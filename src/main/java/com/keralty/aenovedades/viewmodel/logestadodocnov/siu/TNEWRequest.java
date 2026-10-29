package com.keralty.aenovedades.viewmodel.logestadodocnov.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.LogEstadoDocNovConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class TNEWRequest {

    @JsonProperty("pt_p_agrdocumentonovedad_oid")
    private DocumentoNovedadOid logEstadoDocNovTNEWptpagrDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad logEstadoDocNovTNEWptpagrDocumentoNovedadInstance;

    @JsonProperty("pt_p_atrestadoanterior")
    private Long logEstadoDocNovTNEWptpatrEstadoAnterior;

    @JsonProperty("pt_p_atrestadonuevo")
    private Long logEstadoDocNovTNEWptpatrEstadoNuevo;

    @JsonProperty("pt_p_atrobservacions")
    private String logEstadoDocNovTNEWptpatrObservacions;

    public void checkArguments() throws NotNullArgumentException {
        checkLogEstadoDocNovTNEWptpagrDocumentoNovedad();
        checkLogEstadoDocNovTNEWptpatrEstadoAnterior();
        checkLogEstadoDocNovTNEWptpatrEstadoNuevo();
    }

    @JsonIgnore
    public DocumentoNovedadOid getLogEstadoDocNovTNEWptpagrDocumentoNovedad() {
        return this.logEstadoDocNovTNEWptpagrDocumentoNovedad;
    }
    
    public void setLogEstadoDocNovTNEWptpagrDocumentoNovedad(DocumentoNovedadOid logEstadoDocNovTNEWptpagrDocumentoNovedad) {
        this.logEstadoDocNovTNEWptpagrDocumentoNovedad = logEstadoDocNovTNEWptpagrDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getLogEstadoDocNovTNEWptpagrDocumentoNovedadInstance() {
        return this.logEstadoDocNovTNEWptpagrDocumentoNovedadInstance;
    }
    
    public void setLogEstadoDocNovTNEWptpagrDocumentoNovedadInstance(DocumentoNovedad logEstadoDocNovTNEWptpagrDocumentoNovedad) {
        this.logEstadoDocNovTNEWptpagrDocumentoNovedadInstance = logEstadoDocNovTNEWptpagrDocumentoNovedad;
        this.logEstadoDocNovTNEWptpagrDocumentoNovedad = logEstadoDocNovTNEWptpagrDocumentoNovedad != null ? logEstadoDocNovTNEWptpagrDocumentoNovedad.getOid() : null;
    }

    private void checkLogEstadoDocNovTNEWptpagrDocumentoNovedad() throws NotNullArgumentException {
        if(this.getLogEstadoDocNovTNEWptpagrDocumentoNovedadInstance() == null || this.getLogEstadoDocNovTNEWptpagrDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_TNEW, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_TNEW_LOGESTADODOCNOVTNEWPTPAGRDOCUMENTONOVEDAD, LogEstadoDocNovConstants.SERV_ALIAS_TNEW, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_TNEW_LOGESTADODOCNOVTNEWPTPAGRDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public Long getLogEstadoDocNovTNEWptpatrEstadoAnterior() {
        return this.logEstadoDocNovTNEWptpatrEstadoAnterior;
    }
    
    public void setLogEstadoDocNovTNEWptpatrEstadoAnterior(Long logEstadoDocNovTNEWptpatrEstadoAnterior) {
        this.logEstadoDocNovTNEWptpatrEstadoAnterior = logEstadoDocNovTNEWptpatrEstadoAnterior;
    }

    private void checkLogEstadoDocNovTNEWptpatrEstadoAnterior() throws NotNullArgumentException {
        if(this.getLogEstadoDocNovTNEWptpatrEstadoAnterior() == null) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_TNEW, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_TNEW_LOGESTADODOCNOVTNEWPTPATRESTADOANTERIOR, LogEstadoDocNovConstants.SERV_ALIAS_TNEW, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_TNEW_LOGESTADODOCNOVTNEWPTPATRESTADOANTERIOR);
        }
    }

    @JsonIgnore
    public Long getLogEstadoDocNovTNEWptpatrEstadoNuevo() {
        return this.logEstadoDocNovTNEWptpatrEstadoNuevo;
    }
    
    public void setLogEstadoDocNovTNEWptpatrEstadoNuevo(Long logEstadoDocNovTNEWptpatrEstadoNuevo) {
        this.logEstadoDocNovTNEWptpatrEstadoNuevo = logEstadoDocNovTNEWptpatrEstadoNuevo;
    }

    private void checkLogEstadoDocNovTNEWptpatrEstadoNuevo() throws NotNullArgumentException {
        if(this.getLogEstadoDocNovTNEWptpatrEstadoNuevo() == null) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_TNEW, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_TNEW_LOGESTADODOCNOVTNEWPTPATRESTADONUEVO, LogEstadoDocNovConstants.SERV_ALIAS_TNEW, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_TNEW_LOGESTADODOCNOVTNEWPTPATRESTADONUEVO);
        }
    }

    @JsonIgnore
    public String getLogEstadoDocNovTNEWptpatrObservacions() {
        return this.logEstadoDocNovTNEWptpatrObservacions;
    }
    
    public void setLogEstadoDocNovTNEWptpatrObservacions(String logEstadoDocNovTNEWptpatrObservacions) {
        this.logEstadoDocNovTNEWptpatrObservacions = logEstadoDocNovTNEWptpatrObservacions;
    }
}
