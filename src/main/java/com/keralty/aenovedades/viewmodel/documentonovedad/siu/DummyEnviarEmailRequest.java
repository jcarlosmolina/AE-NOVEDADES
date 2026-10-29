package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class DummyEnviarEmailRequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedaddummyEnviarEmailpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance;

    @JsonProperty("pto")
    private String documentoNovedaddummyEnviarEmailpTo;

    @JsonProperty("pasunto")
    private String documentoNovedaddummyEnviarEmailpAsunto;

    @JsonProperty("pboby")
    private String documentoNovedaddummyEnviarEmailpBoby;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedad();
        checkDocumentoNovedaddummyEnviarEmailpTo();
        checkDocumentoNovedaddummyEnviarEmailpAsunto();
        checkDocumentoNovedaddummyEnviarEmailpBoby();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedad() {
        return this.documentoNovedaddummyEnviarEmailpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedaddummyEnviarEmailpthisDocumentoNovedad) {
        this.documentoNovedaddummyEnviarEmailpthisDocumentoNovedad = documentoNovedaddummyEnviarEmailpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance() {
        return this.documentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedaddummyEnviarEmailpthisDocumentoNovedad) {
        this.documentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance = documentoNovedaddummyEnviarEmailpthisDocumentoNovedad;
        this.documentoNovedaddummyEnviarEmailpthisDocumentoNovedad = documentoNovedaddummyEnviarEmailpthisDocumentoNovedad != null ? documentoNovedaddummyEnviarEmailpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPTHISDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedaddummyEnviarEmailpTo() {
        return this.documentoNovedaddummyEnviarEmailpTo;
    }
    
    public void setDocumentoNovedaddummyEnviarEmailpTo(String documentoNovedaddummyEnviarEmailpTo) {
        this.documentoNovedaddummyEnviarEmailpTo = documentoNovedaddummyEnviarEmailpTo;
    }

    private void checkDocumentoNovedaddummyEnviarEmailpTo() throws NotNullArgumentException {
        if(this.getDocumentoNovedaddummyEnviarEmailpTo() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPTO, DocumentoNovedadConstants.SERV_ALIAS_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPTO);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedaddummyEnviarEmailpAsunto() {
        return this.documentoNovedaddummyEnviarEmailpAsunto;
    }
    
    public void setDocumentoNovedaddummyEnviarEmailpAsunto(String documentoNovedaddummyEnviarEmailpAsunto) {
        this.documentoNovedaddummyEnviarEmailpAsunto = documentoNovedaddummyEnviarEmailpAsunto;
    }

    private void checkDocumentoNovedaddummyEnviarEmailpAsunto() throws NotNullArgumentException {
        if(this.getDocumentoNovedaddummyEnviarEmailpAsunto() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPASUNTO, DocumentoNovedadConstants.SERV_ALIAS_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPASUNTO);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedaddummyEnviarEmailpBoby() {
        return this.documentoNovedaddummyEnviarEmailpBoby;
    }
    
    public void setDocumentoNovedaddummyEnviarEmailpBoby(String documentoNovedaddummyEnviarEmailpBoby) {
        this.documentoNovedaddummyEnviarEmailpBoby = documentoNovedaddummyEnviarEmailpBoby;
    }

    private void checkDocumentoNovedaddummyEnviarEmailpBoby() throws NotNullArgumentException {
        if(this.getDocumentoNovedaddummyEnviarEmailpBoby() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPBOBY, DocumentoNovedadConstants.SERV_ALIAS_DUMMYENVIAREMAIL, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_DUMMYENVIAREMAIL_DOCUMENTONOVEDADDUMMYENVIAREMAILPBOBY);
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
