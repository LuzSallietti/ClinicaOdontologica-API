package com.dh.clinicaOdontologica;

import org.apache.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> todosErrores(Exception exc, WebRequest req){
        logger.error(exc.getMessage());
        return new ResponseEntity<>("Error: " + exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
