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
public class ContabilizacionFinanciera {
	
	private int id_contabilizacion_financiera;
	private String tipo_documento;
	private String id_proveedor;
	private String uuid;
	private String usuario_carga;
	private String rfc_emisor;
	private String regimen_fiscal;
	private String forma_pago;
	private String metodo_pago;
	private String tipo_comprobante;
	private BigDecimal subtotal;
	private BigDecimal total;
	private String moneda;
	private BigDecimal impuestos_trasladados;
	private BigDecimal impuestos_retenidos;
	private String fecha_timbrado;
	private String sociedad;
	private String fecha_documento;
	private String fecha_contabilizacion;
	private String ejercicio;
	private String periodo_fiscal;
	private String referencia;
	private String texto_cabecera;
	private String posiciones;
	private String cuentas_contables;
	private String posiciones_impuestos;
	private String posiciones_montos;

}
