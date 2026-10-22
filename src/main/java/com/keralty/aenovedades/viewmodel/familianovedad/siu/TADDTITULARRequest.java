package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.Pais;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TADDTITULARRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTADDTITULARpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTADDTITULARpthisFamiliaNovedadInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_json")
    private String familiaNovedadTADDTITULARptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrdepartamentonacimiento_json")
    private String familiaNovedadTADDTITULARptpagrDepartamentoNacimiento;
    
    @JsonIgnore
    private Departamento familiaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance;

    @JsonProperty("pt_p_agrmunicipionacimiento_json")
    private String familiaNovedadTADDTITULARptpagrMunicipioNacimiento;
    
    @JsonIgnore
    private Municipio familiaNovedadTADDTITULARptpagrMunicipioNacimientoInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String familiaNovedadTADDTITULARptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrprimernombre")
    private String familiaNovedadTADDTITULARptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String familiaNovedadTADDTITULARptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String familiaNovedadTADDTITULARptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String familiaNovedadTADDTITULARptpatrSegundoApellido;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaNovedadTADDTITULARptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String familiaNovedadTADDTITULARptpatrGenero;

    @JsonProperty("pt_p_atrindicadorextranjero")
    private Boolean familiaNovedadTADDTITULARptpatrIndicadorExtranjero;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String familiaNovedadTADDTITULARptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String familiaNovedadTADDTITULARptpatrTelefonoCelular;

    @JsonProperty("pt_p_atrcorreoelectronico")
    private String familiaNovedadTADDTITULARptpatrCorreoElectronico;

    @JsonProperty("pt_p_agrdepartamento_json")
    private String familiaNovedadTADDTITULARptpagrDepartamento;
    
    @JsonIgnore
    private Departamento familiaNovedadTADDTITULARptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_json")
    private String familiaNovedadTADDTITULARptpagrMunicipio;
    
    @JsonIgnore
    private Municipio familiaNovedadTADDTITULARptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String familiaNovedadTADDTITULARptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean familiaNovedadTADDTITULARptpatrRural;

    @JsonProperty("pt_p_codigo")
    private Long familiaNovedadTADDTITULARptpCodigo;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid familiaNovedadTADDTITULARptpagrPais;
    
    @JsonIgnore
    private Pais familiaNovedadTADDTITULARptpagrPaisInstance;

    @JsonProperty("ptrazonsocial")
    private String familiaNovedadTADDTITULARptRazonSocial;

    @JsonProperty("ptusuexistente_json")
    private String familiaNovedadTADDTITULARptUsuExistente;
    
    @JsonIgnore
    private UsuarioNovedad familiaNovedadTADDTITULARptUsuExistenteInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTADDTITULARpthisFamiliaNovedad();
        checkFamiliaNovedadTADDTITULARptpagrTipoIdentificacion();
        checkFamiliaNovedadTADDTITULARptpatrNumIdentificacion();
        checkFamiliaNovedadTADDTITULARptpatrIndicadorExtranjero();
        checkFamiliaNovedadTADDTITULARptpagrDepartamento();
        checkFamiliaNovedadTADDTITULARptpagrMunicipio();
        checkFamiliaNovedadTADDTITULARptpatrDireccionCompleta();
        checkFamiliaNovedadTADDTITULARptpatrRural();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTADDTITULARpthisFamiliaNovedad() {
        return this.familiaNovedadTADDTITULARpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTADDTITULARpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTADDTITULARpthisFamiliaNovedad) {
        this.familiaNovedadTADDTITULARpthisFamiliaNovedad = familiaNovedadTADDTITULARpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTADDTITULARpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTADDTITULARpthisFamiliaNovedad) {
        this.familiaNovedadTADDTITULARpthisFamiliaNovedadInstance = familiaNovedadTADDTITULARpthisFamiliaNovedad;
        this.familiaNovedadTADDTITULARpthisFamiliaNovedad = familiaNovedadTADDTITULARpthisFamiliaNovedad != null ? familiaNovedadTADDTITULARpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTADDTITULARpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpagrTipoIdentificacion() {
        return this.familiaNovedadTADDTITULARptpagrTipoIdentificacion;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrTipoIdentificacion(String familiaNovedadTADDTITULARptpagrTipoIdentificacion) {
        this.familiaNovedadTADDTITULARptpagrTipoIdentificacion = familiaNovedadTADDTITULARptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance() {
        return this.familiaNovedadTADDTITULARptpagrTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance(TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion) {
        this.familiaNovedadTADDTITULARptpagrTipoIdentificacionInstance = familiaNovedadTADDTITULARptpagrTipoIdentificacion;
        this.familiaNovedadTADDTITULARptpagrTipoIdentificacion = familiaNovedadTADDTITULARptpagrTipoIdentificacion != null ? familiaNovedadTADDTITULARptpagrTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkFamiliaNovedadTADDTITULARptpagrTipoIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance() == null || this.getFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpagrDepartamentoNacimiento() {
        return this.familiaNovedadTADDTITULARptpagrDepartamentoNacimiento;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrDepartamentoNacimiento(String familiaNovedadTADDTITULARptpagrDepartamentoNacimiento) {
        this.familiaNovedadTADDTITULARptpagrDepartamentoNacimiento = familiaNovedadTADDTITULARptpagrDepartamentoNacimiento;
    }

    @JsonIgnore
    public Departamento getFamiliaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance() {
        return this.familiaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance(Departamento familiaNovedadTADDTITULARptpagrDepartamentoNacimiento) {
        this.familiaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance = familiaNovedadTADDTITULARptpagrDepartamentoNacimiento;
        this.familiaNovedadTADDTITULARptpagrDepartamentoNacimiento = familiaNovedadTADDTITULARptpagrDepartamentoNacimiento != null ? familiaNovedadTADDTITULARptpagrDepartamentoNacimiento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpagrMunicipioNacimiento() {
        return this.familiaNovedadTADDTITULARptpagrMunicipioNacimiento;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrMunicipioNacimiento(String familiaNovedadTADDTITULARptpagrMunicipioNacimiento) {
        this.familiaNovedadTADDTITULARptpagrMunicipioNacimiento = familiaNovedadTADDTITULARptpagrMunicipioNacimiento;
    }

    @JsonIgnore
    public Municipio getFamiliaNovedadTADDTITULARptpagrMunicipioNacimientoInstance() {
        return this.familiaNovedadTADDTITULARptpagrMunicipioNacimientoInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrMunicipioNacimientoInstance(Municipio familiaNovedadTADDTITULARptpagrMunicipioNacimiento) {
        this.familiaNovedadTADDTITULARptpagrMunicipioNacimientoInstance = familiaNovedadTADDTITULARptpagrMunicipioNacimiento;
        this.familiaNovedadTADDTITULARptpagrMunicipioNacimiento = familiaNovedadTADDTITULARptpagrMunicipioNacimiento != null ? familiaNovedadTADDTITULARptpagrMunicipioNacimiento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrNumIdentificacion() {
        return this.familiaNovedadTADDTITULARptpatrNumIdentificacion;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrNumIdentificacion(String familiaNovedadTADDTITULARptpatrNumIdentificacion) {
        this.familiaNovedadTADDTITULARptpatrNumIdentificacion = familiaNovedadTADDTITULARptpatrNumIdentificacion;
    }

    private void checkFamiliaNovedadTADDTITULARptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrPrimerNombre() {
        return this.familiaNovedadTADDTITULARptpatrPrimerNombre;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrPrimerNombre(String familiaNovedadTADDTITULARptpatrPrimerNombre) {
        this.familiaNovedadTADDTITULARptpatrPrimerNombre = familiaNovedadTADDTITULARptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrSegundoNombre() {
        return this.familiaNovedadTADDTITULARptpatrSegundoNombre;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrSegundoNombre(String familiaNovedadTADDTITULARptpatrSegundoNombre) {
        this.familiaNovedadTADDTITULARptpatrSegundoNombre = familiaNovedadTADDTITULARptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrPrimerApellido() {
        return this.familiaNovedadTADDTITULARptpatrPrimerApellido;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrPrimerApellido(String familiaNovedadTADDTITULARptpatrPrimerApellido) {
        this.familiaNovedadTADDTITULARptpatrPrimerApellido = familiaNovedadTADDTITULARptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrSegundoApellido() {
        return this.familiaNovedadTADDTITULARptpatrSegundoApellido;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrSegundoApellido(String familiaNovedadTADDTITULARptpatrSegundoApellido) {
        this.familiaNovedadTADDTITULARptpatrSegundoApellido = familiaNovedadTADDTITULARptpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getFamiliaNovedadTADDTITULARptpatrFechaNacimiento() {
        return this.familiaNovedadTADDTITULARptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaNovedadTADDTITULARptpatrFechaNacimiento(Date familiaNovedadTADDTITULARptpatrFechaNacimiento) {
        this.familiaNovedadTADDTITULARptpatrFechaNacimiento = familiaNovedadTADDTITULARptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrGenero() {
        return this.familiaNovedadTADDTITULARptpatrGenero;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrGenero(String familiaNovedadTADDTITULARptpatrGenero) {
        this.familiaNovedadTADDTITULARptpatrGenero = familiaNovedadTADDTITULARptpatrGenero;
    }

    @JsonIgnore
    public Boolean getFamiliaNovedadTADDTITULARptpatrIndicadorExtranjero() {
        return this.familiaNovedadTADDTITULARptpatrIndicadorExtranjero;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrIndicadorExtranjero(Boolean familiaNovedadTADDTITULARptpatrIndicadorExtranjero) {
        this.familiaNovedadTADDTITULARptpatrIndicadorExtranjero = familiaNovedadTADDTITULARptpatrIndicadorExtranjero;
    }

    private void checkFamiliaNovedadTADDTITULARptpatrIndicadorExtranjero() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARptpatrIndicadorExtranjero() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRINDICADOREXTRANJERO, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRINDICADOREXTRANJERO);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrTelefonoFijo() {
        return this.familiaNovedadTADDTITULARptpatrTelefonoFijo;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrTelefonoFijo(String familiaNovedadTADDTITULARptpatrTelefonoFijo) {
        this.familiaNovedadTADDTITULARptpatrTelefonoFijo = familiaNovedadTADDTITULARptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrTelefonoCelular() {
        return this.familiaNovedadTADDTITULARptpatrTelefonoCelular;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrTelefonoCelular(String familiaNovedadTADDTITULARptpatrTelefonoCelular) {
        this.familiaNovedadTADDTITULARptpatrTelefonoCelular = familiaNovedadTADDTITULARptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrCorreoElectronico() {
        return this.familiaNovedadTADDTITULARptpatrCorreoElectronico;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrCorreoElectronico(String familiaNovedadTADDTITULARptpatrCorreoElectronico) {
        this.familiaNovedadTADDTITULARptpatrCorreoElectronico = familiaNovedadTADDTITULARptpatrCorreoElectronico;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpagrDepartamento() {
        return this.familiaNovedadTADDTITULARptpagrDepartamento;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrDepartamento(String familiaNovedadTADDTITULARptpagrDepartamento) {
        this.familiaNovedadTADDTITULARptpagrDepartamento = familiaNovedadTADDTITULARptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getFamiliaNovedadTADDTITULARptpagrDepartamentoInstance() {
        return this.familiaNovedadTADDTITULARptpagrDepartamentoInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrDepartamentoInstance(Departamento familiaNovedadTADDTITULARptpagrDepartamento) {
        this.familiaNovedadTADDTITULARptpagrDepartamentoInstance = familiaNovedadTADDTITULARptpagrDepartamento;
        this.familiaNovedadTADDTITULARptpagrDepartamento = familiaNovedadTADDTITULARptpagrDepartamento != null ? familiaNovedadTADDTITULARptpagrDepartamento.getOid().toJson() : "";
    }

    private void checkFamiliaNovedadTADDTITULARptpagrDepartamento() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARptpagrDepartamentoInstance() == null || this.getFamiliaNovedadTADDTITULARptpagrDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRDEPARTAMENTO, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpagrMunicipio() {
        return this.familiaNovedadTADDTITULARptpagrMunicipio;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrMunicipio(String familiaNovedadTADDTITULARptpagrMunicipio) {
        this.familiaNovedadTADDTITULARptpagrMunicipio = familiaNovedadTADDTITULARptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getFamiliaNovedadTADDTITULARptpagrMunicipioInstance() {
        return this.familiaNovedadTADDTITULARptpagrMunicipioInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrMunicipioInstance(Municipio familiaNovedadTADDTITULARptpagrMunicipio) {
        this.familiaNovedadTADDTITULARptpagrMunicipioInstance = familiaNovedadTADDTITULARptpagrMunicipio;
        this.familiaNovedadTADDTITULARptpagrMunicipio = familiaNovedadTADDTITULARptpagrMunicipio != null ? familiaNovedadTADDTITULARptpagrMunicipio.getOid().toJson() : "";
    }

    private void checkFamiliaNovedadTADDTITULARptpagrMunicipio() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARptpagrMunicipioInstance() == null || this.getFamiliaNovedadTADDTITULARptpagrMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRMUNICIPIO, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRMUNICIPIO);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptpatrDireccionCompleta() {
        return this.familiaNovedadTADDTITULARptpatrDireccionCompleta;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrDireccionCompleta(String familiaNovedadTADDTITULARptpatrDireccionCompleta) {
        this.familiaNovedadTADDTITULARptpatrDireccionCompleta = familiaNovedadTADDTITULARptpatrDireccionCompleta;
    }

    private void checkFamiliaNovedadTADDTITULARptpatrDireccionCompleta() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARptpatrDireccionCompleta() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRDIRECCIONCOMPLETA, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRDIRECCIONCOMPLETA);
        }
    }

    @JsonIgnore
    public Boolean getFamiliaNovedadTADDTITULARptpatrRural() {
        return this.familiaNovedadTADDTITULARptpatrRural;
    }
    
    public void setFamiliaNovedadTADDTITULARptpatrRural(Boolean familiaNovedadTADDTITULARptpatrRural) {
        this.familiaNovedadTADDTITULARptpatrRural = familiaNovedadTADDTITULARptpatrRural;
    }

    private void checkFamiliaNovedadTADDTITULARptpatrRural() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTADDTITULARptpatrRural() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TADDTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRRURAL, FamiliaNovedadConstants.SERV_ALIAS_TADDTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPATRRURAL);
        }
    }

    @JsonIgnore
    public Long getFamiliaNovedadTADDTITULARptpCodigo() {
        return this.familiaNovedadTADDTITULARptpCodigo;
    }
    
    public void setFamiliaNovedadTADDTITULARptpCodigo(Long familiaNovedadTADDTITULARptpCodigo) {
        this.familiaNovedadTADDTITULARptpCodigo = familiaNovedadTADDTITULARptpCodigo;
    }

    @JsonIgnore
    public PaisOid getFamiliaNovedadTADDTITULARptpagrPais() {
        return this.familiaNovedadTADDTITULARptpagrPais;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrPais(PaisOid familiaNovedadTADDTITULARptpagrPais) {
        this.familiaNovedadTADDTITULARptpagrPais = familiaNovedadTADDTITULARptpagrPais;
    }

    @JsonIgnore
    public Pais getFamiliaNovedadTADDTITULARptpagrPaisInstance() {
        return this.familiaNovedadTADDTITULARptpagrPaisInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARptpagrPaisInstance(Pais familiaNovedadTADDTITULARptpagrPais) {
        this.familiaNovedadTADDTITULARptpagrPaisInstance = familiaNovedadTADDTITULARptpagrPais;
        this.familiaNovedadTADDTITULARptpagrPais = familiaNovedadTADDTITULARptpagrPais != null ? familiaNovedadTADDTITULARptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptRazonSocial() {
        return this.familiaNovedadTADDTITULARptRazonSocial;
    }
    
    public void setFamiliaNovedadTADDTITULARptRazonSocial(String familiaNovedadTADDTITULARptRazonSocial) {
        this.familiaNovedadTADDTITULARptRazonSocial = familiaNovedadTADDTITULARptRazonSocial;
    }

    @JsonIgnore
    public String getFamiliaNovedadTADDTITULARptUsuExistente() {
        return this.familiaNovedadTADDTITULARptUsuExistente;
    }
    
    public void setFamiliaNovedadTADDTITULARptUsuExistente(String familiaNovedadTADDTITULARptUsuExistente) {
        this.familiaNovedadTADDTITULARptUsuExistente = familiaNovedadTADDTITULARptUsuExistente;
    }

    @JsonIgnore
    public UsuarioNovedad getFamiliaNovedadTADDTITULARptUsuExistenteInstance() {
        return this.familiaNovedadTADDTITULARptUsuExistenteInstance;
    }
    
    public void setFamiliaNovedadTADDTITULARptUsuExistenteInstance(UsuarioNovedad familiaNovedadTADDTITULARptUsuExistente) {
        this.familiaNovedadTADDTITULARptUsuExistenteInstance = familiaNovedadTADDTITULARptUsuExistente;
        this.familiaNovedadTADDTITULARptUsuExistente = familiaNovedadTADDTITULARptUsuExistente != null ? familiaNovedadTADDTITULARptUsuExistente.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
