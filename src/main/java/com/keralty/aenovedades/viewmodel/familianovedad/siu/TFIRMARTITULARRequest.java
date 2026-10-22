package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class TFIRMARTITULARRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTFIRMARTITULARpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] familiaNovedadTFIRMARTITULARptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String familiaNovedadTFIRMARTITULARptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String familiaNovedadTFIRMARTITULARptpatrLongitud;

    @JsonProperty("pt_texto")
    private String familiaNovedadTFIRMARTITULARptTexto;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedad();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedad() {
        return this.familiaNovedadTFIRMARTITULARpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTFIRMARTITULARpthisFamiliaNovedad) {
        this.familiaNovedadTFIRMARTITULARpthisFamiliaNovedad = familiaNovedadTFIRMARTITULARpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTFIRMARTITULARpthisFamiliaNovedad) {
        this.familiaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance = familiaNovedadTFIRMARTITULARpthisFamiliaNovedad;
        this.familiaNovedadTFIRMARTITULARpthisFamiliaNovedad = familiaNovedadTFIRMARTITULARpthisFamiliaNovedad != null ? familiaNovedadTFIRMARTITULARpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TFIRMARTITULAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TFIRMARTITULAR_FAMILIANOVEDADTFIRMARTITULARPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TFIRMARTITULAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TFIRMARTITULAR_FAMILIANOVEDADTFIRMARTITULARPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public byte[] getFamiliaNovedadTFIRMARTITULARptpatrImagenFirma() {
        return this.familiaNovedadTFIRMARTITULARptpatrImagenFirma;
    }
    
    public void setFamiliaNovedadTFIRMARTITULARptpatrImagenFirma(byte[] familiaNovedadTFIRMARTITULARptpatrImagenFirma) {
        this.familiaNovedadTFIRMARTITULARptpatrImagenFirma = familiaNovedadTFIRMARTITULARptpatrImagenFirma;
    }

    @JsonIgnore
    public String getFamiliaNovedadTFIRMARTITULARptpatrLatitud() {
        return this.familiaNovedadTFIRMARTITULARptpatrLatitud;
    }
    
    public void setFamiliaNovedadTFIRMARTITULARptpatrLatitud(String familiaNovedadTFIRMARTITULARptpatrLatitud) {
        this.familiaNovedadTFIRMARTITULARptpatrLatitud = familiaNovedadTFIRMARTITULARptpatrLatitud;
    }

    @JsonIgnore
    public String getFamiliaNovedadTFIRMARTITULARptpatrLongitud() {
        return this.familiaNovedadTFIRMARTITULARptpatrLongitud;
    }
    
    public void setFamiliaNovedadTFIRMARTITULARptpatrLongitud(String familiaNovedadTFIRMARTITULARptpatrLongitud) {
        this.familiaNovedadTFIRMARTITULARptpatrLongitud = familiaNovedadTFIRMARTITULARptpatrLongitud;
    }

    @JsonIgnore
    public String getFamiliaNovedadTFIRMARTITULARptTexto() {
        return this.familiaNovedadTFIRMARTITULARptTexto;
    }
    
    public void setFamiliaNovedadTFIRMARTITULARptTexto(String familiaNovedadTFIRMARTITULARptTexto) {
        this.familiaNovedadTFIRMARTITULARptTexto = familiaNovedadTFIRMARTITULARptTexto;
    }
}
