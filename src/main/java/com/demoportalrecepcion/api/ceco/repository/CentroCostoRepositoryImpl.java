package com.demoportalrecepcion.api.ceco.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoportalrecepcion.api.ceco.model.CentroCosto;

@Repository
public class CentroCostoRepositoryImpl implements CentroCostoRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String centro_costo_select_query = " SELECT * FROM centro_costo ";

	public CentroCostoRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<CentroCosto> getCentrosCosto() {
		return this.namedParameterJdbcTemplate.query(centro_costo_select_query, new CentroCostoRM());
	}

}
