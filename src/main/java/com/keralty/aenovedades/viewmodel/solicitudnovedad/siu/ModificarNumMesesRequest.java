package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ModificarNumMesesRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadmodificarNumMesespthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance;

    @JsonProperty("p_scnummeses")
    private Long solicitudNovedadmodificarNumMesespSCNumMeses;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadmodificarNumMesespthisSolicitudNovedad();
        checkSolicitudNovedadmodificarNumMesespSCNumMeses();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadmodificarNumMesespthisSolicitudNovedad() {
        return this.solicitudNovedadmodificarNumMesespthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadmodificarNumMesespthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadmodificarNumMesespthisSolicitudNovedad) {
        this.solicitudNovedadmodificarNumMesespthisSolicitudNovedad = solicitudNovedadmodificarNumMesespthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance() {
        return this.solicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadmodificarNumMesespthisSolicitudNovedad) {
        this.solicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance = solicitudNovedadmodificarNumMesespthisSolicitudNovedad;
        this.solicitudNovedadmodificarNumMesespthisSolicitudNovedad = solicitudNovedadmodificarNumMesespthisSolicitudNovedad != null ? solicitudNovedadmodificarNumMesespthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadmodificarNumMesespthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_MODIFICARNUMMESES, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_MODIFICARNUMMESES_SOLICITUDNOVEDADMODIFICARNUMMESESPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_MODIFICARNUMMESES, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_MODIFICARNUMMESES_SOLICITUDNOVEDADMODIFICARNUMMESESPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadmodificarNumMesespSCNumMeses() {
        return this.solicitudNovedadmodificarNumMesespSCNumMeses;
    }
    
    public void setSolicitudNovedadmodificarNumMesespSCNumMeses(Long solicitudNovedadmodificarNumMesespSCNumMeses) {
        this.solicitudNovedadmodificarNumMesespSCNumMeses = solicitudNovedadmodificarNumMesespSCNumMeses;
    }

    private void checkSolicitudNovedadmodificarNumMesespSCNumMeses() throws NotNullArgumentException {
        if(this.getSolicitudNovedadmodificarNumMesespSCNumMeses() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_MODIFICARNUMMESES, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_MODIFICARNUMMESES_SOLICITUDNOVEDADMODIFICARNUMMESESPSCNUMMESES, SolicitudNovedadConstants.SERV_ALIAS_MODIFICARNUMMESES, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_MODIFICARNUMMESES_SOLICITUDNOVEDADMODIFICARNUMMESESPSCNUMMESES);
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
