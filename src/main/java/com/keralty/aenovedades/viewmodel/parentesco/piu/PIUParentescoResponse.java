package com.keralty.aenovedades.viewmodel.parentesco.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.parentesco.ds.AutoDS;

public class PIUParentescoResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUParentescoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUParentescoResponse(List<AutoDS> results) {
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
