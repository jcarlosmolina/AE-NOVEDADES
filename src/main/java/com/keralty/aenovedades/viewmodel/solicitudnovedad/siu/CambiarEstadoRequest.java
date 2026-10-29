package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class CambiarEstadoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadcambiarEstadopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadcambiarEstadopthisSolicitudNovedadInstance;

    @JsonProperty("peestado")
    private Long solicitudNovedadcambiarEstadopeEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadcambiarEstadopthisSolicitudNovedad();
        checkSolicitudNovedadcambiarEstadopeEstado();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadcambiarEstadopthisSolicitudNovedad() {
        return this.solicitudNovedadcambiarEstadopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadcambiarEstadopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadcambiarEstadopthisSolicitudNovedad) {
        this.solicitudNovedadcambiarEstadopthisSolicitudNovedad = solicitudNovedadcambiarEstadopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadcambiarEstadopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadcambiarEstadopthisSolicitudNovedad) {
        this.solicitudNovedadcambiarEstadopthisSolicitudNovedadInstance = solicitudNovedadcambiarEstadopthisSolicitudNovedad;
        this.solicitudNovedadcambiarEstadopthisSolicitudNovedad = solicitudNovedadcambiarEstadopthisSolicitudNovedad != null ? solicitudNovedadcambiarEstadopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadcambiarEstadopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CAMBIARESTADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CAMBIARESTADO_SOLICITUDNOVEDADCAMBIARESTADOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_CAMBIARESTADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CAMBIARESTADO_SOLICITUDNOVEDADCAMBIARESTADOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadcambiarEstadopeEstado() {
        return this.solicitudNovedadcambiarEstadopeEstado;
    }
    
    public void setSolicitudNovedadcambiarEstadopeEstado(Long solicitudNovedadcambiarEstadopeEstado) {
        this.solicitudNovedadcambiarEstadopeEstado = solicitudNovedadcambiarEstadopeEstado;
    }

    private void checkSolicitudNovedadcambiarEstadopeEstado() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcambiarEstadopeEstado() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CAMBIARESTADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CAMBIARESTADO_SOLICITUDNOVEDADCAMBIARESTADOPEESTADO, SolicitudNovedadConstants.SERV_ALIAS_CAMBIARESTADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CAMBIARESTADO_SOLICITUDNOVEDADCAMBIARESTADOPEESTADO);
        }
    }
}
