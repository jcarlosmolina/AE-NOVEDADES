package com.keralty.aenovedades.viewmodel.periodicidad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.periodicidad.ds.AutoDS;

public class PIUPeriodicidadResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUPeriodicidadResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPeriodicidadResponse(List<AutoDS> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<AutoDS> getResults() {
        return this.results;
    }
    
    public void setResults(List<AutoDS> results) {
        this.results = results;
    }
}
