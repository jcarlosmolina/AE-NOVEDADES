package com.keralty.aenovedades.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.GlobalServiceConstants;

public class OGSOLNOVSETTRAMITADORequest {

    @JsonProperty("ptfichero")
    private byte[] oGSOLNOVSETTRAMITADOptFichero;

    public void checkArguments() throws NotNullArgumentException {
        checkOGSOLNOVSETTRAMITADOptFichero();
    }

    @JsonIgnore
    public byte[] getOGSOLNOVSETTRAMITADOptFichero() {
        return this.oGSOLNOVSETTRAMITADOptFichero;
    }
    
    public void setOGSOLNOVSETTRAMITADOptFichero(byte[] oGSOLNOVSETTRAMITADOptFichero) {
        this.oGSOLNOVSETTRAMITADOptFichero = oGSOLNOVSETTRAMITADOptFichero;
    }

    private void checkOGSOLNOVSETTRAMITADOptFichero() throws NotNullArgumentException {
        if(this.getOGSOLNOVSETTRAMITADOptFichero() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_OGSOLNOVSETTRAMITADO, GlobalServiceConstants.GS_ARG_ID_OGSOLNOVSETTRAMITADO_OGSOLNOVSETTRAMITADOPTFICHERO, GlobalServiceConstants.G_SERV_ALIAS_OGSOLNOVSETTRAMITADO, GlobalServiceConstants.GS_ARG_ALIAS_OGSOLNOVSETTRAMITADO_OGSOLNOVSETTRAMITADOPTFICHERO);
        }
    }
}
