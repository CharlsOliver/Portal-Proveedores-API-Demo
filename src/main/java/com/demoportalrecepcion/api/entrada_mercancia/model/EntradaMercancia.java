package com.demoportalrecepcion.api.entrada_mercancia.model;

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
public class EntradaMercancia {
	
	private int id_entrada_mercancia;
	private String orden_compra;
	private String um_text;
	private String ejercicio;
	private BigDecimal precio_unitario;
	private String clase_movimiento;
	private String fecha_emision;
	private String posicion;
	private String indicador_impuestos;
	private String clave_material;
	private String material;
	private BigDecimal cantidad;
	private String unidad_medida;
	private BigDecimal importe_im;
	private String entrada_mercancia;
	private String posicion_documento_ref;
	private String moneda;

}
