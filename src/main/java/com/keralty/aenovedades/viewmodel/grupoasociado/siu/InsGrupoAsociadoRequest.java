package com.keralty.aenovedades.viewmodel.grupoasociado.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.GrupoAsociadoConstants;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.oid.GrupoAsociadoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsGrupoAsociadoRequest {

    @JsonProperty("p_thisgrupoasociado_oid")
    private GrupoAsociadoOid grupoAsociadoInsGrupoAsociadopthisGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado grupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad grupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkGrupoAsociadoInsGrupoAsociadopthisGrupoAsociado();
        checkGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedad();
    }

    @JsonIgnore
    public GrupoAsociadoOid getGrupoAsociadoInsGrupoAsociadopthisGrupoAsociado() {
        return this.grupoAsociadoInsGrupoAsociadopthisGrupoAsociado;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadopthisGrupoAsociado(GrupoAsociadoOid grupoAsociadoInsGrupoAsociadopthisGrupoAsociado) {
        this.grupoAsociadoInsGrupoAsociadopthisGrupoAsociado = grupoAsociadoInsGrupoAsociadopthisGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getGrupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance() {
        return this.grupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance(GrupoAsociado grupoAsociadoInsGrupoAsociadopthisGrupoAsociado) {
        this.grupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance = grupoAsociadoInsGrupoAsociadopthisGrupoAsociado;
        this.grupoAsociadoInsGrupoAsociadopthisGrupoAsociado = grupoAsociadoInsGrupoAsociadopthisGrupoAsociado != null ? grupoAsociadoInsGrupoAsociadopthisGrupoAsociado.getOid() : null;
    }

    private void checkGrupoAsociadoInsGrupoAsociadopthisGrupoAsociado() throws NotNullArgumentException {
        if(this.getGrupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance() == null || this.getGrupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_INSGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_INSGRUPOASOCIADO_GRUPOASOCIADOINSGRUPOASOCIADOPTHISGRUPOASOCIADO, GrupoAsociadoConstants.SERV_ALIAS_INSGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_INSGRUPOASOCIADO_GRUPOASOCIADOINSGRUPOASOCIADOPTHISGRUPOASOCIADO);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedad() {
        return this.grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedad(SolicitudNovedadOid grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad) {
        this.grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad = grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance() {
        return this.grupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance(SolicitudNovedad grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad) {
        this.grupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance = grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad;
        this.grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad = grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad != null ? grupoAsociadoInsGrupoAsociadopevcSolicitudNovedad.getOid() : null;
    }

    private void checkGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance() == null || this.getGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_INSGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_INSGRUPOASOCIADO_GRUPOASOCIADOINSGRUPOASOCIADOPEVCSOLICITUDNOVEDAD, GrupoAsociadoConstants.SERV_ALIAS_INSGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_INSGRUPOASOCIADO_GRUPOASOCIADOINSGRUPOASOCIADOPEVCSOLICITUDNOVEDAD);
        }
    }
}
