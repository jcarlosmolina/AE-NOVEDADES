package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;

public class TFIRMARRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTFIRMARpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTFIRMARpthisSolicitudNovedadInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] solicitudNovedadTFIRMARptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String solicitudNovedadTFIRMARptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String solicitudNovedadTFIRMARptpatrLongitud;

    @JsonProperty("pt_texto")
    private String solicitudNovedadTFIRMARptTexto;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTFIRMARpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTFIRMARpthisSolicitudNovedad() {
        return this.solicitudNovedadTFIRMARpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTFIRMARpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTFIRMARpthisSolicitudNovedad) {
        this.solicitudNovedadTFIRMARpthisSolicitudNovedad = solicitudNovedadTFIRMARpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTFIRMARpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTFIRMARpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTFIRMARpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTFIRMARpthisSolicitudNovedad) {
        this.solicitudNovedadTFIRMARpthisSolicitudNovedadInstance = solicitudNovedadTFIRMARpthisSolicitudNovedad;
        this.solicitudNovedadTFIRMARpthisSolicitudNovedad = solicitudNovedadTFIRMARpthisSolicitudNovedad != null ? solicitudNovedadTFIRMARpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTFIRMARpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTFIRMARpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTFIRMARpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TFIRMAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TFIRMAR_SOLICITUDNOVEDADTFIRMARPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TFIRMAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TFIRMAR_SOLICITUDNOVEDADTFIRMARPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public byte[] getSolicitudNovedadTFIRMARptpatrImagenFirma() {
        return this.solicitudNovedadTFIRMARptpatrImagenFirma;
    }
    
    public void setSolicitudNovedadTFIRMARptpatrImagenFirma(byte[] solicitudNovedadTFIRMARptpatrImagenFirma) {
        this.solicitudNovedadTFIRMARptpatrImagenFirma = solicitudNovedadTFIRMARptpatrImagenFirma;
    }

    @JsonIgnore
    public String getSolicitudNovedadTFIRMARptpatrLatitud() {
        return this.solicitudNovedadTFIRMARptpatrLatitud;
    }
    
    public void setSolicitudNovedadTFIRMARptpatrLatitud(String solicitudNovedadTFIRMARptpatrLatitud) {
        this.solicitudNovedadTFIRMARptpatrLatitud = solicitudNovedadTFIRMARptpatrLatitud;
    }

    @JsonIgnore
    public String getSolicitudNovedadTFIRMARptpatrLongitud() {
        return this.solicitudNovedadTFIRMARptpatrLongitud;
    }
    
    public void setSolicitudNovedadTFIRMARptpatrLongitud(String solicitudNovedadTFIRMARptpatrLongitud) {
        this.solicitudNovedadTFIRMARptpatrLongitud = solicitudNovedadTFIRMARptpatrLongitud;
    }

    @JsonIgnore
    public String getSolicitudNovedadTFIRMARptTexto() {
        return this.solicitudNovedadTFIRMARptTexto;
    }
    
    public void setSolicitudNovedadTFIRMARptTexto(String solicitudNovedadTFIRMARptTexto) {
        this.solicitudNovedadTFIRMARptTexto = solicitudNovedadTFIRMARptTexto;
    }
}
