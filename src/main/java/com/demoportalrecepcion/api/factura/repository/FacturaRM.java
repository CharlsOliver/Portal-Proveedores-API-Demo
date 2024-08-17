package com.demoportalrecepcion.api.factura.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.factura.model.Factura;

public class FacturaRM implements RowMapper<Factura>{

	@Override
	public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
		Factura factura = Factura.builder()
				.id_factura(rs.getInt("id_factura"))
				.factura(rs.getString("factura"))
				.uuid(rs.getString("uuid"))
				.folio(rs.getString("folio"))
				.serie(rs.getString("serie"))
				.sociedad(rs.getString("sociedad"))
				.fecha_carga(rs.getString("fecha_carga"))
				.fecha_emision(rs.getString("fecha_emision"))
				.impuestos(rs.getBigDecimal("impuestos"))
				.importe(rs.getBigDecimal("importe"))
				.status(rs.getString("status"))
				.proveedor(rs.getString("proveedor"))
				.nombre_proveedor(rs.getString("nombre_proveedor"))
				.rfc_emisor(rs.getString("rfc_emisor"))
				.moneda(rs.getString("moneda"))
				.subtotal(rs.getBigDecimal("subtotal"))
				.retenciones(rs.getBigDecimal("retenciones"))
				.descuentos(rs.getBigDecimal("descuentos"))
				.total(rs.getBigDecimal("total"))
				.rfc_receptor(rs.getString("rfc_receptor"))
				.build();
		return factura;
	}

}
