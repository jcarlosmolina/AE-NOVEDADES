package com.keralty.aenovedades.viewmodel.usuarionovedad.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
public class DSUsuNovTipoTitular {

    @JsonProperty("numusuario")
    private Long dSUsuNovTipoTitularNumUsuario;

    @JsonProperty("drvidentificacion")
    private String dSUsuNovTipoTitularDrvIdentificacion;

    @JsonProperty("drvnombrecompleto")
    private String dSUsuNovTipoTitularDrvNombreCompleto;

    @JsonProperty("estadobeneficiario_descripcion")
    private String dSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion;

    @JsonProperty("parentesco_descripcion")
    private String dSUsuNovTipoTitularParentescoDotDescripcion;

    @JsonProperty("parentesconuevo_descripcion")
    private String dSUsuNovTipoTitularParentescoNuevoDotDescripcion;

    @JsonProperty("motivoestado")
    private String dSUsuNovTipoTitularMotivoEstado;

    @JsonProperty("fechainivigencia")
    private Date dSUsuNovTipoTitularFechaIniVigencia;

    @JsonProperty("fechaantiguedad")
    private Date dSUsuNovTipoTitularFechaAntiguedad;

    public DSUsuNovTipoTitular() {
    
    }

    public DSUsuNovTipoTitular(UsuarioNovedad instance) {
        if (instance != null) {
            try {
                this.dSUsuNovTipoTitularNumUsuario = instance.getUsuarioNovedadNumUsuario();
                this.dSUsuNovTipoTitularDrvIdentificacion = instance.getUsuarioNovedadDrvIdentificacion();
                this.dSUsuNovTipoTitularDrvNombreCompleto = instance.getUsuarioNovedadDrvNombreCompleto();
                this.dSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion = instance.getEstadoBeneficiario().getEstadoBeneficiarioDescripcion();
                this.dSUsuNovTipoTitularParentescoDotDescripcion = instance.getParentesco().getParentescoDescripcion();
                this.dSUsuNovTipoTitularParentescoNuevoDotDescripcion = instance.getParentescoNuevo().getParentescoDescripcion();
                this.dSUsuNovTipoTitularMotivoEstado = instance.getUsuarioNovedadMotivoEstado();
                this.dSUsuNovTipoTitularFechaIniVigencia = instance.getUsuarioNovedadFechaIniVigencia();
                this.dSUsuNovTipoTitularFechaAntiguedad = instance.getUsuarioNovedadFechaAntiguedad();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public Long getDSUsuNovTipoTitularNumUsuario() {
        return this.dSUsuNovTipoTitularNumUsuario;
    }
    
    public void setDSUsuNovTipoTitularNumUsuario(Long dSUsuNovTipoTitularNumUsuario) {
        this.dSUsuNovTipoTitularNumUsuario = dSUsuNovTipoTitularNumUsuario;
    }

    @JsonIgnore
    public String getDSUsuNovTipoTitularDrvIdentificacion() {
        return this.dSUsuNovTipoTitularDrvIdentificacion;
    }
    
    public void setDSUsuNovTipoTitularDrvIdentificacion(String dSUsuNovTipoTitularDrvIdentificacion) {
        this.dSUsuNovTipoTitularDrvIdentificacion = dSUsuNovTipoTitularDrvIdentificacion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoTitularDrvNombreCompleto() {
        return this.dSUsuNovTipoTitularDrvNombreCompleto;
    }
    
    public void setDSUsuNovTipoTitularDrvNombreCompleto(String dSUsuNovTipoTitularDrvNombreCompleto) {
        this.dSUsuNovTipoTitularDrvNombreCompleto = dSUsuNovTipoTitularDrvNombreCompleto;
    }

    @JsonIgnore
    public String getDSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion() {
        return this.dSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion;
    }
    
    public void setDSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion(String dSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion) {
        this.dSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion = dSUsuNovTipoTitularEstadoBeneficiarioDotDescripcion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoTitularParentescoDotDescripcion() {
        return this.dSUsuNovTipoTitularParentescoDotDescripcion;
    }
    
    public void setDSUsuNovTipoTitularParentescoDotDescripcion(String dSUsuNovTipoTitularParentescoDotDescripcion) {
        this.dSUsuNovTipoTitularParentescoDotDescripcion = dSUsuNovTipoTitularParentescoDotDescripcion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoTitularParentescoNuevoDotDescripcion() {
        return this.dSUsuNovTipoTitularParentescoNuevoDotDescripcion;
    }
    
    public void setDSUsuNovTipoTitularParentescoNuevoDotDescripcion(String dSUsuNovTipoTitularParentescoNuevoDotDescripcion) {
        this.dSUsuNovTipoTitularParentescoNuevoDotDescripcion = dSUsuNovTipoTitularParentescoNuevoDotDescripcion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoTitularMotivoEstado() {
        return this.dSUsuNovTipoTitularMotivoEstado;
    }
    
    public void setDSUsuNovTipoTitularMotivoEstado(String dSUsuNovTipoTitularMotivoEstado) {
        this.dSUsuNovTipoTitularMotivoEstado = dSUsuNovTipoTitularMotivoEstado;
    }

    @JsonIgnore
    public Date getDSUsuNovTipoTitularFechaIniVigencia() {
        return this.dSUsuNovTipoTitularFechaIniVigencia;
    }
    
    public void setDSUsuNovTipoTitularFechaIniVigencia(Date dSUsuNovTipoTitularFechaIniVigencia) {
        this.dSUsuNovTipoTitularFechaIniVigencia = dSUsuNovTipoTitularFechaIniVigencia;
    }

    @JsonIgnore
    public Date getDSUsuNovTipoTitularFechaAntiguedad() {
        return this.dSUsuNovTipoTitularFechaAntiguedad;
    }
    
    public void setDSUsuNovTipoTitularFechaAntiguedad(Date dSUsuNovTipoTitularFechaAntiguedad) {
        this.dSUsuNovTipoTitularFechaAntiguedad = dSUsuNovTipoTitularFechaAntiguedad;
    }
}
