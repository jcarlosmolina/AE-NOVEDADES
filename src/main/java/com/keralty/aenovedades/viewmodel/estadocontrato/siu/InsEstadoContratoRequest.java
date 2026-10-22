package com.keralty.aenovedades.viewmodel.estadocontrato.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.EstadoContratoConstants;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsEstadoContratoRequest {

    @JsonProperty("p_thisestadocontrato_oid")
    private EstadoContratoOid estadoContratoInsEstadoContratopthisEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato estadoContratoInsEstadoContratopthisEstadoContratoInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid estadoContratoInsEstadoContratopevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad estadoContratoInsEstadoContratopevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoContratoInsEstadoContratopthisEstadoContrato();
        checkEstadoContratoInsEstadoContratopevcSolicitudNovedad();
    }

    @JsonIgnore
    public EstadoContratoOid getEstadoContratoInsEstadoContratopthisEstadoContrato() {
        return this.estadoContratoInsEstadoContratopthisEstadoContrato;
    }
    
    public void setEstadoContratoInsEstadoContratopthisEstadoContrato(EstadoContratoOid estadoContratoInsEstadoContratopthisEstadoContrato) {
        this.estadoContratoInsEstadoContratopthisEstadoContrato = estadoContratoInsEstadoContratopthisEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getEstadoContratoInsEstadoContratopthisEstadoContratoInstance() {
        return this.estadoContratoInsEstadoContratopthisEstadoContratoInstance;
    }
    
    public void setEstadoContratoInsEstadoContratopthisEstadoContratoInstance(EstadoContrato estadoContratoInsEstadoContratopthisEstadoContrato) {
        this.estadoContratoInsEstadoContratopthisEstadoContratoInstance = estadoContratoInsEstadoContratopthisEstadoContrato;
        this.estadoContratoInsEstadoContratopthisEstadoContrato = estadoContratoInsEstadoContratopthisEstadoContrato != null ? estadoContratoInsEstadoContratopthisEstadoContrato.getOid() : null;
    }

    private void checkEstadoContratoInsEstadoContratopthisEstadoContrato() throws NotNullArgumentException {
        if(this.getEstadoContratoInsEstadoContratopthisEstadoContratoInstance() == null || this.getEstadoContratoInsEstadoContratopthisEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_INSESTADOCONTRATO, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_INSESTADOCONTRATO_ESTADOCONTRATOINSESTADOCONTRATOPTHISESTADOCONTRATO, EstadoContratoConstants.SERV_ALIAS_INSESTADOCONTRATO, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_INSESTADOCONTRATO_ESTADOCONTRATOINSESTADOCONTRATOPTHISESTADOCONTRATO);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getEstadoContratoInsEstadoContratopevcSolicitudNovedad() {
        return this.estadoContratoInsEstadoContratopevcSolicitudNovedad;
    }
    
    public void setEstadoContratoInsEstadoContratopevcSolicitudNovedad(SolicitudNovedadOid estadoContratoInsEstadoContratopevcSolicitudNovedad) {
        this.estadoContratoInsEstadoContratopevcSolicitudNovedad = estadoContratoInsEstadoContratopevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getEstadoContratoInsEstadoContratopevcSolicitudNovedadInstance() {
        return this.estadoContratoInsEstadoContratopevcSolicitudNovedadInstance;
    }
    
    public void setEstadoContratoInsEstadoContratopevcSolicitudNovedadInstance(SolicitudNovedad estadoContratoInsEstadoContratopevcSolicitudNovedad) {
        this.estadoContratoInsEstadoContratopevcSolicitudNovedadInstance = estadoContratoInsEstadoContratopevcSolicitudNovedad;
        this.estadoContratoInsEstadoContratopevcSolicitudNovedad = estadoContratoInsEstadoContratopevcSolicitudNovedad != null ? estadoContratoInsEstadoContratopevcSolicitudNovedad.getOid() : null;
    }

    private void checkEstadoContratoInsEstadoContratopevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getEstadoContratoInsEstadoContratopevcSolicitudNovedadInstance() == null || this.getEstadoContratoInsEstadoContratopevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_INSESTADOCONTRATO, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_INSESTADOCONTRATO_ESTADOCONTRATOINSESTADOCONTRATOPEVCSOLICITUDNOVEDAD, EstadoContratoConstants.SERV_ALIAS_INSESTADOCONTRATO, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_INSESTADOCONTRATO_ESTADOCONTRATOINSESTADOCONTRATOPEVCSOLICITUDNOVEDAD);
        }
    }
}
