package com.keralty.aenovedades.viewmodel.firma.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.Firma;
public class DSFirmaNull {

    @JsonProperty("identificador")
    private Long dSFirmaNullIdentificador;

    public DSFirmaNull() {
    
    }

    public DSFirmaNull(Firma instance) {
        if (instance != null) {
            this.dSFirmaNullIdentificador = instance.getFirmaIdentificador();
        }
    }

    @JsonIgnore
    public Long getDSFirmaNullIdentificador() {
        return this.dSFirmaNullIdentificador;
    }
    
    public void setDSFirmaNullIdentificador(Long dSFirmaNullIdentificador) {
        this.dSFirmaNullIdentificador = dSFirmaNullIdentificador;
    }
}
