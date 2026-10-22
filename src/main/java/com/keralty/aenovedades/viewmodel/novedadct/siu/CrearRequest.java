package com.keralty.aenovedades.viewmodel.novedadct.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.oid.DepartamentoOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.MunicipioOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Pais;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class CrearRequest {

    @JsonProperty("p_agrfamilianovedad_oid")
    private FamiliaNovedadOid novedadCTcrearpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad novedadCTcrearpagrFamiliaNovedadInstance;

    @JsonProperty("p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid novedadCTcrearpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion novedadCTcrearpagrTipoIdentificacionInstance;

    @JsonProperty("p_agrfirma_oid")
    private FirmaOid novedadCTcrearpagrFirma;
    
    @JsonIgnore
    private Firma novedadCTcrearpagrFirmaInstance;

    @JsonProperty("p_agrmunicipionac_oid")
    private MunicipioOid novedadCTcrearpagrMunicipioNac;
    
    @JsonIgnore
    private Municipio novedadCTcrearpagrMunicipioNacInstance;

    @JsonProperty("p_agrmunicipiores_oid")
    private MunicipioOid novedadCTcrearpagrMunicipioRes;
    
    @JsonIgnore
    private Municipio novedadCTcrearpagrMunicipioResInstance;

    @JsonProperty("p_agrdepartamentonac_oid")
    private DepartamentoOid novedadCTcrearpagrDepartamentoNac;
    
    @JsonIgnore
    private Departamento novedadCTcrearpagrDepartamentoNacInstance;

    @JsonProperty("p_agrdepartamentores_oid")
    private DepartamentoOid novedadCTcrearpagrDepartamentoRes;
    
    @JsonIgnore
    private Departamento novedadCTcrearpagrDepartamentoResInstance;

    @JsonProperty("p_agrpais_oid")
    private PaisOid novedadCTcrearpagrPais;
    
    @JsonIgnore
    private Pais novedadCTcrearpagrPaisInstance;

    @JsonProperty("p_atrtitnumidentificacion")
    private String novedadCTcrearpatrTitNumidentificacion;

    @JsonProperty("p_atrtitprimernombre")
    private String novedadCTcrearpatrTitPrimerNombre;

    @JsonProperty("p_atrtittienebeneficios")
    private Boolean novedadCTcrearpatrTitTieneBeneficios;

    @JsonProperty("p_atrtitsegundonombre")
    private String novedadCTcrearpatrTitSegundoNombre;

    @JsonProperty("p_atrtitprimerapellido")
    private String novedadCTcrearpatrTitPrimerApellido;

    @JsonProperty("p_atrtitsegundoapellido")
    private String novedadCTcrearpatrTitSegundoApellido;

    @JsonProperty("p_atrtitrazonsocial")
    private String novedadCTcrearpatrTitRazonSocial;

    @JsonProperty("p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date novedadCTcrearpatrFechaNacimiento;

    @JsonProperty("p_atrgenero")
    private String novedadCTcrearpatrGenero;

    @JsonProperty("p_atrindicadorextranjero")
    private Boolean novedadCTcrearpatrIndicadorExtranjero;

    @JsonProperty("p_atrtelefonofijo")
    private String novedadCTcrearpatrTelefonoFijo;

    @JsonProperty("p_atrtelefonocelular")
    private String novedadCTcrearpatrTelefonoCelular;

    @JsonProperty("p_atrcorreoelectronico")
    private String novedadCTcrearpatrCorreoElectronico;

    @JsonProperty("p_atrdireccioncompleta")
    private String novedadCTcrearpatrDireccionCompleta;

    @JsonProperty("p_atrrural")
    private Boolean novedadCTcrearpatrRural;

    @JsonProperty("p_atrcodigocore")
    private Long novedadCTcrearpatrCodigoCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadCTcrearpagrFamiliaNovedad();
        checkNovedadCTcrearpagrTipoIdentificacion();
        checkNovedadCTcrearpatrTitNumidentificacion();
        checkNovedadCTcrearpatrTitTieneBeneficios();
    }

    @JsonIgnore
    public FamiliaNovedadOid getNovedadCTcrearpagrFamiliaNovedad() {
        return this.novedadCTcrearpagrFamiliaNovedad;
    }
    
    public void setNovedadCTcrearpagrFamiliaNovedad(FamiliaNovedadOid novedadCTcrearpagrFamiliaNovedad) {
        this.novedadCTcrearpagrFamiliaNovedad = novedadCTcrearpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getNovedadCTcrearpagrFamiliaNovedadInstance() {
        return this.novedadCTcrearpagrFamiliaNovedadInstance;
    }
    
    public void setNovedadCTcrearpagrFamiliaNovedadInstance(FamiliaNovedad novedadCTcrearpagrFamiliaNovedad) {
        this.novedadCTcrearpagrFamiliaNovedadInstance = novedadCTcrearpagrFamiliaNovedad;
        this.novedadCTcrearpagrFamiliaNovedad = novedadCTcrearpagrFamiliaNovedad != null ? novedadCTcrearpagrFamiliaNovedad.getOid() : null;
    }

    private void checkNovedadCTcrearpagrFamiliaNovedad() throws NotNullArgumentException {
        if(this.getNovedadCTcrearpagrFamiliaNovedadInstance() == null || this.getNovedadCTcrearpagrFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_CREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_CREAR_NOVEDADCTCREARPAGRFAMILIANOVEDAD, NovedadCTConstants.SERV_ALIAS_CREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_CREAR_NOVEDADCTCREARPAGRFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getNovedadCTcrearpagrTipoIdentificacion() {
        return this.novedadCTcrearpagrTipoIdentificacion;
    }
    
    public void setNovedadCTcrearpagrTipoIdentificacion(TipoIdentificacionOid novedadCTcrearpagrTipoIdentificacion) {
        this.novedadCTcrearpagrTipoIdentificacion = novedadCTcrearpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getNovedadCTcrearpagrTipoIdentificacionInstance() {
        return this.novedadCTcrearpagrTipoIdentificacionInstance;
    }
    
    public void setNovedadCTcrearpagrTipoIdentificacionInstance(TipoIdentificacion novedadCTcrearpagrTipoIdentificacion) {
        this.novedadCTcrearpagrTipoIdentificacionInstance = novedadCTcrearpagrTipoIdentificacion;
        this.novedadCTcrearpagrTipoIdentificacion = novedadCTcrearpagrTipoIdentificacion != null ? novedadCTcrearpagrTipoIdentificacion.getOid() : null;
    }

    private void checkNovedadCTcrearpagrTipoIdentificacion() throws NotNullArgumentException {
        if(this.getNovedadCTcrearpagrTipoIdentificacionInstance() == null || this.getNovedadCTcrearpagrTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_CREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_CREAR_NOVEDADCTCREARPAGRTIPOIDENTIFICACION, NovedadCTConstants.SERV_ALIAS_CREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_CREAR_NOVEDADCTCREARPAGRTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public FirmaOid getNovedadCTcrearpagrFirma() {
        return this.novedadCTcrearpagrFirma;
    }
    
    public void setNovedadCTcrearpagrFirma(FirmaOid novedadCTcrearpagrFirma) {
        this.novedadCTcrearpagrFirma = novedadCTcrearpagrFirma;
    }

    @JsonIgnore
    public Firma getNovedadCTcrearpagrFirmaInstance() {
        return this.novedadCTcrearpagrFirmaInstance;
    }
    
    public void setNovedadCTcrearpagrFirmaInstance(Firma novedadCTcrearpagrFirma) {
        this.novedadCTcrearpagrFirmaInstance = novedadCTcrearpagrFirma;
        this.novedadCTcrearpagrFirma = novedadCTcrearpagrFirma != null ? novedadCTcrearpagrFirma.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getNovedadCTcrearpagrMunicipioNac() {
        return this.novedadCTcrearpagrMunicipioNac;
    }
    
    public void setNovedadCTcrearpagrMunicipioNac(MunicipioOid novedadCTcrearpagrMunicipioNac) {
        this.novedadCTcrearpagrMunicipioNac = novedadCTcrearpagrMunicipioNac;
    }

    @JsonIgnore
    public Municipio getNovedadCTcrearpagrMunicipioNacInstance() {
        return this.novedadCTcrearpagrMunicipioNacInstance;
    }
    
    public void setNovedadCTcrearpagrMunicipioNacInstance(Municipio novedadCTcrearpagrMunicipioNac) {
        this.novedadCTcrearpagrMunicipioNacInstance = novedadCTcrearpagrMunicipioNac;
        this.novedadCTcrearpagrMunicipioNac = novedadCTcrearpagrMunicipioNac != null ? novedadCTcrearpagrMunicipioNac.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getNovedadCTcrearpagrMunicipioRes() {
        return this.novedadCTcrearpagrMunicipioRes;
    }
    
    public void setNovedadCTcrearpagrMunicipioRes(MunicipioOid novedadCTcrearpagrMunicipioRes) {
        this.novedadCTcrearpagrMunicipioRes = novedadCTcrearpagrMunicipioRes;
    }

    @JsonIgnore
    public Municipio getNovedadCTcrearpagrMunicipioResInstance() {
        return this.novedadCTcrearpagrMunicipioResInstance;
    }
    
    public void setNovedadCTcrearpagrMunicipioResInstance(Municipio novedadCTcrearpagrMunicipioRes) {
        this.novedadCTcrearpagrMunicipioResInstance = novedadCTcrearpagrMunicipioRes;
        this.novedadCTcrearpagrMunicipioRes = novedadCTcrearpagrMunicipioRes != null ? novedadCTcrearpagrMunicipioRes.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getNovedadCTcrearpagrDepartamentoNac() {
        return this.novedadCTcrearpagrDepartamentoNac;
    }
    
    public void setNovedadCTcrearpagrDepartamentoNac(DepartamentoOid novedadCTcrearpagrDepartamentoNac) {
        this.novedadCTcrearpagrDepartamentoNac = novedadCTcrearpagrDepartamentoNac;
    }

    @JsonIgnore
    public Departamento getNovedadCTcrearpagrDepartamentoNacInstance() {
        return this.novedadCTcrearpagrDepartamentoNacInstance;
    }
    
    public void setNovedadCTcrearpagrDepartamentoNacInstance(Departamento novedadCTcrearpagrDepartamentoNac) {
        this.novedadCTcrearpagrDepartamentoNacInstance = novedadCTcrearpagrDepartamentoNac;
        this.novedadCTcrearpagrDepartamentoNac = novedadCTcrearpagrDepartamentoNac != null ? novedadCTcrearpagrDepartamentoNac.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getNovedadCTcrearpagrDepartamentoRes() {
        return this.novedadCTcrearpagrDepartamentoRes;
    }
    
    public void setNovedadCTcrearpagrDepartamentoRes(DepartamentoOid novedadCTcrearpagrDepartamentoRes) {
        this.novedadCTcrearpagrDepartamentoRes = novedadCTcrearpagrDepartamentoRes;
    }

    @JsonIgnore
    public Departamento getNovedadCTcrearpagrDepartamentoResInstance() {
        return this.novedadCTcrearpagrDepartamentoResInstance;
    }
    
    public void setNovedadCTcrearpagrDepartamentoResInstance(Departamento novedadCTcrearpagrDepartamentoRes) {
        this.novedadCTcrearpagrDepartamentoResInstance = novedadCTcrearpagrDepartamentoRes;
        this.novedadCTcrearpagrDepartamentoRes = novedadCTcrearpagrDepartamentoRes != null ? novedadCTcrearpagrDepartamentoRes.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getNovedadCTcrearpagrPais() {
        return this.novedadCTcrearpagrPais;
    }
    
    public void setNovedadCTcrearpagrPais(PaisOid novedadCTcrearpagrPais) {
        this.novedadCTcrearpagrPais = novedadCTcrearpagrPais;
    }

    @JsonIgnore
    public Pais getNovedadCTcrearpagrPaisInstance() {
        return this.novedadCTcrearpagrPaisInstance;
    }
    
    public void setNovedadCTcrearpagrPaisInstance(Pais novedadCTcrearpagrPais) {
        this.novedadCTcrearpagrPaisInstance = novedadCTcrearpagrPais;
        this.novedadCTcrearpagrPais = novedadCTcrearpagrPais != null ? novedadCTcrearpagrPais.getOid() : null;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTitNumidentificacion() {
        return this.novedadCTcrearpatrTitNumidentificacion;
    }
    
    public void setNovedadCTcrearpatrTitNumidentificacion(String novedadCTcrearpatrTitNumidentificacion) {
        this.novedadCTcrearpatrTitNumidentificacion = novedadCTcrearpatrTitNumidentificacion;
    }

    private void checkNovedadCTcrearpatrTitNumidentificacion() throws NotNullArgumentException {
        if(this.getNovedadCTcrearpatrTitNumidentificacion() == null) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_CREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_CREAR_NOVEDADCTCREARPATRTITNUMIDENTIFICACION, NovedadCTConstants.SERV_ALIAS_CREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_CREAR_NOVEDADCTCREARPATRTITNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTitPrimerNombre() {
        return this.novedadCTcrearpatrTitPrimerNombre;
    }
    
    public void setNovedadCTcrearpatrTitPrimerNombre(String novedadCTcrearpatrTitPrimerNombre) {
        this.novedadCTcrearpatrTitPrimerNombre = novedadCTcrearpatrTitPrimerNombre;
    }

    @JsonIgnore
    public Boolean getNovedadCTcrearpatrTitTieneBeneficios() {
        return this.novedadCTcrearpatrTitTieneBeneficios;
    }
    
    public void setNovedadCTcrearpatrTitTieneBeneficios(Boolean novedadCTcrearpatrTitTieneBeneficios) {
        this.novedadCTcrearpatrTitTieneBeneficios = novedadCTcrearpatrTitTieneBeneficios;
    }

    private void checkNovedadCTcrearpatrTitTieneBeneficios() throws NotNullArgumentException {
        if(this.getNovedadCTcrearpatrTitTieneBeneficios() == null) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_CREAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_CREAR_NOVEDADCTCREARPATRTITTIENEBENEFICIOS, NovedadCTConstants.SERV_ALIAS_CREAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_CREAR_NOVEDADCTCREARPATRTITTIENEBENEFICIOS);
        }
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTitSegundoNombre() {
        return this.novedadCTcrearpatrTitSegundoNombre;
    }
    
    public void setNovedadCTcrearpatrTitSegundoNombre(String novedadCTcrearpatrTitSegundoNombre) {
        this.novedadCTcrearpatrTitSegundoNombre = novedadCTcrearpatrTitSegundoNombre;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTitPrimerApellido() {
        return this.novedadCTcrearpatrTitPrimerApellido;
    }
    
    public void setNovedadCTcrearpatrTitPrimerApellido(String novedadCTcrearpatrTitPrimerApellido) {
        this.novedadCTcrearpatrTitPrimerApellido = novedadCTcrearpatrTitPrimerApellido;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTitSegundoApellido() {
        return this.novedadCTcrearpatrTitSegundoApellido;
    }
    
    public void setNovedadCTcrearpatrTitSegundoApellido(String novedadCTcrearpatrTitSegundoApellido) {
        this.novedadCTcrearpatrTitSegundoApellido = novedadCTcrearpatrTitSegundoApellido;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTitRazonSocial() {
        return this.novedadCTcrearpatrTitRazonSocial;
    }
    
    public void setNovedadCTcrearpatrTitRazonSocial(String novedadCTcrearpatrTitRazonSocial) {
        this.novedadCTcrearpatrTitRazonSocial = novedadCTcrearpatrTitRazonSocial;
    }

    @JsonIgnore
    public Date getNovedadCTcrearpatrFechaNacimiento() {
        return this.novedadCTcrearpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setNovedadCTcrearpatrFechaNacimiento(Date novedadCTcrearpatrFechaNacimiento) {
        this.novedadCTcrearpatrFechaNacimiento = novedadCTcrearpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrGenero() {
        return this.novedadCTcrearpatrGenero;
    }
    
    public void setNovedadCTcrearpatrGenero(String novedadCTcrearpatrGenero) {
        this.novedadCTcrearpatrGenero = novedadCTcrearpatrGenero;
    }

    @JsonIgnore
    public Boolean getNovedadCTcrearpatrIndicadorExtranjero() {
        return this.novedadCTcrearpatrIndicadorExtranjero;
    }
    
    public void setNovedadCTcrearpatrIndicadorExtranjero(Boolean novedadCTcrearpatrIndicadorExtranjero) {
        this.novedadCTcrearpatrIndicadorExtranjero = novedadCTcrearpatrIndicadorExtranjero;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTelefonoFijo() {
        return this.novedadCTcrearpatrTelefonoFijo;
    }
    
    public void setNovedadCTcrearpatrTelefonoFijo(String novedadCTcrearpatrTelefonoFijo) {
        this.novedadCTcrearpatrTelefonoFijo = novedadCTcrearpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrTelefonoCelular() {
        return this.novedadCTcrearpatrTelefonoCelular;
    }
    
    public void setNovedadCTcrearpatrTelefonoCelular(String novedadCTcrearpatrTelefonoCelular) {
        this.novedadCTcrearpatrTelefonoCelular = novedadCTcrearpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrCorreoElectronico() {
        return this.novedadCTcrearpatrCorreoElectronico;
    }
    
    public void setNovedadCTcrearpatrCorreoElectronico(String novedadCTcrearpatrCorreoElectronico) {
        this.novedadCTcrearpatrCorreoElectronico = novedadCTcrearpatrCorreoElectronico;
    }

    @JsonIgnore
    public String getNovedadCTcrearpatrDireccionCompleta() {
        return this.novedadCTcrearpatrDireccionCompleta;
    }
    
    public void setNovedadCTcrearpatrDireccionCompleta(String novedadCTcrearpatrDireccionCompleta) {
        this.novedadCTcrearpatrDireccionCompleta = novedadCTcrearpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getNovedadCTcrearpatrRural() {
        return this.novedadCTcrearpatrRural;
    }
    
    public void setNovedadCTcrearpatrRural(Boolean novedadCTcrearpatrRural) {
        this.novedadCTcrearpatrRural = novedadCTcrearpatrRural;
    }

    @JsonIgnore
    public Long getNovedadCTcrearpatrCodigoCORE() {
        return this.novedadCTcrearpatrCodigoCORE;
    }
    
    public void setNovedadCTcrearpatrCodigoCORE(Long novedadCTcrearpatrCodigoCORE) {
        this.novedadCTcrearpatrCodigoCORE = novedadCTcrearpatrCodigoCORE;
    }
}
