package com.keralty.aenovedades.viewmodel.novedadmd.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.NovedadMD;
public class DSNovedadMDNull {

    @JsonProperty("idnovedadmd")
    private Long dSNovedadMDNullIdNovedadMD;

    public DSNovedadMDNull() {
    
    }

    public DSNovedadMDNull(NovedadMD instance) {
        if (instance != null) {
            this.dSNovedadMDNullIdNovedadMD = instance.getNovedadMDidNovedadMD();
        }
    }

    @JsonIgnore
    public Long getDSNovedadMDNullIdNovedadMD() {
        return this.dSNovedadMDNullIdNovedadMD;
    }
    
    public void setDSNovedadMDNullIdNovedadMD(Long dSNovedadMDNullIdNovedadMD) {
        this.dSNovedadMDNullIdNovedadMD = dSNovedadMDNullIdNovedadMD;
    }
}
