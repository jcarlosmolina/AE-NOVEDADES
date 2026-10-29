package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class DelTipoIdentificacionRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedad();
        checkFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacion();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedad() {
        return this.familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad) {
        this.familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad = familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance() {
        return this.familiaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad) {
        this.familiaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance = familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad;
        this.familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad = familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad != null ? familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_DELTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_DELTIPOIDENTIFICACION_FAMILIANOVEDADDELTIPOIDENTIFICACIONPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_DELTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_DELTIPOIDENTIFICACION_FAMILIANOVEDADDELTIPOIDENTIFICACIONPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacion() {
        return this.familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion;
    }
    
    public void setFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacion(TipoIdentificacionOid familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion) {
        this.familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion = familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance() {
        return this.familiaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance(TipoIdentificacion familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion) {
        this.familiaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance = familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion;
        this.familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion = familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion != null ? familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion.getOid() : null;
    }

    private void checkFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance() == null || this.getFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_DELTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_DELTIPOIDENTIFICACION_FAMILIANOVEDADDELTIPOIDENTIFICACIONPEVCTIPOIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_DELTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_DELTIPOIDENTIFICACION_FAMILIANOVEDADDELTIPOIDENTIFICACIONPEVCTIPOIDENTIFICACION);
        }
    }
}
