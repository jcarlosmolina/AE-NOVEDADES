package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.oid.GrupoAsociadoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelGrupoAsociadoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance;

    @JsonProperty("p_evcgrupoasociado_oid")
    private GrupoAsociadoOid solicitudNovedadDelGrupoAsociadopevcGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedad();
        checkSolicitudNovedadDelGrupoAsociadopevcGrupoAsociado();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedad() {
        return this.solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad) {
        this.solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad = solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad) {
        this.solicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance = solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad;
        this.solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad = solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad != null ? solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELGRUPOASOCIADO_SOLICITUDNOVEDADDELGRUPOASOCIADOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DELGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELGRUPOASOCIADO_SOLICITUDNOVEDADDELGRUPOASOCIADOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudNovedadDelGrupoAsociadopevcGrupoAsociado() {
        return this.solicitudNovedadDelGrupoAsociadopevcGrupoAsociado;
    }
    
    public void setSolicitudNovedadDelGrupoAsociadopevcGrupoAsociado(GrupoAsociadoOid solicitudNovedadDelGrupoAsociadopevcGrupoAsociado) {
        this.solicitudNovedadDelGrupoAsociadopevcGrupoAsociado = solicitudNovedadDelGrupoAsociadopevcGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance() {
        return this.solicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance;
    }
    
    public void setSolicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance(GrupoAsociado solicitudNovedadDelGrupoAsociadopevcGrupoAsociado) {
        this.solicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance = solicitudNovedadDelGrupoAsociadopevcGrupoAsociado;
        this.solicitudNovedadDelGrupoAsociadopevcGrupoAsociado = solicitudNovedadDelGrupoAsociadopevcGrupoAsociado != null ? solicitudNovedadDelGrupoAsociadopevcGrupoAsociado.getOid() : null;
    }

    private void checkSolicitudNovedadDelGrupoAsociadopevcGrupoAsociado() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance() == null || this.getSolicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELGRUPOASOCIADO_SOLICITUDNOVEDADDELGRUPOASOCIADOPEVCGRUPOASOCIADO, SolicitudNovedadConstants.SERV_ALIAS_DELGRUPOASOCIADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELGRUPOASOCIADO_SOLICITUDNOVEDADDELGRUPOASOCIADOPEVCGRUPOASOCIADO);
        }
    }
}
