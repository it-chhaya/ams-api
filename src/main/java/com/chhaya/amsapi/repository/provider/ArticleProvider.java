package com.chhaya.amsapi.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String saveSql() {
        return new SQL(){{
            INSERT_INTO("articles");
            VALUES("article_id", "#{articleId}");
            VALUES("title", "#{title}");
            VALUES("description", "#{description}");
            VALUES("thumbnail", "#{thumbnail}");
            VALUES("author", "#{author}");
            VALUES("category_id", "#{category.id}");
        }}.toString();
    }

    public String selectSql() {
        return new SQL(){{
            SELECT("*");
            FROM("articles");
            WHERE("status = true");
        }}.toString();
    }

}