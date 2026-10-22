package com.keralty.aenovedades.viewmodel.novedadct.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.oid.DepartamentoOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.MunicipioOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Pais;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARRequest {

    @JsonProperty("pt_p_agrfamilianovedad_oid")
    private FamiliaNovedadOid novedadCTTCREARptpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad novedadCTTCREARptpagrFamiliaNovedadInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid novedadCTTCREARptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion novedadCTTCREARptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrmunicipionac_oid")
    private MunicipioOid novedadCTTCREARptpagrMunicipioNac;
    
    @JsonIgnore
    private Municipio novedadCTTCREARptpagrMunicipioNacInstance;

    @JsonProperty("pt_p_agrmunicipiores_oid")
    private MunicipioOid novedadCTTCREARptpagrMunicipioRes;
    
    @JsonIgnore
    private Municipio novedadCTTCREARptpagrMunicipioResInstance;

    @JsonProperty("pt_p_agrdepartamentonac_oid")
    private DepartamentoOid novedadCTTCREARptpagrDepartamentoNac;
    
    @JsonIgnore
    private Departamento novedadCTTCREARptpagrDepartamentoNacInstance;

    @JsonProperty("pt_p_agrdepartamentores_oid")
    private DepartamentoOid novedadCTTCREARptpagrDepartamentoRes;
    
    @JsonIgnore
    private Departamento novedadCTTCREARptpagrDepartamentoResInstance;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid novedadCTTCREARptpagrPais;
    
    @JsonIgnore
    private Pais novedadCTTCREARptpagrPaisInstance;

    @JsonProperty("pt_p_atrtitnumidentificacion")
    private String novedadCTTCREARptpatrTitNumidentificacion;

    @JsonProperty("pt_p_atrtitprimernombre")
    private String novedadCTTCREARptpatrTitPrimerNombre;

    @JsonProperty("pt_p_atrtittienebeneficios")
    private Boolean novedadCTTCREARptpatrTitTieneBeneficios;

    @JsonProperty("pt_p_atrtitsegundonombre")
    private String novedadCTTCREARptpatrTitSegundoNombre;

    @JsonProperty("pt_p_atrtitprimerapellido")
    private String novedadCTTCREARptpatrTitPrimerApellido;

    @JsonProperty("pt_p_atrtitsegundoapellido")
    private String novedadCTTCREARptpatrTitSegundoApellido;

    @JsonProperty("pt_p_atrtitrazonsocial")
    private String novedadCTTCREARptpatrTitRazonSocial;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date novedadCTTCREARptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String novedadCTTCREARptpatrGenero;

    @JsonProperty("pt_p_atrindicadorextranjero")
    private Boolean novedadCTTCREARptpatrIndicadorExtranjero;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String novedadCTTCREARptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String novedadCTTCREARptpatrTelefonoCelular;

    @JsonProperty("pt_p_atrcorreoelectronico")
    private String novedadCTTCREARptpatrCorreoElectronico;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String novedadCTTCREARptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean novedadCTTCREARptpatrRural;

    @JsonProperty("pt_p_atrcodigocore")
    private Long novedadCTTCREARptpatrCodigoCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadCTTCREARptpagrFamiliaNovedad();
        checkNovedadCTTCREARptpagrTipoIdentificacion();
        checkNovedadCTTCREARptpatrTitNumidentificacion();
        checkNovedadCTTCREARptpatrTitTieneBeneficios();
    }

    @JsonIgnore
    public FamiliaNovedadOid getNovedadCTTCREARptpagrFamiliaNovedad() {
        return this.novedadCTTCREARptpagrFamiliaNovedad;
    }
    
    public void setNovedadCTTCREARptpagrFamiliaNovedad(FamiliaNovedadOid novedadCTTCREARptpagrFamiliaNovedad) {
        this.novedadCTTCREARptpagrFamiliaNovedad = novedadCTTCREARptpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getNovedadCTTCREARptpagrFamiliaNovedadInstance() {
        return this.novedadCTTCREARptpagrFamiliaNovedadInstance;
    }
    
    public void setNovedadCTTCREARptpagrFamiliaNovedadInstance(FamiliaNovedad novedadCTTCREARptpagrFamiliaNovedad) {
        this.novedadCTTCREARptpagrFamiliaNovedadInstance = novedadCTTCREARptpagrFamiliaNovedad;
        this.novedadCTTCREARptpagrFamiliaNovedad = novedadCTTCREARptpagrFamiliaNovedad != null ? novedadCTTCREARptpagrFamiliaNovedad.getOid() : null;
    }

    private void checkNovedadCTTCREARptpagrFamiliaNovedad() throws NotNullArgumentException {
        if(this.getNovedadCTTCREARptpagrFamiliaNovedadInstance() == null || this.getNovedadCTTCREARptpagrFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_TCREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_TCREAR_NOVEDADCTTCREARPTPAGRFAMILIANOVEDAD, NovedadCTConstants.SERV_ALIAS_TCREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_TCREAR_NOVEDADCTTCREARPTPAGRFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getNovedadCTTCREARptpagrTipoIdentificacion() {
        return this.novedadCTTCREARptpagrTipoIdentificacion;
    }
    
    public void setNovedadCTTCREARptpagrTipoIdentificacion(TipoIdentificacionOid novedadCTTCREARptpagrTipoIdentificacion) {
        this.novedadCTTCREARptpagrTipoIdentificacion = novedadCTTCREARptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getNovedadCTTCREARptpagrTipoIdentificacionInstance() {
        return this.novedadCTTCREARptpagrTipoIdentificacionInstance;
    }
    
    public void setNovedadCTTCREARptpagrTipoIdentificacionInstance(TipoIdentificacion novedadCTTCREARptpagrTipoIdentificacion) {
        this.novedadCTTCREARptpagrTipoIdentificacionInstance = novedadCTTCREARptpagrTipoIdentificacion;
        this.novedadCTTCREARptpagrTipoIdentificacion = novedadCTTCREARptpagrTipoIdentificacion != null ? novedadCTTCREARptpagrTipoIdentificacion.getOid() : null;
    }

    private void checkNovedadCTTCREARptpagrTipoIdentificacion() throws NotNullArgumentException {
        if(this.getNovedadCTTCREARptpagrTipoIdentificacionInstance() == null || this.getNovedadCTTCREARptpagrTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_TCREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_TCREAR_NOVEDADCTTCREARPTPAGRTIPOIDENTIFICACION, NovedadCTConstants.SERV_ALIAS_TCREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_TCREAR_NOVEDADCTTCREARPTPAGRTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public MunicipioOid getNovedadCTTCREARptpagrMunicipioNac() {
        return this.novedadCTTCREARptpagrMunicipioNac;
    }
    
    public void setNovedadCTTCREARptpagrMunicipioNac(MunicipioOid novedadCTTCREARptpagrMunicipioNac) {
        this.novedadCTTCREARptpagrMunicipioNac = novedadCTTCREARptpagrMunicipioNac;
    }

    @JsonIgnore
    public Municipio getNovedadCTTCREARptpagrMunicipioNacInstance() {
        return this.novedadCTTCREARptpagrMunicipioNacInstance;
    }
    
    public void setNovedadCTTCREARptpagrMunicipioNacInstance(Municipio novedadCTTCREARptpagrMunicipioNac) {
        this.novedadCTTCREARptpagrMunicipioNacInstance = novedadCTTCREARptpagrMunicipioNac;
        this.novedadCTTCREARptpagrMunicipioNac = novedadCTTCREARptpagrMunicipioNac != null ? novedadCTTCREARptpagrMunicipioNac.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getNovedadCTTCREARptpagrMunicipioRes() {
        return this.novedadCTTCREARptpagrMunicipioRes;
    }
    
    public void setNovedadCTTCREARptpagrMunicipioRes(MunicipioOid novedadCTTCREARptpagrMunicipioRes) {
        this.novedadCTTCREARptpagrMunicipioRes = novedadCTTCREARptpagrMunicipioRes;
    }

    @JsonIgnore
    public Municipio getNovedadCTTCREARptpagrMunicipioResInstance() {
        return this.novedadCTTCREARptpagrMunicipioResInstance;
    }
    
    public void setNovedadCTTCREARptpagrMunicipioResInstance(Municipio novedadCTTCREARptpagrMunicipioRes) {
        this.novedadCTTCREARptpagrMunicipioResInstance = novedadCTTCREARptpagrMunicipioRes;
        this.novedadCTTCREARptpagrMunicipioRes = novedadCTTCREARptpagrMunicipioRes != null ? novedadCTTCREARptpagrMunicipioRes.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getNovedadCTTCREARptpagrDepartamentoNac() {
        return this.novedadCTTCREARptpagrDepartamentoNac;
    }
    
    public void setNovedadCTTCREARptpagrDepartamentoNac(DepartamentoOid novedadCTTCREARptpagrDepartamentoNac) {
        this.novedadCTTCREARptpagrDepartamentoNac = novedadCTTCREARptpagrDepartamentoNac;
    }

    @JsonIgnore
    public Departamento getNovedadCTTCREARptpagrDepartamentoNacInstance() {
        return this.novedadCTTCREARptpagrDepartamentoNacInstance;
    }
    
    public void setNovedadCTTCREARptpagrDepartamentoNacInstance(Departamento novedadCTTCREARptpagrDepartamentoNac) {
        this.novedadCTTCREARptpagrDepartamentoNacInstance = novedadCTTCREARptpagrDepartamentoNac;
        this.novedadCTTCREARptpagrDepartamentoNac = novedadCTTCREARptpagrDepartamentoNac != null ? novedadCTTCREARptpagrDepartamentoNac.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getNovedadCTTCREARptpagrDepartamentoRes() {
        return this.novedadCTTCREARptpagrDepartamentoRes;
    }
    
    public void setNovedadCTTCREARptpagrDepartamentoRes(DepartamentoOid novedadCTTCREARptpagrDepartamentoRes) {
        this.novedadCTTCREARptpagrDepartamentoRes = novedadCTTCREARptpagrDepartamentoRes;
    }

    @JsonIgnore
    public Departamento getNovedadCTTCREARptpagrDepartamentoResInstance() {
        return this.novedadCTTCREARptpagrDepartamentoResInstance;
    }
    
    public void setNovedadCTTCREARptpagrDepartamentoResInstance(Departamento novedadCTTCREARptpagrDepartamentoRes) {
        this.novedadCTTCREARptpagrDepartamentoResInstance = novedadCTTCREARptpagrDepartamentoRes;
        this.novedadCTTCREARptpagrDepartamentoRes = novedadCTTCREARptpagrDepartamentoRes != null ? novedadCTTCREARptpagrDepartamentoRes.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getNovedadCTTCREARptpagrPais() {
        return this.novedadCTTCREARptpagrPais;
    }
    
    public void setNovedadCTTCREARptpagrPais(PaisOid novedadCTTCREARptpagrPais) {
        this.novedadCTTCREARptpagrPais = novedadCTTCREARptpagrPais;
    }

    @JsonIgnore
    public Pais getNovedadCTTCREARptpagrPaisInstance() {
        return this.novedadCTTCREARptpagrPaisInstance;
    }
    
    public void setNovedadCTTCREARptpagrPaisInstance(Pais novedadCTTCREARptpagrPais) {
        this.novedadCTTCREARptpagrPaisInstance = novedadCTTCREARptpagrPais;
        this.novedadCTTCREARptpagrPais = novedadCTTCREARptpagrPais != null ? novedadCTTCREARptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTitNumidentificacion() {
        return this.novedadCTTCREARptpatrTitNumidentificacion;
    }
    
    public void setNovedadCTTCREARptpatrTitNumidentificacion(String novedadCTTCREARptpatrTitNumidentificacion) {
        this.novedadCTTCREARptpatrTitNumidentificacion = novedadCTTCREARptpatrTitNumidentificacion;
    }

    private void checkNovedadCTTCREARptpatrTitNumidentificacion() throws NotNullArgumentException {
        if(this.getNovedadCTTCREARptpatrTitNumidentificacion() == null) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_TCREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_TCREAR_NOVEDADCTTCREARPTPATRTITNUMIDENTIFICACION, NovedadCTConstants.SERV_ALIAS_TCREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_TCREAR_NOVEDADCTTCREARPTPATRTITNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTitPrimerNombre() {
        return this.novedadCTTCREARptpatrTitPrimerNombre;
    }
    
    public void setNovedadCTTCREARptpatrTitPrimerNombre(String novedadCTTCREARptpatrTitPrimerNombre) {
        this.novedadCTTCREARptpatrTitPrimerNombre = novedadCTTCREARptpatrTitPrimerNombre;
    }

    @JsonIgnore
    public Boolean getNovedadCTTCREARptpatrTitTieneBeneficios() {
        return this.novedadCTTCREARptpatrTitTieneBeneficios;
    }
    
    public void setNovedadCTTCREARptpatrTitTieneBeneficios(Boolean novedadCTTCREARptpatrTitTieneBeneficios) {
        this.novedadCTTCREARptpatrTitTieneBeneficios = novedadCTTCREARptpatrTitTieneBeneficios;
    }

    private void checkNovedadCTTCREARptpatrTitTieneBeneficios() throws NotNullArgumentException {
        if(this.getNovedadCTTCREARptpatrTitTieneBeneficios() == null) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_TCREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_TCREAR_NOVEDADCTTCREARPTPATRTITTIENEBENEFICIOS, NovedadCTConstants.SERV_ALIAS_TCREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_TCREAR_NOVEDADCTTCREARPTPATRTITTIENEBENEFICIOS);
        }
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTitSegundoNombre() {
        return this.novedadCTTCREARptpatrTitSegundoNombre;
    }
    
    public void setNovedadCTTCREARptpatrTitSegundoNombre(String novedadCTTCREARptpatrTitSegundoNombre) {
        this.novedadCTTCREARptpatrTitSegundoNombre = novedadCTTCREARptpatrTitSegundoNombre;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTitPrimerApellido() {
        return this.novedadCTTCREARptpatrTitPrimerApellido;
    }
    
    public void setNovedadCTTCREARptpatrTitPrimerApellido(String novedadCTTCREARptpatrTitPrimerApellido) {
        this.novedadCTTCREARptpatrTitPrimerApellido = novedadCTTCREARptpatrTitPrimerApellido;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTitSegundoApellido() {
        return this.novedadCTTCREARptpatrTitSegundoApellido;
    }
    
    public void setNovedadCTTCREARptpatrTitSegundoApellido(String novedadCTTCREARptpatrTitSegundoApellido) {
        this.novedadCTTCREARptpatrTitSegundoApellido = novedadCTTCREARptpatrTitSegundoApellido;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTitRazonSocial() {
        return this.novedadCTTCREARptpatrTitRazonSocial;
    }
    
    public void setNovedadCTTCREARptpatrTitRazonSocial(String novedadCTTCREARptpatrTitRazonSocial) {
        this.novedadCTTCREARptpatrTitRazonSocial = novedadCTTCREARptpatrTitRazonSocial;
    }

    @JsonIgnore
    public Date getNovedadCTTCREARptpatrFechaNacimiento() {
        return this.novedadCTTCREARptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setNovedadCTTCREARptpatrFechaNacimiento(Date novedadCTTCREARptpatrFechaNacimiento) {
        this.novedadCTTCREARptpatrFechaNacimiento = novedadCTTCREARptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrGenero() {
        return this.novedadCTTCREARptpatrGenero;
    }
    
    public void setNovedadCTTCREARptpatrGenero(String novedadCTTCREARptpatrGenero) {
        this.novedadCTTCREARptpatrGenero = novedadCTTCREARptpatrGenero;
    }

    @JsonIgnore
    public Boolean getNovedadCTTCREARptpatrIndicadorExtranjero() {
        return this.novedadCTTCREARptpatrIndicadorExtranjero;
    }
    
    public void setNovedadCTTCREARptpatrIndicadorExtranjero(Boolean novedadCTTCREARptpatrIndicadorExtranjero) {
        this.novedadCTTCREARptpatrIndicadorExtranjero = novedadCTTCREARptpatrIndicadorExtranjero;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTelefonoFijo() {
        return this.novedadCTTCREARptpatrTelefonoFijo;
    }
    
    public void setNovedadCTTCREARptpatrTelefonoFijo(String novedadCTTCREARptpatrTelefonoFijo) {
        this.novedadCTTCREARptpatrTelefonoFijo = novedadCTTCREARptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrTelefonoCelular() {
        return this.novedadCTTCREARptpatrTelefonoCelular;
    }
    
    public void setNovedadCTTCREARptpatrTelefonoCelular(String novedadCTTCREARptpatrTelefonoCelular) {
        this.novedadCTTCREARptpatrTelefonoCelular = novedadCTTCREARptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrCorreoElectronico() {
        return this.novedadCTTCREARptpatrCorreoElectronico;
    }
    
    public void setNovedadCTTCREARptpatrCorreoElectronico(String novedadCTTCREARptpatrCorreoElectronico) {
        this.novedadCTTCREARptpatrCorreoElectronico = novedadCTTCREARptpatrCorreoElectronico;
    }

    @JsonIgnore
    public String getNovedadCTTCREARptpatrDireccionCompleta() {
        return this.novedadCTTCREARptpatrDireccionCompleta;
    }
    
    public void setNovedadCTTCREARptpatrDireccionCompleta(String novedadCTTCREARptpatrDireccionCompleta) {
        this.novedadCTTCREARptpatrDireccionCompleta = novedadCTTCREARptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getNovedadCTTCREARptpatrRural() {
        return this.novedadCTTCREARptpatrRural;
    }
    
    public void setNovedadCTTCREARptpatrRural(Boolean novedadCTTCREARptpatrRural) {
        this.novedadCTTCREARptpatrRural = novedadCTTCREARptpatrRural;
    }

    @JsonIgnore
    public Long getNovedadCTTCREARptpatrCodigoCORE() {
        return this.novedadCTTCREARptpatrCodigoCORE;
    }
    
    public void setNovedadCTTCREARptpatrCodigoCORE(Long novedadCTTCREARptpatrCodigoCORE) {
        this.novedadCTTCREARptpatrCodigoCORE = novedadCTTCREARptpatrCodigoCORE;
    }
}
