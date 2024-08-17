package com.demoportalrecepcion.api.cuentacontable;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoportalrecepcion.api.common.model.CustomResponse;
import com.demoportalrecepcion.api.cuentacontable.model.CuentaContable;
import com.demoportalrecepcion.api.cuentacontable.service.CuentaContableService;

@RestController
@RequestMapping("/cuenta_contable")
public class CuentaContableController {
	
	private static final Logger log = LoggerFactory.getLogger(CuentaContableController.class);

	private CuentaContableService cuentaContableService;

	public CuentaContableController(CuentaContableService cuentaContableService) {
		super();
		this.cuentaContableService = cuentaContableService;
	}
	
	@GetMapping("")
	public ResponseEntity<CustomResponse> ejemploService(){
		HttpStatus httpStatus;
		CustomResponse response;
		
		try {
			List<CuentaContable> centros_costo = this.cuentaContableService.getCentrosCosto();
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Cuentas contables recuperados.");
			response.setStatus(httpStatus.name());
			response.setObject(centros_costo);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al recuperar cuentas contables.");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}
	
}
