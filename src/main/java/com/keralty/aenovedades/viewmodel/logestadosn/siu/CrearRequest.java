package com.keralty.aenovedades.viewmodel.logestadosn.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.LogEstadoSNConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class CrearRequest {

    @JsonProperty("p_agrsolicitudnovedad_oid")
    private SolicitudNovedadOid logEstadoSNcrearpagrSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad logEstadoSNcrearpagrSolicitudNovedadInstance;

    @JsonProperty("p_atrloginfuncionario")
    private String logEstadoSNcrearpatrLoginFuncionario;

    @JsonProperty("p_atrestado")
    private Long logEstadoSNcrearpatrEstado;

    @JsonProperty("p_atrestadodoc")
    private Long logEstadoSNcrearpatrEstadoDoc;

    public void checkArguments() throws NotNullArgumentException {
        checkLogEstadoSNcrearpagrSolicitudNovedad();
        checkLogEstadoSNcrearpatrLoginFuncionario();
        checkLogEstadoSNcrearpatrEstado();
        checkLogEstadoSNcrearpatrEstadoDoc();
    }

    @JsonIgnore
    public SolicitudNovedadOid getLogEstadoSNcrearpagrSolicitudNovedad() {
        return this.logEstadoSNcrearpagrSolicitudNovedad;
    }
    
    public void setLogEstadoSNcrearpagrSolicitudNovedad(SolicitudNovedadOid logEstadoSNcrearpagrSolicitudNovedad) {
        this.logEstadoSNcrearpagrSolicitudNovedad = logEstadoSNcrearpagrSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getLogEstadoSNcrearpagrSolicitudNovedadInstance() {
        return this.logEstadoSNcrearpagrSolicitudNovedadInstance;
    }
    
    public void setLogEstadoSNcrearpagrSolicitudNovedadInstance(SolicitudNovedad logEstadoSNcrearpagrSolicitudNovedad) {
        this.logEstadoSNcrearpagrSolicitudNovedadInstance = logEstadoSNcrearpagrSolicitudNovedad;
        this.logEstadoSNcrearpagrSolicitudNovedad = logEstadoSNcrearpagrSolicitudNovedad != null ? logEstadoSNcrearpagrSolicitudNovedad.getOid() : null;
    }

    private void checkLogEstadoSNcrearpagrSolicitudNovedad() throws NotNullArgumentException {
        if(this.getLogEstadoSNcrearpagrSolicitudNovedadInstance() == null || this.getLogEstadoSNcrearpagrSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_CREAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_CREAR_LOGESTADOSNCREARPAGRSOLICITUDNOVEDAD, LogEstadoSNConstants.SERV_ALIAS_CREAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_CREAR_LOGESTADOSNCREARPAGRSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getLogEstadoSNcrearpatrLoginFuncionario() {
        return this.logEstadoSNcrearpatrLoginFuncionario;
    }
    
    public void setLogEstadoSNcrearpatrLoginFuncionario(String logEstadoSNcrearpatrLoginFuncionario) {
        this.logEstadoSNcrearpatrLoginFuncionario = logEstadoSNcrearpatrLoginFuncionario;
    }

    private void checkLogEstadoSNcrearpatrLoginFuncionario() throws NotNullArgumentException {
        if(this.getLogEstadoSNcrearpatrLoginFuncionario() == null) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_CREAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_CREAR_LOGESTADOSNCREARPATRLOGINFUNCIONARIO, LogEstadoSNConstants.SERV_ALIAS_CREAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_CREAR_LOGESTADOSNCREARPATRLOGINFUNCIONARIO);
        }
    }

    @JsonIgnore
    public Long getLogEstadoSNcrearpatrEstado() {
        return this.logEstadoSNcrearpatrEstado;
    }
    
    public void setLogEstadoSNcrearpatrEstado(Long logEstadoSNcrearpatrEstado) {
        this.logEstadoSNcrearpatrEstado = logEstadoSNcrearpatrEstado;
    }

    private void checkLogEstadoSNcrearpatrEstado() throws NotNullArgumentException {
        if(this.getLogEstadoSNcrearpatrEstado() == null) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_CREAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_CREAR_LOGESTADOSNCREARPATRESTADO, LogEstadoSNConstants.SERV_ALIAS_CREAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_CREAR_LOGESTADOSNCREARPATRESTADO);
        }
    }

    @JsonIgnore
    public Long getLogEstadoSNcrearpatrEstadoDoc() {
        return this.logEstadoSNcrearpatrEstadoDoc;
    }
    
    public void setLogEstadoSNcrearpatrEstadoDoc(Long logEstadoSNcrearpatrEstadoDoc) {
        this.logEstadoSNcrearpatrEstadoDoc = logEstadoSNcrearpatrEstadoDoc;
    }

    private void checkLogEstadoSNcrearpatrEstadoDoc() throws NotNullArgumentException {
        if(this.getLogEstadoSNcrearpatrEstadoDoc() == null) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_CREAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_CREAR_LOGESTADOSNCREARPATRESTADODOC, LogEstadoSNConstants.SERV_ALIAS_CREAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_CREAR_LOGESTADOSNCREARPATRESTADODOC);
        }
    }
}
