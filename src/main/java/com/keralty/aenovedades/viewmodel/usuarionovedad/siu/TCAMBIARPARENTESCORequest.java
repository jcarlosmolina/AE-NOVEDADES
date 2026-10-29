package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class TCAMBIARPARENTESCORequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance;

    @JsonProperty("pt_p_evcparentesco_json")
    private String usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco;
    
    @JsonIgnore
    private Parentesco usuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad();
        checkUsuarioNovedadTCAMBIARPARENTESCOptpevcParentesco();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad() {
        return this.usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad) {
        this.usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad = usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance() {
        return this.usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad) {
        this.usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance = usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad;
        this.usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad = usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad != null ? usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCAMBIARPARENTESCO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCAMBIARPARENTESCO_USUARIONOVEDADTCAMBIARPARENTESCOPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_TCAMBIARPARENTESCO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCAMBIARPARENTESCO_USUARIONOVEDADTCAMBIARPARENTESCOPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public String getUsuarioNovedadTCAMBIARPARENTESCOptpevcParentesco() {
        return this.usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco;
    }
    
    public void setUsuarioNovedadTCAMBIARPARENTESCOptpevcParentesco(String usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco) {
        this.usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco = usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco;
    }

    @JsonIgnore
    public Parentesco getUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance() {
        return this.usuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance;
    }
    
    public void setUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance(Parentesco usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco) {
        this.usuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance = usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco;
        this.usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco = usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco != null ? usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco.getOid().toJson() : "";
    }

    private void checkUsuarioNovedadTCAMBIARPARENTESCOptpevcParentesco() throws NotNullArgumentException {
        if(this.getUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance() == null || this.getUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_TCAMBIARPARENTESCO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_TCAMBIARPARENTESCO_USUARIONOVEDADTCAMBIARPARENTESCOPTPEVCPARENTESCO, UsuarioNovedadConstants.SERV_ALIAS_TCAMBIARPARENTESCO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_TCAMBIARPARENTESCO_USUARIONOVEDADTCAMBIARPARENTESCOPTPEVCPARENTESCO);
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
