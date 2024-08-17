package com.demoportalrecepcion.api.factura;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoportalrecepcion.api.common.model.CustomResponse;
import com.demoportalrecepcion.api.factura.model.Factura;
import com.demoportalrecepcion.api.factura.model.Posicion;
import com.demoportalrecepcion.api.factura.service.FacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	
	
	private static final Logger log = LoggerFactory.getLogger(FacturaController.class);
	
	private FacturaService facturaService;

	public FacturaController(FacturaService facturaService) {
		super();
		this.facturaService = facturaService;
	}
	
	
	@GetMapping("")
	public ResponseEntity<CustomResponse> getFacturas(){
		
		HttpStatus httpStatus;
		CustomResponse response;
		
		try {
			List<Factura> facturas = this.facturaService.getFacturas();
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Facturas recuperadas.");
			response.setStatus(httpStatus.name());
			response.setObject(facturas);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al recuperar facturas.");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}
	
	@GetMapping("/posiciones/{id_factura}")
	public ResponseEntity<CustomResponse> getPosicionesFacturas(@PathVariable int id_factura){
		HttpStatus httpStatus;
		CustomResponse response;
		
		try {
			
			List<Posicion> posiciones = this.facturaService.getPosiciones(id_factura);
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Facturas recuperadas.");
			response.setStatus(httpStatus.name());
			response.setObject(posiciones);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al recuperar facturas.");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}

}
