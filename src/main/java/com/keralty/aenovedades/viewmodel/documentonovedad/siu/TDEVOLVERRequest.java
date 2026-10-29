package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class TDEVOLVERRequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedadTDEVOLVERpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedadTDEVOLVERpthisDocumentoNovedadInstance;

    @JsonProperty("pt_p_atrobservacions")
    private String documentoNovedadTDEVOLVERptpatrObservacions;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadTDEVOLVERpthisDocumentoNovedad();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedadTDEVOLVERpthisDocumentoNovedad() {
        return this.documentoNovedadTDEVOLVERpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedadTDEVOLVERpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedadTDEVOLVERpthisDocumentoNovedad) {
        this.documentoNovedadTDEVOLVERpthisDocumentoNovedad = documentoNovedadTDEVOLVERpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedadTDEVOLVERpthisDocumentoNovedadInstance() {
        return this.documentoNovedadTDEVOLVERpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedadTDEVOLVERpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedadTDEVOLVERpthisDocumentoNovedad) {
        this.documentoNovedadTDEVOLVERpthisDocumentoNovedadInstance = documentoNovedadTDEVOLVERpthisDocumentoNovedad;
        this.documentoNovedadTDEVOLVERpthisDocumentoNovedad = documentoNovedadTDEVOLVERpthisDocumentoNovedad != null ? documentoNovedadTDEVOLVERpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedadTDEVOLVERpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTDEVOLVERpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedadTDEVOLVERpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TDEVOLVER, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TDEVOLVER_DOCUMENTONOVEDADTDEVOLVERPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_TDEVOLVER, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TDEVOLVER_DOCUMENTONOVEDADTDEVOLVERPTHISDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadTDEVOLVERptpatrObservacions() {
        return this.documentoNovedadTDEVOLVERptpatrObservacions;
    }
    
    public void setDocumentoNovedadTDEVOLVERptpatrObservacions(String documentoNovedadTDEVOLVERptpatrObservacions) {
        this.documentoNovedadTDEVOLVERptpatrObservacions = documentoNovedadTDEVOLVERptpatrObservacions;
    }
}
