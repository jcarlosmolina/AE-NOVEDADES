package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsTipoIdentUsuNovedadRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad();
        checkUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad() {
        return this.usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad = usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance = usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad;
        this.usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad = usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad != null ? usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSTIPOIDENTUSUNOVEDAD_USUARIONOVEDADINSTIPOIDENTUSUNOVEDADPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_INSTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSTIPOIDENTUSUNOVEDAD_USUARIONOVEDADINSTIPOIDENTUSUNOVEDADPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion() {
        return this.usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion;
    }
    
    public void setUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion(TipoIdentificacionOid usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion = usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance() {
        return this.usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance = usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion;
        this.usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion = usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion != null ? usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion.getOid() : null;
    }

    private void checkUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance() == null || this.getUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSTIPOIDENTUSUNOVEDAD_USUARIONOVEDADINSTIPOIDENTUSUNOVEDADPEVCTIPOIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_INSTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSTIPOIDENTUSUNOVEDAD_USUARIONOVEDADINSTIPOIDENTUSUNOVEDADPEVCTIPOIDENTIFICACION);
        }
    }
}
