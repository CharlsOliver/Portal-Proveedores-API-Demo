package com.demoportalrecepcion.api.cuentacontable.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demoportalrecepcion.api.cuentacontable.model.CuentaContable;

public class CuentaContableRM implements RowMapper<CuentaContable> {

	@Override
	public CuentaContable mapRow(ResultSet rs, int rowNum) throws SQLException {
		CuentaContable cuenta_contable = CuentaContable.builder()
				.id_cuenta_contable(rs.getInt("id_cuenta_contable"))
				.cuenta_contable(rs.getString("cuenta_contable"))
				.descripcion(rs.getString("descripcion"))
				.build();
		return cuenta_contable;
	}

}
