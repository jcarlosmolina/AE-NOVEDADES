package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class CambiarExcluidoRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadcambiarExcluidopthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance;

    @JsonProperty("prexcluido")
    private Boolean usuarioNovedadcambiarExcluidoprExcluido;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadcambiarExcluidopthisUsuarioNovedad();
        checkUsuarioNovedadcambiarExcluidoprExcluido();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadcambiarExcluidopthisUsuarioNovedad() {
        return this.usuarioNovedadcambiarExcluidopthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadcambiarExcluidopthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadcambiarExcluidopthisUsuarioNovedad) {
        this.usuarioNovedadcambiarExcluidopthisUsuarioNovedad = usuarioNovedadcambiarExcluidopthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance() {
        return this.usuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadcambiarExcluidopthisUsuarioNovedad) {
        this.usuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance = usuarioNovedadcambiarExcluidopthisUsuarioNovedad;
        this.usuarioNovedadcambiarExcluidopthisUsuarioNovedad = usuarioNovedadcambiarExcluidopthisUsuarioNovedad != null ? usuarioNovedadcambiarExcluidopthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadcambiarExcluidopthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIAREXCLUIDO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIAREXCLUIDO_USUARIONOVEDADCAMBIAREXCLUIDOPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_CAMBIAREXCLUIDO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIAREXCLUIDO_USUARIONOVEDADCAMBIAREXCLUIDOPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public Boolean getUsuarioNovedadcambiarExcluidoprExcluido() {
        return this.usuarioNovedadcambiarExcluidoprExcluido;
    }
    
    public void setUsuarioNovedadcambiarExcluidoprExcluido(Boolean usuarioNovedadcambiarExcluidoprExcluido) {
        this.usuarioNovedadcambiarExcluidoprExcluido = usuarioNovedadcambiarExcluidoprExcluido;
    }

    private void checkUsuarioNovedadcambiarExcluidoprExcluido() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarExcluidoprExcluido() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIAREXCLUIDO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIAREXCLUIDO_USUARIONOVEDADCAMBIAREXCLUIDOPREXCLUIDO, UsuarioNovedadConstants.SERV_ALIAS_CAMBIAREXCLUIDO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIAREXCLUIDO_USUARIONOVEDADCAMBIAREXCLUIDOPREXCLUIDO);
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
