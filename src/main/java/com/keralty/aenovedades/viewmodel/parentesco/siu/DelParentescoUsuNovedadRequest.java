package com.keralty.aenovedades.viewmodel.parentesco.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.ParentescoConstants;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelParentescoUsuNovedadRequest {

    @JsonProperty("p_thisparentesco_oid")
    private ParentescoOid parentescoDelParentescoUsuNovedadpthisParentesco;
    
    @JsonIgnore
    private Parentesco parentescoDelParentescoUsuNovedadpthisParentescoInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid parentescoDelParentescoUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad parentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkParentescoDelParentescoUsuNovedadpthisParentesco();
        checkParentescoDelParentescoUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public ParentescoOid getParentescoDelParentescoUsuNovedadpthisParentesco() {
        return this.parentescoDelParentescoUsuNovedadpthisParentesco;
    }
    
    public void setParentescoDelParentescoUsuNovedadpthisParentesco(ParentescoOid parentescoDelParentescoUsuNovedadpthisParentesco) {
        this.parentescoDelParentescoUsuNovedadpthisParentesco = parentescoDelParentescoUsuNovedadpthisParentesco;
    }

    @JsonIgnore
    public Parentesco getParentescoDelParentescoUsuNovedadpthisParentescoInstance() {
        return this.parentescoDelParentescoUsuNovedadpthisParentescoInstance;
    }
    
    public void setParentescoDelParentescoUsuNovedadpthisParentescoInstance(Parentesco parentescoDelParentescoUsuNovedadpthisParentesco) {
        this.parentescoDelParentescoUsuNovedadpthisParentescoInstance = parentescoDelParentescoUsuNovedadpthisParentesco;
        this.parentescoDelParentescoUsuNovedadpthisParentesco = parentescoDelParentescoUsuNovedadpthisParentesco != null ? parentescoDelParentescoUsuNovedadpthisParentesco.getOid() : null;
    }

    private void checkParentescoDelParentescoUsuNovedadpthisParentesco() throws NotNullArgumentException {
        if(this.getParentescoDelParentescoUsuNovedadpthisParentescoInstance() == null || this.getParentescoDelParentescoUsuNovedadpthisParentescoInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_DELPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_DELPARENTESCOUSUNOVEDAD_PARENTESCODELPARENTESCOUSUNOVEDADPTHISPARENTESCO, ParentescoConstants.SERV_ALIAS_DELPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_DELPARENTESCOUSUNOVEDAD_PARENTESCODELPARENTESCOUSUNOVEDADPTHISPARENTESCO);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getParentescoDelParentescoUsuNovedadpevcUsuarioNovedad() {
        return this.parentescoDelParentescoUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setParentescoDelParentescoUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid parentescoDelParentescoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoDelParentescoUsuNovedadpevcUsuarioNovedad = parentescoDelParentescoUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getParentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance() {
        return this.parentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setParentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad parentescoDelParentescoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance = parentescoDelParentescoUsuNovedadpevcUsuarioNovedad;
        this.parentescoDelParentescoUsuNovedadpevcUsuarioNovedad = parentescoDelParentescoUsuNovedadpevcUsuarioNovedad != null ? parentescoDelParentescoUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkParentescoDelParentescoUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getParentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance() == null || this.getParentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_DELPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_DELPARENTESCOUSUNOVEDAD_PARENTESCODELPARENTESCOUSUNOVEDADPEVCUSUARIONOVEDAD, ParentescoConstants.SERV_ALIAS_DELPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_DELPARENTESCOUSUNOVEDAD_PARENTESCODELPARENTESCOUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
