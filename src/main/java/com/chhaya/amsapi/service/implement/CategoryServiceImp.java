package com.chhaya.amsapi.service.implement;

import com.chhaya.amsapi.repository.CategoryRepository;
import com.chhaya.amsapi.repository.dto.CategoryDto;
import com.chhaya.amsapi.rest.message.FailureMessage;
import com.chhaya.amsapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDto findOne(int id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        // if (categoryDto.getName().isEmpty())
        //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        //             FailureMessage.CATEGORY_NAME_CANNOT_BE_EMPTY.value());

        try {

            categoryRepository.save(categoryDto);

            return categoryDto;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }

    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {

        CategoryDto category = categoryRepository.findOne(categoryDto.getId());

        if (category == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, FailureMessage.NOT_FOUND_BY_ID.value());

        if (categoryDto.getName().isEmpty()) 
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    FailureMessage.CATEGORY_NAME_CANNOT_BE_EMPTY.value());

        try {
            categoryRepository.update(categoryDto);
            return categoryDto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }

    }

}
