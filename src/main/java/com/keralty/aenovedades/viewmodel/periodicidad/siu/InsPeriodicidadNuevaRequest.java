package com.keralty.aenovedades.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.PeriodicidadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsPeriodicidadNuevaRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadInsPeriodicidadNuevapthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadInsPeriodicidadNuevapthisPeriodicidadInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid periodicidadInsPeriodicidadNuevapevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad periodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadInsPeriodicidadNuevapthisPeriodicidad();
        checkPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedad();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadInsPeriodicidadNuevapthisPeriodicidad() {
        return this.periodicidadInsPeriodicidadNuevapthisPeriodicidad;
    }
    
    public void setPeriodicidadInsPeriodicidadNuevapthisPeriodicidad(PeriodicidadOid periodicidadInsPeriodicidadNuevapthisPeriodicidad) {
        this.periodicidadInsPeriodicidadNuevapthisPeriodicidad = periodicidadInsPeriodicidadNuevapthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadInsPeriodicidadNuevapthisPeriodicidadInstance() {
        return this.periodicidadInsPeriodicidadNuevapthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadNuevapthisPeriodicidadInstance(Periodicidad periodicidadInsPeriodicidadNuevapthisPeriodicidad) {
        this.periodicidadInsPeriodicidadNuevapthisPeriodicidadInstance = periodicidadInsPeriodicidadNuevapthisPeriodicidad;
        this.periodicidadInsPeriodicidadNuevapthisPeriodicidad = periodicidadInsPeriodicidadNuevapthisPeriodicidad != null ? periodicidadInsPeriodicidadNuevapthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadNuevapthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadNuevapthisPeriodicidadInstance() == null || this.getPeriodicidadInsPeriodicidadNuevapthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDADNUEVA_PERIODICIDADINSPERIODICIDADNUEVAPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDADNUEVA_PERIODICIDADINSPERIODICIDADNUEVAPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedad() {
        return this.periodicidadInsPeriodicidadNuevapevcSolicitudNovedad;
    }
    
    public void setPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedad(SolicitudNovedadOid periodicidadInsPeriodicidadNuevapevcSolicitudNovedad) {
        this.periodicidadInsPeriodicidadNuevapevcSolicitudNovedad = periodicidadInsPeriodicidadNuevapevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance() {
        return this.periodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance(SolicitudNovedad periodicidadInsPeriodicidadNuevapevcSolicitudNovedad) {
        this.periodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance = periodicidadInsPeriodicidadNuevapevcSolicitudNovedad;
        this.periodicidadInsPeriodicidadNuevapevcSolicitudNovedad = periodicidadInsPeriodicidadNuevapevcSolicitudNovedad != null ? periodicidadInsPeriodicidadNuevapevcSolicitudNovedad.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance() == null || this.getPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDADNUEVA_PERIODICIDADINSPERIODICIDADNUEVAPEVCSOLICITUDNOVEDAD, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDADNUEVA, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDADNUEVA_PERIODICIDADINSPERIODICIDADNUEVAPEVCSOLICITUDNOVEDAD);
        }
    }
}
