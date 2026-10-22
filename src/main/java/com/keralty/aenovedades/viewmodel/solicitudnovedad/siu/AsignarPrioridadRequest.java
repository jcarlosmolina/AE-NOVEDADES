package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class AsignarPrioridadRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadasignarPrioridadpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance;

    @JsonProperty("peprioridad")
    private Long solicitudNovedadasignarPrioridadpePrioridad;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadasignarPrioridadpthisSolicitudNovedad();
        checkSolicitudNovedadasignarPrioridadpePrioridad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadasignarPrioridadpthisSolicitudNovedad() {
        return this.solicitudNovedadasignarPrioridadpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadasignarPrioridadpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadasignarPrioridadpthisSolicitudNovedad) {
        this.solicitudNovedadasignarPrioridadpthisSolicitudNovedad = solicitudNovedadasignarPrioridadpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadasignarPrioridadpthisSolicitudNovedad) {
        this.solicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance = solicitudNovedadasignarPrioridadpthisSolicitudNovedad;
        this.solicitudNovedadasignarPrioridadpthisSolicitudNovedad = solicitudNovedadasignarPrioridadpthisSolicitudNovedad != null ? solicitudNovedadasignarPrioridadpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadasignarPrioridadpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ASIGNARPRIORIDAD, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ASIGNARPRIORIDAD_SOLICITUDNOVEDADASIGNARPRIORIDADPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_ASIGNARPRIORIDAD, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ASIGNARPRIORIDAD_SOLICITUDNOVEDADASIGNARPRIORIDADPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadasignarPrioridadpePrioridad() {
        return this.solicitudNovedadasignarPrioridadpePrioridad;
    }
    
    public void setSolicitudNovedadasignarPrioridadpePrioridad(Long solicitudNovedadasignarPrioridadpePrioridad) {
        this.solicitudNovedadasignarPrioridadpePrioridad = solicitudNovedadasignarPrioridadpePrioridad;
    }

    private void checkSolicitudNovedadasignarPrioridadpePrioridad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadasignarPrioridadpePrioridad() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ASIGNARPRIORIDAD, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ASIGNARPRIORIDAD_SOLICITUDNOVEDADASIGNARPRIORIDADPEPRIORIDAD, SolicitudNovedadConstants.SERV_ALIAS_ASIGNARPRIORIDAD, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ASIGNARPRIORIDAD_SOLICITUDNOVEDADASIGNARPRIORIDADPEPRIORIDAD);
        }
    }
}
