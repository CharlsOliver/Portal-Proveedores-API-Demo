package com.demoportalrecepcion.api.contabilizacion.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.contabilizacion.model.Contabilizacion;

public class ContabilizacionRM implements RowMapper<Contabilizacion>{

	@Override
	public Contabilizacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Contabilizacion contabilizacion = Contabilizacion.builder()
				.id_contabilizacion(rs.getInt("id_contabilizacion"))
				.orden_compra(rs.getString("orden_compra"))
				.proveedor(rs.getString("proveedor"))
				.uuid(rs.getString("uuid"))
				.rfc_emisor(rs.getString("rfc_emisor"))
				.regimen_emisor(rs.getString("regimen_emisor"))
				.forma_pago(rs.getString("forma_pago"))
				.metodo_pago(rs.getString("metodo_pago"))
				.tipo_comprobante(rs.getString("tipo_comprobante"))
				.subtotal(rs.getBigDecimal("subtotal"))
				.total(rs.getBigDecimal("total"))
				.moneda(rs.getString("moneda"))
				.impuestos_trasladados(rs.getBigDecimal("impuestos_trasladados"))
				.impuestos_retenidos(rs.getBigDecimal("impuestos_retenidos"))
				.fecha_timbrado(rs.getString("fecha_timbrado"))
				.fecha_documento(rs.getString("fecha_documento"))
				.fecha_contabilizacion(rs.getString("fecha_contabilizacion"))
				.referencia(rs.getString("referencia"))
				.sociedad(rs.getString("sociedad"))
				.texto_cabecera(rs.getString("texto_cabecera"))
				.texto_general(rs.getString("texto_general"))
				.items(rs.getString("items"))
				.build();
		
		return contabilizacion;
	}

}
