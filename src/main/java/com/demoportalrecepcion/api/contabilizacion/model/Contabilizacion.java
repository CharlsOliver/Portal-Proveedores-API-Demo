package com.demoportalrecepcion.api.contabilizacion.model;

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
public class Contabilizacion {
	
	private int id_contabilizacion;
	private String orden_compra;
	private String proveedor;
	private String uuid;
	private String rfc_emisor;
	private String regimen_emisor;
	private String forma_pago;
	private String metodo_pago;
	private String tipo_comprobante;
	private BigDecimal subtotal;
	private BigDecimal total;
	private String moneda;
	private BigDecimal impuestos_trasladados;
	private BigDecimal impuestos_retenidos;
	private String fecha_timbrado;
	private String fecha_documento;
	private String fecha_contabilizacion;
	private String referencia;
	private String sociedad;
	private String texto_cabecera;
	private String texto_general;
	private String items;
	private int escenario;
	
}
