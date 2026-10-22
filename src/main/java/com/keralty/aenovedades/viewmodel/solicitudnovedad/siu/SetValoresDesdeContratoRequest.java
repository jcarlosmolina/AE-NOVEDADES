package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class SetValoresDesdeContratoRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance;

    @JsonProperty("p_ctrcodigotarifa")
    private String solicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa;

    @JsonProperty("p_ctrdesctarifa")
    private String solicitudNovedadsetValoresDesdeContratopCtrDescTarifa;

    @JsonProperty("p_ctrcodigoconvenio")
    private String solicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio;

    @JsonProperty("p_ctrdescconvenio")
    private String solicitudNovedadsetValoresDesdeContratopCtrDescConvenio;

    @JsonProperty("p_ctrescolectivo")
    private Boolean solicitudNovedadsetValoresDesdeContratopCtrEsColectivo;

    @JsonProperty("p_contranumiden")
    private String solicitudNovedadsetValoresDesdeContratopContraNumIden;

    @JsonProperty("p_contraprimernombre")
    private String solicitudNovedadsetValoresDesdeContratopContraPrimerNombre;

    @JsonProperty("p_contrasegundonombre")
    private String solicitudNovedadsetValoresDesdeContratopContraSegundoNombre;

    @JsonProperty("p_contraprimerapellido")
    private String solicitudNovedadsetValoresDesdeContratopContraPrimerApellido;

    @JsonProperty("p_contrasegundoapellido")
    private String solicitudNovedadsetValoresDesdeContratopContraSegundoApellido;

    @JsonProperty("p_ctrtagcausaexclusion")
    private String solicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion;

    @JsonProperty("p_contrarazonsocial")
    private String solicitudNovedadsetValoresDesdeContratopContraRazonSocial;

    @JsonProperty("pctractivo")
    private Boolean solicitudNovedadsetValoresDesdeContratopCtrActivo;

    @JsonProperty("p_contratipopersona")
    private String solicitudNovedadsetValoresDesdeContratopContraTipoPersona;

    @JsonProperty("p_atrctrfiniciocontrato")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato;

    @JsonProperty("p_ctrtipocontrato")
    private Long solicitudNovedadsetValoresDesdeContratopCtrTipoContrato;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad();
        checkSolicitudNovedadsetValoresDesdeContratopCtrEsColectivo();
        checkSolicitudNovedadsetValoresDesdeContratopCtrActivo();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad() {
        return this.solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad) {
        this.solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad = solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance() {
        return this.solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad) {
        this.solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance = solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad;
        this.solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad = solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad != null ? solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_SETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_SETVALORESDESDECONTRATO_SOLICITUDNOVEDADSETVALORESDESDECONTRATOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_SETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_SETVALORESDESDECONTRATO_SOLICITUDNOVEDADSETVALORESDESDECONTRATOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa(String solicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa) {
        this.solicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa = solicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopCtrDescTarifa() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrDescTarifa;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrDescTarifa(String solicitudNovedadsetValoresDesdeContratopCtrDescTarifa) {
        this.solicitudNovedadsetValoresDesdeContratopCtrDescTarifa = solicitudNovedadsetValoresDesdeContratopCtrDescTarifa;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio(String solicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio) {
        this.solicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio = solicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopCtrDescConvenio() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrDescConvenio;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrDescConvenio(String solicitudNovedadsetValoresDesdeContratopCtrDescConvenio) {
        this.solicitudNovedadsetValoresDesdeContratopCtrDescConvenio = solicitudNovedadsetValoresDesdeContratopCtrDescConvenio;
    }

    @JsonIgnore
    public Boolean getSolicitudNovedadsetValoresDesdeContratopCtrEsColectivo() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrEsColectivo;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrEsColectivo(Boolean solicitudNovedadsetValoresDesdeContratopCtrEsColectivo) {
        this.solicitudNovedadsetValoresDesdeContratopCtrEsColectivo = solicitudNovedadsetValoresDesdeContratopCtrEsColectivo;
    }

    private void checkSolicitudNovedadsetValoresDesdeContratopCtrEsColectivo() throws NotNullArgumentException {
        if(this.getSolicitudNovedadsetValoresDesdeContratopCtrEsColectivo() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_SETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_SETVALORESDESDECONTRATO_SOLICITUDNOVEDADSETVALORESDESDECONTRATOPCTRESCOLECTIVO, SolicitudNovedadConstants.SERV_ALIAS_SETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_SETVALORESDESDECONTRATO_SOLICITUDNOVEDADSETVALORESDESDECONTRATOPCTRESCOLECTIVO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopContraNumIden() {
        return this.solicitudNovedadsetValoresDesdeContratopContraNumIden;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopContraNumIden(String solicitudNovedadsetValoresDesdeContratopContraNumIden) {
        this.solicitudNovedadsetValoresDesdeContratopContraNumIden = solicitudNovedadsetValoresDesdeContratopContraNumIden;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopContraPrimerNombre() {
        return this.solicitudNovedadsetValoresDesdeContratopContraPrimerNombre;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopContraPrimerNombre(String solicitudNovedadsetValoresDesdeContratopContraPrimerNombre) {
        this.solicitudNovedadsetValoresDesdeContratopContraPrimerNombre = solicitudNovedadsetValoresDesdeContratopContraPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopContraSegundoNombre() {
        return this.solicitudNovedadsetValoresDesdeContratopContraSegundoNombre;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopContraSegundoNombre(String solicitudNovedadsetValoresDesdeContratopContraSegundoNombre) {
        this.solicitudNovedadsetValoresDesdeContratopContraSegundoNombre = solicitudNovedadsetValoresDesdeContratopContraSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopContraPrimerApellido() {
        return this.solicitudNovedadsetValoresDesdeContratopContraPrimerApellido;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopContraPrimerApellido(String solicitudNovedadsetValoresDesdeContratopContraPrimerApellido) {
        this.solicitudNovedadsetValoresDesdeContratopContraPrimerApellido = solicitudNovedadsetValoresDesdeContratopContraPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopContraSegundoApellido() {
        return this.solicitudNovedadsetValoresDesdeContratopContraSegundoApellido;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopContraSegundoApellido(String solicitudNovedadsetValoresDesdeContratopContraSegundoApellido) {
        this.solicitudNovedadsetValoresDesdeContratopContraSegundoApellido = solicitudNovedadsetValoresDesdeContratopContraSegundoApellido;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion(String solicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion) {
        this.solicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion = solicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion;
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopContraRazonSocial() {
        return this.solicitudNovedadsetValoresDesdeContratopContraRazonSocial;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopContraRazonSocial(String solicitudNovedadsetValoresDesdeContratopContraRazonSocial) {
        this.solicitudNovedadsetValoresDesdeContratopContraRazonSocial = solicitudNovedadsetValoresDesdeContratopContraRazonSocial;
    }

    @JsonIgnore
    public Boolean getSolicitudNovedadsetValoresDesdeContratopCtrActivo() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrActivo;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrActivo(Boolean solicitudNovedadsetValoresDesdeContratopCtrActivo) {
        this.solicitudNovedadsetValoresDesdeContratopCtrActivo = solicitudNovedadsetValoresDesdeContratopCtrActivo;
    }

    private void checkSolicitudNovedadsetValoresDesdeContratopCtrActivo() throws NotNullArgumentException {
        if(this.getSolicitudNovedadsetValoresDesdeContratopCtrActivo() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_SETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_SETVALORESDESDECONTRATO_SOLICITUDNOVEDADSETVALORESDESDECONTRATOPCTRACTIVO, SolicitudNovedadConstants.SERV_ALIAS_SETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_SETVALORESDESDECONTRATO_SOLICITUDNOVEDADSETVALORESDESDECONTRATOPCTRACTIVO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadsetValoresDesdeContratopContraTipoPersona() {
        return this.solicitudNovedadsetValoresDesdeContratopContraTipoPersona;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopContraTipoPersona(String solicitudNovedadsetValoresDesdeContratopContraTipoPersona) {
        this.solicitudNovedadsetValoresDesdeContratopContraTipoPersona = solicitudNovedadsetValoresDesdeContratopContraTipoPersona;
    }

    @JsonIgnore
    public Date getSolicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato() {
        return this.solicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato(Date solicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato) {
        this.solicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato = solicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato;
    }

    @JsonIgnore
    public Long getSolicitudNovedadsetValoresDesdeContratopCtrTipoContrato() {
        return this.solicitudNovedadsetValoresDesdeContratopCtrTipoContrato;
    }
    
    public void setSolicitudNovedadsetValoresDesdeContratopCtrTipoContrato(Long solicitudNovedadsetValoresDesdeContratopCtrTipoContrato) {
        this.solicitudNovedadsetValoresDesdeContratopCtrTipoContrato = solicitudNovedadsetValoresDesdeContratopCtrTipoContrato;
    }
}
