package com.keralty.aenovedades.viewmodel.familianovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;

public class TMODIFICARMANUALRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private FamiliaNovedadOid familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad familiaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance;

    @JsonProperty("pt_p_numfamilia")
    private Long familiaNovedadTMODIFICARMANUALptpNumFamilia;

    @JsonProperty("pt_p_titnumidentificacion")
    private String familiaNovedadTMODIFICARMANUALptpTitNumidentificacion;

    @JsonProperty("pt_p_titprimernombre")
    private String familiaNovedadTMODIFICARMANUALptpTitPrimerNombre;

    @JsonProperty("pt_p_titsegundonombre")
    private String familiaNovedadTMODIFICARMANUALptpTitSegundoNombre;

    @JsonProperty("pt_p_titprimerapellido")
    private String familiaNovedadTMODIFICARMANUALptpTitPrimerApellido;

    @JsonProperty("pt_p_titsegundoapellido")
    private String familiaNovedadTMODIFICARMANUALptpTitSegundoApellido;

    @JsonProperty("pt_p_titrazonsocial")
    private String familiaNovedadTMODIFICARMANUALptpTitRazonSocial;

    @JsonProperty("pttipoidentificacion_json")
    private String familiaNovedadTMODIFICARMANUALptTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion familiaNovedadTMODIFICARMANUALptTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedad();
        checkFamiliaNovedadTMODIFICARMANUALptpNumFamilia();
        checkFamiliaNovedadTMODIFICARMANUALptpTitNumidentificacion();
        checkFamiliaNovedadTMODIFICARMANUALptTipoIdentificacion();
    }

    @JsonIgnore
    public FamiliaNovedadOid getFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedad() {
        return this.familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedad(FamiliaNovedadOid familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad) {
        this.familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad = familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance() {
        return this.familiaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance(FamiliaNovedad familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad) {
        this.familiaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance = familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad;
        this.familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad = familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad != null ? familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad.getOid() : null;
    }

    private void checkFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance() == null || this.getFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTHISFAMILIANOVEDAD);
        }
    }

    @JsonIgnore
    public Long getFamiliaNovedadTMODIFICARMANUALptpNumFamilia() {
        return this.familiaNovedadTMODIFICARMANUALptpNumFamilia;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptpNumFamilia(Long familiaNovedadTMODIFICARMANUALptpNumFamilia) {
        this.familiaNovedadTMODIFICARMANUALptpNumFamilia = familiaNovedadTMODIFICARMANUALptpNumFamilia;
    }

    private void checkFamiliaNovedadTMODIFICARMANUALptpNumFamilia() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTMODIFICARMANUALptpNumFamilia() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTPNUMFAMILIA, FamiliaNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTPNUMFAMILIA);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTMODIFICARMANUALptpTitNumidentificacion() {
        return this.familiaNovedadTMODIFICARMANUALptpTitNumidentificacion;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptpTitNumidentificacion(String familiaNovedadTMODIFICARMANUALptpTitNumidentificacion) {
        this.familiaNovedadTMODIFICARMANUALptpTitNumidentificacion = familiaNovedadTMODIFICARMANUALptpTitNumidentificacion;
    }

    private void checkFamiliaNovedadTMODIFICARMANUALptpTitNumidentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTMODIFICARMANUALptpTitNumidentificacion() == null) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTPTITNUMIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTPTITNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaNovedadTMODIFICARMANUALptpTitPrimerNombre() {
        return this.familiaNovedadTMODIFICARMANUALptpTitPrimerNombre;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptpTitPrimerNombre(String familiaNovedadTMODIFICARMANUALptpTitPrimerNombre) {
        this.familiaNovedadTMODIFICARMANUALptpTitPrimerNombre = familiaNovedadTMODIFICARMANUALptpTitPrimerNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTMODIFICARMANUALptpTitSegundoNombre() {
        return this.familiaNovedadTMODIFICARMANUALptpTitSegundoNombre;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptpTitSegundoNombre(String familiaNovedadTMODIFICARMANUALptpTitSegundoNombre) {
        this.familiaNovedadTMODIFICARMANUALptpTitSegundoNombre = familiaNovedadTMODIFICARMANUALptpTitSegundoNombre;
    }

    @JsonIgnore
    public String getFamiliaNovedadTMODIFICARMANUALptpTitPrimerApellido() {
        return this.familiaNovedadTMODIFICARMANUALptpTitPrimerApellido;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptpTitPrimerApellido(String familiaNovedadTMODIFICARMANUALptpTitPrimerApellido) {
        this.familiaNovedadTMODIFICARMANUALptpTitPrimerApellido = familiaNovedadTMODIFICARMANUALptpTitPrimerApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadTMODIFICARMANUALptpTitSegundoApellido() {
        return this.familiaNovedadTMODIFICARMANUALptpTitSegundoApellido;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptpTitSegundoApellido(String familiaNovedadTMODIFICARMANUALptpTitSegundoApellido) {
        this.familiaNovedadTMODIFICARMANUALptpTitSegundoApellido = familiaNovedadTMODIFICARMANUALptpTitSegundoApellido;
    }

    @JsonIgnore
    public String getFamiliaNovedadTMODIFICARMANUALptpTitRazonSocial() {
        return this.familiaNovedadTMODIFICARMANUALptpTitRazonSocial;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptpTitRazonSocial(String familiaNovedadTMODIFICARMANUALptpTitRazonSocial) {
        this.familiaNovedadTMODIFICARMANUALptpTitRazonSocial = familiaNovedadTMODIFICARMANUALptpTitRazonSocial;
    }

    @JsonIgnore
    public String getFamiliaNovedadTMODIFICARMANUALptTipoIdentificacion() {
        return this.familiaNovedadTMODIFICARMANUALptTipoIdentificacion;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptTipoIdentificacion(String familiaNovedadTMODIFICARMANUALptTipoIdentificacion) {
        this.familiaNovedadTMODIFICARMANUALptTipoIdentificacion = familiaNovedadTMODIFICARMANUALptTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaNovedadTMODIFICARMANUALptTipoIdentificacionInstance() {
        return this.familiaNovedadTMODIFICARMANUALptTipoIdentificacionInstance;
    }
    
    public void setFamiliaNovedadTMODIFICARMANUALptTipoIdentificacionInstance(TipoIdentificacion familiaNovedadTMODIFICARMANUALptTipoIdentificacion) {
        this.familiaNovedadTMODIFICARMANUALptTipoIdentificacionInstance = familiaNovedadTMODIFICARMANUALptTipoIdentificacion;
        this.familiaNovedadTMODIFICARMANUALptTipoIdentificacion = familiaNovedadTMODIFICARMANUALptTipoIdentificacion != null ? familiaNovedadTMODIFICARMANUALptTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkFamiliaNovedadTMODIFICARMANUALptTipoIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaNovedadTMODIFICARMANUALptTipoIdentificacionInstance() == null || this.getFamiliaNovedadTMODIFICARMANUALptTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaNovedadConstants.SERV_ID_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ID, FamiliaNovedadConstants.ARG_ID_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTTIPOIDENTIFICACION, FamiliaNovedadConstants.SERV_ALIAS_TMODIFICARMANUAL, FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ARG_ALIAS_TMODIFICARMANUAL_FAMILIANOVEDADTMODIFICARMANUALPTTIPOIDENTIFICACION);
        }
    }
}
