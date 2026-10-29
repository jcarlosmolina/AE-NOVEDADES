package com.keralty.aenovedades.viewmodel.usuarionovedad.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
public class DSUsuNovTipoUsuario {

    @JsonProperty("contratacionro")
    private Boolean dSUsuNovTipoUsuarioContratacionRO;

    @JsonProperty("excluido")
    private Boolean dSUsuNovTipoUsuarioExcluido;

    @JsonProperty("sunummeses")
    private Long dSUsuNovTipoUsuarioSUNumMeses;

    @JsonProperty("prorrogasuspension")
    private Boolean dSUsuNovTipoUsuarioProrrogaSuspension;

    @JsonProperty("activacionsuspension")
    private Boolean dSUsuNovTipoUsuarioActivacionSuspension;

    @JsonProperty("numusuario")
    private Long dSUsuNovTipoUsuarioNumUsuario;

    @JsonProperty("drvidentificacion")
    private String dSUsuNovTipoUsuarioDrvIdentificacion;

    @JsonProperty("drvnuevaidentificacion")
    private String dSUsuNovTipoUsuarioDrvNuevaIdentificacion;

    @JsonProperty("drvnombrecompleto")
    private String dSUsuNovTipoUsuarioDrvNombreCompleto;

    @JsonProperty("parentesco_descripcion")
    private String dSUsuNovTipoUsuarioParentescoDotDescripcion;

    @JsonProperty("parentesconuevo_descripcion")
    private String dSUsuNovTipoUsuarioParentescoNuevoDotDescripcion;

    @JsonProperty("estadobeneficiario_descripcion")
    private String dSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion;

    @JsonProperty("motivoestado")
    private String dSUsuNovTipoUsuarioMotivoEstado;

    @JsonProperty("fechainivigencia")
    private Date dSUsuNovTipoUsuarioFechaIniVigencia;

    @JsonProperty("fechaantiguedad")
    private Date dSUsuNovTipoUsuarioFechaAntiguedad;

    @JsonProperty("drvestasuspendido")
    private Boolean dSUsuNovTipoUsuarioDrvEstaSuspendido;

    public DSUsuNovTipoUsuario() {
    
    }

