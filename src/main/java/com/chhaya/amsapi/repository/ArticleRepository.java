package com.chhaya.amsapi.repository;

import com.chhaya.amsapi.repository.dto.ArticleDto;
import com.chhaya.amsapi.repository.provider.ArticleProvider;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {
    
    @InsertProvider(type = ArticleProvider.class, method = "saveSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(ArticleDto articleDto);

    @SelectProvider(type = ArticleProvider.class, method = "selectSql")
    @Results(id = "articleResults", value = {
            @Result(column = "article_id", property = "articleId"),

    })
    List<ArticleDto> select();
    
}