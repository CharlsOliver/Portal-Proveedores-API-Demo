package com.demoportalrecepcion.api.contabilizacion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContabilizacionResponse {
	
	@JsonProperty("AnioFiscalDocSap")
    private String anioFiscalDocSap;

    @JsonProperty("UsuarioCarga")
    private String usuarioCarga;

    @JsonProperty("FechaVencimiento")
    private String fechaVencimiento;

    @JsonProperty("IsError")
    private String isError;

    @JsonProperty("IdProveedor")
    private String idProveedor;

    @JsonProperty("PurchaseOrder")
    private String purchaseOrder;

    @JsonProperty("Uuid")
    private String uuid;

    @JsonProperty("HasWithholdings")
    private String hasWithholdings;

    @JsonProperty("DocumentoSap")
    private String documentoSap;

    @JsonProperty("HEADER_DATASet")
    private HeaderDataSet headerDataSet;

    @JsonProperty("FISCAL_DATA")
    private FiscalData fiscalData;

    @JsonProperty("ITEM_DATASet")
    private ItemDataSet itemDataSet;
    
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class HeaderDataSet {
        private String FechaDocumento;
        private String TextoCabecera;
        private String TextoGral;
        private String FechaContabilizacion;
        private String Referencia;
        private String Sociedad;
        private String Total;
        private String Moneda;
    }
    
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FiscalData {
        private String RfcEmisor;
        private String RegimenFiscal;
        private String FormaPago;
        private String MetodoPago;
        private String TipoComprobante;
        private String Subtotal;
        private String Total;
        private String Moneda;
        private String TotalImpTrasladados;
        private String TotalImpRetenidos;
        private String FechaTimbrado;
    }
    
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ItemDataSet {
        private List<Item> results;
        
        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        @Builder
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Item {
            private String OrdenCompra;
            private String ItemOc;
            private String EntradaMercancia;
            private String PoEm;
            private String AnioEm;
            private String IndImpuesto;
            private String ImporteEm;
            private String CantidadEm;
            private String UnidadMedida;
        }
    }
}
