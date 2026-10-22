package com.keralty.aenovedades.api.logusrsolnov;

import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.LogUsrSolNov;
import com.keralty.aenovedades.persistence.oid.LogUsrSolNovOid;
import com.keralty.aenovedades.service.LogUsrSolNovService;
import com.keralty.aenovedades.utils.TokenUtilities;
import com.keralty.aenovedades.viewmodel.InstanceResponseViewModel;
import com.keralty.aenovedades.viewmodel.logusrsolnov.piu.PIULogUsrSolNovResponse;
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

@Path("/api/LogUsrSolNovApi")
@RequestScoped
public class LogUsrSolNovApi {

    LogUsrSolNovService service;

    public LogUsrSolNovApi(LogUsrSolNovService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{logUsrSolNovId}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public LogUsrSolNov getInstance(Long logUsrSolNovId) {
    	return service.getById(logUsrSolNovId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public List<LogUsrSolNov> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public LogUsrSolNov getByOid(LogUsrSolNovOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public LogUsrSolNov getByOIDWithHV(LogUsrSolNovOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetLogUsrSolNovDynamic")
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public InstanceResponseViewModel getLogUsrSolNovDynamic(QueryRequest request) {
        LogUsrSolNovOid oid = new LogUsrSolNovOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getLogUsrSolNovDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public PopulationResponseViewModel getLogUsrSolNovPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }



    @POST
    @Path(value = "/PIU_LogUsrSolNov")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public PIULogUsrSolNovResponse piuPIULogUsrSolNov(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIULogUsrSolNovResponse response;
        try
        {
            response = new PIULogUsrSolNovResponse(service.piuPIULogUsrSolNov(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIULogUsrSolNov(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIULogUsrSolNovResponse();
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
