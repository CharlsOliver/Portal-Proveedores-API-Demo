package com.demoportalrecepcion.api.entrada_mercancia.service;

import java.util.List;

import com.demoportalrecepcion.api.entrada_mercancia.model.EntradaMercancia;

public interface EntradaMercanciaService{

	String obtenerEjemplo();

	List<EntradaMercancia> getEntradasMercancia(String orden_compra);

}
