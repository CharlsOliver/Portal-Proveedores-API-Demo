package com.demoportalrecepcion.api.contabilizacion.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.contabilizacion.model.ContabilizacionFinanciera;


public class ContabilizacionFinancieraRM implements RowMapper<ContabilizacionFinanciera>{

	@Override
	public ContabilizacionFinanciera mapRow(ResultSet rs, int rowNum) throws SQLException {
		ContabilizacionFinanciera contabilziacion = ContabilizacionFinanciera.builder()
				.id_contabilizacion_financiera(rs.getInt("id_contabilizacion_financiera"))
				.tipo_documento(rs.getString("tipo_documento"))
				.id_proveedor(rs.getString("id_proveedor"))
				.uuid(rs.getString("uuid"))
				.usuario_carga(rs.getString("usuario_carga"))
				.rfc_emisor(rs.getString("rfc_emisor"))
				.regimen_fiscal(rs.getString("regimen_fiscal"))
				.forma_pago(rs.getString("forma_pago"))
				.metodo_pago(rs.getString("metodo_pago"))
				.tipo_comprobante(rs.getString("tipo_comprobante"))
				.subtotal(rs.getBigDecimal("subtotal"))
				.total(rs.getBigDecimal("total"))
				.moneda(rs.getString("moneda"))
				.impuestos_trasladados(rs.getBigDecimal("impuestos_trasladados"))
				.impuestos_retenidos(rs.getBigDecimal("impuestos_retenidos"))
				.fecha_timbrado(rs.getString("fecha_timbrado"))
				.sociedad(rs.getString("sociedad"))
				.fecha_documento(rs.getString("fecha_documento"))
				.fecha_contabilizacion(rs.getString("fecha_contabilizacion"))
				.ejercicio(rs.getString("ejercicio"))
				.periodo_fiscal(rs.getString("periodo_fiscal"))
				.referencia(rs.getString("referencia"))
				.texto_cabecera(rs.getString("texto_cabecera"))
				.posiciones(rs.getString("posiciones"))
				.cuentas_contables(rs.getString("cuentas_contables"))
				.posiciones_impuestos(rs.getString("posiciones_impuestos"))
				.posiciones_montos(rs.getString("posiciones_montos"))
				.build();
		
		return contabilziacion;
	}
	

}
