package com.demoportalrecepcion.api.indicadorimpuesto.model;

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
public class IndicadorImpuesto {
	
	private int id_indicador_impuesto;
	private String indicador_impuesto;
	private String descripcion;

}
