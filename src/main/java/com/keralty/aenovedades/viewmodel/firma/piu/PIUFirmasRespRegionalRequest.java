package com.keralty.aenovedades.viewmodel.firma.piu;

import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.firma.filter.FFirmasResponsables;

public class PIUFirmasRespRegionalRequest extends PopulationRequestViewModel{

    private FFirmasResponsables fFirmasResponsables;
    
    public void setFFirmasResponsables(FFirmasResponsables fFirmasResponsables) {
        this.fFirmasResponsables = fFirmasResponsables;
    }
    
    public FFirmasResponsables getFFirmasResponsables() {
        return fFirmasResponsables;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fFirmasResponsables != null)
            queryRequest.addFilterRequest(fFirmasResponsables.buildFilterRequest());
        return queryRequest;
    }
}
