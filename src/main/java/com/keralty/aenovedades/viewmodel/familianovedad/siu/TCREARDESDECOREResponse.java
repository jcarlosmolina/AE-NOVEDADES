package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCREARDESDECOREResponse extends ServiceResponse {


    @JsonProperty("oafamilianovedad")
    private FamiliaNovedadOid familiaNovedadTCREARDESDECOREoaFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTCREARDESDECOREoaFamiliaNovedadInstance;

    public TCREARDESDECOREResponse() {
        super();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTCREARDESDECOREoaFamiliaNovedad() {
        return this.familiaNovedadTCREARDESDECOREoaFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREoaFamiliaNovedad(FamiliaNovedadOid familiaNovedadTCREARDESDECOREoaFamiliaNovedad) {
        this.familiaNovedadTCREARDESDECOREoaFamiliaNovedad = familiaNovedadTCREARDESDECOREoaFamiliaNovedad;
    }
    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTCREARDESDECOREoaFamiliaNovedadInstance() {
        return this.familiaNovedadTCREARDESDECOREoaFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREoaFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTCREARDESDECOREoaFamiliaNovedad) {
        if (familiaNovedadTCREARDESDECOREoaFamiliaNovedad != null && !familiaNovedadTCREARDESDECOREoaFamiliaNovedad.isNull()) {
            this.familiaNovedadTCREARDESDECOREoaFamiliaNovedad = familiaNovedadTCREARDESDECOREoaFamiliaNovedad.getOid();
            this.familiaNovedadTCREARDESDECOREoaFamiliaNovedadInstance = familiaNovedadTCREARDESDECOREoaFamiliaNovedad;
        } else {
            this.familiaNovedadTCREARDESDECOREoaFamiliaNovedad = null;
            this.familiaNovedadTCREARDESDECOREoaFamiliaNovedadInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("familiaNovedadTCREARDESDECOREoaFamiliaNovedad", familiaNovedadTCREARDESDECOREoaFamiliaNovedad);
        return outArgs;
    }
}
