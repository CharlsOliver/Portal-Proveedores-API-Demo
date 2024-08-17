package com.demoportalrecepcion.api.cuentacontable.Repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoportalrecepcion.api.cuentacontable.model.CuentaContable;

@Repository
public class CuentaContableRepositoryImpl implements CuentaContableRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String cuenta_contable_select_query = " SELECT * FROM cuenta_contable ";

	public CuentaContableRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<CuentaContable> getCuentasContables() {
		return this.namedParameterJdbcTemplate.query(cuenta_contable_select_query, new CuentaContableRM());
	}

}