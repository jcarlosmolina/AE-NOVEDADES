package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ValidarPPRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadvalidarPPpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadvalidarPPpthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadvalidarPPpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadvalidarPPpthisSolicitudNovedad() {
        return this.solicitudNovedadvalidarPPpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadvalidarPPpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadvalidarPPpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarPPpthisSolicitudNovedad = solicitudNovedadvalidarPPpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadvalidarPPpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadvalidarPPpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarPPpthisSolicitudNovedadInstance = solicitudNovedadvalidarPPpthisSolicitudNovedad;
        this.solicitudNovedadvalidarPPpthisSolicitudNovedad = solicitudNovedadvalidarPPpthisSolicitudNovedad != null ? solicitudNovedadvalidarPPpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadvalidarPPpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_VALIDARPP, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_VALIDARPP_SOLICITUDNOVEDADVALIDARPPPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_VALIDARPP, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_VALIDARPP_SOLICITUDNOVEDADVALIDARPPPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
