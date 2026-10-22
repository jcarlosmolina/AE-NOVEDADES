package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TMODIFICARMANUALRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance;

    @JsonProperty("pt_p_numidentificacion")
    private String usuarioNovedadTMODIFICARMANUALptpNumIdentificacion;

    @JsonProperty("pt_p_primernombre")
    private String usuarioNovedadTMODIFICARMANUALptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String usuarioNovedadTMODIFICARMANUALptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String usuarioNovedadTMODIFICARMANUALptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String usuarioNovedadTMODIFICARMANUALptpSegundoApellido;

    @JsonProperty("pt_p_genero")
    private String usuarioNovedadTMODIFICARMANUALptpGenero;

    @JsonProperty("pt_p_fechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadTMODIFICARMANUALptpFechaNacimiento;

    @JsonProperty("pttipoidentificacion_json")
    private String usuarioNovedadTMODIFICARMANUALptTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance;

    @JsonProperty("ptparentesco_json")
    private String usuarioNovedadTMODIFICARMANUALptParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadTMODIFICARMANUALptParentescoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad();
        checkUsuarioNovedadTMODIFICARMANUALptpNumIdentificacion();
        checkUsuarioNovedadTMODIFICARMANUALptTipoIdentificacion();
        checkUsuarioNovedadTMODIFICARMANUALptParentesco();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad() {
        return this.usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad) {
        this.usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad = usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad) {
        this.usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance = usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad;
        this.usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad = usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad != null ? usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptpNumIdentificacion() {
        return this.usuarioNovedadTMODIFICARMANUALptpNumIdentificacion;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptpNumIdentificacion(String usuarioNovedadTMODIFICARMANUALptpNumIdentificacion) {
        this.usuarioNovedadTMODIFICARMANUALptpNumIdentificacion = usuarioNovedadTMODIFICARMANUALptpNumIdentificacion;
    }

    private void checkUsuarioNovedadTMODIFICARMANUALptpNumIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTMODIFICARMANUALptpNumIdentificacion() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTPNUMIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTPNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptpPrimerNombre() {
        return this.usuarioNovedadTMODIFICARMANUALptpPrimerNombre;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptpPrimerNombre(String usuarioNovedadTMODIFICARMANUALptpPrimerNombre) {
        this.usuarioNovedadTMODIFICARMANUALptpPrimerNombre = usuarioNovedadTMODIFICARMANUALptpPrimerNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptpSegundoNombre() {
        return this.usuarioNovedadTMODIFICARMANUALptpSegundoNombre;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptpSegundoNombre(String usuarioNovedadTMODIFICARMANUALptpSegundoNombre) {
        this.usuarioNovedadTMODIFICARMANUALptpSegundoNombre = usuarioNovedadTMODIFICARMANUALptpSegundoNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptpPrimerApellido() {
        return this.usuarioNovedadTMODIFICARMANUALptpPrimerApellido;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptpPrimerApellido(String usuarioNovedadTMODIFICARMANUALptpPrimerApellido) {
        this.usuarioNovedadTMODIFICARMANUALptpPrimerApellido = usuarioNovedadTMODIFICARMANUALptpPrimerApellido;
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptpSegundoApellido() {
        return this.usuarioNovedadTMODIFICARMANUALptpSegundoApellido;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptpSegundoApellido(String usuarioNovedadTMODIFICARMANUALptpSegundoApellido) {
        this.usuarioNovedadTMODIFICARMANUALptpSegundoApellido = usuarioNovedadTMODIFICARMANUALptpSegundoApellido;
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptpGenero() {
        return this.usuarioNovedadTMODIFICARMANUALptpGenero;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptpGenero(String usuarioNovedadTMODIFICARMANUALptpGenero) {
        this.usuarioNovedadTMODIFICARMANUALptpGenero = usuarioNovedadTMODIFICARMANUALptpGenero;
    }

    @JsonIgnore
    public Date getUsuarioNovedadTMODIFICARMANUALptpFechaNacimiento() {
        return this.usuarioNovedadTMODIFICARMANUALptpFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadTMODIFICARMANUALptpFechaNacimiento(Date usuarioNovedadTMODIFICARMANUALptpFechaNacimiento) {
        this.usuarioNovedadTMODIFICARMANUALptpFechaNacimiento = usuarioNovedadTMODIFICARMANUALptpFechaNacimiento;
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptTipoIdentificacion() {
        return this.usuarioNovedadTMODIFICARMANUALptTipoIdentificacion;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptTipoIdentificacion(String usuarioNovedadTMODIFICARMANUALptTipoIdentificacion) {
        this.usuarioNovedadTMODIFICARMANUALptTipoIdentificacion = usuarioNovedadTMODIFICARMANUALptTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance() {
        return this.usuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadTMODIFICARMANUALptTipoIdentificacion) {
        this.usuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance = usuarioNovedadTMODIFICARMANUALptTipoIdentificacion;
        this.usuarioNovedadTMODIFICARMANUALptTipoIdentificacion = usuarioNovedadTMODIFICARMANUALptTipoIdentificacion != null ? usuarioNovedadTMODIFICARMANUALptTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkUsuarioNovedadTMODIFICARMANUALptTipoIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance() == null || this.getUsuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTTIPOIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTMODIFICARMANUALptParentesco() {
        return this.usuarioNovedadTMODIFICARMANUALptParentesco;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptParentesco(String usuarioNovedadTMODIFICARMANUALptParentesco) {
        this.usuarioNovedadTMODIFICARMANUALptParentesco = usuarioNovedadTMODIFICARMANUALptParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadTMODIFICARMANUALptParentescoInstance() {
        return this.usuarioNovedadTMODIFICARMANUALptParentescoInstance;
    }
    
    public void setUsuarioNovedadTMODIFICARMANUALptParentescoInstance(Parentesco usuarioNovedadTMODIFICARMANUALptParentesco) {
        this.usuarioNovedadTMODIFICARMANUALptParentescoInstance = usuarioNovedadTMODIFICARMANUALptParentesco;
        this.usuarioNovedadTMODIFICARMANUALptParentesco = usuarioNovedadTMODIFICARMANUALptParentesco != null ? usuarioNovedadTMODIFICARMANUALptParentesco.getOid().toJson() : "";
    }

    private void checkUsuarioNovedadTMODIFICARMANUALptParentesco() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTMODIFICARMANUALptParentescoInstance() == null || this.getUsuarioNovedadTMODIFICARMANUALptParentescoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTPARENTESCO, UsuarioNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_USUARIONOVEDADTMODIFICARMANUALPTPARENTESCO);
        }
    }
}
