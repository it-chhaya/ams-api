package com.chhaya.amsapi.rest.message;

public enum FailureMessage {

    NOT_FOUND_BY_ID("The record with this ID not exist"),
    CATEGORY_NAME_CANNOT_BE_EMPTY("Category name cannot be empty");

    private String message;

    FailureMessage(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }

}
