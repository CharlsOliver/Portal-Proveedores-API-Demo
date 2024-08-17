package com.demoportalrecepcion.api.ceco;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoportalrecepcion.api.ceco.model.CentroCosto;
import com.demoportalrecepcion.api.ceco.service.CentroCostoService;
import com.demoportalrecepcion.api.common.model.CustomResponse;

@RestController
@RequestMapping("/centro_costo")
public class CentroCostoController {
	
	private static final Logger log = LoggerFactory.getLogger(CentroCostoController.class);
	
	private CentroCostoService cecoService;

	public CentroCostoController(CentroCostoService cecoService) {
		super();
		this.cecoService = cecoService;
	}
	
	@GetMapping("")
	public ResponseEntity<CustomResponse> getCentroCosto(){
		HttpStatus httpStatus;
		CustomResponse response;
		
		try {
			List<CentroCosto> centros_costo = this.cecoService.getCentrosCosto();
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Centros de costo recuperados.");
			response.setStatus(httpStatus.name());
			response.setObject(centros_costo);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al recuperar centros de costo.");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}
}
