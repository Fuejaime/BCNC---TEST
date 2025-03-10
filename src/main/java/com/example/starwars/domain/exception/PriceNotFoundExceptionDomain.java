package com.example.starwars.domain.exception;

public class PriceNotFoundExceptionDomain extends RuntimeException {
    public PriceNotFoundExceptionDomain(String message) {
        super(message);
    }
}
