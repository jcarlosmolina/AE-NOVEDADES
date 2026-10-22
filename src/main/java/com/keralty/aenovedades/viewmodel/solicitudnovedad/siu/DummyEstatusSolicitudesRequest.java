package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DummyEstatusSolicitudesRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad() {
        return this.solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad) {
        this.solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad = solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance() {
        return this.solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad) {
        this.solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance = solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad;
        this.solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad = solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad != null ? solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance() == null || this.getSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DUMMYESTATUSSOLICITUDES, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DUMMYESTATUSSOLICITUDES_SOLICITUDNOVEDADDUMMYESTATUSSOLICITUDESPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DUMMYESTATUSSOLICITUDES, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DUMMYESTATUSSOLICITUDES_SOLICITUDNOVEDADDUMMYESTATUSSOLICITUDESPTHISSOLICITUDNOVEDAD);
        }
    }
}
