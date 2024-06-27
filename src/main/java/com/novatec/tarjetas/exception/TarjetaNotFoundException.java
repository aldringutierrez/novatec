package com.novatec.tarjetas.exception;

public class TarjetaNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public TarjetaNotFoundException(String message) {
        super(message);
    }
}
