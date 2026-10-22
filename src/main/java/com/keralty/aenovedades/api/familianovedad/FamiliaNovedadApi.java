package com.keralty.aenovedades.api.familianovedad;

import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.service.FamiliaNovedadService;
import com.keralty.aenovedades.utils.TokenUtilities;
import com.keralty.aenovedades.viewmodel.familianovedad.piu.PIUFamiliaNovedadNullResponse;
import com.keralty.aenovedades.viewmodel.familianovedad.piu.PIUFamNovMTipoTitularObsResponse;
import com.keralty.aenovedades.viewmodel.familianovedad.piu.PIUFamNovMTipoTitularResponse;
import com.keralty.aenovedades.viewmodel.familianovedad.piu.PIUFamNovMTipoUsuarioObsResponse;
import com.keralty.aenovedades.viewmodel.familianovedad.piu.PIUFamNovMTipoUsuarioResponse;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARMANUALRequest;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARUSUMANUALRequest;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TDELETERequest;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARTITULARRequest;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TMODIFICARMANUALRequest;
import com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest;
import com.keralty.aenovedades.viewmodel.InstanceResponseViewModel;
import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.PopulationResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/FamiliaNovedadApi")
@RequestScoped
public class FamiliaNovedadApi {

    FamiliaNovedadService service;

    public FamiliaNovedadApi(FamiliaNovedadService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{familiaNovedadidFamiliaNovedad}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public FamiliaNovedad getInstance(Long familiaNovedadidFamiliaNovedad) {
    	return service.getById(familiaNovedadidFamiliaNovedad);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<FamiliaNovedad> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<PreloadViewModel> getFamiliaNovedadPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public FamiliaNovedad getByOid(FamiliaNovedadOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public FamiliaNovedad getByOIDWithHV(FamiliaNovedadOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetFamiliaNovedadDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getFamiliaNovedadDynamic(QueryRequest request) {
        FamiliaNovedadOid oid = new FamiliaNovedadOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getFamiliaNovedadDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PreloadResponseViewModel getFamiliaNovedadWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getFamiliaNovedadPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/TFIRMARTITULAR")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTFIRMARTITULAR(TFIRMARTITULARRequest request) {
        return service.tFIRMARTITULAR(request);
    }
    

    @POST
    @Path(value = "/TSETDIRCORR")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTSETDIRCORR(TSETDIRCORRRequest request) {
        return service.tSETDIRCORR(request);
    }
    

    @POST
    @Path(value = "/TSETDIRCORRCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTSETDIRCORRCheckPreconditions(TSETDIRCORRRequest request) {

        return service.tSETDIRCORRCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TADDTITULAR")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTADDTITULAR(TADDTITULARRequest request) {
        return service.tADDTITULAR(request);
    }
    

    @POST
    @Path(value = "/TADDTITULARCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTADDTITULARCheckPreconditions(TADDTITULARRequest request) {

        return service.tADDTITULARCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TFIRMARNUEVOTITULAR")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTFIRMARNUEVOTITULAR(TFIRMARNUEVOTITULARRequest request) {
        return service.tFIRMARNUEVOTITULAR(request);
    }
    

    @POST
    @Path(value = "/TFIRMARNUEVOTITULARCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTFIRMARNUEVOTITULARCheckPreconditions(TFIRMARNUEVOTITULARRequest request) {

        return service.tFIRMARNUEVOTITULARCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TDELETE")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTDELETE(TDELETERequest request) {
        return service.tDELETE(request);
    }
    

    @POST
    @Path(value = "/TDELETECheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse familiaNovedadTDELETECheckPreconditions(TDELETERequest request) {

        return service.tDELETECheckPreconditions(request);
    }

    @POST
    @Path(value = "/TCREARMANUAL")
    @RolesAllowed({"SuperAdmin","Asesor"})
    public ServiceResponse familiaNovedadTCREARMANUAL(TCREARMANUALRequest request) {
        return service.tCREARMANUAL(request);
    }
    

    @POST
    @Path(value = "/TMODIFICARMANUAL")
    @RolesAllowed({"SuperAdmin","Asesor"})
    public ServiceResponse familiaNovedadTMODIFICARMANUAL(TMODIFICARMANUALRequest request) {
        return service.tMODIFICARMANUAL(request);
    }
    

    @POST
    @Path(value = "/TCREARUSUMANUAL")
    @RolesAllowed({"SuperAdmin","Asesor"})
    public ServiceResponse familiaNovedadTCREARUSUMANUAL(TCREARUSUMANUALRequest request) {
        return service.tCREARUSUMANUAL(request);
    }
    


    @POST
    @Path(value = "/PIU_FamNov_M_TipoTitular")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUFamNovMTipoTitularResponse piuPIUFamNovMTipoTitular(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFamNovMTipoTitularResponse response;
        try
        {
            response = new PIUFamNovMTipoTitularResponse(service.piuPIUFamNovMTipoTitular(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFamNovMTipoTitular(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFamNovMTipoTitularResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_FamNov_M_TipoUsuario")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUFamNovMTipoUsuarioResponse piuPIUFamNovMTipoUsuario(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFamNovMTipoUsuarioResponse response;
        try
        {
            response = new PIUFamNovMTipoUsuarioResponse(service.piuPIUFamNovMTipoUsuario(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFamNovMTipoUsuario(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFamNovMTipoUsuarioResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_FamiliaNovedad_Null")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUFamiliaNovedadNullResponse piuPIUFamiliaNovedadNull(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFamiliaNovedadNullResponse response;
        try
        {
            response = new PIUFamiliaNovedadNullResponse(service.piuPIUFamiliaNovedadNull(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFamiliaNovedadNull(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFamiliaNovedadNullResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_FamNov_M_TipoTitularObs")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUFamNovMTipoTitularObsResponse piuPIUFamNovMTipoTitularObs(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFamNovMTipoTitularObsResponse response;
        try
        {
            response = new PIUFamNovMTipoTitularObsResponse(service.piuPIUFamNovMTipoTitularObs(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFamNovMTipoTitularObs(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFamNovMTipoTitularObsResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_FamNov_M_TipoUsuarioObs")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUFamNovMTipoUsuarioObsResponse piuPIUFamNovMTipoUsuarioObs(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFamNovMTipoUsuarioObsResponse response;
        try
        {
            response = new PIUFamNovMTipoUsuarioObsResponse(service.piuPIUFamNovMTipoUsuarioObs(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFamNovMTipoUsuarioObs(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFamNovMTipoUsuarioObsResponse();
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
