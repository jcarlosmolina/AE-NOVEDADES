package com.keralty.aenovedades.viewmodel.logestadosn.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.LogEstadoSN;
public class DSLogEstadoSNPIU {

    @JsonProperty("fecha")
    private Timestamp dSLogEstadoSNPIUFecha;

    @JsonProperty("estado")
    private Long dSLogEstadoSNPIUEstado;

    @JsonProperty("estadodoc")
    private Long dSLogEstadoSNPIUEstadoDoc;

    @JsonProperty("loginfuncionario")
    private String dSLogEstadoSNPIULoginFuncionario;

    public DSLogEstadoSNPIU() {
    
    }

    public DSLogEstadoSNPIU(LogEstadoSN instance) {
        if (instance != null) {
            this.dSLogEstadoSNPIUFecha = instance.getLogEstadoSNFecha();
            this.dSLogEstadoSNPIUEstado = instance.getLogEstadoSNEstado();
            this.dSLogEstadoSNPIUEstadoDoc = instance.getLogEstadoSNEstadoDoc();
            this.dSLogEstadoSNPIULoginFuncionario = instance.getLogEstadoSNLoginFuncionario();
        }
    }

    @JsonIgnore
    public Timestamp getDSLogEstadoSNPIUFecha() {
        return this.dSLogEstadoSNPIUFecha;
    }
    
    public void setDSLogEstadoSNPIUFecha(Timestamp dSLogEstadoSNPIUFecha) {
        this.dSLogEstadoSNPIUFecha = dSLogEstadoSNPIUFecha;
    }

    @JsonIgnore
    public Long getDSLogEstadoSNPIUEstado() {
        return this.dSLogEstadoSNPIUEstado;
    }
    
    public void setDSLogEstadoSNPIUEstado(Long dSLogEstadoSNPIUEstado) {
        this.dSLogEstadoSNPIUEstado = dSLogEstadoSNPIUEstado;
    }

    @JsonIgnore
    public Long getDSLogEstadoSNPIUEstadoDoc() {
        return this.dSLogEstadoSNPIUEstadoDoc;
    }
    
    public void setDSLogEstadoSNPIUEstadoDoc(Long dSLogEstadoSNPIUEstadoDoc) {
        this.dSLogEstadoSNPIUEstadoDoc = dSLogEstadoSNPIUEstadoDoc;
    }

    @JsonIgnore
    public String getDSLogEstadoSNPIULoginFuncionario() {
        return this.dSLogEstadoSNPIULoginFuncionario;
    }
    
    public void setDSLogEstadoSNPIULoginFuncionario(String dSLogEstadoSNPIULoginFuncionario) {
        this.dSLogEstadoSNPIULoginFuncionario = dSLogEstadoSNPIULoginFuncionario;
    }
}
