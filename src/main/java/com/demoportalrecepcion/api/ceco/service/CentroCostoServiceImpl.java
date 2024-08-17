package com.demoportalrecepcion.api.ceco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoportalrecepcion.api.ceco.model.CentroCosto;
import com.demoportalrecepcion.api.ceco.repository.CentroCostoRepository;

@Service
public class CentroCostoServiceImpl implements CentroCostoService {
	
	private CentroCostoRepository cecoRepository;

	public CentroCostoServiceImpl(CentroCostoRepository cecoRepository) {
		super();
		this.cecoRepository = cecoRepository;
	}

	@Override
	public List<CentroCosto> getCentrosCosto() {
		return this.cecoRepository.getCentrosCosto();
	}

}
