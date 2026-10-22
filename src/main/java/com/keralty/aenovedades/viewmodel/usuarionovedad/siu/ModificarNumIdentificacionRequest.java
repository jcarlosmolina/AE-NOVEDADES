package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class ModificarNumIdentificacionRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance;

    @JsonProperty("p_numidentificacioncd")
    private String usuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad() {
        return this.usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad) {
        this.usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad = usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad) {
        this.usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance = usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad;
        this.usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad = usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad != null ? usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_MODIFICARNUMIDENTIFICACION, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_MODIFICARNUMIDENTIFICACION_USUARIONOVEDADMODIFICARNUMIDENTIFICACIONPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_MODIFICARNUMIDENTIFICACION, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_MODIFICARNUMIDENTIFICACION_USUARIONOVEDADMODIFICARNUMIDENTIFICACIONPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD() {
        return this.usuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD;
    }
    
    public void setUsuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD(String usuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD) {
        this.usuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD = usuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD;
    }
}
