package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class AsignarFARequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadasignarFApthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadasignarFApthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadasignarFApthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadasignarFApthisSolicitudNovedad() {
        return this.solicitudNovedadasignarFApthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadasignarFApthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadasignarFApthisSolicitudNovedad) {
        this.solicitudNovedadasignarFApthisSolicitudNovedad = solicitudNovedadasignarFApthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadasignarFApthisSolicitudNovedadInstance() {
        return this.solicitudNovedadasignarFApthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadasignarFApthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadasignarFApthisSolicitudNovedad) {
        this.solicitudNovedadasignarFApthisSolicitudNovedadInstance = solicitudNovedadasignarFApthisSolicitudNovedad;
        this.solicitudNovedadasignarFApthisSolicitudNovedad = solicitudNovedadasignarFApthisSolicitudNovedad != null ? solicitudNovedadasignarFApthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadasignarFApthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadasignarFApthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadasignarFApthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ASIGNARFA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ASIGNARFA_SOLICITUDNOVEDADASIGNARFAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_ASIGNARFA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ASIGNARFA_SOLICITUDNOVEDADASIGNARFAPTHISSOLICITUDNOVEDAD);
        }
    }
}
