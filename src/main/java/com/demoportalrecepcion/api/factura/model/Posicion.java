package com.demoportalrecepcion.api.factura.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Posicion {
	
	private int id_posicion_factura;
	private String concepto;
	private BigDecimal cantidad;
	private String unidad;
	private BigDecimal precio_unitario;
	private BigDecimal importe;
	private int id_factura;
	
}
