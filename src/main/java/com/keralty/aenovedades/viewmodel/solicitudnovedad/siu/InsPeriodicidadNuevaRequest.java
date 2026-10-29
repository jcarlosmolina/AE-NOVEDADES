package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class InsPeriodicidadNuevaRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance;

    @JsonProperty("p_evcperiodicidad_oid")
    private PeriodicidadOid solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad();
        checkSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad() {
        return this.solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad) {
        this.solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad = solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance() {
        return this.solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad) {
        this.solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance = solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad;
        this.solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad = solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad != null ? solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSPERIODICIDADNUEVA_SOLICITUDNOVEDADINSPERIODICIDADNUEVAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_INSPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSPERIODICIDADNUEVA_SOLICITUDNOVEDADINSPERIODICIDADNUEVAPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidad() {
        return this.solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad;
    }
    
    public void setSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidad(PeriodicidadOid solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad) {
        this.solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad = solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance() {
        return this.solicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance;
    }
    
    public void setSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance(Periodicidad solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad) {
        this.solicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance = solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad;
        this.solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad = solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad != null ? solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad.getOid() : null;
    }

    private void checkSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance() == null || this.getSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSPERIODICIDADNUEVA_SOLICITUDNOVEDADINSPERIODICIDADNUEVAPEVCPERIODICIDAD, SolicitudNovedadConstants.SERV_ALIAS_INSPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSPERIODICIDADNUEVA_SOLICITUDNOVEDADINSPERIODICIDADNUEVAPEVCPERIODICIDAD);
        }
    }
}
