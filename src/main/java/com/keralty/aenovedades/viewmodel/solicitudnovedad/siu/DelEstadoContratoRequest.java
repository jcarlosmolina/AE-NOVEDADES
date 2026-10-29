package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelEstadoContratoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadDelEstadoContratopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance;

    @JsonProperty("p_evcestadocontrato_oid")
    private EstadoContratoOid solicitudNovedadDelEstadoContratopevcEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato solicitudNovedadDelEstadoContratopevcEstadoContratoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadDelEstadoContratopthisSolicitudNovedad();
        checkSolicitudNovedadDelEstadoContratopevcEstadoContrato();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadDelEstadoContratopthisSolicitudNovedad() {
        return this.solicitudNovedadDelEstadoContratopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadDelEstadoContratopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadDelEstadoContratopthisSolicitudNovedad) {
        this.solicitudNovedadDelEstadoContratopthisSolicitudNovedad = solicitudNovedadDelEstadoContratopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadDelEstadoContratopthisSolicitudNovedad) {
        this.solicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance = solicitudNovedadDelEstadoContratopthisSolicitudNovedad;
        this.solicitudNovedadDelEstadoContratopthisSolicitudNovedad = solicitudNovedadDelEstadoContratopthisSolicitudNovedad != null ? solicitudNovedadDelEstadoContratopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadDelEstadoContratopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELESTADOCONTRATO_SOLICITUDNOVEDADDELESTADOCONTRATOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DELESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELESTADOCONTRATO_SOLICITUDNOVEDADDELESTADOCONTRATOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public EstadoContratoOid getSolicitudNovedadDelEstadoContratopevcEstadoContrato() {
        return this.solicitudNovedadDelEstadoContratopevcEstadoContrato;
    }
    
    public void setSolicitudNovedadDelEstadoContratopevcEstadoContrato(EstadoContratoOid solicitudNovedadDelEstadoContratopevcEstadoContrato) {
        this.solicitudNovedadDelEstadoContratopevcEstadoContrato = solicitudNovedadDelEstadoContratopevcEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getSolicitudNovedadDelEstadoContratopevcEstadoContratoInstance() {
        return this.solicitudNovedadDelEstadoContratopevcEstadoContratoInstance;
    }
    
    public void setSolicitudNovedadDelEstadoContratopevcEstadoContratoInstance(EstadoContrato solicitudNovedadDelEstadoContratopevcEstadoContrato) {
        this.solicitudNovedadDelEstadoContratopevcEstadoContratoInstance = solicitudNovedadDelEstadoContratopevcEstadoContrato;
        this.solicitudNovedadDelEstadoContratopevcEstadoContrato = solicitudNovedadDelEstadoContratopevcEstadoContrato != null ? solicitudNovedadDelEstadoContratopevcEstadoContrato.getOid() : null;
    }

    private void checkSolicitudNovedadDelEstadoContratopevcEstadoContrato() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelEstadoContratopevcEstadoContratoInstance() == null || this.getSolicitudNovedadDelEstadoContratopevcEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELESTADOCONTRATO_SOLICITUDNOVEDADDELESTADOCONTRATOPEVCESTADOCONTRATO, SolicitudNovedadConstants.SERV_ALIAS_DELESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELESTADOCONTRATO_SOLICITUDNOVEDADDELESTADOCONTRATOPEVCESTADOCONTRATO);
        }
    }
}
