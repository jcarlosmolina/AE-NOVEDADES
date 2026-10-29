package com.keralty.aenovedades.viewmodel.usuarionovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
public class DSUsuarioNovedadNull {

    @JsonProperty("idusuarionovedad")
    private Long dSUsuarioNovedadNullIdUsuarioNovedad;

    public DSUsuarioNovedadNull() {
    
    }

    public DSUsuarioNovedadNull(UsuarioNovedad instance) {
        if (instance != null) {
            this.dSUsuarioNovedadNullIdUsuarioNovedad = instance.getUsuarioNovedadidUsuarioNovedad();
        }
    }

    @JsonIgnore
    public Long getDSUsuarioNovedadNullIdUsuarioNovedad() {
        return this.dSUsuarioNovedadNullIdUsuarioNovedad;
    }
    
    public void setDSUsuarioNovedadNullIdUsuarioNovedad(Long dSUsuarioNovedadNullIdUsuarioNovedad) {
        this.dSUsuarioNovedadNullIdUsuarioNovedad = dSUsuarioNovedadNullIdUsuarioNovedad;
    }
}
