package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class TCREARDESDECORERequest {

    @JsonProperty("pt_p_agrsolicitud_oid")
    private SolicitudNovedadOid familiaNovedadTCREARDESDECOREptpagrSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad familiaNovedadTCREARDESDECOREptpagrSolicitudInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrtitnumidentificacion")
    private String familiaNovedadTCREARDESDECOREptpatrTitNumidentificacion;

    @JsonProperty("pt_p_atrtitprimernombre")
    private String familiaNovedadTCREARDESDECOREptpatrTitPrimerNombre;

    @JsonProperty("pt_p_atrtittienebeneficios")
    private Boolean familiaNovedadTCREARDESDECOREptpatrTitTieneBeneficios;

    @JsonProperty("pt_p_atrtitsegundonombre")
    private String familiaNovedadTCREARDESDECOREptpatrTitSegundoNombre;

    @JsonProperty("pt_p_atrtitprimerapellido")
    private String familiaNovedadTCREARDESDECOREptpatrTitPrimerApellido;

    @JsonProperty("pt_p_atrtitsegundoapellido")
    private String familiaNovedadTCREARDESDECOREptpatrTitSegundoApellido;

    @JsonProperty("pt_p_atrnumfamilia")
    private Long familiaNovedadTCREARDESDECOREptpatrNumFamilia;

    @JsonProperty("pt_p_atrtitrazonsocial")
    private String familiaNovedadTCREARDESDECOREptpatrTitRazonSocial;

    @JsonProperty("pt_p_atrfamactiva")
    private Boolean familiaNovedadTCREARDESDECOREptpatrFamActiva;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTCREARDESDECOREptpagrSolicitud();
        checkFamiliaNovedadTCREARDESDECOREptpatrTitNumidentificacion();
        checkFamiliaNovedadTCREARDESDECOREptpatrTitTieneBeneficios();
        checkFamiliaNovedadTCREARDESDECOREptpatrNumFamilia();
        checkFamiliaNovedadTCREARDESDECOREptpatrFamActiva();
    }

    @JsonIgnore
    public SolicitudNovedadOid getFamiliaNovedadTCREARDESDECOREptpagrSolicitud() {
        return this.familiaNovedadTCREARDESDECOREptpagrSolicitud;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpagrSolicitud(SolicitudNovedadOid familiaNovedadTCREARDESDECOREptpagrSolicitud) {
        this.familiaNovedadTCREARDESDECOREptpagrSolicitud = familiaNovedadTCREARDESDECOREptpagrSolicitud;
    }

    @JsonIgnore
    public SolicitudNovedad getFamiliaNovedadTCREARDESDECOREptpagrSolicitudInstance() {
        return this.familiaNovedadTCREARDESDECOREptpagrSolicitudInstance;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpagrSolicitudInstance(SolicitudNovedad familiaNovedadTCREARDESDECOREptpagrSolicitud) {
        this.familiaNovedadTCREARDESDECOREptpagrSolicitudInstance = familiaNovedadTCREARDESDECOREptpagrSolicitud;
        this.familiaNovedadTCREARDESDECOREptpagrSolicitud = familiaNovedadTCREARDESDECOREptpagrSolicitud != null ? familiaNovedadTCREARDESDECOREptpagrSolicitud.getOid() : null;
    }

    private void checkFamiliaNovedadTCREARDESDECOREptpagrSolicitud() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARDESDECOREptpagrSolicitudInstance() == null || this.getFamiliaNovedadTCREARDESDECOREptpagrSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPAGRSOLICITUD, FamiliaNovedadConstants.SERV_ALIAS_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPAGRSOLICITUD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacion() {
        return this.familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacion(TipoIdentificacionOid familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion) {
        this.familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion = familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance() {
        return this.familiaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance(TipoIdentificacion familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion) {
        this.familiaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance = familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion;
        this.familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion = familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion != null ? familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARDESDECOREptpatrTitNumidentificacion() {
        return this.familiaNovedadTCREARDESDECOREptpatrTitNumidentificacion;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrTitNumidentificacion(String familiaNovedadTCREARDESDECOREptpatrTitNumidentificacion) {
        this.familiaNovedadTCREARDESDECOREptpatrTitNumidentificacion = familiaNovedadTCREARDESDECOREptpatrTitNumidentificacion;
    }

    private void checkFamiliaNovedadTCREARDESDECOREptpatrTitNumidentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARDESDECOREptpatrTitNumidentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRTITNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRTITNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARDESDECOREptpatrTitPrimerNombre() {
        return this.familiaNovedadTCREARDESDECOREptpatrTitPrimerNombre;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrTitPrimerNombre(String familiaNovedadTCREARDESDECOREptpatrTitPrimerNombre) {
        this.familiaNovedadTCREARDESDECOREptpatrTitPrimerNombre = familiaNovedadTCREARDESDECOREptpatrTitPrimerNombre;
    }

    @JsonIgnore
    public Boolean getFamiliaNovedadTCREARDESDECOREptpatrTitTieneBeneficios() {
        return this.familiaNovedadTCREARDESDECOREptpatrTitTieneBeneficios;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrTitTieneBeneficios(Boolean familiaNovedadTCREARDESDECOREptpatrTitTieneBeneficios) {
        this.familiaNovedadTCREARDESDECOREptpatrTitTieneBeneficios = familiaNovedadTCREARDESDECOREptpatrTitTieneBeneficios;
    }

    private void checkFamiliaNovedadTCREARDESDECOREptpatrTitTieneBeneficios() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARDESDECOREptpatrTitTieneBeneficios() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRTITTIENEBENEFICIOS, FamiliaNovedadConstants.SERV_ALIAS_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRTITTIENEBENEFICIOS);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARDESDECOREptpatrTitSegundoNombre() {
        return this.familiaNovedadTCREARDESDECOREptpatrTitSegundoNombre;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrTitSegundoNombre(String familiaNovedadTCREARDESDECOREptpatrTitSegundoNombre) {
        this.familiaNovedadTCREARDESDECOREptpatrTitSegundoNombre = familiaNovedadTCREARDESDECOREptpatrTitSegundoNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARDESDECOREptpatrTitPrimerApellido() {
        return this.familiaNovedadTCREARDESDECOREptpatrTitPrimerApellido;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrTitPrimerApellido(String familiaNovedadTCREARDESDECOREptpatrTitPrimerApellido) {
        this.familiaNovedadTCREARDESDECOREptpatrTitPrimerApellido = familiaNovedadTCREARDESDECOREptpatrTitPrimerApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARDESDECOREptpatrTitSegundoApellido() {
        return this.familiaNovedadTCREARDESDECOREptpatrTitSegundoApellido;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrTitSegundoApellido(String familiaNovedadTCREARDESDECOREptpatrTitSegundoApellido) {
        this.familiaNovedadTCREARDESDECOREptpatrTitSegundoApellido = familiaNovedadTCREARDESDECOREptpatrTitSegundoApellido;
    }

    @JsonIgnore
    public Long getFamiliaNovedadTCREARDESDECOREptpatrNumFamilia() {
        return this.familiaNovedadTCREARDESDECOREptpatrNumFamilia;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrNumFamilia(Long familiaNovedadTCREARDESDECOREptpatrNumFamilia) {
        this.familiaNovedadTCREARDESDECOREptpatrNumFamilia = familiaNovedadTCREARDESDECOREptpatrNumFamilia;
    }

    private void checkFamiliaNovedadTCREARDESDECOREptpatrNumFamilia() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARDESDECOREptpatrNumFamilia() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRNUMFAMILIA, FamiliaNovedadConstants.SERV_ALIAS_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRNUMFAMILIA);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTCREARDESDECOREptpatrTitRazonSocial() {
        return this.familiaNovedadTCREARDESDECOREptpatrTitRazonSocial;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrTitRazonSocial(String familiaNovedadTCREARDESDECOREptpatrTitRazonSocial) {
        this.familiaNovedadTCREARDESDECOREptpatrTitRazonSocial = familiaNovedadTCREARDESDECOREptpatrTitRazonSocial;
    }

    @JsonIgnore
    public Boolean getFamiliaNovedadTCREARDESDECOREptpatrFamActiva() {
        return this.familiaNovedadTCREARDESDECOREptpatrFamActiva;
    }
    
    public void setFamiliaNovedadTCREARDESDECOREptpatrFamActiva(Boolean familiaNovedadTCREARDESDECOREptpatrFamActiva) {
        this.familiaNovedadTCREARDESDECOREptpatrFamActiva = familiaNovedadTCREARDESDECOREptpatrFamActiva;
    }

    private void checkFamiliaNovedadTCREARDESDECOREptpatrFamActiva() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTCREARDESDECOREptpatrFamActiva() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRFAMACTIVA, FamiliaNovedadConstants.SERV_ALIAS_TCREARDESDECORE, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TCREARDESDECORE_FAMILIANOVEDADTCREARDESDECOREPTPATRFAMACTIVA);
        }
    }
}
