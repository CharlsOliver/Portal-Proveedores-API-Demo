package com.demoportalrecepcion.api.contabilizacion.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoportalrecepcion.api.contabilizacion.integration.ContabilizacionODataClient;
import com.demoportalrecepcion.api.contabilizacion.model.Contabilizacion;
import com.demoportalrecepcion.api.contabilizacion.model.ContabilizacionFinanciera;

@Repository
public class ContabilizacionRepositoryImpl implements ContabilizacionRepository{
	
	private ContabilizacionODataClient contabilizacionClient;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String escenarios_select_query = " SELECT * FROM contabilizacion ";
	
	private final String escenarios_financieros_select_query = " SELECT * FROM contabilizacion_financiera ";
	

	public ContabilizacionRepositoryImpl(ContabilizacionODataClient contabilizacionClient, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.contabilizacionClient = contabilizacionClient;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public String contabilizar(String oc) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("orden_compra", oc);
		
		StringBuilder selectQuery = new StringBuilder(this.escenarios_select_query);
		selectQuery.append("WHERE orden_compra = :orden_compra");
		
		Contabilizacion factura = namedParameterJdbcTemplate.queryForObject(selectQuery.toString(), params, new ContabilizacionRM());
		
		// Crear el objeto principal
        JSONObject mainObject = new JSONObject();
        
        mainObject.put("HasWithholdings", "");
        mainObject.put("IdProveedor", factura.getProveedor());
        mainObject.put("PurchaseOrder", factura.getOrden_compra());
        mainObject.put("Uuid", factura.getUuid());
        mainObject.put("DocumentoSap", "");
        mainObject.put("AnioFiscalDocSap", "");
        mainObject.put("IsError", "");
        mainObject.put("FechaVencimiento", "");
        mainObject.put("UsuarioCarga", "opulido@ammper.com");
        
        // Crear y añadir el objeto FISCAL_DATA
        JSONObject fiscalData = new JSONObject();
        fiscalData.put("RfcEmisor", factura.getRfc_emisor());
        fiscalData.put("RegimenFiscal", factura.getRegimen_emisor());
        fiscalData.put("FormaPago", factura.getForma_pago());
        fiscalData.put("MetodoPago", factura.getMetodo_pago());
        fiscalData.put("TipoComprobante", factura.getTipo_comprobante());
        fiscalData.put("Subtotal", factura.getSubtotal().toString());
        fiscalData.put("Total", factura.getTotal().toString());
        fiscalData.put("Moneda", factura.getMoneda());
        fiscalData.put("TotalImpTrasladados", factura.getImpuestos_trasladados().toString());
        fiscalData.put("TotalImpRetenidos", factura.getImpuestos_retenidos().toString());
        fiscalData.put("FechaTimbrado", factura.getFecha_timbrado());
        mainObject.put("FISCAL_DATA", fiscalData);
        
        // Crear y añadir el objeto HEADER_DATASet
        JSONObject headerDataSet = new JSONObject();
        headerDataSet.put("FechaDocumento", factura.getFecha_documento());
        headerDataSet.put("FechaContabilizacion", factura.getFecha_contabilizacion());
        headerDataSet.put("Referencia", factura.getReferencia());
        headerDataSet.put("Sociedad", factura.getSociedad());
        headerDataSet.put("Total", factura.getTotal().toString());
        headerDataSet.put("Moneda", factura.getMoneda());
        headerDataSet.put("TextoCabecera", factura.getTexto_cabecera());
        headerDataSet.put("TextoGral", factura.getTexto_general());
        mainObject.put("HEADER_DATASet", headerDataSet);
        
        // Crear y añadir el array ITEM_DATASet
        String items = factura.getItems();
        JSONArray itemsArray = new JSONArray(items);
        mainObject.put("ITEM_DATASet", itemsArray);
        
        // Crear y añadir el array TAX_DATASet vacío
        mainObject.put("TAX_DATASet", new JSONArray());
        
        // Crear y añadir el array WITHTAX_DATASet vacío
        mainObject.put("WITHTAX_DATASet", new JSONArray());
        
        // Crear y añadir el array MESSAGESSet
        JSONArray messagesSet = new JSONArray();
        JSONObject message = new JSONObject();
        message.put("Type", "");
        message.put("Id", "");
        message.put("Number", "");
        message.put("Message", "");
        message.put("LogNo", "");
        message.put("LogMsgNo", "");
        message.put("MessageV1", "");
        message.put("MessageV2", "");
        message.put("MessageV3", "");
        message.put("MessageV4", "");
        message.put("Parameter", "");
        message.put("Row", "");
        message.put("Field", "");
        message.put("System", "");
        messagesSet.put(message);
        mainObject.put("MESSAGESSet", messagesSet);
        
        String body = mainObject.toString(4);
		
		return contabilizacionClient.contabilizacionODataCall(body);
	}


