package com.chhaya.amsapi.rest.response;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApiResponse<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6659132243601057840L;
    private String message;
    private boolean success;
    private int code;
    private T data;
    private Timestamp time;

    public ApiResponse() {
        time = new Timestamp(System.currentTimeMillis());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                "success='" + success + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", time=" + time +
                '}';
    }

    public void setResponse(String message, boolean success, int code, T data) {
        this.message = message;
        this.success = success;
        this.code = code;
        this.data = data;
    }

}
