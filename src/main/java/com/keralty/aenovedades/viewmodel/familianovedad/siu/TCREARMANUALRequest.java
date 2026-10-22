package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class TCREARMANUALRequest {

    @JsonProperty("pt_p_agrsolicitud_oid")
    private SolicitudNovedadOid familiaNovedadTCREARMANUALptpagrSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad familiaNovedadTCREARMANUALptpagrSolicitudInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_json")
    private String familiaNovedadTCREARMANUALptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadTCREARMANUALptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrtitnumidentificacion")
    private String familiaNovedadTCREARMANUALptpatrTitNumidentificacion;

    @JsonProperty("pt_p_atrtitprimernombre")
    private String familiaNovedadTCREARMANUALptpatrTitPrimerNombre;

    @JsonProperty("pt_p_atrtitsegundonombre")
    private String familiaNovedadTCREARMANUALptpatrTitSegundoNombre;

    @JsonProperty("pt_p_atrtitprimerapellido")
    private String familiaNovedadTCREARMANUALptpatrTitPrimerApellido;

    @JsonProperty("pt_p_atrtitsegundoapellido")
    private String familiaNovedadTCREARMANUALptpatrTitSegundoApellido;

    @JsonProperty("pt_p_atrnumfamilia")
    private Long familiaNovedadTCREARMANUALptpatrNumFamilia;

    @JsonProperty("pt_p_atrtitrazonsocial")
    private String familiaNovedadTCREARMANUALptpatrTitRazonSocial;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTCREARMANUALptpagrSolicitud();
        checkFamiliaNovedadTCREARMANUALptpatrTitNumidentificacion();
        checkFamiliaNovedadTCREARMANUALptpatrNumFamilia();
    }

    @JsonIgnore
    public SolicitudNovedadOid getFamiliaNovedadTCREARMANUALptpagrSolicitud() {
        return this.familiaNovedadTCREARMANUALptpagrSolicitud;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpagrSolicitud(SolicitudNovedadOid familiaNovedadTCREARMANUALptpagrSolicitud) {
        this.familiaNovedadTCREARMANUALptpagrSolicitud = familiaNovedadTCREARMANUALptpagrSolicitud;
    }

    @JsonIgnore
    public SolicitudNovedad getFamiliaNovedadTCREARMANUALptpagrSolicitudInstance() {
        return this.familiaNovedadTCREARMANUALptpagrSolicitudInstance;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpagrSolicitudInstance(SolicitudNovedad familiaNovedadTCREARMANUALptpagrSolicitud) {
        this.familiaNovedadTCREARMANUALptpagrSolicitudInstance = familiaNovedadTCREARMANUALptpagrSolicitud;
        this.familiaNovedadTCREARMANUALptpagrSolicitud = familiaNovedadTCREARMANUALptpagrSolicitud != null ? familiaNovedadTCREARMANUALptpagrSolicitud.getOid() : null;
    }

    private void checkFamiliaNovedadTCREARMANUALptpagrSolicitud() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARMANUALptpagrSolicitudInstance() == null || this.getFamiliaNovedadTCREARMANUALptpagrSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARMANUAL_FAMILIANOVEDADTCREARMANUALPTPAGRSOLICITUD, FamiliaNovedadConstants.SERV_ALIAS_TCREARMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARMANUAL_FAMILIANOVEDADTCREARMANUALPTPAGRSOLICITUD);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARMANUALptpagrTipoIdentificacion() {
        return this.familiaNovedadTCREARMANUALptpagrTipoIdentificacion;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpagrTipoIdentificacion(String familiaNovedadTCREARMANUALptpagrTipoIdentificacion) {
        this.familiaNovedadTCREARMANUALptpagrTipoIdentificacion = familiaNovedadTCREARMANUALptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadTCREARMANUALptpagrTipoIdentificacionInstance() {
        return this.familiaNovedadTCREARMANUALptpagrTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpagrTipoIdentificacionInstance(TipoIdentificacion familiaNovedadTCREARMANUALptpagrTipoIdentificacion) {
        this.familiaNovedadTCREARMANUALptpagrTipoIdentificacionInstance = familiaNovedadTCREARMANUALptpagrTipoIdentificacion;
        this.familiaNovedadTCREARMANUALptpagrTipoIdentificacion = familiaNovedadTCREARMANUALptpagrTipoIdentificacion != null ? familiaNovedadTCREARMANUALptpagrTipoIdentificacion.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARMANUALptpatrTitNumidentificacion() {
        return this.familiaNovedadTCREARMANUALptpatrTitNumidentificacion;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpatrTitNumidentificacion(String familiaNovedadTCREARMANUALptpatrTitNumidentificacion) {
        this.familiaNovedadTCREARMANUALptpatrTitNumidentificacion = familiaNovedadTCREARMANUALptpatrTitNumidentificacion;
    }

    private void checkFamiliaNovedadTCREARMANUALptpatrTitNumidentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARMANUALptpatrTitNumidentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARMANUAL_FAMILIANOVEDADTCREARMANUALPTPATRTITNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TCREARMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARMANUAL_FAMILIANOVEDADTCREARMANUALPTPATRTITNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARMANUALptpatrTitPrimerNombre() {
        return this.familiaNovedadTCREARMANUALptpatrTitPrimerNombre;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpatrTitPrimerNombre(String familiaNovedadTCREARMANUALptpatrTitPrimerNombre) {
        this.familiaNovedadTCREARMANUALptpatrTitPrimerNombre = familiaNovedadTCREARMANUALptpatrTitPrimerNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARMANUALptpatrTitSegundoNombre() {
        return this.familiaNovedadTCREARMANUALptpatrTitSegundoNombre;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpatrTitSegundoNombre(String familiaNovedadTCREARMANUALptpatrTitSegundoNombre) {
        this.familiaNovedadTCREARMANUALptpatrTitSegundoNombre = familiaNovedadTCREARMANUALptpatrTitSegundoNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARMANUALptpatrTitPrimerApellido() {
        return this.familiaNovedadTCREARMANUALptpatrTitPrimerApellido;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpatrTitPrimerApellido(String familiaNovedadTCREARMANUALptpatrTitPrimerApellido) {
        this.familiaNovedadTCREARMANUALptpatrTitPrimerApellido = familiaNovedadTCREARMANUALptpatrTitPrimerApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARMANUALptpatrTitSegundoApellido() {
        return this.familiaNovedadTCREARMANUALptpatrTitSegundoApellido;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpatrTitSegundoApellido(String familiaNovedadTCREARMANUALptpatrTitSegundoApellido) {
        this.familiaNovedadTCREARMANUALptpatrTitSegundoApellido = familiaNovedadTCREARMANUALptpatrTitSegundoApellido;
    }

    @JsonIgnore
    public Long getFamiliaNovedadTCREARMANUALptpatrNumFamilia() {
        return this.familiaNovedadTCREARMANUALptpatrNumFamilia;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpatrNumFamilia(Long familiaNovedadTCREARMANUALptpatrNumFamilia) {
        this.familiaNovedadTCREARMANUALptpatrNumFamilia = familiaNovedadTCREARMANUALptpatrNumFamilia;
    }

    private void checkFamiliaNovedadTCREARMANUALptpatrNumFamilia() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARMANUALptpatrNumFamilia() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARMANUAL_FAMILIANOVEDADTCREARMANUALPTPATRNUMFAMILIA, FamiliaNovedadConstants.SERV_ALIAS_TCREARMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARMANUAL_FAMILIANOVEDADTCREARMANUALPTPATRNUMFAMILIA);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARMANUALptpatrTitRazonSocial() {
        return this.familiaNovedadTCREARMANUALptpatrTitRazonSocial;
    }
    
    public void setFamiliaNovedadTCREARMANUALptpatrTitRazonSocial(String familiaNovedadTCREARMANUALptpatrTitRazonSocial) {
        this.familiaNovedadTCREARMANUALptpatrTitRazonSocial = familiaNovedadTCREARMANUALptpatrTitRazonSocial;
    }
}
