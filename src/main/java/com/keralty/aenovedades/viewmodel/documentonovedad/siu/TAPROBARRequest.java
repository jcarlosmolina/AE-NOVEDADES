package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class TAPROBARRequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedadTAPROBARpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedadTAPROBARpthisDocumentoNovedadInstance;

    @JsonProperty("pt_p_atrobservacions")
    private String documentoNovedadTAPROBARptpatrObservacions;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadTAPROBARpthisDocumentoNovedad();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedadTAPROBARpthisDocumentoNovedad() {
        return this.documentoNovedadTAPROBARpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedadTAPROBARpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedadTAPROBARpthisDocumentoNovedad) {
        this.documentoNovedadTAPROBARpthisDocumentoNovedad = documentoNovedadTAPROBARpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedadTAPROBARpthisDocumentoNovedadInstance() {
        return this.documentoNovedadTAPROBARpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedadTAPROBARpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedadTAPROBARpthisDocumentoNovedad) {
        this.documentoNovedadTAPROBARpthisDocumentoNovedadInstance = documentoNovedadTAPROBARpthisDocumentoNovedad;
        this.documentoNovedadTAPROBARpthisDocumentoNovedad = documentoNovedadTAPROBARpthisDocumentoNovedad != null ? documentoNovedadTAPROBARpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedadTAPROBARpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTAPROBARpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedadTAPROBARpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TAPROBAR, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TAPROBAR_DOCUMENTONOVEDADTAPROBARPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_TAPROBAR, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TAPROBAR_DOCUMENTONOVEDADTAPROBARPTHISDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadTAPROBARptpatrObservacions() {
        return this.documentoNovedadTAPROBARptpatrObservacions;
    }
    
    public void setDocumentoNovedadTAPROBARptpatrObservacions(String documentoNovedadTAPROBARptpatrObservacions) {
        this.documentoNovedadTAPROBARptpatrObservacions = documentoNovedadTAPROBARptpatrObservacions;
    }
}
