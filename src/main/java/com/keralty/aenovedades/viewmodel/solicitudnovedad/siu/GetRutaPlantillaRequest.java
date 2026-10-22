package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class GetRutaPlantillaRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadgetRutaPlantillapthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadgetRutaPlantillapthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedad() {
        return this.solicitudNovedadgetRutaPlantillapthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadgetRutaPlantillapthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadgetRutaPlantillapthisSolicitudNovedad) {
        this.solicitudNovedadgetRutaPlantillapthisSolicitudNovedad = solicitudNovedadgetRutaPlantillapthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance() {
        return this.solicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadgetRutaPlantillapthisSolicitudNovedad) {
        this.solicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance = solicitudNovedadgetRutaPlantillapthisSolicitudNovedad;
        this.solicitudNovedadgetRutaPlantillapthisSolicitudNovedad = solicitudNovedadgetRutaPlantillapthisSolicitudNovedad != null ? solicitudNovedadgetRutaPlantillapthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadgetRutaPlantillapthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_GETRUTAPLANTILLA, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_GETRUTAPLANTILLA_SOLICITUDNOVEDADGETRUTAPLANTILLAPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_GETRUTAPLANTILLA, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_GETRUTAPLANTILLA_SOLICITUDNOVEDADGETRUTAPLANTILLAPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
