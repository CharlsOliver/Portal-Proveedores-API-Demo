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
public class Factura {
	
	private int id_factura;
	private String factura;
	private String uuid;
	private String folio;
	private String serie;
	private String sociedad;
	private String fecha_carga;
	private String fecha_emision;
	private BigDecimal impuestos;
	private BigDecimal importe;
	private String status;
	private String proveedor;
	private String nombre_proveedor;
	private String rfc_emisor;
	private String moneda;
	private BigDecimal subtotal;
	private BigDecimal retenciones;
	private BigDecimal descuentos;
	private BigDecimal total;
	private String rfc_receptor;
	
}
