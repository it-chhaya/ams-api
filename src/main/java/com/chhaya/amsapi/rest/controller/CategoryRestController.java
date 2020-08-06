package com.chhaya.amsapi.rest.controller;

import com.chhaya.amsapi.constant.ApiConstants;
import com.chhaya.amsapi.repository.dto.CategoryDto;
import com.chhaya.amsapi.rest.message.FailureMessage;
import com.chhaya.amsapi.rest.message.SuccessMessage;
import com.chhaya.amsapi.rest.request.CategoryRequest;
import com.chhaya.amsapi.rest.response.ApiResponse;
import com.chhaya.amsapi.rest.response.CategoryResponse;
import com.chhaya.amsapi.service.implement.CategoryServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_VERSION)
public class CategoryRestController {

    private CategoryServiceImp categoryServiceImp;

    private ModelMapper mapper;

    @Autowired
    public CategoryRestController(CategoryServiceImp categoryServiceImp) {
        this.categoryServiceImp = categoryServiceImp;
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(ApiConstants.RELATED_CATEGORIES_URL)
    ResponseEntity<ApiResponse<List<CategoryResponse>>> getRelatedCategories() {

        ApiResponse<List<CategoryResponse>> response = new ApiResponse<>();

        List<CategoryDto> relatedCategoryDtoList = categoryServiceImp.findRelatedCategories();

        List<CategoryResponse> relatedCategoryResponseList = new ArrayList<>();

        for (CategoryDto relatedCategoryDto : relatedCategoryDtoList) {
            relatedCategoryResponseList.add(mapper.map(relatedCategoryDto, CategoryResponse.class));
        }

        if (relatedCategoryDtoList.size() == 0) {

            response.setResponse(SuccessMessage.HAS_NO_RECORD.value(),
                    false,
                    HttpStatus.NO_CONTENT.value(),
                    null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

        } else {

            response.setResponse(SuccessMessage.FOUND_ALL.value(),
                    true,
                    HttpStatus.OK.value(),
                    relatedCategoryResponseList);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }

    }

    @Operation(summary = "Find all categories",
        description = "Find all categories from database")
    @GetMapping(ApiConstants.CATEGORIES_URL)
    ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategoriesAction() {

        ApiResponse<List<CategoryResponse>> response = new ApiResponse<>();

        ModelMapper mapper = new ModelMapper();

        List<CategoryDto> categoryDtoList = categoryServiceImp.findAll();

        List<CategoryResponse> categoryResponseList = new ArrayList<>();

        for (CategoryDto categoryDto : categoryDtoList) {
            categoryResponseList.add(mapper.map(categoryDto, CategoryResponse.class));
        }

        response.setMessage(SuccessMessage.FOUND_ALL.value());
        response.setCode(HttpStatus.OK.value());
        response.setData(categoryResponseList);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);

    }

    @GetMapping(ApiConstants.CATEGORIES_URL + "/{id}")
    ResponseEntity<ApiResponse<CategoryResponse>> getCategoryAction(@PathVariable int id) {

        ApiResponse<CategoryResponse> response = new ApiResponse<>();

        ModelMapper mapper = new ModelMapper();

        CategoryDto categoryDto = categoryServiceImp.findOne(id);

        if (categoryDto != null) {
            CategoryResponse categoryResponse = mapper.map(categoryDto, CategoryResponse.class);
            response.setMessage(SuccessMessage.FOUND_ONE.value());
            response.setSuccess(true);
            response.setCode(HttpStatus.OK.value());
            response.setData(categoryResponse);
        } else {
            response.setMessage(FailureMessage.NOT_FOUND_BY_ID.value());
            response.setSuccess(false);
            response.setCode(HttpStatus.NO_CONTENT.value());
            response.setData(null);
        }

        return ResponseEntity.ok(response);

    }

    @PostMapping(ApiConstants.CATEGORIES_URL)
    ResponseEntity<ApiResponse<CategoryResponse>> addCategoryAction(@RequestBody CategoryRequest categoryRequest) {

        ApiResponse<CategoryResponse> response = new ApiResponse<>();

        ModelMapper mapper = new ModelMapper();

        CategoryDto categoryDto = mapper.map(categoryRequest, CategoryDto.class);

        CategoryDto savedCategory = categoryServiceImp.save(categoryDto);

        CategoryResponse categoryResponse = mapper.map(savedCategory, CategoryResponse.class);

        response.setMessage(SuccessMessage.IS_SAVED.value());
        response.setSuccess(true);
        response.setCode(HttpStatus.CREATED.value());
        response.setData(categoryResponse);

        return ResponseEntity.ok(response);
    }

    @PutMapping(ApiConstants.CATEGORIES_URL + "/{id}")
    ResponseEntity<ApiResponse<CategoryResponse>> editCategoryAction(@PathVariable int id,
            @RequestBody CategoryRequest categoryRequest) {

        ApiResponse<CategoryResponse> response = new ApiResponse<>();

        CategoryDto categoryDto = mapper.map(categoryRequest, CategoryDto.class);

        categoryDto.setId(id);

        CategoryDto updatedCategory = categoryServiceImp.update(categoryDto);

        CategoryResponse categoryResponse = mapper.map(updatedCategory, CategoryResponse.class);

        response.setResponse(SuccessMessage.IS_UPDATED.value(),
            true,
            HttpStatus.OK.value(),
            categoryResponse);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(ApiConstants.CATEGORIES_URL)
    String deleteCategoryAction() {
        return "Delete category";
    }
}
