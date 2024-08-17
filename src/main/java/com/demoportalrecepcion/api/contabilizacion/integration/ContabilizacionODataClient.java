package com.demoportalrecepcion.api.contabilizacion.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demoportalrecepcion.api.config.HttpClientConfig;
import com.demoportalrecepcion.api.contabilizacion.model.ContabilizacionResponse;
import com.demoportalrecepcion.api.contabilizacion.model.ContabilizacionResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ContabilizacionODataClient {

    private final String ZFIODP_PROVEEDOR_PRF_SRV = "/ZFIODP_PROVEEDOR_PRF_SRV";
    private final String endpoint_contabiliza_foc = "/CONTABILIZA_FOCSet?";

    private RestTemplate restTemplate;
    
    @Autowired
    private HttpClientConfig httpClientConfig;

    public ContabilizacionODataClient(@Qualifier("restTemplate") RestTemplate restTemplate, RetryTemplate retryTemplate) {
        this.restTemplate = restTemplate;
    }

    public String contabilizacionODataCall(String body) {
    	
    	String docSap = "";
    	
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        headers.set("X-Requested-With", "X");
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        
        String url = httpClientConfig.getODATA_BASEURL() + ZFIODP_PROVEEDOR_PRF_SRV + endpoint_contabiliza_foc;   
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            ContabilizacionResponseWrapper wrapper = objectMapper.readValue(response.getBody(), ContabilizacionResponseWrapper.class);
            ContabilizacionResponse contabilizacionResp = wrapper.getD();
            docSap = contabilizacionResp.getDocumentoSap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return docSap;
    }
}
