package com.keralty.aenovedades.viewmodel.documentonovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
public class DSDocumentoNovedadNull {

    @JsonProperty("iddocumento")
    private Long dSDocumentoNovedadNullIdDocumento;

    public DSDocumentoNovedadNull() {
    
    }

    public DSDocumentoNovedadNull(DocumentoNovedad instance) {
        if (instance != null) {
            this.dSDocumentoNovedadNullIdDocumento = instance.getDocumentoNovedadIdDocumento();
        }
    }

    @JsonIgnore
    public Long getDSDocumentoNovedadNullIdDocumento() {
        return this.dSDocumentoNovedadNullIdDocumento;
    }
    
    public void setDSDocumentoNovedadNullIdDocumento(Long dSDocumentoNovedadNullIdDocumento) {
        this.dSDocumentoNovedadNullIdDocumento = dSDocumentoNovedadNullIdDocumento;
    }
}
