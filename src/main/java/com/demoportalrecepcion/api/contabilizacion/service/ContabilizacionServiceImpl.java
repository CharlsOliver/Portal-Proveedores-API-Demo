package com.demoportalrecepcion.api.contabilizacion.service;

import org.springframework.stereotype.Service;

import com.demoportalrecepcion.api.contabilizacion.repository.ContabilizacionRepository;

@Service
public class ContabilizacionServiceImpl implements ContabilizacionService {
	
	ContabilizacionRepository contabilizacionRepository;
	
	

	public ContabilizacionServiceImpl(ContabilizacionRepository contabilizacionRepository) {
		super();
		this.contabilizacionRepository = contabilizacionRepository;
	}


	@Override
	public String contabilizar(String oc) {
		return contabilizacionRepository.contabilizar(oc);
	}


	@Override
	public String contabilizar(int escenario) {
		return contabilizacionRepository.contabilizar(escenario);
	}

}
