package com.demoportalrecepcion.api.factura.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoportalrecepcion.api.factura.model.Factura;
import com.demoportalrecepcion.api.factura.model.Posicion;

@Repository
public class FacturaRepositoryImpl implements FacturaRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String factura_select_query = " SELECT * FROM factura ";
	
	private final String posiciones_select_query = " SELECT * FROM posicion_factura ";
	
	

	public FacturaRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}



	@Override
	public List<Factura> getFacturas() {
		return this.namedParameterJdbcTemplate.query(factura_select_query, new FacturaRM());
	}



	@Override
	public List<Posicion> getPosiciones(int id_factura) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		StringBuilder query = new StringBuilder(posiciones_select_query);
		
		query.append(" WHERE ");
		query.append(" id_factura = :id_factura ");
		params.addValue("id_factura", id_factura);
		return this.namedParameterJdbcTemplate.query(query.toString(), params, new PosicionRM());
	}
	
}
