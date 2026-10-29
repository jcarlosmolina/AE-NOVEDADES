package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ValidarCRRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadvalidarCRpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadvalidarCRpthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadvalidarCRpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadvalidarCRpthisSolicitudNovedad() {
        return this.solicitudNovedadvalidarCRpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadvalidarCRpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadvalidarCRpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarCRpthisSolicitudNovedad = solicitudNovedadvalidarCRpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadvalidarCRpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadvalidarCRpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarCRpthisSolicitudNovedadInstance = solicitudNovedadvalidarCRpthisSolicitudNovedad;
        this.solicitudNovedadvalidarCRpthisSolicitudNovedad = solicitudNovedadvalidarCRpthisSolicitudNovedad != null ? solicitudNovedadvalidarCRpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadvalidarCRpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_VALIDARCR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_VALIDARCR_SOLICITUDNOVEDADVALIDARCRPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_VALIDARCR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_VALIDARCR_SOLICITUDNOVEDADVALIDARCRPTHISSOLICITUDNOVEDAD);
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
