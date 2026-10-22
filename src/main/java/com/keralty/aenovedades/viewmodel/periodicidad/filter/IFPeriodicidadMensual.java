package com.keralty.aenovedades.viewmodel.periodicidad.filter;


import com.keralty.aenovedades.global.PeriodicidadConstants;
import com.keralty.aenovedades.viewmodel.FilterRequest;

public class IFPeriodicidadMensual {

    public IFPeriodicidadMensual() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(PeriodicidadConstants.FILTER_NAME_IFPERIODICIDADMENSUAL);
        return filterRequest;
    }
}
