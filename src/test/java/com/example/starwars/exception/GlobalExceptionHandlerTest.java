package com.example.starwars.exception;

import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerDirectTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandlePriceNotFoundDirectly() {
        ResponseEntity<Void> response = handler.handlePriceNotFound(new PriceNotFoundExceptionDomain("Price not found"));
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode()); // Forzar a Sonar a rastrear esta línea
    }
}
