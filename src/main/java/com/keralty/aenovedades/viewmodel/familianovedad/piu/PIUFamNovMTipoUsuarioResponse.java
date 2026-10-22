package com.keralty.aenovedades.viewmodel.familianovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular;

public class PIUFamNovMTipoUsuarioResponse extends QueryResponse {

    private List<DSFamNovTipoTitular> results;

    public PIUFamNovMTipoUsuarioResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUFamNovMTipoUsuarioResponse(List<DSFamNovTipoTitular> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSFamNovTipoTitular> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSFamNovTipoTitular> results) {
        this.results = results;
    }
}
