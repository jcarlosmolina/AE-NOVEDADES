package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class TDELETERequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedadTDELETEpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedadTDELETEpthisDocumentoNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadTDELETEpthisDocumentoNovedad();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedadTDELETEpthisDocumentoNovedad() {
        return this.documentoNovedadTDELETEpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedadTDELETEpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedadTDELETEpthisDocumentoNovedad) {
        this.documentoNovedadTDELETEpthisDocumentoNovedad = documentoNovedadTDELETEpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedadTDELETEpthisDocumentoNovedadInstance() {
        return this.documentoNovedadTDELETEpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedadTDELETEpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedadTDELETEpthisDocumentoNovedad) {
        this.documentoNovedadTDELETEpthisDocumentoNovedadInstance = documentoNovedadTDELETEpthisDocumentoNovedad;
        this.documentoNovedadTDELETEpthisDocumentoNovedad = documentoNovedadTDELETEpthisDocumentoNovedad != null ? documentoNovedadTDELETEpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedadTDELETEpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTDELETEpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedadTDELETEpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TDELETE, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TDELETE_DOCUMENTONOVEDADTDELETEPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_TDELETE, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TDELETE_DOCUMENTONOVEDADTDELETEPTHISDOCUMENTONOVEDAD);
        }
    }
}
