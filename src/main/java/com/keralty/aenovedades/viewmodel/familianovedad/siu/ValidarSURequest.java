package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class ValidarSURequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadvalidarSUpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadvalidarSUpthisFamiliaNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadvalidarSUpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadvalidarSUpthisFamiliaNovedad() {
        return this.familiaNovedadvalidarSUpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadvalidarSUpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadvalidarSUpthisFamiliaNovedad) {
        this.familiaNovedadvalidarSUpthisFamiliaNovedad = familiaNovedadvalidarSUpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance() {
        return this.familiaNovedadvalidarSUpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadvalidarSUpthisFamiliaNovedad) {
        this.familiaNovedadvalidarSUpthisFamiliaNovedadInstance = familiaNovedadvalidarSUpthisFamiliaNovedad;
        this.familiaNovedadvalidarSUpthisFamiliaNovedad = familiaNovedadvalidarSUpthisFamiliaNovedad != null ? familiaNovedadvalidarSUpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadvalidarSUpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_VALIDARSU, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_VALIDARSU_FAMILIANOVEDADVALIDARSUPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_VALIDARSU, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_VALIDARSU_FAMILIANOVEDADVALIDARSUPTHISFAMILIANOVEDAD);
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
