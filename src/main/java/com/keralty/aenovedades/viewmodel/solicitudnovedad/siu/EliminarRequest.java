package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class EliminarRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadeliminarpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadeliminarpthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadeliminarpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadeliminarpthisSolicitudNovedad() {
        return this.solicitudNovedadeliminarpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadeliminarpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadeliminarpthisSolicitudNovedad) {
        this.solicitudNovedadeliminarpthisSolicitudNovedad = solicitudNovedadeliminarpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadeliminarpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadeliminarpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadeliminarpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadeliminarpthisSolicitudNovedad) {
        this.solicitudNovedadeliminarpthisSolicitudNovedadInstance = solicitudNovedadeliminarpthisSolicitudNovedad;
        this.solicitudNovedadeliminarpthisSolicitudNovedad = solicitudNovedadeliminarpthisSolicitudNovedad != null ? solicitudNovedadeliminarpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadeliminarpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadeliminarpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadeliminarpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_ELIMINAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_ELIMINAR_SOLICITUDNOVEDADELIMINARPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_ELIMINAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_ELIMINAR_SOLICITUDNOVEDADELIMINARPTHISSOLICITUDNOVEDAD);
        }
    }
}
