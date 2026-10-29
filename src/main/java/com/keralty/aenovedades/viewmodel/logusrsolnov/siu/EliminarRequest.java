package com.keralty.aenovedades.viewmodel.logusrsolnov.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.LogUsrSolNovConstants;
import com.keralty.aenovedades.persistence.LogUsrSolNov;
import com.keralty.aenovedades.persistence.oid.LogUsrSolNovOid;

public class EliminarRequest {

    @JsonProperty("p_thislogusrsolnov_oid")
    private LogUsrSolNovOid logUsrSolNoveliminarpthisLogUsrSolNov;
    
    @JsonIgnore
    private LogUsrSolNov logUsrSolNoveliminarpthisLogUsrSolNovInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkLogUsrSolNoveliminarpthisLogUsrSolNov();
    }

    @JsonIgnore
    public LogUsrSolNovOid getLogUsrSolNoveliminarpthisLogUsrSolNov() {
        return this.logUsrSolNoveliminarpthisLogUsrSolNov;
    }
    
    public void setLogUsrSolNoveliminarpthisLogUsrSolNov(LogUsrSolNovOid logUsrSolNoveliminarpthisLogUsrSolNov) {
        this.logUsrSolNoveliminarpthisLogUsrSolNov = logUsrSolNoveliminarpthisLogUsrSolNov;
    }

    @JsonIgnore
    public LogUsrSolNov getLogUsrSolNoveliminarpthisLogUsrSolNovInstance() {
        return this.logUsrSolNoveliminarpthisLogUsrSolNovInstance;
    }
    
    public void setLogUsrSolNoveliminarpthisLogUsrSolNovInstance(LogUsrSolNov logUsrSolNoveliminarpthisLogUsrSolNov) {
        this.logUsrSolNoveliminarpthisLogUsrSolNovInstance = logUsrSolNoveliminarpthisLogUsrSolNov;
        this.logUsrSolNoveliminarpthisLogUsrSolNov = logUsrSolNoveliminarpthisLogUsrSolNov != null ? logUsrSolNoveliminarpthisLogUsrSolNov.getOid() : null;
    }

    private void checkLogUsrSolNoveliminarpthisLogUsrSolNov() throws NotNullArgumentException {
        if(this.getLogUsrSolNoveliminarpthisLogUsrSolNovInstance() == null || this.getLogUsrSolNoveliminarpthisLogUsrSolNovInstance().isNull()) {
            throw new NotNullArgumentException(LogUsrSolNovConstants.SERV_ID_ELIMINAR, LogUsrSolNovConstants.CLASS_ID, LogUsrSolNovConstants.ARG_ID_ELIMINAR_LOGUSRSOLNOVELIMINARPTHISLOGUSRSOLNOV, LogUsrSolNovConstants.SERV_ALIAS_ELIMINAR, LogUsrSolNovConstants.CLASS_ALIAS, LogUsrSolNovConstants.ARG_ALIAS_ELIMINAR_LOGUSRSOLNOVELIMINARPTHISLOGUSRSOLNOV);
        }
    }
}
