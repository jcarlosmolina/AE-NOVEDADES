package com.keralty.aenovedades.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.PeriodicidadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsPeriodicidadSolNovRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadInsPeriodicidadSolNovpthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad periodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadInsPeriodicidadSolNovpthisPeriodicidad();
        checkPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedad();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadInsPeriodicidadSolNovpthisPeriodicidad() {
        return this.periodicidadInsPeriodicidadSolNovpthisPeriodicidad;
    }
    
    public void setPeriodicidadInsPeriodicidadSolNovpthisPeriodicidad(PeriodicidadOid periodicidadInsPeriodicidadSolNovpthisPeriodicidad) {
        this.periodicidadInsPeriodicidadSolNovpthisPeriodicidad = periodicidadInsPeriodicidadSolNovpthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance() {
        return this.periodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance(Periodicidad periodicidadInsPeriodicidadSolNovpthisPeriodicidad) {
        this.periodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance = periodicidadInsPeriodicidadSolNovpthisPeriodicidad;
        this.periodicidadInsPeriodicidadSolNovpthisPeriodicidad = periodicidadInsPeriodicidadSolNovpthisPeriodicidad != null ? periodicidadInsPeriodicidadSolNovpthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadSolNovpthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance() == null || this.getPeriodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDADSOLNOV_PERIODICIDADINSPERIODICIDADSOLNOVPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDADSOLNOV_PERIODICIDADINSPERIODICIDADSOLNOVPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedad() {
        return this.periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad;
    }
    
    public void setPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedad(SolicitudNovedadOid periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad) {
        this.periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad = periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance() {
        return this.periodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance(SolicitudNovedad periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad) {
        this.periodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance = periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad;
        this.periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad = periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad != null ? periodicidadInsPeriodicidadSolNovpevcSolicitudNovedad.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance() == null || this.getPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDADSOLNOV_PERIODICIDADINSPERIODICIDADSOLNOVPEVCSOLICITUDNOVEDAD, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDADSOLNOV, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDADSOLNOV_PERIODICIDADINSPERIODICIDADSOLNOVPEVCSOLICITUDNOVEDAD);
        }
    }
}
