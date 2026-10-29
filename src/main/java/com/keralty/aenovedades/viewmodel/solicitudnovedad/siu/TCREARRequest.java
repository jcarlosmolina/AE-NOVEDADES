package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.persistence.Causal;
import com.keralty.aenovedades.persistence.Novedad;
import com.keralty.aenovedades.persistence.oid.ProteccionDatosOid;
import com.keralty.aenovedades.persistence.Planes;
import com.keralty.aenovedades.persistence.Productos;
import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.persistence.TipoNovedad;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aenovedades.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARRequest {

    @JsonProperty("pt_p_agrplan_json")
    private String solicitudNovedadTCREARptpagrPlan;
    
    @JsonIgnore
    private Planes solicitudNovedadTCREARptpagrPlanInstance;

    @JsonProperty("pt_p_agrnovedad_json")
    private String solicitudNovedadTCREARptpagrNovedad;
    
    @JsonIgnore
    private Novedad solicitudNovedadTCREARptpagrNovedadInstance;

    @JsonProperty("pt_p_agrcausal_json")
    private String solicitudNovedadTCREARptpagrCausal;
    
    @JsonIgnore
    private Causal solicitudNovedadTCREARptpagrCausalInstance;

    @JsonProperty("pt_p_atrfechavigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudNovedadTCREARptpatrFechaVigencia;

    @JsonProperty("pt_p_atrnumcontrato")
    private String solicitudNovedadTCREARptpatrNumContrato;

    @JsonProperty("ptproducto_json")
    private String solicitudNovedadTCREARptProducto;
    
    @JsonIgnore
    private Productos solicitudNovedadTCREARptProductoInstance;

    @JsonProperty("pttiponovedad_json")
    private String solicitudNovedadTCREARptTipoNovedad;
    
    @JsonIgnore
    private TipoNovedad solicitudNovedadTCREARptTipoNovedadInstance;

    @JsonProperty("pt_p_agrprotecciondatos_oid")
    private ProteccionDatosOid solicitudNovedadTCREARptpagrProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudNovedadTCREARptpagrProteccionDatosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTCREARptpagrPlan();
        checkSolicitudNovedadTCREARptpagrNovedad();
        checkSolicitudNovedadTCREARptpatrFechaVigencia();
        checkSolicitudNovedadTCREARptpatrNumContrato();
        checkSolicitudNovedadTCREARptProducto();
        checkSolicitudNovedadTCREARptTipoNovedad();
        checkSolicitudNovedadTCREARptpagrProteccionDatos();
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREARptpagrPlan() {
        return this.solicitudNovedadTCREARptpagrPlan;
    }
    
    public void setSolicitudNovedadTCREARptpagrPlan(String solicitudNovedadTCREARptpagrPlan) {
        this.solicitudNovedadTCREARptpagrPlan = solicitudNovedadTCREARptpagrPlan;
    }

    @JsonIgnore
    public Planes getSolicitudNovedadTCREARptpagrPlanInstance() {
        return this.solicitudNovedadTCREARptpagrPlanInstance;
    }
    
    public void setSolicitudNovedadTCREARptpagrPlanInstance(Planes solicitudNovedadTCREARptpagrPlan) {
        this.solicitudNovedadTCREARptpagrPlanInstance = solicitudNovedadTCREARptpagrPlan;
        this.solicitudNovedadTCREARptpagrPlan = solicitudNovedadTCREARptpagrPlan != null ? solicitudNovedadTCREARptpagrPlan.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREARptpagrPlan() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARptpagrPlanInstance() == null || this.getSolicitudNovedadTCREARptpagrPlanInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAR_SOLICITUDNOVEDADTCREARPTPAGRPLAN, SolicitudNovedadConstants.SERV_ALIAS_TCREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAR_SOLICITUDNOVEDADTCREARPTPAGRPLAN);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREARptpagrNovedad() {
        return this.solicitudNovedadTCREARptpagrNovedad;
    }
    
    public void setSolicitudNovedadTCREARptpagrNovedad(String solicitudNovedadTCREARptpagrNovedad) {
        this.solicitudNovedadTCREARptpagrNovedad = solicitudNovedadTCREARptpagrNovedad;
    }

    @JsonIgnore
    public Novedad getSolicitudNovedadTCREARptpagrNovedadInstance() {
        return this.solicitudNovedadTCREARptpagrNovedadInstance;
    }
    
    public void setSolicitudNovedadTCREARptpagrNovedadInstance(Novedad solicitudNovedadTCREARptpagrNovedad) {
        this.solicitudNovedadTCREARptpagrNovedadInstance = solicitudNovedadTCREARptpagrNovedad;
        this.solicitudNovedadTCREARptpagrNovedad = solicitudNovedadTCREARptpagrNovedad != null ? solicitudNovedadTCREARptpagrNovedad.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREARptpagrNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARptpagrNovedadInstance() == null || this.getSolicitudNovedadTCREARptpagrNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAR_SOLICITUDNOVEDADTCREARPTPAGRNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAR_SOLICITUDNOVEDADTCREARPTPAGRNOVEDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREARptpagrCausal() {
        return this.solicitudNovedadTCREARptpagrCausal;
    }
    
    public void setSolicitudNovedadTCREARptpagrCausal(String solicitudNovedadTCREARptpagrCausal) {
        this.solicitudNovedadTCREARptpagrCausal = solicitudNovedadTCREARptpagrCausal;
    }

    @JsonIgnore
    public Causal getSolicitudNovedadTCREARptpagrCausalInstance() {
        return this.solicitudNovedadTCREARptpagrCausalInstance;
    }
    
    public void setSolicitudNovedadTCREARptpagrCausalInstance(Causal solicitudNovedadTCREARptpagrCausal) {
        this.solicitudNovedadTCREARptpagrCausalInstance = solicitudNovedadTCREARptpagrCausal;
        this.solicitudNovedadTCREARptpagrCausal = solicitudNovedadTCREARptpagrCausal != null ? solicitudNovedadTCREARptpagrCausal.getOid().toJson() : "";
    }

    @JsonIgnore
    public Date getSolicitudNovedadTCREARptpatrFechaVigencia() {
        return this.solicitudNovedadTCREARptpatrFechaVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudNovedadTCREARptpatrFechaVigencia(Date solicitudNovedadTCREARptpatrFechaVigencia) {
        this.solicitudNovedadTCREARptpatrFechaVigencia = solicitudNovedadTCREARptpatrFechaVigencia;
    }

    private void checkSolicitudNovedadTCREARptpatrFechaVigencia() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARptpatrFechaVigencia() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAR_SOLICITUDNOVEDADTCREARPTPATRFECHAVIGENCIA, SolicitudNovedadConstants.SERV_ALIAS_TCREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAR_SOLICITUDNOVEDADTCREARPTPATRFECHAVIGENCIA);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREARptpatrNumContrato() {
        return this.solicitudNovedadTCREARptpatrNumContrato;
    }
    
    public void setSolicitudNovedadTCREARptpatrNumContrato(String solicitudNovedadTCREARptpatrNumContrato) {
        this.solicitudNovedadTCREARptpatrNumContrato = solicitudNovedadTCREARptpatrNumContrato;
    }

    private void checkSolicitudNovedadTCREARptpatrNumContrato() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARptpatrNumContrato() == null) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAR_SOLICITUDNOVEDADTCREARPTPATRNUMCONTRATO, SolicitudNovedadConstants.SERV_ALIAS_TCREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAR_SOLICITUDNOVEDADTCREARPTPATRNUMCONTRATO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREARptProducto() {
        return this.solicitudNovedadTCREARptProducto;
    }
    
    public void setSolicitudNovedadTCREARptProducto(String solicitudNovedadTCREARptProducto) {
        this.solicitudNovedadTCREARptProducto = solicitudNovedadTCREARptProducto;
    }

    @JsonIgnore
    public Productos getSolicitudNovedadTCREARptProductoInstance() {
        return this.solicitudNovedadTCREARptProductoInstance;
    }
    
    public void setSolicitudNovedadTCREARptProductoInstance(Productos solicitudNovedadTCREARptProducto) {
        this.solicitudNovedadTCREARptProductoInstance = solicitudNovedadTCREARptProducto;
        this.solicitudNovedadTCREARptProducto = solicitudNovedadTCREARptProducto != null ? solicitudNovedadTCREARptProducto.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREARptProducto() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARptProductoInstance() == null || this.getSolicitudNovedadTCREARptProductoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO, SolicitudNovedadConstants.SERV_ALIAS_TCREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO);
        }
    }

    @JsonIgnore
    public String getSolicitudNovedadTCREARptTipoNovedad() {
        return this.solicitudNovedadTCREARptTipoNovedad;
    }
    
    public void setSolicitudNovedadTCREARptTipoNovedad(String solicitudNovedadTCREARptTipoNovedad) {
        this.solicitudNovedadTCREARptTipoNovedad = solicitudNovedadTCREARptTipoNovedad;
    }

    @JsonIgnore
    public TipoNovedad getSolicitudNovedadTCREARptTipoNovedadInstance() {
        return this.solicitudNovedadTCREARptTipoNovedadInstance;
    }
    
    public void setSolicitudNovedadTCREARptTipoNovedadInstance(TipoNovedad solicitudNovedadTCREARptTipoNovedad) {
        this.solicitudNovedadTCREARptTipoNovedadInstance = solicitudNovedadTCREARptTipoNovedad;
        this.solicitudNovedadTCREARptTipoNovedad = solicitudNovedadTCREARptTipoNovedad != null ? solicitudNovedadTCREARptTipoNovedad.getOid().toJson() : "";
    }

    private void checkSolicitudNovedadTCREARptTipoNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARptTipoNovedadInstance() == null || this.getSolicitudNovedadTCREARptTipoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAR_SOLICITUDNOVEDADTCREARPTTIPONOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TCREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAR_SOLICITUDNOVEDADTCREARPTTIPONOVEDAD);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudNovedadTCREARptpagrProteccionDatos() {
        return this.solicitudNovedadTCREARptpagrProteccionDatos;
    }
    
    public void setSolicitudNovedadTCREARptpagrProteccionDatos(ProteccionDatosOid solicitudNovedadTCREARptpagrProteccionDatos) {
        this.solicitudNovedadTCREARptpagrProteccionDatos = solicitudNovedadTCREARptpagrProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudNovedadTCREARptpagrProteccionDatosInstance() {
        return this.solicitudNovedadTCREARptpagrProteccionDatosInstance;
    }
    
    public void setSolicitudNovedadTCREARptpagrProteccionDatosInstance(ProteccionDatos solicitudNovedadTCREARptpagrProteccionDatos) {
        this.solicitudNovedadTCREARptpagrProteccionDatosInstance = solicitudNovedadTCREARptpagrProteccionDatos;
        this.solicitudNovedadTCREARptpagrProteccionDatos = solicitudNovedadTCREARptpagrProteccionDatos != null ? solicitudNovedadTCREARptpagrProteccionDatos.getOid() : null;
    }

    private void checkSolicitudNovedadTCREARptpagrProteccionDatos() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTCREARptpagrProteccionDatosInstance() == null || this.getSolicitudNovedadTCREARptpagrProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TCREAR, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TCREAR_SOLICITUDNOVEDADTCREARPTPAGRPROTECCIONDATOS, SolicitudNovedadConstants.SERV_ALIAS_TCREAR, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TCREAR_SOLICITUDNOVEDADTCREARPTPAGRPROTECCIONDATOS);
        }
    }
}
