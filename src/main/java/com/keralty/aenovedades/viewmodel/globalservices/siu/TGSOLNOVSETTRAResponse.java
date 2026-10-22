package com.keralty.aenovedades.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TGSOLNOVSETTRAResponse extends ServiceResponse {

    @JsonProperty("pt_oanumprocesados")
    private Long tGSOLNOVSETTRAptoaNumProcesados;

    @JsonProperty("pt_oanumerrores")
    private Long tGSOLNOVSETTRAptoaNumErrores;

    @JsonProperty("pt_oaerrores")
    private String tGSOLNOVSETTRAptoaErrores;

    public TGSOLNOVSETTRAResponse() {
        super();
    }

    @JsonIgnore
    public Long getTGSOLNOVSETTRAptoaNumProcesados() {
        return this.tGSOLNOVSETTRAptoaNumProcesados;
    }

    public void setTGSOLNOVSETTRAptoaNumProcesados(Long tGSOLNOVSETTRAptoaNumProcesados) {
        this.tGSOLNOVSETTRAptoaNumProcesados = tGSOLNOVSETTRAptoaNumProcesados;
    }

    @JsonIgnore
    public Long getTGSOLNOVSETTRAptoaNumErrores() {
        return this.tGSOLNOVSETTRAptoaNumErrores;
    }

    public void setTGSOLNOVSETTRAptoaNumErrores(Long tGSOLNOVSETTRAptoaNumErrores) {
        this.tGSOLNOVSETTRAptoaNumErrores = tGSOLNOVSETTRAptoaNumErrores;
    }

    @JsonIgnore
    public String getTGSOLNOVSETTRAptoaErrores() {
        return this.tGSOLNOVSETTRAptoaErrores;
    }

    public void setTGSOLNOVSETTRAptoaErrores(String tGSOLNOVSETTRAptoaErrores) {
        this.tGSOLNOVSETTRAptoaErrores = tGSOLNOVSETTRAptoaErrores;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("tGSOLNOVSETTRAptoaNumProcesados", tGSOLNOVSETTRAptoaNumProcesados);
        outArgs.put("tGSOLNOVSETTRAptoaNumErrores", tGSOLNOVSETTRAptoaNumErrores);
        outArgs.put("tGSOLNOVSETTRAptoaErrores", tGSOLNOVSETTRAptoaErrores);
        return outArgs;
    }
}
