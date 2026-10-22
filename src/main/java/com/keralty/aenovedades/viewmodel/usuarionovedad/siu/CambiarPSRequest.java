package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class CambiarPSRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadcambiarPSpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadcambiarPSpthisUsuarioNovedadInstance;

    @JsonProperty("pprorroga")
    private Boolean usuarioNovedadcambiarPSpProrroga;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadcambiarPSpthisUsuarioNovedad();
        checkUsuarioNovedadcambiarPSpProrroga();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadcambiarPSpthisUsuarioNovedad() {
        return this.usuarioNovedadcambiarPSpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadcambiarPSpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadcambiarPSpthisUsuarioNovedad) {
        this.usuarioNovedadcambiarPSpthisUsuarioNovedad = usuarioNovedadcambiarPSpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadcambiarPSpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadcambiarPSpthisUsuarioNovedad) {
        this.usuarioNovedadcambiarPSpthisUsuarioNovedadInstance = usuarioNovedadcambiarPSpthisUsuarioNovedad;
        this.usuarioNovedadcambiarPSpthisUsuarioNovedad = usuarioNovedadcambiarPSpthisUsuarioNovedad != null ? usuarioNovedadcambiarPSpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadcambiarPSpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIARPS, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIARPS_USUARIONOVEDADCAMBIARPSPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_CAMBIARPS, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIARPS_USUARIONOVEDADCAMBIARPSPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public Boolean getUsuarioNovedadcambiarPSpProrroga() {
        return this.usuarioNovedadcambiarPSpProrroga;
    }
    
    public void setUsuarioNovedadcambiarPSpProrroga(Boolean usuarioNovedadcambiarPSpProrroga) {
        this.usuarioNovedadcambiarPSpProrroga = usuarioNovedadcambiarPSpProrroga;
    }

    private void checkUsuarioNovedadcambiarPSpProrroga() throws NotNullArgumentException {
        if(this.getUsuarioNovedadcambiarPSpProrroga() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_CAMBIARPS, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_CAMBIARPS_USUARIONOVEDADCAMBIARPSPPRORROGA, UsuarioNovedadConstants.SERV_ALIAS_CAMBIARPS, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_CAMBIARPS_USUARIONOVEDADCAMBIARPSPPRORROGA);
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
