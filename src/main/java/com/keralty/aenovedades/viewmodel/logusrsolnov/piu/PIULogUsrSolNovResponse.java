package com.keralty.aenovedades.viewmodel.logusrsolnov.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.logusrsolnov.ds.DSLogUsrSolNov;

public class PIULogUsrSolNovResponse extends QueryResponse {

    private List<DSLogUsrSolNov> results;

    public PIULogUsrSolNovResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIULogUsrSolNovResponse(List<DSLogUsrSolNov> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSLogUsrSolNov> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSLogUsrSolNov> results) {
        this.results = results;
    }
}
