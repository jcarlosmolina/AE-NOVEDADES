package com.keralty.aenovedades.viewmodel.documentonovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
public class ICDocumentoNovedad {

    @JsonProperty("nombre")
    private String iCDocumentoNovedadNombre;

    public ICDocumentoNovedad() {
    
    }

    public ICDocumentoNovedad(DocumentoNovedad instance) {
        if (instance != null) {
            this.iCDocumentoNovedadNombre = instance.getDocumentoNovedadNombre();
        }
    }

    @JsonIgnore
    public String getICDocumentoNovedadNombre() {
        return this.iCDocumentoNovedadNombre;
    }
    
    public void setICDocumentoNovedadNombre(String iCDocumentoNovedadNombre) {
        this.iCDocumentoNovedadNombre = iCDocumentoNovedadNombre;
    }
}
