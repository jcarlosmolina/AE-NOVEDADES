package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TMARCARCOMPLETADAResponse extends ServiceResponse {

    @JsonProperty("oanumerr")
    private Long solicitudNovedadTMARCARCOMPLETADAoaNumErr;

    public TMARCARCOMPLETADAResponse() {
        super();
    }

    @JsonIgnore
    public Long getSolicitudNovedadTMARCARCOMPLETADAoaNumErr() {
        return this.solicitudNovedadTMARCARCOMPLETADAoaNumErr;
    }
    
    public void setSolicitudNovedadTMARCARCOMPLETADAoaNumErr(Long solicitudNovedadTMARCARCOMPLETADAoaNumErr) {
        this.solicitudNovedadTMARCARCOMPLETADAoaNumErr = solicitudNovedadTMARCARCOMPLETADAoaNumErr;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudNovedadTMARCARCOMPLETADAoaNumErr", solicitudNovedadTMARCARCOMPLETADAoaNumErr);
        return outArgs;
    }
}
