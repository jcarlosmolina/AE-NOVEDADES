package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class CambiarEstadoDocRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance;

    @JsonProperty("peestadodoc")
    private Long solicitudNovedadcambiarEstadoDocpeEstadoDoc;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedad();
        checkSolicitudNovedadcambiarEstadoDocpeEstadoDoc();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedad() {
        return this.solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad) {
        this.solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad = solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad) {
        this.solicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance = solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad;
        this.solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad = solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad != null ? solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CAMBIARESTADODOC_SOLICITUDNOVEDADCAMBIARESTADODOCPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_CAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CAMBIARESTADODOC_SOLICITUDNOVEDADCAMBIARESTADODOCPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadcambiarEstadoDocpeEstadoDoc() {
        return this.solicitudNovedadcambiarEstadoDocpeEstadoDoc;
    }
    
    public void setSolicitudNovedadcambiarEstadoDocpeEstadoDoc(Long solicitudNovedadcambiarEstadoDocpeEstadoDoc) {
        this.solicitudNovedadcambiarEstadoDocpeEstadoDoc = solicitudNovedadcambiarEstadoDocpeEstadoDoc;
    }

    private void checkSolicitudNovedadcambiarEstadoDocpeEstadoDoc() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcambiarEstadoDocpeEstadoDoc() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CAMBIARESTADODOC_SOLICITUDNOVEDADCAMBIARESTADODOCPEESTADODOC, SolicitudNovedadConstants.SERV_ALIAS_CAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CAMBIARESTADODOC_SOLICITUDNOVEDADCAMBIARESTADODOCPEESTADODOC);
        }
    }
}
