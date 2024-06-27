package com.novatec.tarjetas.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class TarjetaRequest {
		private long tarjetaId;
    private String name;
    private long numero;
    private Date fechaVence;
    private String 	estado_activacion;
    private String 	estado_bloqueo;
    private BigDecimal saldo;
    private String cardId;
    private BigDecimal price;
    }
