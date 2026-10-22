package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class TDELETERequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadTDELETEpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadTDELETEpthisUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadTDELETEpthisUsuarioNovedad();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadTDELETEpthisUsuarioNovedad() {
        return this.usuarioNovedadTDELETEpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadTDELETEpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadTDELETEpthisUsuarioNovedad) {
        this.usuarioNovedadTDELETEpthisUsuarioNovedad = usuarioNovedadTDELETEpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadTDELETEpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadTDELETEpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadTDELETEpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadTDELETEpthisUsuarioNovedad) {
        this.usuarioNovedadTDELETEpthisUsuarioNovedadInstance = usuarioNovedadTDELETEpthisUsuarioNovedad;
        this.usuarioNovedadTDELETEpthisUsuarioNovedad = usuarioNovedadTDELETEpthisUsuarioNovedad != null ? usuarioNovedadTDELETEpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadTDELETEpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTDELETEpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadTDELETEpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TDELETE, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TDELETE_USUARIONOVEDADTDELETEPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_TDELETE, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TDELETE_USUARIONOVEDADTDELETEPTHISUSUARIONOVEDAD);
        }
    }
}
