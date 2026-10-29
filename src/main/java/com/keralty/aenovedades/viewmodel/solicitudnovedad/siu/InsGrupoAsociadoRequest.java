package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.oid.GrupoAsociadoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsGrupoAsociadoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance;

    @JsonProperty("p_evcgrupoasociado_oid")
    private GrupoAsociadoOid solicitudNovedadInsGrupoAsociadopevcGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedad();
        checkSolicitudNovedadInsGrupoAsociadopevcGrupoAsociado();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedad() {
        return this.solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad) {
        this.solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad = solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad) {
        this.solicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance = solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad;
        this.solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad = solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad != null ? solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSGRUPOASOCIADO_SOLICITUDNOVEDADINSGRUPOASOCIADOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_INSGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSGRUPOASOCIADO_SOLICITUDNOVEDADINSGRUPOASOCIADOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudNovedadInsGrupoAsociadopevcGrupoAsociado() {
        return this.solicitudNovedadInsGrupoAsociadopevcGrupoAsociado;
    }
    
    public void setSolicitudNovedadInsGrupoAsociadopevcGrupoAsociado(GrupoAsociadoOid solicitudNovedadInsGrupoAsociadopevcGrupoAsociado) {
        this.solicitudNovedadInsGrupoAsociadopevcGrupoAsociado = solicitudNovedadInsGrupoAsociadopevcGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance() {
        return this.solicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance;
    }
    
    public void setSolicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance(GrupoAsociado solicitudNovedadInsGrupoAsociadopevcGrupoAsociado) {
        this.solicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance = solicitudNovedadInsGrupoAsociadopevcGrupoAsociado;
        this.solicitudNovedadInsGrupoAsociadopevcGrupoAsociado = solicitudNovedadInsGrupoAsociadopevcGrupoAsociado != null ? solicitudNovedadInsGrupoAsociadopevcGrupoAsociado.getOid() : null;
    }

    private void checkSolicitudNovedadInsGrupoAsociadopevcGrupoAsociado() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance() == null || this.getSolicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSGRUPOASOCIADO_SOLICITUDNOVEDADINSGRUPOASOCIADOPEVCGRUPOASOCIADO, SolicitudNovedadConstants.SERV_ALIAS_INSGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSGRUPOASOCIADO_SOLICITUDNOVEDADINSGRUPOASOCIADOPEVCGRUPOASOCIADO);
        }
    }
}
