package com.keralty.aenovedades.viewmodel.estadocontrato.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.EstadoContratoConstants;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelEstadoContratoRequest {

    @JsonProperty("p_thisestadocontrato_oid")
    private EstadoContratoOid estadoContratoDelEstadoContratopthisEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato estadoContratoDelEstadoContratopthisEstadoContratoInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid estadoContratoDelEstadoContratopevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad estadoContratoDelEstadoContratopevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoContratoDelEstadoContratopthisEstadoContrato();
        checkEstadoContratoDelEstadoContratopevcSolicitudNovedad();
    }

    @JsonIgnore
    public EstadoContratoOid getEstadoContratoDelEstadoContratopthisEstadoContrato() {
        return this.estadoContratoDelEstadoContratopthisEstadoContrato;
    }
    
    public void setEstadoContratoDelEstadoContratopthisEstadoContrato(EstadoContratoOid estadoContratoDelEstadoContratopthisEstadoContrato) {
        this.estadoContratoDelEstadoContratopthisEstadoContrato = estadoContratoDelEstadoContratopthisEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getEstadoContratoDelEstadoContratopthisEstadoContratoInstance() {
        return this.estadoContratoDelEstadoContratopthisEstadoContratoInstance;
    }
    
    public void setEstadoContratoDelEstadoContratopthisEstadoContratoInstance(EstadoContrato estadoContratoDelEstadoContratopthisEstadoContrato) {
        this.estadoContratoDelEstadoContratopthisEstadoContratoInstance = estadoContratoDelEstadoContratopthisEstadoContrato;
        this.estadoContratoDelEstadoContratopthisEstadoContrato = estadoContratoDelEstadoContratopthisEstadoContrato != null ? estadoContratoDelEstadoContratopthisEstadoContrato.getOid() : null;
    }

    private void checkEstadoContratoDelEstadoContratopthisEstadoContrato() throws NotNullArgumentException {
        if(this.getEstadoContratoDelEstadoContratopthisEstadoContratoInstance() == null || this.getEstadoContratoDelEstadoContratopthisEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_DELESTADOCONTRATO, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_DELESTADOCONTRATO_ESTADOCONTRATODELESTADOCONTRATOPTHISESTADOCONTRATO, EstadoContratoConstants.SERV_ALIAS_DELESTADOCONTRATO, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_DELESTADOCONTRATO_ESTADOCONTRATODELESTADOCONTRATOPTHISESTADOCONTRATO);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getEstadoContratoDelEstadoContratopevcSolicitudNovedad() {
        return this.estadoContratoDelEstadoContratopevcSolicitudNovedad;
    }
    
    public void setEstadoContratoDelEstadoContratopevcSolicitudNovedad(SolicitudNovedadOid estadoContratoDelEstadoContratopevcSolicitudNovedad) {
        this.estadoContratoDelEstadoContratopevcSolicitudNovedad = estadoContratoDelEstadoContratopevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getEstadoContratoDelEstadoContratopevcSolicitudNovedadInstance() {
        return this.estadoContratoDelEstadoContratopevcSolicitudNovedadInstance;
    }
    
    public void setEstadoContratoDelEstadoContratopevcSolicitudNovedadInstance(SolicitudNovedad estadoContratoDelEstadoContratopevcSolicitudNovedad) {
        this.estadoContratoDelEstadoContratopevcSolicitudNovedadInstance = estadoContratoDelEstadoContratopevcSolicitudNovedad;
        this.estadoContratoDelEstadoContratopevcSolicitudNovedad = estadoContratoDelEstadoContratopevcSolicitudNovedad != null ? estadoContratoDelEstadoContratopevcSolicitudNovedad.getOid() : null;
    }

    private void checkEstadoContratoDelEstadoContratopevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getEstadoContratoDelEstadoContratopevcSolicitudNovedadInstance() == null || this.getEstadoContratoDelEstadoContratopevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_DELESTADOCONTRATO, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_DELESTADOCONTRATO_ESTADOCONTRATODELESTADOCONTRATOPEVCSOLICITUDNOVEDAD, EstadoContratoConstants.SERV_ALIAS_DELESTADOCONTRATO, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_DELESTADOCONTRATO_ESTADOCONTRATODELESTADOCONTRATOPEVCSOLICITUDNOVEDAD);
        }
    }
}
