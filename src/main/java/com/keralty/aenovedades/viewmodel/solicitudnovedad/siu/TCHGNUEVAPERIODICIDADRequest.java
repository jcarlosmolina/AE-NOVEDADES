package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TCHGNUEVAPERIODICIDADRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance;

    @JsonProperty("ptperiodicidad_json")
    private String solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad();
        checkSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad() {
        return this.solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad) {
        this.solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad = solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad) {
        this.solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance = solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad;
        this.solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad = solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad != null ? solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCHGNUEVAPERIODICIDAD, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCHGNUEVAPERIODICIDAD_SOLICITUDNOVEDADTCHGNUEVAPERIODICIDADPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCHGNUEVAPERIODICIDAD, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCHGNUEVAPERIODICIDAD_SOLICITUDNOVEDADTCHGNUEVAPERIODICIDADPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad() {
        return this.solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad;
    }
    
    public void setSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad(String solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad) {
        this.solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad = solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance() {
        return this.solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance;
    }
    
    public void setSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance(Periodicidad solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad) {
        this.solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance = solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad;
        this.solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad = solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad != null ? solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance() == null || this.getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCHGNUEVAPERIODICIDAD, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCHGNUEVAPERIODICIDAD_SOLICITUDNOVEDADTCHGNUEVAPERIODICIDADPTPERIODICIDAD, SolicitudNovedadConstants.SERV_ALIAS_TCHGNUEVAPERIODICIDAD, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCHGNUEVAPERIODICIDAD_SOLICITUDNOVEDADTCHGNUEVAPERIODICIDADPTPERIODICIDAD);
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
