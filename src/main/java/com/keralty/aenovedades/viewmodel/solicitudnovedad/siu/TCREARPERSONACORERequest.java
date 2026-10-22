package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TCREARPERSONACORERequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance;

    @JsonProperty("ptnovedadct_oid")
    private NovedadCTOid solicitudNovedadTCREARPERSONACOREptNovedadCT;
    
    @JsonIgnore
    private NovedadCT solicitudNovedadTCREARPERSONACOREptNovedadCTInstance;

    @JsonProperty("ptnumerrores")
    private Long solicitudNovedadTCREARPERSONACOREptNumErrores;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad();
        checkSolicitudNovedadTCREARPERSONACOREptNovedadCT();
        checkSolicitudNovedadTCREARPERSONACOREptNumErrores();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad() {
        return this.solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad) {
        this.solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad = solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad) {
        this.solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance = solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad;
        this.solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad = solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad != null ? solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARPERSONACORE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARPERSONACORE_SOLICITUDNOVEDADTCREARPERSONACOREPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCREARPERSONACORE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARPERSONACORE_SOLICITUDNOVEDADTCREARPERSONACOREPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public NovedadCTOid getSolicitudNovedadTCREARPERSONACOREptNovedadCT() {
        return this.solicitudNovedadTCREARPERSONACOREptNovedadCT;
    }
    
    public void setSolicitudNovedadTCREARPERSONACOREptNovedadCT(NovedadCTOid solicitudNovedadTCREARPERSONACOREptNovedadCT) {
        this.solicitudNovedadTCREARPERSONACOREptNovedadCT = solicitudNovedadTCREARPERSONACOREptNovedadCT;
    }

    @JsonIgnore
    public NovedadCT getSolicitudNovedadTCREARPERSONACOREptNovedadCTInstance() {
        return this.solicitudNovedadTCREARPERSONACOREptNovedadCTInstance;
    }
    
    public void setSolicitudNovedadTCREARPERSONACOREptNovedadCTInstance(NovedadCT solicitudNovedadTCREARPERSONACOREptNovedadCT) {
        this.solicitudNovedadTCREARPERSONACOREptNovedadCTInstance = solicitudNovedadTCREARPERSONACOREptNovedadCT;
        this.solicitudNovedadTCREARPERSONACOREptNovedadCT = solicitudNovedadTCREARPERSONACOREptNovedadCT != null ? solicitudNovedadTCREARPERSONACOREptNovedadCT.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARPERSONACOREptNovedadCT() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARPERSONACOREptNovedadCTInstance() == null || this.getSolicitudNovedadTCREARPERSONACOREptNovedadCTInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARPERSONACORE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARPERSONACORE_SOLICITUDNOVEDADTCREARPERSONACOREPTNOVEDADCT, SolicitudNovedadConstants.SERV_ALIAS_TCREARPERSONACORE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARPERSONACORE_SOLICITUDNOVEDADTCREARPERSONACOREPTNOVEDADCT);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadTCREARPERSONACOREptNumErrores() {
        return this.solicitudNovedadTCREARPERSONACOREptNumErrores;
    }
    
    public void setSolicitudNovedadTCREARPERSONACOREptNumErrores(Long solicitudNovedadTCREARPERSONACOREptNumErrores) {
        this.solicitudNovedadTCREARPERSONACOREptNumErrores = solicitudNovedadTCREARPERSONACOREptNumErrores;
    }

    private void checkSolicitudNovedadTCREARPERSONACOREptNumErrores() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARPERSONACOREptNumErrores() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARPERSONACORE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARPERSONACORE_SOLICITUDNOVEDADTCREARPERSONACOREPTNUMERRORES, SolicitudNovedadConstants.SERV_ALIAS_TCREARPERSONACORE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARPERSONACORE_SOLICITUDNOVEDADTCREARPERSONACOREPTNUMERRORES);
        }
    }
}
