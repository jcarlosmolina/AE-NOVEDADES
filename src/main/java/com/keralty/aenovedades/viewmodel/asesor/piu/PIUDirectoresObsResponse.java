package com.keralty.aenovedades.viewmodel.asesor.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.asesor.ds.DSDirectoresObs;

public class PIUDirectoresObsResponse extends QueryResponse {

    private List<DSDirectoresObs> results;

    public PIUDirectoresObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDirectoresObsResponse(List<DSDirectoresObs> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSDirectoresObs> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSDirectoresObs> results) {
        this.results = results;
    }
}
