package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ValidarASRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadvalidarASpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadvalidarASpthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadvalidarASpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadvalidarASpthisSolicitudNovedad() {
        return this.solicitudNovedadvalidarASpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadvalidarASpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadvalidarASpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarASpthisSolicitudNovedad = solicitudNovedadvalidarASpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadvalidarASpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadvalidarASpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadvalidarASpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadvalidarASpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarASpthisSolicitudNovedadInstance = solicitudNovedadvalidarASpthisSolicitudNovedad;
        this.solicitudNovedadvalidarASpthisSolicitudNovedad = solicitudNovedadvalidarASpthisSolicitudNovedad != null ? solicitudNovedadvalidarASpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadvalidarASpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadvalidarASpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadvalidarASpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_VALIDARAS, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_VALIDARAS_SOLICITUDNOVEDADVALIDARASPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_VALIDARAS, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_VALIDARAS_SOLICITUDNOVEDADVALIDARASPTHISSOLICITUDNOVEDAD);
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
