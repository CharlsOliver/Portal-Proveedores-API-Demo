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
public class ContabilizacionFinancieraResponse {

    @JsonProperty("AnioFiscalDocSap")
    private String anioFiscalDocSap;

    @JsonProperty("UsuarioCarga")
    private String usuarioCarga;

    @JsonProperty("FechaVencimiento")
    private String fechaVencimiento;

    @JsonProperty("IdProveedor")
    private String idProveedor;

    @JsonProperty("TipoDocumento")
    private String tipoDocumento;

    @JsonProperty("Uuid")
    private String uuid;

    @JsonProperty("HasWithholdings")
    private String hasWithholdings;

    @JsonProperty("DocumentoSap")
    private String documentoSap;

    @JsonProperty("IsError")
    private String isError;

    @JsonProperty("DOCUMENTO_CABECERA")
    private DocumentoCabecera documentoCabecera;

    @JsonProperty("CUENTAS_CONTABLESSet")
    private CuentasContablesSet cuentasContablesSet;

    @JsonProperty("POSICIONES_PROVEEDORSet")
    private PosicionesProveedorSet posicionesProveedorSet;

    @JsonProperty("POSICIONES_MONTOSSet")
    private PosicionesMontosSet posicionesMontosSet;

    @JsonProperty("POSICIONES_IMPUESTOSSet")
    private PosicionesImpuestosSet posicionesImpuestosSet;

    @JsonProperty("MESSAGESSet")
    private MessagesSet messagesSet;

    @JsonProperty("POSICIONES_RETENCIONSet")
    private PosicionesRetencionSet posicionesRetencionSet;

    @JsonProperty("FISCAL_DATA")
    private FiscalData fiscalData;

    // Clases internas

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocumentoCabecera {
        private String sociedad;
        private String fechaDocumento;
        private String fechaContabilizacion;
        private String anioFiscal;
        private String periodoFiscal;
        private String referencia;
        private String headerTxt;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CuentasContablesSet {
        private List<CuentasContables> results;

        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        @Builder
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CuentasContables {
            private String item;
            private String ordenInterna;
            private String cuentaContable;
            private String textoPos;
            private String sociedad;
            private String anioFiscal;
            private String periodoFiscal;
            private String fechaContabilizacion;
            private String indImpuesto;
            private String centroCosto;
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PosicionesProveedorSet {
        private List<PosicionesProveedor> results;

        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        @Builder
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PosicionesProveedor {
            private String item;
            private String idProveedor;
            private String sociedad;
            private String condPago;
            private String indImpuesto;
            private String textoPos;
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PosicionesMontosSet {
        private List<PosicionesMontos> results;

        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        @Builder
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PosicionesMontos {
            private String item;
            private String currency;
            private String importe;
            private String baseImp;
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PosicionesImpuestosSet {
        private List<PosicionesImpuestos> results;

        @Setter
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        @Builder
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PosicionesImpuestos {
            private String item;
            private String indImpuestos;
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MessagesSet {
        private List<Object> results;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PosicionesRetencionSet {
        private List<Object> results;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FiscalData {
        private String rfcEmisor;
        private String regimenFiscal;
        private String formaPago;
        private String metodoPago;
        private String tipoComprobante;
        private String subtotal;
        private String total;
        private String moneda;
        private String totalImpTrasladados;
        private String totalImpRetenidos;
        private String fechaTimbrado;
    }
}