    public DSUsuNovTipoUsuario(UsuarioNovedad instance) {
        if (instance != null) {
            try {
                this.dSUsuNovTipoUsuarioContratacionRO = instance.getUsuarioNovedadContratacionRO();
                this.dSUsuNovTipoUsuarioExcluido = instance.getUsuarioNovedadExcluido();
                this.dSUsuNovTipoUsuarioSUNumMeses = instance.getUsuarioNovedadSUNumMeses();
                this.dSUsuNovTipoUsuarioProrrogaSuspension = instance.getUsuarioNovedadProrrogaSuspension();
                this.dSUsuNovTipoUsuarioActivacionSuspension = instance.getUsuarioNovedadActivacionSuspension();
                this.dSUsuNovTipoUsuarioNumUsuario = instance.getUsuarioNovedadNumUsuario();
                this.dSUsuNovTipoUsuarioDrvIdentificacion = instance.getUsuarioNovedadDrvIdentificacion();
                this.dSUsuNovTipoUsuarioDrvNuevaIdentificacion = instance.getUsuarioNovedadDrvNuevaIdentificacion();
                this.dSUsuNovTipoUsuarioDrvNombreCompleto = instance.getUsuarioNovedadDrvNombreCompleto();
                this.dSUsuNovTipoUsuarioParentescoDotDescripcion = instance.getParentesco().getParentescoDescripcion();
                this.dSUsuNovTipoUsuarioParentescoNuevoDotDescripcion = instance.getParentescoNuevo().getParentescoDescripcion();
                this.dSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion = instance.getEstadoBeneficiario().getEstadoBeneficiarioDescripcion();
                this.dSUsuNovTipoUsuarioMotivoEstado = instance.getUsuarioNovedadMotivoEstado();
                this.dSUsuNovTipoUsuarioFechaIniVigencia = instance.getUsuarioNovedadFechaIniVigencia();
                this.dSUsuNovTipoUsuarioFechaAntiguedad = instance.getUsuarioNovedadFechaAntiguedad();
                this.dSUsuNovTipoUsuarioDrvEstaSuspendido = instance.getUsuarioNovedaddrvEstaSuspendido();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public Boolean getDSUsuNovTipoUsuarioContratacionRO() {
        return this.dSUsuNovTipoUsuarioContratacionRO;
    }
    
    public void setDSUsuNovTipoUsuarioContratacionRO(Boolean dSUsuNovTipoUsuarioContratacionRO) {
        this.dSUsuNovTipoUsuarioContratacionRO = dSUsuNovTipoUsuarioContratacionRO;
    }

    @JsonIgnore
    public Boolean getDSUsuNovTipoUsuarioExcluido() {
        return this.dSUsuNovTipoUsuarioExcluido;
    }
    
    public void setDSUsuNovTipoUsuarioExcluido(Boolean dSUsuNovTipoUsuarioExcluido) {
        this.dSUsuNovTipoUsuarioExcluido = dSUsuNovTipoUsuarioExcluido;
    }

    @JsonIgnore
    public Long getDSUsuNovTipoUsuarioSUNumMeses() {
        return this.dSUsuNovTipoUsuarioSUNumMeses;
    }
    
    public void setDSUsuNovTipoUsuarioSUNumMeses(Long dSUsuNovTipoUsuarioSUNumMeses) {
        this.dSUsuNovTipoUsuarioSUNumMeses = dSUsuNovTipoUsuarioSUNumMeses;
    }

    @JsonIgnore
    public Boolean getDSUsuNovTipoUsuarioProrrogaSuspension() {
        return this.dSUsuNovTipoUsuarioProrrogaSuspension;
    }
    
    public void setDSUsuNovTipoUsuarioProrrogaSuspension(Boolean dSUsuNovTipoUsuarioProrrogaSuspension) {
        this.dSUsuNovTipoUsuarioProrrogaSuspension = dSUsuNovTipoUsuarioProrrogaSuspension;
    }

    @JsonIgnore
    public Boolean getDSUsuNovTipoUsuarioActivacionSuspension() {
        return this.dSUsuNovTipoUsuarioActivacionSuspension;
    }
    
    public void setDSUsuNovTipoUsuarioActivacionSuspension(Boolean dSUsuNovTipoUsuarioActivacionSuspension) {
        this.dSUsuNovTipoUsuarioActivacionSuspension = dSUsuNovTipoUsuarioActivacionSuspension;
    }

    @JsonIgnore
    public Long getDSUsuNovTipoUsuarioNumUsuario() {
        return this.dSUsuNovTipoUsuarioNumUsuario;
    }
    
    public void setDSUsuNovTipoUsuarioNumUsuario(Long dSUsuNovTipoUsuarioNumUsuario) {
        this.dSUsuNovTipoUsuarioNumUsuario = dSUsuNovTipoUsuarioNumUsuario;
    }

    @JsonIgnore
    public String getDSUsuNovTipoUsuarioDrvIdentificacion() {
        return this.dSUsuNovTipoUsuarioDrvIdentificacion;
    }
    
    public void setDSUsuNovTipoUsuarioDrvIdentificacion(String dSUsuNovTipoUsuarioDrvIdentificacion) {
        this.dSUsuNovTipoUsuarioDrvIdentificacion = dSUsuNovTipoUsuarioDrvIdentificacion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoUsuarioDrvNuevaIdentificacion() {
        return this.dSUsuNovTipoUsuarioDrvNuevaIdentificacion;
    }
    
    public void setDSUsuNovTipoUsuarioDrvNuevaIdentificacion(String dSUsuNovTipoUsuarioDrvNuevaIdentificacion) {
        this.dSUsuNovTipoUsuarioDrvNuevaIdentificacion = dSUsuNovTipoUsuarioDrvNuevaIdentificacion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoUsuarioDrvNombreCompleto() {
        return this.dSUsuNovTipoUsuarioDrvNombreCompleto;
    }
    
    public void setDSUsuNovTipoUsuarioDrvNombreCompleto(String dSUsuNovTipoUsuarioDrvNombreCompleto) {
        this.dSUsuNovTipoUsuarioDrvNombreCompleto = dSUsuNovTipoUsuarioDrvNombreCompleto;
    }

    @JsonIgnore
    public String getDSUsuNovTipoUsuarioParentescoDotDescripcion() {
        return this.dSUsuNovTipoUsuarioParentescoDotDescripcion;
    }
    
    public void setDSUsuNovTipoUsuarioParentescoDotDescripcion(String dSUsuNovTipoUsuarioParentescoDotDescripcion) {
        this.dSUsuNovTipoUsuarioParentescoDotDescripcion = dSUsuNovTipoUsuarioParentescoDotDescripcion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoUsuarioParentescoNuevoDotDescripcion() {
        return this.dSUsuNovTipoUsuarioParentescoNuevoDotDescripcion;
    }
    
    public void setDSUsuNovTipoUsuarioParentescoNuevoDotDescripcion(String dSUsuNovTipoUsuarioParentescoNuevoDotDescripcion) {
        this.dSUsuNovTipoUsuarioParentescoNuevoDotDescripcion = dSUsuNovTipoUsuarioParentescoNuevoDotDescripcion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion() {
        return this.dSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion;
    }
    
    public void setDSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion(String dSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion) {
        this.dSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion = dSUsuNovTipoUsuarioEstadoBeneficiarioDotDescripcion;
    }

    @JsonIgnore
    public String getDSUsuNovTipoUsuarioMotivoEstado() {
        return this.dSUsuNovTipoUsuarioMotivoEstado;
    }
    
    public void setDSUsuNovTipoUsuarioMotivoEstado(String dSUsuNovTipoUsuarioMotivoEstado) {
        this.dSUsuNovTipoUsuarioMotivoEstado = dSUsuNovTipoUsuarioMotivoEstado;
    }

    @JsonIgnore
    public Date getDSUsuNovTipoUsuarioFechaIniVigencia() {
        return this.dSUsuNovTipoUsuarioFechaIniVigencia;
    }
    
    public void setDSUsuNovTipoUsuarioFechaIniVigencia(Date dSUsuNovTipoUsuarioFechaIniVigencia) {
        this.dSUsuNovTipoUsuarioFechaIniVigencia = dSUsuNovTipoUsuarioFechaIniVigencia;
    }

    @JsonIgnore
    public Date getDSUsuNovTipoUsuarioFechaAntiguedad() {
        return this.dSUsuNovTipoUsuarioFechaAntiguedad;
    }
    
    public void setDSUsuNovTipoUsuarioFechaAntiguedad(Date dSUsuNovTipoUsuarioFechaAntiguedad) {
        this.dSUsuNovTipoUsuarioFechaAntiguedad = dSUsuNovTipoUsuarioFechaAntiguedad;
    }

    @JsonIgnore
    public Boolean getDSUsuNovTipoUsuarioDrvEstaSuspendido() {
        return this.dSUsuNovTipoUsuarioDrvEstaSuspendido;
    }
    
    public void setDSUsuNovTipoUsuarioDrvEstaSuspendido(Boolean dSUsuNovTipoUsuarioDrvEstaSuspendido) {
        this.dSUsuNovTipoUsuarioDrvEstaSuspendido = dSUsuNovTipoUsuarioDrvEstaSuspendido;
    }
}
