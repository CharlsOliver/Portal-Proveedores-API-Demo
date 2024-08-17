package com.demoportalrecepcion.api.cuentacontable.model;

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
public class CuentaContable {
	
	private int id_cuenta_contable;
	private String cuenta_contable;
	private String descripcion;
	
}
