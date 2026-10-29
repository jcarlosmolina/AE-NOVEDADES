package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TCREARDOCIDDESDECORERequest {

    @JsonProperty("pt_p_atriddocengestor")
    private String documentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor;

    @JsonProperty("pt_p_nombre")
    private String documentoNovedadTCREARDOCIDDESDECOREptpNombre;

    @JsonProperty("pt_p_extension")
    private String documentoNovedadTCREARDOCIDDESDECOREptpExtension;

    @JsonProperty("ptsolicitud_oid")
    private SolicitudNovedadOid documentoNovedadTCREARDOCIDDESDECOREptSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad documentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadTCREARDOCIDDESDECOREptSolicitud();
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor() {
        return this.documentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor;
    }
    
    public void setDocumentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor(String documentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor) {
        this.documentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor = documentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor;
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARDOCIDDESDECOREptpNombre() {
        return this.documentoNovedadTCREARDOCIDDESDECOREptpNombre;
    }
    
    public void setDocumentoNovedadTCREARDOCIDDESDECOREptpNombre(String documentoNovedadTCREARDOCIDDESDECOREptpNombre) {
        this.documentoNovedadTCREARDOCIDDESDECOREptpNombre = documentoNovedadTCREARDOCIDDESDECOREptpNombre;
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARDOCIDDESDECOREptpExtension() {
        return this.documentoNovedadTCREARDOCIDDESDECOREptpExtension;
    }
    
    public void setDocumentoNovedadTCREARDOCIDDESDECOREptpExtension(String documentoNovedadTCREARDOCIDDESDECOREptpExtension) {
        this.documentoNovedadTCREARDOCIDDESDECOREptpExtension = documentoNovedadTCREARDOCIDDESDECOREptpExtension;
    }

    @JsonIgnore
    public SolicitudNovedadOid getDocumentoNovedadTCREARDOCIDDESDECOREptSolicitud() {
        return this.documentoNovedadTCREARDOCIDDESDECOREptSolicitud;
    }
    
    public void setDocumentoNovedadTCREARDOCIDDESDECOREptSolicitud(SolicitudNovedadOid documentoNovedadTCREARDOCIDDESDECOREptSolicitud) {
        this.documentoNovedadTCREARDOCIDDESDECOREptSolicitud = documentoNovedadTCREARDOCIDDESDECOREptSolicitud;
    }

    @JsonIgnore
    public SolicitudNovedad getDocumentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance() {
        return this.documentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance;
    }
    
    public void setDocumentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance(SolicitudNovedad documentoNovedadTCREARDOCIDDESDECOREptSolicitud) {
        this.documentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance = documentoNovedadTCREARDOCIDDESDECOREptSolicitud;
        this.documentoNovedadTCREARDOCIDDESDECOREptSolicitud = documentoNovedadTCREARDOCIDDESDECOREptSolicitud != null ? documentoNovedadTCREARDOCIDDESDECOREptSolicitud.getOid() : null;
    }

    private void checkDocumentoNovedadTCREARDOCIDDESDECOREptSolicitud() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance() == null || this.getDocumentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TCREARDOCIDDESDECORE, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TCREARDOCIDDESDECORE_DOCUMENTONOVEDADTCREARDOCIDDESDECOREPTSOLICITUD, DocumentoNovedadConstants.SERV_ALIAS_TCREARDOCIDDESDECORE, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TCREARDOCIDDESDECORE_DOCUMENTONOVEDADTCREARDOCIDDESDECOREPTSOLICITUD);
        }
    }
}
