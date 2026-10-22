package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class DescargarDocumentoATOResponse extends ServiceResponse {

    @JsonProperty("oaurldescarga")
    private String documentoNovedaddescargarDocumentoATOoaUrlDescarga;

    @JsonProperty("oatoken")
    private String documentoNovedaddescargarDocumentoATOoaToken;

    @JsonProperty("oanumsolicitud")
    private String documentoNovedaddescargarDocumentoATOoaNumSolicitud;

    public DescargarDocumentoATOResponse() {
        super();
    }

    @JsonIgnore
    public String getDocumentoNovedaddescargarDocumentoATOoaUrlDescarga() {
        return this.documentoNovedaddescargarDocumentoATOoaUrlDescarga;
    }
    
    public void setDocumentoNovedaddescargarDocumentoATOoaUrlDescarga(String documentoNovedaddescargarDocumentoATOoaUrlDescarga) {
        this.documentoNovedaddescargarDocumentoATOoaUrlDescarga = documentoNovedaddescargarDocumentoATOoaUrlDescarga;
    }

    @JsonIgnore
    public String getDocumentoNovedaddescargarDocumentoATOoaToken() {
        return this.documentoNovedaddescargarDocumentoATOoaToken;
    }
    
    public void setDocumentoNovedaddescargarDocumentoATOoaToken(String documentoNovedaddescargarDocumentoATOoaToken) {
        this.documentoNovedaddescargarDocumentoATOoaToken = documentoNovedaddescargarDocumentoATOoaToken;
    }

    @JsonIgnore
    public String getDocumentoNovedaddescargarDocumentoATOoaNumSolicitud() {
        return this.documentoNovedaddescargarDocumentoATOoaNumSolicitud;
    }
    
    public void setDocumentoNovedaddescargarDocumentoATOoaNumSolicitud(String documentoNovedaddescargarDocumentoATOoaNumSolicitud) {
        this.documentoNovedaddescargarDocumentoATOoaNumSolicitud = documentoNovedaddescargarDocumentoATOoaNumSolicitud;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("documentoNovedaddescargarDocumentoATOoaUrlDescarga", documentoNovedaddescargarDocumentoATOoaUrlDescarga);
        outArgs.put("documentoNovedaddescargarDocumentoATOoaToken", documentoNovedaddescargarDocumentoATOoaToken);
        outArgs.put("documentoNovedaddescargarDocumentoATOoaNumSolicitud", documentoNovedaddescargarDocumentoATOoaNumSolicitud);
        return outArgs;
    }
}
