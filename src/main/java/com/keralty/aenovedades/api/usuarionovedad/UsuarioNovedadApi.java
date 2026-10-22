package com.keralty.aenovedades.api.usuarionovedad;

import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.service.UsuarioNovedadService;
import com.keralty.aenovedades.utils.TokenUtilities;
import com.keralty.aenovedades.viewmodel.InstanceResponseViewModel;
import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.PopulationResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.piu.PIUUsuarioNovedadNullResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.piu.PIUUsuNovTipoTitularObsResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.piu.PIUUsuNovTipoTitularResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.piu.PIUUsuNovTipoUsuarioObsResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.piu.PIUUsuNovTipoUsuarioResponse;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TDELETERequest;
import com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TMODIFICARMANUALRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/UsuarioNovedadApi")
@RequestScoped
public class UsuarioNovedadApi {

    UsuarioNovedadService service;

    public UsuarioNovedadApi(UsuarioNovedadService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{usuarioNovedadidUsuarioNovedad}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public UsuarioNovedad getInstance(Long usuarioNovedadidUsuarioNovedad) {
    	return service.getById(usuarioNovedadidUsuarioNovedad);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<UsuarioNovedad> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<PreloadViewModel> getUsuarioNovedadPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public UsuarioNovedad getByOid(UsuarioNovedadOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public UsuarioNovedad getByOIDWithHV(UsuarioNovedadOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetUsuarioNovedadDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getUsuarioNovedadDynamic(QueryRequest request) {
        UsuarioNovedadOid oid = new UsuarioNovedadOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getUsuarioNovedadDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PreloadResponseViewModel getUsuarioNovedadWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getUsuarioNovedadPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/modificarSUNumMeses")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadModificarSUNumMeses(ModificarSUNumMesesRequest request) {
        return service.modificarSUNumMeses(request);
    }
    

    @POST
    @Path(value = "/modificarSUNumMesesCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadModificarSUNumMesesCheckPreconditions(ModificarSUNumMesesRequest request) {

        return service.modificarSUNumMesesCheckPreconditions(request);
    }

    @POST
    @Path(value = "/cambiarExcluido")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarExcluido(CambiarExcluidoRequest request) {
        return service.cambiarExcluido(request);
    }
    

    @POST
    @Path(value = "/cambiarExcluidoCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarExcluidoCheckPreconditions(CambiarExcluidoRequest request) {

        return service.cambiarExcluidoCheckPreconditions(request);
    }

    @POST
    @Path(value = "/cambiarRO")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarRO(CambiarRORequest request) {
        return service.cambiarRO(request);
    }
    

    @POST
    @Path(value = "/cambiarROCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarROCheckPreconditions(CambiarRORequest request) {

        return service.cambiarROCheckPreconditions(request);
    }

    @POST
    @Path(value = "/cambiarPS")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarPS(CambiarPSRequest request) {
        return service.cambiarPS(request);
    }
    

    @POST
    @Path(value = "/cambiarPSCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarPSCheckPreconditions(CambiarPSRequest request) {

        return service.cambiarPSCheckPreconditions(request);
    }

    @POST
    @Path(value = "/cambiarAS")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarAS(CambiarASRequest request) {
        return service.cambiarAS(request);
    }
    

    @POST
    @Path(value = "/cambiarASCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadCambiarASCheckPreconditions(CambiarASRequest request) {

        return service.cambiarASCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TDELETE")
    @RolesAllowed({"SuperAdmin","Asesor"})
    public ServiceResponse usuarioNovedadTDELETE(TDELETERequest request) {
        return service.tDELETE(request);
    }
    

    @POST
    @Path(value = "/TCAMBIARPARENTESCO")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadTCAMBIARPARENTESCO(TCAMBIARPARENTESCORequest request) {
        return service.tCAMBIARPARENTESCO(request);
    }
    

    @POST
    @Path(value = "/TCAMBIARPARENTESCOCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadTCAMBIARPARENTESCOCheckPreconditions(TCAMBIARPARENTESCORequest request) {

        return service.tCAMBIARPARENTESCOCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TCAMBIARTIPOIDENT")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadTCAMBIARTIPOIDENT(TCAMBIARTIPOIDENTRequest request) {
        return service.tCAMBIARTIPOIDENT(request);
    }
    

    @POST
    @Path(value = "/TCAMBIARTIPOIDENTCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse usuarioNovedadTCAMBIARTIPOIDENTCheckPreconditions(TCAMBIARTIPOIDENTRequest request) {

        return service.tCAMBIARTIPOIDENTCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TMODIFICARMANUAL")
    @RolesAllowed({"SuperAdmin","Asesor"})
    public ServiceResponse usuarioNovedadTMODIFICARMANUAL(TMODIFICARMANUALRequest request) {
        return service.tMODIFICARMANUAL(request);
    }
    


    @POST
    @Path(value = "/PIU_UsuNov_TipoTitular")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUUsuNovTipoTitularResponse piuPIUUsuNovTipoTitular(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuNovTipoTitularResponse response;
        try
        {
            response = new PIUUsuNovTipoTitularResponse(service.piuPIUUsuNovTipoTitular(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuNovTipoTitular(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUUsuNovTipoTitularResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_UsuNov_TipoUsuario")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUUsuNovTipoUsuarioResponse piuPIUUsuNovTipoUsuario(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuNovTipoUsuarioResponse response;
        try
        {
            response = new PIUUsuNovTipoUsuarioResponse(service.piuPIUUsuNovTipoUsuario(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuNovTipoUsuario(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUUsuNovTipoUsuarioResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_UsuarioNovedad_Null")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUUsuarioNovedadNullResponse piuPIUUsuarioNovedadNull(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuarioNovedadNullResponse response;
        try
        {
            response = new PIUUsuarioNovedadNullResponse(service.piuPIUUsuarioNovedadNull(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuarioNovedadNull(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUUsuarioNovedadNullResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_UsuNov_TipoTitularObs")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUUsuNovTipoTitularObsResponse piuPIUUsuNovTipoTitularObs(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuNovTipoTitularObsResponse response;
        try
        {
            response = new PIUUsuNovTipoTitularObsResponse(service.piuPIUUsuNovTipoTitularObs(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuNovTipoTitularObs(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUUsuNovTipoTitularObsResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_UsuNov_TipoUsuarioObs")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUUsuNovTipoUsuarioObsResponse piuPIUUsuNovTipoUsuarioObs(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuNovTipoUsuarioObsResponse response;
        try
        {
            response = new PIUUsuNovTipoUsuarioObsResponse(service.piuPIUUsuNovTipoUsuarioObs(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuNovTipoUsuarioObs(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUUsuNovTipoUsuarioObsResponse();
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
