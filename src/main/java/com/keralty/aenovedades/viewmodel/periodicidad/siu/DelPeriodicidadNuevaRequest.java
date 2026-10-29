package com.keralty.aenovedades.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.PeriodicidadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelPeriodicidadNuevaRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadDelPeriodicidadNuevapthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadDelPeriodicidadNuevapthisPeriodicidadInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid periodicidadDelPeriodicidadNuevapevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad periodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadDelPeriodicidadNuevapthisPeriodicidad();
        checkPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedad();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadDelPeriodicidadNuevapthisPeriodicidad() {
        return this.periodicidadDelPeriodicidadNuevapthisPeriodicidad;
    }
    
    public void setPeriodicidadDelPeriodicidadNuevapthisPeriodicidad(PeriodicidadOid periodicidadDelPeriodicidadNuevapthisPeriodicidad) {
        this.periodicidadDelPeriodicidadNuevapthisPeriodicidad = periodicidadDelPeriodicidadNuevapthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadDelPeriodicidadNuevapthisPeriodicidadInstance() {
        return this.periodicidadDelPeriodicidadNuevapthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadNuevapthisPeriodicidadInstance(Periodicidad periodicidadDelPeriodicidadNuevapthisPeriodicidad) {
        this.periodicidadDelPeriodicidadNuevapthisPeriodicidadInstance = periodicidadDelPeriodicidadNuevapthisPeriodicidad;
        this.periodicidadDelPeriodicidadNuevapthisPeriodicidad = periodicidadDelPeriodicidadNuevapthisPeriodicidad != null ? periodicidadDelPeriodicidadNuevapthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadNuevapthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadNuevapthisPeriodicidadInstance() == null || this.getPeriodicidadDelPeriodicidadNuevapthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDADNUEVA_PERIODICIDADDELPERIODICIDADNUEVAPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDADNUEVA_PERIODICIDADDELPERIODICIDADNUEVAPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedad() {
        return this.periodicidadDelPeriodicidadNuevapevcSolicitudNovedad;
    }
    
    public void setPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedad(SolicitudNovedadOid periodicidadDelPeriodicidadNuevapevcSolicitudNovedad) {
        this.periodicidadDelPeriodicidadNuevapevcSolicitudNovedad = periodicidadDelPeriodicidadNuevapevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance() {
        return this.periodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance(SolicitudNovedad periodicidadDelPeriodicidadNuevapevcSolicitudNovedad) {
        this.periodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance = periodicidadDelPeriodicidadNuevapevcSolicitudNovedad;
        this.periodicidadDelPeriodicidadNuevapevcSolicitudNovedad = periodicidadDelPeriodicidadNuevapevcSolicitudNovedad != null ? periodicidadDelPeriodicidadNuevapevcSolicitudNovedad.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance() == null || this.getPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDADNUEVA_PERIODICIDADDELPERIODICIDADNUEVAPEVCSOLICITUDNOVEDAD, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDADNUEVA_PERIODICIDADDELPERIODICIDADNUEVAPEVCSOLICITUDNOVEDAD);
        }
    }
}
