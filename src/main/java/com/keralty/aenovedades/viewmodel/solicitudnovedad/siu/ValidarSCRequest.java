package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ValidarSCRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadvalidarSCpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadvalidarSCpthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadvalidarSCpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadvalidarSCpthisSolicitudNovedad() {
        return this.solicitudNovedadvalidarSCpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadvalidarSCpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadvalidarSCpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarSCpthisSolicitudNovedad = solicitudNovedadvalidarSCpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadvalidarSCpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadvalidarSCpthisSolicitudNovedad) {
        this.solicitudNovedadvalidarSCpthisSolicitudNovedadInstance = solicitudNovedadvalidarSCpthisSolicitudNovedad;
        this.solicitudNovedadvalidarSCpthisSolicitudNovedad = solicitudNovedadvalidarSCpthisSolicitudNovedad != null ? solicitudNovedadvalidarSCpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadvalidarSCpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_VALIDARSC, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_VALIDARSC_SOLICITUDNOVEDADVALIDARSCPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_VALIDARSC, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_VALIDARSC_SOLICITUDNOVEDADVALIDARSCPTHISSOLICITUDNOVEDAD);
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
