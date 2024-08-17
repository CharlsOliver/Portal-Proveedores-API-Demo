package com.demoportalrecepcion.api.entrada_mercancia.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoportalrecepcion.api.entrada_mercancia.model.EntradaMercancia;

@Repository
public class EntradaMercanciaRepositoryImpl implements EntradaMercanciaRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String entradas_mercancia_select_query = " SELECT * FROM entrada_mercancia ";
	

	public EntradaMercanciaRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	

	@Override
	public List<EntradaMercancia> getEntradasMercancia(String orden_compra) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		StringBuilder query = new StringBuilder(entradas_mercancia_select_query);
		
		query.append(" WHERE ");
		query.append(" orden_compra = :orden_compra ");
		params.addValue("orden_compra", orden_compra);
		return this.namedParameterJdbcTemplate.query(query.toString(), params, new EntradaMercanciaRM());
	}

}
