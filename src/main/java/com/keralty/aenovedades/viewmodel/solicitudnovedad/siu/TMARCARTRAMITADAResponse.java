package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TMARCARTRAMITADAResponse extends ServiceResponse {

    @JsonProperty("oanumprocesados")
    private Long solicitudNovedadTMARCARTRAMITADAoaNumProcesados;

    @JsonProperty("oanumerrores")
    private Long solicitudNovedadTMARCARTRAMITADAoaNumErrores;

    @JsonProperty("oaerrores")
    private String solicitudNovedadTMARCARTRAMITADAoaErrores;

    public TMARCARTRAMITADAResponse() {
        super();
    }

    @JsonIgnore
    public Long getSolicitudNovedadTMARCARTRAMITADAoaNumProcesados() {
        return this.solicitudNovedadTMARCARTRAMITADAoaNumProcesados;
    }
    
    public void setSolicitudNovedadTMARCARTRAMITADAoaNumProcesados(Long solicitudNovedadTMARCARTRAMITADAoaNumProcesados) {
        this.solicitudNovedadTMARCARTRAMITADAoaNumProcesados = solicitudNovedadTMARCARTRAMITADAoaNumProcesados;
    }

    @JsonIgnore
    public Long getSolicitudNovedadTMARCARTRAMITADAoaNumErrores() {
        return this.solicitudNovedadTMARCARTRAMITADAoaNumErrores;
    }
    
    public void setSolicitudNovedadTMARCARTRAMITADAoaNumErrores(Long solicitudNovedadTMARCARTRAMITADAoaNumErrores) {
        this.solicitudNovedadTMARCARTRAMITADAoaNumErrores = solicitudNovedadTMARCARTRAMITADAoaNumErrores;
    }

    @JsonIgnore
    public String getSolicitudNovedadTMARCARTRAMITADAoaErrores() {
        return this.solicitudNovedadTMARCARTRAMITADAoaErrores;
    }
    
    public void setSolicitudNovedadTMARCARTRAMITADAoaErrores(String solicitudNovedadTMARCARTRAMITADAoaErrores) {
        this.solicitudNovedadTMARCARTRAMITADAoaErrores = solicitudNovedadTMARCARTRAMITADAoaErrores;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudNovedadTMARCARTRAMITADAoaNumProcesados", solicitudNovedadTMARCARTRAMITADAoaNumProcesados);
        outArgs.put("solicitudNovedadTMARCARTRAMITADAoaNumErrores", solicitudNovedadTMARCARTRAMITADAoaNumErrores);
        outArgs.put("solicitudNovedadTMARCARTRAMITADAoaErrores", solicitudNovedadTMARCARTRAMITADAoaErrores);
        return outArgs;
    }
}
