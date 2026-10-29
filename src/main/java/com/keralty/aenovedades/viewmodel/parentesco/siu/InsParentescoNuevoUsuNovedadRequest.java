package com.keralty.aenovedades.viewmodel.parentesco.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.ParentescoConstants;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsParentescoNuevoUsuNovedadRequest {

    @JsonProperty("p_thisparentesco_oid")
    private ParentescoOid parentescoInsParentescoNuevoUsuNovedadpthisParentesco;
    
    @JsonIgnore
    private Parentesco parentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkParentescoInsParentescoNuevoUsuNovedadpthisParentesco();
        checkParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public ParentescoOid getParentescoInsParentescoNuevoUsuNovedadpthisParentesco() {
        return this.parentescoInsParentescoNuevoUsuNovedadpthisParentesco;
    }
    
    public void setParentescoInsParentescoNuevoUsuNovedadpthisParentesco(ParentescoOid parentescoInsParentescoNuevoUsuNovedadpthisParentesco) {
        this.parentescoInsParentescoNuevoUsuNovedadpthisParentesco = parentescoInsParentescoNuevoUsuNovedadpthisParentesco;
    }

    @JsonIgnore
    public Parentesco getParentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance() {
        return this.parentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance;
    }
    
    public void setParentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance(Parentesco parentescoInsParentescoNuevoUsuNovedadpthisParentesco) {
        this.parentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance = parentescoInsParentescoNuevoUsuNovedadpthisParentesco;
        this.parentescoInsParentescoNuevoUsuNovedadpthisParentesco = parentescoInsParentescoNuevoUsuNovedadpthisParentesco != null ? parentescoInsParentescoNuevoUsuNovedadpthisParentesco.getOid() : null;
    }

    private void checkParentescoInsParentescoNuevoUsuNovedadpthisParentesco() throws NotNullArgumentException {
        if(this.getParentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance() == null || this.getParentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_INSPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_INSPARENTESCONUEVOUSUNOVEDAD_PARENTESCOINSPARENTESCONUEVOUSUNOVEDADPTHISPARENTESCO, ParentescoConstants.SERV_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD_PARENTESCOINSPARENTESCONUEVOUSUNOVEDADPTHISPARENTESCO);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad() {
        return this.parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad = parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance() {
        return this.parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance = parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad;
        this.parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad = parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad != null ? parentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance() == null || this.getParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_INSPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_INSPARENTESCONUEVOUSUNOVEDAD_PARENTESCOINSPARENTESCONUEVOUSUNOVEDADPEVCUSUARIONOVEDAD, ParentescoConstants.SERV_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_INSPARENTESCONUEVOUSUNOVEDAD_PARENTESCOINSPARENTESCONUEVOUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
