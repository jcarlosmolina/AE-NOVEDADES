package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class InsTipoIdentificacionRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcfamilianovedad_oid")
    private FamiliaNovedadOid tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion();
        checkTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion() {
        return this.tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion(String tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance = tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion;
        this.tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion != null ? tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTIFICACION_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTIFICACION_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public FamiliaNovedadOid getTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad() {
        return this.tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad(FamiliaNovedadOid tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad) {
        this.tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad = tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance() {
        return this.tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance(FamiliaNovedad tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad) {
        this.tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance = tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad;
        this.tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad = tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad != null ? tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance() == null || this.getTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTIFICACION_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONPEVCFAMILIANOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTIFICACION_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONPEVCFAMILIANOVEDAD);
        }
    }
}
