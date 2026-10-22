package com.keralty.aenovedades.viewmodel.asesor.piu;

import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.asesor.filter.FAsesores;

public class PIUAsesorRequest extends PopulationRequestViewModel{

    private FAsesores fAsesores;
    
    public void setFAsesores(FAsesores fAsesores) {
        this.fAsesores = fAsesores;
    }
    
    public FAsesores getFAsesores() {
        return fAsesores;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fAsesores != null)
            queryRequest.addFilterRequest(fAsesores.buildFilterRequest());
        return queryRequest;
    }
}
