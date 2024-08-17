package com.demoportalrecepcion.api.indicadorimpuesto.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoportalrecepcion.api.indicadorimpuesto.model.IndicadorImpuesto;

@Repository
public class IndicadorImpuestoRepositoryImpl implements IndicadorImpuestoRepository {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String indicador_impuesto_select_query = " SELECT * FROM indicador_impuesto ";

	public IndicadorImpuestoRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<IndicadorImpuesto> getIndicadoresImpuesto() {
		return this.namedParameterJdbcTemplate.query(indicador_impuesto_select_query, new IndicadorImpuestoRM());
	}

}
