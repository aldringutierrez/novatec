package com.novatec.tarjetas.exception;

import lombok.Data;

@Data
public class TarjetaServiceCustomException extends RuntimeException{

    private String errorCode;

    public TarjetaServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
