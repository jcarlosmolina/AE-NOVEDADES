package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class ValidarRORequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadvalidarROpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadvalidarROpthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadvalidarROpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadvalidarROpthisFamiliaNovedad() {
        return this.familiaNovedadvalidarROpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadvalidarROpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadvalidarROpthisFamiliaNovedad) {
        this.familiaNovedadvalidarROpthisFamiliaNovedad = familiaNovedadvalidarROpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadvalidarROpthisFamiliaNovedadInstance() {
        return this.familiaNovedadvalidarROpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadvalidarROpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadvalidarROpthisFamiliaNovedad) {
        this.familiaNovedadvalidarROpthisFamiliaNovedadInstance = familiaNovedadvalidarROpthisFamiliaNovedad;
        this.familiaNovedadvalidarROpthisFamiliaNovedad = familiaNovedadvalidarROpthisFamiliaNovedad != null ? familiaNovedadvalidarROpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadvalidarROpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadvalidarROpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadvalidarROpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_VALIDARRO, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_VALIDARRO_FAMILIANOVEDADVALIDARROPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_VALIDARRO, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_VALIDARRO_FAMILIANOVEDADVALIDARROPTHISFAMILIANOVEDAD);
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
