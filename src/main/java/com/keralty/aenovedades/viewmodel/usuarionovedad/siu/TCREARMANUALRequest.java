package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARMANUALRequest {

    @JsonProperty("pt_p_agrfamilianovedad_oid")
    private FamiliaNovedadOid usuarioNovedadTCREARMANUALptpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad usuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid usuarioNovedadTCREARMANUALptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrparentesco_oid")
    private ParentescoOid usuarioNovedadTCREARMANUALptpagrParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadTCREARMANUALptpagrParentescoInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String usuarioNovedadTCREARMANUALptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrprimernombre")
    private String usuarioNovedadTCREARMANUALptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String usuarioNovedadTCREARMANUALptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String usuarioNovedadTCREARMANUALptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String usuarioNovedadTCREARMANUALptpatrSegundoApellido;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioNovedadTCREARMANUALptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String usuarioNovedadTCREARMANUALptpatrGenero;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadTCREARMANUALptpagrFamiliaNovedad();
        checkUsuarioNovedadTCREARMANUALptpatrNumIdentificacion();
    }

    @JsonIgnore
    public FamiliaNovedadOid getUsuarioNovedadTCREARMANUALptpagrFamiliaNovedad() {
        return this.usuarioNovedadTCREARMANUALptpagrFamiliaNovedad;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpagrFamiliaNovedad(FamiliaNovedadOid usuarioNovedadTCREARMANUALptpagrFamiliaNovedad) {
        this.usuarioNovedadTCREARMANUALptpagrFamiliaNovedad = usuarioNovedadTCREARMANUALptpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getUsuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance() {
        return this.usuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance(FamiliaNovedad usuarioNovedadTCREARMANUALptpagrFamiliaNovedad) {
        this.usuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance = usuarioNovedadTCREARMANUALptpagrFamiliaNovedad;
        this.usuarioNovedadTCREARMANUALptpagrFamiliaNovedad = usuarioNovedadTCREARMANUALptpagrFamiliaNovedad != null ? usuarioNovedadTCREARMANUALptpagrFamiliaNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadTCREARMANUALptpagrFamiliaNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance() == null || this.getUsuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCREARMANUAL, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCREARMANUAL_USUARIONOVEDADTCREARMANUALPTPAGRFAMILIANOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_TCREARMANUAL, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCREARMANUAL_USUARIONOVEDADTCREARMANUALPTPAGRFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadTCREARMANUALptpagrTipoIdentificacion() {
        return this.usuarioNovedadTCREARMANUALptpagrTipoIdentificacion;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpagrTipoIdentificacion(TipoIdentificacionOid usuarioNovedadTCREARMANUALptpagrTipoIdentificacion) {
        this.usuarioNovedadTCREARMANUALptpagrTipoIdentificacion = usuarioNovedadTCREARMANUALptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance() {
        return this.usuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadTCREARMANUALptpagrTipoIdentificacion) {
        this.usuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance = usuarioNovedadTCREARMANUALptpagrTipoIdentificacion;
        this.usuarioNovedadTCREARMANUALptpagrTipoIdentificacion = usuarioNovedadTCREARMANUALptpagrTipoIdentificacion != null ? usuarioNovedadTCREARMANUALptpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public ParentescoOid getUsuarioNovedadTCREARMANUALptpagrParentesco() {
        return this.usuarioNovedadTCREARMANUALptpagrParentesco;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpagrParentesco(ParentescoOid usuarioNovedadTCREARMANUALptpagrParentesco) {
        this.usuarioNovedadTCREARMANUALptpagrParentesco = usuarioNovedadTCREARMANUALptpagrParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadTCREARMANUALptpagrParentescoInstance() {
        return this.usuarioNovedadTCREARMANUALptpagrParentescoInstance;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpagrParentescoInstance(Parentesco usuarioNovedadTCREARMANUALptpagrParentesco) {
        this.usuarioNovedadTCREARMANUALptpagrParentescoInstance = usuarioNovedadTCREARMANUALptpagrParentesco;
        this.usuarioNovedadTCREARMANUALptpagrParentesco = usuarioNovedadTCREARMANUALptpagrParentesco != null ? usuarioNovedadTCREARMANUALptpagrParentesco.getOid() : null;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARMANUALptpatrNumIdentificacion() {
        return this.usuarioNovedadTCREARMANUALptpatrNumIdentificacion;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpatrNumIdentificacion(String usuarioNovedadTCREARMANUALptpatrNumIdentificacion) {
        this.usuarioNovedadTCREARMANUALptpatrNumIdentificacion = usuarioNovedadTCREARMANUALptpatrNumIdentificacion;
    }

    private void checkUsuarioNovedadTCREARMANUALptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCREARMANUALptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCREARMANUAL, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCREARMANUAL_USUARIONOVEDADTCREARMANUALPTPATRNUMIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_TCREARMANUAL, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCREARMANUAL_USUARIONOVEDADTCREARMANUALPTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARMANUALptpatrPrimerNombre() {
        return this.usuarioNovedadTCREARMANUALptpatrPrimerNombre;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpatrPrimerNombre(String usuarioNovedadTCREARMANUALptpatrPrimerNombre) {
        this.usuarioNovedadTCREARMANUALptpatrPrimerNombre = usuarioNovedadTCREARMANUALptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARMANUALptpatrSegundoNombre() {
        return this.usuarioNovedadTCREARMANUALptpatrSegundoNombre;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpatrSegundoNombre(String usuarioNovedadTCREARMANUALptpatrSegundoNombre) {
        this.usuarioNovedadTCREARMANUALptpatrSegundoNombre = usuarioNovedadTCREARMANUALptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARMANUALptpatrPrimerApellido() {
        return this.usuarioNovedadTCREARMANUALptpatrPrimerApellido;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpatrPrimerApellido(String usuarioNovedadTCREARMANUALptpatrPrimerApellido) {
        this.usuarioNovedadTCREARMANUALptpatrPrimerApellido = usuarioNovedadTCREARMANUALptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARMANUALptpatrSegundoApellido() {
        return this.usuarioNovedadTCREARMANUALptpatrSegundoApellido;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpatrSegundoApellido(String usuarioNovedadTCREARMANUALptpatrSegundoApellido) {
        this.usuarioNovedadTCREARMANUALptpatrSegundoApellido = usuarioNovedadTCREARMANUALptpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getUsuarioNovedadTCREARMANUALptpatrFechaNacimiento() {
        return this.usuarioNovedadTCREARMANUALptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioNovedadTCREARMANUALptpatrFechaNacimiento(Date usuarioNovedadTCREARMANUALptpatrFechaNacimiento) {
        this.usuarioNovedadTCREARMANUALptpatrFechaNacimiento = usuarioNovedadTCREARMANUALptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getUsuarioNovedadTCREARMANUALptpatrGenero() {
        return this.usuarioNovedadTCREARMANUALptpatrGenero;
    }
    
    public void setUsuarioNovedadTCREARMANUALptpatrGenero(String usuarioNovedadTCREARMANUALptpatrGenero) {
        this.usuarioNovedadTCREARMANUALptpatrGenero = usuarioNovedadTCREARMANUALptpatrGenero;
    }
}
