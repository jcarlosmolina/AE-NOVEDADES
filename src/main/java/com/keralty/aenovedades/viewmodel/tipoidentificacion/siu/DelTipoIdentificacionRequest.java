package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class DelTipoIdentificacionRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcfamilianovedad_oid")
    private FamiliaNovedadOid tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion();
        checkTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion() {
        return this.tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion(String tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance = tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion;
        this.tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion != null ? tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTIFICACION_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTIFICACION_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public FamiliaNovedadOid getTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad() {
        return this.tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad(FamiliaNovedadOid tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad) {
        this.tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad = tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance() {
        return this.tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance(FamiliaNovedad tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad) {
        this.tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance = tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad;
        this.tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad = tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad != null ? tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance() == null || this.getTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTIFICACION_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONPEVCFAMILIANOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTIFICACION_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONPEVCFAMILIANOVEDAD);
        }
    }
}
