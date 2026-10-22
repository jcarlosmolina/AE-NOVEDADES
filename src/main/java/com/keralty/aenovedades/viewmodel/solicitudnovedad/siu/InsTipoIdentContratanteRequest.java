package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class InsTipoIdentContratanteRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad();
        checkSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad() {
        return this.solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad) {
        this.solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad = solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance() {
        return this.solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad) {
        this.solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance = solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad;
        this.solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad = solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad != null ? solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADINSTIPOIDENTCONTRATANTEPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_INSTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADINSTIPOIDENTCONTRATANTEPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion() {
        return this.solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion;
    }
    
    public void setSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion(TipoIdentificacionOid solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion) {
        this.solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion = solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance() {
        return this.solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance;
    }
    
    public void setSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance(TipoIdentificacion solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion) {
        this.solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance = solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion;
        this.solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion = solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion != null ? solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion.getOid() : null;
    }

    private void checkSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance() == null || this.getSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADINSTIPOIDENTCONTRATANTEPEVCTIPOIDENTIFICACION, SolicitudNovedadConstants.SERV_ALIAS_INSTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADINSTIPOIDENTCONTRATANTEPEVCTIPOIDENTIFICACION);
        }
    }
}
