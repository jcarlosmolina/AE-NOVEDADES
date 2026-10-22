package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelTipoIdentUsuNovedadRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad();
        checkUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad() {
        return this.usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance = usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad;
        this.usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad != null ? usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELTIPOIDENTUSUNOVEDAD_USUARIONOVEDADDELTIPOIDENTUSUNOVEDADPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_DELTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELTIPOIDENTUSUNOVEDAD_USUARIONOVEDADDELTIPOIDENTUSUNOVEDADPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion() {
        return this.usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion;
    }
    
    public void setUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion(TipoIdentificacionOid usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion = usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance() {
        return this.usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion) {
        this.usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance = usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion;
        this.usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion = usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion != null ? usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion.getOid() : null;
    }

    private void checkUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance() == null || this.getUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELTIPOIDENTUSUNOVEDAD_USUARIONOVEDADDELTIPOIDENTUSUNOVEDADPEVCTIPOIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_DELTIPOIDENTUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELTIPOIDENTUSUNOVEDAD_USUARIONOVEDADDELTIPOIDENTUSUNOVEDADPEVCTIPOIDENTIFICACION);
        }
    }
}
