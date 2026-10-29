package com.keralty.aenovedades.viewmodel.novedadmd.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadMDConstants;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.oid.NovedadMDOid;

public class TDELETERequest {

    @JsonProperty("p_thisnovedadmd_oid")
    private NovedadMDOid novedadMDTDELETEpthisNovedadMD;
    
    @JsonIgnore
    private NovedadMD novedadMDTDELETEpthisNovedadMDInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadMDTDELETEpthisNovedadMD();
    }

    @JsonIgnore
    public NovedadMDOid getNovedadMDTDELETEpthisNovedadMD() {
        return this.novedadMDTDELETEpthisNovedadMD;
    }
    
    public void setNovedadMDTDELETEpthisNovedadMD(NovedadMDOid novedadMDTDELETEpthisNovedadMD) {
        this.novedadMDTDELETEpthisNovedadMD = novedadMDTDELETEpthisNovedadMD;
    }

    @JsonIgnore
    public NovedadMD getNovedadMDTDELETEpthisNovedadMDInstance() {
        return this.novedadMDTDELETEpthisNovedadMDInstance;
    }
    
    public void setNovedadMDTDELETEpthisNovedadMDInstance(NovedadMD novedadMDTDELETEpthisNovedadMD) {
        this.novedadMDTDELETEpthisNovedadMDInstance = novedadMDTDELETEpthisNovedadMD;
        this.novedadMDTDELETEpthisNovedadMD = novedadMDTDELETEpthisNovedadMD != null ? novedadMDTDELETEpthisNovedadMD.getOid() : null;
    }

    private void checkNovedadMDTDELETEpthisNovedadMD() throws NotNullArgumentException {
        if(this.getNovedadMDTDELETEpthisNovedadMDInstance() == null || this.getNovedadMDTDELETEpthisNovedadMDInstance().isNull()) {
            throw new NotNullArgumentException(NovedadMDConstants.SERV_ID_TDELETE, NovedadMDConstants.CLASS_ID, NovedadMDConstants.ARG_ID_TDELETE_NOVEDADMDTDELETEPTHISNOVEDADMD, NovedadMDConstants.SERV_ALIAS_TDELETE, NovedadMDConstants.CLASS_ALIAS, NovedadMDConstants.ARG_ALIAS_TDELETE_NOVEDADMDTDELETEPTHISNOVEDADMD);
        }
    }
}
