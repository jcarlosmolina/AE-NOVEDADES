package com.keralty.aenovedades.viewmodel.logestadodocnov.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.LogEstadoDocNovConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class CrearRequest {

    @JsonProperty("p_agrdocumentonovedad_oid")
    private DocumentoNovedadOid logEstadoDocNovcrearpagrDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad logEstadoDocNovcrearpagrDocumentoNovedadInstance;

    @JsonProperty("p_atrnombrefuncionario")
    private String logEstadoDocNovcrearpatrNombreFuncionario;

    @JsonProperty("p_atrestadoanterior")
    private Long logEstadoDocNovcrearpatrEstadoAnterior;

    @JsonProperty("p_atrestadonuevo")
    private Long logEstadoDocNovcrearpatrEstadoNuevo;

    @JsonProperty("p_atrobservacions")
    private String logEstadoDocNovcrearpatrObservacions;

    public void checkArguments() throws NotNullArgumentException {
        checkLogEstadoDocNovcrearpagrDocumentoNovedad();
        checkLogEstadoDocNovcrearpatrNombreFuncionario();
        checkLogEstadoDocNovcrearpatrEstadoAnterior();
        checkLogEstadoDocNovcrearpatrEstadoNuevo();
    }

    @JsonIgnore
    public DocumentoNovedadOid getLogEstadoDocNovcrearpagrDocumentoNovedad() {
        return this.logEstadoDocNovcrearpagrDocumentoNovedad;
    }
    
    public void setLogEstadoDocNovcrearpagrDocumentoNovedad(DocumentoNovedadOid logEstadoDocNovcrearpagrDocumentoNovedad) {
        this.logEstadoDocNovcrearpagrDocumentoNovedad = logEstadoDocNovcrearpagrDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getLogEstadoDocNovcrearpagrDocumentoNovedadInstance() {
        return this.logEstadoDocNovcrearpagrDocumentoNovedadInstance;
    }
    
    public void setLogEstadoDocNovcrearpagrDocumentoNovedadInstance(DocumentoNovedad logEstadoDocNovcrearpagrDocumentoNovedad) {
        this.logEstadoDocNovcrearpagrDocumentoNovedadInstance = logEstadoDocNovcrearpagrDocumentoNovedad;
        this.logEstadoDocNovcrearpagrDocumentoNovedad = logEstadoDocNovcrearpagrDocumentoNovedad != null ? logEstadoDocNovcrearpagrDocumentoNovedad.getOid() : null;
    }

    private void checkLogEstadoDocNovcrearpagrDocumentoNovedad() throws NotNullArgumentException {
        if(this.getLogEstadoDocNovcrearpagrDocumentoNovedadInstance() == null || this.getLogEstadoDocNovcrearpagrDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_CREAR, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_CREAR_LOGESTADODOCNOVCREARPAGRDOCUMENTONOVEDAD, LogEstadoDocNovConstants.SERV_ALIAS_CREAR, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_CREAR_LOGESTADODOCNOVCREARPAGRDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public String getLogEstadoDocNovcrearpatrNombreFuncionario() {
        return this.logEstadoDocNovcrearpatrNombreFuncionario;
    }
    
    public void setLogEstadoDocNovcrearpatrNombreFuncionario(String logEstadoDocNovcrearpatrNombreFuncionario) {
        this.logEstadoDocNovcrearpatrNombreFuncionario = logEstadoDocNovcrearpatrNombreFuncionario;
    }

    private void checkLogEstadoDocNovcrearpatrNombreFuncionario() throws NotNullArgumentException {
        if(this.getLogEstadoDocNovcrearpatrNombreFuncionario() == null) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_CREAR, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_CREAR_LOGESTADODOCNOVCREARPATRNOMBREFUNCIONARIO, LogEstadoDocNovConstants.SERV_ALIAS_CREAR, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_CREAR_LOGESTADODOCNOVCREARPATRNOMBREFUNCIONARIO);
        }
    }

    @JsonIgnore
    public Long getLogEstadoDocNovcrearpatrEstadoAnterior() {
        return this.logEstadoDocNovcrearpatrEstadoAnterior;
    }
    
    public void setLogEstadoDocNovcrearpatrEstadoAnterior(Long logEstadoDocNovcrearpatrEstadoAnterior) {
        this.logEstadoDocNovcrearpatrEstadoAnterior = logEstadoDocNovcrearpatrEstadoAnterior;
    }

    private void checkLogEstadoDocNovcrearpatrEstadoAnterior() throws NotNullArgumentException {
        if(this.getLogEstadoDocNovcrearpatrEstadoAnterior() == null) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_CREAR, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_CREAR_LOGESTADODOCNOVCREARPATRESTADOANTERIOR, LogEstadoDocNovConstants.SERV_ALIAS_CREAR, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_CREAR_LOGESTADODOCNOVCREARPATRESTADOANTERIOR);
        }
    }

    @JsonIgnore
    public Long getLogEstadoDocNovcrearpatrEstadoNuevo() {
        return this.logEstadoDocNovcrearpatrEstadoNuevo;
    }
    
    public void setLogEstadoDocNovcrearpatrEstadoNuevo(Long logEstadoDocNovcrearpatrEstadoNuevo) {
        this.logEstadoDocNovcrearpatrEstadoNuevo = logEstadoDocNovcrearpatrEstadoNuevo;
    }

    private void checkLogEstadoDocNovcrearpatrEstadoNuevo() throws NotNullArgumentException {
        if(this.getLogEstadoDocNovcrearpatrEstadoNuevo() == null) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_CREAR, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_CREAR_LOGESTADODOCNOVCREARPATRESTADONUEVO, LogEstadoDocNovConstants.SERV_ALIAS_CREAR, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_CREAR_LOGESTADODOCNOVCREARPATRESTADONUEVO);
        }
    }

    @JsonIgnore
    public String getLogEstadoDocNovcrearpatrObservacions() {
        return this.logEstadoDocNovcrearpatrObservacions;
    }
    
    public void setLogEstadoDocNovcrearpatrObservacions(String logEstadoDocNovcrearpatrObservacions) {
        this.logEstadoDocNovcrearpatrObservacions = logEstadoDocNovcrearpatrObservacions;
    }
}
