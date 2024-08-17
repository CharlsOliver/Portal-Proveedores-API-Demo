package com.demoportalrecepcion.api.indicadorimpuesto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoportalrecepcion.api.indicadorimpuesto.model.IndicadorImpuesto;
import com.demoportalrecepcion.api.indicadorimpuesto.repository.IndicadorImpuestoRepository;

@Service
public class IndicadorImpuestoServiceImpl implements IndicadorImpuestoService {
	
	private IndicadorImpuestoRepository indicadorImpuestoRepository;

	public IndicadorImpuestoServiceImpl(IndicadorImpuestoRepository indicadorImpuestoRepository) {
		super();
		this.indicadorImpuestoRepository = indicadorImpuestoRepository;
	}

	@Override
	public List<IndicadorImpuesto> getIndicadoresImpuesto() {
		return this.indicadorImpuestoRepository.getIndicadoresImpuesto();
	}

}
