package com.chhaya.amsapi.repository.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8394973619493067368L;
    private int id;
    private String name;
    private boolean status;

    public CategoryDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

}
