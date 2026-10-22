package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class MarcarCompletadaRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadmarcarCompletadapthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadmarcarCompletadapthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadmarcarCompletadapthisSolicitudNovedad() {
        return this.solicitudNovedadmarcarCompletadapthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadmarcarCompletadapthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadmarcarCompletadapthisSolicitudNovedad) {
        this.solicitudNovedadmarcarCompletadapthisSolicitudNovedad = solicitudNovedadmarcarCompletadapthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance() {
        return this.solicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadmarcarCompletadapthisSolicitudNovedad) {
        this.solicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance = solicitudNovedadmarcarCompletadapthisSolicitudNovedad;
        this.solicitudNovedadmarcarCompletadapthisSolicitudNovedad = solicitudNovedadmarcarCompletadapthisSolicitudNovedad != null ? solicitudNovedadmarcarCompletadapthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadmarcarCompletadapthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_MARCARCOMPLETADA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_MARCARCOMPLETADA_SOLICITUDNOVEDADMARCARCOMPLETADAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_MARCARCOMPLETADA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_MARCARCOMPLETADA_SOLICITUDNOVEDADMARCARCOMPLETADAPTHISSOLICITUDNOVEDAD);
        }
    }
}
