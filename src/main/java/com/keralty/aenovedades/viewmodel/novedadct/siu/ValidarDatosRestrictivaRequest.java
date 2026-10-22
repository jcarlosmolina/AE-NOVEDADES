package com.keralty.aenovedades.viewmodel.novedadct.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;

public class ValidarDatosRestrictivaRequest {

    @JsonProperty("p_thisnovedadct_oid")
    private NovedadCTOid novedadCTvalidarDatosRestrictivapthisNovedadCT;
    
    @JsonIgnore
    private NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCTInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadCTvalidarDatosRestrictivapthisNovedadCT();
    }

    @JsonIgnore
    public NovedadCTOid getNovedadCTvalidarDatosRestrictivapthisNovedadCT() {
        return this.novedadCTvalidarDatosRestrictivapthisNovedadCT;
    }
    
    public void setNovedadCTvalidarDatosRestrictivapthisNovedadCT(NovedadCTOid novedadCTvalidarDatosRestrictivapthisNovedadCT) {
        this.novedadCTvalidarDatosRestrictivapthisNovedadCT = novedadCTvalidarDatosRestrictivapthisNovedadCT;
    }

    @JsonIgnore
    public NovedadCT getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance() {
        return this.novedadCTvalidarDatosRestrictivapthisNovedadCTInstance;
    }
    
    public void setNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance(NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT) {
        this.novedadCTvalidarDatosRestrictivapthisNovedadCTInstance = novedadCTvalidarDatosRestrictivapthisNovedadCT;
        this.novedadCTvalidarDatosRestrictivapthisNovedadCT = novedadCTvalidarDatosRestrictivapthisNovedadCT != null ? novedadCTvalidarDatosRestrictivapthisNovedadCT.getOid() : null;
    }

    private void checkNovedadCTvalidarDatosRestrictivapthisNovedadCT() throws NotNullArgumentException {
        if(this.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance() == null || this.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_VALIDARDATOSRESTRICTIVA, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_VALIDARDATOSRESTRICTIVA_NOVEDADCTVALIDARDATOSRESTRICTIVAPTHISNOVEDADCT, NovedadCTConstants.SERV_ALIAS_VALIDARDATOSRESTRICTIVA, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_VALIDARDATOSRESTRICTIVA_NOVEDADCTVALIDARDATOSRESTRICTIVAPTHISNOVEDADCT);
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
