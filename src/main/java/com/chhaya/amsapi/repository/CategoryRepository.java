package com.chhaya.amsapi.repository;

import com.chhaya.amsapi.repository.dto.CategoryDto;
import com.chhaya.amsapi.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    @Select("SELECT * FROM categories WHERE status = true")
    List<CategoryDto> findAll();

    @SelectProvider(type = CategoryProvider.class, method = "findOneSql")
    CategoryDto findOne(int id);

    @InsertProvider(type = CategoryProvider.class, method = "saveSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(CategoryDto categoryDto);

    @UpdateProvider(type = CategoryProvider.class, method = "updateSql")
    void update(CategoryDto categoryDto);

    @SelectProvider(type = CategoryProvider.class, method = "findRelatedCategoriesSql")
    List<CategoryDto> findRelatedCategories();

}
