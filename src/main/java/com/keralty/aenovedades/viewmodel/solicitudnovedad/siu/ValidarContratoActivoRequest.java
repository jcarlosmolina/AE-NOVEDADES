package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ValidarContratoActivoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadvalidarContratoActivopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadvalidarContratoActivopthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadvalidarContratoActivopthisSolicitudNovedad() {
        return this.solicitudNovedadvalidarContratoActivopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadvalidarContratoActivopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadvalidarContratoActivopthisSolicitudNovedad) {
        this.solicitudNovedadvalidarContratoActivopthisSolicitudNovedad = solicitudNovedadvalidarContratoActivopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadvalidarContratoActivopthisSolicitudNovedad) {
        this.solicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance = solicitudNovedadvalidarContratoActivopthisSolicitudNovedad;
        this.solicitudNovedadvalidarContratoActivopthisSolicitudNovedad = solicitudNovedadvalidarContratoActivopthisSolicitudNovedad != null ? solicitudNovedadvalidarContratoActivopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadvalidarContratoActivopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_VALIDARCONTRATOACTIVO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_VALIDARCONTRATOACTIVO_SOLICITUDNOVEDADVALIDARCONTRATOACTIVOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_VALIDARCONTRATOACTIVO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_VALIDARCONTRATOACTIVO_SOLICITUDNOVEDADVALIDARCONTRATOACTIVOPTHISSOLICITUDNOVEDAD);
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
