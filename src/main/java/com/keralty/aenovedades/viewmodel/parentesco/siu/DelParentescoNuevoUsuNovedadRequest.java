package com.keralty.aenovedades.viewmodel.parentesco.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.ParentescoConstants;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelParentescoNuevoUsuNovedadRequest {

    @JsonProperty("p_thisparentesco_oid")
    private ParentescoOid parentescoDelParentescoNuevoUsuNovedadpthisParentesco;
    
    @JsonIgnore
    private Parentesco parentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkParentescoDelParentescoNuevoUsuNovedadpthisParentesco();
        checkParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public ParentescoOid getParentescoDelParentescoNuevoUsuNovedadpthisParentesco() {
        return this.parentescoDelParentescoNuevoUsuNovedadpthisParentesco;
    }
    
    public void setParentescoDelParentescoNuevoUsuNovedadpthisParentesco(ParentescoOid parentescoDelParentescoNuevoUsuNovedadpthisParentesco) {
        this.parentescoDelParentescoNuevoUsuNovedadpthisParentesco = parentescoDelParentescoNuevoUsuNovedadpthisParentesco;
    }

    @JsonIgnore
    public Parentesco getParentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance() {
        return this.parentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance;
    }
    
    public void setParentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance(Parentesco parentescoDelParentescoNuevoUsuNovedadpthisParentesco) {
        this.parentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance = parentescoDelParentescoNuevoUsuNovedadpthisParentesco;
        this.parentescoDelParentescoNuevoUsuNovedadpthisParentesco = parentescoDelParentescoNuevoUsuNovedadpthisParentesco != null ? parentescoDelParentescoNuevoUsuNovedadpthisParentesco.getOid() : null;
    }

    private void checkParentescoDelParentescoNuevoUsuNovedadpthisParentesco() throws NotNullArgumentException {
        if(this.getParentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance() == null || this.getParentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_DELPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_DELPARENTESCONUEVOUSUNOVEDAD_PARENTESCODELPARENTESCONUEVOUSUNOVEDADPTHISPARENTESCO, ParentescoConstants.SERV_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD_PARENTESCODELPARENTESCONUEVOUSUNOVEDADPTHISPARENTESCO);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad() {
        return this.parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad = parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance() {
        return this.parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance = parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad;
        this.parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad = parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad != null ? parentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance() == null || this.getParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_DELPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_DELPARENTESCONUEVOUSUNOVEDAD_PARENTESCODELPARENTESCONUEVOUSUNOVEDADPEVCUSUARIONOVEDAD, ParentescoConstants.SERV_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_DELPARENTESCONUEVOUSUNOVEDAD_PARENTESCODELPARENTESCONUEVOUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
