package com.demoportalrecepcion.api.contabilizacion.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoportalrecepcion.api.contabilizacion.integration.ContabilizacionODataClient;
import com.demoportalrecepcion.api.contabilizacion.model.Contabilizacion;

@Repository
public class ContabilizacionRepositoryImpl implements ContabilizacionRepository{
	
	private ContabilizacionODataClient contabilizacionClient;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String escenarios_select_query = " SELECT * FROM contabilizacion ";
	

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

}