	@Override
	public String contabilizar(int escenario) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_contabilizacion_financiera", escenario);
		
		
		StringBuilder selectQuery = new StringBuilder(this.escenarios_financieros_select_query);
		selectQuery.append("WHERE id_contabilizacion_financiera = :id_contabilizacion_financiera");
		
		ContabilizacionFinanciera factura = namedParameterJdbcTemplate.queryForObject(selectQuery.toString(), params, new ContabilizacionFinancieraRM());
		
		// Crear el objeto principal
        JSONObject mainObject = new JSONObject();
        
        // Añadir propiedades simples
        mainObject.put("TipoDocumento", factura.getTipo_documento());
        mainObject.put("IdProveedor", factura.getId_proveedor());
        mainObject.put("Uuid", factura.getUuid());
        mainObject.put("HasWithholdings", "");
        mainObject.put("DocumentoSap", "");
        mainObject.put("AnioFiscalDocSap", "");
        mainObject.put("IsError", "");
        mainObject.put("UsuarioCarga", "opulido@ammper.com");
        
        // Crear y añadir el objeto FISCAL_DATA
        JSONObject fiscalData = new JSONObject();
        fiscalData.put("RfcEmisor", factura.getRfc_emisor());
        fiscalData.put("RegimenFiscal", factura.getRegimen_fiscal());
        fiscalData.put("FormaPago", factura.getForma_pago());
        fiscalData.put("MetodoPago", factura.getMetodo_pago());
        fiscalData.put("TipoComprobante", factura.getTipo_comprobante());
        fiscalData.put("Subtotal", factura.getSubtotal().toString());
        fiscalData.put("Total", factura.getTotal().toString());
        fiscalData.put("Moneda", factura.getMoneda());
        fiscalData.put("TotalImpTrasladados", factura.getImpuestos_trasladados().toString());
        fiscalData.put("TotalImpRetenidos", factura.getImpuestos_retenidos().toString());
        fiscalData.put("FechaTimbrado", factura.getFecha_timbrado());
        mainObject.put("FISCAL_DATA", fiscalData);
        
        // Crear y añadir el objeto DOCUMENTO_CABECERA
        JSONObject documentoCabecera = new JSONObject();
        documentoCabecera.put("Sociedad", factura.getSociedad());
        documentoCabecera.put("FechaDocumento", factura.getFecha_documento());
        documentoCabecera.put("FechaContabilizacion", factura.getFecha_contabilizacion());
        documentoCabecera.put("AnioFiscal", factura.getEjercicio());
        documentoCabecera.put("PeriodoFiscal", factura.getPeriodo_fiscal());
        documentoCabecera.put("Referencia", factura.getReferencia());
        documentoCabecera.put("HeaderTxt", factura.getTexto_cabecera());
        mainObject.put("DOCUMENTO_CABECERA", documentoCabecera);
        
        // Crear y añadir el array POSICIONES_PROVEEDORSet
        String posiciones = factura.getPosiciones();
        JSONArray posicionesProveedorSet = new JSONArray(posiciones);
        mainObject.put("POSICIONES_PROVEEDORSet", posicionesProveedorSet);
        
        // Crear y añadir el array CUENTAS_CONTABLESSet
        String cuentasContables = factura.getCuentas_contables();
        JSONArray cuentasContablesSet = new JSONArray(cuentasContables);
        mainObject.put("CUENTAS_CONTABLESSet", cuentasContablesSet);
        
        // Crear y añadir el array POSICIONES_IMPUESTOSSet
        String posicionesImpuestos = factura.getPosiciones_impuestos();
        JSONArray posicionesImpuestosSet = new JSONArray(posicionesImpuestos);
        mainObject.put("POSICIONES_IMPUESTOSSet", posicionesImpuestosSet);
        
        // Crear y añadir el array POSICIONES_RETENCIONSet vacío
        mainObject.put("POSICIONES_RETENCIONSet", new JSONArray());
        
        // Crear y añadir el array POSICIONES_MONTOSSet
        String posicionesMontos = factura.getPosiciones_montos();
        JSONArray posicionesMontosSet = new JSONArray(posicionesMontos);
        mainObject.put("POSICIONES_MONTOSSet", posicionesMontosSet);
        
        // Crear y añadir el array MESSAGESSet
        JSONArray messagesSet = new JSONArray();
        JSONObject message = new JSONObject();
        message.put("Type", "");
        message.put("Id", "");
        message.put("Number", "");
        message.put("Message", "");
        message.put("LogNo", "");
        message.put("LogMsgNo", "");
        message.put("MessageV1", "");
        message.put("MessageV2", "");
        message.put("MessageV3", "");
        message.put("MessageV4", "");
        message.put("Parameter", "");
        message.put("Row", "");
        message.put("Field", "");
        message.put("System", "");
        messagesSet.put(message);
        mainObject.put("MESSAGESSet", messagesSet);
        
        // Convertir mainObject a JSON string
        String body = mainObject.toString(4);
        
        return contabilizacionClient.contabilizacionODataCallFinanciero(body);
	}

}
