package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class TCREARATORequest {

    @JsonProperty("pt_p_atrdescripcion")
    private String documentoNovedadTCREARATOptpatrDescripcion;

    @JsonProperty("pt_p_atrtipo")
    private Long documentoNovedadTCREARATOptpatrTipo;

    @JsonProperty("pt_p_extension")
    private String documentoNovedadTCREARATOptpExtension;

    @JsonProperty("ptusuario_json")
    private String documentoNovedadTCREARATOptUsuario;
    
    @JsonIgnore
    private UsuarioNovedad documentoNovedadTCREARATOptUsuarioInstance;

    @JsonProperty("ptsolicitud_oid")
    private SolicitudNovedadOid documentoNovedadTCREARATOptSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad documentoNovedadTCREARATOptSolicitudInstance;

    @JsonProperty("ptiddocgestor")
    private String documentoNovedadTCREARATOptIdDocGestor;

    @JsonProperty("ptnombre")
    private String documentoNovedadTCREARATOptNombre;

    @JsonProperty("pffichero")
    private byte[] documentoNovedadTCREARATOpfFichero;

    @JsonProperty("ptnumsolicitud")
    private Long documentoNovedadTCREARATOptNumSolicitud;

    @JsonProperty("ptnumidentusuario")
    private String documentoNovedadTCREARATOptNumIdentUsuario;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadTCREARATOptSolicitud();
        checkDocumentoNovedadTCREARATOptIdDocGestor();
        checkDocumentoNovedadTCREARATOptNombre();
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARATOptpatrDescripcion() {
        return this.documentoNovedadTCREARATOptpatrDescripcion;
    }
    
    public void setDocumentoNovedadTCREARATOptpatrDescripcion(String documentoNovedadTCREARATOptpatrDescripcion) {
        this.documentoNovedadTCREARATOptpatrDescripcion = documentoNovedadTCREARATOptpatrDescripcion;
    }

    @JsonIgnore
    public Long getDocumentoNovedadTCREARATOptpatrTipo() {
        return this.documentoNovedadTCREARATOptpatrTipo;
    }
    
    public void setDocumentoNovedadTCREARATOptpatrTipo(Long documentoNovedadTCREARATOptpatrTipo) {
        this.documentoNovedadTCREARATOptpatrTipo = documentoNovedadTCREARATOptpatrTipo;
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARATOptpExtension() {
        return this.documentoNovedadTCREARATOptpExtension;
    }
    
    public void setDocumentoNovedadTCREARATOptpExtension(String documentoNovedadTCREARATOptpExtension) {
        this.documentoNovedadTCREARATOptpExtension = documentoNovedadTCREARATOptpExtension;
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARATOptUsuario() {
        return this.documentoNovedadTCREARATOptUsuario;
    }
    
    public void setDocumentoNovedadTCREARATOptUsuario(String documentoNovedadTCREARATOptUsuario) {
        this.documentoNovedadTCREARATOptUsuario = documentoNovedadTCREARATOptUsuario;
    }

    @JsonIgnore
    public UsuarioNovedad getDocumentoNovedadTCREARATOptUsuarioInstance() {
        return this.documentoNovedadTCREARATOptUsuarioInstance;
    }
    
    public void setDocumentoNovedadTCREARATOptUsuarioInstance(UsuarioNovedad documentoNovedadTCREARATOptUsuario) {
        this.documentoNovedadTCREARATOptUsuarioInstance = documentoNovedadTCREARATOptUsuario;
        this.documentoNovedadTCREARATOptUsuario = documentoNovedadTCREARATOptUsuario != null ? documentoNovedadTCREARATOptUsuario.getOid().toJson() : "";
    }

    @JsonIgnore
    public SolicitudNovedadOid getDocumentoNovedadTCREARATOptSolicitud() {
        return this.documentoNovedadTCREARATOptSolicitud;
    }
    
    public void setDocumentoNovedadTCREARATOptSolicitud(SolicitudNovedadOid documentoNovedadTCREARATOptSolicitud) {
        this.documentoNovedadTCREARATOptSolicitud = documentoNovedadTCREARATOptSolicitud;
    }

    @JsonIgnore
    public SolicitudNovedad getDocumentoNovedadTCREARATOptSolicitudInstance() {
        return this.documentoNovedadTCREARATOptSolicitudInstance;
    }
    
    public void setDocumentoNovedadTCREARATOptSolicitudInstance(SolicitudNovedad documentoNovedadTCREARATOptSolicitud) {
        this.documentoNovedadTCREARATOptSolicitudInstance = documentoNovedadTCREARATOptSolicitud;
        this.documentoNovedadTCREARATOptSolicitud = documentoNovedadTCREARATOptSolicitud != null ? documentoNovedadTCREARATOptSolicitud.getOid() : null;
    }

    private void checkDocumentoNovedadTCREARATOptSolicitud() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTCREARATOptSolicitudInstance() == null || this.getDocumentoNovedadTCREARATOptSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TCREARATO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TCREARATO_DOCUMENTONOVEDADTCREARATOPTSOLICITUD, DocumentoNovedadConstants.SERV_ALIAS_TCREARATO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TCREARATO_DOCUMENTONOVEDADTCREARATOPTSOLICITUD);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARATOptIdDocGestor() {
        return this.documentoNovedadTCREARATOptIdDocGestor;
    }
    
    public void setDocumentoNovedadTCREARATOptIdDocGestor(String documentoNovedadTCREARATOptIdDocGestor) {
        this.documentoNovedadTCREARATOptIdDocGestor = documentoNovedadTCREARATOptIdDocGestor;
    }

    private void checkDocumentoNovedadTCREARATOptIdDocGestor() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTCREARATOptIdDocGestor() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TCREARATO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TCREARATO_DOCUMENTONOVEDADTCREARATOPTIDDOCGESTOR, DocumentoNovedadConstants.SERV_ALIAS_TCREARATO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TCREARATO_DOCUMENTONOVEDADTCREARATOPTIDDOCGESTOR);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARATOptNombre() {
        return this.documentoNovedadTCREARATOptNombre;
    }
    
    public void setDocumentoNovedadTCREARATOptNombre(String documentoNovedadTCREARATOptNombre) {
        this.documentoNovedadTCREARATOptNombre = documentoNovedadTCREARATOptNombre;
    }

    private void checkDocumentoNovedadTCREARATOptNombre() throws NotNullArgumentException {
        if(this.getDocumentoNovedadTCREARATOptNombre() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_TCREARATO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_TCREARATO_DOCUMENTONOVEDADTCREARATOPTNOMBRE, DocumentoNovedadConstants.SERV_ALIAS_TCREARATO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_TCREARATO_DOCUMENTONOVEDADTCREARATOPTNOMBRE);
        }
    }

    @JsonIgnore
    public byte[] getDocumentoNovedadTCREARATOpfFichero() {
        return this.documentoNovedadTCREARATOpfFichero;
    }
    
    public void setDocumentoNovedadTCREARATOpfFichero(byte[] documentoNovedadTCREARATOpfFichero) {
        this.documentoNovedadTCREARATOpfFichero = documentoNovedadTCREARATOpfFichero;
    }

    @JsonIgnore
    public Long getDocumentoNovedadTCREARATOptNumSolicitud() {
        return this.documentoNovedadTCREARATOptNumSolicitud;
    }
    
    public void setDocumentoNovedadTCREARATOptNumSolicitud(Long documentoNovedadTCREARATOptNumSolicitud) {
        this.documentoNovedadTCREARATOptNumSolicitud = documentoNovedadTCREARATOptNumSolicitud;
    }

    @JsonIgnore
    public String getDocumentoNovedadTCREARATOptNumIdentUsuario() {
        return this.documentoNovedadTCREARATOptNumIdentUsuario;
    }
    
    public void setDocumentoNovedadTCREARATOptNumIdentUsuario(String documentoNovedadTCREARATOptNumIdentUsuario) {
        this.documentoNovedadTCREARATOptNumIdentUsuario = documentoNovedadTCREARATOptNumIdentUsuario;
    }
}
