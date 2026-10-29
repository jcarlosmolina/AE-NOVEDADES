package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class TMARCARCOMPLETADARequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedad() {
        return this.familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad) {
        this.familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance() {
        return this.familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad) {
        this.familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance = familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad;
        this.familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad != null ? familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TMARCARCOMPLETADA, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TMARCARCOMPLETADA_FAMILIANOVEDADTMARCARCOMPLETADAPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TMARCARCOMPLETADA, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TMARCARCOMPLETADA_FAMILIANOVEDADTMARCARCOMPLETADAPTHISFAMILIANOVEDAD);
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
