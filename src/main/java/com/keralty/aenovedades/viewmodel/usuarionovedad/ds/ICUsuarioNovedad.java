package com.keralty.aenovedades.viewmodel.usuarionovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
public class ICUsuarioNovedad {

    @JsonProperty("drvnombrecompleto")
    private String iCUsuarioNovedadDrvNombreCompleto;

    public ICUsuarioNovedad() {
    
    }

    public ICUsuarioNovedad(UsuarioNovedad instance) {
        if (instance != null) {
            try {
                this.iCUsuarioNovedadDrvNombreCompleto = instance.getUsuarioNovedadDrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICUsuarioNovedadDrvNombreCompleto() {
        return this.iCUsuarioNovedadDrvNombreCompleto;
    }
    
    public void setICUsuarioNovedadDrvNombreCompleto(String iCUsuarioNovedadDrvNombreCompleto) {
        this.iCUsuarioNovedadDrvNombreCompleto = iCUsuarioNovedadDrvNombreCompleto;
    }
}
