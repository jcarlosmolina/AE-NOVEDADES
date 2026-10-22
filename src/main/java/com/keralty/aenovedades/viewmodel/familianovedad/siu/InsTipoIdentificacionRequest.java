package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class InsTipoIdentificacionRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedad();
        checkFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacion();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedad() {
        return this.familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad) {
        this.familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad = familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance() {
        return this.familiaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad) {
        this.familiaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance = familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad;
        this.familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad = familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad != null ? familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_INSTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_INSTIPOIDENTIFICACION_FAMILIANOVEDADINSTIPOIDENTIFICACIONPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_INSTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_INSTIPOIDENTIFICACION_FAMILIANOVEDADINSTIPOIDENTIFICACIONPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacion() {
        return this.familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion;
    }
    
    public void setFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacion(TipoIdentificacionOid familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion) {
        this.familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion = familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance() {
        return this.familiaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance(TipoIdentificacion familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion) {
        this.familiaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance = familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion;
        this.familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion = familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion != null ? familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion.getOid() : null;
    }

    private void checkFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance() == null || this.getFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_INSTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_INSTIPOIDENTIFICACION_FAMILIANOVEDADINSTIPOIDENTIFICACIONPEVCTIPOIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_INSTIPOIDENTIFICACION, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_INSTIPOIDENTIFICACION_FAMILIANOVEDADINSTIPOIDENTIFICACIONPEVCTIPOIDENTIFICACION);
        }
    }
}
