package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.Causal;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.MotivoExcepcionSolNov;
import com.keralty.aenovedades.persistence.Novedad;
import com.keralty.aenovedades.persistence.oid.CausalOid;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.FuncionarioOid;
import com.keralty.aenovedades.persistence.oid.GrupoAsociadoOid;
import com.keralty.aenovedades.persistence.oid.MotivoExcepcionSolNovOid;
import com.keralty.aenovedades.persistence.oid.NovedadOid;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.PlanesOid;
import com.keralty.aenovedades.persistence.oid.ProteccionDatosOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.Planes;
import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class CrearRequest {

    @JsonProperty("p_agrplant_oid")
    private PlanesOid solicitudNovedadcrearpagrPlanT;
    
    @JsonIgnore
    private Planes solicitudNovedadcrearpagrPlanTInstance;

    @JsonProperty("p_agrnovedad_oid")
    private NovedadOid solicitudNovedadcrearpagrNovedad;
    
    @JsonIgnore
    private Novedad solicitudNovedadcrearpagrNovedadInstance;

    @JsonProperty("p_agrcausal_oid")
    private CausalOid solicitudNovedadcrearpagrCausal;
    
    @JsonIgnore
    private Causal solicitudNovedadcrearpagrCausalInstance;

    @JsonProperty("p_agrprotecciondatos_oid")
    private ProteccionDatosOid solicitudNovedadcrearpagrProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudNovedadcrearpagrProteccionDatosInstance;

    @JsonProperty("p_agrtipoidentcontratante_oid")
    private TipoIdentificacionOid solicitudNovedadcrearpagrTipoIdentContratante;
    
    @JsonIgnore
    private TipoIdentificacion solicitudNovedadcrearpagrTipoIdentContratanteInstance;

    @JsonProperty("p_agrestadocontrato_oid")
    private EstadoContratoOid solicitudNovedadcrearpagrEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato solicitudNovedadcrearpagrEstadoContratoInstance;

    @JsonProperty("p_agrgrupoasociado_oid")
    private GrupoAsociadoOid solicitudNovedadcrearpagrGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudNovedadcrearpagrGrupoAsociadoInstance;

    @JsonProperty("p_agrperiodicidad_oid")
    private PeriodicidadOid solicitudNovedadcrearpagrPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadcrearpagrPeriodicidadInstance;

    @JsonProperty("p_agragente_oid")
    private FuncionarioOid solicitudNovedadcrearpagrAgente;
    
    @JsonIgnore
    private Funcionario solicitudNovedadcrearpagrAgenteInstance;

    @JsonProperty("p_agrperiodicidadnueva_oid")
    private PeriodicidadOid solicitudNovedadcrearpagrPeriodicidadNueva;
    
    @JsonIgnore
    private Periodicidad solicitudNovedadcrearpagrPeriodicidadNuevaInstance;

    @JsonProperty("p_agrmotivoexcepcion_oid")
    private MotivoExcepcionSolNovOid solicitudNovedadcrearpagrMotivoExcepcion;
    
    @JsonIgnore
    private MotivoExcepcionSolNov solicitudNovedadcrearpagrMotivoExcepcionInstance;

    @JsonProperty("p_agrusrafiliacion_oid")
    private FuncionarioOid solicitudNovedadcrearpagrUsrAfiliacion;
    
    @JsonIgnore
    private Funcionario solicitudNovedadcrearpagrUsrAfiliacionInstance;

    @JsonProperty("p_agrfirma_oid")
    private FirmaOid solicitudNovedadcrearpagrFirma;
    
    @JsonIgnore
    private Firma solicitudNovedadcrearpagrFirmaInstance;

    @JsonProperty("p_atrfechavigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadcrearpatrFechaVigencia;

    @JsonProperty("p_atrnumcontrato")
    private String solicitudNovedadcrearpatrNumContrato;

    @JsonProperty("p_atrexcepcion")
    private Boolean solicitudNovedadcrearpatrExcepcion;

    @JsonProperty("p_atrfechainiexcepcion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadcrearpatrFechaIniExcepcion;

    @JsonProperty("p_atrfechafinexcepcion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadcrearpatrFechaFinExcepcion;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadcrearpagrPlanT();
        checkSolicitudNovedadcrearpagrNovedad();
        checkSolicitudNovedadcrearpagrAgente();
        checkSolicitudNovedadcrearpatrFechaVigencia();
        checkSolicitudNovedadcrearpatrNumContrato();
        checkSolicitudNovedadcrearpatrExcepcion();
    }

    @JsonIgnore
    public PlanesOid getSolicitudNovedadcrearpagrPlanT() {
        return this.solicitudNovedadcrearpagrPlanT;
    }
    
    public void setSolicitudNovedadcrearpagrPlanT(PlanesOid solicitudNovedadcrearpagrPlanT) {
        this.solicitudNovedadcrearpagrPlanT = solicitudNovedadcrearpagrPlanT;
    }

    @JsonIgnore
    public Planes getSolicitudNovedadcrearpagrPlanTInstance() {
        return this.solicitudNovedadcrearpagrPlanTInstance;
    }
    
    public void setSolicitudNovedadcrearpagrPlanTInstance(Planes solicitudNovedadcrearpagrPlanT) {
        this.solicitudNovedadcrearpagrPlanTInstance = solicitudNovedadcrearpagrPlanT;
        this.solicitudNovedadcrearpagrPlanT = solicitudNovedadcrearpagrPlanT != null ? solicitudNovedadcrearpagrPlanT.getOid() : null;
    }

    private void checkSolicitudNovedadcrearpagrPlanT() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcrearpagrPlanTInstance() == null || this.getSolicitudNovedadcrearpagrPlanTInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CREAR_SOLICITUDNOVEDADCREARPAGRPLANT, SolicitudNovedadConstants.SERV_ALIAS_CREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CREAR_SOLICITUDNOVEDADCREARPAGRPLANT);
        }
    }

    @JsonIgnore
    public NovedadOid getSolicitudNovedadcrearpagrNovedad() {
        return this.solicitudNovedadcrearpagrNovedad;
    }
    
    public void setSolicitudNovedadcrearpagrNovedad(NovedadOid solicitudNovedadcrearpagrNovedad) {
        this.solicitudNovedadcrearpagrNovedad = solicitudNovedadcrearpagrNovedad;
    }

    @JsonIgnore
    public Novedad getSolicitudNovedadcrearpagrNovedadInstance() {
        return this.solicitudNovedadcrearpagrNovedadInstance;
    }
    
    public void setSolicitudNovedadcrearpagrNovedadInstance(Novedad solicitudNovedadcrearpagrNovedad) {
        this.solicitudNovedadcrearpagrNovedadInstance = solicitudNovedadcrearpagrNovedad;
        this.solicitudNovedadcrearpagrNovedad = solicitudNovedadcrearpagrNovedad != null ? solicitudNovedadcrearpagrNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadcrearpagrNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcrearpagrNovedadInstance() == null || this.getSolicitudNovedadcrearpagrNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CREAR_SOLICITUDNOVEDADCREARPAGRNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_CREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CREAR_SOLICITUDNOVEDADCREARPAGRNOVEDAD);
        }
    }

    @JsonIgnore
    public CausalOid getSolicitudNovedadcrearpagrCausal() {
        return this.solicitudNovedadcrearpagrCausal;
    }
    
    public void setSolicitudNovedadcrearpagrCausal(CausalOid solicitudNovedadcrearpagrCausal) {
        this.solicitudNovedadcrearpagrCausal = solicitudNovedadcrearpagrCausal;
    }

    @JsonIgnore
    public Causal getSolicitudNovedadcrearpagrCausalInstance() {
        return this.solicitudNovedadcrearpagrCausalInstance;
    }
    
    public void setSolicitudNovedadcrearpagrCausalInstance(Causal solicitudNovedadcrearpagrCausal) {
        this.solicitudNovedadcrearpagrCausalInstance = solicitudNovedadcrearpagrCausal;
        this.solicitudNovedadcrearpagrCausal = solicitudNovedadcrearpagrCausal != null ? solicitudNovedadcrearpagrCausal.getOid() : null;
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudNovedadcrearpagrProteccionDatos() {
        return this.solicitudNovedadcrearpagrProteccionDatos;
    }
    
    public void setSolicitudNovedadcrearpagrProteccionDatos(ProteccionDatosOid solicitudNovedadcrearpagrProteccionDatos) {
        this.solicitudNovedadcrearpagrProteccionDatos = solicitudNovedadcrearpagrProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudNovedadcrearpagrProteccionDatosInstance() {
        return this.solicitudNovedadcrearpagrProteccionDatosInstance;
    }
    
    public void setSolicitudNovedadcrearpagrProteccionDatosInstance(ProteccionDatos solicitudNovedadcrearpagrProteccionDatos) {
        this.solicitudNovedadcrearpagrProteccionDatosInstance = solicitudNovedadcrearpagrProteccionDatos;
        this.solicitudNovedadcrearpagrProteccionDatos = solicitudNovedadcrearpagrProteccionDatos != null ? solicitudNovedadcrearpagrProteccionDatos.getOid() : null;
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudNovedadcrearpagrTipoIdentContratante() {
        return this.solicitudNovedadcrearpagrTipoIdentContratante;
    }
    
    public void setSolicitudNovedadcrearpagrTipoIdentContratante(TipoIdentificacionOid solicitudNovedadcrearpagrTipoIdentContratante) {
        this.solicitudNovedadcrearpagrTipoIdentContratante = solicitudNovedadcrearpagrTipoIdentContratante;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudNovedadcrearpagrTipoIdentContratanteInstance() {
        return this.solicitudNovedadcrearpagrTipoIdentContratanteInstance;
    }
    
    public void setSolicitudNovedadcrearpagrTipoIdentContratanteInstance(TipoIdentificacion solicitudNovedadcrearpagrTipoIdentContratante) {
        this.solicitudNovedadcrearpagrTipoIdentContratanteInstance = solicitudNovedadcrearpagrTipoIdentContratante;
        this.solicitudNovedadcrearpagrTipoIdentContratante = solicitudNovedadcrearpagrTipoIdentContratante != null ? solicitudNovedadcrearpagrTipoIdentContratante.getOid() : null;
    }

    @JsonIgnore
    public EstadoContratoOid getSolicitudNovedadcrearpagrEstadoContrato() {
        return this.solicitudNovedadcrearpagrEstadoContrato;
    }
    
    public void setSolicitudNovedadcrearpagrEstadoContrato(EstadoContratoOid solicitudNovedadcrearpagrEstadoContrato) {
        this.solicitudNovedadcrearpagrEstadoContrato = solicitudNovedadcrearpagrEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getSolicitudNovedadcrearpagrEstadoContratoInstance() {
        return this.solicitudNovedadcrearpagrEstadoContratoInstance;
    }
    
    public void setSolicitudNovedadcrearpagrEstadoContratoInstance(EstadoContrato solicitudNovedadcrearpagrEstadoContrato) {
        this.solicitudNovedadcrearpagrEstadoContratoInstance = solicitudNovedadcrearpagrEstadoContrato;
        this.solicitudNovedadcrearpagrEstadoContrato = solicitudNovedadcrearpagrEstadoContrato != null ? solicitudNovedadcrearpagrEstadoContrato.getOid() : null;
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudNovedadcrearpagrGrupoAsociado() {
        return this.solicitudNovedadcrearpagrGrupoAsociado;
    }
    
    public void setSolicitudNovedadcrearpagrGrupoAsociado(GrupoAsociadoOid solicitudNovedadcrearpagrGrupoAsociado) {
        this.solicitudNovedadcrearpagrGrupoAsociado = solicitudNovedadcrearpagrGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudNovedadcrearpagrGrupoAsociadoInstance() {
        return this.solicitudNovedadcrearpagrGrupoAsociadoInstance;
    }
    
    public void setSolicitudNovedadcrearpagrGrupoAsociadoInstance(GrupoAsociado solicitudNovedadcrearpagrGrupoAsociado) {
        this.solicitudNovedadcrearpagrGrupoAsociadoInstance = solicitudNovedadcrearpagrGrupoAsociado;
        this.solicitudNovedadcrearpagrGrupoAsociado = solicitudNovedadcrearpagrGrupoAsociado != null ? solicitudNovedadcrearpagrGrupoAsociado.getOid() : null;
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudNovedadcrearpagrPeriodicidad() {
        return this.solicitudNovedadcrearpagrPeriodicidad;
    }
    
    public void setSolicitudNovedadcrearpagrPeriodicidad(PeriodicidadOid solicitudNovedadcrearpagrPeriodicidad) {
        this.solicitudNovedadcrearpagrPeriodicidad = solicitudNovedadcrearpagrPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadcrearpagrPeriodicidadInstance() {
        return this.solicitudNovedadcrearpagrPeriodicidadInstance;
    }
    
    public void setSolicitudNovedadcrearpagrPeriodicidadInstance(Periodicidad solicitudNovedadcrearpagrPeriodicidad) {
        this.solicitudNovedadcrearpagrPeriodicidadInstance = solicitudNovedadcrearpagrPeriodicidad;
        this.solicitudNovedadcrearpagrPeriodicidad = solicitudNovedadcrearpagrPeriodicidad != null ? solicitudNovedadcrearpagrPeriodicidad.getOid() : null;
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudNovedadcrearpagrAgente() {
        return this.solicitudNovedadcrearpagrAgente;
    }
    
    public void setSolicitudNovedadcrearpagrAgente(FuncionarioOid solicitudNovedadcrearpagrAgente) {
        this.solicitudNovedadcrearpagrAgente = solicitudNovedadcrearpagrAgente;
    }

    @JsonIgnore
    public Funcionario getSolicitudNovedadcrearpagrAgenteInstance() {
        return this.solicitudNovedadcrearpagrAgenteInstance;
    }
    
    public void setSolicitudNovedadcrearpagrAgenteInstance(Funcionario solicitudNovedadcrearpagrAgente) {
        this.solicitudNovedadcrearpagrAgenteInstance = solicitudNovedadcrearpagrAgente;
        this.solicitudNovedadcrearpagrAgente = solicitudNovedadcrearpagrAgente != null ? solicitudNovedadcrearpagrAgente.getOid() : null;
    }

    private void checkSolicitudNovedadcrearpagrAgente() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcrearpagrAgenteInstance() == null || this.getSolicitudNovedadcrearpagrAgenteInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CREAR_SOLICITUDNOVEDADCREARPAGRAGENTE, SolicitudNovedadConstants.SERV_ALIAS_CREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CREAR_SOLICITUDNOVEDADCREARPAGRAGENTE);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudNovedadcrearpagrPeriodicidadNueva() {
        return this.solicitudNovedadcrearpagrPeriodicidadNueva;
    }
    
    public void setSolicitudNovedadcrearpagrPeriodicidadNueva(PeriodicidadOid solicitudNovedadcrearpagrPeriodicidadNueva) {
        this.solicitudNovedadcrearpagrPeriodicidadNueva = solicitudNovedadcrearpagrPeriodicidadNueva;
    }

    @JsonIgnore
    public Periodicidad getSolicitudNovedadcrearpagrPeriodicidadNuevaInstance() {
        return this.solicitudNovedadcrearpagrPeriodicidadNuevaInstance;
    }
    
    public void setSolicitudNovedadcrearpagrPeriodicidadNuevaInstance(Periodicidad solicitudNovedadcrearpagrPeriodicidadNueva) {
        this.solicitudNovedadcrearpagrPeriodicidadNuevaInstance = solicitudNovedadcrearpagrPeriodicidadNueva;
        this.solicitudNovedadcrearpagrPeriodicidadNueva = solicitudNovedadcrearpagrPeriodicidadNueva != null ? solicitudNovedadcrearpagrPeriodicidadNueva.getOid() : null;
    }

    @JsonIgnore
    public MotivoExcepcionSolNovOid getSolicitudNovedadcrearpagrMotivoExcepcion() {
        return this.solicitudNovedadcrearpagrMotivoExcepcion;
    }
    
    public void setSolicitudNovedadcrearpagrMotivoExcepcion(MotivoExcepcionSolNovOid solicitudNovedadcrearpagrMotivoExcepcion) {
        this.solicitudNovedadcrearpagrMotivoExcepcion = solicitudNovedadcrearpagrMotivoExcepcion;
    }

    @JsonIgnore
    public MotivoExcepcionSolNov getSolicitudNovedadcrearpagrMotivoExcepcionInstance() {
        return this.solicitudNovedadcrearpagrMotivoExcepcionInstance;
    }
    
    public void setSolicitudNovedadcrearpagrMotivoExcepcionInstance(MotivoExcepcionSolNov solicitudNovedadcrearpagrMotivoExcepcion) {
        this.solicitudNovedadcrearpagrMotivoExcepcionInstance = solicitudNovedadcrearpagrMotivoExcepcion;
        this.solicitudNovedadcrearpagrMotivoExcepcion = solicitudNovedadcrearpagrMotivoExcepcion != null ? solicitudNovedadcrearpagrMotivoExcepcion.getOid() : null;
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudNovedadcrearpagrUsrAfiliacion() {
        return this.solicitudNovedadcrearpagrUsrAfiliacion;
    }
    
    public void setSolicitudNovedadcrearpagrUsrAfiliacion(FuncionarioOid solicitudNovedadcrearpagrUsrAfiliacion) {
        this.solicitudNovedadcrearpagrUsrAfiliacion = solicitudNovedadcrearpagrUsrAfiliacion;
    }

    @JsonIgnore
    public Funcionario getSolicitudNovedadcrearpagrUsrAfiliacionInstance() {
        return this.solicitudNovedadcrearpagrUsrAfiliacionInstance;
    }
    
    public void setSolicitudNovedadcrearpagrUsrAfiliacionInstance(Funcionario solicitudNovedadcrearpagrUsrAfiliacion) {
        this.solicitudNovedadcrearpagrUsrAfiliacionInstance = solicitudNovedadcrearpagrUsrAfiliacion;
        this.solicitudNovedadcrearpagrUsrAfiliacion = solicitudNovedadcrearpagrUsrAfiliacion != null ? solicitudNovedadcrearpagrUsrAfiliacion.getOid() : null;
    }

    @JsonIgnore
    public FirmaOid getSolicitudNovedadcrearpagrFirma() {
        return this.solicitudNovedadcrearpagrFirma;
    }
    
    public void setSolicitudNovedadcrearpagrFirma(FirmaOid solicitudNovedadcrearpagrFirma) {
        this.solicitudNovedadcrearpagrFirma = solicitudNovedadcrearpagrFirma;
    }

    @JsonIgnore
    public Firma getSolicitudNovedadcrearpagrFirmaInstance() {
        return this.solicitudNovedadcrearpagrFirmaInstance;
    }
    
    public void setSolicitudNovedadcrearpagrFirmaInstance(Firma solicitudNovedadcrearpagrFirma) {
        this.solicitudNovedadcrearpagrFirmaInstance = solicitudNovedadcrearpagrFirma;
        this.solicitudNovedadcrearpagrFirma = solicitudNovedadcrearpagrFirma != null ? solicitudNovedadcrearpagrFirma.getOid() : null;
    }

    @JsonIgnore
    public Date getSolicitudNovedadcrearpatrFechaVigencia() {
        return this.solicitudNovedadcrearpatrFechaVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadcrearpatrFechaVigencia(Date solicitudNovedadcrearpatrFechaVigencia) {
        this.solicitudNovedadcrearpatrFechaVigencia = solicitudNovedadcrearpatrFechaVigencia;
    }

    private void checkSolicitudNovedadcrearpatrFechaVigencia() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcrearpatrFechaVigencia() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CREAR_SOLICITUDNOVEDADCREARPATRFECHAVIGENCIA, SolicitudNovedadConstants.SERV_ALIAS_CREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CREAR_SOLICITUDNOVEDADCREARPATRFECHAVIGENCIA);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadcrearpatrNumContrato() {
        return this.solicitudNovedadcrearpatrNumContrato;
    }
    
    public void setSolicitudNovedadcrearpatrNumContrato(String solicitudNovedadcrearpatrNumContrato) {
        this.solicitudNovedadcrearpatrNumContrato = solicitudNovedadcrearpatrNumContrato;
    }

    private void checkSolicitudNovedadcrearpatrNumContrato() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcrearpatrNumContrato() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CREAR_SOLICITUDNOVEDADCREARPATRNUMCONTRATO, SolicitudNovedadConstants.SERV_ALIAS_CREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CREAR_SOLICITUDNOVEDADCREARPATRNUMCONTRATO);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudNovedadcrearpatrExcepcion() {
        return this.solicitudNovedadcrearpatrExcepcion;
    }
    
    public void setSolicitudNovedadcrearpatrExcepcion(Boolean solicitudNovedadcrearpatrExcepcion) {
        this.solicitudNovedadcrearpatrExcepcion = solicitudNovedadcrearpatrExcepcion;
    }

    private void checkSolicitudNovedadcrearpatrExcepcion() throws NotNullArgumentException {
        if(this.getSolicitudNovedadcrearpatrExcepcion() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_CREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_CREAR_SOLICITUDNOVEDADCREARPATREXCEPCION, SolicitudNovedadConstants.SERV_ALIAS_CREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_CREAR_SOLICITUDNOVEDADCREARPATREXCEPCION);
        }
    }

    @JsonIgnore
    public Date getSolicitudNovedadcrearpatrFechaIniExcepcion() {
        return this.solicitudNovedadcrearpatrFechaIniExcepcion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadcrearpatrFechaIniExcepcion(Date solicitudNovedadcrearpatrFechaIniExcepcion) {
        this.solicitudNovedadcrearpatrFechaIniExcepcion = solicitudNovedadcrearpatrFechaIniExcepcion;
    }

    @JsonIgnore
    public Date getSolicitudNovedadcrearpatrFechaFinExcepcion() {
        return this.solicitudNovedadcrearpatrFechaFinExcepcion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadcrearpatrFechaFinExcepcion(Date solicitudNovedadcrearpatrFechaFinExcepcion) {
        this.solicitudNovedadcrearpatrFechaFinExcepcion = solicitudNovedadcrearpatrFechaFinExcepcion;
    }
}
