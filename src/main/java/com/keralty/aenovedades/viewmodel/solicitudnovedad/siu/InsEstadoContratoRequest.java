package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsEstadoContratoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadInsEstadoContratopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance;

    @JsonProperty("p_evcestadocontrato_oid")
    private EstadoContratoOid solicitudNovedadInsEstadoContratopevcEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato solicitudNovedadInsEstadoContratopevcEstadoContratoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadInsEstadoContratopthisSolicitudNovedad();
        checkSolicitudNovedadInsEstadoContratopevcEstadoContrato();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadInsEstadoContratopthisSolicitudNovedad() {
        return this.solicitudNovedadInsEstadoContratopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadInsEstadoContratopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadInsEstadoContratopthisSolicitudNovedad) {
        this.solicitudNovedadInsEstadoContratopthisSolicitudNovedad = solicitudNovedadInsEstadoContratopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadInsEstadoContratopthisSolicitudNovedad) {
        this.solicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance = solicitudNovedadInsEstadoContratopthisSolicitudNovedad;
        this.solicitudNovedadInsEstadoContratopthisSolicitudNovedad = solicitudNovedadInsEstadoContratopthisSolicitudNovedad != null ? solicitudNovedadInsEstadoContratopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadInsEstadoContratopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSESTADOCONTRATO_SOLICITUDNOVEDADINSESTADOCONTRATOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_INSESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSESTADOCONTRATO_SOLICITUDNOVEDADINSESTADOCONTRATOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public EstadoContratoOid getSolicitudNovedadInsEstadoContratopevcEstadoContrato() {
        return this.solicitudNovedadInsEstadoContratopevcEstadoContrato;
    }
    
    public void setSolicitudNovedadInsEstadoContratopevcEstadoContrato(EstadoContratoOid solicitudNovedadInsEstadoContratopevcEstadoContrato) {
        this.solicitudNovedadInsEstadoContratopevcEstadoContrato = solicitudNovedadInsEstadoContratopevcEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance() {
        return this.solicitudNovedadInsEstadoContratopevcEstadoContratoInstance;
    }
    
    public void setSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance(EstadoContrato solicitudNovedadInsEstadoContratopevcEstadoContrato) {
        this.solicitudNovedadInsEstadoContratopevcEstadoContratoInstance = solicitudNovedadInsEstadoContratopevcEstadoContrato;
        this.solicitudNovedadInsEstadoContratopevcEstadoContrato = solicitudNovedadInsEstadoContratopevcEstadoContrato != null ? solicitudNovedadInsEstadoContratopevcEstadoContrato.getOid() : null;
    }

    private void checkSolicitudNovedadInsEstadoContratopevcEstadoContrato() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance() == null || this.getSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSESTADOCONTRATO_SOLICITUDNOVEDADINSESTADOCONTRATOPEVCESTADOCONTRATO, SolicitudNovedadConstants.SERV_ALIAS_INSESTADOCONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSESTADOCONTRATO_SOLICITUDNOVEDADINSESTADOCONTRATOPEVCESTADOCONTRATO);
        }
    }
}
