package com.chhaya.amsapi.rest.request;

import java.io.Serializable;
import java.sql.Date;

import com.chhaya.amsapi.repository.dto.CategoryDto;

public class ArticleRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String title;
    private String description;
    private String thumbnail;
    private String author;
    private Date publishedDate;
    private CategoryDto category;


    public ArticleRequest() {
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

    public CategoryDto getCategory() {
        return this.category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", author='" + getAuthor() + "'" +
            ", publishedDate='" + getPublishedDate() + "'" +
            ", category='" + getCategory() + "'" +
            "}";
    }
    
}