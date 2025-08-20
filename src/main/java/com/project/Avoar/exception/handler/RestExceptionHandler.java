package com.project.Avoar.exception.handler;

import com.project.Avoar.exception.InvalidValueException;
import com.project.Avoar.exception.NotFoundFlightException;
import com.project.Avoar.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<String> invalidValueException(InvalidValueException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<String> notFoundUserException(NotFoundUserException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }

    @ExceptionHandler(NotFoundFlightException.class)
    public ResponseEntity<String> notFoundFlightException(NotFoundFlightException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
