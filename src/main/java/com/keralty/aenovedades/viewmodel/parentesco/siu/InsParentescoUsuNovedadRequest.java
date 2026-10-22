package com.keralty.aenovedades.viewmodel.parentesco.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.ParentescoConstants;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsParentescoUsuNovedadRequest {

    @JsonProperty("p_thisparentesco_oid")
    private ParentescoOid parentescoInsParentescoUsuNovedadpthisParentesco;
    
    @JsonIgnore
    private Parentesco parentescoInsParentescoUsuNovedadpthisParentescoInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid parentescoInsParentescoUsuNovedadpevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad parentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkParentescoInsParentescoUsuNovedadpthisParentesco();
        checkParentescoInsParentescoUsuNovedadpevcUsuarioNovedad();
    }

    @JsonIgnore
    public ParentescoOid getParentescoInsParentescoUsuNovedadpthisParentesco() {
        return this.parentescoInsParentescoUsuNovedadpthisParentesco;
    }
    
    public void setParentescoInsParentescoUsuNovedadpthisParentesco(ParentescoOid parentescoInsParentescoUsuNovedadpthisParentesco) {
        this.parentescoInsParentescoUsuNovedadpthisParentesco = parentescoInsParentescoUsuNovedadpthisParentesco;
    }

    @JsonIgnore
    public Parentesco getParentescoInsParentescoUsuNovedadpthisParentescoInstance() {
        return this.parentescoInsParentescoUsuNovedadpthisParentescoInstance;
    }
    
    public void setParentescoInsParentescoUsuNovedadpthisParentescoInstance(Parentesco parentescoInsParentescoUsuNovedadpthisParentesco) {
        this.parentescoInsParentescoUsuNovedadpthisParentescoInstance = parentescoInsParentescoUsuNovedadpthisParentesco;
        this.parentescoInsParentescoUsuNovedadpthisParentesco = parentescoInsParentescoUsuNovedadpthisParentesco != null ? parentescoInsParentescoUsuNovedadpthisParentesco.getOid() : null;
    }

    private void checkParentescoInsParentescoUsuNovedadpthisParentesco() throws NotNullArgumentException {
        if(this.getParentescoInsParentescoUsuNovedadpthisParentescoInstance() == null || this.getParentescoInsParentescoUsuNovedadpthisParentescoInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_INSPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_INSPARENTESCOUSUNOVEDAD_PARENTESCOINSPARENTESCOUSUNOVEDADPTHISPARENTESCO, ParentescoConstants.SERV_ALIAS_INSPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_INSPARENTESCOUSUNOVEDAD_PARENTESCOINSPARENTESCOUSUNOVEDADPTHISPARENTESCO);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getParentescoInsParentescoUsuNovedadpevcUsuarioNovedad() {
        return this.parentescoInsParentescoUsuNovedadpevcUsuarioNovedad;
    }
    
    public void setParentescoInsParentescoUsuNovedadpevcUsuarioNovedad(UsuarioNovedadOid parentescoInsParentescoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoInsParentescoUsuNovedadpevcUsuarioNovedad = parentescoInsParentescoUsuNovedadpevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getParentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance() {
        return this.parentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance;
    }
    
    public void setParentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance(UsuarioNovedad parentescoInsParentescoUsuNovedadpevcUsuarioNovedad) {
        this.parentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance = parentescoInsParentescoUsuNovedadpevcUsuarioNovedad;
        this.parentescoInsParentescoUsuNovedadpevcUsuarioNovedad = parentescoInsParentescoUsuNovedadpevcUsuarioNovedad != null ? parentescoInsParentescoUsuNovedadpevcUsuarioNovedad.getOid() : null;
    }

    private void checkParentescoInsParentescoUsuNovedadpevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getParentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance() == null || this.getParentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_INSPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_INSPARENTESCOUSUNOVEDAD_PARENTESCOINSPARENTESCOUSUNOVEDADPEVCUSUARIONOVEDAD, ParentescoConstants.SERV_ALIAS_INSPARENTESCOUSUNOVEDAD, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_INSPARENTESCOUSUNOVEDAD_PARENTESCOINSPARENTESCOUSUNOVEDADPEVCUSUARIONOVEDAD);
        }
    }
}
