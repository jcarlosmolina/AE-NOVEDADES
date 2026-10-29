package com.keralty.aenovedades.viewmodel.novedadct.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;

public class TCREAROMODFIRMANUEVOTITRequest {

    @JsonProperty("p_thisnovedadct_oid")
    private NovedadCTOid novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT;
    
    @JsonIgnore
    private NovedadCT novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT();
    }

    @JsonIgnore
    public NovedadCTOid getNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT() {
        return this.novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT;
    }
    
    public void setNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT(NovedadCTOid novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT) {
        this.novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT = novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT;
    }

    @JsonIgnore
    public NovedadCT getNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance() {
        return this.novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance;
    }
    
    public void setNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance(NovedadCT novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT) {
        this.novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance = novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT;
        this.novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT = novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT != null ? novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT.getOid() : null;
    }

    private void checkNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT() throws NotNullArgumentException {
        if(this.getNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance() == null || this.getNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_TCREAROMODFIRMANUEVOTIT, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_TCREAROMODFIRMANUEVOTIT_NOVEDADCTTCREAROMODFIRMANUEVOTITPTHISNOVEDADCT, NovedadCTConstants.SERV_ALIAS_TCREAROMODFIRMANUEVOTIT, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_TCREAROMODFIRMANUEVOTIT_NOVEDADCTTCREAROMODFIRMANUEVOTITPTHISNOVEDADCT);
        }
    }

    @JsonIgnore
    public byte[] getNovedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma() {
        return this.novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma;
    }
    
    public void setNovedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma(byte[] novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma) {
        this.novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma = novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma;
    }

    @JsonIgnore
    public String getNovedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud() {
        return this.novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud;
    }
    
    public void setNovedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud(String novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud) {
        this.novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud = novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud;
    }

    @JsonIgnore
    public String getNovedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud() {
        return this.novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud;
    }
    
    public void setNovedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud(String novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud) {
        this.novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud = novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud;
    }
}
