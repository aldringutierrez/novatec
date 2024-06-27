package com.novatec.tarjetas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class TransactionResponse {
        private long transaccionId;
        private String tipo;
        private String estado;
        private Date fechaTran;
        private BigDecimal valor;
        private long tarjetaId;
    }

