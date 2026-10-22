package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class AddTextoObservacionesRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadaddTextoObservacionespthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance;

    @JsonProperty("pttexto")
    private String solicitudNovedadaddTextoObservacionesptTexto;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadaddTextoObservacionespthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadaddTextoObservacionespthisSolicitudNovedad() {
        return this.solicitudNovedadaddTextoObservacionespthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadaddTextoObservacionespthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadaddTextoObservacionespthisSolicitudNovedad) {
        this.solicitudNovedadaddTextoObservacionespthisSolicitudNovedad = solicitudNovedadaddTextoObservacionespthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance() {
        return this.solicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadaddTextoObservacionespthisSolicitudNovedad) {
        this.solicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance = solicitudNovedadaddTextoObservacionespthisSolicitudNovedad;
        this.solicitudNovedadaddTextoObservacionespthisSolicitudNovedad = solicitudNovedadaddTextoObservacionespthisSolicitudNovedad != null ? solicitudNovedadaddTextoObservacionespthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadaddTextoObservacionespthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ADDTEXTOOBSERVACIONES, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ADDTEXTOOBSERVACIONES_SOLICITUDNOVEDADADDTEXTOOBSERVACIONESPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_ADDTEXTOOBSERVACIONES, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ADDTEXTOOBSERVACIONES_SOLICITUDNOVEDADADDTEXTOOBSERVACIONESPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadaddTextoObservacionesptTexto() {
        return this.solicitudNovedadaddTextoObservacionesptTexto;
    }
    
    public void setSolicitudNovedadaddTextoObservacionesptTexto(String solicitudNovedadaddTextoObservacionesptTexto) {
        this.solicitudNovedadaddTextoObservacionesptTexto = solicitudNovedadaddTextoObservacionesptTexto;
    }
}
