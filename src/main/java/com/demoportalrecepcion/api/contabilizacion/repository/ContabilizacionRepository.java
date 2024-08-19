package com.demoportalrecepcion.api.contabilizacion.repository;

public interface ContabilizacionRepository {

	String contabilizar(String oc);

	String contabilizar(int escenario);
}
