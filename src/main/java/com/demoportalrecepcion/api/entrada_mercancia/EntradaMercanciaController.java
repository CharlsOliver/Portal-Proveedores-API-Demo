package com.demoportalrecepcion.api.entrada_mercancia;

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
import com.demoportalrecepcion.api.entrada_mercancia.model.EntradaMercancia;
import com.demoportalrecepcion.api.entrada_mercancia.service.EntradaMercanciaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/entradas_mercancia")
public class EntradaMercanciaController {
	
	
	private static final Logger log = LoggerFactory.getLogger(EntradaMercanciaController.class);

	private EntradaMercanciaService entradaMercanciaService;

	public EntradaMercanciaController(EntradaMercanciaService entradaMercanciaService) {
		super();
		this.entradaMercanciaService = entradaMercanciaService;
	}
	
	@GetMapping("/test")
	public ResponseEntity<CustomResponse> ejemploService(){
		HttpStatus httpStatus;
		CustomResponse response;
		
		try {
			String ejemplo = this.entradaMercanciaService.obtenerEjemplo();
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Ejemplo de WebService");
			response.setStatus(httpStatus.name());
			response.setObject(ejemplo);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al recuperar ejemplo");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}
	
	@GetMapping("/{orden_compra}")
	@Operation(summary = "Recuperar entradas de mercancia de una orden de compra", description = "${}")
	public ResponseEntity<CustomResponse> getEntradasMercancia(@PathVariable String orden_compra){
		
		CustomResponse response;
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			List<EntradaMercancia> entradas_mercancia = this.entradaMercanciaService.getEntradasMercancia(orden_compra);
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Entradas de mercancia recuperadas.");
			response.setStatus(httpStatus.name());
			response.setObject(entradas_mercancia);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al recuperar entradas de mercancia.");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}

}
