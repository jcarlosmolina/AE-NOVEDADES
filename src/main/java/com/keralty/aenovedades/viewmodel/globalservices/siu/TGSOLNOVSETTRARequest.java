package com.keralty.aenovedades.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.GlobalServiceConstants;

public class TGSOLNOVSETTRARequest {

    @JsonProperty("ptnumradicado")
    private Long tGSOLNOVSETTRAptNumRadicado;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSOLNOVSETTRAptNumRadicado();
    }

    @JsonIgnore
    public Long getTGSOLNOVSETTRAptNumRadicado() {
        return this.tGSOLNOVSETTRAptNumRadicado;
    }
    
    public void setTGSOLNOVSETTRAptNumRadicado(Long tGSOLNOVSETTRAptNumRadicado) {
        this.tGSOLNOVSETTRAptNumRadicado = tGSOLNOVSETTRAptNumRadicado;
    }

    private void checkTGSOLNOVSETTRAptNumRadicado() throws NotNullArgumentException {
        if(this.getTGSOLNOVSETTRAptNumRadicado() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSOLNOVSETTRA, GlobalServiceConstants.GS_ARG_ID_TGSOLNOVSETTRA_TGSOLNOVSETTRAPTNUMRADICADO, GlobalServiceConstants.G_SERV_ALIAS_TGSOLNOVSETTRA, GlobalServiceConstants.GS_ARG_ALIAS_TGSOLNOVSETTRA_TGSOLNOVSETTRAPTNUMRADICADO);
        }
    }
}
