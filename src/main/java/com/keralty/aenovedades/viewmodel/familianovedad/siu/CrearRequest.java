package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class CrearRequest {

    @JsonProperty("p_agrsolicitud_oid")
    private SolicitudNovedadOid familiaNovedadcrearpagrSolicitud;
    
    @JsonIgnore
    private SolicitudNovedad familiaNovedadcrearpagrSolicitudInstance;

    @JsonProperty("p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid familiaNovedadcrearpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadcrearpagrTipoIdentificacionInstance;

    @JsonProperty("p_agrfirma_oid")
    private FirmaOid familiaNovedadcrearpagrFirma;
    
    @JsonIgnore
    private Firma familiaNovedadcrearpagrFirmaInstance;

    @JsonProperty("p_atrtitnumidentificacion")
    private String familiaNovedadcrearpatrTitNumidentificacion;

    @JsonProperty("p_atrtitprimernombre")
    private String familiaNovedadcrearpatrTitPrimerNombre;

    @JsonProperty("p_atrtittienebeneficios")
    private Boolean familiaNovedadcrearpatrTitTieneBeneficios;

    @JsonProperty("p_atrtitsegundonombre")
    private String familiaNovedadcrearpatrTitSegundoNombre;

    @JsonProperty("p_atrtitprimerapellido")
    private String familiaNovedadcrearpatrTitPrimerApellido;

    @JsonProperty("p_atrtitsegundoapellido")
    private String familiaNovedadcrearpatrTitSegundoApellido;

    @JsonProperty("p_atrnumfamilia")
    private Long familiaNovedadcrearpatrNumFamilia;

    @JsonProperty("p_atrtitrazonsocial")
    private String familiaNovedadcrearpatrTitRazonSocial;

    @JsonProperty("p_atrfamactiva")
    private Boolean familiaNovedadcrearpatrFamActiva;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadcrearpagrSolicitud();
        checkFamiliaNovedadcrearpatrTitNumidentificacion();
        checkFamiliaNovedadcrearpatrTitTieneBeneficios();
        checkFamiliaNovedadcrearpatrNumFamilia();
        checkFamiliaNovedadcrearpatrFamActiva();
    }

    @JsonIgnore
    public SolicitudNovedadOid getFamiliaNovedadcrearpagrSolicitud() {
        return this.familiaNovedadcrearpagrSolicitud;
    }
    
    public void setFamiliaNovedadcrearpagrSolicitud(SolicitudNovedadOid familiaNovedadcrearpagrSolicitud) {
        this.familiaNovedadcrearpagrSolicitud = familiaNovedadcrearpagrSolicitud;
    }

    @JsonIgnore
    public SolicitudNovedad getFamiliaNovedadcrearpagrSolicitudInstance() {
        return this.familiaNovedadcrearpagrSolicitudInstance;
    }
    
    public void setFamiliaNovedadcrearpagrSolicitudInstance(SolicitudNovedad familiaNovedadcrearpagrSolicitud) {
        this.familiaNovedadcrearpagrSolicitudInstance = familiaNovedadcrearpagrSolicitud;
        this.familiaNovedadcrearpagrSolicitud = familiaNovedadcrearpagrSolicitud != null ? familiaNovedadcrearpagrSolicitud.getOid() : null;
    }

    private void checkFamiliaNovedadcrearpagrSolicitud() throws NotNullArgumentException {
        if(this.getFamiliaNovedadcrearpagrSolicitudInstance() == null || this.getFamiliaNovedadcrearpagrSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_CREAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_CREAR_FAMILIANOVEDADCREARPAGRSOLICITUD, FamiliaNovedadConstants.SERV_ALIAS_CREAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_CREAR_FAMILIANOVEDADCREARPAGRSOLICITUD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getFamiliaNovedadcrearpagrTipoIdentificacion() {
        return this.familiaNovedadcrearpagrTipoIdentificacion;
    }
    
    public void setFamiliaNovedadcrearpagrTipoIdentificacion(TipoIdentificacionOid familiaNovedadcrearpagrTipoIdentificacion) {
        this.familiaNovedadcrearpagrTipoIdentificacion = familiaNovedadcrearpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadcrearpagrTipoIdentificacionInstance() {
        return this.familiaNovedadcrearpagrTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadcrearpagrTipoIdentificacionInstance(TipoIdentificacion familiaNovedadcrearpagrTipoIdentificacion) {
        this.familiaNovedadcrearpagrTipoIdentificacionInstance = familiaNovedadcrearpagrTipoIdentificacion;
        this.familiaNovedadcrearpagrTipoIdentificacion = familiaNovedadcrearpagrTipoIdentificacion != null ? familiaNovedadcrearpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public FirmaOid getFamiliaNovedadcrearpagrFirma() {
        return this.familiaNovedadcrearpagrFirma;
    }
    
    public void setFamiliaNovedadcrearpagrFirma(FirmaOid familiaNovedadcrearpagrFirma) {
        this.familiaNovedadcrearpagrFirma = familiaNovedadcrearpagrFirma;
    }

    @JsonIgnore
    public Firma getFamiliaNovedadcrearpagrFirmaInstance() {
        return this.familiaNovedadcrearpagrFirmaInstance;
    }
    
    public void setFamiliaNovedadcrearpagrFirmaInstance(Firma familiaNovedadcrearpagrFirma) {
        this.familiaNovedadcrearpagrFirmaInstance = familiaNovedadcrearpagrFirma;
        this.familiaNovedadcrearpagrFirma = familiaNovedadcrearpagrFirma != null ? familiaNovedadcrearpagrFirma.getOid() : null;
    }

    @JsonIgnore
    public String getFamiliaNovedadcrearpatrTitNumidentificacion() {
        return this.familiaNovedadcrearpatrTitNumidentificacion;
    }
    
    public void setFamiliaNovedadcrearpatrTitNumidentificacion(String familiaNovedadcrearpatrTitNumidentificacion) {
        this.familiaNovedadcrearpatrTitNumidentificacion = familiaNovedadcrearpatrTitNumidentificacion;
    }

    private void checkFamiliaNovedadcrearpatrTitNumidentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadcrearpatrTitNumidentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_CREAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_CREAR_FAMILIANOVEDADCREARPATRTITNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_CREAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_CREAR_FAMILIANOVEDADCREARPATRTITNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadcrearpatrTitPrimerNombre() {
        return this.familiaNovedadcrearpatrTitPrimerNombre;
    }
    
    public void setFamiliaNovedadcrearpatrTitPrimerNombre(String familiaNovedadcrearpatrTitPrimerNombre) {
        this.familiaNovedadcrearpatrTitPrimerNombre = familiaNovedadcrearpatrTitPrimerNombre;
    }

    @JsonIgnore
    public Boolean getFamiliaNovedadcrearpatrTitTieneBeneficios() {
        return this.familiaNovedadcrearpatrTitTieneBeneficios;
    }
    
    public void setFamiliaNovedadcrearpatrTitTieneBeneficios(Boolean familiaNovedadcrearpatrTitTieneBeneficios) {
        this.familiaNovedadcrearpatrTitTieneBeneficios = familiaNovedadcrearpatrTitTieneBeneficios;
    }

    private void checkFamiliaNovedadcrearpatrTitTieneBeneficios() throws NotNullArgumentException {
        if(this.getFamiliaNovedadcrearpatrTitTieneBeneficios() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_CREAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_CREAR_FAMILIANOVEDADCREARPATRTITTIENEBENEFICIOS, FamiliaNovedadConstants.SERV_ALIAS_CREAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_CREAR_FAMILIANOVEDADCREARPATRTITTIENEBENEFICIOS);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadcrearpatrTitSegundoNombre() {
        return this.familiaNovedadcrearpatrTitSegundoNombre;
    }
    
    public void setFamiliaNovedadcrearpatrTitSegundoNombre(String familiaNovedadcrearpatrTitSegundoNombre) {
        this.familiaNovedadcrearpatrTitSegundoNombre = familiaNovedadcrearpatrTitSegundoNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadcrearpatrTitPrimerApellido() {
        return this.familiaNovedadcrearpatrTitPrimerApellido;
    }
    
    public void setFamiliaNovedadcrearpatrTitPrimerApellido(String familiaNovedadcrearpatrTitPrimerApellido) {
        this.familiaNovedadcrearpatrTitPrimerApellido = familiaNovedadcrearpatrTitPrimerApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadcrearpatrTitSegundoApellido() {
        return this.familiaNovedadcrearpatrTitSegundoApellido;
    }
    
    public void setFamiliaNovedadcrearpatrTitSegundoApellido(String familiaNovedadcrearpatrTitSegundoApellido) {
        this.familiaNovedadcrearpatrTitSegundoApellido = familiaNovedadcrearpatrTitSegundoApellido;
    }

    @JsonIgnore
    public Long getFamiliaNovedadcrearpatrNumFamilia() {
        return this.familiaNovedadcrearpatrNumFamilia;
    }
    
    public void setFamiliaNovedadcrearpatrNumFamilia(Long familiaNovedadcrearpatrNumFamilia) {
        this.familiaNovedadcrearpatrNumFamilia = familiaNovedadcrearpatrNumFamilia;
    }

    private void checkFamiliaNovedadcrearpatrNumFamilia() throws NotNullArgumentException {
        if(this.getFamiliaNovedadcrearpatrNumFamilia() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_CREAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_CREAR_FAMILIANOVEDADCREARPATRNUMFAMILIA, FamiliaNovedadConstants.SERV_ALIAS_CREAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_CREAR_FAMILIANOVEDADCREARPATRNUMFAMILIA);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadcrearpatrTitRazonSocial() {
        return this.familiaNovedadcrearpatrTitRazonSocial;
    }
    
    public void setFamiliaNovedadcrearpatrTitRazonSocial(String familiaNovedadcrearpatrTitRazonSocial) {
        this.familiaNovedadcrearpatrTitRazonSocial = familiaNovedadcrearpatrTitRazonSocial;
    }

    @JsonIgnore
    public Boolean getFamiliaNovedadcrearpatrFamActiva() {
        return this.familiaNovedadcrearpatrFamActiva;
    }
    
    public void setFamiliaNovedadcrearpatrFamActiva(Boolean familiaNovedadcrearpatrFamActiva) {
        this.familiaNovedadcrearpatrFamActiva = familiaNovedadcrearpatrFamActiva;
    }

    private void checkFamiliaNovedadcrearpatrFamActiva() throws NotNullArgumentException {
        if(this.getFamiliaNovedadcrearpatrFamActiva() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_CREAR, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_CREAR_FAMILIANOVEDADCREARPATRFAMACTIVA, FamiliaNovedadConstants.SERV_ALIAS_CREAR, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_CREAR_FAMILIANOVEDADCREARPATRFAMACTIVA);
        }
    }
}
