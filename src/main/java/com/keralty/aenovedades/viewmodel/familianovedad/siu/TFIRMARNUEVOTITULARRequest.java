package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class TFIRMARNUEVOTITULARRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] familiaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String familiaNovedadTFIRMARNUEVOTITULARptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String familiaNovedadTFIRMARNUEVOTITULARptpatrLongitud;

    @JsonProperty("pt_texto")
    private String familiaNovedadTFIRMARNUEVOTITULARptTexto;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad() {
        return this.familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad) {
        this.familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad = familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad) {
        this.familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance = familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad;
        this.familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad = familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad != null ? familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TFIRMARNUEVOTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TFIRMARNUEVOTITULAR_FAMILIANOVEDADTFIRMARNUEVOTITULARPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TFIRMARNUEVOTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TFIRMARNUEVOTITULAR_FAMILIANOVEDADTFIRMARNUEVOTITULARPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public byte[] getFamiliaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma() {
        return this.familiaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma;
    }
    
    public void setFamiliaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma(byte[] familiaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma) {
        this.familiaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma = familiaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma;
    }

    @JsonIgnore
    public String getFamiliaNovedadTFIRMARNUEVOTITULARptpatrLatitud() {
        return this.familiaNovedadTFIRMARNUEVOTITULARptpatrLatitud;
    }
    
    public void setFamiliaNovedadTFIRMARNUEVOTITULARptpatrLatitud(String familiaNovedadTFIRMARNUEVOTITULARptpatrLatitud) {
        this.familiaNovedadTFIRMARNUEVOTITULARptpatrLatitud = familiaNovedadTFIRMARNUEVOTITULARptpatrLatitud;
    }

    @JsonIgnore
    public String getFamiliaNovedadTFIRMARNUEVOTITULARptpatrLongitud() {
        return this.familiaNovedadTFIRMARNUEVOTITULARptpatrLongitud;
    }
    
    public void setFamiliaNovedadTFIRMARNUEVOTITULARptpatrLongitud(String familiaNovedadTFIRMARNUEVOTITULARptpatrLongitud) {
        this.familiaNovedadTFIRMARNUEVOTITULARptpatrLongitud = familiaNovedadTFIRMARNUEVOTITULARptpatrLongitud;
    }

    @JsonIgnore
    public String getFamiliaNovedadTFIRMARNUEVOTITULARptTexto() {
        return this.familiaNovedadTFIRMARNUEVOTITULARptTexto;
    }
    
    public void setFamiliaNovedadTFIRMARNUEVOTITULARptTexto(String familiaNovedadTFIRMARNUEVOTITULARptTexto) {
        this.familiaNovedadTFIRMARNUEVOTITULARptTexto = familiaNovedadTFIRMARNUEVOTITULARptTexto;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
