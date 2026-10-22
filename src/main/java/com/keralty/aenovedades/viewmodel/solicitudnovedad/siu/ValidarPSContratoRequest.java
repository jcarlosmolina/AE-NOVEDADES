package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ValidarPSContratoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadvalidarPSContratopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadvalidarPSContratopthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadvalidarPSContratopthisSolicitudNovedad() {
        return this.solicitudNovedadvalidarPSContratopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadvalidarPSContratopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadvalidarPSContratopthisSolicitudNovedad) {
        this.solicitudNovedadvalidarPSContratopthisSolicitudNovedad = solicitudNovedadvalidarPSContratopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadvalidarPSContratopthisSolicitudNovedad) {
        this.solicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance = solicitudNovedadvalidarPSContratopthisSolicitudNovedad;
        this.solicitudNovedadvalidarPSContratopthisSolicitudNovedad = solicitudNovedadvalidarPSContratopthisSolicitudNovedad != null ? solicitudNovedadvalidarPSContratopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadvalidarPSContratopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_VALIDARPSCONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_VALIDARPSCONTRATO_SOLICITUDNOVEDADVALIDARPSCONTRATOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_VALIDARPSCONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_VALIDARPSCONTRATO_SOLICITUDNOVEDADVALIDARPSCONTRATOPTHISSOLICITUDNOVEDAD);
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
