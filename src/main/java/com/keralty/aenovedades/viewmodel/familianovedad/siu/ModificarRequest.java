package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class ModificarRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadmodificarpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadmodificarpthisFamiliaNovedadInstance;

    @JsonProperty("p_numfamilia")
    private Long familiaNovedadmodificarpNumFamilia;

    @JsonProperty("p_titnumidentificacion")
    private String familiaNovedadmodificarpTitNumidentificacion;

    @JsonProperty("p_titprimernombre")
    private String familiaNovedadmodificarpTitPrimerNombre;

    @JsonProperty("p_titsegundonombre")
    private String familiaNovedadmodificarpTitSegundoNombre;

    @JsonProperty("p_titprimerapellido")
    private String familiaNovedadmodificarpTitPrimerApellido;

    @JsonProperty("p_titsegundoapellido")
    private String familiaNovedadmodificarpTitSegundoApellido;

    @JsonProperty("p_titrazonsocial")
    private String familiaNovedadmodificarpTitRazonSocial;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadmodificarpthisFamiliaNovedad();
        checkFamiliaNovedadmodificarpNumFamilia();
        checkFamiliaNovedadmodificarpTitNumidentificacion();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadmodificarpthisFamiliaNovedad() {
        return this.familiaNovedadmodificarpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadmodificarpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadmodificarpthisFamiliaNovedad) {
        this.familiaNovedadmodificarpthisFamiliaNovedad = familiaNovedadmodificarpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadmodificarpthisFamiliaNovedadInstance() {
        return this.familiaNovedadmodificarpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadmodificarpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadmodificarpthisFamiliaNovedad) {
        this.familiaNovedadmodificarpthisFamiliaNovedadInstance = familiaNovedadmodificarpthisFamiliaNovedad;
        this.familiaNovedadmodificarpthisFamiliaNovedad = familiaNovedadmodificarpthisFamiliaNovedad != null ? familiaNovedadmodificarpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadmodificarpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadmodificarpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadmodificarpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_MODIFICAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_MODIFICAR_FAMILIANOVEDADMODIFICARPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_MODIFICAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_MODIFICAR_FAMILIANOVEDADMODIFICARPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public Long getFamiliaNovedadmodificarpNumFamilia() {
        return this.familiaNovedadmodificarpNumFamilia;
    }
    
    public void setFamiliaNovedadmodificarpNumFamilia(Long familiaNovedadmodificarpNumFamilia) {
        this.familiaNovedadmodificarpNumFamilia = familiaNovedadmodificarpNumFamilia;
    }

    private void checkFamiliaNovedadmodificarpNumFamilia() throws NotNullArgumentException {
        if(this.getFamiliaNovedadmodificarpNumFamilia() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_MODIFICAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_MODIFICAR_FAMILIANOVEDADMODIFICARPNUMFAMILIA, FamiliaNovedadConstants.SERV_ALIAS_MODIFICAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_MODIFICAR_FAMILIANOVEDADMODIFICARPNUMFAMILIA);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadmodificarpTitNumidentificacion() {
        return this.familiaNovedadmodificarpTitNumidentificacion;
    }
    
    public void setFamiliaNovedadmodificarpTitNumidentificacion(String familiaNovedadmodificarpTitNumidentificacion) {
        this.familiaNovedadmodificarpTitNumidentificacion = familiaNovedadmodificarpTitNumidentificacion;
    }

    private void checkFamiliaNovedadmodificarpTitNumidentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadmodificarpTitNumidentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_MODIFICAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_MODIFICAR_FAMILIANOVEDADMODIFICARPTITNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_MODIFICAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_MODIFICAR_FAMILIANOVEDADMODIFICARPTITNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadmodificarpTitPrimerNombre() {
        return this.familiaNovedadmodificarpTitPrimerNombre;
    }
    
    public void setFamiliaNovedadmodificarpTitPrimerNombre(String familiaNovedadmodificarpTitPrimerNombre) {
        this.familiaNovedadmodificarpTitPrimerNombre = familiaNovedadmodificarpTitPrimerNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadmodificarpTitSegundoNombre() {
        return this.familiaNovedadmodificarpTitSegundoNombre;
    }
    
    public void setFamiliaNovedadmodificarpTitSegundoNombre(String familiaNovedadmodificarpTitSegundoNombre) {
        this.familiaNovedadmodificarpTitSegundoNombre = familiaNovedadmodificarpTitSegundoNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadmodificarpTitPrimerApellido() {
        return this.familiaNovedadmodificarpTitPrimerApellido;
    }
    
    public void setFamiliaNovedadmodificarpTitPrimerApellido(String familiaNovedadmodificarpTitPrimerApellido) {
        this.familiaNovedadmodificarpTitPrimerApellido = familiaNovedadmodificarpTitPrimerApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadmodificarpTitSegundoApellido() {
        return this.familiaNovedadmodificarpTitSegundoApellido;
    }
    
    public void setFamiliaNovedadmodificarpTitSegundoApellido(String familiaNovedadmodificarpTitSegundoApellido) {
        this.familiaNovedadmodificarpTitSegundoApellido = familiaNovedadmodificarpTitSegundoApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadmodificarpTitRazonSocial() {
        return this.familiaNovedadmodificarpTitRazonSocial;
    }
    
    public void setFamiliaNovedadmodificarpTitRazonSocial(String familiaNovedadmodificarpTitRazonSocial) {
        this.familiaNovedadmodificarpTitRazonSocial = familiaNovedadmodificarpTitRazonSocial;
    }
}
