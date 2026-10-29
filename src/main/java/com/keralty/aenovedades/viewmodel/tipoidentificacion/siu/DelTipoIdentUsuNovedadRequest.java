package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelTipoIdentUsuNovedadRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion();
        checkTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion() {
        return this.tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion(String tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance = tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion;
        this.tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion != null ? tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDENTUSUNOVEDADPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDENTUSUNOVEDADPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad() {
        return this.tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad = tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance() {
        return this.tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad) {
        this.tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance = tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad;
        this.tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad = tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad != null ? tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance() == null || this.getTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDENTUSUNOVEDADPEVCUSUARIONOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTUSUNOVEDAD, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTUSUNOVEDAD_TIPOIDENTIFICACIONDELTIPOIDENTUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
