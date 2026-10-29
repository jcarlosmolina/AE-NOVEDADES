package com.keralty.aenovedades.viewmodel.novedadct.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;

public class ValidarDatosRestrictivaTipoIdRequest {

    @JsonProperty("p_thisnovedadct_oid")
    private NovedadCTOid novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT;
    
    @JsonIgnore
    private NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT();
    }

    @JsonIgnore
    public NovedadCTOid getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT() {
        return this.novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT;
    }
    
    public void setNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT(NovedadCTOid novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT) {
        this.novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT;
    }

    @JsonIgnore
    public NovedadCT getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance() {
        return this.novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance;
    }
    
    public void setNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance(NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT) {
        this.novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance = novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT;
        this.novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT != null ? novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getOid() : null;
    }

    private void checkNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT() throws NotNullArgumentException {
        if(this.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance() == null || this.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_VALIDARDATOSRESTRICTIVATIPOID, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_VALIDARDATOSRESTRICTIVATIPOID_NOVEDADCTVALIDARDATOSRESTRICTIVATIPOIDPTHISNOVEDADCT, NovedadCTConstants.SERV_ALIAS_VALIDARDATOSRESTRICTIVATIPOID, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_VALIDARDATOSRESTRICTIVATIPOID_NOVEDADCTVALIDARDATOSRESTRICTIVATIPOIDPTHISNOVEDADCT);
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
