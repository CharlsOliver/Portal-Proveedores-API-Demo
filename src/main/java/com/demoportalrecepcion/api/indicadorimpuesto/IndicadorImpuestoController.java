package com.demoportalrecepcion.api.indicadorimpuesto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoportalrecepcion.api.common.model.CustomResponse;
import com.demoportalrecepcion.api.indicadorimpuesto.model.IndicadorImpuesto;
import com.demoportalrecepcion.api.indicadorimpuesto.service.IndicadorImpuestoService;

@RestController
@RequestMapping("/indicador_impuesto")
public class IndicadorImpuestoController {
	
	private static final Logger log = LoggerFactory.getLogger(IndicadorImpuestoController.class);
	
	private IndicadorImpuestoService indicadorImpuestoService;
	
	
	
	public IndicadorImpuestoController(IndicadorImpuestoService indicadorImpuestoService) {
		super();
		this.indicadorImpuestoService = indicadorImpuestoService;
	}



	@GetMapping("")
	public ResponseEntity<CustomResponse> getIndicadorImpuesto(){
		HttpStatus httpStatus;
		CustomResponse response;
		
		try {
			List<IndicadorImpuesto> centros_costo = this.indicadorImpuestoService.getIndicadoresImpuesto();
			httpStatus = HttpStatus.OK;
			response = new CustomResponse();
			response.setMessage("Indicadores de impuesto recuperados.");
			response.setStatus(httpStatus.name());
			response.setObject(centros_costo);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = new CustomResponse();
			response.setMessage("Error al recuperar indicadores de impuesto.");
			response.setStatus(httpStatus.name());
			response.setErrorDescription(e.getMessage());
		}
		
		return new ResponseEntity<CustomResponse>(response, httpStatus);
	}

}
