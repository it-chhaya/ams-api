package com.chhaya.amsapi.repository;

import com.chhaya.amsapi.repository.dto.ArticleDto;
import com.chhaya.amsapi.repository.dto.CategoryDto;
import com.chhaya.amsapi.repository.provider.ArticleProvider;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {

    @InsertProvider(type = ArticleProvider.class, method = "saveSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(ArticleDto articleDto);

    @UpdateProvider(type = ArticleProvider.class, method = "updateSql")
    void update(ArticleDto articleDto);

    @SelectProvider(type = ArticleProvider.class, method = "selectSql")
    @Results(id = "articleResults", value = {
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "published_date", property = "publishedDate"),
            @Result(column = "article_id", property = "category", one = @One(select = "findOneByArticleId"))
    })
    List<ArticleDto> select();

    @SelectProvider(type = ArticleProvider.class, method = "findOneByArticleIdSql")
    CategoryDto findOneByArticleId(String articleId);

    @SelectProvider(type = ArticleProvider.class, method = "selectRecentArticlesSql")
    @ResultMap(value = "articleResults")
    List<ArticleDto> selectRecentArticles();

    @SelectProvider(type = ArticleProvider.class, method = "selectPopularArticlesSql")
    @ResultMap(value = "articleResults")
    List<ArticleDto> selectPopularArticles();

    @Select("SELECT * FROM articles WHERE article_id = #{articleId}")
    @ResultMap(value = "articleResults")
    ArticleDto selectByArticleId(String articleId);

    @Delete("DELETE FROM articles WHERE article_id = #{articleId}")
    void delete(String articleId);

}