package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelParentescoUsuNovedadRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance;

    @JsonProperty("p_evcparentesco_oid")
    private ParentescoOid usuarioNovedadDelParentescoUsuNovedadpevcParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad();
        checkUsuarioNovedadDelParentescoUsuNovedadpevcParentesco();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad() {
        return this.usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance = usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad;
        this.usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad != null ? usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELPARENTESCOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELPARENTESCOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCOUSUNOVEDADPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_DELPARENTESCOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELPARENTESCOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCOUSUNOVEDADPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public ParentescoOid getUsuarioNovedadDelParentescoUsuNovedadpevcParentesco() {
        return this.usuarioNovedadDelParentescoUsuNovedadpevcParentesco;
    }
    
    public void setUsuarioNovedadDelParentescoUsuNovedadpevcParentesco(ParentescoOid usuarioNovedadDelParentescoUsuNovedadpevcParentesco) {
        this.usuarioNovedadDelParentescoUsuNovedadpevcParentesco = usuarioNovedadDelParentescoUsuNovedadpevcParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance() {
        return this.usuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance;
    }
    
    public void setUsuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance(Parentesco usuarioNovedadDelParentescoUsuNovedadpevcParentesco) {
        this.usuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance = usuarioNovedadDelParentescoUsuNovedadpevcParentesco;
        this.usuarioNovedadDelParentescoUsuNovedadpevcParentesco = usuarioNovedadDelParentescoUsuNovedadpevcParentesco != null ? usuarioNovedadDelParentescoUsuNovedadpevcParentesco.getOid() : null;
    }

    private void checkUsuarioNovedadDelParentescoUsuNovedadpevcParentesco() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance() == null || this.getUsuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELPARENTESCOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELPARENTESCOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCOUSUNOVEDADPEVCPARENTESCO, UsuarioNovedadConstants.SERV_ALIAS_DELPARENTESCOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELPARENTESCOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCOUSUNOVEDADPEVCPARENTESCO);
        }
    }
}
