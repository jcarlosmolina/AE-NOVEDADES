package com.keralty.aenovedades.viewmodel.usuarionovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class InsEstadoBeneficiarioRequest {

    @JsonProperty("p_thisusuarionovedad_oid")
    private UsuarioNovedadOid usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance;

    @JsonProperty("p_evcestadobeneficiario_oid")
    private EstadoBeneficiarioOid usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad();
        checkUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario();
    }

    @JsonIgnore
    public UsuarioNovedadOid getUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad() {
        return this.usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad;
    }
    
    public void setUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad(UsuarioNovedadOid usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad) {
        this.usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad = usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance() {
        return this.usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance;
    }
    
    public void setUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance(UsuarioNovedad usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad) {
        this.usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance = usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad;
        this.usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad = usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad != null ? usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad.getOid() : null;
    }

    private void checkUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance() == null || this.getUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSESTADOBENEFICIARIO_USUARIONOVEDADINSESTADOBENEFICIARIOPTHISUSUARIONOVEDAD, UsuarioNovedadConstants.SERV_ALIAS_INSESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSESTADOBENEFICIARIO_USUARIONOVEDADINSESTADOBENEFICIARIOPTHISUSUARIONOVEDAD);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario() {
        return this.usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario;
    }
    
    public void setUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario(EstadoBeneficiarioOid usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario) {
        this.usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario = usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance() {
        return this.usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance;
    }
    
    public void setUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance(EstadoBeneficiario usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario) {
        this.usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance = usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario;
        this.usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario = usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario != null ? usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario.getOid() : null;
    }

    private void checkUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario() throws NotNullArgumentException {
        if(this.getUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance() == null || this.getUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioNovedadConstants.SERV_ID_INSESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ID, UsuarioNovedadConstants.ARG_ID_INSESTADOBENEFICIARIO_USUARIONOVEDADINSESTADOBENEFICIARIOPEVCESTADOBENEFICIARIO, UsuarioNovedadConstants.SERV_ALIAS_INSESTADOBENEFICIARIO, UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ARG_ALIAS_INSESTADOBENEFICIARIO_USUARIONOVEDADINSESTADOBENEFICIARIOPEVCESTADOBENEFICIARIO);
        }
    }
}
