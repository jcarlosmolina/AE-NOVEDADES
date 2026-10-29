package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class ModificarSUNumMesesRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance;

    @JsonProperty("p_sunummeses")
    private Long usuarioNovedadmodificarSUNumMesespSUNumMeses;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedad();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedad() {
        return this.usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad) {
        this.usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad = usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance() {
        return this.usuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad) {
        this.usuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance = usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad;
        this.usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad = usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad != null ? usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_MODIFICARSUNUMMESES, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_MODIFICARSUNUMMESES_USUARIONOVEDADMODIFICARSUNUMMESESPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_MODIFICARSUNUMMESES, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_MODIFICARSUNUMMESES_USUARIONOVEDADMODIFICARSUNUMMESESPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public Long getUsuarioNovedadmodificarSUNumMesespSUNumMeses() {
        return this.usuarioNovedadmodificarSUNumMesespSUNumMeses;
    }
    
    public void setUsuarioNovedadmodificarSUNumMesespSUNumMeses(Long usuarioNovedadmodificarSUNumMesespSUNumMeses) {
        this.usuarioNovedadmodificarSUNumMesespSUNumMeses = usuarioNovedadmodificarSUNumMesespSUNumMeses;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
