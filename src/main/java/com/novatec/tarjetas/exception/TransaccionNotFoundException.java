package com.novatec.tarjetas.exception;

public class TransaccionNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 2;
    public TransaccionNotFoundException(String message) {
        super(message);
    }
}
