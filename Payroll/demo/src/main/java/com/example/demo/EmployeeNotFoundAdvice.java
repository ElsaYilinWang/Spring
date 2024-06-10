package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// @RestControllerAdvice signals that this advice is rendered straight into the response body.
class EmployeeNotFoundAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    // @ExceptionHandler configures the advice to only respond when an EmployeeNotFoundException is thrown.

    @ResponseStatus(HttpStatus.NOT_FOUND)
    // @ResponseStatus says to issue an HttpStatus.NOT_FOUND — that is, an HTTP 404 error.
    String employeeNotFoundHandler(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}
