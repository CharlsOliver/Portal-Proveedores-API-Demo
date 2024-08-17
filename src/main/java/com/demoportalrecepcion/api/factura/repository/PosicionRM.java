package com.demoportalrecepcion.api.factura.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.factura.model.Posicion;

public class PosicionRM implements RowMapper<Posicion>{
	
	@Override
	public Posicion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Posicion posicion = Posicion.builder()
				.id_posicion_factura(rs.getInt("id_posicion_factura"))
				.concepto(rs.getString("concepto"))
				.cantidad(rs.getBigDecimal("cantidad"))
				.unidad(rs.getString("unidad"))
				.precio_unitario(rs.getBigDecimal("precio_unitario"))
				.importe(rs.getBigDecimal("importe"))
				.id_factura(rs.getInt("id_factura"))
				.build();
		return posicion;
	}

}
