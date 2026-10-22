package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class DelTipoIdentContratanteRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad();
        checkSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad() {
        return this.solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad) {
        this.solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad = solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance() {
        return this.solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad) {
        this.solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance = solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad;
        this.solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad = solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad != null ? solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADDELTIPOIDENTCONTRATANTEPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DELTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADDELTIPOIDENTCONTRATANTEPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion() {
        return this.solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion;
    }
    
    public void setSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion(TipoIdentificacionOid solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion) {
        this.solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion = solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance() {
        return this.solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance;
    }
    
    public void setSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance(TipoIdentificacion solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion) {
        this.solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance = solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion;
        this.solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion = solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion != null ? solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion.getOid() : null;
    }

    private void checkSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance() == null || this.getSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADDELTIPOIDENTCONTRATANTEPEVCTIPOIDENTIFICACION, SolicitudNovedadConstants.SERV_ALIAS_DELTIPOIDENTCONTRATANTE, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELTIPOIDENTCONTRATANTE_SOLICITUDNOVEDADDELTIPOIDENTCONTRATANTEPEVCTIPOIDENTIFICACION);
        }
    }
}
