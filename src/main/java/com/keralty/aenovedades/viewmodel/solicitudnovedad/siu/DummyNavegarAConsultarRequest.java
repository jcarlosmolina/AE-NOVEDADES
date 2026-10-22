package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DummyNavegarAConsultarRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad() {
        return this.solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad) {
        this.solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad = solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance() {
        return this.solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad) {
        this.solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance = solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad;
        this.solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad = solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad != null ? solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DUMMYNAVEGARACONSULTAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DUMMYNAVEGARACONSULTAR_SOLICITUDNOVEDADDUMMYNAVEGARACONSULTARPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DUMMYNAVEGARACONSULTAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DUMMYNAVEGARACONSULTAR_SOLICITUDNOVEDADDUMMYNAVEGARACONSULTARPTHISSOLICITUDNOVEDAD);
        }
    }
}
