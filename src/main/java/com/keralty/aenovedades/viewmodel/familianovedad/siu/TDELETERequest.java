package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class TDELETERequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTDELETEpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTDELETEpthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTDELETEpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTDELETEpthisFamiliaNovedad() {
        return this.familiaNovedadTDELETEpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTDELETEpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTDELETEpthisFamiliaNovedad) {
        this.familiaNovedadTDELETEpthisFamiliaNovedad = familiaNovedadTDELETEpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTDELETEpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTDELETEpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTDELETEpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTDELETEpthisFamiliaNovedad) {
        this.familiaNovedadTDELETEpthisFamiliaNovedadInstance = familiaNovedadTDELETEpthisFamiliaNovedad;
        this.familiaNovedadTDELETEpthisFamiliaNovedad = familiaNovedadTDELETEpthisFamiliaNovedad != null ? familiaNovedadTDELETEpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTDELETEpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTDELETEpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTDELETEpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TDELETE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TDELETE_FAMILIANOVEDADTDELETEPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TDELETE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TDELETE_FAMILIANOVEDADTDELETEPTHISFAMILIANOVEDAD);
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
