package com.keralty.aenovedades.service;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.keralty.integraciones.contract.ConsultarContratoRequest;
import com.keralty.integraciones.contract.ConsultarContratoResponse;
import com.keralty.integraciones.coverage.ConsultarBeneficiarioRequest;
import com.keralty.integraciones.patient.ConsultarPersonaRequest;
import com.keralty.integraciones.patient.ConsultarPersonaResponse;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/api/bhcall")
@RegisterRestClient(configKey="ae-apigateway")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aenovedades.utils.TokenUtilities.getToken4aeapigateway}")
public interface BhCallService {

    @POST
    @Path("/consultarContratoSinLastValid")
    ConsultarContratoResponse consultarContratoSinLastValid(ConsultarContratoRequest request);

    @POST
    @Path("/consultarPersona")
    ConsultarPersonaResponse consultarPersona(ConsultarPersonaRequest request);

    @POST
    @Path("/consultarCausaExclusionBeneficiario")
    String consultarCausaExclusionBeneficiario(ConsultarBeneficiarioRequest request);

}
