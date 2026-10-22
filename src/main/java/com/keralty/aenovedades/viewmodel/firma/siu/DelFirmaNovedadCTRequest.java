package com.keralty.aenovedades.viewmodel.firma.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FirmaConstants;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;

public class DelFirmaNovedadCTRequest {

    @JsonProperty("p_thisfirma_oid")
    private FirmaOid firmaDelFirmaNovedadCTpthisFirma;
    
    @JsonIgnore
    private Firma firmaDelFirmaNovedadCTpthisFirmaInstance;

    @JsonProperty("p_evcnovedadct_oid")
    private NovedadCTOid firmaDelFirmaNovedadCTpevcNovedadCT;
    
    @JsonIgnore
    private NovedadCT firmaDelFirmaNovedadCTpevcNovedadCTInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFirmaDelFirmaNovedadCTpthisFirma();
        checkFirmaDelFirmaNovedadCTpevcNovedadCT();
    }

    @JsonIgnore
    public FirmaOid getFirmaDelFirmaNovedadCTpthisFirma() {
        return this.firmaDelFirmaNovedadCTpthisFirma;
    }
    
    public void setFirmaDelFirmaNovedadCTpthisFirma(FirmaOid firmaDelFirmaNovedadCTpthisFirma) {
        this.firmaDelFirmaNovedadCTpthisFirma = firmaDelFirmaNovedadCTpthisFirma;
    }

    @JsonIgnore
    public Firma getFirmaDelFirmaNovedadCTpthisFirmaInstance() {
        return this.firmaDelFirmaNovedadCTpthisFirmaInstance;
    }
    
    public void setFirmaDelFirmaNovedadCTpthisFirmaInstance(Firma firmaDelFirmaNovedadCTpthisFirma) {
        this.firmaDelFirmaNovedadCTpthisFirmaInstance = firmaDelFirmaNovedadCTpthisFirma;
        this.firmaDelFirmaNovedadCTpthisFirma = firmaDelFirmaNovedadCTpthisFirma != null ? firmaDelFirmaNovedadCTpthisFirma.getOid() : null;
    }

    private void checkFirmaDelFirmaNovedadCTpthisFirma() throws NotNullArgumentException {
        if(this.getFirmaDelFirmaNovedadCTpthisFirmaInstance() == null || this.getFirmaDelFirmaNovedadCTpthisFirmaInstance().isNull()) {
            throw new NotNullArgumentException(FirmaConstants.SERV_ID_DELFIRMANOVEDADCT, FirmaConstants.CLASS_ID, FirmaConstants.ARG_ID_DELFIRMANOVEDADCT_FIRMADELFIRMANOVEDADCTPTHISFIRMA, FirmaConstants.SERV_ALIAS_DELFIRMANOVEDADCT, FirmaConstants.CLASS_ALIAS, FirmaConstants.ARG_ALIAS_DELFIRMANOVEDADCT_FIRMADELFIRMANOVEDADCTPTHISFIRMA);
        }
    }

    @JsonIgnore
    public NovedadCTOid getFirmaDelFirmaNovedadCTpevcNovedadCT() {
        return this.firmaDelFirmaNovedadCTpevcNovedadCT;
    }
    
    public void setFirmaDelFirmaNovedadCTpevcNovedadCT(NovedadCTOid firmaDelFirmaNovedadCTpevcNovedadCT) {
        this.firmaDelFirmaNovedadCTpevcNovedadCT = firmaDelFirmaNovedadCTpevcNovedadCT;
    }

    @JsonIgnore
    public NovedadCT getFirmaDelFirmaNovedadCTpevcNovedadCTInstance() {
        return this.firmaDelFirmaNovedadCTpevcNovedadCTInstance;
    }
    
    public void setFirmaDelFirmaNovedadCTpevcNovedadCTInstance(NovedadCT firmaDelFirmaNovedadCTpevcNovedadCT) {
        this.firmaDelFirmaNovedadCTpevcNovedadCTInstance = firmaDelFirmaNovedadCTpevcNovedadCT;
        this.firmaDelFirmaNovedadCTpevcNovedadCT = firmaDelFirmaNovedadCTpevcNovedadCT != null ? firmaDelFirmaNovedadCTpevcNovedadCT.getOid() : null;
    }

    private void checkFirmaDelFirmaNovedadCTpevcNovedadCT() throws NotNullArgumentException {
        if(this.getFirmaDelFirmaNovedadCTpevcNovedadCTInstance() == null || this.getFirmaDelFirmaNovedadCTpevcNovedadCTInstance().isNull()) {
            throw new NotNullArgumentException(FirmaConstants.SERV_ID_DELFIRMANOVEDADCT, FirmaConstants.CLASS_ID, FirmaConstants.ARG_ID_DELFIRMANOVEDADCT_FIRMADELFIRMANOVEDADCTPEVCNOVEDADCT, FirmaConstants.SERV_ALIAS_DELFIRMANOVEDADCT, FirmaConstants.CLASS_ALIAS, FirmaConstants.ARG_ALIAS_DELFIRMANOVEDADCT_FIRMADELFIRMANOVEDADCTPEVCNOVEDADCT);
        }
    }
}
