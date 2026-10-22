package com.keralty.aenovedades.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class GetRutaPlantillaResponse extends ServiceResponse {

    @JsonProperty("oaruta")
    private String solicitudNovedadgetRutaPlantillaoaRuta;

    @JsonProperty("oanombrearchivo")
    private String solicitudNovedadgetRutaPlantillaoaNombreArchivo;

    @JsonProperty("oareporte")
    private byte[] solicitudNovedadgetRutaPlantillaoaReporte;

    public GetRutaPlantillaResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicitudNovedadgetRutaPlantillaoaRuta() {
        return this.solicitudNovedadgetRutaPlantillaoaRuta;
    }
    
    public void setSolicitudNovedadgetRutaPlantillaoaRuta(String solicitudNovedadgetRutaPlantillaoaRuta) {
        this.solicitudNovedadgetRutaPlantillaoaRuta = solicitudNovedadgetRutaPlantillaoaRuta;
    }

    @JsonIgnore
    public String getSolicitudNovedadgetRutaPlantillaoaNombreArchivo() {
        return this.solicitudNovedadgetRutaPlantillaoaNombreArchivo;
    }
    
    public void setSolicitudNovedadgetRutaPlantillaoaNombreArchivo(String solicitudNovedadgetRutaPlantillaoaNombreArchivo) {
        this.solicitudNovedadgetRutaPlantillaoaNombreArchivo = solicitudNovedadgetRutaPlantillaoaNombreArchivo;
    }

    @JsonIgnore
    public byte[] getSolicitudNovedadgetRutaPlantillaoaReporte() {
        return this.solicitudNovedadgetRutaPlantillaoaReporte;
    }
    
    public void setSolicitudNovedadgetRutaPlantillaoaReporte(byte[] solicitudNovedadgetRutaPlantillaoaReporte) {
        this.solicitudNovedadgetRutaPlantillaoaReporte = solicitudNovedadgetRutaPlantillaoaReporte;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudNovedadgetRutaPlantillaoaRuta", solicitudNovedadgetRutaPlantillaoaRuta);
        outArgs.put("solicitudNovedadgetRutaPlantillaoaNombreArchivo", solicitudNovedadgetRutaPlantillaoaNombreArchivo);
        outArgs.put("solicitudNovedadgetRutaPlantillaoaReporte", solicitudNovedadgetRutaPlantillaoaReporte);
        return outArgs;
    }
}
