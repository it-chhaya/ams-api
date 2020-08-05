package com.chhaya.amsapi.rest.message;

public enum SuccessMessage {

    FOUND_ALL("All records have found successfully"),
    FOUND_ONE("A record has found successfully"),
    IS_SAVED("Record has been saved successfully"),
    IS_UPDATED("Record has been updated successfully"),
    UPLOADED_IMAGE("Image has been uploaded successfully");

    private String message;

    SuccessMessage(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }

}
