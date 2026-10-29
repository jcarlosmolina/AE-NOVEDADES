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
import com.keralty.aenovedades.persistence.oid.CausalOid;
import com.keralty.aenovedades.persistence.oid.MotivoExcepcionSolNovOid;
import com.keralty.aenovedades.persistence.oid.NovedadOid;
import com.keralty.aenovedades.persistence.oid.PlanesOid;
import com.keralty.aenovedades.persistence.oid.ProductosOid;
import com.keralty.aenovedades.persistence.oid.ProteccionDatosOid;
import com.keralty.aenovedades.persistence.oid.TipoNovedadOid;
import com.keralty.aenovedades.persistence.Planes;
import com.keralty.aenovedades.persistence.Productos;
import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.persistence.TipoNovedad;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARINTRequest {

    @JsonProperty("pt_p_agrplan_oid")
    private PlanesOid solicitudNovedadTCREARINTptpagrPlan;
    
    @JsonIgnore
    private Planes solicitudNovedadTCREARINTptpagrPlanInstance;

    @JsonProperty("pt_p_agrnovedad_oid")
    private NovedadOid solicitudNovedadTCREARINTptpagrNovedad;
    
    @JsonIgnore
    private Novedad solicitudNovedadTCREARINTptpagrNovedadInstance;

    @JsonProperty("pt_p_agrcausal_oid")
    private CausalOid solicitudNovedadTCREARINTptpagrCausal;
    
    @JsonIgnore
    private Causal solicitudNovedadTCREARINTptpagrCausalInstance;

    @JsonProperty("pt_p_atrfechavigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTCREARINTptpatrFechaVigencia;

    @JsonProperty("pt_p_atrnumcontrato")
    private String solicitudNovedadTCREARINTptpatrNumContrato;

    @JsonProperty("ptproducto_oid")
    private ProductosOid solicitudNovedadTCREARINTptProducto;
    
    @JsonIgnore
    private Productos solicitudNovedadTCREARINTptProductoInstance;

    @JsonProperty("pttiponovedad_oid")
    private TipoNovedadOid solicitudNovedadTCREARINTptTipoNovedad;
    
    @JsonIgnore
    private TipoNovedad solicitudNovedadTCREARINTptTipoNovedadInstance;

    @JsonProperty("pt_p_agrprotecciondatos_oid")
    private ProteccionDatosOid solicitudNovedadTCREARINTptpagrProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudNovedadTCREARINTptpagrProteccionDatosInstance;

    @JsonProperty("pt_p_atrexcepcion")
    private Boolean solicitudNovedadTCREARINTptpatrExcepcion;

    @JsonProperty("p_agrmotivoexcepcion_oid")
    private MotivoExcepcionSolNovOid solicitudNovedadTCREARINTpagrMotivoExcepcion;
    
    @JsonIgnore
    private MotivoExcepcionSolNov solicitudNovedadTCREARINTpagrMotivoExcepcionInstance;

    @JsonProperty("p_atrfechainiexcepcion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTCREARINTpatrFechaIniExcepcion;

    @JsonProperty("p_atrfechafinexcepcion")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTCREARINTpatrFechaFinExcepcion;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCREARINTptpagrPlan();
        checkSolicitudNovedadTCREARINTptpagrNovedad();
        checkSolicitudNovedadTCREARINTptpatrFechaVigencia();
        checkSolicitudNovedadTCREARINTptpatrNumContrato();
        checkSolicitudNovedadTCREARINTptProducto();
        checkSolicitudNovedadTCREARINTptTipoNovedad();
        checkSolicitudNovedadTCREARINTptpagrProteccionDatos();
        checkSolicitudNovedadTCREARINTptpatrExcepcion();
    }

    @JsonIgnore
    public PlanesOid getSolicitudNovedadTCREARINTptpagrPlan() {
        return this.solicitudNovedadTCREARINTptpagrPlan;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrPlan(PlanesOid solicitudNovedadTCREARINTptpagrPlan) {
        this.solicitudNovedadTCREARINTptpagrPlan = solicitudNovedadTCREARINTptpagrPlan;
    }

    @JsonIgnore
    public Planes getSolicitudNovedadTCREARINTptpagrPlanInstance() {
        return this.solicitudNovedadTCREARINTptpagrPlanInstance;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrPlanInstance(Planes solicitudNovedadTCREARINTptpagrPlan) {
        this.solicitudNovedadTCREARINTptpagrPlanInstance = solicitudNovedadTCREARINTptpagrPlan;
        this.solicitudNovedadTCREARINTptpagrPlan = solicitudNovedadTCREARINTptpagrPlan != null ? solicitudNovedadTCREARINTptpagrPlan.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARINTptpagrPlan() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptpagrPlanInstance() == null || this.getSolicitudNovedadTCREARINTptpagrPlanInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPAGRPLAN, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPAGRPLAN);
        }
    }

    @JsonIgnore
    public NovedadOid getSolicitudNovedadTCREARINTptpagrNovedad() {
        return this.solicitudNovedadTCREARINTptpagrNovedad;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrNovedad(NovedadOid solicitudNovedadTCREARINTptpagrNovedad) {
        this.solicitudNovedadTCREARINTptpagrNovedad = solicitudNovedadTCREARINTptpagrNovedad;
    }

    @JsonIgnore
    public Novedad getSolicitudNovedadTCREARINTptpagrNovedadInstance() {
        return this.solicitudNovedadTCREARINTptpagrNovedadInstance;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrNovedadInstance(Novedad solicitudNovedadTCREARINTptpagrNovedad) {
        this.solicitudNovedadTCREARINTptpagrNovedadInstance = solicitudNovedadTCREARINTptpagrNovedad;
        this.solicitudNovedadTCREARINTptpagrNovedad = solicitudNovedadTCREARINTptpagrNovedad != null ? solicitudNovedadTCREARINTptpagrNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARINTptpagrNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptpagrNovedadInstance() == null || this.getSolicitudNovedadTCREARINTptpagrNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPAGRNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPAGRNOVEDAD);
        }
    }

    @JsonIgnore
    public CausalOid getSolicitudNovedadTCREARINTptpagrCausal() {
        return this.solicitudNovedadTCREARINTptpagrCausal;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrCausal(CausalOid solicitudNovedadTCREARINTptpagrCausal) {
        this.solicitudNovedadTCREARINTptpagrCausal = solicitudNovedadTCREARINTptpagrCausal;
    }

    @JsonIgnore
    public Causal getSolicitudNovedadTCREARINTptpagrCausalInstance() {
        return this.solicitudNovedadTCREARINTptpagrCausalInstance;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrCausalInstance(Causal solicitudNovedadTCREARINTptpagrCausal) {
        this.solicitudNovedadTCREARINTptpagrCausalInstance = solicitudNovedadTCREARINTptpagrCausal;
        this.solicitudNovedadTCREARINTptpagrCausal = solicitudNovedadTCREARINTptpagrCausal != null ? solicitudNovedadTCREARINTptpagrCausal.getOid() : null;
    }

    @JsonIgnore
    public Date getSolicitudNovedadTCREARINTptpatrFechaVigencia() {
        return this.solicitudNovedadTCREARINTptpatrFechaVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTCREARINTptpatrFechaVigencia(Date solicitudNovedadTCREARINTptpatrFechaVigencia) {
        this.solicitudNovedadTCREARINTptpatrFechaVigencia = solicitudNovedadTCREARINTptpatrFechaVigencia;
    }

    private void checkSolicitudNovedadTCREARINTptpatrFechaVigencia() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptpatrFechaVigencia() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPATRFECHAVIGENCIA, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPATRFECHAVIGENCIA);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREARINTptpatrNumContrato() {
        return this.solicitudNovedadTCREARINTptpatrNumContrato;
    }
    
    public void setSolicitudNovedadTCREARINTptpatrNumContrato(String solicitudNovedadTCREARINTptpatrNumContrato) {
        this.solicitudNovedadTCREARINTptpatrNumContrato = solicitudNovedadTCREARINTptpatrNumContrato;
    }

    private void checkSolicitudNovedadTCREARINTptpatrNumContrato() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptpatrNumContrato() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPATRNUMCONTRATO, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPATRNUMCONTRATO);
        }
    }

    @JsonIgnore
    public ProductosOid getSolicitudNovedadTCREARINTptProducto() {
        return this.solicitudNovedadTCREARINTptProducto;
    }
    
    public void setSolicitudNovedadTCREARINTptProducto(ProductosOid solicitudNovedadTCREARINTptProducto) {
        this.solicitudNovedadTCREARINTptProducto = solicitudNovedadTCREARINTptProducto;
    }

    @JsonIgnore
    public Productos getSolicitudNovedadTCREARINTptProductoInstance() {
        return this.solicitudNovedadTCREARINTptProductoInstance;
    }
    
    public void setSolicitudNovedadTCREARINTptProductoInstance(Productos solicitudNovedadTCREARINTptProducto) {
        this.solicitudNovedadTCREARINTptProductoInstance = solicitudNovedadTCREARINTptProducto;
        this.solicitudNovedadTCREARINTptProducto = solicitudNovedadTCREARINTptProducto != null ? solicitudNovedadTCREARINTptProducto.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARINTptProducto() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptProductoInstance() == null || this.getSolicitudNovedadTCREARINTptProductoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPRODUCTO, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPRODUCTO);
        }
    }

    @JsonIgnore
    public TipoNovedadOid getSolicitudNovedadTCREARINTptTipoNovedad() {
        return this.solicitudNovedadTCREARINTptTipoNovedad;
    }
    
    public void setSolicitudNovedadTCREARINTptTipoNovedad(TipoNovedadOid solicitudNovedadTCREARINTptTipoNovedad) {
        this.solicitudNovedadTCREARINTptTipoNovedad = solicitudNovedadTCREARINTptTipoNovedad;
    }

    @JsonIgnore
    public TipoNovedad getSolicitudNovedadTCREARINTptTipoNovedadInstance() {
        return this.solicitudNovedadTCREARINTptTipoNovedadInstance;
    }
    
    public void setSolicitudNovedadTCREARINTptTipoNovedadInstance(TipoNovedad solicitudNovedadTCREARINTptTipoNovedad) {
        this.solicitudNovedadTCREARINTptTipoNovedadInstance = solicitudNovedadTCREARINTptTipoNovedad;
        this.solicitudNovedadTCREARINTptTipoNovedad = solicitudNovedadTCREARINTptTipoNovedad != null ? solicitudNovedadTCREARINTptTipoNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARINTptTipoNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptTipoNovedadInstance() == null || this.getSolicitudNovedadTCREARINTptTipoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTTIPONOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTTIPONOVEDAD);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudNovedadTCREARINTptpagrProteccionDatos() {
        return this.solicitudNovedadTCREARINTptpagrProteccionDatos;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrProteccionDatos(ProteccionDatosOid solicitudNovedadTCREARINTptpagrProteccionDatos) {
        this.solicitudNovedadTCREARINTptpagrProteccionDatos = solicitudNovedadTCREARINTptpagrProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudNovedadTCREARINTptpagrProteccionDatosInstance() {
        return this.solicitudNovedadTCREARINTptpagrProteccionDatosInstance;
    }
    
    public void setSolicitudNovedadTCREARINTptpagrProteccionDatosInstance(ProteccionDatos solicitudNovedadTCREARINTptpagrProteccionDatos) {
        this.solicitudNovedadTCREARINTptpagrProteccionDatosInstance = solicitudNovedadTCREARINTptpagrProteccionDatos;
        this.solicitudNovedadTCREARINTptpagrProteccionDatos = solicitudNovedadTCREARINTptpagrProteccionDatos != null ? solicitudNovedadTCREARINTptpagrProteccionDatos.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARINTptpagrProteccionDatos() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptpagrProteccionDatosInstance() == null || this.getSolicitudNovedadTCREARINTptpagrProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPAGRPROTECCIONDATOS, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPAGRPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudNovedadTCREARINTptpatrExcepcion() {
        return this.solicitudNovedadTCREARINTptpatrExcepcion;
    }
    
    public void setSolicitudNovedadTCREARINTptpatrExcepcion(Boolean solicitudNovedadTCREARINTptpatrExcepcion) {
        this.solicitudNovedadTCREARINTptpatrExcepcion = solicitudNovedadTCREARINTptpatrExcepcion;
    }

    private void checkSolicitudNovedadTCREARINTptpatrExcepcion() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARINTptpatrExcepcion() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREARINT, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPATREXCEPCION, SolicitudNovedadConstants.SERV_ALIAS_TCREARINT, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREARINT_SOLICITUDNOVEDADTCREARINTPTPATREXCEPCION);
        }
    }

    @JsonIgnore
    public MotivoExcepcionSolNovOid getSolicitudNovedadTCREARINTpagrMotivoExcepcion() {
        return this.solicitudNovedadTCREARINTpagrMotivoExcepcion;
    }
    
    public void setSolicitudNovedadTCREARINTpagrMotivoExcepcion(MotivoExcepcionSolNovOid solicitudNovedadTCREARINTpagrMotivoExcepcion) {
        this.solicitudNovedadTCREARINTpagrMotivoExcepcion = solicitudNovedadTCREARINTpagrMotivoExcepcion;
    }

    @JsonIgnore
    public MotivoExcepcionSolNov getSolicitudNovedadTCREARINTpagrMotivoExcepcionInstance() {
        return this.solicitudNovedadTCREARINTpagrMotivoExcepcionInstance;
    }
    
    public void setSolicitudNovedadTCREARINTpagrMotivoExcepcionInstance(MotivoExcepcionSolNov solicitudNovedadTCREARINTpagrMotivoExcepcion) {
        this.solicitudNovedadTCREARINTpagrMotivoExcepcionInstance = solicitudNovedadTCREARINTpagrMotivoExcepcion;
        this.solicitudNovedadTCREARINTpagrMotivoExcepcion = solicitudNovedadTCREARINTpagrMotivoExcepcion != null ? solicitudNovedadTCREARINTpagrMotivoExcepcion.getOid() : null;
    }

    @JsonIgnore
    public Date getSolicitudNovedadTCREARINTpatrFechaIniExcepcion() {
        return this.solicitudNovedadTCREARINTpatrFechaIniExcepcion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTCREARINTpatrFechaIniExcepcion(Date solicitudNovedadTCREARINTpatrFechaIniExcepcion) {
        this.solicitudNovedadTCREARINTpatrFechaIniExcepcion = solicitudNovedadTCREARINTpatrFechaIniExcepcion;
    }

    @JsonIgnore
    public Date getSolicitudNovedadTCREARINTpatrFechaFinExcepcion() {
        return this.solicitudNovedadTCREARINTpatrFechaFinExcepcion;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTCREARINTpatrFechaFinExcepcion(Date solicitudNovedadTCREARINTpatrFechaFinExcepcion) {
        this.solicitudNovedadTCREARINTpatrFechaFinExcepcion = solicitudNovedadTCREARINTpatrFechaFinExcepcion;
    }
}
