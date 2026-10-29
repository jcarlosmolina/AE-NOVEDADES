package com.keralty.aenovedades.viewmodel.asesor.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.asesor.ds.DSAsesorPIU;

public class PIUAsesoresDeAgenciaResponse extends QueryResponse {

    private List<DSAsesorPIU> results;

    public PIUAsesoresDeAgenciaResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAsesoresDeAgenciaResponse(List<DSAsesorPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAsesorPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAsesorPIU> results) {
        this.results = results;
    }
}
