package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsTipoIdentUsuNovedadRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion();
        checkTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion() {
        return this.tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion(String tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance = tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion;
        this.tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion != null ? tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDENTUSUNOVEDADPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDENTUSUNOVEDADPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad() {
        return this.tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad = tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance() {
        return this.tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance = tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad;
        this.tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad = tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad != null ? tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance() == null || this.getTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDENTUSUNOVEDADPEVCUSUARIONOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONINSTIPOIDENTUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
