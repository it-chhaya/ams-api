package com.chhaya.amsapi.rest.response;

import java.io.Serializable;
import java.sql.Date;

import com.chhaya.amsapi.repository.dto.CategoryDto;

public class ArticleResponse implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 2077821222786975936L;
    private String articleId;
    private String title;
    private String description;
    private String thumbnail;
    private String author;
    private Date publishedDate;
    private CategoryResponse category;


    public ArticleResponse() {
    }


    public String getArticleId() {
        return this.articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return this.publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public CategoryResponse getCategory() {
        return this.category;
    }

    public void setCategory(CategoryResponse category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "{" +
            " articleId='" + getArticleId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", author='" + getAuthor() + "'" +
            ", publishedDate='" + getPublishedDate() + "'" +
            ", category='" + getCategory() + "'" +
            "}";
    }

}