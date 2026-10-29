package com.keralty.aenovedades.viewmodel.grupoasociado.piu;

import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.grupoasociado.filter.FGrupoAsociadoVarios;

public class PIUGrupoAsociadoRequest extends PopulationRequestViewModel{

    private FGrupoAsociadoVarios fGrupoAsociadoVarios;
    
    public void setFGrupoAsociadoVarios(FGrupoAsociadoVarios fGrupoAsociadoVarios) {
        this.fGrupoAsociadoVarios = fGrupoAsociadoVarios;
    }
    
    public FGrupoAsociadoVarios getFGrupoAsociadoVarios() {
        return fGrupoAsociadoVarios;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fGrupoAsociadoVarios != null)
            queryRequest.addFilterRequest(fGrupoAsociadoVarios.buildFilterRequest());
        return queryRequest;
    }
}
