package com.keralty.aenovedades.viewmodel.novedadmd.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadMDConstants;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.oid.NovedadMDOid;

public class EliminarRequest {

    @JsonProperty("p_thisnovedadmd_oid")
    private NovedadMDOid novedadMDeliminarpthisNovedadMD;
    
    @JsonIgnore
    private NovedadMD novedadMDeliminarpthisNovedadMDInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadMDeliminarpthisNovedadMD();
    }

    @JsonIgnore
    public NovedadMDOid getNovedadMDeliminarpthisNovedadMD() {
        return this.novedadMDeliminarpthisNovedadMD;
    }
    
    public void setNovedadMDeliminarpthisNovedadMD(NovedadMDOid novedadMDeliminarpthisNovedadMD) {
        this.novedadMDeliminarpthisNovedadMD = novedadMDeliminarpthisNovedadMD;
    }

    @JsonIgnore
    public NovedadMD getNovedadMDeliminarpthisNovedadMDInstance() {
        return this.novedadMDeliminarpthisNovedadMDInstance;
    }
    
    public void setNovedadMDeliminarpthisNovedadMDInstance(NovedadMD novedadMDeliminarpthisNovedadMD) {
        this.novedadMDeliminarpthisNovedadMDInstance = novedadMDeliminarpthisNovedadMD;
        this.novedadMDeliminarpthisNovedadMD = novedadMDeliminarpthisNovedadMD != null ? novedadMDeliminarpthisNovedadMD.getOid() : null;
    }

    private void checkNovedadMDeliminarpthisNovedadMD() throws NotNullArgumentException {
        if(this.getNovedadMDeliminarpthisNovedadMDInstance() == null || this.getNovedadMDeliminarpthisNovedadMDInstance().isNull()) {
            throw new NotNullArgumentException(NovedadMDConstants.SERV_ID_ELIMINAR, NovedadMDConstants.CLASS_ID, NovedadMDConstants.ARG_ID_ELIMINAR_NOVEDADMDELIMINARPTHISNOVEDADMD, NovedadMDConstants.SERV_ALIAS_ELIMINAR, NovedadMDConstants.CLASS_ALIAS, NovedadMDConstants.ARG_ALIAS_ELIMINAR_NOVEDADMDELIMINARPTHISNOVEDADMD);
        }
    }
}
