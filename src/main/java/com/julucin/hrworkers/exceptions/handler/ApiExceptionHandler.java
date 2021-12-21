package com.julucin.hrworkers.exceptions.handler;

import com.julucin.hrworkers.exceptions.InstanceDoesNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = InstanceDoesNotExistException.class)
    public ResponseEntity<ExceptionHandlerResponse> handle(InstanceDoesNotExistException exception){
        return ResponseEntity.status(404).body(ExceptionHandlerResponse.of(exception));
    }

}
