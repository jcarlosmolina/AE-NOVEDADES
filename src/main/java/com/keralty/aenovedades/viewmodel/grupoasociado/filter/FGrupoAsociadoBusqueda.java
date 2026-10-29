package com.keralty.aenovedades.viewmodel.grupoasociado.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aenovedades.global.GrupoAsociadoConstants;
import com.keralty.aenovedades.viewmodel.FilterRequest;

public class FGrupoAsociadoBusqueda {

    @JsonProperty("v_codigolegal")
    private String vCodigoLegal;

    @JsonProperty("v_descripcion")
    private String vDescripcion;

    public FGrupoAsociadoBusqueda() {
        // Default constructor
    }

    @JsonIgnore
    public String getVCodigoLegal() {
        return this.vCodigoLegal;
    }
    
    public void setVCodigoLegal(String vCodigoLegal) {
        this.vCodigoLegal = vCodigoLegal;
    }

    @JsonIgnore
    public String getVDescripcion() {
        return this.vDescripcion;
    }
    
    public void setVDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(GrupoAsociadoConstants.FILTER_NAME_FGRUPOASOCIADOBUSQUEDA);
        filterRequest.addFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOBUSQUEDA_VCODIGOLEGAL, vCodigoLegal);
        filterRequest.addFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOBUSQUEDA_VDESCRIPCION, vDescripcion);
        return filterRequest;
    }
}
