package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TCAMBIARESTADORequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance;

    @JsonProperty("ptestado")
    private Long solicitudNovedadTCAMBIARESTADOptEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad();
        checkSolicitudNovedadTCAMBIARESTADOptEstado();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad() {
        return this.solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad) {
        this.solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad = solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad) {
        this.solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance = solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad;
        this.solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad = solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad != null ? solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCAMBIARESTADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCAMBIARESTADO_SOLICITUDNOVEDADTCAMBIARESTADOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCAMBIARESTADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCAMBIARESTADO_SOLICITUDNOVEDADTCAMBIARESTADOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadTCAMBIARESTADOptEstado() {
        return this.solicitudNovedadTCAMBIARESTADOptEstado;
    }
    
    public void setSolicitudNovedadTCAMBIARESTADOptEstado(Long solicitudNovedadTCAMBIARESTADOptEstado) {
        this.solicitudNovedadTCAMBIARESTADOptEstado = solicitudNovedadTCAMBIARESTADOptEstado;
    }

    private void checkSolicitudNovedadTCAMBIARESTADOptEstado() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCAMBIARESTADOptEstado() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCAMBIARESTADO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCAMBIARESTADO_SOLICITUDNOVEDADTCAMBIARESTADOPTESTADO, SolicitudNovedadConstants.SERV_ALIAS_TCAMBIARESTADO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCAMBIARESTADO_SOLICITUDNOVEDADTCAMBIARESTADOPTESTADO);
        }
    }
}
