package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARUSUMANUALRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_json")
    private String familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrparentesco_json")
    private String familiaNovedadTCREARUSUMANUALptpagrParentesco;
    
    @JsonIgnore
    private Parentesco familiaNovedadTCREARUSUMANUALptpagrParentescoInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String familiaNovedadTCREARUSUMANUALptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrprimernombre")
    private String familiaNovedadTCREARUSUMANUALptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String familiaNovedadTCREARUSUMANUALptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String familiaNovedadTCREARUSUMANUALptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String familiaNovedadTCREARUSUMANUALptpatrSegundoApellido;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaNovedadTCREARUSUMANUALptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String familiaNovedadTCREARUSUMANUALptpatrGenero;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedad();
        checkFamiliaNovedadTCREARUSUMANUALptpatrNumIdentificacion();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedad() {
        return this.familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad) {
        this.familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad = familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad) {
        this.familiaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance = familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad;
        this.familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad = familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad != null ? familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARUSUMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARUSUMANUAL_FAMILIANOVEDADTCREARUSUMANUALPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TCREARUSUMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARUSUMANUAL_FAMILIANOVEDADTCREARUSUMANUALPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpagrTipoIdentificacion() {
        return this.familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpagrTipoIdentificacion(String familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion) {
        this.familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion = familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadTCREARUSUMANUALptpagrTipoIdentificacionInstance() {
        return this.familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpagrTipoIdentificacionInstance(TipoIdentificacion familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion) {
        this.familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacionInstance = familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion;
        this.familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion = familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion != null ? familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpagrParentesco() {
        return this.familiaNovedadTCREARUSUMANUALptpagrParentesco;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpagrParentesco(String familiaNovedadTCREARUSUMANUALptpagrParentesco) {
        this.familiaNovedadTCREARUSUMANUALptpagrParentesco = familiaNovedadTCREARUSUMANUALptpagrParentesco;
    }

    @JsonIgnore
    public Parentesco getFamiliaNovedadTCREARUSUMANUALptpagrParentescoInstance() {
        return this.familiaNovedadTCREARUSUMANUALptpagrParentescoInstance;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpagrParentescoInstance(Parentesco familiaNovedadTCREARUSUMANUALptpagrParentesco) {
        this.familiaNovedadTCREARUSUMANUALptpagrParentescoInstance = familiaNovedadTCREARUSUMANUALptpagrParentesco;
        this.familiaNovedadTCREARUSUMANUALptpagrParentesco = familiaNovedadTCREARUSUMANUALptpagrParentesco != null ? familiaNovedadTCREARUSUMANUALptpagrParentesco.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpatrNumIdentificacion() {
        return this.familiaNovedadTCREARUSUMANUALptpatrNumIdentificacion;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpatrNumIdentificacion(String familiaNovedadTCREARUSUMANUALptpatrNumIdentificacion) {
        this.familiaNovedadTCREARUSUMANUALptpatrNumIdentificacion = familiaNovedadTCREARUSUMANUALptpatrNumIdentificacion;
    }

    private void checkFamiliaNovedadTCREARUSUMANUALptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARUSUMANUALptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARUSUMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARUSUMANUAL_FAMILIANOVEDADTCREARUSUMANUALPTPATRNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TCREARUSUMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARUSUMANUAL_FAMILIANOVEDADTCREARUSUMANUALPTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpatrPrimerNombre() {
        return this.familiaNovedadTCREARUSUMANUALptpatrPrimerNombre;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpatrPrimerNombre(String familiaNovedadTCREARUSUMANUALptpatrPrimerNombre) {
        this.familiaNovedadTCREARUSUMANUALptpatrPrimerNombre = familiaNovedadTCREARUSUMANUALptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpatrSegundoNombre() {
        return this.familiaNovedadTCREARUSUMANUALptpatrSegundoNombre;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpatrSegundoNombre(String familiaNovedadTCREARUSUMANUALptpatrSegundoNombre) {
        this.familiaNovedadTCREARUSUMANUALptpatrSegundoNombre = familiaNovedadTCREARUSUMANUALptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpatrPrimerApellido() {
        return this.familiaNovedadTCREARUSUMANUALptpatrPrimerApellido;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpatrPrimerApellido(String familiaNovedadTCREARUSUMANUALptpatrPrimerApellido) {
        this.familiaNovedadTCREARUSUMANUALptpatrPrimerApellido = familiaNovedadTCREARUSUMANUALptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpatrSegundoApellido() {
        return this.familiaNovedadTCREARUSUMANUALptpatrSegundoApellido;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpatrSegundoApellido(String familiaNovedadTCREARUSUMANUALptpatrSegundoApellido) {
        this.familiaNovedadTCREARUSUMANUALptpatrSegundoApellido = familiaNovedadTCREARUSUMANUALptpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getFamiliaNovedadTCREARUSUMANUALptpatrFechaNacimiento() {
        return this.familiaNovedadTCREARUSUMANUALptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaNovedadTCREARUSUMANUALptpatrFechaNacimiento(Date familiaNovedadTCREARUSUMANUALptpatrFechaNacimiento) {
        this.familiaNovedadTCREARUSUMANUALptpatrFechaNacimiento = familiaNovedadTCREARUSUMANUALptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARUSUMANUALptpatrGenero() {
        return this.familiaNovedadTCREARUSUMANUALptpatrGenero;
    }
    
    public void setFamiliaNovedadTCREARUSUMANUALptpatrGenero(String familiaNovedadTCREARUSUMANUALptpatrGenero) {
        this.familiaNovedadTCREARUSUMANUALptpatrGenero = familiaNovedadTCREARUSUMANUALptpatrGenero;
    }
}
