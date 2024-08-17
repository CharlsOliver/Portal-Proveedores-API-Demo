package com.demoportalrecepcion.api.indicadorimpuesto.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.indicadorimpuesto.model.IndicadorImpuesto;

public class IndicadorImpuestoRM implements RowMapper<IndicadorImpuesto> {

	@Override
	public IndicadorImpuesto mapRow(ResultSet rs, int rowNum) throws SQLException {
		IndicadorImpuesto indicador_impuesto = IndicadorImpuesto.builder()
				.id_indicador_impuesto(rs.getInt("id_indicador_impuesto"))
				.indicador_impuesto(rs.getString("indicador_impuesto"))
				.descripcion(rs.getString("descripcion"))
				.build();
		return indicador_impuesto;
	}

}
