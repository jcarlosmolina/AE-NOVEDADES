package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class CambiarASRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadcambiarASpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadcambiarASpthisUsuarioNovedadInstance;

    @JsonProperty("pactivacion")
    private Boolean usuarioNovedadcambiarASpActivacion;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadcambiarASpthisUsuarioNovedad();
        checkUsuarioNovedadcambiarASpActivacion();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadcambiarASpthisUsuarioNovedad() {
        return this.usuarioNovedadcambiarASpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadcambiarASpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadcambiarASpthisUsuarioNovedad) {
        this.usuarioNovedadcambiarASpthisUsuarioNovedad = usuarioNovedadcambiarASpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadcambiarASpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadcambiarASpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadcambiarASpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadcambiarASpthisUsuarioNovedad) {
        this.usuarioNovedadcambiarASpthisUsuarioNovedadInstance = usuarioNovedadcambiarASpthisUsuarioNovedad;
        this.usuarioNovedadcambiarASpthisUsuarioNovedad = usuarioNovedadcambiarASpthisUsuarioNovedad != null ? usuarioNovedadcambiarASpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadcambiarASpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarASpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadcambiarASpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIARAS, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIARAS_USUARIONOVEDADCAMBIARASPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_CAMBIARAS, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIARAS_USUARIONOVEDADCAMBIARASPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public Boolean getUsuarioNovedadcambiarASpActivacion() {
        return this.usuarioNovedadcambiarASpActivacion;
    }
    
    public void setUsuarioNovedadcambiarASpActivacion(Boolean usuarioNovedadcambiarASpActivacion) {
        this.usuarioNovedadcambiarASpActivacion = usuarioNovedadcambiarASpActivacion;
    }

    private void checkUsuarioNovedadcambiarASpActivacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarASpActivacion() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIARAS, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIARAS_USUARIONOVEDADCAMBIARASPACTIVACION, UsuarioNovedadConstants.SERV_ALIAS_CAMBIARAS, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIARAS_USUARIONOVEDADCAMBIARASPACTIVACION);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
