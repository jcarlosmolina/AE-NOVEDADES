package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelTipoIdCDUsuNovedadRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion();
        checkTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion() {
        return this.tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion(String tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion = tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance = tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion;
        this.tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion = tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion != null ? tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDCDUSUNOVEDADPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDCDUSUNOVEDADPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad() {
        return this.tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad = tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance() {
        return this.tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance = tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad;
        this.tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad = tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad != null ? tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance() == null || this.getTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDCDUSUNOVEDADPEVCUSUARIONOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDCDUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
