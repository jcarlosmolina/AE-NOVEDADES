package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class AnotarObservacionesRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadanotarObservacionespthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadanotarObservacionespthisSolicitudNovedadInstance;

    @JsonProperty("p_observaciones")
    private String solicitudNovedadanotarObservacionespObservaciones;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadanotarObservacionespthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadanotarObservacionespthisSolicitudNovedad() {
        return this.solicitudNovedadanotarObservacionespthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadanotarObservacionespthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadanotarObservacionespthisSolicitudNovedad) {
        this.solicitudNovedadanotarObservacionespthisSolicitudNovedad = solicitudNovedadanotarObservacionespthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadanotarObservacionespthisSolicitudNovedadInstance() {
        return this.solicitudNovedadanotarObservacionespthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadanotarObservacionespthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadanotarObservacionespthisSolicitudNovedad) {
        this.solicitudNovedadanotarObservacionespthisSolicitudNovedadInstance = solicitudNovedadanotarObservacionespthisSolicitudNovedad;
        this.solicitudNovedadanotarObservacionespthisSolicitudNovedad = solicitudNovedadanotarObservacionespthisSolicitudNovedad != null ? solicitudNovedadanotarObservacionespthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadanotarObservacionespthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadanotarObservacionespthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadanotarObservacionespthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ANOTAROBSERVACIONES, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ANOTAROBSERVACIONES_SOLICITUDNOVEDADANOTAROBSERVACIONESPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_ANOTAROBSERVACIONES, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ANOTAROBSERVACIONES_SOLICITUDNOVEDADANOTAROBSERVACIONESPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadanotarObservacionespObservaciones() {
        return this.solicitudNovedadanotarObservacionespObservaciones;
    }
    
    public void setSolicitudNovedadanotarObservacionespObservaciones(String solicitudNovedadanotarObservacionespObservaciones) {
        this.solicitudNovedadanotarObservacionespObservaciones = solicitudNovedadanotarObservacionespObservaciones;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
