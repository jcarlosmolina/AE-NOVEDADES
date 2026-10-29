package com.keralty.aenovedades.viewmodel.familianovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamiliaNovedadNull;

public class PIUFamiliaNovedadNullResponse extends QueryResponse {

    private List<DSFamiliaNovedadNull> results;

    public PIUFamiliaNovedadNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUFamiliaNovedadNullResponse(List<DSFamiliaNovedadNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSFamiliaNovedadNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSFamiliaNovedadNull> results) {
        this.results = results;
    }
}
