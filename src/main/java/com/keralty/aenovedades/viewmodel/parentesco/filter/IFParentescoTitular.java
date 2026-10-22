package com.keralty.aenovedades.viewmodel.parentesco.filter;


import com.keralty.aenovedades.global.ParentescoConstants;
import com.keralty.aenovedades.viewmodel.FilterRequest;

public class IFParentescoTitular {

    public IFParentescoTitular() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ParentescoConstants.FILTER_NAME_IFPARENTESCOTITULAR);
        return filterRequest;
    }
}
