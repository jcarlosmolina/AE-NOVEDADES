package com.keralty.aenovedades.api.documentonovedad;

import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;
import com.keralty.aenovedades.service.DocumentoNovedadService;
import com.keralty.aenovedades.utils.TokenUtilities;
import com.keralty.aenovedades.viewmodel.documentonovedad.piu.PIUDocumentoNovedadNullResponse;
import com.keralty.aenovedades.viewmodel.documentonovedad.piu.PIUDocumentoNovedadResponse;
import com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATORequest;
import com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse;
import com.keralty.aenovedades.viewmodel.documentonovedad.siu.TAPROBARRequest;
import com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARATORequest;
import com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDEVOLVERRequest;
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

@Path("/api/DocumentoNovedadApi")
@RequestScoped
public class DocumentoNovedadApi {

    DocumentoNovedadService service;

    public DocumentoNovedadApi(DocumentoNovedadService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{documentoNovedadIdDocumento}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public DocumentoNovedad getInstance(Long documentoNovedadIdDocumento) {
    	return service.getById(documentoNovedadIdDocumento);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<DocumentoNovedad> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<PreloadViewModel> getDocumentoNovedadPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public DocumentoNovedad getByOid(DocumentoNovedadOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public DocumentoNovedad getByOIDWithHV(DocumentoNovedadOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetDocumentoNovedadDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getDocumentoNovedadDynamic(QueryRequest request) {
        DocumentoNovedadOid oid = new DocumentoNovedadOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getDocumentoNovedadDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PreloadResponseViewModel getDocumentoNovedadWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getDocumentoNovedadPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/descargarDocumentoATO")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public DescargarDocumentoATOResponse documentoNovedadDescargarDocumentoATO(DescargarDocumentoATORequest request) {
        return service.descargarDocumentoATO(request);
    }
    

    @POST
    @Path(value = "/descargarDocumentoATOCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public DescargarDocumentoATOResponse documentoNovedadDescargarDocumentoATOCheckPreconditions(DescargarDocumentoATORequest request) {

        return service.descargarDocumentoATOCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TAPROBAR")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse documentoNovedadTAPROBAR(TAPROBARRequest request) {
        return service.tAPROBAR(request);
    }
    

    @POST
    @Path(value = "/TDEVOLVER")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse documentoNovedadTDEVOLVER(TDEVOLVERRequest request) {
        return service.tDEVOLVER(request);
    }
    

    @POST
    @Path(value = "/TCREARATO")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public ServiceResponse documentoNovedadTCREARATO(TCREARATORequest request) {
        return service.tCREARATO(request);
    }
    


    @POST
    @Path(value = "/PIU_DocumentoNovedad")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUDocumentoNovedadResponse piuPIUDocumentoNovedad(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDocumentoNovedadResponse response;
        try
        {
            response = new PIUDocumentoNovedadResponse(service.piuPIUDocumentoNovedad(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDocumentoNovedad(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUDocumentoNovedadResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_DocumentoNovedad_Null")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUDocumentoNovedadNullResponse piuPIUDocumentoNovedadNull(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDocumentoNovedadNullResponse response;
        try
        {
            response = new PIUDocumentoNovedadNullResponse(service.piuPIUDocumentoNovedadNull(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDocumentoNovedadNull(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUDocumentoNovedadNullResponse();
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
