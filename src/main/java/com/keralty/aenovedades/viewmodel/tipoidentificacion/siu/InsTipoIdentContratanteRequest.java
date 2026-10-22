package com.keralty.aenovedades.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class InsTipoIdentContratanteRequest {

    @JsonProperty("p_thistipoidentificacion_json")
    private String tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion();
        checkTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad();
    }

    @JsonIgnore
    public String getTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion() {
        return this.tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion(String tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion = tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance = tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion;
        this.tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion = tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion != null ? tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONINSTIPOIDENTCONTRATANTEPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONINSTIPOIDENTCONTRATANTEPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad() {
        return this.tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad;
    }
    
    public void setTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad(SolicitudNovedadOid tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad) {
        this.tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad = tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance() {
        return this.tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance(SolicitudNovedad tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad) {
        this.tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance = tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad;
        this.tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad = tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad != null ? tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance() == null || this.getTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONINSTIPOIDENTCONTRATANTEPEVCSOLICITUDNOVEDAD, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTCONTRATANTE, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTCONTRATANTE_TIPOIDENTIFICACIONINSTIPOIDENTCONTRATANTEPEVCSOLICITUDNOVEDAD);
        }
    }
}
