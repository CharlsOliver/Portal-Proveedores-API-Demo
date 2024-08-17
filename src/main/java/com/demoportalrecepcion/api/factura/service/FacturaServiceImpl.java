package com.demoportalrecepcion.api.factura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoportalrecepcion.api.factura.model.Factura;
import com.demoportalrecepcion.api.factura.model.Posicion;
import com.demoportalrecepcion.api.factura.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	private FacturaRepository facturaRepository;
	
	

	public FacturaServiceImpl(FacturaRepository facturaRepository) {
		super();
		this.facturaRepository = facturaRepository;
	}



	@Override
	public List<Factura> getFacturas() {
		return this.facturaRepository.getFacturas();
	}



	@Override
	public List<Posicion> getPosiciones(int id_factura) {
		return this.facturaRepository.getPosiciones(id_factura);
	}

}
