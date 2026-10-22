package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class ValidarEURequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadvalidarEUpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadvalidarEUpthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadvalidarEUpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadvalidarEUpthisFamiliaNovedad() {
        return this.familiaNovedadvalidarEUpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadvalidarEUpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadvalidarEUpthisFamiliaNovedad) {
        this.familiaNovedadvalidarEUpthisFamiliaNovedad = familiaNovedadvalidarEUpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance() {
        return this.familiaNovedadvalidarEUpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadvalidarEUpthisFamiliaNovedad) {
        this.familiaNovedadvalidarEUpthisFamiliaNovedadInstance = familiaNovedadvalidarEUpthisFamiliaNovedad;
        this.familiaNovedadvalidarEUpthisFamiliaNovedad = familiaNovedadvalidarEUpthisFamiliaNovedad != null ? familiaNovedadvalidarEUpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadvalidarEUpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_VALIDAREU, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_VALIDAREU_FAMILIANOVEDADVALIDAREUPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_VALIDAREU, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_VALIDAREU_FAMILIANOVEDADVALIDAREUPTHISFAMILIANOVEDAD);
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
