package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCREARResponse extends ServiceResponse {


    @JsonProperty("oasolicitud")
    private SolicitudNovedadOid solicitudNovedadTCREARoaSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTCREARoaSolicitudInstance;

    public TCREARResponse() {
        super();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTCREARoaSolicitud() {
        return this.solicitudNovedadTCREARoaSolicitud;
    }
    
    public void setSolicitudNovedadTCREARoaSolicitud(SolicitudNovedadOid solicitudNovedadTCREARoaSolicitud) {
        this.solicitudNovedadTCREARoaSolicitud = solicitudNovedadTCREARoaSolicitud;
    }
    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTCREARoaSolicitudInstance() {
        return this.solicitudNovedadTCREARoaSolicitudInstance;
    }
    
    public void setSolicitudNovedadTCREARoaSolicitudInstance(SolicitudNovedad solicitudNovedadTCREARoaSolicitud) {
        if (solicitudNovedadTCREARoaSolicitud != null && !solicitudNovedadTCREARoaSolicitud.isNull()) {
            this.solicitudNovedadTCREARoaSolicitud = solicitudNovedadTCREARoaSolicitud.getOid();
            this.solicitudNovedadTCREARoaSolicitudInstance = solicitudNovedadTCREARoaSolicitud;
        } else {
            this.solicitudNovedadTCREARoaSolicitud = null;
            this.solicitudNovedadTCREARoaSolicitudInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudNovedadTCREARoaSolicitud", solicitudNovedadTCREARoaSolicitud);
        return outArgs;
    }
}
