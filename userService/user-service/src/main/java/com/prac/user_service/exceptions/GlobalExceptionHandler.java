package com.prac.user_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prac.user_service.payload.ApiResponse;

public class GlobalExceptionHandler {
   
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
       String message = ex.getMessage();
         return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build(), HttpStatus.NOT_FOUND);
    }

}
