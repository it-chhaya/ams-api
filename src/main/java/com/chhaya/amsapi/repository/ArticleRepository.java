package com.chhaya.amsapi.repository;

import com.chhaya.amsapi.repository.dto.ArticleDto;
import com.chhaya.amsapi.repository.provider.ArticleProvider;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository {
    
    @InsertProvider(type = ArticleProvider.class, method = "saveSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(ArticleDto articleDto);
    
}