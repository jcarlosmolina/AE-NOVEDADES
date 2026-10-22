package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class DescargarDocumentoATORequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedad();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedad() {
        return this.documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad) {
        this.documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad = documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance() {
        return this.documentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad) {
        this.documentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance = documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad;
        this.documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad = documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad != null ? documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_DESCARGARDOCUMENTOATO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_DESCARGARDOCUMENTOATO_DOCUMENTONOVEDADDESCARGARDOCUMENTOATOPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_DESCARGARDOCUMENTOATO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_DESCARGARDOCUMENTOATO_DOCUMENTONOVEDADDESCARGARDOCUMENTOATOPTHISDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
