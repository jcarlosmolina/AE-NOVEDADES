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

public class TCREARRequest {

    @JsonProperty("pt_p_agrfamilianovedad_oid")
    private FamiliaNovedadOid novedadMDTCREARptpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad novedadMDTCREARptpagrFamiliaNovedadInstance;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid novedadMDTCREARptpagrPais;
    
    @JsonIgnore
    private Pais novedadMDTCREARptpagrPaisInstance;

    @JsonProperty("pt_p_agrdepartamento_oid")
    private DepartamentoOid novedadMDTCREARptpagrDepartamento;
    
    @JsonIgnore
    private Departamento novedadMDTCREARptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_oid")
    private MunicipioOid novedadMDTCREARptpagrMunicipio;
    
    @JsonIgnore
    private Municipio novedadMDTCREARptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String novedadMDTCREARptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean novedadMDTCREARptpatrRural;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String novedadMDTCREARptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String novedadMDTCREARptpatrTelefonoCelular;

    @JsonProperty("pt_p_atrcorreoelectronico")
    private String novedadMDTCREARptpatrCorreoElectronico;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadMDTCREARptpagrFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getNovedadMDTCREARptpagrFamiliaNovedad() {
        return this.novedadMDTCREARptpagrFamiliaNovedad;
    }
    
    public void setNovedadMDTCREARptpagrFamiliaNovedad(FamiliaNovedadOid novedadMDTCREARptpagrFamiliaNovedad) {
        this.novedadMDTCREARptpagrFamiliaNovedad = novedadMDTCREARptpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getNovedadMDTCREARptpagrFamiliaNovedadInstance() {
        return this.novedadMDTCREARptpagrFamiliaNovedadInstance;
    }
    
    public void setNovedadMDTCREARptpagrFamiliaNovedadInstance(FamiliaNovedad novedadMDTCREARptpagrFamiliaNovedad) {
        this.novedadMDTCREARptpagrFamiliaNovedadInstance = novedadMDTCREARptpagrFamiliaNovedad;
        this.novedadMDTCREARptpagrFamiliaNovedad = novedadMDTCREARptpagrFamiliaNovedad != null ? novedadMDTCREARptpagrFamiliaNovedad.getOid() : null;
    }

    private void checkNovedadMDTCREARptpagrFamiliaNovedad() throws NotNullArgumentException {
        if(this.getNovedadMDTCREARptpagrFamiliaNovedadInstance() == null || this.getNovedadMDTCREARptpagrFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(NovedadMDConstants.SERV_ID_TCREAR, NovedadMDConstants.CLASS_ID, NovedadMDConstants.ARG_ID_TCREAR_NOVEDADMDTCREARPTPAGRFAMILIANOVEDAD, NovedadMDConstants.SERV_ALIAS_TCREAR, NovedadMDConstants.CLASS_ALIAS, NovedadMDConstants.ARG_ALIAS_TCREAR_NOVEDADMDTCREARPTPAGRFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public PaisOid getNovedadMDTCREARptpagrPais() {
        return this.novedadMDTCREARptpagrPais;
    }
    
    public void setNovedadMDTCREARptpagrPais(PaisOid novedadMDTCREARptpagrPais) {
        this.novedadMDTCREARptpagrPais = novedadMDTCREARptpagrPais;
    }

    @JsonIgnore
    public Pais getNovedadMDTCREARptpagrPaisInstance() {
        return this.novedadMDTCREARptpagrPaisInstance;
    }
    
    public void setNovedadMDTCREARptpagrPaisInstance(Pais novedadMDTCREARptpagrPais) {
        this.novedadMDTCREARptpagrPaisInstance = novedadMDTCREARptpagrPais;
        this.novedadMDTCREARptpagrPais = novedadMDTCREARptpagrPais != null ? novedadMDTCREARptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getNovedadMDTCREARptpagrDepartamento() {
        return this.novedadMDTCREARptpagrDepartamento;
    }
    
    public void setNovedadMDTCREARptpagrDepartamento(DepartamentoOid novedadMDTCREARptpagrDepartamento) {
        this.novedadMDTCREARptpagrDepartamento = novedadMDTCREARptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getNovedadMDTCREARptpagrDepartamentoInstance() {
        return this.novedadMDTCREARptpagrDepartamentoInstance;
    }
    
    public void setNovedadMDTCREARptpagrDepartamentoInstance(Departamento novedadMDTCREARptpagrDepartamento) {
        this.novedadMDTCREARptpagrDepartamentoInstance = novedadMDTCREARptpagrDepartamento;
        this.novedadMDTCREARptpagrDepartamento = novedadMDTCREARptpagrDepartamento != null ? novedadMDTCREARptpagrDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getNovedadMDTCREARptpagrMunicipio() {
        return this.novedadMDTCREARptpagrMunicipio;
    }
    
    public void setNovedadMDTCREARptpagrMunicipio(MunicipioOid novedadMDTCREARptpagrMunicipio) {
        this.novedadMDTCREARptpagrMunicipio = novedadMDTCREARptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getNovedadMDTCREARptpagrMunicipioInstance() {
        return this.novedadMDTCREARptpagrMunicipioInstance;
    }
    
    public void setNovedadMDTCREARptpagrMunicipioInstance(Municipio novedadMDTCREARptpagrMunicipio) {
        this.novedadMDTCREARptpagrMunicipioInstance = novedadMDTCREARptpagrMunicipio;
        this.novedadMDTCREARptpagrMunicipio = novedadMDTCREARptpagrMunicipio != null ? novedadMDTCREARptpagrMunicipio.getOid() : null;
    }

    @JsonIgnore
    public String getNovedadMDTCREARptpatrDireccionCompleta() {
        return this.novedadMDTCREARptpatrDireccionCompleta;
    }
    
    public void setNovedadMDTCREARptpatrDireccionCompleta(String novedadMDTCREARptpatrDireccionCompleta) {
        this.novedadMDTCREARptpatrDireccionCompleta = novedadMDTCREARptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getNovedadMDTCREARptpatrRural() {
        return this.novedadMDTCREARptpatrRural;
    }
    
    public void setNovedadMDTCREARptpatrRural(Boolean novedadMDTCREARptpatrRural) {
        this.novedadMDTCREARptpatrRural = novedadMDTCREARptpatrRural;
    }

    @JsonIgnore
    public String getNovedadMDTCREARptpatrTelefonoFijo() {
        return this.novedadMDTCREARptpatrTelefonoFijo;
    }
    
    public void setNovedadMDTCREARptpatrTelefonoFijo(String novedadMDTCREARptpatrTelefonoFijo) {
        this.novedadMDTCREARptpatrTelefonoFijo = novedadMDTCREARptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getNovedadMDTCREARptpatrTelefonoCelular() {
        return this.novedadMDTCREARptpatrTelefonoCelular;
    }
    
    public void setNovedadMDTCREARptpatrTelefonoCelular(String novedadMDTCREARptpatrTelefonoCelular) {
        this.novedadMDTCREARptpatrTelefonoCelular = novedadMDTCREARptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getNovedadMDTCREARptpatrCorreoElectronico() {
        return this.novedadMDTCREARptpatrCorreoElectronico;
    }
    
    public void setNovedadMDTCREARptpatrCorreoElectronico(String novedadMDTCREARptpatrCorreoElectronico) {
        this.novedadMDTCREARptpatrCorreoElectronico = novedadMDTCREARptpatrCorreoElectronico;
    }
}
