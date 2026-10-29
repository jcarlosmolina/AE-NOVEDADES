package com.keralty.aenovedades.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class OGSOLNOVSETTRAMITADOResponse extends ServiceResponse {

    @JsonProperty("oanumprocesados")
    private Long oGSOLNOVSETTRAMITADOoaNumProcesados;

    @JsonProperty("oanumerrores")
    private Long oGSOLNOVSETTRAMITADOoaNumErrores;

    @JsonProperty("oaerrores")
    private String oGSOLNOVSETTRAMITADOoaErrores;

    public OGSOLNOVSETTRAMITADOResponse() {
        super();
    }

    @JsonIgnore
    public Long getOGSOLNOVSETTRAMITADOoaNumProcesados() {
        return this.oGSOLNOVSETTRAMITADOoaNumProcesados;
    }

    public void setOGSOLNOVSETTRAMITADOoaNumProcesados(Long oGSOLNOVSETTRAMITADOoaNumProcesados) {
        this.oGSOLNOVSETTRAMITADOoaNumProcesados = oGSOLNOVSETTRAMITADOoaNumProcesados;
    }

    @JsonIgnore
    public Long getOGSOLNOVSETTRAMITADOoaNumErrores() {
        return this.oGSOLNOVSETTRAMITADOoaNumErrores;
    }

    public void setOGSOLNOVSETTRAMITADOoaNumErrores(Long oGSOLNOVSETTRAMITADOoaNumErrores) {
        this.oGSOLNOVSETTRAMITADOoaNumErrores = oGSOLNOVSETTRAMITADOoaNumErrores;
    }

    @JsonIgnore
    public String getOGSOLNOVSETTRAMITADOoaErrores() {
        return this.oGSOLNOVSETTRAMITADOoaErrores;
    }

    public void setOGSOLNOVSETTRAMITADOoaErrores(String oGSOLNOVSETTRAMITADOoaErrores) {
        this.oGSOLNOVSETTRAMITADOoaErrores = oGSOLNOVSETTRAMITADOoaErrores;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("oGSOLNOVSETTRAMITADOoaNumProcesados", oGSOLNOVSETTRAMITADOoaNumProcesados);
        outArgs.put("oGSOLNOVSETTRAMITADOoaNumErrores", oGSOLNOVSETTRAMITADOoaNumErrores);
        outArgs.put("oGSOLNOVSETTRAMITADOoaErrores", oGSOLNOVSETTRAMITADOoaErrores);
        return outArgs;
    }
}
