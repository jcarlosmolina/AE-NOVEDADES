package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class AsignarFUGRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadasignarFUGpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadasignarFUGpthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadasignarFUGpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadasignarFUGpthisSolicitudNovedad() {
        return this.solicitudNovedadasignarFUGpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadasignarFUGpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadasignarFUGpthisSolicitudNovedad) {
        this.solicitudNovedadasignarFUGpthisSolicitudNovedad = solicitudNovedadasignarFUGpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadasignarFUGpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadasignarFUGpthisSolicitudNovedad) {
        this.solicitudNovedadasignarFUGpthisSolicitudNovedadInstance = solicitudNovedadasignarFUGpthisSolicitudNovedad;
        this.solicitudNovedadasignarFUGpthisSolicitudNovedad = solicitudNovedadasignarFUGpthisSolicitudNovedad != null ? solicitudNovedadasignarFUGpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadasignarFUGpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ASIGNARFUG, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ASIGNARFUG_SOLICITUDNOVEDADASIGNARFUGPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_ASIGNARFUG, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ASIGNARFUG_SOLICITUDNOVEDADASIGNARFUGPTHISSOLICITUDNOVEDAD);
        }
    }
}
