package com.novatec.tarjetas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    public class Transaccion {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long transaccionId;

    private String tipo;
    private String estado;
        private Timestamp  fechaTran;
        private BigDecimal valor;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "tarjetaId")
        private Tarjeta tarjeta;

    }
