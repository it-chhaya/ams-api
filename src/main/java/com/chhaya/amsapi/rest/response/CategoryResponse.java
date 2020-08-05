package com.chhaya.amsapi.rest.response;

import java.io.Serializable;

public class CategoryResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2041791416205455126L;
    private String name;

    public CategoryResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "name='" + name + '\'' +
                '}';
    }

}
