package com.keralty.aenovedades.api.logestadodocnov;

import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.persistence.oid.LogEstadoDocNovOid;
import com.keralty.aenovedades.service.LogEstadoDocNovService;
import com.keralty.aenovedades.utils.TokenUtilities;
import com.keralty.aenovedades.viewmodel.InstanceResponseViewModel;
import com.keralty.aenovedades.viewmodel.logestadodocnov.piu.PIULogEstadoDocNovResponse;
import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.PopulationResponseViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/LogEstadoDocNovApi")
@RequestScoped
public class LogEstadoDocNovApi {

    LogEstadoDocNovService service;

    public LogEstadoDocNovApi(LogEstadoDocNovService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{logEstadoDocNovId}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public LogEstadoDocNov getInstance(Long logEstadoDocNovId) {
    	return service.getById(logEstadoDocNovId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<LogEstadoDocNov> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public LogEstadoDocNov getByOid(LogEstadoDocNovOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public LogEstadoDocNov getByOIDWithHV(LogEstadoDocNovOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetLogEstadoDocNovDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getLogEstadoDocNovDynamic(QueryRequest request) {
        LogEstadoDocNovOid oid = new LogEstadoDocNovOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getLogEstadoDocNovDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getLogEstadoDocNovPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }



    @POST
    @Path(value = "/PIU_LogEstadoDocNov")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIULogEstadoDocNovResponse piuPIULogEstadoDocNov(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIULogEstadoDocNovResponse response;
        try
        {
            response = new PIULogEstadoDocNovResponse(service.piuPIULogEstadoDocNov(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIULogEstadoDocNov(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIULogEstadoDocNovResponse();
            response.setException(e);
        }
        return response;
    }


    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    @Operation(hidden = true)
    public AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath) {
        return service.buildRelatedInstance(relatedInstanceJsonOid, relatedInstancePath);
    }
}
