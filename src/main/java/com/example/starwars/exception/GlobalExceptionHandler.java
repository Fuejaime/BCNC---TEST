package com.example.starwars.exception;

import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PriceNotFoundExceptionDomain.class)
    public ResponseEntity<Void> handlePriceNotFound(PriceNotFoundExceptionDomain ex) {
        return ResponseEntity.notFound().build();
    }
}
