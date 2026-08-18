package com.sanjay.jobtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JobApplicationNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleJobApplicationNotFoundException(
            JobApplicationNotFoundException exception
    ) {
        Map<String, String> error = new HashMap<>();
        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}