package com.demoportalrecepcion.api.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CustomResponse {
	
	private String message;
	private String status;
	private String errorDescription;
	private Object object;
	
}
