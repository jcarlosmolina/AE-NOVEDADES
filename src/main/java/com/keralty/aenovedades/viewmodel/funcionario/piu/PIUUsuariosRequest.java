package com.keralty.aenovedades.viewmodel.funcionario.piu;

import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.funcionario.filter.FFuncionarioPorNombreNoAseso;

public class PIUUsuariosRequest extends PopulationRequestViewModel{

    private FFuncionarioPorNombreNoAseso fFuncionarioPorNombreNoAseso;
    
    public void setFFuncionarioPorNombreNoAseso(FFuncionarioPorNombreNoAseso fFuncionarioPorNombreNoAseso) {
        this.fFuncionarioPorNombreNoAseso = fFuncionarioPorNombreNoAseso;
    }
    
    public FFuncionarioPorNombreNoAseso getFFuncionarioPorNombreNoAseso() {
        return fFuncionarioPorNombreNoAseso;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fFuncionarioPorNombreNoAseso != null)
            queryRequest.addFilterRequest(fFuncionarioPorNombreNoAseso.buildFilterRequest());
        return queryRequest;
    }
}
