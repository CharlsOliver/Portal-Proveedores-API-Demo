package com.demoportalrecepcion.api.contabilizacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoportalrecepcion.api.common.model.CustomResponse;
import com.demoportalrecepcion.api.contabilizacion.service.ContabilizacionService;

@RestController
@RequestMapping("/contabilizacion")
public class ContabilizacionController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ContabilizacionController.class);
	
	private ContabilizacionService contabilizacionService;

	public ContabilizacionController(ContabilizacionService contabilizacionService) {
		super();
		this.contabilizacionService = contabilizacionService;
	}
	
	@GetMapping("/{oc}")
	public ResponseEntity<CustomResponse> getFacturas(@PathVariable String oc){
		
		CustomResponse response;
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			String result = this.contabilizacionService.contabilizar(oc);
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Factura contabilizada correctamente.");
			response.setStatus(httpStatus.name());
			response.setObject(result);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al contabilizar escenario");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}
}
