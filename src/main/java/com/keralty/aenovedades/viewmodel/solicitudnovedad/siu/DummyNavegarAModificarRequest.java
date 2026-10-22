package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DummyNavegarAModificarRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad() {
        return this.solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad) {
        this.solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad = solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance() {
        return this.solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad) {
        this.solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance = solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad;
        this.solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad = solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad != null ? solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DUMMYNAVEGARAMODIFICAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DUMMYNAVEGARAMODIFICAR_SOLICITUDNOVEDADDUMMYNAVEGARAMODIFICARPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DUMMYNAVEGARAMODIFICAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DUMMYNAVEGARAMODIFICAR_SOLICITUDNOVEDADDUMMYNAVEGARAMODIFICARPTHISSOLICITUDNOVEDAD);
        }
    }
}
