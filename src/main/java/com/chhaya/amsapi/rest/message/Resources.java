package com.chhaya.amsapi.rest.message;

public enum Resources {

    USER("User"),
    USERS("Users"),
    PRODUCT("Product"),
    PRODUCTS("Products");

    private String name;

    Resources(String name) {
        this.name = name;
    }

    public String value() {
        return name;
    }
    
}