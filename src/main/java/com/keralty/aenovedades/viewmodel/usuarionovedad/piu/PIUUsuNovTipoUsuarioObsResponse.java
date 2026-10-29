package com.keralty.aenovedades.viewmodel.usuarionovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoUsuario;

public class PIUUsuNovTipoUsuarioObsResponse extends QueryResponse {

    private List<DSUsuNovTipoUsuario> results;

    public PIUUsuNovTipoUsuarioObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUUsuNovTipoUsuarioObsResponse(List<DSUsuNovTipoUsuario> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSUsuNovTipoUsuario> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSUsuNovTipoUsuario> results) {
        this.results = results;
    }
}
