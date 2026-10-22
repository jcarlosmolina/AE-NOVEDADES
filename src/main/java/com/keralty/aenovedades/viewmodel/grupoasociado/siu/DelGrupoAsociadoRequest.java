package com.keralty.aenovedades.viewmodel.grupoasociado.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.GrupoAsociadoConstants;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.oid.GrupoAsociadoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelGrupoAsociadoRequest {

    @JsonProperty("p_thisgrupoasociado_oid")
    private GrupoAsociadoOid grupoAsociadoDelGrupoAsociadopthisGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado grupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad grupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkGrupoAsociadoDelGrupoAsociadopthisGrupoAsociado();
        checkGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedad();
    }

    @JsonIgnore
    public GrupoAsociadoOid getGrupoAsociadoDelGrupoAsociadopthisGrupoAsociado() {
        return this.grupoAsociadoDelGrupoAsociadopthisGrupoAsociado;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadopthisGrupoAsociado(GrupoAsociadoOid grupoAsociadoDelGrupoAsociadopthisGrupoAsociado) {
        this.grupoAsociadoDelGrupoAsociadopthisGrupoAsociado = grupoAsociadoDelGrupoAsociadopthisGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getGrupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance() {
        return this.grupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance(GrupoAsociado grupoAsociadoDelGrupoAsociadopthisGrupoAsociado) {
        this.grupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance = grupoAsociadoDelGrupoAsociadopthisGrupoAsociado;
        this.grupoAsociadoDelGrupoAsociadopthisGrupoAsociado = grupoAsociadoDelGrupoAsociadopthisGrupoAsociado != null ? grupoAsociadoDelGrupoAsociadopthisGrupoAsociado.getOid() : null;
    }

    private void checkGrupoAsociadoDelGrupoAsociadopthisGrupoAsociado() throws NotNullArgumentException {
        if(this.getGrupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance() == null || this.getGrupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_DELGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_DELGRUPOASOCIADO_GRUPOASOCIADODELGRUPOASOCIADOPTHISGRUPOASOCIADO, GrupoAsociadoConstants.SERV_ALIAS_DELGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_DELGRUPOASOCIADO_GRUPOASOCIADODELGRUPOASOCIADOPTHISGRUPOASOCIADO);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedad() {
        return this.grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedad(SolicitudNovedadOid grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad) {
        this.grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad = grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance() {
        return this.grupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance(SolicitudNovedad grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad) {
        this.grupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance = grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad;
        this.grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad = grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad != null ? grupoAsociadoDelGrupoAsociadopevcSolicitudNovedad.getOid() : null;
    }

    private void checkGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance() == null || this.getGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_DELGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_DELGRUPOASOCIADO_GRUPOASOCIADODELGRUPOASOCIADOPEVCSOLICITUDNOVEDAD, GrupoAsociadoConstants.SERV_ALIAS_DELGRUPOASOCIADO, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_DELGRUPOASOCIADO_GRUPOASOCIADODELGRUPOASOCIADOPEVCSOLICITUDNOVEDAD);
        }
    }
}
