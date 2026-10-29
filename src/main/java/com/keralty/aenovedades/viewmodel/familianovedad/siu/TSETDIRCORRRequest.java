package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.Pais;

public class TSETDIRCORRRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTSETDIRCORRpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTSETDIRCORRpthisFamiliaNovedadInstance;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid familiaNovedadTSETDIRCORRptpagrPais;
    
    @JsonIgnore
    private Pais familiaNovedadTSETDIRCORRptpagrPaisInstance;

    @JsonProperty("pt_p_agrdepartamento_json")
    private String familiaNovedadTSETDIRCORRptpagrDepartamento;
    
    @JsonIgnore
    private Departamento familiaNovedadTSETDIRCORRptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_json")
    private String familiaNovedadTSETDIRCORRptpagrMunicipio;
    
    @JsonIgnore
    private Municipio familiaNovedadTSETDIRCORRptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String familiaNovedadTSETDIRCORRptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean familiaNovedadTSETDIRCORRptpatrRural;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String familiaNovedadTSETDIRCORRptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String familiaNovedadTSETDIRCORRptpatrTelefonoCelular;

    @JsonProperty("pt_p_atrcorreoelectronico")
    private String familiaNovedadTSETDIRCORRptpatrCorreoElectronico;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTSETDIRCORRpthisFamiliaNovedad();
        checkFamiliaNovedadTSETDIRCORRptpatrRural();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedad() {
        return this.familiaNovedadTSETDIRCORRpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTSETDIRCORRpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTSETDIRCORRpthisFamiliaNovedad) {
        this.familiaNovedadTSETDIRCORRpthisFamiliaNovedad = familiaNovedadTSETDIRCORRpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTSETDIRCORRpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTSETDIRCORRpthisFamiliaNovedad) {
        this.familiaNovedadTSETDIRCORRpthisFamiliaNovedadInstance = familiaNovedadTSETDIRCORRpthisFamiliaNovedad;
        this.familiaNovedadTSETDIRCORRpthisFamiliaNovedad = familiaNovedadTSETDIRCORRpthisFamiliaNovedad != null ? familiaNovedadTSETDIRCORRpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTSETDIRCORRpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TSETDIRCORR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TSETDIRCORR_FAMILIANOVEDADTSETDIRCORRPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TSETDIRCORR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TSETDIRCORR_FAMILIANOVEDADTSETDIRCORRPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public PaisOid getFamiliaNovedadTSETDIRCORRptpagrPais() {
        return this.familiaNovedadTSETDIRCORRptpagrPais;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpagrPais(PaisOid familiaNovedadTSETDIRCORRptpagrPais) {
        this.familiaNovedadTSETDIRCORRptpagrPais = familiaNovedadTSETDIRCORRptpagrPais;
    }

    @JsonIgnore
    public Pais getFamiliaNovedadTSETDIRCORRptpagrPaisInstance() {
        return this.familiaNovedadTSETDIRCORRptpagrPaisInstance;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpagrPaisInstance(Pais familiaNovedadTSETDIRCORRptpagrPais) {
        this.familiaNovedadTSETDIRCORRptpagrPaisInstance = familiaNovedadTSETDIRCORRptpagrPais;
        this.familiaNovedadTSETDIRCORRptpagrPais = familiaNovedadTSETDIRCORRptpagrPais != null ? familiaNovedadTSETDIRCORRptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public String getFamiliaNovedadTSETDIRCORRptpagrDepartamento() {
        return this.familiaNovedadTSETDIRCORRptpagrDepartamento;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpagrDepartamento(String familiaNovedadTSETDIRCORRptpagrDepartamento) {
        this.familiaNovedadTSETDIRCORRptpagrDepartamento = familiaNovedadTSETDIRCORRptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getFamiliaNovedadTSETDIRCORRptpagrDepartamentoInstance() {
        return this.familiaNovedadTSETDIRCORRptpagrDepartamentoInstance;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpagrDepartamentoInstance(Departamento familiaNovedadTSETDIRCORRptpagrDepartamento) {
        this.familiaNovedadTSETDIRCORRptpagrDepartamentoInstance = familiaNovedadTSETDIRCORRptpagrDepartamento;
        this.familiaNovedadTSETDIRCORRptpagrDepartamento = familiaNovedadTSETDIRCORRptpagrDepartamento != null ? familiaNovedadTSETDIRCORRptpagrDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getFamiliaNovedadTSETDIRCORRptpagrMunicipio() {
        return this.familiaNovedadTSETDIRCORRptpagrMunicipio;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpagrMunicipio(String familiaNovedadTSETDIRCORRptpagrMunicipio) {
        this.familiaNovedadTSETDIRCORRptpagrMunicipio = familiaNovedadTSETDIRCORRptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getFamiliaNovedadTSETDIRCORRptpagrMunicipioInstance() {
        return this.familiaNovedadTSETDIRCORRptpagrMunicipioInstance;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpagrMunicipioInstance(Municipio familiaNovedadTSETDIRCORRptpagrMunicipio) {
        this.familiaNovedadTSETDIRCORRptpagrMunicipioInstance = familiaNovedadTSETDIRCORRptpagrMunicipio;
        this.familiaNovedadTSETDIRCORRptpagrMunicipio = familiaNovedadTSETDIRCORRptpagrMunicipio != null ? familiaNovedadTSETDIRCORRptpagrMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getFamiliaNovedadTSETDIRCORRptpatrDireccionCompleta() {
        return this.familiaNovedadTSETDIRCORRptpatrDireccionCompleta;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpatrDireccionCompleta(String familiaNovedadTSETDIRCORRptpatrDireccionCompleta) {
        this.familiaNovedadTSETDIRCORRptpatrDireccionCompleta = familiaNovedadTSETDIRCORRptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getFamiliaNovedadTSETDIRCORRptpatrRural() {
        return this.familiaNovedadTSETDIRCORRptpatrRural;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpatrRural(Boolean familiaNovedadTSETDIRCORRptpatrRural) {
        this.familiaNovedadTSETDIRCORRptpatrRural = familiaNovedadTSETDIRCORRptpatrRural;
    }

    private void checkFamiliaNovedadTSETDIRCORRptpatrRural() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTSETDIRCORRptpatrRural() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TSETDIRCORR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TSETDIRCORR_FAMILIANOVEDADTSETDIRCORRPTPATRRURAL, FamiliaNovedadConstants.SERV_ALIAS_TSETDIRCORR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TSETDIRCORR_FAMILIANOVEDADTSETDIRCORRPTPATRRURAL);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTSETDIRCORRptpatrTelefonoFijo() {
        return this.familiaNovedadTSETDIRCORRptpatrTelefonoFijo;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpatrTelefonoFijo(String familiaNovedadTSETDIRCORRptpatrTelefonoFijo) {
        this.familiaNovedadTSETDIRCORRptpatrTelefonoFijo = familiaNovedadTSETDIRCORRptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getFamiliaNovedadTSETDIRCORRptpatrTelefonoCelular() {
        return this.familiaNovedadTSETDIRCORRptpatrTelefonoCelular;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpatrTelefonoCelular(String familiaNovedadTSETDIRCORRptpatrTelefonoCelular) {
        this.familiaNovedadTSETDIRCORRptpatrTelefonoCelular = familiaNovedadTSETDIRCORRptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getFamiliaNovedadTSETDIRCORRptpatrCorreoElectronico() {
        return this.familiaNovedadTSETDIRCORRptpatrCorreoElectronico;
    }
    
    public void setFamiliaNovedadTSETDIRCORRptpatrCorreoElectronico(String familiaNovedadTSETDIRCORRptpatrCorreoElectronico) {
        this.familiaNovedadTSETDIRCORRptpatrCorreoElectronico = familiaNovedadTSETDIRCORRptpatrCorreoElectronico;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
