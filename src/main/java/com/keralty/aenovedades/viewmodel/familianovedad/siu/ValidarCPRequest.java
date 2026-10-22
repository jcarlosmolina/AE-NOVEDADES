package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class ValidarCPRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadvalidarCPpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadvalidarCPpthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadvalidarCPpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadvalidarCPpthisFamiliaNovedad() {
        return this.familiaNovedadvalidarCPpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadvalidarCPpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadvalidarCPpthisFamiliaNovedad) {
        this.familiaNovedadvalidarCPpthisFamiliaNovedad = familiaNovedadvalidarCPpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance() {
        return this.familiaNovedadvalidarCPpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadvalidarCPpthisFamiliaNovedad) {
        this.familiaNovedadvalidarCPpthisFamiliaNovedadInstance = familiaNovedadvalidarCPpthisFamiliaNovedad;
        this.familiaNovedadvalidarCPpthisFamiliaNovedad = familiaNovedadvalidarCPpthisFamiliaNovedad != null ? familiaNovedadvalidarCPpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadvalidarCPpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_VALIDARCP, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_VALIDARCP_FAMILIANOVEDADVALIDARCPPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_VALIDARCP, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_VALIDARCP_FAMILIANOVEDADVALIDARCPPTHISFAMILIANOVEDAD);
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
