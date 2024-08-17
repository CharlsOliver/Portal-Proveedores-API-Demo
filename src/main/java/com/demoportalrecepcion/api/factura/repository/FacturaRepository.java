package com.demoportalrecepcion.api.factura.repository;

import java.util.List;

import com.demoportalrecepcion.api.factura.model.Factura;
import com.demoportalrecepcion.api.factura.model.Posicion;

public interface FacturaRepository {
	
	List<Factura> getFacturas();

	List<Posicion> getPosiciones(int id_factura);
}
