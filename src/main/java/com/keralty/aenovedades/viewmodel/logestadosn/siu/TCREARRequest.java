package com.keralty.aenovedades.viewmodel.logestadosn.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.LogEstadoSNConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TCREARRequest {

    @JsonProperty("pt_p_agrsolicitudnovedad_oid")
    private SolicitudNovedadOid logEstadoSNTCREARptpagrSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad logEstadoSNTCREARptpagrSolicitudNovedadInstance;

    @JsonProperty("pt_p_atrestado")
    private Long logEstadoSNTCREARptpatrEstado;

    @JsonProperty("pt_p_atrestadodoc")
    private Long logEstadoSNTCREARptpatrEstadoDoc;

    public void checkArguments() throws NotNullArgumentException {
        checkLogEstadoSNTCREARptpagrSolicitudNovedad();
        checkLogEstadoSNTCREARptpatrEstado();
        checkLogEstadoSNTCREARptpatrEstadoDoc();
    }

    @JsonIgnore
    public SolicitudNovedadOid getLogEstadoSNTCREARptpagrSolicitudNovedad() {
        return this.logEstadoSNTCREARptpagrSolicitudNovedad;
    }
    
    public void setLogEstadoSNTCREARptpagrSolicitudNovedad(SolicitudNovedadOid logEstadoSNTCREARptpagrSolicitudNovedad) {
        this.logEstadoSNTCREARptpagrSolicitudNovedad = logEstadoSNTCREARptpagrSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getLogEstadoSNTCREARptpagrSolicitudNovedadInstance() {
        return this.logEstadoSNTCREARptpagrSolicitudNovedadInstance;
    }
    
    public void setLogEstadoSNTCREARptpagrSolicitudNovedadInstance(SolicitudNovedad logEstadoSNTCREARptpagrSolicitudNovedad) {
        this.logEstadoSNTCREARptpagrSolicitudNovedadInstance = logEstadoSNTCREARptpagrSolicitudNovedad;
        this.logEstadoSNTCREARptpagrSolicitudNovedad = logEstadoSNTCREARptpagrSolicitudNovedad != null ? logEstadoSNTCREARptpagrSolicitudNovedad.getOid() : null;
    }

    private void checkLogEstadoSNTCREARptpagrSolicitudNovedad() throws NotNullArgumentException {
        if(this.getLogEstadoSNTCREARptpagrSolicitudNovedadInstance() == null || this.getLogEstadoSNTCREARptpagrSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_TCREAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_TCREAR_LOGESTADOSNTCREARPTPAGRSOLICITUDNOVEDAD, LogEstadoSNConstants.SERV_ALIAS_TCREAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_TCREAR_LOGESTADOSNTCREARPTPAGRSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getLogEstadoSNTCREARptpatrEstado() {
        return this.logEstadoSNTCREARptpatrEstado;
    }
    
    public void setLogEstadoSNTCREARptpatrEstado(Long logEstadoSNTCREARptpatrEstado) {
        this.logEstadoSNTCREARptpatrEstado = logEstadoSNTCREARptpatrEstado;
    }

    private void checkLogEstadoSNTCREARptpatrEstado() throws NotNullArgumentException {
        if(this.getLogEstadoSNTCREARptpatrEstado() == null) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_TCREAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_TCREAR_LOGESTADOSNTCREARPTPATRESTADO, LogEstadoSNConstants.SERV_ALIAS_TCREAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_TCREAR_LOGESTADOSNTCREARPTPATRESTADO);
        }
    }

    @JsonIgnore
    public Long getLogEstadoSNTCREARptpatrEstadoDoc() {
        return this.logEstadoSNTCREARptpatrEstadoDoc;
    }
    
    public void setLogEstadoSNTCREARptpatrEstadoDoc(Long logEstadoSNTCREARptpatrEstadoDoc) {
        this.logEstadoSNTCREARptpatrEstadoDoc = logEstadoSNTCREARptpatrEstadoDoc;
    }

    private void checkLogEstadoSNTCREARptpatrEstadoDoc() throws NotNullArgumentException {
        if(this.getLogEstadoSNTCREARptpatrEstadoDoc() == null) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_TCREAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_TCREAR_LOGESTADOSNTCREARPTPATRESTADODOC, LogEstadoSNConstants.SERV_ALIAS_TCREAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_TCREAR_LOGESTADOSNTCREARPTPATRESTADODOC);
        }
    }
}
