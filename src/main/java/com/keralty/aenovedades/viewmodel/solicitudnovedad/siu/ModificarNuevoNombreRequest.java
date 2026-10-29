package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class ModificarNuevoNombreRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance;

    @JsonProperty("p_contranuevarazonsocial")
    private String solicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad();
        checkSolicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad() {
        return this.solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad) {
        this.solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad = solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance() {
        return this.solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad) {
        this.solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance = solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad;
        this.solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad = solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad != null ? solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_MODIFICARNUEVONOMBRE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_MODIFICARNUEVONOMBRE_SOLICITUDNOVEDADMODIFICARNUEVONOMBREPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_MODIFICARNUEVONOMBRE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_MODIFICARNUEVONOMBRE_SOLICITUDNOVEDADMODIFICARNUEVONOMBREPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial() {
        return this.solicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial;
    }
    
    public void setSolicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial(String solicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial) {
        this.solicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial = solicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial;
    }

    private void checkSolicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial() throws NotNullArgumentException {
        if(this.getSolicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_MODIFICARNUEVONOMBRE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_MODIFICARNUEVONOMBRE_SOLICITUDNOVEDADMODIFICARNUEVONOMBREPCONTRANUEVARAZONSOCIAL, SolicitudNovedadConstants.SERV_ALIAS_MODIFICARNUEVONOMBRE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_MODIFICARNUEVONOMBRE_SOLICITUDNOVEDADMODIFICARNUEVONOMBREPCONTRANUEVARAZONSOCIAL);
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
