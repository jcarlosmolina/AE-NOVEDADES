package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TADDFAMILIARequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTADDFAMILIApthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance;

    @JsonProperty("ptnumfamilia")
    private Long solicitudNovedadTADDFAMILIAptNumFamilia;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTADDFAMILIApthisSolicitudNovedad();
        checkSolicitudNovedadTADDFAMILIAptNumFamilia();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTADDFAMILIApthisSolicitudNovedad() {
        return this.solicitudNovedadTADDFAMILIApthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTADDFAMILIApthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTADDFAMILIApthisSolicitudNovedad) {
        this.solicitudNovedadTADDFAMILIApthisSolicitudNovedad = solicitudNovedadTADDFAMILIApthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTADDFAMILIApthisSolicitudNovedad) {
        this.solicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance = solicitudNovedadTADDFAMILIApthisSolicitudNovedad;
        this.solicitudNovedadTADDFAMILIApthisSolicitudNovedad = solicitudNovedadTADDFAMILIApthisSolicitudNovedad != null ? solicitudNovedadTADDFAMILIApthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTADDFAMILIApthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TADDFAMILIA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TADDFAMILIA_SOLICITUDNOVEDADTADDFAMILIAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TADDFAMILIA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TADDFAMILIA_SOLICITUDNOVEDADTADDFAMILIAPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadTADDFAMILIAptNumFamilia() {
        return this.solicitudNovedadTADDFAMILIAptNumFamilia;
    }
    
    public void setSolicitudNovedadTADDFAMILIAptNumFamilia(Long solicitudNovedadTADDFAMILIAptNumFamilia) {
        this.solicitudNovedadTADDFAMILIAptNumFamilia = solicitudNovedadTADDFAMILIAptNumFamilia;
    }

    private void checkSolicitudNovedadTADDFAMILIAptNumFamilia() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTADDFAMILIAptNumFamilia() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TADDFAMILIA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TADDFAMILIA_SOLICITUDNOVEDADTADDFAMILIAPTNUMFAMILIA, SolicitudNovedadConstants.SERV_ALIAS_TADDFAMILIA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TADDFAMILIA_SOLICITUDNOVEDADTADDFAMILIAPTNUMFAMILIA);
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
