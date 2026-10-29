package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class AsignarFechaTerminadaRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedad() {
        return this.solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad) {
        this.solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad = solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance() {
        return this.solicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad) {
        this.solicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance = solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad;
        this.solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad = solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad != null ? solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ASIGNARFECHATERMINADA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ASIGNARFECHATERMINADA_SOLICITUDNOVEDADASIGNARFECHATERMINADAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_ASIGNARFECHATERMINADA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ASIGNARFECHATERMINADA_SOLICITUDNOVEDADASIGNARFECHATERMINADAPTHISSOLICITUDNOVEDAD);
        }
    }
}
