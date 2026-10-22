package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class ValidarCPRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadvalidarCPpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadvalidarCPpthisUsuarioNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadvalidarCPpthisUsuarioNovedad();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadvalidarCPpthisUsuarioNovedad() {
        return this.usuarioNovedadvalidarCPpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadvalidarCPpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadvalidarCPpthisUsuarioNovedad) {
        this.usuarioNovedadvalidarCPpthisUsuarioNovedad = usuarioNovedadvalidarCPpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadvalidarCPpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadvalidarCPpthisUsuarioNovedad) {
        this.usuarioNovedadvalidarCPpthisUsuarioNovedadInstance = usuarioNovedadvalidarCPpthisUsuarioNovedad;
        this.usuarioNovedadvalidarCPpthisUsuarioNovedad = usuarioNovedadvalidarCPpthisUsuarioNovedad != null ? usuarioNovedadvalidarCPpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadvalidarCPpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_VALIDARCP, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_VALIDARCP_USUARIONOVEDADVALIDARCPPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_VALIDARCP, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_VALIDARCP_USUARIONOVEDADVALIDARCPPTHISUSUARIONOVEDAD);
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
