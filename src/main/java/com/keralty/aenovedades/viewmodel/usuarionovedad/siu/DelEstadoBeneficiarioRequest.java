package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelEstadoBeneficiarioRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance;

    @JsonProperty("p_evcestadobeneficiario_oid")
    private EstadoBeneficiarioOid usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad();
        checkUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad() {
        return this.usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad) {
        this.usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad = usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance() {
        return this.usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad) {
        this.usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance = usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad;
        this.usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad = usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad != null ? usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELESTADOBENEFICIARIO_USUARIONOVEDADDELESTADOBENEFICIARIOPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_DELESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELESTADOBENEFICIARIO_USUARIONOVEDADDELESTADOBENEFICIARIOPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario() {
        return this.usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario;
    }
    
    public void setUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario(EstadoBeneficiarioOid usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario) {
        this.usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario = usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance() {
        return this.usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance;
    }
    
    public void setUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance(EstadoBeneficiario usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario) {
        this.usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance = usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario;
        this.usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario = usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario != null ? usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario.getOid() : null;
    }

    private void checkUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario() throws NotNullArgumentException {
        if(this.getUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance() == null || this.getUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_DELESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_DELESTADOBENEFICIARIO_USUARIONOVEDADDELESTADOBENEFICIARIOPEVCESTADOBENEFICIARIO, UsuarioNovedadConstants.SERV_ALIAS_DELESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_DELESTADOBENEFICIARIO_USUARIONOVEDADDELESTADOBENEFICIARIOPEVCESTADOBENEFICIARIO);
        }
    }
}
