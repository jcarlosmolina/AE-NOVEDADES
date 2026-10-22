package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TMARCARTRAMITADARequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad() {
        return this.solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad) {
        this.solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad = solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad) {
        this.solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance = solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad;
        this.solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad = solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad != null ? solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TMARCARTRAMITADA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TMARCARTRAMITADA_SOLICITUDNOVEDADTMARCARTRAMITADAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TMARCARTRAMITADA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TMARCARTRAMITADA_SOLICITUDNOVEDADTMARCARTRAMITADAPTHISSOLICITUDNOVEDAD);
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
