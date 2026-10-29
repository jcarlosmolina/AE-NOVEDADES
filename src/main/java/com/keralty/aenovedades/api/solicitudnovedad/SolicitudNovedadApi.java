package com.keralty.aenovedades.api.solicitudnovedad;

import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.service.SolicitudNovedadService;
import com.keralty.aenovedades.utils.TokenUtilities;
import com.keralty.aenovedades.viewmodel.InstanceResponseViewModel;
import com.keralty.aenovedades.viewmodel.PopulationRequestViewModel;
import com.keralty.aenovedades.viewmodel.PopulationResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContratante;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContraTipoTitular;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUConsultaSolicitudNovedadRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUConsultaSolicitudNovedadResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUEstatusSolNovAfiliacionRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUEstatusSolNovAfiliacionResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUEstatusSolNovAsesorRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUEstatusSolNovAsesorResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUEstatusSolNovRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUEstatusSolNovResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.piu.PIUSolicitudNovedadNullResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AnotarObservacionesRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyEstatusSolicitudesRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAConsultarRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAModificarRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyVerPDFRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.RegistrarObservacionesRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TFIRMARRequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARANULADARequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse;
import com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/SolicitudNovedadApi")
@RequestScoped
public class SolicitudNovedadApi {

    SolicitudNovedadService service;

