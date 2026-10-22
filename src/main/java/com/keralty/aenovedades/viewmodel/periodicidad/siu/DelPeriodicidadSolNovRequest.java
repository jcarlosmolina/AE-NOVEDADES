package com.keralty.aenovedades.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.PeriodicidadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelPeriodicidadSolNovRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadDelPeriodicidadSolNovpthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad periodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadDelPeriodicidadSolNovpthisPeriodicidad();
        checkPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedad();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadDelPeriodicidadSolNovpthisPeriodicidad() {
        return this.periodicidadDelPeriodicidadSolNovpthisPeriodicidad;
    }
    
    public void setPeriodicidadDelPeriodicidadSolNovpthisPeriodicidad(PeriodicidadOid periodicidadDelPeriodicidadSolNovpthisPeriodicidad) {
        this.periodicidadDelPeriodicidadSolNovpthisPeriodicidad = periodicidadDelPeriodicidadSolNovpthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance() {
        return this.periodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance(Periodicidad periodicidadDelPeriodicidadSolNovpthisPeriodicidad) {
        this.periodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance = periodicidadDelPeriodicidadSolNovpthisPeriodicidad;
        this.periodicidadDelPeriodicidadSolNovpthisPeriodicidad = periodicidadDelPeriodicidadSolNovpthisPeriodicidad != null ? periodicidadDelPeriodicidadSolNovpthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadSolNovpthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance() == null || this.getPeriodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDADSOLNOV_PERIODICIDADDELPERIODICIDADSOLNOVPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDADSOLNOV_PERIODICIDADDELPERIODICIDADSOLNOVPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedad() {
        return this.periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad;
    }
    
    public void setPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedad(SolicitudNovedadOid periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad) {
        this.periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad = periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance() {
        return this.periodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance(SolicitudNovedad periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad) {
        this.periodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance = periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad;
        this.periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad = periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad != null ? periodicidadDelPeriodicidadSolNovpevcSolicitudNovedad.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance() == null || this.getPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDADSOLNOV_PERIODICIDADDELPERIODICIDADSOLNOVPEVCSOLICITUDNOVEDAD, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDADSOLNOV_PERIODICIDADDELPERIODICIDADSOLNOVPEVCSOLICITUDNOVEDAD);
        }
    }
}
