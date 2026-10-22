package com.keralty.aenovedades.viewmodel.logestadosn.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.LogEstadoSNConstants;
import com.keralty.aenovedades.persistence.LogEstadoSN;
import com.keralty.aenovedades.persistence.oid.LogEstadoSNOid;

public class EliminarRequest {

    @JsonProperty("p_thislogestadosn_oid")
    private LogEstadoSNOid logEstadoSNeliminarpthisLogEstadoSN;
    
    @JsonIgnore
    private LogEstadoSN logEstadoSNeliminarpthisLogEstadoSNInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkLogEstadoSNeliminarpthisLogEstadoSN();
    }

    @JsonIgnore
    public LogEstadoSNOid getLogEstadoSNeliminarpthisLogEstadoSN() {
        return this.logEstadoSNeliminarpthisLogEstadoSN;
    }
    
    public void setLogEstadoSNeliminarpthisLogEstadoSN(LogEstadoSNOid logEstadoSNeliminarpthisLogEstadoSN) {
        this.logEstadoSNeliminarpthisLogEstadoSN = logEstadoSNeliminarpthisLogEstadoSN;
    }

    @JsonIgnore
    public LogEstadoSN getLogEstadoSNeliminarpthisLogEstadoSNInstance() {
        return this.logEstadoSNeliminarpthisLogEstadoSNInstance;
    }
    
    public void setLogEstadoSNeliminarpthisLogEstadoSNInstance(LogEstadoSN logEstadoSNeliminarpthisLogEstadoSN) {
        this.logEstadoSNeliminarpthisLogEstadoSNInstance = logEstadoSNeliminarpthisLogEstadoSN;
        this.logEstadoSNeliminarpthisLogEstadoSN = logEstadoSNeliminarpthisLogEstadoSN != null ? logEstadoSNeliminarpthisLogEstadoSN.getOid() : null;
    }

    private void checkLogEstadoSNeliminarpthisLogEstadoSN() throws NotNullArgumentException {
        if(this.getLogEstadoSNeliminarpthisLogEstadoSNInstance() == null || this.getLogEstadoSNeliminarpthisLogEstadoSNInstance().isNull()) {
            throw new NotNullArgumentException(LogEstadoSNConstants.SERV_ID_ELIMINAR, LogEstadoSNConstants.CLASS_ID, LogEstadoSNConstants.ARG_ID_ELIMINAR_LOGESTADOSNELIMINARPTHISLOGESTADOSN, LogEstadoSNConstants.SERV_ALIAS_ELIMINAR, LogEstadoSNConstants.CLASS_ALIAS, LogEstadoSNConstants.ARG_ALIAS_ELIMINAR_LOGESTADOSNELIMINARPTHISLOGESTADOSN);
        }
    }
}
