package com.demoportalrecepcion.api.entrada_mercancia.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.entrada_mercancia.model.EntradaMercancia;

public class EntradaMercanciaRM implements RowMapper<EntradaMercancia>{

	@Override
	public EntradaMercancia mapRow(ResultSet rs, int rowNum) throws SQLException {
		EntradaMercancia entrada_mercancia = EntradaMercancia.builder()
				.id_entrada_mercancia(rs.getInt("id_entrada_mercancia"))
				.orden_compra(rs.getString("orden_compra"))
				.um_text(rs.getString("um_text"))
				.ejercicio(rs.getString("ejercicio"))
				.precio_unitario(rs.getBigDecimal("precio_unitario"))
				.clase_movimiento(rs.getString("clase_movimiento"))
				.fecha_emision(rs.getString("fecha_emision"))
				.posicion(rs.getString("posicion"))
				.indicador_impuestos(rs.getString("indicador_impuestos"))
				.clave_material(rs.getString("clave_material"))
				.material(rs.getString("material"))
				.cantidad(rs.getBigDecimal("cantidad"))
				.unidad_medida(rs.getString("unidad_medida"))
				.importe_im(rs.getBigDecimal("importe_im"))
				.entrada_mercancia(rs.getString("entrada_mercancia"))
				.posicion_documento_ref(rs.getString("posicion_documento_ref"))
				.moneda(rs.getString("moneda"))
				.build();
		return entrada_mercancia;
	}

}
