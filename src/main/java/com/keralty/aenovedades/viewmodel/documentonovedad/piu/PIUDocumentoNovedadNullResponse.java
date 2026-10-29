package com.keralty.aenovedades.viewmodel.documentonovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.documentonovedad.ds.DSDocumentoNovedadNull;

public class PIUDocumentoNovedadNullResponse extends QueryResponse {

    private List<DSDocumentoNovedadNull> results;

    public PIUDocumentoNovedadNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDocumentoNovedadNullResponse(List<DSDocumentoNovedadNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSDocumentoNovedadNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSDocumentoNovedadNull> results) {
        this.results = results;
    }
}
