package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARDESDECORERequest {

    @JsonProperty("pt_p_agrfamilianovedad_oid")
    private FamiliaNovedadOid usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrparentesco_oid")
    private ParentescoOid usuarioNovedadTCREARDESDECOREptpagrParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadTCREARDESDECOREptpagrParentescoInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String usuarioNovedadTCREARDESDECOREptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrprimernombre")
    private String usuarioNovedadTCREARDESDECOREptpatrPrimerNombre;

    @JsonProperty("pt_p_atrmotivoestado")
    private String usuarioNovedadTCREARDESDECOREptpatrMotivoEstado;

    @JsonProperty("pt_p_atrfechainivigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia;

    @JsonProperty("pt_p_atrfechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad;

    @JsonProperty("pt_p_atrsegundonombre")
    private String usuarioNovedadTCREARDESDECOREptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String usuarioNovedadTCREARDESDECOREptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String usuarioNovedadTCREARDESDECOREptpatrSegundoApellido;

    @JsonProperty("pt_p_atrnumusuario")
    private Long usuarioNovedadTCREARDESDECOREptpatrNumUsuario;

    @JsonProperty("pt_p_agrestadobeneficiario_oid")
    private EstadoBeneficiarioOid usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiarioInstance;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadTCREARDESDECOREptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String usuarioNovedadTCREARDESDECOREptpatrGenero;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad();
        checkUsuarioNovedadTCREARDESDECOREptpatrNumIdentificacion();
        checkUsuarioNovedadTCREARDESDECOREptpatrNumUsuario();
    }

    @JsonIgnore
    public FamiliaNovedadOid getUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad() {
        return this.usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad(FamiliaNovedadOid usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad) {
        this.usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad = usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance() {
        return this.usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance(FamiliaNovedad usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad) {
        this.usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance = usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad;
        this.usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad = usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad != null ? usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance() == null || this.getUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCREARDESDECORE, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCREARDESDECORE_USUARIONOVEDADTCREARDESDECOREPTPAGRFAMILIANOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_TCREARDESDECORE, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCREARDESDECORE_USUARIONOVEDADTCREARDESDECOREPTPAGRFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion() {
        return this.usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion(TipoIdentificacionOid usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion) {
        this.usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion = usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance() {
        return this.usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion) {
        this.usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance = usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion;
        this.usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion = usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion != null ? usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public ParentescoOid getUsuarioNovedadTCREARDESDECOREptpagrParentesco() {
        return this.usuarioNovedadTCREARDESDECOREptpagrParentesco;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrParentesco(ParentescoOid usuarioNovedadTCREARDESDECOREptpagrParentesco) {
        this.usuarioNovedadTCREARDESDECOREptpagrParentesco = usuarioNovedadTCREARDESDECOREptpagrParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadTCREARDESDECOREptpagrParentescoInstance() {
        return this.usuarioNovedadTCREARDESDECOREptpagrParentescoInstance;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrParentescoInstance(Parentesco usuarioNovedadTCREARDESDECOREptpagrParentesco) {
        this.usuarioNovedadTCREARDESDECOREptpagrParentescoInstance = usuarioNovedadTCREARDESDECOREptpagrParentesco;
        this.usuarioNovedadTCREARDESDECOREptpagrParentesco = usuarioNovedadTCREARDESDECOREptpagrParentesco != null ? usuarioNovedadTCREARDESDECOREptpagrParentesco.getOid() : null;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARDESDECOREptpatrNumIdentificacion() {
        return this.usuarioNovedadTCREARDESDECOREptpatrNumIdentificacion;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrNumIdentificacion(String usuarioNovedadTCREARDESDECOREptpatrNumIdentificacion) {
        this.usuarioNovedadTCREARDESDECOREptpatrNumIdentificacion = usuarioNovedadTCREARDESDECOREptpatrNumIdentificacion;
    }

    private void checkUsuarioNovedadTCREARDESDECOREptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCREARDESDECOREptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCREARDESDECORE, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCREARDESDECORE_USUARIONOVEDADTCREARDESDECOREPTPATRNUMIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_TCREARDESDECORE, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCREARDESDECORE_USUARIONOVEDADTCREARDESDECOREPTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARDESDECOREptpatrPrimerNombre() {
        return this.usuarioNovedadTCREARDESDECOREptpatrPrimerNombre;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrPrimerNombre(String usuarioNovedadTCREARDESDECOREptpatrPrimerNombre) {
        this.usuarioNovedadTCREARDESDECOREptpatrPrimerNombre = usuarioNovedadTCREARDESDECOREptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARDESDECOREptpatrMotivoEstado() {
        return this.usuarioNovedadTCREARDESDECOREptpatrMotivoEstado;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrMotivoEstado(String usuarioNovedadTCREARDESDECOREptpatrMotivoEstado) {
        this.usuarioNovedadTCREARDESDECOREptpatrMotivoEstado = usuarioNovedadTCREARDESDECOREptpatrMotivoEstado;
    }

    @JsonIgnore
    public Date getUsuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia() {
        return this.usuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia(Date usuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia) {
        this.usuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia = usuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia;
    }

    @JsonIgnore
    public Date getUsuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad() {
        return this.usuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad(Date usuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad) {
        this.usuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad = usuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARDESDECOREptpatrSegundoNombre() {
        return this.usuarioNovedadTCREARDESDECOREptpatrSegundoNombre;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrSegundoNombre(String usuarioNovedadTCREARDESDECOREptpatrSegundoNombre) {
        this.usuarioNovedadTCREARDESDECOREptpatrSegundoNombre = usuarioNovedadTCREARDESDECOREptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARDESDECOREptpatrPrimerApellido() {
        return this.usuarioNovedadTCREARDESDECOREptpatrPrimerApellido;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrPrimerApellido(String usuarioNovedadTCREARDESDECOREptpatrPrimerApellido) {
        this.usuarioNovedadTCREARDESDECOREptpatrPrimerApellido = usuarioNovedadTCREARDESDECOREptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARDESDECOREptpatrSegundoApellido() {
        return this.usuarioNovedadTCREARDESDECOREptpatrSegundoApellido;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrSegundoApellido(String usuarioNovedadTCREARDESDECOREptpatrSegundoApellido) {
        this.usuarioNovedadTCREARDESDECOREptpatrSegundoApellido = usuarioNovedadTCREARDESDECOREptpatrSegundoApellido;
    }

    @JsonIgnore
    public Long getUsuarioNovedadTCREARDESDECOREptpatrNumUsuario() {
        return this.usuarioNovedadTCREARDESDECOREptpatrNumUsuario;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrNumUsuario(Long usuarioNovedadTCREARDESDECOREptpatrNumUsuario) {
        this.usuarioNovedadTCREARDESDECOREptpatrNumUsuario = usuarioNovedadTCREARDESDECOREptpatrNumUsuario;
    }

    private void checkUsuarioNovedadTCREARDESDECOREptpatrNumUsuario() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCREARDESDECOREptpatrNumUsuario() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCREARDESDECORE, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCREARDESDECORE_USUARIONOVEDADTCREARDESDECOREPTPATRNUMUSUARIO, UsuarioNovedadConstants.SERV_ALIAS_TCREARDESDECORE, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCREARDESDECORE_USUARIONOVEDADTCREARDESDECOREPTPATRNUMUSUARIO);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getUsuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario() {
        return this.usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario(EstadoBeneficiarioOid usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario) {
        this.usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario = usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getUsuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiarioInstance() {
        return this.usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiarioInstance;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiarioInstance(EstadoBeneficiario usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario) {
        this.usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiarioInstance = usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario;
        this.usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario = usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario != null ? usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario.getOid() : null;
    }

    @JsonIgnore
    public Date getUsuarioNovedadTCREARDESDECOREptpatrFechaNacimiento() {
        return this.usuarioNovedadTCREARDESDECOREptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadTCREARDESDECOREptpatrFechaNacimiento(Date usuarioNovedadTCREARDESDECOREptpatrFechaNacimiento) {
        this.usuarioNovedadTCREARDESDECOREptpatrFechaNacimiento = usuarioNovedadTCREARDESDECOREptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARDESDECOREptpatrGenero() {
        return this.usuarioNovedadTCREARDESDECOREptpatrGenero;
    }
    
    public void setUsuarioNovedadTCREARDESDECOREptpatrGenero(String usuarioNovedadTCREARDESDECOREptpatrGenero) {
        this.usuarioNovedadTCREARDESDECOREptpatrGenero = usuarioNovedadTCREARDESDECOREptpatrGenero;
    }
}
