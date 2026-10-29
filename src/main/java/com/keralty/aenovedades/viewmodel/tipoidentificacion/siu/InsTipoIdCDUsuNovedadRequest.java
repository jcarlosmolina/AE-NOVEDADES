package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsTipoIdCDUsuNovedadRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion();
        checkTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion() {
        return this.tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion(String tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion = tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance = tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion;
        this.tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion = tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion != null ? tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDCDUSUNOVEDADPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDCDUSUNOVEDADPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad() {
        return this.tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad = tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance() {
        return this.tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance = tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad;
        this.tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad = tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad != null ? tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance() == null || this.getTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDCDUSUNOVEDADPEVCUSUARIONOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDCDUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDCDUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDCDUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
