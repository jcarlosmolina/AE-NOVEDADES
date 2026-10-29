package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class CrearRequest {

    @JsonProperty("p_agrsolicitud_oid")
    private SolicitudNovedadOid documentoNovedadcrearpagrSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad documentoNovedadcrearpagrSolicitudInstance;

    @JsonProperty("p_agrusuario_oid")
    private UsuarioNovedadOid documentoNovedadcrearpagrUsuario;
    
    @JsonIgnore
    private UsuarioNovedad documentoNovedadcrearpagrUsuarioInstance;

    @JsonProperty("p_atrdescripcion")
    private String documentoNovedadcrearpatrDescripcion;

    @JsonProperty("p_atrestado")
    private Long documentoNovedadcrearpatrEstado;

    @JsonProperty("p_atriddocengestor")
    private String documentoNovedadcrearpatrIdDocEnGestor;

    @JsonProperty("p_atrtipo")
    private Long documentoNovedadcrearpatrTipo;

    @JsonProperty("p_atrnombre")
    private String documentoNovedadcrearpatrNombre;

    @JsonProperty("p_atrextension")
    private String documentoNovedadcrearpatrExtension;

    @JsonProperty("p_atrusuariocreador")
    private String documentoNovedadcrearpatrUsuarioCreador;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadcrearpagrSolicitud();
        checkDocumentoNovedadcrearpatrEstado();
        checkDocumentoNovedadcrearpatrTipo();
        checkDocumentoNovedadcrearpatrUsuarioCreador();
    }

    @JsonIgnore
    public SolicitudNovedadOid getDocumentoNovedadcrearpagrSolicitud() {
        return this.documentoNovedadcrearpagrSolicitud;
    }
    
    public void setDocumentoNovedadcrearpagrSolicitud(SolicitudNovedadOid documentoNovedadcrearpagrSolicitud) {
        this.documentoNovedadcrearpagrSolicitud = documentoNovedadcrearpagrSolicitud;
    }

    @JsonIgnore
    public SolicitudNovedad getDocumentoNovedadcrearpagrSolicitudInstance() {
        return this.documentoNovedadcrearpagrSolicitudInstance;
    }
    
    public void setDocumentoNovedadcrearpagrSolicitudInstance(SolicitudNovedad documentoNovedadcrearpagrSolicitud) {
        this.documentoNovedadcrearpagrSolicitudInstance = documentoNovedadcrearpagrSolicitud;
        this.documentoNovedadcrearpagrSolicitud = documentoNovedadcrearpagrSolicitud != null ? documentoNovedadcrearpagrSolicitud.getOid() : null;
    }

    private void checkDocumentoNovedadcrearpagrSolicitud() throws NotNullArgumentException {
        if(this.getDocumentoNovedadcrearpagrSolicitudInstance() == null || this.getDocumentoNovedadcrearpagrSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_CREAR, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_CREAR_DOCUMENTONOVEDADCREARPAGRSOLICITUD, DocumentoNovedadConstants.SERV_ALIAS_CREAR, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_CREAR_DOCUMENTONOVEDADCREARPAGRSOLICITUD);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getDocumentoNovedadcrearpagrUsuario() {
        return this.documentoNovedadcrearpagrUsuario;
    }
    
    public void setDocumentoNovedadcrearpagrUsuario(UsuarioNovedadOid documentoNovedadcrearpagrUsuario) {
        this.documentoNovedadcrearpagrUsuario = documentoNovedadcrearpagrUsuario;
    }

    @JsonIgnore
    public UsuarioNovedad getDocumentoNovedadcrearpagrUsuarioInstance() {
        return this.documentoNovedadcrearpagrUsuarioInstance;
    }
    
    public void setDocumentoNovedadcrearpagrUsuarioInstance(UsuarioNovedad documentoNovedadcrearpagrUsuario) {
        this.documentoNovedadcrearpagrUsuarioInstance = documentoNovedadcrearpagrUsuario;
        this.documentoNovedadcrearpagrUsuario = documentoNovedadcrearpagrUsuario != null ? documentoNovedadcrearpagrUsuario.getOid() : null;
    }

    @JsonIgnore
    public String getDocumentoNovedadcrearpatrDescripcion() {
        return this.documentoNovedadcrearpatrDescripcion;
    }
    
    public void setDocumentoNovedadcrearpatrDescripcion(String documentoNovedadcrearpatrDescripcion) {
        this.documentoNovedadcrearpatrDescripcion = documentoNovedadcrearpatrDescripcion;
    }

    @JsonIgnore
    public Long getDocumentoNovedadcrearpatrEstado() {
        return this.documentoNovedadcrearpatrEstado;
    }
    
    public void setDocumentoNovedadcrearpatrEstado(Long documentoNovedadcrearpatrEstado) {
        this.documentoNovedadcrearpatrEstado = documentoNovedadcrearpatrEstado;
    }

    private void checkDocumentoNovedadcrearpatrEstado() throws NotNullArgumentException {
        if(this.getDocumentoNovedadcrearpatrEstado() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_CREAR, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_CREAR_DOCUMENTONOVEDADCREARPATRESTADO, DocumentoNovedadConstants.SERV_ALIAS_CREAR, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_CREAR_DOCUMENTONOVEDADCREARPATRESTADO);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadcrearpatrIdDocEnGestor() {
        return this.documentoNovedadcrearpatrIdDocEnGestor;
    }
    
    public void setDocumentoNovedadcrearpatrIdDocEnGestor(String documentoNovedadcrearpatrIdDocEnGestor) {
        this.documentoNovedadcrearpatrIdDocEnGestor = documentoNovedadcrearpatrIdDocEnGestor;
    }

    @JsonIgnore
    public Long getDocumentoNovedadcrearpatrTipo() {
        return this.documentoNovedadcrearpatrTipo;
    }
    
    public void setDocumentoNovedadcrearpatrTipo(Long documentoNovedadcrearpatrTipo) {
        this.documentoNovedadcrearpatrTipo = documentoNovedadcrearpatrTipo;
    }

    private void checkDocumentoNovedadcrearpatrTipo() throws NotNullArgumentException {
        if(this.getDocumentoNovedadcrearpatrTipo() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_CREAR, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_CREAR_DOCUMENTONOVEDADCREARPATRTIPO, DocumentoNovedadConstants.SERV_ALIAS_CREAR, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_CREAR_DOCUMENTONOVEDADCREARPATRTIPO);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadcrearpatrNombre() {
        return this.documentoNovedadcrearpatrNombre;
    }
    
    public void setDocumentoNovedadcrearpatrNombre(String documentoNovedadcrearpatrNombre) {
        this.documentoNovedadcrearpatrNombre = documentoNovedadcrearpatrNombre;
    }

    @JsonIgnore
    public String getDocumentoNovedadcrearpatrExtension() {
        return this.documentoNovedadcrearpatrExtension;
    }
    
    public void setDocumentoNovedadcrearpatrExtension(String documentoNovedadcrearpatrExtension) {
        this.documentoNovedadcrearpatrExtension = documentoNovedadcrearpatrExtension;
    }

    @JsonIgnore
    public String getDocumentoNovedadcrearpatrUsuarioCreador() {
        return this.documentoNovedadcrearpatrUsuarioCreador;
    }
    
    public void setDocumentoNovedadcrearpatrUsuarioCreador(String documentoNovedadcrearpatrUsuarioCreador) {
        this.documentoNovedadcrearpatrUsuarioCreador = documentoNovedadcrearpatrUsuarioCreador;
    }

    private void checkDocumentoNovedadcrearpatrUsuarioCreador() throws NotNullArgumentException {
        if(this.getDocumentoNovedadcrearpatrUsuarioCreador() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_CREAR, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_CREAR_DOCUMENTONOVEDADCREARPATRUSUARIOCREADOR, DocumentoNovedadConstants.SERV_ALIAS_CREAR, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_CREAR_DOCUMENTONOVEDADCREARPATRUSUARIOCREADOR);
        }
    }
}
