package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TCAMBIARESTADODOCRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance;

    @JsonProperty("ptestadodoc")
    private Long solicitudNovedadTCAMBIARESTADODOCptEstadoDoc;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad();
        checkSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad() {
        return this.solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad) {
        this.solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad = solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad) {
        this.solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance = solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad;
        this.solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad = solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad != null ? solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCAMBIARESTADODOC_SOLICITUDNOVEDADTCAMBIARESTADODOCPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCAMBIARESTADODOC_SOLICITUDNOVEDADTCAMBIARESTADODOCPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Long getSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc() {
        return this.solicitudNovedadTCAMBIARESTADODOCptEstadoDoc;
    }
    
    public void setSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc(Long solicitudNovedadTCAMBIARESTADODOCptEstadoDoc) {
        this.solicitudNovedadTCAMBIARESTADODOCptEstadoDoc = solicitudNovedadTCAMBIARESTADODOCptEstadoDoc;
    }

    private void checkSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCAMBIARESTADODOC_SOLICITUDNOVEDADTCAMBIARESTADODOCPTESTADODOC, SolicitudNovedadConstants.SERV_ALIAS_TCAMBIARESTADODOC, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCAMBIARESTADODOC_SOLICITUDNOVEDADTCAMBIARESTADODOCPTESTADODOC);
        }
    }
}
