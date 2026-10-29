package com.keralty.aenovedades.viewmodel.novedadct.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;

public class TDELETERequest {

    @JsonProperty("p_thisnovedadct_oid")
    private NovedadCTOid novedadCTTDELETEpthisNovedadCT;
    
    @JsonIgnore
    private NovedadCT novedadCTTDELETEpthisNovedadCTInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadCTTDELETEpthisNovedadCT();
    }

    @JsonIgnore
    public NovedadCTOid getNovedadCTTDELETEpthisNovedadCT() {
        return this.novedadCTTDELETEpthisNovedadCT;
    }
    
    public void setNovedadCTTDELETEpthisNovedadCT(NovedadCTOid novedadCTTDELETEpthisNovedadCT) {
        this.novedadCTTDELETEpthisNovedadCT = novedadCTTDELETEpthisNovedadCT;
    }

    @JsonIgnore
    public NovedadCT getNovedadCTTDELETEpthisNovedadCTInstance() {
        return this.novedadCTTDELETEpthisNovedadCTInstance;
    }
    
    public void setNovedadCTTDELETEpthisNovedadCTInstance(NovedadCT novedadCTTDELETEpthisNovedadCT) {
        this.novedadCTTDELETEpthisNovedadCTInstance = novedadCTTDELETEpthisNovedadCT;
        this.novedadCTTDELETEpthisNovedadCT = novedadCTTDELETEpthisNovedadCT != null ? novedadCTTDELETEpthisNovedadCT.getOid() : null;
    }

    private void checkNovedadCTTDELETEpthisNovedadCT() throws NotNullArgumentException {
        if(this.getNovedadCTTDELETEpthisNovedadCTInstance() == null || this.getNovedadCTTDELETEpthisNovedadCTInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_TDELETE, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_TDELETE_NOVEDADCTTDELETEPTHISNOVEDADCT, NovedadCTConstants.SERV_ALIAS_TDELETE, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_TDELETE_NOVEDADCTTDELETEPTHISNOVEDADCT);
        }
    }
}
