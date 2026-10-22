package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.GrupoAsociadoOid;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TSETVALORESDESDECONTRATORequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance;

    @JsonProperty("pt_p_ctrcodigotarifa")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa;

    @JsonProperty("pt_p_ctrdesctarifa")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa;

    @JsonProperty("pt_p_ctrcodigoconvenio")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio;

    @JsonProperty("pt_p_ctrdescconvenio")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio;

    @JsonProperty("pt_p_ctrescolectivo")
    private Boolean solicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo;

    @JsonProperty("pt_p_contranumiden")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden;

    @JsonProperty("pt_p_contraprimernombre")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre;

    @JsonProperty("pt_p_contrasegundonombre")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre;

    @JsonProperty("pt_p_contraprimerapellido")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido;

    @JsonProperty("pt_p_contrasegundoapellido")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido;

    @JsonProperty("pt_p_evcestadocontrato_oid")
    private EstadoContratoOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance;

    @JsonProperty("pt_p_evcgrupoasociado_oid")
    private GrupoAsociadoOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance;

    @JsonProperty("pt_p_evcperiodicidad_oid")
    private PeriodicidadOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance;

    @JsonProperty("pt_p_evctipoidentificacion_oid")
    private TipoIdentificacionOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance;

    @JsonProperty("pt_p_ctrtagcausaexclusion")
    private String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion;

    @JsonProperty("p_contrarazonsocial")
    private String solicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial;

    @JsonProperty("pctractivo")
    private Boolean solicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo;

    @JsonProperty("p_contratipopersona")
    private String solicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona;

    @JsonProperty("pt_p_atrctrfiniciocontrato")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato;

    @JsonProperty("pt_p_ctrtipocontrato")
    private Long solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad();
        checkSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo();
        checkSolicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad = solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance = solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad;
        this.solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad = solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad != null ? solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TSETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TSETVALORESDESDECONTRATO_SOLICITUDNOVEDADTSETVALORESDESDECONTRATOPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TSETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TSETVALORESDESDECONTRATO_SOLICITUDNOVEDADTSETVALORESDESDECONTRATOPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa(String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa = solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa(String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa = solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio(String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio = solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio(String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio = solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio;
    }

    @JsonIgnore
    public Boolean getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo(Boolean solicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo = solicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo;
    }

    private void checkSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TSETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TSETVALORESDESDECONTRATO_SOLICITUDNOVEDADTSETVALORESDESDECONTRATOPTPCTRESCOLECTIVO, SolicitudNovedadConstants.SERV_ALIAS_TSETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TSETVALORESDESDECONTRATO_SOLICITUDNOVEDADTSETVALORESDESDECONTRATOPTPCTRESCOLECTIVO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden(String solicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden = solicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre(String solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre = solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre(String solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre = solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido(String solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido = solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido(String solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido = solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido;
    }

    @JsonIgnore
    public EstadoContratoOid getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato(EstadoContratoOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato = solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance(EstadoContrato solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance = solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato;
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato = solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato != null ? solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato.getOid() : null;
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado(GrupoAsociadoOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado = solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance(GrupoAsociado solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance = solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado;
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado = solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado != null ? solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado.getOid() : null;
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad(PeriodicidadOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad = solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance(Periodicidad solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance = solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad;
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad = solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad != null ? solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad.getOid() : null;
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion(TipoIdentificacionOid solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion = solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance(TipoIdentificacion solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance = solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion;
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion = solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion != null ? solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion(String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion = solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion;
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial(String solicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial = solicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial;
    }

    @JsonIgnore
    public Boolean getSolicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo(Boolean solicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo = solicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo;
    }

    private void checkSolicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TSETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TSETVALORESDESDECONTRATO_SOLICITUDNOVEDADTSETVALORESDESDECONTRATOPCTRACTIVO, SolicitudNovedadConstants.SERV_ALIAS_TSETVALORESDESDECONTRATO, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TSETVALORESDESDECONTRATO_SOLICITUDNOVEDADTSETVALORESDESDECONTRATOPCTRACTIVO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona(String solicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona = solicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona;
    }

    @JsonIgnore
    public Date getSolicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato(Date solicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato = solicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato;
    }

    @JsonIgnore
    public Long getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato() {
        return this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato;
    }
    
    public void setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato(Long solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato) {
        this.solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato = solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato;
    }
}
