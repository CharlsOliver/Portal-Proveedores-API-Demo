package com.demoportalrecepcion.api.ceco.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.ceco.model.CentroCosto;

public class CentroCostoRM implements RowMapper<CentroCosto> {

	@Override
	public CentroCosto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CentroCosto ceco = CentroCosto.builder()
				.id_centro_costo(rs.getInt("id_centro_costo"))
				.centro_costo(rs.getString("centro_costo"))
				.descripcion(rs.getString("descripcion"))
				.build();
		return ceco;
	}
	
}
