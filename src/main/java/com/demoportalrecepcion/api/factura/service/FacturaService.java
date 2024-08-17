package com.demoportalrecepcion.api.factura.service;

import java.util.List;

import com.demoportalrecepcion.api.factura.model.Factura;
import com.demoportalrecepcion.api.factura.model.Posicion;

public interface FacturaService {
	
	List<Factura> getFacturas();

	List<Posicion> getPosiciones(int id_factura);
	
}
