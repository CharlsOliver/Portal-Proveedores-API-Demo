package com.demoportalrecepcion.api.entrada_mercancia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoportalrecepcion.api.entrada_mercancia.model.EntradaMercancia;
import com.demoportalrecepcion.api.entrada_mercancia.repository.EntradaMercanciaRepository;

@Service
public class EntradaMercanciaServiceImpl implements EntradaMercanciaService{
	
	private EntradaMercanciaRepository entradaMercanciaRepository;


	public EntradaMercanciaServiceImpl(EntradaMercanciaRepository entradaMercanciaRepository) {
		super();
		this.entradaMercanciaRepository = entradaMercanciaRepository;
	}

	@Override
	public String obtenerEjemplo() {
		return "It works!!!!!";
	}

	@Override
	public List<EntradaMercancia> getEntradasMercancia(String orden_compra) {
		return this.entradaMercanciaRepository.getEntradasMercancia(orden_compra);
	}

}
