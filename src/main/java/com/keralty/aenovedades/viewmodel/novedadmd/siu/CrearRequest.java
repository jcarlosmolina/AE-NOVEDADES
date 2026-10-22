package com.keralty.aenovedades.viewmodel.novedadmd.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadMDConstants;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.oid.DepartamentoOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.MunicipioOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.Pais;

public class CrearRequest {

    @JsonProperty("p_agrfamilianovedad_oid")
    private FamiliaNovedadOid novedadMDcrearpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad novedadMDcrearpagrFamiliaNovedadInstance;

    @JsonProperty("p_agrpais_oid")
    private PaisOid novedadMDcrearpagrPais;
    
    @JsonIgnore
    private Pais novedadMDcrearpagrPaisInstance;

    @JsonProperty("p_agrmunicipio_oid")
    private MunicipioOid novedadMDcrearpagrMunicipio;
    
    @JsonIgnore
    private Municipio novedadMDcrearpagrMunicipioInstance;

    @JsonProperty("p_agrdepartamento_oid")
    private DepartamentoOid novedadMDcrearpagrDepartamento;
    
    @JsonIgnore
    private Departamento novedadMDcrearpagrDepartamentoInstance;

    @JsonProperty("p_atrdireccioncompleta")
    private String novedadMDcrearpatrDireccionCompleta;

    @JsonProperty("p_atrrural")
    private Boolean novedadMDcrearpatrRural;

    @JsonProperty("p_atrtelefonofijo")
    private String novedadMDcrearpatrTelefonoFijo;

    @JsonProperty("p_atrtelefonocelular")
    private String novedadMDcrearpatrTelefonoCelular;

    @JsonProperty("p_atrcorreoelectronico")
    private String novedadMDcrearpatrCorreoElectronico;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadMDcrearpagrFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getNovedadMDcrearpagrFamiliaNovedad() {
        return this.novedadMDcrearpagrFamiliaNovedad;
    }
    
    public void setNovedadMDcrearpagrFamiliaNovedad(FamiliaNovedadOid novedadMDcrearpagrFamiliaNovedad) {
        this.novedadMDcrearpagrFamiliaNovedad = novedadMDcrearpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getNovedadMDcrearpagrFamiliaNovedadInstance() {
        return this.novedadMDcrearpagrFamiliaNovedadInstance;
    }
    
    public void setNovedadMDcrearpagrFamiliaNovedadInstance(FamiliaNovedad novedadMDcrearpagrFamiliaNovedad) {
        this.novedadMDcrearpagrFamiliaNovedadInstance = novedadMDcrearpagrFamiliaNovedad;
        this.novedadMDcrearpagrFamiliaNovedad = novedadMDcrearpagrFamiliaNovedad != null ? novedadMDcrearpagrFamiliaNovedad.getOid() : null;
    }

    private void checkNovedadMDcrearpagrFamiliaNovedad() throws NotNullArgumentException {
        if(this.getNovedadMDcrearpagrFamiliaNovedadInstance() == null || this.getNovedadMDcrearpagrFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(NovedadMDConstants.SERV_ID_CREAR, NovedadMDConstants.CLASS_ID, NovedadMDConstants.ARG_ID_CREAR_NOVEDADMDCREARPAGRFAMILIANOVEDAD, NovedadMDConstants.SERV_ALIAS_CREAR, NovedadMDConstants.CLASS_ALIAS, NovedadMDConstants.ARG_ALIAS_CREAR_NOVEDADMDCREARPAGRFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public PaisOid getNovedadMDcrearpagrPais() {
        return this.novedadMDcrearpagrPais;
    }
    
    public void setNovedadMDcrearpagrPais(PaisOid novedadMDcrearpagrPais) {
        this.novedadMDcrearpagrPais = novedadMDcrearpagrPais;
    }

    @JsonIgnore
    public Pais getNovedadMDcrearpagrPaisInstance() {
        return this.novedadMDcrearpagrPaisInstance;
    }
    
    public void setNovedadMDcrearpagrPaisInstance(Pais novedadMDcrearpagrPais) {
        this.novedadMDcrearpagrPaisInstance = novedadMDcrearpagrPais;
        this.novedadMDcrearpagrPais = novedadMDcrearpagrPais != null ? novedadMDcrearpagrPais.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getNovedadMDcrearpagrMunicipio() {
        return this.novedadMDcrearpagrMunicipio;
    }
    
    public void setNovedadMDcrearpagrMunicipio(MunicipioOid novedadMDcrearpagrMunicipio) {
        this.novedadMDcrearpagrMunicipio = novedadMDcrearpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getNovedadMDcrearpagrMunicipioInstance() {
        return this.novedadMDcrearpagrMunicipioInstance;
    }
    
    public void setNovedadMDcrearpagrMunicipioInstance(Municipio novedadMDcrearpagrMunicipio) {
        this.novedadMDcrearpagrMunicipioInstance = novedadMDcrearpagrMunicipio;
        this.novedadMDcrearpagrMunicipio = novedadMDcrearpagrMunicipio != null ? novedadMDcrearpagrMunicipio.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getNovedadMDcrearpagrDepartamento() {
        return this.novedadMDcrearpagrDepartamento;
    }
    
    public void setNovedadMDcrearpagrDepartamento(DepartamentoOid novedadMDcrearpagrDepartamento) {
        this.novedadMDcrearpagrDepartamento = novedadMDcrearpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getNovedadMDcrearpagrDepartamentoInstance() {
        return this.novedadMDcrearpagrDepartamentoInstance;
    }
    
    public void setNovedadMDcrearpagrDepartamentoInstance(Departamento novedadMDcrearpagrDepartamento) {
        this.novedadMDcrearpagrDepartamentoInstance = novedadMDcrearpagrDepartamento;
        this.novedadMDcrearpagrDepartamento = novedadMDcrearpagrDepartamento != null ? novedadMDcrearpagrDepartamento.getOid() : null;
    }

    @JsonIgnore
    public String getNovedadMDcrearpatrDireccionCompleta() {
        return this.novedadMDcrearpatrDireccionCompleta;
    }
    
    public void setNovedadMDcrearpatrDireccionCompleta(String novedadMDcrearpatrDireccionCompleta) {
        this.novedadMDcrearpatrDireccionCompleta = novedadMDcrearpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getNovedadMDcrearpatrRural() {
        return this.novedadMDcrearpatrRural;
    }
    
    public void setNovedadMDcrearpatrRural(Boolean novedadMDcrearpatrRural) {
        this.novedadMDcrearpatrRural = novedadMDcrearpatrRural;
    }

    @JsonIgnore
    public String getNovedadMDcrearpatrTelefonoFijo() {
        return this.novedadMDcrearpatrTelefonoFijo;
    }
    
    public void setNovedadMDcrearpatrTelefonoFijo(String novedadMDcrearpatrTelefonoFijo) {
        this.novedadMDcrearpatrTelefonoFijo = novedadMDcrearpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getNovedadMDcrearpatrTelefonoCelular() {
        return this.novedadMDcrearpatrTelefonoCelular;
    }
    
    public void setNovedadMDcrearpatrTelefonoCelular(String novedadMDcrearpatrTelefonoCelular) {
        this.novedadMDcrearpatrTelefonoCelular = novedadMDcrearpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getNovedadMDcrearpatrCorreoElectronico() {
        return this.novedadMDcrearpatrCorreoElectronico;
    }
    
    public void setNovedadMDcrearpatrCorreoElectronico(String novedadMDcrearpatrCorreoElectronico) {
        this.novedadMDcrearpatrCorreoElectronico = novedadMDcrearpatrCorreoElectronico;
    }
}
