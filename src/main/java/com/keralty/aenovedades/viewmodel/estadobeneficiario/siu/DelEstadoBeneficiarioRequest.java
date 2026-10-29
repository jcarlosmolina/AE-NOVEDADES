package com.keralty.aenovedades.viewmodel.estadobeneficiario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.EstadoBeneficiarioConstants;
import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;

public class DelEstadoBeneficiarioRequest {

    @JsonProperty("p_thisestadobeneficiario_oid")
    private EstadoBeneficiarioOid estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance;

    @JsonProperty("p_evcusuarionovedad_oid")
    private UsuarioNovedadOid estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad;
    
    @JsonIgnore
    private UsuarioNovedad estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario();
        checkEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad();
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario() {
        return this.estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario(EstadoBeneficiarioOid estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario) {
        this.estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario = estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance() {
        return this.estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance(EstadoBeneficiario estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario) {
        this.estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance = estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario;
        this.estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario = estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario != null ? estadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario.getOid() : null;
    }

    private void checkEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiario() throws NotNullArgumentException {
        if(this.getEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance() == null || this.getEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(EstadoBeneficiarioConstants.SERV_ID_DELESTADOBENEFICIARIO, EstadoBeneficiarioConstants.CLASS_ID, EstadoBeneficiarioConstants.ARG_ID_DELESTADOBENEFICIARIO_ESTADOBENEFICIARIODELESTADOBENEFICIARIOPTHISESTADOBENEFICIARIO, EstadoBeneficiarioConstants.SERV_ALIAS_DELESTADOBENEFICIARIO, EstadoBeneficiarioConstants.CLASS_ALIAS, EstadoBeneficiarioConstants.ARG_ALIAS_DELESTADOBENEFICIARIO_ESTADOBENEFICIARIODELESTADOBENEFICIARIOPTHISESTADOBENEFICIARIO);
        }
    }

    @JsonIgnore
    public UsuarioNovedadOid getEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad() {
        return this.estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad(UsuarioNovedadOid estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad) {
        this.estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad = estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad;
    }

    @JsonIgnore
    public UsuarioNovedad getEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance() {
        return this.estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance(UsuarioNovedad estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad) {
        this.estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance = estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad;
        this.estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad = estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad != null ? estadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad.getOid() : null;
    }

    private void checkEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedad() throws NotNullArgumentException {
        if(this.getEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance() == null || this.getEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance().isNull()) {
            throw new NotNullArgumentException(EstadoBeneficiarioConstants.SERV_ID_DELESTADOBENEFICIARIO, EstadoBeneficiarioConstants.CLASS_ID, EstadoBeneficiarioConstants.ARG_ID_DELESTADOBENEFICIARIO_ESTADOBENEFICIARIODELESTADOBENEFICIARIOPEVCUSUARIONOVEDAD, EstadoBeneficiarioConstants.SERV_ALIAS_DELESTADOBENEFICIARIO, EstadoBeneficiarioConstants.CLASS_ALIAS, EstadoBeneficiarioConstants.ARG_ALIAS_DELESTADOBENEFICIARIO_ESTADOBENEFICIARIODELESTADOBENEFICIARIOPEVCUSUARIONOVEDAD);
        }
    }
}
