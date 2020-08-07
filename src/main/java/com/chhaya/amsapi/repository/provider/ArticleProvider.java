package com.chhaya.amsapi.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String saveSql() {
        return new SQL() {{
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
        return new SQL() {{
            SELECT("*");
            FROM("articles");
            WHERE("status = true");
            ORDER_BY("id DESC");
        }}.toString();
    }

    public String findOneByArticleIdSql() {
        return new SQL() {{
            SELECT("*");
            FROM("categories c");
            INNER_JOIN("articles a ON a.category_id = c.id");
            WHERE("a.article_id = #{articleId}", "a.status = true", "c.status = true");
        }}.toString();
    }

    public String selectRecentArticlesSql() {
        return new SQL() {{
            SELECT("*");
            FROM("articles");
            WHERE("status = true");
            ORDER_BY("id DESC", "published_date DESC");
            LIMIT(3);
        }}.toString();
    }

    public String selectPopularArticlesSql() {
        return new SQL() {{
            SELECT("*");
            FROM("articles");
            WHERE("status = true", "category_id IN (3,5)");
            ORDER_BY("id DESC");
            LIMIT(8);
        }}.toString();
    }

}