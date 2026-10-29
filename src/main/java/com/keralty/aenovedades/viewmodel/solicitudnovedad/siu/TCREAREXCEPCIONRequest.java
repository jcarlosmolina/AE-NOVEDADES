package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.Causal;
import com.keralty.aenovedades.persistence.MotivoExcepcionSolNov;
import com.keralty.aenovedades.persistence.Novedad;
import com.keralty.aenovedades.persistence.oid.ProteccionDatosOid;
import com.keralty.aenovedades.persistence.Planes;
import com.keralty.aenovedades.persistence.Productos;
import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.persistence.TipoNovedad;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREAREXCEPCIONRequest {

    @JsonProperty("pt_p_agrplan_json")
    private String solicitudNovedadTCREAREXCEPCIONptpagrPlan;
    
    @JsonIgnore
    private Planes solicitudNovedadTCREAREXCEPCIONptpagrPlanInstance;

    @JsonProperty("pt_p_agrnovedad_json")
    private String solicitudNovedadTCREAREXCEPCIONptpagrNovedad;
    
    @JsonIgnore
    private Novedad solicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance;

    @JsonProperty("pt_p_agrcausal_json")
    private String solicitudNovedadTCREAREXCEPCIONptpagrCausal;
    
    @JsonIgnore
    private Causal solicitudNovedadTCREAREXCEPCIONptpagrCausalInstance;

    @JsonProperty("pt_p_atrfechavigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia;

    @JsonProperty("pt_p_atrnumcontrato")
    private String solicitudNovedadTCREAREXCEPCIONptpatrNumContrato;

    @JsonProperty("ptproducto_json")
    private String solicitudNovedadTCREAREXCEPCIONptProducto;
    
    @JsonIgnore
    private Productos solicitudNovedadTCREAREXCEPCIONptProductoInstance;

    @JsonProperty("pttiponovedad_json")
    private String solicitudNovedadTCREAREXCEPCIONptTipoNovedad;
    
    @JsonIgnore
    private TipoNovedad solicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance;

    @JsonProperty("pt_p_agrprotecciondatos_oid")
    private ProteccionDatosOid solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance;

    @JsonProperty("p_agrmotivoexcepcion_json")
    private String solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion;
    
    @JsonIgnore
    private MotivoExcepcionSolNov solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance;

    @JsonProperty("p_atrfechainiexcepcion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion;

    @JsonProperty("p_atrfechafinexcepcion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCREAREXCEPCIONptpagrPlan();
        checkSolicitudNovedadTCREAREXCEPCIONptpagrNovedad();
        checkSolicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia();
        checkSolicitudNovedadTCREAREXCEPCIONptpatrNumContrato();
        checkSolicitudNovedadTCREAREXCEPCIONptProducto();
        checkSolicitudNovedadTCREAREXCEPCIONptTipoNovedad();
        checkSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos();
        checkSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion();
        checkSolicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion();
        checkSolicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion();
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREAREXCEPCIONptpagrPlan() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrPlan;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrPlan(String solicitudNovedadTCREAREXCEPCIONptpagrPlan) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrPlan = solicitudNovedadTCREAREXCEPCIONptpagrPlan;
    }

    @JsonIgnore
    public Planes getSolicitudNovedadTCREAREXCEPCIONptpagrPlanInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrPlanInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrPlanInstance(Planes solicitudNovedadTCREAREXCEPCIONptpagrPlan) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrPlanInstance = solicitudNovedadTCREAREXCEPCIONptpagrPlan;
        this.solicitudNovedadTCREAREXCEPCIONptpagrPlan = solicitudNovedadTCREAREXCEPCIONptpagrPlan != null ? solicitudNovedadTCREAREXCEPCIONptpagrPlan.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONptpagrPlan() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONptpagrPlanInstance() == null || this.getSolicitudNovedadTCREAREXCEPCIONptpagrPlanInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPAGRPLAN, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPAGRPLAN);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREAREXCEPCIONptpagrNovedad() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrNovedad;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrNovedad(String solicitudNovedadTCREAREXCEPCIONptpagrNovedad) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrNovedad = solicitudNovedadTCREAREXCEPCIONptpagrNovedad;
    }

    @JsonIgnore
    public Novedad getSolicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance(Novedad solicitudNovedadTCREAREXCEPCIONptpagrNovedad) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance = solicitudNovedadTCREAREXCEPCIONptpagrNovedad;
        this.solicitudNovedadTCREAREXCEPCIONptpagrNovedad = solicitudNovedadTCREAREXCEPCIONptpagrNovedad != null ? solicitudNovedadTCREAREXCEPCIONptpagrNovedad.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONptpagrNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance() == null || this.getSolicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPAGRNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPAGRNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREAREXCEPCIONptpagrCausal() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrCausal;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrCausal(String solicitudNovedadTCREAREXCEPCIONptpagrCausal) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrCausal = solicitudNovedadTCREAREXCEPCIONptpagrCausal;
    }

    @JsonIgnore
    public Causal getSolicitudNovedadTCREAREXCEPCIONptpagrCausalInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrCausalInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrCausalInstance(Causal solicitudNovedadTCREAREXCEPCIONptpagrCausal) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrCausalInstance = solicitudNovedadTCREAREXCEPCIONptpagrCausal;
        this.solicitudNovedadTCREAREXCEPCIONptpagrCausal = solicitudNovedadTCREAREXCEPCIONptpagrCausal != null ? solicitudNovedadTCREAREXCEPCIONptpagrCausal.getOid().toJson() : "";
    }

    @JsonIgnore
    public Date getSolicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia() {
        return this.solicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia(Date solicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia) {
        this.solicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia = solicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia;
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPATRFECHAVIGENCIA, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPATRFECHAVIGENCIA);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREAREXCEPCIONptpatrNumContrato() {
        return this.solicitudNovedadTCREAREXCEPCIONptpatrNumContrato;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpatrNumContrato(String solicitudNovedadTCREAREXCEPCIONptpatrNumContrato) {
        this.solicitudNovedadTCREAREXCEPCIONptpatrNumContrato = solicitudNovedadTCREAREXCEPCIONptpatrNumContrato;
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONptpatrNumContrato() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONptpatrNumContrato() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPATRNUMCONTRATO, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPATRNUMCONTRATO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREAREXCEPCIONptProducto() {
        return this.solicitudNovedadTCREAREXCEPCIONptProducto;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptProducto(String solicitudNovedadTCREAREXCEPCIONptProducto) {
        this.solicitudNovedadTCREAREXCEPCIONptProducto = solicitudNovedadTCREAREXCEPCIONptProducto;
    }

    @JsonIgnore
    public Productos getSolicitudNovedadTCREAREXCEPCIONptProductoInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONptProductoInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptProductoInstance(Productos solicitudNovedadTCREAREXCEPCIONptProducto) {
        this.solicitudNovedadTCREAREXCEPCIONptProductoInstance = solicitudNovedadTCREAREXCEPCIONptProducto;
        this.solicitudNovedadTCREAREXCEPCIONptProducto = solicitudNovedadTCREAREXCEPCIONptProducto != null ? solicitudNovedadTCREAREXCEPCIONptProducto.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONptProducto() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONptProductoInstance() == null || this.getSolicitudNovedadTCREAREXCEPCIONptProductoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPRODUCTO, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPRODUCTO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREAREXCEPCIONptTipoNovedad() {
        return this.solicitudNovedadTCREAREXCEPCIONptTipoNovedad;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptTipoNovedad(String solicitudNovedadTCREAREXCEPCIONptTipoNovedad) {
        this.solicitudNovedadTCREAREXCEPCIONptTipoNovedad = solicitudNovedadTCREAREXCEPCIONptTipoNovedad;
    }

    @JsonIgnore
    public TipoNovedad getSolicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance(TipoNovedad solicitudNovedadTCREAREXCEPCIONptTipoNovedad) {
        this.solicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance = solicitudNovedadTCREAREXCEPCIONptTipoNovedad;
        this.solicitudNovedadTCREAREXCEPCIONptTipoNovedad = solicitudNovedadTCREAREXCEPCIONptTipoNovedad != null ? solicitudNovedadTCREAREXCEPCIONptTipoNovedad.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONptTipoNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance() == null || this.getSolicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTTIPONOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTTIPONOVEDAD);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos(ProteccionDatosOid solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos = solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance(ProteccionDatos solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos) {
        this.solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance = solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos;
        this.solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos = solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos != null ? solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos.getOid() : null;
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance() == null || this.getSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPAGRPROTECCIONDATOS, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPAGRPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion() {
        return this.solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion(String solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion) {
        this.solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion = solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion;
    }

    @JsonIgnore
    public MotivoExcepcionSolNov getSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance() {
        return this.solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance;
    }
    
    public void setSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance(MotivoExcepcionSolNov solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion) {
        this.solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance = solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion;
        this.solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion = solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion != null ? solicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance() == null || this.getSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPAGRMOTIVOEXCEPCION, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPAGRMOTIVOEXCEPCION);
        }
    }

    @JsonIgnore
    public Date getSolicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion() {
        return this.solicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion(Date solicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion) {
        this.solicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion = solicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion;
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONpatrFechaIniExcepcion() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPATRFECHAINIEXCEPCION, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPATRFECHAINIEXCEPCION);
        }
    }

    @JsonIgnore
    public Date getSolicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion() {
        return this.solicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion(Date solicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion) {
        this.solicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion = solicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion;
    }

    private void checkSolicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREAREXCEPCIONpatrFechaFinExcepcion() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPATRFECHAFINEXCEPCION, SolicitudNovedadConstants.SERV_ALIAS_TCREAREXCEPCION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPATRFECHAFINEXCEPCION);
        }
    }
}
