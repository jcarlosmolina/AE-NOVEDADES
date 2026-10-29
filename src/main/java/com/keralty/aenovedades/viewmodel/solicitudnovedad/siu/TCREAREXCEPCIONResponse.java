package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCREAREXCEPCIONResponse extends ServiceResponse {


    @JsonProperty("oasolicitud")
    private SolicitudNovedadOid solicitudNovedadTCREAREXCEPCIONoaSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTCREAREXCEPCIONoaSolicitudInstance;

    public TCREAREXCEPCIONResponse() {
        super();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTCREAREXCEPCIONoaSolicitud() {
        return this.solicitudNovedadTCREAREXCEPCIONoaSolicitud;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONoaSolicitud(SolicitudNovedadOid solicitudNovedadTCREAREXCEPCIONoaSolicitud) {
        this.solicitudNovedadTCREAREXCEPCIONoaSolicitud = solicitudNovedadTCREAREXCEPCIONoaSolicitud;
    }
    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTCREAREXCEPCIONoaSolicitudInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONoaSolicitudInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONoaSolicitudInstance(SolicitudNovedad solicitudNovedadTCREAREXCEPCIONoaSolicitud) {
        if (solicitudNovedadTCREAREXCEPCIONoaSolicitud != null && !solicitudNovedadTCREAREXCEPCIONoaSolicitud.isNull()) {
            this.solicitudNovedadTCREAREXCEPCIONoaSolicitud = solicitudNovedadTCREAREXCEPCIONoaSolicitud.getOid();
            this.solicitudNovedadTCREAREXCEPCIONoaSolicitudInstance = solicitudNovedadTCREAREXCEPCIONoaSolicitud;
        } else {
            this.solicitudNovedadTCREAREXCEPCIONoaSolicitud = null;
            this.solicitudNovedadTCREAREXCEPCIONoaSolicitudInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudNovedadTCREAREXCEPCIONoaSolicitud", solicitudNovedadTCREAREXCEPCIONoaSolicitud);
        return outArgs;
    }
}
