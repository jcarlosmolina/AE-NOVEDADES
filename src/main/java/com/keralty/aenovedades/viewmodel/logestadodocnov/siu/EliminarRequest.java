package com.keralty.aenovedades.viewmodel.logestadodocnov.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.LogEstadoDocNovConstants;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.persistence.oid.LogEstadoDocNovOid;

public class EliminarRequest {

    @JsonProperty("p_thisobsestadonov_oid")
    private LogEstadoDocNovOid logEstadoDocNoveliminarpthisObsEstadoNov;
    
    @JsonIgnore
    private LogEstadoDocNov logEstadoDocNoveliminarpthisObsEstadoNovInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkLogEstadoDocNoveliminarpthisObsEstadoNov();
    }

    @JsonIgnore
    public LogEstadoDocNovOid getLogEstadoDocNoveliminarpthisObsEstadoNov() {
        return this.logEstadoDocNoveliminarpthisObsEstadoNov;
    }
    
    public void setLogEstadoDocNoveliminarpthisObsEstadoNov(LogEstadoDocNovOid logEstadoDocNoveliminarpthisObsEstadoNov) {
        this.logEstadoDocNoveliminarpthisObsEstadoNov = logEstadoDocNoveliminarpthisObsEstadoNov;
    }

    @JsonIgnore
    public LogEstadoDocNov getLogEstadoDocNoveliminarpthisObsEstadoNovInstance() {
        return this.logEstadoDocNoveliminarpthisObsEstadoNovInstance;
    }
    
    public void setLogEstadoDocNoveliminarpthisObsEstadoNovInstance(LogEstadoDocNov logEstadoDocNoveliminarpthisObsEstadoNov) {
        this.logEstadoDocNoveliminarpthisObsEstadoNovInstance = logEstadoDocNoveliminarpthisObsEstadoNov;
        this.logEstadoDocNoveliminarpthisObsEstadoNov = logEstadoDocNoveliminarpthisObsEstadoNov != null ? logEstadoDocNoveliminarpthisObsEstadoNov.getOid() : null;
    }

    private void checkLogEstadoDocNoveliminarpthisObsEstadoNov() throws NotNullArgumentException {
        if(this.getLogEstadoDocNoveliminarpthisObsEstadoNovInstance() == null || this.getLogEstadoDocNoveliminarpthisObsEstadoNovInstance().isNull()) {
            throw new NotNullArgumentException(LogEstadoDocNovConstants.SERV_ID_ELIMINAR, LogEstadoDocNovConstants.CLASS_ID, LogEstadoDocNovConstants.ARG_ID_ELIMINAR_LOGESTADODOCNOVELIMINARPTHISOBSESTADONOV, LogEstadoDocNovConstants.SERV_ALIAS_ELIMINAR, LogEstadoDocNovConstants.CLASS_ALIAS, LogEstadoDocNovConstants.ARG_ALIAS_ELIMINAR_LOGESTADODOCNOVELIMINARPTHISOBSESTADONOV);
        }
    }
}
