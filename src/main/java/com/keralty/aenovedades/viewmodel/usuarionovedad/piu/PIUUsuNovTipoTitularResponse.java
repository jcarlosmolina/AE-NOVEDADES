package com.keralty.aenovedades.viewmodel.usuarionovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoTitular;

public class PIUUsuNovTipoTitularResponse extends QueryResponse {

    private List<DSUsuNovTipoTitular> results;

    public PIUUsuNovTipoTitularResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUUsuNovTipoTitularResponse(List<DSUsuNovTipoTitular> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSUsuNovTipoTitular> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSUsuNovTipoTitular> results) {
        this.results = results;
    }
}
