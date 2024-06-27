package com.novatec.tarjetas.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaResponse {
    private long tarjetaId;
    private long numero;
    private String nombreTitular;
  	private Date fechaVence;
  	private String estadoActivacion;
  	private String estadoBloqueo;
  	private BigDecimal saldo;
    
    
}
