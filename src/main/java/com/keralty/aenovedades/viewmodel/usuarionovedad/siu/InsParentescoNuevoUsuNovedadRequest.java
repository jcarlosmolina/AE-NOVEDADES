package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsParentescoNuevoUsuNovedadRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance;

    @JsonProperty("p_evcparentesco_oid")
    private ParentescoOid usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad();
        checkUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad() {
        return this.usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad = usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad) {
        this.usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance = usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad;
        this.usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad = usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad != null ? usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADINSPARENTESCONUEVOUSUNOVEDADPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADINSPARENTESCONUEVOUSUNOVEDADPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public ParentescoOid getUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco() {
        return this.usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco;
    }
    
    public void setUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco(ParentescoOid usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco) {
        this.usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco = usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance() {
        return this.usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance;
    }
    
    public void setUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance(Parentesco usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco) {
        this.usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance = usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco;
        this.usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco = usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco != null ? usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco.getOid() : null;
    }

    private void checkUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance() == null || this.getUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADINSPARENTESCONUEVOUSUNOVEDADPEVCPARENTESCO, UsuarioNovedadConstants.SERV_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD_USUARIONOVEDADINSPARENTESCONUEVOUSUNOVEDADPEVCPARENTESCO);
        }
    }
}
