package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelTipoIdCDUsuNovedadRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad();
        checkUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad() {
        return this.usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance = usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad;
        this.usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad != null ? usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELTIPOIDCDUSUNOVEDAD_USUARIONOVEDADDELTIPOIDCDUSUNOVEDADPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_DELTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELTIPOIDCDUSUNOVEDAD_USUARIONOVEDADDELTIPOIDCDUSUNOVEDADPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion() {
        return this.usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion;
    }
    
    public void setUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion(TipoIdentificacionOid usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion = usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance() {
        return this.usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance = usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion;
        this.usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion = usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion != null ? usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion.getOid() : null;
    }

    private void checkUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance() == null || this.getUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELTIPOIDCDUSUNOVEDAD_USUARIONOVEDADDELTIPOIDCDUSUNOVEDADPEVCTIPOIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_DELTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELTIPOIDCDUSUNOVEDAD_USUARIONOVEDADDELTIPOIDCDUSUNOVEDADPEVCTIPOIDENTIFICACION);
        }
    }
}
