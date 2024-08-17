package com.demoportalrecepcion.api.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;

@Getter
@Configuration
public class HttpClientConfig {

    @Value("${sap.odata.baseurl}")
    private String ODATA_BASEURL;

    @Value("${sap.odata.client}")
    private String ODATA_SAP_CLIENT;

    @Value("${sap.odata.user}")
    private String ODATA_SAP_USER;

    @Value("${sap.odata.password}")
    private String ODATA_SAP_PASSWORD;
    
    
	private static final Logger log = LoggerFactory.getLogger(HttpClientConfig.class);


    @Bean
    @Qualifier("oDataClient")
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        String auth = ODATA_SAP_USER + ":" + ODATA_SAP_PASSWORD;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(encodedAuth);

        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            log.info("Authorization header: {}", authHeader);
            request.getHeaders().set("Authorization", authHeader);
            request.getHeaders().set("sap-client", ODATA_SAP_CLIENT);
            return execution.execute(request, body);
        };

        restTemplate.setInterceptors(Collections.singletonList(interceptor));
        return restTemplate;
    }
}
