package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class ValidarCTRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadvalidarCTpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadvalidarCTpthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadvalidarCTpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadvalidarCTpthisFamiliaNovedad() {
        return this.familiaNovedadvalidarCTpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadvalidarCTpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadvalidarCTpthisFamiliaNovedad) {
        this.familiaNovedadvalidarCTpthisFamiliaNovedad = familiaNovedadvalidarCTpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance() {
        return this.familiaNovedadvalidarCTpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadvalidarCTpthisFamiliaNovedad) {
        this.familiaNovedadvalidarCTpthisFamiliaNovedadInstance = familiaNovedadvalidarCTpthisFamiliaNovedad;
        this.familiaNovedadvalidarCTpthisFamiliaNovedad = familiaNovedadvalidarCTpthisFamiliaNovedad != null ? familiaNovedadvalidarCTpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadvalidarCTpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_VALIDARCT, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_VALIDARCT_FAMILIANOVEDADVALIDARCTPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_VALIDARCT, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_VALIDARCT_FAMILIANOVEDADVALIDARCTPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
