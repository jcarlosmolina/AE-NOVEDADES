package com.keralty.aenovedades.viewmodel.novedadct.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;

public class EliminarRequest {

    @JsonProperty("p_thisfamilianovedad_oid")
    private NovedadCTOid novedadCTeliminarpthisFamiliaNovedad;
    
    @JsonIgnore
    private NovedadCT novedadCTeliminarpthisFamiliaNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkNovedadCTeliminarpthisFamiliaNovedad();
    }

    @JsonIgnore
    public NovedadCTOid getNovedadCTeliminarpthisFamiliaNovedad() {
        return this.novedadCTeliminarpthisFamiliaNovedad;
    }
    
    public void setNovedadCTeliminarpthisFamiliaNovedad(NovedadCTOid novedadCTeliminarpthisFamiliaNovedad) {
        this.novedadCTeliminarpthisFamiliaNovedad = novedadCTeliminarpthisFamiliaNovedad;
    }

    @JsonIgnore
    public NovedadCT getNovedadCTeliminarpthisFamiliaNovedadInstance() {
        return this.novedadCTeliminarpthisFamiliaNovedadInstance;
    }
    
    public void setNovedadCTeliminarpthisFamiliaNovedadInstance(NovedadCT novedadCTeliminarpthisFamiliaNovedad) {
        this.novedadCTeliminarpthisFamiliaNovedadInstance = novedadCTeliminarpthisFamiliaNovedad;
        this.novedadCTeliminarpthisFamiliaNovedad = novedadCTeliminarpthisFamiliaNovedad != null ? novedadCTeliminarpthisFamiliaNovedad.getOid() : null;
    }

    private void checkNovedadCTeliminarpthisFamiliaNovedad() throws NotNullArgumentException {
        if(this.getNovedadCTeliminarpthisFamiliaNovedadInstance() == null || this.getNovedadCTeliminarpthisFamiliaNovedadInstance().isNull()) {
            throw new NotNullArgumentException(NovedadCTConstants.SERV_ID_ELIMINAR, NovedadCTConstants.CLASS_ID, NovedadCTConstants.ARG_ID_ELIMINAR_NOVEDADCTELIMINARPTHISFAMILIANOVEDAD, NovedadCTConstants.SERV_ALIAS_ELIMINAR, NovedadCTConstants.CLASS_ALIAS, NovedadCTConstants.ARG_ALIAS_ELIMINAR_NOVEDADCTELIMINARPTHISFAMILIANOVEDAD);
        }
    }
}
