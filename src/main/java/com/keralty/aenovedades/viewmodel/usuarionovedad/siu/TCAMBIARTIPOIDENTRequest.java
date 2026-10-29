package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class TCAMBIARTIPOIDENTRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance;

    @JsonProperty("pt_p_evctipoidentificacion_json")
    private String usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance;

    @JsonProperty("pt_p_numidentificacioncd")
    private String usuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad();
        checkUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion();
        checkUsuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad() {
        return this.usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad) {
        this.usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad = usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad) {
        this.usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance = usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad;
        this.usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad = usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad != null ? usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCAMBIARTIPOIDENT, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCAMBIARTIPOIDENT_USUARIONOVEDADTCAMBIARTIPOIDENTPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_TCAMBIARTIPOIDENT, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCAMBIARTIPOIDENT_USUARIONOVEDADTCAMBIARTIPOIDENTPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion() {
        return this.usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion;
    }
    
    public void setUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion(String usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion) {
        this.usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion = usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance() {
        return this.usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance;
    }
    
    public void setUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance(TipoIdentificacion usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion) {
        this.usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance = usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion;
        this.usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion = usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion != null ? usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance() == null || this.getUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCAMBIARTIPOIDENT, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCAMBIARTIPOIDENT_USUARIONOVEDADTCAMBIARTIPOIDENTPTPEVCTIPOIDENTIFICACION, UsuarioNovedadConstants.SERV_ALIAS_TCAMBIARTIPOIDENT, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCAMBIARTIPOIDENT_USUARIONOVEDADTCAMBIARTIPOIDENTPTPEVCTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD() {
        return this.usuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD;
    }
    
    public void setUsuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD(String usuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD) {
        this.usuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD = usuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD;
    }

    private void checkUsuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD() == null) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCAMBIARTIPOIDENT, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCAMBIARTIPOIDENT_USUARIONOVEDADTCAMBIARTIPOIDENTPTPNUMIDENTIFICACIONCD, UsuarioNovedadConstants.SERV_ALIAS_TCAMBIARTIPOIDENT, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCAMBIARTIPOIDENT_USUARIONOVEDADTCAMBIARTIPOIDENTPTPNUMIDENTIFICACIONCD);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
