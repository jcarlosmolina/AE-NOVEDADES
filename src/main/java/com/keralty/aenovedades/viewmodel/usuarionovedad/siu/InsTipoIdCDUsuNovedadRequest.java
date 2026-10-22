package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsTipoIdCDUsuNovedadRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad();
        checkUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad() {
        return this.usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad = usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance = usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad;
        this.usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad = usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad != null ? usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSTIPOIDCDUSUNOVEDAD_USUARIONOVEDADINSTIPOIDCDUSUNOVEDADPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_INSTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSTIPOIDCDUSUNOVEDAD_USUARIONOVEDADINSTIPOIDCDUSUNOVEDADPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion() {
        return this.usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion;
    }
    
    public void setUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion(TipoIdentificacionOid usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion = usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance() {
        return this.usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance = usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion;
        this.usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion = usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion != null ? usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion.getOid() : null;
    }

    private void checkUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance() == null || this.getUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSTIPOIDCDUSUNOVEDAD_USUARIONOVEDADINSTIPOIDCDUSUNOVEDADPEVCTIPOIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_INSTIPOIDCDUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSTIPOIDCDUSUNOVEDAD_USUARIONOVEDADINSTIPOIDCDUSUNOVEDADPEVCTIPOIDENTIFICACION);
        }
    }
}
