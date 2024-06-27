package com.novatec.tarjetas.entity;
	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Data;
	import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.*;
	@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public class Tarjeta {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(name = "NUMERO")
	    private Long numero;

	    @Column(name = "NOMBRE_TITULAR")
	    private String nombreTitular;

	    @Column(name = "FECHA_VENCE")
	    private Date fechaVence;

	    @Column(name = "ESTADO_ACTIVACION")
	    private String estadoActivacion;

	    @Column(name = "ESTADO_BLOQUEO")
	    private String estadoBloqueo;

	    @Column(name = "SALDO")
	    private BigDecimal saldo;

		@OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Transaccion> transacciones = new ArrayList<Transaccion>();
	}



