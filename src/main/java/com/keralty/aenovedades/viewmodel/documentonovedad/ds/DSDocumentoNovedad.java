package com.keralty.aenovedades.viewmodel.documentonovedad.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
public class DSDocumentoNovedad {

    @JsonProperty("fechasubida")
    private Timestamp dSDocumentoNovedadFechaSubida;

    @JsonProperty("usuario_drvidentificacion")
    private String dSDocumentoNovedadUsuarioDotDrvIdentificacion;

    @JsonProperty("usuario_drvnombrecompleto")
    private String dSDocumentoNovedadUsuarioDotDrvNombreCompleto;

    @JsonProperty("tipo")
    private Long dSDocumentoNovedadTipo;

    @JsonProperty("estado")
    private Long dSDocumentoNovedadEstado;

    @JsonProperty("nombre")
    private String dSDocumentoNovedadNombre;

    @JsonProperty("descripcion")
    private String dSDocumentoNovedadDescripcion;

    public DSDocumentoNovedad() {
    
    }

    public DSDocumentoNovedad(DocumentoNovedad instance) {
        if (instance != null) {
            try {
                this.dSDocumentoNovedadFechaSubida = instance.getDocumentoNovedadFechaSubida();
                this.dSDocumentoNovedadUsuarioDotDrvIdentificacion = instance.getUsuario().getUsuarioNovedadDrvIdentificacion();
                this.dSDocumentoNovedadUsuarioDotDrvNombreCompleto = instance.getUsuario().getUsuarioNovedadDrvNombreCompleto();
                this.dSDocumentoNovedadTipo = instance.getDocumentoNovedadTipo();
                this.dSDocumentoNovedadEstado = instance.getDocumentoNovedadEstado();
                this.dSDocumentoNovedadNombre = instance.getDocumentoNovedadNombre();
                this.dSDocumentoNovedadDescripcion = instance.getDocumentoNovedadDescripcion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public Timestamp getDSDocumentoNovedadFechaSubida() {
        return this.dSDocumentoNovedadFechaSubida;
    }
    
    public void setDSDocumentoNovedadFechaSubida(Timestamp dSDocumentoNovedadFechaSubida) {
        this.dSDocumentoNovedadFechaSubida = dSDocumentoNovedadFechaSubida;
    }

    @JsonIgnore
    public String getDSDocumentoNovedadUsuarioDotDrvIdentificacion() {
        return this.dSDocumentoNovedadUsuarioDotDrvIdentificacion;
    }
    
    public void setDSDocumentoNovedadUsuarioDotDrvIdentificacion(String dSDocumentoNovedadUsuarioDotDrvIdentificacion) {
        this.dSDocumentoNovedadUsuarioDotDrvIdentificacion = dSDocumentoNovedadUsuarioDotDrvIdentificacion;
    }

    @JsonIgnore
    public String getDSDocumentoNovedadUsuarioDotDrvNombreCompleto() {
        return this.dSDocumentoNovedadUsuarioDotDrvNombreCompleto;
    }
    
    public void setDSDocumentoNovedadUsuarioDotDrvNombreCompleto(String dSDocumentoNovedadUsuarioDotDrvNombreCompleto) {
        this.dSDocumentoNovedadUsuarioDotDrvNombreCompleto = dSDocumentoNovedadUsuarioDotDrvNombreCompleto;
    }

    @JsonIgnore
    public Long getDSDocumentoNovedadTipo() {
        return this.dSDocumentoNovedadTipo;
    }
    
    public void setDSDocumentoNovedadTipo(Long dSDocumentoNovedadTipo) {
        this.dSDocumentoNovedadTipo = dSDocumentoNovedadTipo;
    }

    @JsonIgnore
    public Long getDSDocumentoNovedadEstado() {
        return this.dSDocumentoNovedadEstado;
    }
    
    public void setDSDocumentoNovedadEstado(Long dSDocumentoNovedadEstado) {
        this.dSDocumentoNovedadEstado = dSDocumentoNovedadEstado;
    }

    @JsonIgnore
    public String getDSDocumentoNovedadNombre() {
        return this.dSDocumentoNovedadNombre;
    }
    
    public void setDSDocumentoNovedadNombre(String dSDocumentoNovedadNombre) {
        this.dSDocumentoNovedadNombre = dSDocumentoNovedadNombre;
    }

    @JsonIgnore
    public String getDSDocumentoNovedadDescripcion() {
        return this.dSDocumentoNovedadDescripcion;
    }
    
    public void setDSDocumentoNovedadDescripcion(String dSDocumentoNovedadDescripcion) {
        this.dSDocumentoNovedadDescripcion = dSDocumentoNovedadDescripcion;
    }
}
