package com.keralty.aenovedades.viewmodel.grupoasociado.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIU;

public class PIUGrupoAsociadoResponse extends QueryResponse {

    private List<DSGrupoAsociadoPIU> results;

    public PIUGrupoAsociadoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUGrupoAsociadoResponse(List<DSGrupoAsociadoPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSGrupoAsociadoPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSGrupoAsociadoPIU> results) {
        this.results = results;
    }
}
