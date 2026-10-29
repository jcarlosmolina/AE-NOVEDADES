package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsPeriodicidadSolNovRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance;

    @JsonProperty("p_evcperiodicidad_oid")
    private PeriodicidadOid solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad();
        checkSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad() {
        return this.solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad) {
        this.solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad = solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad) {
        this.solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance = solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad;
        this.solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad = solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad != null ? solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSPERIODICIDADSOLNOV_SOLICITUDNOVEDADINSPERIODICIDADSOLNOVPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_INSPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSPERIODICIDADSOLNOV_SOLICITUDNOVEDADINSPERIODICIDADSOLNOVPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad() {
        return this.solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad;
    }
    
    public void setSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad(PeriodicidadOid solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad) {
        this.solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad = solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance() {
        return this.solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance;
    }
    
    public void setSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance(Periodicidad solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad) {
        this.solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance = solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad;
        this.solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad = solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad != null ? solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad.getOid() : null;
    }

    private void checkSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance() == null || this.getSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSPERIODICIDADSOLNOV_SOLICITUDNOVEDADINSPERIODICIDADSOLNOVPEVCPERIODICIDAD, SolicitudNovedadConstants.SERV_ALIAS_INSPERIODICIDADSOLNOV, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSPERIODICIDADSOLNOV_SOLICITUDNOVEDADINSPERIODICIDADSOLNOVPEVCPERIODICIDAD);
        }
    }
}
