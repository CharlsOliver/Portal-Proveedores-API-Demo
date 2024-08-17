package com.demoportalrecepcion.api.cuentacontable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoportalrecepcion.api.cuentacontable.Repository.CuentaContableRepository;
import com.demoportalrecepcion.api.cuentacontable.model.CuentaContable;

@Service
public class CuentaContableServiceImpl implements CuentaContableService {
	
	private CuentaContableRepository cuentaContableRepository;

	public CuentaContableServiceImpl(CuentaContableRepository cuentaContableRepository) {
		super();
		this.cuentaContableRepository = cuentaContableRepository;
	}



	@Override
	public List<CuentaContable> getCentrosCosto() {
		return this.cuentaContableRepository.getCuentasContables();
	}

}
