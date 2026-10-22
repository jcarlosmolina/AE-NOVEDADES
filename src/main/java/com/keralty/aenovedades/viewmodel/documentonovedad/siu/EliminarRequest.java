package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class EliminarRequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedadeliminarpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedadeliminarpthisDocumentoNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadeliminarpthisDocumentoNovedad();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedadeliminarpthisDocumentoNovedad() {
        return this.documentoNovedadeliminarpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedadeliminarpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedadeliminarpthisDocumentoNovedad) {
        this.documentoNovedadeliminarpthisDocumentoNovedad = documentoNovedadeliminarpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedadeliminarpthisDocumentoNovedadInstance() {
        return this.documentoNovedadeliminarpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedadeliminarpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedadeliminarpthisDocumentoNovedad) {
        this.documentoNovedadeliminarpthisDocumentoNovedadInstance = documentoNovedadeliminarpthisDocumentoNovedad;
        this.documentoNovedadeliminarpthisDocumentoNovedad = documentoNovedadeliminarpthisDocumentoNovedad != null ? documentoNovedadeliminarpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedadeliminarpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedadeliminarpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedadeliminarpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_ELIMINAR, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_ELIMINAR_DOCUMENTONOVEDADELIMINARPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_ELIMINAR, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_ELIMINAR_DOCUMENTONOVEDADELIMINARPTHISDOCUMENTONOVEDAD);
        }
    }
}
