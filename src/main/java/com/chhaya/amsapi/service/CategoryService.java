package com.chhaya.amsapi.service;

import com.chhaya.amsapi.repository.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    List<CategoryDto> findRelatedCategories();

    CategoryDto findOne(int id);

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

}
