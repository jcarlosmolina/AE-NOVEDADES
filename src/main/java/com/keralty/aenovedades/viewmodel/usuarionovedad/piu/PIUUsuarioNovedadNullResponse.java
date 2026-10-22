package com.keralty.aenovedades.viewmodel.usuarionovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuarioNovedadNull;

public class PIUUsuarioNovedadNullResponse extends QueryResponse {

    private List<DSUsuarioNovedadNull> results;

    public PIUUsuarioNovedadNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUUsuarioNovedadNullResponse(List<DSUsuarioNovedadNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSUsuarioNovedadNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSUsuarioNovedadNull> results) {
        this.results = results;
    }
}
