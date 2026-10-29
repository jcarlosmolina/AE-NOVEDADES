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

public class CrearRequest {

    @JsonProperty("p_agrfamilianovedad_oid")
    private FamiliaNovedadOid usuarioNovedadcrearpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad usuarioNovedadcrearpagrFamiliaNovedadInstance;

    @JsonProperty("p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid usuarioNovedadcrearpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadcrearpagrTipoIdentificacionInstance;

    @JsonProperty("p_agrparentesco_oid")
    private ParentescoOid usuarioNovedadcrearpagrParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadcrearpagrParentescoInstance;

    @JsonProperty("p_agrestadobeneficiario_oid")
    private EstadoBeneficiarioOid usuarioNovedadcrearpagrEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario usuarioNovedadcrearpagrEstadoBeneficiarioInstance;

    @JsonProperty("p_agrparentesconuevo_oid")
    private ParentescoOid usuarioNovedadcrearpagrParentescoNuevo;
    
    @JsonIgnore
    private Parentesco usuarioNovedadcrearpagrParentescoNuevoInstance;

    @JsonProperty("p_agrtipoidentificacioncd_oid")
    private TipoIdentificacionOid usuarioNovedadcrearpagrTipoIdentificacionCD;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadcrearpagrTipoIdentificacionCDInstance;

    @JsonProperty("p_atrnumidentificacion")
    private String usuarioNovedadcrearpatrNumIdentificacion;

    @JsonProperty("p_atrprimernombre")
    private String usuarioNovedadcrearpatrPrimerNombre;

    @JsonProperty("p_atrmotivoestado")
    private String usuarioNovedadcrearpatrMotivoEstado;

    @JsonProperty("p_atrfechainivigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadcrearpatrFechaIniVigencia;

    @JsonProperty("p_atrfechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadcrearpatrFechaAntiguedad;

    @JsonProperty("p_atrsegundonombre")
    private String usuarioNovedadcrearpatrSegundoNombre;

    @JsonProperty("p_atrprimerapellido")
    private String usuarioNovedadcrearpatrPrimerApellido;

    @JsonProperty("p_atrsegundoapellido")
    private String usuarioNovedadcrearpatrSegundoApellido;

    @JsonProperty("p_atrnumusuario")
    private Long usuarioNovedadcrearpatrNumUsuario;

    @JsonProperty("p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadcrearpatrFechaNacimiento;

    @JsonProperty("p_atrgenero")
    private String usuarioNovedadcrearpatrGenero;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadcrearpagrFamiliaNovedad();
        checkUsuarioNovedadcrearpatrNumIdentificacion();
        checkUsuarioNovedadcrearpatrNumUsuario();
    }

    @JsonIgnore
    public FamiliaNovedadOid getUsuarioNovedadcrearpagrFamiliaNovedad() {
        return this.usuarioNovedadcrearpagrFamiliaNovedad;
    }
    
    public void setUsuarioNovedadcrearpagrFamiliaNovedad(FamiliaNovedadOid usuarioNovedadcrearpagrFamiliaNovedad) {
        this.usuarioNovedadcrearpagrFamiliaNovedad = usuarioNovedadcrearpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getUsuarioNovedadcrearpagrFamiliaNovedadInstance() {
        return this.usuarioNovedadcrearpagrFamiliaNovedadInstance;
    }
    
    public void setUsuarioNovedadcrearpagrFamiliaNovedadInstance(FamiliaNovedad usuarioNovedadcrearpagrFamiliaNovedad) {
        this.usuarioNovedadcrearpagrFamiliaNovedadInstance = usuarioNovedadcrearpagrFamiliaNovedad;
        this.usuarioNovedadcrearpagrFamiliaNovedad = usuarioNovedadcrearpagrFamiliaNovedad != null ? usuarioNovedadcrearpagrFamiliaNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadcrearpagrFamiliaNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcrearpagrFamiliaNovedadInstance() == null || this.getUsuarioNovedadcrearpagrFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CREAR, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CREAR_USUARIONOVEDADCREARPAGRFAMILIANOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_CREAR, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CREAR_USUARIONOVEDADCREARPAGRFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadcrearpagrTipoIdentificacion() {
        return this.usuarioNovedadcrearpagrTipoIdentificacion;
    }
    
    public void setUsuarioNovedadcrearpagrTipoIdentificacion(TipoIdentificacionOid usuarioNovedadcrearpagrTipoIdentificacion) {
        this.usuarioNovedadcrearpagrTipoIdentificacion = usuarioNovedadcrearpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadcrearpagrTipoIdentificacionInstance() {
        return this.usuarioNovedadcrearpagrTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadcrearpagrTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadcrearpagrTipoIdentificacion) {
        this.usuarioNovedadcrearpagrTipoIdentificacionInstance = usuarioNovedadcrearpagrTipoIdentificacion;
        this.usuarioNovedadcrearpagrTipoIdentificacion = usuarioNovedadcrearpagrTipoIdentificacion != null ? usuarioNovedadcrearpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public ParentescoOid getUsuarioNovedadcrearpagrParentesco() {
        return this.usuarioNovedadcrearpagrParentesco;
    }
    
    public void setUsuarioNovedadcrearpagrParentesco(ParentescoOid usuarioNovedadcrearpagrParentesco) {
        this.usuarioNovedadcrearpagrParentesco = usuarioNovedadcrearpagrParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadcrearpagrParentescoInstance() {
        return this.usuarioNovedadcrearpagrParentescoInstance;
    }
    
    public void setUsuarioNovedadcrearpagrParentescoInstance(Parentesco usuarioNovedadcrearpagrParentesco) {
        this.usuarioNovedadcrearpagrParentescoInstance = usuarioNovedadcrearpagrParentesco;
        this.usuarioNovedadcrearpagrParentesco = usuarioNovedadcrearpagrParentesco != null ? usuarioNovedadcrearpagrParentesco.getOid() : null;
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getUsuarioNovedadcrearpagrEstadoBeneficiario() {
        return this.usuarioNovedadcrearpagrEstadoBeneficiario;
    }
    
    public void setUsuarioNovedadcrearpagrEstadoBeneficiario(EstadoBeneficiarioOid usuarioNovedadcrearpagrEstadoBeneficiario) {
        this.usuarioNovedadcrearpagrEstadoBeneficiario = usuarioNovedadcrearpagrEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getUsuarioNovedadcrearpagrEstadoBeneficiarioInstance() {
        return this.usuarioNovedadcrearpagrEstadoBeneficiarioInstance;
    }
    
    public void setUsuarioNovedadcrearpagrEstadoBeneficiarioInstance(EstadoBeneficiario usuarioNovedadcrearpagrEstadoBeneficiario) {
        this.usuarioNovedadcrearpagrEstadoBeneficiarioInstance = usuarioNovedadcrearpagrEstadoBeneficiario;
        this.usuarioNovedadcrearpagrEstadoBeneficiario = usuarioNovedadcrearpagrEstadoBeneficiario != null ? usuarioNovedadcrearpagrEstadoBeneficiario.getOid() : null;
    }

    @JsonIgnore
    public ParentescoOid getUsuarioNovedadcrearpagrParentescoNuevo() {
        return this.usuarioNovedadcrearpagrParentescoNuevo;
    }
    
    public void setUsuarioNovedadcrearpagrParentescoNuevo(ParentescoOid usuarioNovedadcrearpagrParentescoNuevo) {
        this.usuarioNovedadcrearpagrParentescoNuevo = usuarioNovedadcrearpagrParentescoNuevo;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadcrearpagrParentescoNuevoInstance() {
        return this.usuarioNovedadcrearpagrParentescoNuevoInstance;
    }
    
    public void setUsuarioNovedadcrearpagrParentescoNuevoInstance(Parentesco usuarioNovedadcrearpagrParentescoNuevo) {
        this.usuarioNovedadcrearpagrParentescoNuevoInstance = usuarioNovedadcrearpagrParentescoNuevo;
        this.usuarioNovedadcrearpagrParentescoNuevo = usuarioNovedadcrearpagrParentescoNuevo != null ? usuarioNovedadcrearpagrParentescoNuevo.getOid() : null;
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadcrearpagrTipoIdentificacionCD() {
        return this.usuarioNovedadcrearpagrTipoIdentificacionCD;
    }
    
    public void setUsuarioNovedadcrearpagrTipoIdentificacionCD(TipoIdentificacionOid usuarioNovedadcrearpagrTipoIdentificacionCD) {
        this.usuarioNovedadcrearpagrTipoIdentificacionCD = usuarioNovedadcrearpagrTipoIdentificacionCD;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadcrearpagrTipoIdentificacionCDInstance() {
        return this.usuarioNovedadcrearpagrTipoIdentificacionCDInstance;
    }
    
    public void setUsuarioNovedadcrearpagrTipoIdentificacionCDInstance(TipoIdentificacion usuarioNovedadcrearpagrTipoIdentificacionCD) {
        this.usuarioNovedadcrearpagrTipoIdentificacionCDInstance = usuarioNovedadcrearpagrTipoIdentificacionCD;
        this.usuarioNovedadcrearpagrTipoIdentificacionCD = usuarioNovedadcrearpagrTipoIdentificacionCD != null ? usuarioNovedadcrearpagrTipoIdentificacionCD.getOid() : null;
    }

    @JsonIgnore
    public String getUsuarioNovedadcrearpatrNumIdentificacion() {
        return this.usuarioNovedadcrearpatrNumIdentificacion;
    }
    
    public void setUsuarioNovedadcrearpatrNumIdentificacion(String usuarioNovedadcrearpatrNumIdentificacion) {
        this.usuarioNovedadcrearpatrNumIdentificacion = usuarioNovedadcrearpatrNumIdentificacion;
    }

    private void checkUsuarioNovedadcrearpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcrearpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CREAR, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CREAR_USUARIONOVEDADCREARPATRNUMIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_CREAR, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CREAR_USUARIONOVEDADCREARPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadcrearpatrPrimerNombre() {
        return this.usuarioNovedadcrearpatrPrimerNombre;
    }
    
    public void setUsuarioNovedadcrearpatrPrimerNombre(String usuarioNovedadcrearpatrPrimerNombre) {
        this.usuarioNovedadcrearpatrPrimerNombre = usuarioNovedadcrearpatrPrimerNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadcrearpatrMotivoEstado() {
        return this.usuarioNovedadcrearpatrMotivoEstado;
    }
    
    public void setUsuarioNovedadcrearpatrMotivoEstado(String usuarioNovedadcrearpatrMotivoEstado) {
        this.usuarioNovedadcrearpatrMotivoEstado = usuarioNovedadcrearpatrMotivoEstado;
    }

    @JsonIgnore
    public Date getUsuarioNovedadcrearpatrFechaIniVigencia() {
        return this.usuarioNovedadcrearpatrFechaIniVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadcrearpatrFechaIniVigencia(Date usuarioNovedadcrearpatrFechaIniVigencia) {
        this.usuarioNovedadcrearpatrFechaIniVigencia = usuarioNovedadcrearpatrFechaIniVigencia;
    }

    @JsonIgnore
    public Date getUsuarioNovedadcrearpatrFechaAntiguedad() {
        return this.usuarioNovedadcrearpatrFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadcrearpatrFechaAntiguedad(Date usuarioNovedadcrearpatrFechaAntiguedad) {
        this.usuarioNovedadcrearpatrFechaAntiguedad = usuarioNovedadcrearpatrFechaAntiguedad;
    }

    @JsonIgnore
    public String getUsuarioNovedadcrearpatrSegundoNombre() {
        return this.usuarioNovedadcrearpatrSegundoNombre;
    }
    
    public void setUsuarioNovedadcrearpatrSegundoNombre(String usuarioNovedadcrearpatrSegundoNombre) {
        this.usuarioNovedadcrearpatrSegundoNombre = usuarioNovedadcrearpatrSegundoNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadcrearpatrPrimerApellido() {
        return this.usuarioNovedadcrearpatrPrimerApellido;
    }
    
    public void setUsuarioNovedadcrearpatrPrimerApellido(String usuarioNovedadcrearpatrPrimerApellido) {
        this.usuarioNovedadcrearpatrPrimerApellido = usuarioNovedadcrearpatrPrimerApellido;
    }

    @JsonIgnore
    public String getUsuarioNovedadcrearpatrSegundoApellido() {
        return this.usuarioNovedadcrearpatrSegundoApellido;
    }
    
    public void setUsuarioNovedadcrearpatrSegundoApellido(String usuarioNovedadcrearpatrSegundoApellido) {
        this.usuarioNovedadcrearpatrSegundoApellido = usuarioNovedadcrearpatrSegundoApellido;
    }

    @JsonIgnore
    public Long getUsuarioNovedadcrearpatrNumUsuario() {
        return this.usuarioNovedadcrearpatrNumUsuario;
    }
    
    public void setUsuarioNovedadcrearpatrNumUsuario(Long usuarioNovedadcrearpatrNumUsuario) {
        this.usuarioNovedadcrearpatrNumUsuario = usuarioNovedadcrearpatrNumUsuario;
    }

    private void checkUsuarioNovedadcrearpatrNumUsuario() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcrearpatrNumUsuario() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CREAR, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CREAR_USUARIONOVEDADCREARPATRNUMUSUARIO, UsuarioNovedadConstants.SERV_ALIAS_CREAR, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CREAR_USUARIONOVEDADCREARPATRNUMUSUARIO);
        }
    }

    @JsonIgnore
    public Date getUsuarioNovedadcrearpatrFechaNacimiento() {
        return this.usuarioNovedadcrearpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadcrearpatrFechaNacimiento(Date usuarioNovedadcrearpatrFechaNacimiento) {
        this.usuarioNovedadcrearpatrFechaNacimiento = usuarioNovedadcrearpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getUsuarioNovedadcrearpatrGenero() {
        return this.usuarioNovedadcrearpatrGenero;
    }
    
    public void setUsuarioNovedadcrearpatrGenero(String usuarioNovedadcrearpatrGenero) {
        this.usuarioNovedadcrearpatrGenero = usuarioNovedadcrearpatrGenero;
    }
}
