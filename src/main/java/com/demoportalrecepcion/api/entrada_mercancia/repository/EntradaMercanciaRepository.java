package com.demoportalrecepcion.api.entrada_mercancia.repository;

import java.util.List;

import com.demoportalrecepcion.api.entrada_mercancia.model.EntradaMercancia;


public interface EntradaMercanciaRepository {

	List<EntradaMercancia> getEntradasMercancia(String orden_compra);

}
