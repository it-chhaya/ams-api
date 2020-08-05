package com.chhaya.amsapi.rest.response;

import java.io.Serializable;
import java.sql.Timestamp;

public class ErrorResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5108588909213934014L;
    private String message;
    private int code;
    private String error;
    private Timestamp time;

    public ErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", error='" + error + '\'' +
                ", time=" + time +
                '}';
    }

}
