package com.global.emsbackend.advice;

import com.global.emsbackend.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgs(MethodArgumentNotValidException ex) {

        Map<String, String> errorsMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {

            errorsMap.put(error.getField(), error.getDefaultMessage());

        });

        return errorsMap;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, String> handleResourceNotFoundException(

        ResourceNotFoundException ex

    ) {

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("errorMessage: ", ex.getMessage());

        return errorMap;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String, String> handleSQLException(

        SQLIntegrityConstraintViolationException ex

    ) {

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("sqlError", ex.getMessage());

        return errorMap;

    }

}
