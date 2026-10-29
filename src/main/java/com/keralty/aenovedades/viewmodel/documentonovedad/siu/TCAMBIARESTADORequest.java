package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class TCAMBIARESTADORequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance;

    @JsonProperty("pt_p_atrobservacions")
    private String documentoNovedadTCAMBIARESTADOptpatrObservacions;

    @JsonProperty("ptnuevoestado")
    private Long documentoNovedadTCAMBIARESTADOptNuevoEstado;

    @JsonProperty("ptajustarestadosolicitud")
    private Boolean documentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedad();
        checkDocumentoNovedadTCAMBIARESTADOptNuevoEstado();
        checkDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedad() {
        return this.documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad) {
        this.documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad = documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance() {
        return this.documentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad) {
        this.documentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance = documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad;
        this.documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad = documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad != null ? documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TCAMBIARESTADO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TCAMBIARESTADO_DOCUMENTONOVEDADTCAMBIARESTADOPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_TCAMBIARESTADO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TCAMBIARESTADO_DOCUMENTONOVEDADTCAMBIARESTADOPTHISDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadTCAMBIARESTADOptpatrObservacions() {
        return this.documentoNovedadTCAMBIARESTADOptpatrObservacions;
    }
    
    public void setDocumentoNovedadTCAMBIARESTADOptpatrObservacions(String documentoNovedadTCAMBIARESTADOptpatrObservacions) {
        this.documentoNovedadTCAMBIARESTADOptpatrObservacions = documentoNovedadTCAMBIARESTADOptpatrObservacions;
    }

    @JsonIgnore
    public Long getDocumentoNovedadTCAMBIARESTADOptNuevoEstado() {
        return this.documentoNovedadTCAMBIARESTADOptNuevoEstado;
    }
    
    public void setDocumentoNovedadTCAMBIARESTADOptNuevoEstado(Long documentoNovedadTCAMBIARESTADOptNuevoEstado) {
        this.documentoNovedadTCAMBIARESTADOptNuevoEstado = documentoNovedadTCAMBIARESTADOptNuevoEstado;
    }

    private void checkDocumentoNovedadTCAMBIARESTADOptNuevoEstado() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTCAMBIARESTADOptNuevoEstado() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TCAMBIARESTADO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TCAMBIARESTADO_DOCUMENTONOVEDADTCAMBIARESTADOPTNUEVOESTADO, DocumentoNovedadConstants.SERV_ALIAS_TCAMBIARESTADO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TCAMBIARESTADO_DOCUMENTONOVEDADTCAMBIARESTADOPTNUEVOESTADO);
        }
    }

    @JsonIgnore
    public Boolean getDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud() {
        return this.documentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud;
    }
    
    public void setDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud(Boolean documentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud) {
        this.documentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud = documentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud;
    }

    private void checkDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TCAMBIARESTADO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TCAMBIARESTADO_DOCUMENTONOVEDADTCAMBIARESTADOPTAJUSTARESTADOSOLICITUD, DocumentoNovedadConstants.SERV_ALIAS_TCAMBIARESTADO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TCAMBIARESTADO_DOCUMENTONOVEDADTCAMBIARESTADOPTAJUSTARESTADOSOLICITUD);
        }
    }
}
