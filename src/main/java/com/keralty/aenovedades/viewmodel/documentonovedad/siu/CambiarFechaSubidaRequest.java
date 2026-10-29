package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;
import java.sql.Timestamp;

public class CambiarFechaSubidaRequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedadcambiarFechaSubidapthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance;

    @JsonProperty("p_fechasubida")
    private Timestamp documentoNovedadcambiarFechaSubidapFechaSubida;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedad();
        checkDocumentoNovedadcambiarFechaSubidapFechaSubida();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedad() {
        return this.documentoNovedadcambiarFechaSubidapthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedad(DocumentoNovedadOid documentoNovedadcambiarFechaSubidapthisDocumentoNovedad) {
        this.documentoNovedadcambiarFechaSubidapthisDocumentoNovedad = documentoNovedadcambiarFechaSubidapthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance() {
        return this.documentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedadcambiarFechaSubidapthisDocumentoNovedad) {
        this.documentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance = documentoNovedadcambiarFechaSubidapthisDocumentoNovedad;
        this.documentoNovedadcambiarFechaSubidapthisDocumentoNovedad = documentoNovedadcambiarFechaSubidapthisDocumentoNovedad != null ? documentoNovedadcambiarFechaSubidapthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance() == null || this.getDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_CAMBIARFECHASUBIDA, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_CAMBIARFECHASUBIDA_DOCUMENTONOVEDADCAMBIARFECHASUBIDAPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_CAMBIARFECHASUBIDA, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_CAMBIARFECHASUBIDA_DOCUMENTONOVEDADCAMBIARFECHASUBIDAPTHISDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public Timestamp getDocumentoNovedadcambiarFechaSubidapFechaSubida() {
        return this.documentoNovedadcambiarFechaSubidapFechaSubida;
    }
    
    public void setDocumentoNovedadcambiarFechaSubidapFechaSubida(Timestamp documentoNovedadcambiarFechaSubidapFechaSubida) {
        this.documentoNovedadcambiarFechaSubidapFechaSubida = documentoNovedadcambiarFechaSubidapFechaSubida;
    }

    private void checkDocumentoNovedadcambiarFechaSubidapFechaSubida() throws NotNullArgumentException {
        if(this.getDocumentoNovedadcambiarFechaSubidapFechaSubida() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_CAMBIARFECHASUBIDA, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_CAMBIARFECHASUBIDA_DOCUMENTONOVEDADCAMBIARFECHASUBIDAPFECHASUBIDA, DocumentoNovedadConstants.SERV_ALIAS_CAMBIARFECHASUBIDA, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_CAMBIARFECHASUBIDA_DOCUMENTONOVEDADCAMBIARFECHASUBIDAPFECHASUBIDA);
        }
    }
}
