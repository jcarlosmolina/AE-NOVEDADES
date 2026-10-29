package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class CambiarRORequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadcambiarROpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadcambiarROpthisUsuarioNovedadInstance;

    @JsonProperty("prcontratar")
    private Boolean usuarioNovedadcambiarROprContratar;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadcambiarROpthisUsuarioNovedad();
        checkUsuarioNovedadcambiarROprContratar();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadcambiarROpthisUsuarioNovedad() {
        return this.usuarioNovedadcambiarROpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadcambiarROpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadcambiarROpthisUsuarioNovedad) {
        this.usuarioNovedadcambiarROpthisUsuarioNovedad = usuarioNovedadcambiarROpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadcambiarROpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadcambiarROpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadcambiarROpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadcambiarROpthisUsuarioNovedad) {
        this.usuarioNovedadcambiarROpthisUsuarioNovedadInstance = usuarioNovedadcambiarROpthisUsuarioNovedad;
        this.usuarioNovedadcambiarROpthisUsuarioNovedad = usuarioNovedadcambiarROpthisUsuarioNovedad != null ? usuarioNovedadcambiarROpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadcambiarROpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarROpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadcambiarROpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIARRO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIARRO_USUARIONOVEDADCAMBIARROPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_CAMBIARRO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIARRO_USUARIONOVEDADCAMBIARROPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public Boolean getUsuarioNovedadcambiarROprContratar() {
        return this.usuarioNovedadcambiarROprContratar;
    }
    
    public void setUsuarioNovedadcambiarROprContratar(Boolean usuarioNovedadcambiarROprContratar) {
        this.usuarioNovedadcambiarROprContratar = usuarioNovedadcambiarROprContratar;
    }

    private void checkUsuarioNovedadcambiarROprContratar() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarROprContratar() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIARRO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIARRO_USUARIONOVEDADCAMBIARROPRCONTRATAR, UsuarioNovedadConstants.SERV_ALIAS_CAMBIARRO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIARRO_USUARIONOVEDADCAMBIARROPRCONTRATAR);
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
