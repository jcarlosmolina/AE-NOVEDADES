package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TMARCARANULADARequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTMARCARANULADApthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTMARCARANULADApthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTMARCARANULADApthisSolicitudNovedad() {
        return this.solicitudNovedadTMARCARANULADApthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTMARCARANULADApthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTMARCARANULADApthisSolicitudNovedad) {
        this.solicitudNovedadTMARCARANULADApthisSolicitudNovedad = solicitudNovedadTMARCARANULADApthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTMARCARANULADApthisSolicitudNovedad) {
        this.solicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance = solicitudNovedadTMARCARANULADApthisSolicitudNovedad;
        this.solicitudNovedadTMARCARANULADApthisSolicitudNovedad = solicitudNovedadTMARCARANULADApthisSolicitudNovedad != null ? solicitudNovedadTMARCARANULADApthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTMARCARANULADApthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TMARCARANULADA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TMARCARANULADA_SOLICITUDNOVEDADTMARCARANULADAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TMARCARANULADA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TMARCARANULADA_SOLICITUDNOVEDADTMARCARANULADAPTHISSOLICITUDNOVEDAD);
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
