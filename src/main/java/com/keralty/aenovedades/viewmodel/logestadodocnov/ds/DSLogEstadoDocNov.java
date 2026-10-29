package com.keralty.aenovedades.viewmodel.logestadodocnov.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
public class DSLogEstadoDocNov {

    @JsonProperty("fecha")
    private Timestamp dSLogEstadoDocNovFecha;

    @JsonProperty("nombrefuncionario")
    private String dSLogEstadoDocNovNombreFuncionario;

    @JsonProperty("estadoanterior")
    private Long dSLogEstadoDocNovEstadoAnterior;

    @JsonProperty("estadonuevo")
    private Long dSLogEstadoDocNovEstadoNuevo;

    @JsonProperty("observacions")
    private String dSLogEstadoDocNovObservacions;

    public DSLogEstadoDocNov() {
    
    }

    public DSLogEstadoDocNov(LogEstadoDocNov instance) {
        if (instance != null) {
            this.dSLogEstadoDocNovFecha = instance.getLogEstadoDocNovFecha();
            this.dSLogEstadoDocNovNombreFuncionario = instance.getLogEstadoDocNovNombreFuncionario();
            this.dSLogEstadoDocNovEstadoAnterior = instance.getLogEstadoDocNovEstadoAnterior();
            this.dSLogEstadoDocNovEstadoNuevo = instance.getLogEstadoDocNovEstadoNuevo();
            this.dSLogEstadoDocNovObservacions = instance.getLogEstadoDocNovObservacions();
        }
    }

    @JsonIgnore
    public Timestamp getDSLogEstadoDocNovFecha() {
        return this.dSLogEstadoDocNovFecha;
    }
    
    public void setDSLogEstadoDocNovFecha(Timestamp dSLogEstadoDocNovFecha) {
        this.dSLogEstadoDocNovFecha = dSLogEstadoDocNovFecha;
    }

    @JsonIgnore
    public String getDSLogEstadoDocNovNombreFuncionario() {
        return this.dSLogEstadoDocNovNombreFuncionario;
    }
    
    public void setDSLogEstadoDocNovNombreFuncionario(String dSLogEstadoDocNovNombreFuncionario) {
        this.dSLogEstadoDocNovNombreFuncionario = dSLogEstadoDocNovNombreFuncionario;
    }

    @JsonIgnore
    public Long getDSLogEstadoDocNovEstadoAnterior() {
        return this.dSLogEstadoDocNovEstadoAnterior;
    }
    
    public void setDSLogEstadoDocNovEstadoAnterior(Long dSLogEstadoDocNovEstadoAnterior) {
        this.dSLogEstadoDocNovEstadoAnterior = dSLogEstadoDocNovEstadoAnterior;
    }

    @JsonIgnore
    public Long getDSLogEstadoDocNovEstadoNuevo() {
        return this.dSLogEstadoDocNovEstadoNuevo;
    }
    
    public void setDSLogEstadoDocNovEstadoNuevo(Long dSLogEstadoDocNovEstadoNuevo) {
        this.dSLogEstadoDocNovEstadoNuevo = dSLogEstadoDocNovEstadoNuevo;
    }

    @JsonIgnore
    public String getDSLogEstadoDocNovObservacions() {
        return this.dSLogEstadoDocNovObservacions;
    }
    
    public void setDSLogEstadoDocNovObservacions(String dSLogEstadoDocNovObservacions) {
        this.dSLogEstadoDocNovObservacions = dSLogEstadoDocNovObservacions;
    }
}
