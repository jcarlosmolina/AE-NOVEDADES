package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelPeriodicidadSolNovRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance;

    @JsonProperty("p_evcperiodicidad_oid")
    private PeriodicidadOid solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad();
        checkSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad() {
        return this.solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad) {
        this.solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad = solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad) {
        this.solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance = solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad;
        this.solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad = solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad != null ? solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELPERIODICIDADSOLNOV_SOLICITUDNOVEDADDELPERIODICIDADSOLNOVPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DELPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELPERIODICIDADSOLNOV_SOLICITUDNOVEDADDELPERIODICIDADSOLNOVPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad() {
        return this.solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad;
    }
    
    public void setSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad(PeriodicidadOid solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad) {
        this.solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad = solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance() {
        return this.solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance;
    }
    
    public void setSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance(Periodicidad solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad) {
        this.solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance = solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad;
        this.solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad = solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad != null ? solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad.getOid() : null;
    }

    private void checkSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance() == null || this.getSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELPERIODICIDADSOLNOV_SOLICITUDNOVEDADDELPERIODICIDADSOLNOVPEVCPERIODICIDAD, SolicitudNovedadConstants.SERV_ALIAS_DELPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELPERIODICIDADSOLNOV_SOLICITUDNOVEDADDELPERIODICIDADSOLNOVPEVCPERIODICIDAD);
        }
    }
}
