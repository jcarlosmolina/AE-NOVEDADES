package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DelPeriodicidadNuevaRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance;

    @JsonProperty("p_evcperiodicidad_oid")
    private PeriodicidadOid solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad();
        checkSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad() {
        return this.solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad) {
        this.solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad = solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance() {
        return this.solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad) {
        this.solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance = solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad;
        this.solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad = solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad != null ? solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELPERIODICIDADNUEVA_SOLICITUDNOVEDADDELPERIODICIDADNUEVAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DELPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELPERIODICIDADNUEVA_SOLICITUDNOVEDADDELPERIODICIDADNUEVAPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidad() {
        return this.solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad;
    }
    
    public void setSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidad(PeriodicidadOid solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad) {
        this.solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad = solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance() {
        return this.solicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance;
    }
    
    public void setSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance(Periodicidad solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad) {
        this.solicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance = solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad;
        this.solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad = solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad != null ? solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad.getOid() : null;
    }

    private void checkSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance() == null || this.getSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELPERIODICIDADNUEVA_SOLICITUDNOVEDADDELPERIODICIDADNUEVAPEVCPERIODICIDAD, SolicitudNovedadConstants.SERV_ALIAS_DELPERIODICIDADNUEVA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELPERIODICIDADNUEVA_SOLICITUDNOVEDADDELPERIODICIDADNUEVAPEVCPERIODICIDAD);
        }
    }
}
