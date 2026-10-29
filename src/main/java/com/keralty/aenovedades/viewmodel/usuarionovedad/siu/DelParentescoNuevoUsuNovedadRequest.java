package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelParentescoNuevoUsuNovedadRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance;

    @JsonProperty("p_evcparentesco_oid")
    private ParentescoOid usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad();
        checkUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad() {
        return this.usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance = usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad;
        this.usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad = usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad != null ? usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCONUEVOUSUNOVEDADPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCONUEVOUSUNOVEDADPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public ParentescoOid getUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco() {
        return this.usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco;
    }
    
    public void setUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco(ParentescoOid usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco) {
        this.usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco = usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance() {
        return this.usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance;
    }
    
    public void setUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance(Parentesco usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco) {
        this.usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance = usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco;
        this.usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco = usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco != null ? usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco.getOid() : null;
    }

    private void checkUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance() == null || this.getUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCONUEVOUSUNOVEDADPEVCPARENTESCO, UsuarioNovedadConstants.SERV_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADDELPARENTESCONUEVOUSUNOVEDADPEVCPARENTESCO);
        }
    }
}
