package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class DelTipoIdentContratanteRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion();
        checkTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion() {
        return this.tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion(String tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion = tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance = tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion;
        this.tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion = tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion != null ? tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONDELTIPOIDENTCONTRATANTEPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONDELTIPOIDENTCONTRATANTEPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad() {
        return this.tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad;
    }
    
    public void setTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad(SolicitudNovedadOid tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad) {
        this.tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad = tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance() {
        return this.tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance(SolicitudNovedad tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad) {
        this.tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance = tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad;
        this.tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad = tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad != null ? tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance() == null || this.getTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONDELTIPOIDENTCONTRATANTEPEVCSOLICITUDNOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONDELTIPOIDENTCONTRATANTEPEVCSOLICITUDNOVEDAD);
        }
    }
}
