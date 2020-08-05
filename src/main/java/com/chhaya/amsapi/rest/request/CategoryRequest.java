package com.chhaya.amsapi.rest.request;

import javax.validation.constraints.NotEmpty;

public class CategoryRequest {

    @NotEmpty
    private String name;

    public CategoryRequest() {
    }

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "name='" + name + '\'' +
                '}';
    }

}
