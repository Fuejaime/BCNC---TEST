package com.example.starwars.exception;

import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandlePriceNotFound() {
        // Arrange
        PriceNotFoundExceptionDomain exception = new PriceNotFoundExceptionDomain("Price not found");

        // Act
        ResponseEntity<Void> response = globalExceptionHandler.handlePriceNotFound(exception);

        // Assert
        assertEquals(ResponseEntity.notFound().build(), response);
    }
}
