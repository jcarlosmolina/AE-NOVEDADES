package com.keralty.aenovedades.viewmodel.novedadmd.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.novedadmd.ds.DSNovedadMDNull;

public class PIUNovedadMDNullResponse extends QueryResponse {

    private List<DSNovedadMDNull> results;

    public PIUNovedadMDNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUNovedadMDNullResponse(List<DSNovedadMDNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSNovedadMDNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSNovedadMDNull> results) {
        this.results = results;
    }
}
