package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class ValidarCFRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadvalidarCFpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadvalidarCFpthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadvalidarCFpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadvalidarCFpthisFamiliaNovedad() {
        return this.familiaNovedadvalidarCFpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadvalidarCFpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadvalidarCFpthisFamiliaNovedad) {
        this.familiaNovedadvalidarCFpthisFamiliaNovedad = familiaNovedadvalidarCFpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance() {
        return this.familiaNovedadvalidarCFpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadvalidarCFpthisFamiliaNovedad) {
        this.familiaNovedadvalidarCFpthisFamiliaNovedadInstance = familiaNovedadvalidarCFpthisFamiliaNovedad;
        this.familiaNovedadvalidarCFpthisFamiliaNovedad = familiaNovedadvalidarCFpthisFamiliaNovedad != null ? familiaNovedadvalidarCFpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadvalidarCFpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_VALIDARCF, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_VALIDARCF_FAMILIANOVEDADVALIDARCFPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_VALIDARCF, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_VALIDARCF_FAMILIANOVEDADVALIDARCFPTHISFAMILIANOVEDAD);
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
