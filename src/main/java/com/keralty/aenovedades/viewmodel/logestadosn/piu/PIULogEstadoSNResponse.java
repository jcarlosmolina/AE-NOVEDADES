package com.keralty.aenovedades.viewmodel.logestadosn.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.logestadosn.ds.DSLogEstadoSNPIU;

public class PIULogEstadoSNResponse extends QueryResponse {

    private List<DSLogEstadoSNPIU> results;

    public PIULogEstadoSNResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIULogEstadoSNResponse(List<DSLogEstadoSNPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSLogEstadoSNPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSLogEstadoSNPIU> results) {
        this.results = results;
    }
}
