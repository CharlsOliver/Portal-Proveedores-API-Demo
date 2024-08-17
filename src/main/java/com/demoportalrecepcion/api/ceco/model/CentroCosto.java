package com.demoportalrecepcion.api.ceco.model;

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
public class CentroCosto {
	
	private int id_centro_costo;
	private String centro_costo;
	private String descripcion;

}
