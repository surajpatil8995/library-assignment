package com.management.library.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
public class ExceptionConfig {

    public record ErrorResponse(int errorCode, String errorMsg){}

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ErrorResponse> handleException(Exception e) {
//    var res = new ErrorResponse(400, e.getMessage());
//        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
//    }
}