    public SolicitudNovedadApi(SolicitudNovedadService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{solicitudNovedadId}")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public SolicitudNovedad getInstance(Long solicitudNovedadId) {
    	return service.getById(solicitudNovedadId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<SolicitudNovedad> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<PreloadViewModel> getSolicitudNovedadPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public SolicitudNovedad getByOid(SolicitudNovedadOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public SolicitudNovedad getByOIDWithHV(SolicitudNovedadOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetSolicitudNovedadDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getSolicitudNovedadDynamic(QueryRequest request) {
        SolicitudNovedadOid oid = new SolicitudNovedadOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getSolicitudNovedadDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PreloadResponseViewModel getSolicitudNovedadWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getSolicitudNovedadPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/modificarNumMeses")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadModificarNumMeses(ModificarNumMesesRequest request) {
        return service.modificarNumMeses(request);
    }
    

    @POST
    @Path(value = "/modificarNumMesesCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadModificarNumMesesCheckPreconditions(ModificarNumMesesRequest request) {

        return service.modificarNumMesesCheckPreconditions(request);
    }

    @POST
    @Path(value = "/modificarNuevoNombre")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadModificarNuevoNombre(ModificarNuevoNombreRequest request) {
        return service.modificarNuevoNombre(request);
    }
    

    @POST
    @Path(value = "/modificarNuevoNombreCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadModificarNuevoNombreCheckPreconditions(ModificarNuevoNombreRequest request) {

        return service.modificarNuevoNombreCheckPreconditions(request);
    }

    @POST
    @Path(value = "/registrarObservaciones")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadRegistrarObservaciones(RegistrarObservacionesRequest request) {
        return service.registrarObservaciones(request);
    }
    

    @POST
    @Path(value = "/registrarObservacionesCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadRegistrarObservacionesCheckPreconditions(RegistrarObservacionesRequest request) {

        return service.registrarObservacionesCheckPreconditions(request);
    }

    @POST
    @Path(value = "/dummyNavegarAModificar")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadDummyNavegarAModificar(DummyNavegarAModificarRequest request) {
        return service.dummyNavegarAModificar(request);
    }
    

    @POST
    @Path(value = "/dummyVerPDF")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadDummyVerPDF(DummyVerPDFRequest request) {
        return service.dummyVerPDF(request);
    }
    

    @POST
    @Path(value = "/anotarObservaciones")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadAnotarObservaciones(AnotarObservacionesRequest request) {
        return service.anotarObservaciones(request);
    }
    

    @POST
    @Path(value = "/anotarObservacionesCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadAnotarObservacionesCheckPreconditions(AnotarObservacionesRequest request) {

        return service.anotarObservacionesCheckPreconditions(request);
    }

    @POST
    @Path(value = "/dummy_EstatusSolicitudes")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadDummyEstatusSolicitudes(DummyEstatusSolicitudesRequest request) {
        return service.dummyEstatusSolicitudes(request);
    }
    

    @POST
    @Path(value = "/dummyNavegarAConsultar")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","Gestor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadDummyNavegarAConsultar(DummyNavegarAConsultarRequest request) {
        return service.dummyNavegarAConsultar(request);
    }
    

    @POST
    @Path(value = "/getRutaPlantilla")
    public GetRutaPlantillaResponse solicitudNovedadGetRutaPlantilla(GetRutaPlantillaRequest request) {
        return service.getRutaPlantilla(request);
    }
    

    @POST
    @Path(value = "/getRutaPlantillaCheckPreconditions")
    public GetRutaPlantillaResponse solicitudNovedadGetRutaPlantillaCheckPreconditions(GetRutaPlantillaRequest request) {

        return service.getRutaPlantillaCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TCREAR")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TCREARResponse solicitudNovedadTCREAR(TCREARRequest request) {
        return service.tCREAR(request);
    }
    

    @POST
    @Path(value = "/TADDFAMILIA")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTADDFAMILIA(TADDFAMILIARequest request) {
        return service.tADDFAMILIA(request);
    }
    

    @POST
    @Path(value = "/TADDFAMILIACheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTADDFAMILIACheckPreconditions(TADDFAMILIARequest request) {

        return service.tADDFAMILIACheckPreconditions(request);
    }

    @POST
    @Path(value = "/TMARCARCOMPLETADA")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public TMARCARCOMPLETADAResponse solicitudNovedadTMARCARCOMPLETADA(TMARCARCOMPLETADARequest request) {
        return service.tMARCARCOMPLETADA(request);
    }
    

    @POST
    @Path(value = "/TMARCARCOMPLETADACheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public TMARCARCOMPLETADAResponse solicitudNovedadTMARCARCOMPLETADACheckPreconditions(TMARCARCOMPLETADARequest request) {

        return service.tMARCARCOMPLETADACheckPreconditions(request);
    }

    @POST
    @Path(value = "/TCHGNUEVAPERIODICIDAD")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTCHGNUEVAPERIODICIDAD(TCHGNUEVAPERIODICIDADRequest request) {
        return service.tCHGNUEVAPERIODICIDAD(request);
    }
    

    @POST
    @Path(value = "/TCHGNUEVAPERIODICIDADCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTCHGNUEVAPERIODICIDADCheckPreconditions(TCHGNUEVAPERIODICIDADRequest request) {

        return service.tCHGNUEVAPERIODICIDADCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TMARCARTRAMITADA")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public TMARCARTRAMITADAResponse solicitudNovedadTMARCARTRAMITADA(TMARCARTRAMITADARequest request) {
        return service.tMARCARTRAMITADA(request);
    }
    

    @POST
    @Path(value = "/TMARCARTRAMITADACheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public TMARCARTRAMITADAResponse solicitudNovedadTMARCARTRAMITADACheckPreconditions(TMARCARTRAMITADARequest request) {

        return service.tMARCARTRAMITADACheckPreconditions(request);
    }

    @POST
    @Path(value = "/TMARCARANULADA")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTMARCARANULADA(TMARCARANULADARequest request) {
        return service.tMARCARANULADA(request);
    }
    

    @POST
    @Path(value = "/TMARCARANULADACheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTMARCARANULADACheckPreconditions(TMARCARANULADARequest request) {

        return service.tMARCARANULADACheckPreconditions(request);
    }

    @POST
    @Path(value = "/TCREAREXCEPCION")
    @RolesAllowed({"Admin","SuperAdmin"})
    public TCREAREXCEPCIONResponse solicitudNovedadTCREAREXCEPCION(TCREAREXCEPCIONRequest request) {
        return service.tCREAREXCEPCION(request);
    }
    

    @POST
    @Path(value = "/TCAMBIARESTADODOC")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTCAMBIARESTADODOC(TCAMBIARESTADODOCRequest request) {
        return service.tCAMBIARESTADODOC(request);
    }
    

    @POST
    @Path(value = "/TREASIGNARUSUARIOS")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse solicitudNovedadTREASIGNARUSUARIOS(TREASIGNARUSUARIOSRequest request) {
        return service.tREASIGNARUSUARIOS(request);
    }
    

    @POST
    @Path(value = "/TFIRMAR")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","MesaDeApoyo"})
    public ServiceResponse solicitudNovedadTFIRMAR(TFIRMARRequest request) {
        return service.tFIRMAR(request);
    }
    

    @POST
    @Path(value = "/IIU_SolNovTipoContrato")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovTipoContrato iiuIIUSolNovTipoContrato(SolicitudNovedadOid oid) {
        return service.iIUSolNovTipoContrato(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovContratante")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovContratante iiuIIUSolNovContratante(SolicitudNovedadOid oid) {
        return service.iIUSolNovContratante(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovObservaciones")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovObservaciones iiuIIUSolNovObservaciones(SolicitudNovedadOid oid) {
        return service.iIUSolNovObservaciones(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovTipoTitular")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovTipoTitular iiuIIUSolNovTipoTitular(SolicitudNovedadOid oid) {
        return service.iIUSolNovTipoTitular(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovTipoUsuario")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovTipoUsuario iiuIIUSolNovTipoUsuario(SolicitudNovedadOid oid) {
        return service.iIUSolNovTipoUsuario(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovContratanteSL")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovContratante iiuIIUSolNovContratanteSL(SolicitudNovedadOid oid) {
        return service.iIUSolNovContratanteSL(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovContra_TipoTitular")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovContraTipoTitular iiuIIUSolNovContraTipoTitular(SolicitudNovedadOid oid) {
        return service.iIUSolNovContraTipoTitular(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovTipoContratoOBS")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovTipoContrato iiuIIUSolNovTipoContratoOBS(SolicitudNovedadOid oid) {
        return service.iIUSolNovTipoContratoOBS(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovContratanteOBS")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovContratante iiuIIUSolNovContratanteOBS(SolicitudNovedadOid oid) {
        return service.iIUSolNovContratanteOBS(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovObservacionesOBS")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovObservaciones iiuIIUSolNovObservacionesOBS(SolicitudNovedadOid oid) {
        return service.iIUSolNovObservacionesOBS(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovTipoTitularObs")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovTipoTitular iiuIIUSolNovTipoTitularObs(SolicitudNovedadOid oid) {
        return service.iIUSolNovTipoTitularObs(oid);
    }

    @POST
    @Path(value = "/IIU_SolNovTipoUsuarioObs")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSSolNovTipoUsuario iiuIIUSolNovTipoUsuarioObs(SolicitudNovedadOid oid) {
        return service.iIUSolNovTipoUsuarioObs(oid);
    }

    @POST
    @Path(value = "/PIU_ConsultaSolicitudNovedad")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUConsultaSolicitudNovedadResponse piuPIUConsultaSolicitudNovedad(PIUConsultaSolicitudNovedadRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUConsultaSolicitudNovedadResponse response;
        try
        {
            response = new PIUConsultaSolicitudNovedadResponse(service.piuPIUConsultaSolicitudNovedad(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUConsultaSolicitudNovedad(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUConsultaSolicitudNovedadResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_EstatusSolNov")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUEstatusSolNovResponse piuPIUEstatusSolNov(PIUEstatusSolNovRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUEstatusSolNovResponse response;
        try
        {
            response = new PIUEstatusSolNovResponse(service.piuPIUEstatusSolNov(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUEstatusSolNov(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUEstatusSolNovResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_EstatusSolNov_Afiliacion")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUEstatusSolNovAfiliacionResponse piuPIUEstatusSolNovAfiliacion(PIUEstatusSolNovAfiliacionRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUEstatusSolNovAfiliacionResponse response;
        try
        {
            response = new PIUEstatusSolNovAfiliacionResponse(service.piuPIUEstatusSolNovAfiliacion(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUEstatusSolNovAfiliacion(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUEstatusSolNovAfiliacionResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_EstatusSolNov_Asesor")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUEstatusSolNovAsesorResponse piuPIUEstatusSolNovAsesor(PIUEstatusSolNovAsesorRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUEstatusSolNovAsesorResponse response;
        try
        {
            response = new PIUEstatusSolNovAsesorResponse(service.piuPIUEstatusSolNovAsesor(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUEstatusSolNovAsesor(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUEstatusSolNovAsesorResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_SolicitudNovedad_Null")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUSolicitudNovedadNullResponse piuPIUSolicitudNovedadNull(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUSolicitudNovedadNullResponse response;
        try
        {
            response = new PIUSolicitudNovedadNullResponse(service.piuPIUSolicitudNovedadNull(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUSolicitudNovedadNull(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUSolicitudNovedadNullResponse();
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
