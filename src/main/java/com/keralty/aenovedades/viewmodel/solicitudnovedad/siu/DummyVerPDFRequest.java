package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class DummyVerPDFRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedaddummyVerPDFpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedaddummyVerPDFpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedaddummyVerPDFpthisSolicitudNovedad() {
        return this.solicitudNovedaddummyVerPDFpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedaddummyVerPDFpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedaddummyVerPDFpthisSolicitudNovedad) {
        this.solicitudNovedaddummyVerPDFpthisSolicitudNovedad = solicitudNovedaddummyVerPDFpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance() {
        return this.solicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedaddummyVerPDFpthisSolicitudNovedad) {
        this.solicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance = solicitudNovedaddummyVerPDFpthisSolicitudNovedad;
        this.solicitudNovedaddummyVerPDFpthisSolicitudNovedad = solicitudNovedaddummyVerPDFpthisSolicitudNovedad != null ? solicitudNovedaddummyVerPDFpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedaddummyVerPDFpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DUMMYVERPDF, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DUMMYVERPDF_SOLICITUDNOVEDADDUMMYVERPDFPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DUMMYVERPDF, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DUMMYVERPDF_SOLICITUDNOVEDADDUMMYVERPDFPTHISSOLICITUDNOVEDAD);
        }
    }
}
