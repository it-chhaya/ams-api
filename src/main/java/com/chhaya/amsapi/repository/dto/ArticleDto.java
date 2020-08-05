package com.chhaya.amsapi.repository.dto;

import java.io.Serializable;
import java.sql.Date;

public class ArticleDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2682418973018491184L;
    private int id;
    private String articleId;
    private String title;
    private String description;
    private String thumbnail;
    private String author;
    private Date publishedDate;
    private CategoryDto category;
    private boolean status;


    public ArticleDto() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CategoryDto getCategory() {
        return this.category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", articleId='" + getArticleId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", author='" + getAuthor() + "'" +
            ", publishedDate='" + getPublishedDate() + "'" +
            ", category='" + getCategory() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }

}
