package com.novatec.tarjetas.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

    @Data
    public class TransaccionRequest {
        private long transaccionId;
        private String tipo;
        private String estado;
        private Date fechaTran;
        private BigDecimal valor;
        private long tarjetaId;
    }

