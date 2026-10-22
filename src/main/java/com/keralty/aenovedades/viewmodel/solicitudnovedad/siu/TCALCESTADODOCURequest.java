package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TCALCESTADODOCURequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad() {
        return this.solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad) {
        this.solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad = solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad) {
        this.solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance = solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad;
        this.solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad = solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad != null ? solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCALCESTADODOCU, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCALCESTADODOCU_SOLICITUDNOVEDADTCALCESTADODOCUPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCALCESTADODOCU, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCALCESTADODOCU_SOLICITUDNOVEDADTCALCESTADODOCUPTHISSOLICITUDNOVEDAD);
        }
    }
}
