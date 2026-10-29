package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModificarRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadmodificarpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadmodificarpthisUsuarioNovedadInstance;

    @JsonProperty("p_numidentificacion")
    private String usuarioNovedadmodificarpNumIdentificacion;

    @JsonProperty("p_primernombre")
    private String usuarioNovedadmodificarpPrimerNombre;

    @JsonProperty("p_segundonombre")
    private String usuarioNovedadmodificarpSegundoNombre;

    @JsonProperty("p_primerapellido")
    private String usuarioNovedadmodificarpPrimerApellido;

    @JsonProperty("p_segundoapellido")
    private String usuarioNovedadmodificarpSegundoApellido;

    @JsonProperty("p_genero")
    private String usuarioNovedadmodificarpGenero;

    @JsonProperty("p_fechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadmodificarpFechaNacimiento;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadmodificarpthisUsuarioNovedad();
        checkUsuarioNovedadmodificarpNumIdentificacion();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadmodificarpthisUsuarioNovedad() {
        return this.usuarioNovedadmodificarpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadmodificarpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadmodificarpthisUsuarioNovedad) {
        this.usuarioNovedadmodificarpthisUsuarioNovedad = usuarioNovedadmodificarpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadmodificarpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadmodificarpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadmodificarpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadmodificarpthisUsuarioNovedad) {
        this.usuarioNovedadmodificarpthisUsuarioNovedadInstance = usuarioNovedadmodificarpthisUsuarioNovedad;
        this.usuarioNovedadmodificarpthisUsuarioNovedad = usuarioNovedadmodificarpthisUsuarioNovedad != null ? usuarioNovedadmodificarpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadmodificarpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadmodificarpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadmodificarpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_MODIFICAR, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_MODIFICAR_USUARIONOVEDADMODIFICARPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_MODIFICAR, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_MODIFICAR_USUARIONOVEDADMODIFICARPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadmodificarpNumIdentificacion() {
        return this.usuarioNovedadmodificarpNumIdentificacion;
    }
    
    public void setUsuarioNovedadmodificarpNumIdentificacion(String usuarioNovedadmodificarpNumIdentificacion) {
        this.usuarioNovedadmodificarpNumIdentificacion = usuarioNovedadmodificarpNumIdentificacion;
    }

    private void checkUsuarioNovedadmodificarpNumIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadmodificarpNumIdentificacion() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_MODIFICAR, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_MODIFICAR_USUARIONOVEDADMODIFICARPNUMIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_MODIFICAR, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_MODIFICAR_USUARIONOVEDADMODIFICARPNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadmodificarpPrimerNombre() {
        return this.usuarioNovedadmodificarpPrimerNombre;
    }
    
    public void setUsuarioNovedadmodificarpPrimerNombre(String usuarioNovedadmodificarpPrimerNombre) {
        this.usuarioNovedadmodificarpPrimerNombre = usuarioNovedadmodificarpPrimerNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadmodificarpSegundoNombre() {
        return this.usuarioNovedadmodificarpSegundoNombre;
    }
    
    public void setUsuarioNovedadmodificarpSegundoNombre(String usuarioNovedadmodificarpSegundoNombre) {
        this.usuarioNovedadmodificarpSegundoNombre = usuarioNovedadmodificarpSegundoNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadmodificarpPrimerApellido() {
        return this.usuarioNovedadmodificarpPrimerApellido;
    }
    
    public void setUsuarioNovedadmodificarpPrimerApellido(String usuarioNovedadmodificarpPrimerApellido) {
        this.usuarioNovedadmodificarpPrimerApellido = usuarioNovedadmodificarpPrimerApellido;
    }

    @JsonIgnore
    public String getUsuarioNovedadmodificarpSegundoApellido() {
        return this.usuarioNovedadmodificarpSegundoApellido;
    }
    
    public void setUsuarioNovedadmodificarpSegundoApellido(String usuarioNovedadmodificarpSegundoApellido) {
        this.usuarioNovedadmodificarpSegundoApellido = usuarioNovedadmodificarpSegundoApellido;
    }

    @JsonIgnore
    public String getUsuarioNovedadmodificarpGenero() {
        return this.usuarioNovedadmodificarpGenero;
    }
    
    public void setUsuarioNovedadmodificarpGenero(String usuarioNovedadmodificarpGenero) {
        this.usuarioNovedadmodificarpGenero = usuarioNovedadmodificarpGenero;
    }

    @JsonIgnore
    public Date getUsuarioNovedadmodificarpFechaNacimiento() {
        return this.usuarioNovedadmodificarpFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadmodificarpFechaNacimiento(Date usuarioNovedadmodificarpFechaNacimiento) {
        this.usuarioNovedadmodificarpFechaNacimiento = usuarioNovedadmodificarpFechaNacimiento;
    }
}
