package com.chhaya.amsapi.exception;

import com.chhaya.amsapi.rest.response.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@RestControllerAdvice
public class AppException {

    @ExceptionHandler(value = ResponseStatusException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<ErrorResponse> handle(ResponseStatusException e) {

        ErrorResponse response = new ErrorResponse();

        response.setMessage("The operation failed, please check error");
        response.setCode(e.getStatus().value());
        response.setError(e.getReason());
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);

    }

}
