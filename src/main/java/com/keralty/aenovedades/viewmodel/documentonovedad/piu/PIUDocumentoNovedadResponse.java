package com.keralty.aenovedades.viewmodel.documentonovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.documentonovedad.ds.DSDocumentoNovedad;

public class PIUDocumentoNovedadResponse extends QueryResponse {

    private List<DSDocumentoNovedad> results;

    public PIUDocumentoNovedadResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDocumentoNovedadResponse(List<DSDocumentoNovedad> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSDocumentoNovedad> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSDocumentoNovedad> results) {
        this.results = results;
    }
}
