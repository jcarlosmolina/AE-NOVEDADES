package com.keralty.aenovedades.viewmodel.periodicidad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.persistence.Periodicidad;
public class ICPeriodicidad {

    @JsonProperty("descripcion")
    private String iCPeriodicidadDescripcion;

    public ICPeriodicidad() {
    
    }

    public ICPeriodicidad(Periodicidad instance) {
        if (instance != null) {
            this.iCPeriodicidadDescripcion = instance.getPeriodicidadDescripcion();
        }
    }

    @JsonIgnore
    public String getICPeriodicidadDescripcion() {
        return this.iCPeriodicidadDescripcion;
    }
    
    public void setICPeriodicidadDescripcion(String iCPeriodicidadDescripcion) {
        this.iCPeriodicidadDescripcion = iCPeriodicidadDescripcion;
    }
}
