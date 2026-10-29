package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;

public class TCREARDOCNUMIDSIEXISTERequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance;

    @JsonProperty("p_numidentificacion")
    private String familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad();
        checkFamiliaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad() {
        return this.familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad) {
        this.familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad = familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad) {
        this.familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance = familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad;
        this.familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad = familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad != null ? familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARDOCNUMIDSIEXISTE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARDOCNUMIDSIEXISTE_FAMILIANOVEDADTCREARDOCNUMIDSIEXISTEPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TCREARDOCNUMIDSIEXISTE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARDOCNUMIDSIEXISTE_FAMILIANOVEDADTCREARDOCNUMIDSIEXISTEPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion() {
        return this.familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion;
    }
    
    public void setFamiliaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion(String familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion) {
        this.familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion = familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion;
    }

    private void checkFamiliaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARDOCNUMIDSIEXISTE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARDOCNUMIDSIEXISTE_FAMILIANOVEDADTCREARDOCNUMIDSIEXISTEPNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TCREARDOCNUMIDSIEXISTE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARDOCNUMIDSIEXISTE_FAMILIANOVEDADTCREARDOCNUMIDSIEXISTEPNUMIDENTIFICACION);
        }
    }
}
