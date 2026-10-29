package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class RegistrarObservacionesRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadregistrarObservacionespthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance;

    @JsonProperty("p_observaciones")
    private String solicitudNovedadregistrarObservacionespObservaciones;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadregistrarObservacionespthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadregistrarObservacionespthisSolicitudNovedad() {
        return this.solicitudNovedadregistrarObservacionespthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadregistrarObservacionespthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadregistrarObservacionespthisSolicitudNovedad) {
        this.solicitudNovedadregistrarObservacionespthisSolicitudNovedad = solicitudNovedadregistrarObservacionespthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance() {
        return this.solicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadregistrarObservacionespthisSolicitudNovedad) {
        this.solicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance = solicitudNovedadregistrarObservacionespthisSolicitudNovedad;
        this.solicitudNovedadregistrarObservacionespthisSolicitudNovedad = solicitudNovedadregistrarObservacionespthisSolicitudNovedad != null ? solicitudNovedadregistrarObservacionespthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadregistrarObservacionespthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_REGISTRAROBSERVACIONES, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_REGISTRAROBSERVACIONES_SOLICITUDNOVEDADREGISTRAROBSERVACIONESPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_REGISTRAROBSERVACIONES, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_REGISTRAROBSERVACIONES_SOLICITUDNOVEDADREGISTRAROBSERVACIONESPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadregistrarObservacionespObservaciones() {
        return this.solicitudNovedadregistrarObservacionespObservaciones;
    }
    
    public void setSolicitudNovedadregistrarObservacionespObservaciones(String solicitudNovedadregistrarObservacionespObservaciones) {
        this.solicitudNovedadregistrarObservacionespObservaciones = solicitudNovedadregistrarObservacionespObservaciones;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
