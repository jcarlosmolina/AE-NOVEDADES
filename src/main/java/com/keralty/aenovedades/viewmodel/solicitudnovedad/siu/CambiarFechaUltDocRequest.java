package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.sql.Timestamp;

public class CambiarFechaUltDocRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance;

    @JsonProperty("pefechahora")
    private Timestamp solicitudNovedadcambiarFechaUltDocpeFechaHora;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad();
        checkSolicitudNovedadcambiarFechaUltDocpeFechaHora();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad() {
        return this.solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad) {
        this.solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad = solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad) {
        this.solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance = solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad;
        this.solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad = solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad != null ? solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CAMBIARFECHAULTDOC, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CAMBIARFECHAULTDOC_SOLICITUDNOVEDADCAMBIARFECHAULTDOCPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_CAMBIARFECHAULTDOC, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CAMBIARFECHAULTDOC_SOLICITUDNOVEDADCAMBIARFECHAULTDOCPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public Timestamp getSolicitudNovedadcambiarFechaUltDocpeFechaHora() {
        return this.solicitudNovedadcambiarFechaUltDocpeFechaHora;
    }
    
    public void setSolicitudNovedadcambiarFechaUltDocpeFechaHora(Timestamp solicitudNovedadcambiarFechaUltDocpeFechaHora) {
        this.solicitudNovedadcambiarFechaUltDocpeFechaHora = solicitudNovedadcambiarFechaUltDocpeFechaHora;
    }

    private void checkSolicitudNovedadcambiarFechaUltDocpeFechaHora() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcambiarFechaUltDocpeFechaHora() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CAMBIARFECHAULTDOC, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CAMBIARFECHAULTDOC_SOLICITUDNOVEDADCAMBIARFECHAULTDOCPEFECHAHORA, SolicitudNovedadConstants.SERV_ALIAS_CAMBIARFECHAULTDOC, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CAMBIARFECHAULTDOC_SOLICITUDNOVEDADCAMBIARFECHAULTDOCPEFECHAHORA);
        }
    }
}
