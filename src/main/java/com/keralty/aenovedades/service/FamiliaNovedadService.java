package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.MinCardinalityException;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.PreconditionException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.AsesorConstants;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.oid.DepartamentoOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.MunicipioOid;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;
import com.keralty.aenovedades.persistence.oid.NovedadMDOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Pais;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.repository.FamiliaNovedadJpaRepository;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aenovedades.utils.Utilities;
import com.keralty.aenovedades.viewmodel.FilterRequest;
import com.keralty.aenovedades.viewmodel.FilterVariableRequest;
import com.keralty.aenovedades.viewmodel.InstanceResponseViewModel;
import com.keralty.aenovedades.viewmodel.PopulationResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class FamiliaNovedadService extends AbstractService {

    FamiliaNovedadJpaRepository repository;

    FamiliaNovedadService familiaNovedadSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    FirmaService firmaSrv;

    SolicitudService solicitudSrv;

    UsuarioNovedadService usuarioNovedadSrv;

    PaisService paisSrv;

    DepartamentoService departamentoSrv;

    MunicipioService municipioSrv;

    NovedadMDService novedadMDSrv;

    NovedadCTService novedadCTSrv;

    ParentescoService parentescoSrv;

    DocumentoNovedadService documentoNovedadSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public FamiliaNovedadService(
            FamiliaNovedadService familiaNovedadSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            FirmaService firmaSrv,
            SolicitudService solicitudSrv,
            UsuarioNovedadService usuarioNovedadSrv,
            PaisService paisSrv,
            DepartamentoService departamentoSrv,
            MunicipioService municipioSrv,
            NovedadMDService novedadMDSrv,
            NovedadCTService novedadCTSrv,
            ParentescoService parentescoSrv,
            DocumentoNovedadService documentoNovedadSrv,
            UserFunctions userFunctionsSrv,
            FamiliaNovedadJpaRepository repository) {
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.firmaSrv = firmaSrv;
        this.solicitudSrv = solicitudSrv;
        this.usuarioNovedadSrv = usuarioNovedadSrv;
        this.paisSrv = paisSrv;
        this.departamentoSrv = departamentoSrv;
        this.municipioSrv = municipioSrv;
        this.novedadMDSrv = novedadMDSrv;
        this.novedadCTSrv = novedadCTSrv;
        this.parentescoSrv = parentescoSrv;
        this.documentoNovedadSrv = documentoNovedadSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, FamiliaNovedadConstants.CLASS_NAME);
    }

    private List<FamiliaNovedad> solveFamiliaNovedadTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, FamiliaNovedadConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveFamiliaNovedadTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, FamiliaNovedadConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class FamiliaNovedad
     *
     * @return Population of class FamiliaNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaNovedad> get() {
        List<FamiliaNovedad> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class FamiliaNovedad
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class FamiliaNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<FamiliaNovedad> instances = get(queryRequest);
        if(FamiliaNovedadConstants.DSDSFAMNOVTIPOTITULAR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSFamNovTipoTitular())).collect(Collectors.toList());
        }
        if(FamiliaNovedadConstants.DSDSFAMNOVTIPOUSUARIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSFamNovTipoUsuario())).collect(Collectors.toList());
        }
        if(FamiliaNovedadConstants.DSICFAMILIANOVEDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICFamiliaNovedad())).collect(Collectors.toList());
        }
        if(FamiliaNovedadConstants.DSDSFAMILIANOVEDADNULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSFamiliaNovedadNull())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class FamiliaNovedad that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class FamiliaNovedad matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaNovedad> get(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest);
    }
    
    /*
     * Returns the list of instances that matches certain search criteria
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return List of instances that matches certain search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public QueryResponse getDynamic(QueryRequest queryRequest) {
        if (queryRequest.getDisplaySetName() == null || queryRequest.getDisplaySetName().isEmpty()) {
            return new PopulationResponseViewModel(solveFamiliaNovedadTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveFamiliaNovedadTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveFamiliaNovedadTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
        }
    }

    /*
     * Returns the population of a class with a certain structure
     *
     * @param relatedInstanceJsonOid Json Oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @param displaySetItems DisplaySet items for each returned instance
     *
     * @return List of instances
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PopulationResponseViewModel getByRelatedDynamic(String relatedInstanceJsonOid, String relatedInstancePath, String displaySetItems) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid))));
        return new PopulationResponseViewModel(solveFamiliaNovedadTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of FamiliaNovedad by ID
     *
     * @param familiaNovedadidFamiliaNovedad Identification field familiaNovedadidFamiliaNovedad
     *
     * @return Instance of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaNovedad getById(Long familiaNovedadidFamiliaNovedad) {
        return getByOID(new FamiliaNovedadOid(familiaNovedadidFamiliaNovedad));
    }
    
    /*
     * Returns an instance of FamiliaNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaNovedad getByOID(FamiliaNovedadOid oid) {
        Optional<FamiliaNovedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of FamiliaNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public FamiliaNovedad getByOIDWithHV(FamiliaNovedadOid oid) {
        Optional<FamiliaNovedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<FamiliaNovedad> getInstanceByOid(FamiliaNovedadOid oid) {
        return oid != null && oid.getFamiliaNovedadidFamiliaNovedad() != null
               ? repository.findById(oid.getFamiliaNovedadidFamiliaNovedad())
               : Optional.empty();
    }

    /*
     * Returns an instance of FamiliaNovedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of FamiliaNovedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaNovedad getByJsonOid(String jsonOid) {
        FamiliaNovedadOid oid = new FamiliaNovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of FamiliaNovedad related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaNovedad> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveFamiliaNovedadTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of FamiliaNovedad related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaNovedad> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of FamiliaNovedad
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getFamiliaNovedadDynamic(FamiliaNovedadOid oid, String displaySetItems) {
        return new InstanceResponseViewModel(getByOIDWithHV(oid), displaySetItems);
    }

    /*
     * Returns the supplementary info for a given instance
     *
     * @param oid Instance OID
     *
     * @param dsName DisplaySet name
     *
     * @return Supplementary info for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String getSuppInfo(FamiliaNovedadOid oid, String dsName) {
        FamiliaNovedad instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(FamiliaNovedad instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (FamiliaNovedadConstants.DSICFAMILIANOVEDAD.equals(dsName))
            return instance.buildICFamiliaNovedad();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(FamiliaNovedad instance, String dsName) {
        if (FamiliaNovedadConstants.DSDSFAMNOVTIPOTITULAR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSFamNovTipoTitular());
        if (FamiliaNovedadConstants.DSDSFAMNOVTIPOUSUARIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSFamNovTipoUsuario());
        if (FamiliaNovedadConstants.DSICFAMILIANOVEDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICFamiliaNovedad());
        if (FamiliaNovedadConstants.DSDSFAMILIANOVEDADNULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSFamiliaNovedadNull());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUFamNovMTipoTitular
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FamiliaNovedad using displayset DSFamNovTipoTitular that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular> piuPIUFamNovMTipoTitular(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFamNovMTipoTitular
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFamNovMTipoTitular
     */
    public int getCount4PIUFamNovMTipoTitular(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFamNovMTipoUsuario
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FamiliaNovedad using displayset DSFamNovTipoTitular that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular> piuPIUFamNovMTipoUsuario(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFamNovMTipoUsuario
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFamNovMTipoUsuario
     */
    public int getCount4PIUFamNovMTipoUsuario(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFamiliaNovedadNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FamiliaNovedad using displayset DSFamiliaNovedadNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamiliaNovedadNull> piuPIUFamiliaNovedadNull(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamiliaNovedadNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFamiliaNovedadNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFamiliaNovedadNull
     */
    public int getCount4PIUFamiliaNovedadNull(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFamNovMTipoTitularObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FamiliaNovedad using displayset DSFamNovTipoTitular that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular> piuPIUFamNovMTipoTitularObs(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFamNovMTipoTitularObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFamNovMTipoTitularObs
     */
    public int getCount4PIUFamNovMTipoTitularObs(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFamNovMTipoUsuarioObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FamiliaNovedad using displayset DSFamNovTipoTitular that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular> piuPIUFamNovMTipoUsuarioObs(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.familianovedad.ds.DSFamNovTipoTitular::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFamNovMTipoUsuarioObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFamNovMTipoUsuarioObs
     */
    public int getCount4PIUFamNovMTipoUsuarioObs(QueryRequest queryRequest) {
        return solveFamiliaNovedadTypedQuery(queryRequest).size();
    }

    // Service: crear

    /*
     * Entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse crear(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.crearTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse crearTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.CrearRequest request) throws ModelException {
        request.setFamiliaNovedadcrearpagrSolicitudInstance(solicitudNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadcrearpagrSolicitud()));
        request.setFamiliaNovedadcrearpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFamiliaNovedadcrearpagrTipoIdentificacion()));
        request.setFamiliaNovedadcrearpagrFirmaInstance(firmaSrv.getByOIDWithHV(request.getFamiliaNovedadcrearpagrFirma()));
        return familiaNovedadSrv.crearImplementation(request);
    }

    /*
     * Implements service crear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse crearImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad familiaNovedadcrearpagrSolicitud = request.getFamiliaNovedadcrearpagrSolicitudInstance();
        TipoIdentificacion familiaNovedadcrearpagrTipoIdentificacion = request.getFamiliaNovedadcrearpagrTipoIdentificacionInstance();
        Firma familiaNovedadcrearpagrFirma = request.getFamiliaNovedadcrearpagrFirmaInstance();
        String familiaNovedadcrearpatrTitNumidentificacion = request.getFamiliaNovedadcrearpatrTitNumidentificacion();
        String familiaNovedadcrearpatrTitPrimerNombre = request.getFamiliaNovedadcrearpatrTitPrimerNombre();
        Boolean familiaNovedadcrearpatrTitTieneBeneficios = request.getFamiliaNovedadcrearpatrTitTieneBeneficios();
        String familiaNovedadcrearpatrTitSegundoNombre = request.getFamiliaNovedadcrearpatrTitSegundoNombre();
        String familiaNovedadcrearpatrTitPrimerApellido = request.getFamiliaNovedadcrearpatrTitPrimerApellido();
        String familiaNovedadcrearpatrTitSegundoApellido = request.getFamiliaNovedadcrearpatrTitSegundoApellido();
        Long familiaNovedadcrearpatrNumFamilia = request.getFamiliaNovedadcrearpatrNumFamilia();
        String familiaNovedadcrearpatrTitRazonSocial = request.getFamiliaNovedadcrearpatrTitRazonSocial();
        Boolean familiaNovedadcrearpatrFamActiva = request.getFamiliaNovedadcrearpatrFamActiva();

        request.checkArguments();
        FamiliaNovedad instance = new FamiliaNovedad();
        instance.add2Solicitud(familiaNovedadcrearpagrSolicitud);

        if (familiaNovedadcrearpagrTipoIdentificacion != null && !familiaNovedadcrearpagrTipoIdentificacion.isNull()) {
            instance.add2TipoIdentificacion(familiaNovedadcrearpagrTipoIdentificacion);
        }

        if (familiaNovedadcrearpagrFirma != null && !familiaNovedadcrearpagrFirma.isNull()) {
            familiaNovedadcrearpagrFirma.add2FamiliaNovedad(instance);
            instance.add2Firma(familiaNovedadcrearpagrFirma);
        }

        instance.setFamiliaNovedadidFamiliaNovedad(Long.valueOf(0));
        instance.setFamiliaNovedadTitNumidentificacion(familiaNovedadcrearpatrTitNumidentificacion);
        instance.setFamiliaNovedadTitPrimerNombre(familiaNovedadcrearpatrTitPrimerNombre);
        instance.setFamiliaNovedadTitTieneBeneficios(familiaNovedadcrearpatrTitTieneBeneficios);
        instance.setFamiliaNovedadTitSegundoNombre(familiaNovedadcrearpatrTitSegundoNombre);
        instance.setFamiliaNovedadTitPrimerApellido(familiaNovedadcrearpatrTitPrimerApellido);
        instance.setFamiliaNovedadTitSegundoApellido(familiaNovedadcrearpatrTitSegundoApellido);
        instance.setFamiliaNovedadNumFamilia(familiaNovedadcrearpatrNumFamilia);
        instance.setFamiliaNovedadTitRazonSocial(familiaNovedadcrearpatrTitRazonSocial);
        instance.setFamiliaNovedadFamActiva(familiaNovedadcrearpatrFamActiva);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: eliminar

    /*
     * Entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse eliminar(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.eliminarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse eliminarTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.EliminarRequest request) throws ModelException {
        request.setFamiliaNovedadeliminarpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadeliminarpthisFamiliaNovedad()));
        return familiaNovedadSrv.eliminarImplementation(request);
    }

    /*
     * Implements service eliminar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse eliminarImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadeliminarpthisFamiliaNovedad = request.getFamiliaNovedadeliminarpthisFamiliaNovedadInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadeliminarpthisFamiliaNovedad;
        if(familiaNovedadeliminarpthisFamiliaNovedad.getUsuarioNovedad().size() > 0) {
            throw new MinCardinalityException(FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ROLE_ALIAS_USUARIONOVEDAD);
        }
        if(familiaNovedadeliminarpthisFamiliaNovedad.getNovedadCT() != null && !familiaNovedadeliminarpthisFamiliaNovedad.getNovedadCT().isNull()) {
            throw new MinCardinalityException(FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ROLE_ALIAS_NOVEDADCT);
        }
        if(familiaNovedadeliminarpthisFamiliaNovedad.getNovedadMD() != null && !familiaNovedadeliminarpthisFamiliaNovedad.getNovedadMD().isNull()) {
            throw new MinCardinalityException(FamiliaNovedadConstants.CLASS_ALIAS, FamiliaNovedadConstants.ROLE_ALIAS_NOVEDADMD);
        }


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: InsTipoIdentificacion

    /*
     * Entry point for service InsTipoIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoIdentificacion(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsTipoIdentificacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.insTipoIdentificacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoIdentificacionTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsTipoIdentificacionRequest request) throws ModelException {
        request.setFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedad()));
        request.setFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacion()));
        return familiaNovedadSrv.insTipoIdentificacionImplementation(request, true);
    }

    /*
     * Implements service InsTipoIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoIdentificacionImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsTipoIdentificacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad = request.getFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance();
        TipoIdentificacion familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion = request.getFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad;

        instance.add2TipoIdentificacion(familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionRequest();
            relatedRequest.setTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance(familiaNovedadInsTipoIdentificacionpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance(familiaNovedadInsTipoIdentificacionpthisFamiliaNovedad);
            tipoIdentificacionSrv.insTipoIdentificacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: DelTipoIdentificacion

    /*
     * Entry point for service DelTipoIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoIdentificacion(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.DelTipoIdentificacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.delTipoIdentificacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoIdentificacionTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.DelTipoIdentificacionRequest request) throws ModelException {
        request.setFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedad()));
        request.setFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacion()));
        return familiaNovedadSrv.delTipoIdentificacionImplementation(request, true);
    }

    /*
     * Implements service DelTipoIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoIdentificacionImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.DelTipoIdentificacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad = request.getFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance();
        TipoIdentificacion familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion = request.getFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad;

        instance.add2TipoIdentificacion(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionRequest();
            relatedRequest.setTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance(familiaNovedadDelTipoIdentificacionpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance(familiaNovedadDelTipoIdentificacionpthisFamiliaNovedad);
            tipoIdentificacionSrv.delTipoIdentificacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: InsFirmaTitularFamiliaNovedad

    /*
     * Entry point for service InsFirmaTitularFamiliaNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insFirmaTitularFamiliaNovedad(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsFirmaTitularFamiliaNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.insFirmaTitularFamiliaNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsFirmaTitularFamiliaNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insFirmaTitularFamiliaNovedadTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsFirmaTitularFamiliaNovedadRequest request) throws ModelException {
        request.setFamiliaNovedadInsFirmaTitularFamiliaNovedadpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadInsFirmaTitularFamiliaNovedadpthisFamiliaNovedad()));
        request.setFamiliaNovedadInsFirmaTitularFamiliaNovedadpevcFirmaInstance(firmaSrv.getByOIDWithHV(request.getFamiliaNovedadInsFirmaTitularFamiliaNovedadpevcFirma()));
        return familiaNovedadSrv.insFirmaTitularFamiliaNovedadImplementation(request, true);
    }

    /*
     * Implements service InsFirmaTitularFamiliaNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insFirmaTitularFamiliaNovedadImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsFirmaTitularFamiliaNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadInsFirmaTitularFamiliaNovedadpthisFamiliaNovedad = request.getFamiliaNovedadInsFirmaTitularFamiliaNovedadpthisFamiliaNovedadInstance();
        Firma familiaNovedadInsFirmaTitularFamiliaNovedadpevcFirma = request.getFamiliaNovedadInsFirmaTitularFamiliaNovedadpevcFirmaInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadInsFirmaTitularFamiliaNovedadpthisFamiliaNovedad;

        instance.add2Firma(familiaNovedadInsFirmaTitularFamiliaNovedadpevcFirma);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.firma.siu.InsFirmaTitularFamiliaNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.firma.siu.InsFirmaTitularFamiliaNovedadRequest();
            relatedRequest.setFirmaInsFirmaTitularFamiliaNovedadpthisFirmaInstance(familiaNovedadInsFirmaTitularFamiliaNovedadpevcFirma);
            relatedRequest.setFirmaInsFirmaTitularFamiliaNovedadpevcFamiliaNovedadInstance(familiaNovedadInsFirmaTitularFamiliaNovedadpthisFamiliaNovedad);
            firmaSrv.insFirmaTitularFamiliaNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: DelFirmaTitulaFamiliaNovedad

    /*
     * Entry point for service DelFirmaTitulaFamiliaNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delFirmaTitulaFamiliaNovedad(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.DelFirmaTitulaFamiliaNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.delFirmaTitulaFamiliaNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelFirmaTitulaFamiliaNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delFirmaTitulaFamiliaNovedadTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.DelFirmaTitulaFamiliaNovedadRequest request) throws ModelException {
        request.setFamiliaNovedadDelFirmaTitulaFamiliaNovedadpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadDelFirmaTitulaFamiliaNovedadpthisFamiliaNovedad()));
        request.setFamiliaNovedadDelFirmaTitulaFamiliaNovedadpevcFirmaInstance(firmaSrv.getByOIDWithHV(request.getFamiliaNovedadDelFirmaTitulaFamiliaNovedadpevcFirma()));
        return familiaNovedadSrv.delFirmaTitulaFamiliaNovedadImplementation(request, true);
    }

    /*
     * Implements service DelFirmaTitulaFamiliaNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delFirmaTitulaFamiliaNovedadImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.DelFirmaTitulaFamiliaNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadDelFirmaTitulaFamiliaNovedadpthisFamiliaNovedad = request.getFamiliaNovedadDelFirmaTitulaFamiliaNovedadpthisFamiliaNovedadInstance();
        Firma familiaNovedadDelFirmaTitulaFamiliaNovedadpevcFirma = request.getFamiliaNovedadDelFirmaTitulaFamiliaNovedadpevcFirmaInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadDelFirmaTitulaFamiliaNovedadpthisFamiliaNovedad;

        instance.add2Firma(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.firma.siu.DelFirmaTitulaFamiliaNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.firma.siu.DelFirmaTitulaFamiliaNovedadRequest();
            relatedRequest.setFirmaDelFirmaTitulaFamiliaNovedadpthisFirmaInstance(familiaNovedadDelFirmaTitulaFamiliaNovedadpevcFirma);
            relatedRequest.setFirmaDelFirmaTitulaFamiliaNovedadpevcFamiliaNovedadInstance(familiaNovedadDelFirmaTitulaFamiliaNovedadpthisFamiliaNovedad);
            firmaSrv.delFirmaTitulaFamiliaNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: validarCF

    /*
     * Entry point for service validarCF
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarCF(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.validarCFTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarCF
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarCFTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest request) throws ModelException {
        request.setFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadvalidarCFpthisFamiliaNovedad()));
        return familiaNovedadSrv.validarCFImplementation(request);
    }

    /*
     * Implements service validarCF
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarCFImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadvalidarCFpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance();

        request.checkArguments();

        validarCFPreconditions(request);
        FamiliaNovedad instance = familiaNovedadvalidarCFpthisFamiliaNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    private void validarCFPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest request) 
            throws ModelException {
        checkClas1581424574464890Pre12(request);
        checkClas1581424574464890Pre13(request);
    }

    private void checkClas1581424574464890Pre12 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = FALSE)
        // OR Solicitud.CtrEsColectivo = TRUE

        FamiliaNovedad familiaNovedadvalidarCFpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || familiaNovedadvalidarCFpthisFamiliaNovedad.getSolicitud().getSolicitudNovedadCtrEsColectivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("La novedad requiere que el contrato sea colectivo");
    }

    private void checkClas1581424574464890Pre13 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = FALSE)
        // OR drvTieneUsuarioActivo = TRUE

        FamiliaNovedad familiaNovedadvalidarCFpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || familiaNovedadvalidarCFpthisFamiliaNovedad.getFamiliaNovedaddrvTieneUsuarioActivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Al menos un usuario de la familia debe estar activo. Compruebe familia: " + STDFunctions.intToStrFun(familiaNovedadvalidarCFpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
    }

    // Service: validarEU

    /*
     * Entry point for service validarEU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarEU(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.validarEUTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarEU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarEUTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest request) throws ModelException {
        request.setFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadvalidarEUpthisFamiliaNovedad()));
        return familiaNovedadSrv.validarEUImplementation(request);
    }

    /*
     * Implements service validarEU
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarEUImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadvalidarEUpthisFamiliaNovedad = request.getFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance();

        request.checkArguments();

        validarEUPreconditions(request);
        FamiliaNovedad instance = familiaNovedadvalidarEUpthisFamiliaNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    private void validarEUPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest request) 
            throws ModelException {
        checkClas1581424574464890Pre17(request);
        checkClas1581424574464890Pre16(request);
    }

    private void checkClas1581424574464890Pre17 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest request) 
            throws ModelException {
        // COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.Excluido = true) > 0

        FamiliaNovedad familiaNovedadvalidarEUpthisFamiliaNovedad = request.getFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator035(familiaNovedadvalidarEUpthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("La familia num: " + STDFunctions.intToStrFun(familiaNovedadvalidarEUpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()) + " no excluye a ningún usuario");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre16 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest request) 
            throws ModelException {
        // COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.drvEstaActivo = true AND UsuarioNovedad.Excluido = false) > 0

        FamiliaNovedad familiaNovedadvalidarEUpthisFamiliaNovedad = request.getFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator036(familiaNovedadvalidarEUpthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("La familia num: " + STDFunctions.intToStrFun(familiaNovedadvalidarEUpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()) + " no tiene usuarios activos");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    // Service: validarRO

    /*
     * Entry point for service validarRO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarRO(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.validarROTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarRO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarROTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest request) throws ModelException {
        request.setFamiliaNovedadvalidarROpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadvalidarROpthisFamiliaNovedad()));
        return familiaNovedadSrv.validarROImplementation(request);
    }

    /*
     * Implements service validarRO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarROImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadvalidarROpthisFamiliaNovedad = request.getFamiliaNovedadvalidarROpthisFamiliaNovedadInstance();

        request.checkArguments();

        validarROPreconditions(request);
        FamiliaNovedad instance = familiaNovedadvalidarROpthisFamiliaNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    private void validarROPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest request) 
            throws ModelException {
        checkClas1581424574464890Pre18(request);
        checkClas1581424574464890Pre22(request);
    }

    private void checkClas1581424574464890Pre18 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest request) 
            throws ModelException {
        // COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.ContratacionRO = true) > 0

        FamiliaNovedad familiaNovedadvalidarROpthisFamiliaNovedad = request.getFamiliaNovedadvalidarROpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator026(familiaNovedadvalidarROpthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("La familia num: " + STDFunctions.intToStrFun(familiaNovedadvalidarROpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()) + " no tiene ningún usuario con Contratación de rehabilitación oral");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre22 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest request) 
            throws ModelException {
        // COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.ContratacionRO = TRUE AND UsuarioNovedad.drvEstaActivo = FALSE) > 0

        FamiliaNovedad familiaNovedadvalidarROpthisFamiliaNovedad = request.getFamiliaNovedadvalidarROpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator028(familiaNovedadvalidarROpthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Los usuarios de la familia num: " + STDFunctions.intToStrFun(familiaNovedadvalidarROpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()) + " con Rehabilitación Oral deben estar activos");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    // Service: validarCP

    /*
     * Entry point for service validarCP
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarCP(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.validarCPTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarCP
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarCPTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest request) throws ModelException {
        request.setFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadvalidarCPpthisFamiliaNovedad()));
        return familiaNovedadSrv.validarCPImplementation(request);
    }

    /*
     * Implements service validarCP
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarCPImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadvalidarCPpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance();

        request.checkArguments();

        validarCPPreconditions(request);
        FamiliaNovedad instance = familiaNovedadvalidarCPpthisFamiliaNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    private void validarCPPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        checkClas1581424574464890Pre20(request);
        checkClas1581424574464890Pre21(request);
        checkClas1581424574464890Pre43(request);
    }

    private void checkClas1581424574464890Pre20 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = false) OR DrvValidarCP1 = true

        FamiliaNovedad familiaNovedadvalidarCPpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || familiaNovedadvalidarCPpthisFamiliaNovedad.getFamiliaNovedadDrvValidarCP1().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Los contratos con contratante Jurídico deben tener al menos un beneficiario con parentesco TITULAR activo");
    }

    private void checkClas1581424574464890Pre21 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        // COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.Parentesco.EsPadre = TRUE AND UsuarioNovedad.drvEdad - drvEdadUsuTitular < 10) = 0

        FamiliaNovedad familiaNovedadvalidarCPpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = (repository.assocOperator027(familiaNovedadvalidarCPpthisFamiliaNovedad)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("El titular debe tener por lo menos un diferencia de 10 años con la edad del beneficiario de parentesco PADRE");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre43 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        // COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.drvEsConyuge = TRUE AND UsuarioNovedad.drvEstaActivo = TRUE) <= 1

        FamiliaNovedad familiaNovedadvalidarCPpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator031(familiaNovedadvalidarCPpthisFamiliaNovedad) <= Long.valueOf(1);
            if (!preconditionHolds) throw new PreconditionException("Sólo puede existir un beneficiario con parentesco CONYUGE en estado activo");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    // Service: validarCT

    /*
     * Entry point for service validarCT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarCT(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.validarCTTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarCT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarCTTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) throws ModelException {
        request.setFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadvalidarCTpthisFamiliaNovedad()));
        return familiaNovedadSrv.validarCTImplementation(request);
    }

    /*
     * Implements service validarCT
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarCTImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadvalidarCTpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance();

        request.checkArguments();

        validarCTPreconditions(request);
        FamiliaNovedad instance = familiaNovedadvalidarCTpthisFamiliaNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    private void validarCTPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) 
            throws ModelException {
        checkClas1581424574464890Pre45(request);
        checkClas1581424574464890Pre46(request);
        checkClas1581424574464890Pre47(request);
        checkClas1581424574464890Pre26(request);
    }

    private void checkClas1581424574464890Pre45 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) 
            throws ModelException {
        // EXIST( NovedadCT ) = TRUE

        FamiliaNovedad familiaNovedadvalidarCTpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator032(familiaNovedadvalidarCTpthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Debe indicar los datos del nuevo titular para la familia num. " + STDFunctions.intToStrFun(familiaNovedadvalidarCTpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre46 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) 
            throws ModelException {
        // EXIST( NovedadCT.Firma ) = TRUE

        FamiliaNovedad familiaNovedadvalidarCTpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator033(familiaNovedadvalidarCTpthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Debe diligenciar la firma del nuevo titular para la familia num. " + STDFunctions.intToStrFun(familiaNovedadvalidarCTpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre47 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) 
            throws ModelException {
        // EXIST( Firma) = TRUE

        FamiliaNovedad familiaNovedadvalidarCTpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator034(familiaNovedadvalidarCTpthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Debe diligenciar la firma del titular actual de la familia num. " + STDFunctions.intToStrFun(familiaNovedadvalidarCTpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre26 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = false) OR DrvValidarCT1 = true

        FamiliaNovedad familiaNovedadvalidarCTpthisFamiliaNovedad = request.getFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || familiaNovedadvalidarCTpthisFamiliaNovedad.getFamiliaNovedadDrvValidarCT1().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El nuevo titular de la familia num. " + STDFunctions.intToStrFun(familiaNovedadvalidarCTpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()) + " no puede ser persona jurídica");
    }

    // Service: validarSU

    /*
     * Entry point for service validarSU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarSU(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarSURequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.validarSUTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarSU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarSUTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarSURequest request) throws ModelException {
        request.setFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadvalidarSUpthisFamiliaNovedad()));
        return familiaNovedadSrv.validarSUImplementation(request);
    }

    /*
     * Implements service validarSU
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarSUImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarSURequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadvalidarSUpthisFamiliaNovedad = request.getFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance();

        request.checkArguments();

        validarSUPreconditions(request);
        FamiliaNovedad instance = familiaNovedadvalidarSUpthisFamiliaNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    private void validarSUPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarSURequest request) 
            throws ModelException {
        checkClas1581424574464890Pre48(request);
    }

    private void checkClas1581424574464890Pre48 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarSURequest request) 
            throws ModelException {
        // COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.SUNumMeses <> NULL) > 0

        FamiliaNovedad familiaNovedadvalidarSUpthisFamiliaNovedad = request.getFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator037(familiaNovedadvalidarSUpthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("La familia num: " + STDFunctions.intToStrFun(familiaNovedadvalidarSUpthisFamiliaNovedad.getFamiliaNovedadNumFamilia()) + " no tiene ningún usuario suspendido");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    // Service: modificar

    /*
     * Entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificar(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.modificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ModificarRequest request) throws ModelException {
        request.setFamiliaNovedadmodificarpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadmodificarpthisFamiliaNovedad()));
        return familiaNovedadSrv.modificarImplementation(request);
    }

    /*
     * Implements service modificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadmodificarpthisFamiliaNovedad = request.getFamiliaNovedadmodificarpthisFamiliaNovedadInstance();
        String familiaNovedadmodificarpTitNumidentificacion = request.getFamiliaNovedadmodificarpTitNumidentificacion();
        String familiaNovedadmodificarpTitPrimerNombre = request.getFamiliaNovedadmodificarpTitPrimerNombre();
        String familiaNovedadmodificarpTitSegundoNombre = request.getFamiliaNovedadmodificarpTitSegundoNombre();
        String familiaNovedadmodificarpTitPrimerApellido = request.getFamiliaNovedadmodificarpTitPrimerApellido();
        String familiaNovedadmodificarpTitSegundoApellido = request.getFamiliaNovedadmodificarpTitSegundoApellido();
        Long familiaNovedadmodificarpNumFamilia = request.getFamiliaNovedadmodificarpNumFamilia();
        String familiaNovedadmodificarpTitRazonSocial = request.getFamiliaNovedadmodificarpTitRazonSocial();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadmodificarpthisFamiliaNovedad;
        instance.setFamiliaNovedadTitNumidentificacion(familiaNovedadmodificarpTitNumidentificacion);
        instance.setFamiliaNovedadTitPrimerNombre(familiaNovedadmodificarpTitPrimerNombre);
        instance.setFamiliaNovedadTitSegundoNombre(familiaNovedadmodificarpTitSegundoNombre);
        instance.setFamiliaNovedadTitPrimerApellido(familiaNovedadmodificarpTitPrimerApellido);
        instance.setFamiliaNovedadTitSegundoApellido(familiaNovedadmodificarpTitSegundoApellido);
        instance.setFamiliaNovedadNumFamilia(familiaNovedadmodificarpNumFamilia);
        instance.setFamiliaNovedadTitRazonSocial(familiaNovedadmodificarpTitRazonSocial);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: TCREARDESDECORE

    /*
     * Entry point for service TCREARDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECOREResponse tCREARDESDECORE(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECORERequest request) {
        com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECOREResponse response = new com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECOREResponse();
        try {
            response = familiaNovedadSrv.tCREARDESDECORETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECOREResponse tCREARDESDECORETxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECORERequest request) throws ModelException {
        request.setFamiliaNovedadTCREARDESDECOREptpagrSolicitudInstance(solicitudNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTCREARDESDECOREptpagrSolicitud()));
        request.setFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacion()));
        return familiaNovedadSrv.tCREARDESDECOREImplementation(request);
    }

    /*
     * Implements service TCREARDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECOREResponse tCREARDESDECOREImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECORERequest request) throws ModelException {
        com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECOREResponse response = new com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECOREResponse();
        SolicitudNovedad familiaNovedadTCREARDESDECOREptpagrSolicitud = request.getFamiliaNovedadTCREARDESDECOREptpagrSolicitudInstance();
        TipoIdentificacion familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion = request.getFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance();
        String familiaNovedadTCREARDESDECOREptpatrTitNumidentificacion = request.getFamiliaNovedadTCREARDESDECOREptpatrTitNumidentificacion();
        String familiaNovedadTCREARDESDECOREptpatrTitPrimerNombre = request.getFamiliaNovedadTCREARDESDECOREptpatrTitPrimerNombre();
        Boolean familiaNovedadTCREARDESDECOREptpatrTitTieneBeneficios = request.getFamiliaNovedadTCREARDESDECOREptpatrTitTieneBeneficios();
        String familiaNovedadTCREARDESDECOREptpatrTitSegundoNombre = request.getFamiliaNovedadTCREARDESDECOREptpatrTitSegundoNombre();
        String familiaNovedadTCREARDESDECOREptpatrTitPrimerApellido = request.getFamiliaNovedadTCREARDESDECOREptpatrTitPrimerApellido();
        String familiaNovedadTCREARDESDECOREptpatrTitSegundoApellido = request.getFamiliaNovedadTCREARDESDECOREptpatrTitSegundoApellido();
        Long familiaNovedadTCREARDESDECOREptpatrNumFamilia = request.getFamiliaNovedadTCREARDESDECOREptpatrNumFamilia();
        String familiaNovedadTCREARDESDECOREptpatrTitRazonSocial = request.getFamiliaNovedadTCREARDESDECOREptpatrTitRazonSocial();
        Boolean familiaNovedadTCREARDESDECOREptpatrFamActiva = request.getFamiliaNovedadTCREARDESDECOREptpatrFamActiva();

        request.checkArguments();
        FamiliaNovedad instance;

        com.keralty.aenovedades.viewmodel.familianovedad.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.CrearRequest();
        step1Request.setFamiliaNovedadcrearpagrSolicitudInstance(familiaNovedadTCREARDESDECOREptpagrSolicitud);
        step1Request.setFamiliaNovedadcrearpagrTipoIdentificacionInstance(familiaNovedadTCREARDESDECOREptpagrTipoIdentificacion);
        step1Request.setFamiliaNovedadcrearpagrFirmaInstance(null);
        step1Request.setFamiliaNovedadcrearpatrTitNumidentificacion(familiaNovedadTCREARDESDECOREptpatrTitNumidentificacion);
        step1Request.setFamiliaNovedadcrearpatrTitPrimerNombre(familiaNovedadTCREARDESDECOREptpatrTitPrimerNombre);
        step1Request.setFamiliaNovedadcrearpatrTitTieneBeneficios(familiaNovedadTCREARDESDECOREptpatrTitTieneBeneficios);
        step1Request.setFamiliaNovedadcrearpatrTitSegundoNombre(familiaNovedadTCREARDESDECOREptpatrTitSegundoNombre);
        step1Request.setFamiliaNovedadcrearpatrTitPrimerApellido(familiaNovedadTCREARDESDECOREptpatrTitPrimerApellido);
        step1Request.setFamiliaNovedadcrearpatrTitSegundoApellido(familiaNovedadTCREARDESDECOREptpatrTitSegundoApellido);
        step1Request.setFamiliaNovedadcrearpatrNumFamilia(familiaNovedadTCREARDESDECOREptpatrNumFamilia);
        step1Request.setFamiliaNovedadcrearpatrTitRazonSocial(familiaNovedadTCREARDESDECOREptpatrTitRazonSocial);
        step1Request.setFamiliaNovedadcrearpatrFamActiva(familiaNovedadTCREARDESDECOREptpatrFamActiva);
        instance = (FamiliaNovedad) familiaNovedadSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        // Value expressions for outgoing argument 'familiaNovedadTCREARDESDECOREoaFamiliaNovedad'
        // DEFAULT  : THIS
        response.setFamiliaNovedadTCREARDESDECOREoaFamiliaNovedadInstance(instance);


        return response;
    }

    // Service: TFIRMARTITULAR

    /*
     * Entry point for service TFIRMARTITULAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tFIRMARTITULAR(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARTITULARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tFIRMARTITULARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TFIRMARTITULAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tFIRMARTITULARTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARTITULARRequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedad()));
        return familiaNovedadSrv.tFIRMARTITULARImplementation(request);
    }

    /*
     * Implements service TFIRMARTITULAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tFIRMARTITULARImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARTITULARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        byte[] familiaNovedadTFIRMARTITULARptpatrImagenFirma = request.getFamiliaNovedadTFIRMARTITULARptpatrImagenFirma();
        String familiaNovedadTFIRMARTITULARptpatrLatitud = request.getFamiliaNovedadTFIRMARTITULARptpatrLatitud();
        String familiaNovedadTFIRMARTITULARptpatrLongitud = request.getFamiliaNovedadTFIRMARTITULARptpatrLongitud();
        FamiliaNovedad familiaNovedadTFIRMARTITULARpthisFamiliaNovedad = request.getFamiliaNovedadTFIRMARTITULARpthisFamiliaNovedadInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadTFIRMARTITULARpthisFamiliaNovedad;

        /* Action 1: IF (EXIST (Firma) = false) */
        boolean ifCondition1 = repository.assocOperator039(familiaNovedadTFIRMARTITULARpthisFamiliaNovedad).equals(false);
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.firma.siu.TCREARTITFAMNOVRequest step10Request = new com.keralty.aenovedades.viewmodel.firma.siu.TCREARTITFAMNOVRequest();
            step10Request.setFirmaTCREARTITFAMNOVptpatrImagenFirma(familiaNovedadTFIRMARTITULARptpatrImagenFirma);
            step10Request.setFirmaTCREARTITFAMNOVptpatrLatitud(familiaNovedadTFIRMARTITULARptpatrLatitud);
            step10Request.setFirmaTCREARTITFAMNOVptpatrLongitud(familiaNovedadTFIRMARTITULARptpatrLongitud);
            step10Request.setFirmaTCREARTITFAMNOVptFamiliaNovedadInstance(familiaNovedadTFIRMARTITULARpthisFamiliaNovedad);
            firmaSrv.tCREARTITFAMNOVImplementation(step10Request);
        } else {
            com.keralty.aenovedades.viewmodel.firma.siu.ModificarRequest step11Request = new com.keralty.aenovedades.viewmodel.firma.siu.ModificarRequest();
            step11Request.setFirmamodificarpthisFirmaInstance(familiaNovedadTFIRMARTITULARpthisFamiliaNovedad.getFirma());
            step11Request.setFirmamodificarpImagenFirma(familiaNovedadTFIRMARTITULARptpatrImagenFirma);
            step11Request.setFirmamodificarpLatitud(familiaNovedadTFIRMARTITULARptpatrLatitud);
            step11Request.setFirmamodificarpLongitud(familiaNovedadTFIRMARTITULARptpatrLongitud);
            firmaSrv.modificarImplementation(step11Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: TMARCARCOMPLETADA

    /*
     * Entry point for service TMARCARCOMPLETADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMARCARCOMPLETADA(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tMARCARCOMPLETADATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMARCARCOMPLETADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMARCARCOMPLETADATxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedad()));
        return familiaNovedadSrv.tMARCARCOMPLETADAImplementation(request);
    }

    /*
     * Implements service TMARCARCOMPLETADA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMARCARCOMPLETADAImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();

        request.checkArguments();

        tMARCARCOMPLETADAPreconditions(request);
        FamiliaNovedad instance = familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad;

        /* Action 1: IF (Solicitud.Novedad.AliasNovedad = "CF") */
        boolean ifCondition1 = (familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CF");
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest step10Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCFRequest();
            step10Request.setFamiliaNovedadvalidarCFpthisFamiliaNovedadInstance(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad);
            familiaNovedadSrv.validarCFImplementation(step10Request);
        }

        /* Action 2: IF (Solicitud.Novedad.AliasNovedad = "EU") */
        boolean ifCondition2 = (familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("EU");
        if (ifCondition2) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest step20Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarEURequest();
            step20Request.setFamiliaNovedadvalidarEUpthisFamiliaNovedadInstance(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad);
            familiaNovedadSrv.validarEUImplementation(step20Request);
        }

        /* Action 3: IF (Solicitud.Novedad.AliasNovedad = "SU") */
        boolean ifCondition3 = (familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("SU");
        if (ifCondition3) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarSURequest step30Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarSURequest();
            step30Request.setFamiliaNovedadvalidarSUpthisFamiliaNovedadInstance(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad);
            familiaNovedadSrv.validarSUImplementation(step30Request);
        }

        /* Action 4: IF (Solicitud.Novedad.AliasNovedad = "RO" AND Solicitud.Novedad.TipoNovedad.Tipo = 2) */
        boolean ifCondition4 = (familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("RO") && (familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getTipoNovedad().getTipoNovedadTipo()).equals(Long.valueOf(2));
        if (ifCondition4) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest step40Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarRORequest();
            step40Request.setFamiliaNovedadvalidarROpthisFamiliaNovedadInstance(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad);
            familiaNovedadSrv.validarROImplementation(step40Request);
        }

        /* Action 5: IF (Solicitud.Novedad.AliasNovedad = "CT") */
        boolean ifCondition5 = (familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CT");
        if (ifCondition5) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest step50Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCTRequest();
            step50Request.setFamiliaNovedadvalidarCTpthisFamiliaNovedadInstance(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad);
            familiaNovedadSrv.validarCTImplementation(step50Request);
        }

        /* Action 6: IF (Solicitud.Novedad.AliasNovedad = "CP") */
        boolean ifCondition6 = (familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CP");
        if (ifCondition6) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest step60Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.ValidarCPRequest();
            step60Request.setFamiliaNovedadvalidarCPpthisFamiliaNovedadInstance(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad);
            familiaNovedadSrv.validarCPImplementation(step60Request);
        }

        for(UsuarioNovedad step7Entity : repository.assocOperator040(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad)) {
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest step7Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest();
            step7Request.setUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance(step7Entity);
            usuarioNovedadSrv.validarCPImplementation(step7Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    private void tMARCARCOMPLETADAPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        checkClas1581424574464890Pre11(request);
        checkClas1581424574464890Pre10(request);
        checkClas1581424574464890Pre23(request);
        checkClas1581424574464890Pre24(request);
        checkClas1581424574464890Pre4(request);
        checkClas1581424574464890Pre5(request);
        checkClas1581424574464890Pre6(request);
        checkClas1581424574464890Pre7(request);
        checkClas1581424574464890Pre8(request);
        checkClas1581424574464890Pre9(request);
    }

    private void checkClas1581424574464890Pre11 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.DrvExigeFamiliaActiva = false OR FamActiva = true

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        boolean preconditionHolds = familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getSolicitudNovedadDrvExigeFamiliaActiva().equals(false) || familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadFamActiva().equals(true);
        if (!preconditionHolds) throw new PreconditionException("La novedad requiere que la familia num. " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()) + " esté activa");
    }

    private void checkClas1581424574464890Pre10 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "CP" OR EXIST( UsuarioNovedad.ParentescoNuevo ) = true

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CP") || repository.assocOperator025(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo CP es necesario indicar el nuevo parentesco para algún usuario de la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre23 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "PS" OR COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.ProrrogaSuspension = true) > 0

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("PS") || repository.assocOperator029(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Es necesario indicar el menos un usuario con prorroga de suspensión en la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre24 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "AS" OR COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.ActivacionSuspension = true) > 0

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("AS") || repository.assocOperator030(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Es necesario indicar el menos un usuario con activación de suspensión en la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre4 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "CD" OR COUNT( UsuarioNovedad.TipoIdentificacionCD ) > 0

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CD") || repository.assocOperator019(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo CD es necesario indicar el nuevo tipo de identificación para algún usuario de la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre5 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "CD" OR COUNT( UsuarioNovedad ) WHERE (UsuarioNovedad.NumIdentificacionCD <> NULL) > 0

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CD") || repository.assocOperator020(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo CD es necesario indicar el nuevo número de identificación para algún usuario de la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre6 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "CT" OR EXIST( NovedadCT ) = true

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CT") || repository.assocOperator021(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo CT es necesario indicar el nuevo titular de la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre7 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "CT" OR EXIST( Firma ) = true

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CT") || repository.assocOperator022(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo CT es necesario proporcionar la firma del titular de la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre8 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "CT" OR EXIST( NovedadCT.Firma ) = true

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CT") || repository.assocOperator023(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo CT es necesario proporcionar la firma del nuevo titular de la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581424574464890Pre9 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad <> "MD" OR EXIST( NovedadMD ) = true

        FamiliaNovedad familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad = request.getFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance();
        try {
            boolean preconditionHolds = !(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("MD") || repository.assocOperator024(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo MD es necesario proporcionar la la nueva dirección de correspondencia del titular de la familia num: " + STDFunctions.intToStrFun(familiaNovedadTMARCARCOMPLETADApthisFamiliaNovedad.getFamiliaNovedadNumFamilia()));
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    // Service: TSETDIRCORR

    /*
     * Entry point for service TSETDIRCORR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tSETDIRCORR(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tSETDIRCORRTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TSETDIRCORR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tSETDIRCORRTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedad()));
        request.setFamiliaNovedadTSETDIRCORRptpagrPaisInstance(paisSrv.getByOIDWithHV(request.getFamiliaNovedadTSETDIRCORRptpagrPais()));
        request.setFamiliaNovedadTSETDIRCORRptpagrDepartamentoInstance(departamentoSrv.getByOIDWithHV(new DepartamentoOid().fromJsonString(request.getFamiliaNovedadTSETDIRCORRptpagrDepartamento())));
        request.setFamiliaNovedadTSETDIRCORRptpagrMunicipioInstance(municipioSrv.getByOIDWithHV(new MunicipioOid().fromJsonString(request.getFamiliaNovedadTSETDIRCORRptpagrMunicipio())));
        return familiaNovedadSrv.tSETDIRCORRImplementation(request);
    }

    /*
     * Implements service TSETDIRCORR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tSETDIRCORRImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Pais familiaNovedadTSETDIRCORRptpagrPais = request.getFamiliaNovedadTSETDIRCORRptpagrPaisInstance();
        Departamento familiaNovedadTSETDIRCORRptpagrDepartamento = request.getFamiliaNovedadTSETDIRCORRptpagrDepartamentoInstance();
        Municipio familiaNovedadTSETDIRCORRptpagrMunicipio = request.getFamiliaNovedadTSETDIRCORRptpagrMunicipioInstance();
        String familiaNovedadTSETDIRCORRptpatrDireccionCompleta = request.getFamiliaNovedadTSETDIRCORRptpatrDireccionCompleta();
        Boolean familiaNovedadTSETDIRCORRptpatrRural = request.getFamiliaNovedadTSETDIRCORRptpatrRural();
        String familiaNovedadTSETDIRCORRptpatrTelefonoFijo = request.getFamiliaNovedadTSETDIRCORRptpatrTelefonoFijo();
        String familiaNovedadTSETDIRCORRptpatrTelefonoCelular = request.getFamiliaNovedadTSETDIRCORRptpatrTelefonoCelular();
        String familiaNovedadTSETDIRCORRptpatrCorreoElectronico = request.getFamiliaNovedadTSETDIRCORRptpatrCorreoElectronico();
        FamiliaNovedad familiaNovedadTSETDIRCORRpthisFamiliaNovedad = request.getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance();

        request.checkArguments();

        tSETDIRCORRPreconditions(request);
        FamiliaNovedad instance = familiaNovedadTSETDIRCORRpthisFamiliaNovedad;

        for(NovedadMD step1Entity : repository.assocOperator041(familiaNovedadTSETDIRCORRpthisFamiliaNovedad)) {
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TDELETERequest step1Request = new com.keralty.aenovedades.viewmodel.novedadmd.siu.TDELETERequest();
            step1Request.setNovedadMDTDELETEpthisNovedadMDInstance(step1Entity);
            novedadMDSrv.tDELETEImplementation(step1Request);
        }

        com.keralty.aenovedades.viewmodel.novedadmd.siu.TCREARRequest step2Request = new com.keralty.aenovedades.viewmodel.novedadmd.siu.TCREARRequest();
        step2Request.setNovedadMDTCREARptpagrFamiliaNovedadInstance(familiaNovedadTSETDIRCORRpthisFamiliaNovedad);
        step2Request.setNovedadMDTCREARptpagrPaisInstance(familiaNovedadTSETDIRCORRptpagrPais);
        step2Request.setNovedadMDTCREARptpagrDepartamentoInstance(familiaNovedadTSETDIRCORRptpagrDepartamento);
        step2Request.setNovedadMDTCREARptpagrMunicipioInstance(familiaNovedadTSETDIRCORRptpagrMunicipio);
        step2Request.setNovedadMDTCREARptpatrDireccionCompleta(familiaNovedadTSETDIRCORRptpatrDireccionCompleta);
        step2Request.setNovedadMDTCREARptpatrRural(familiaNovedadTSETDIRCORRptpatrRural);
        step2Request.setNovedadMDTCREARptpatrTelefonoFijo(familiaNovedadTSETDIRCORRptpatrTelefonoFijo);
        step2Request.setNovedadMDTCREARptpatrTelefonoCelular(familiaNovedadTSETDIRCORRptpatrTelefonoCelular);
        step2Request.setNovedadMDTCREARptpatrCorreoElectronico(familiaNovedadTSETDIRCORRptpatrCorreoElectronico);
        novedadMDSrv.tCREARImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    /*
     * Checks service TSETDIRCORR preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tSETDIRCORRCheckPreconditions(com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedad()));
        request.setFamiliaNovedadTSETDIRCORRptpagrPaisInstance(paisSrv.getByOIDWithHV(request.getFamiliaNovedadTSETDIRCORRptpagrPais()));
        request.setFamiliaNovedadTSETDIRCORRptpagrDepartamentoInstance(departamentoSrv.getByOIDWithHV(new DepartamentoOid().fromJsonString(request.getFamiliaNovedadTSETDIRCORRptpagrDepartamento())));
        request.setFamiliaNovedadTSETDIRCORRptpagrMunicipioInstance(municipioSrv.getByOIDWithHV(new MunicipioOid().fromJsonString(request.getFamiliaNovedadTSETDIRCORRptpagrMunicipio())));
        try {
            if("Clas_1581424574464890Pre_28".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre28(request);
            if("Clas_1581424574464890Pre_39".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre39(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tSETDIRCORRPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest request) 
            throws ModelException {
        checkClas1581424574464890Pre28(request);
        checkClas1581424574464890Pre39(request);
    }

    private void checkClas1581424574464890Pre28 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest request) 
            throws ModelException {
        // FamActiva = TRUE

        FamiliaNovedad familiaNovedadTSETDIRCORRpthisFamiliaNovedad = request.getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance();
        boolean preconditionHolds = familiaNovedadTSETDIRCORRpthisFamiliaNovedad.getFamiliaNovedadFamActiva().equals(true);
        if (!preconditionHolds) throw new PreconditionException("La familia debe estgar activa");
    }

    private void checkClas1581424574464890Pre39 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TSETDIRCORRRequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad = "MD"

        FamiliaNovedad familiaNovedadTSETDIRCORRpthisFamiliaNovedad = request.getFamiliaNovedadTSETDIRCORRpthisFamiliaNovedadInstance();
        boolean preconditionHolds = (familiaNovedadTSETDIRCORRpthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("MD");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de modificación de dirección de correspondencia");
    }

    // Service: TADDTITULAR

    /*
     * Entry point for service TADDTITULAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tADDTITULAR(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tADDTITULARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TADDTITULAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tADDTITULARTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTADDTITULARpthisFamiliaNovedad()));
        request.setFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrTipoIdentificacion())));
        request.setFamiliaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance(departamentoSrv.getByOIDWithHV(new DepartamentoOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrDepartamentoNacimiento())));
        request.setFamiliaNovedadTADDTITULARptpagrMunicipioNacimientoInstance(municipioSrv.getByOIDWithHV(new MunicipioOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrMunicipioNacimiento())));
        request.setFamiliaNovedadTADDTITULARptpagrDepartamentoInstance(departamentoSrv.getByOIDWithHV(new DepartamentoOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrDepartamento())));
        request.setFamiliaNovedadTADDTITULARptpagrMunicipioInstance(municipioSrv.getByOIDWithHV(new MunicipioOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrMunicipio())));
        request.setFamiliaNovedadTADDTITULARptpagrPaisInstance(paisSrv.getByOIDWithHV(request.getFamiliaNovedadTADDTITULARptpagrPais()));
        request.setFamiliaNovedadTADDTITULARptUsuExistenteInstance(usuarioNovedadSrv.getByOIDWithHV(new UsuarioNovedadOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptUsuExistente())));
        return familiaNovedadSrv.tADDTITULARImplementation(request);
    }

    /*
     * Implements service TADDTITULAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tADDTITULARImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion = request.getFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance();
        Municipio familiaNovedadTADDTITULARptpagrMunicipioNacimiento = request.getFamiliaNovedadTADDTITULARptpagrMunicipioNacimientoInstance();
        Municipio familiaNovedadTADDTITULARptpagrMunicipio = request.getFamiliaNovedadTADDTITULARptpagrMunicipioInstance();
        Departamento familiaNovedadTADDTITULARptpagrDepartamentoNacimiento = request.getFamiliaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance();
        Departamento familiaNovedadTADDTITULARptpagrDepartamento = request.getFamiliaNovedadTADDTITULARptpagrDepartamentoInstance();
        Pais familiaNovedadTADDTITULARptpagrPais = request.getFamiliaNovedadTADDTITULARptpagrPaisInstance();
        String familiaNovedadTADDTITULARptpatrNumIdentificacion = request.getFamiliaNovedadTADDTITULARptpatrNumIdentificacion();
        String familiaNovedadTADDTITULARptpatrPrimerNombre = request.getFamiliaNovedadTADDTITULARptpatrPrimerNombre();
        String familiaNovedadTADDTITULARptpatrSegundoNombre = request.getFamiliaNovedadTADDTITULARptpatrSegundoNombre();
        String familiaNovedadTADDTITULARptpatrPrimerApellido = request.getFamiliaNovedadTADDTITULARptpatrPrimerApellido();
        String familiaNovedadTADDTITULARptpatrSegundoApellido = request.getFamiliaNovedadTADDTITULARptpatrSegundoApellido();
        String familiaNovedadTADDTITULARptRazonSocial = request.getFamiliaNovedadTADDTITULARptRazonSocial();
        Date familiaNovedadTADDTITULARptpatrFechaNacimiento = request.getFamiliaNovedadTADDTITULARptpatrFechaNacimiento();
        String familiaNovedadTADDTITULARptpatrGenero = request.getFamiliaNovedadTADDTITULARptpatrGenero();
        Boolean familiaNovedadTADDTITULARptpatrIndicadorExtranjero = request.getFamiliaNovedadTADDTITULARptpatrIndicadorExtranjero();
        String familiaNovedadTADDTITULARptpatrTelefonoFijo = request.getFamiliaNovedadTADDTITULARptpatrTelefonoFijo();
        String familiaNovedadTADDTITULARptpatrTelefonoCelular = request.getFamiliaNovedadTADDTITULARptpatrTelefonoCelular();
        String familiaNovedadTADDTITULARptpatrCorreoElectronico = request.getFamiliaNovedadTADDTITULARptpatrCorreoElectronico();
        String familiaNovedadTADDTITULARptpatrDireccionCompleta = request.getFamiliaNovedadTADDTITULARptpatrDireccionCompleta();
        Boolean familiaNovedadTADDTITULARptpatrRural = request.getFamiliaNovedadTADDTITULARptpatrRural();
        Long familiaNovedadTADDTITULARptpCodigo = request.getFamiliaNovedadTADDTITULARptpCodigo();
        FamiliaNovedad familiaNovedadTADDTITULARpthisFamiliaNovedad = request.getFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance();

        request.checkArguments();

        tADDTITULARPreconditions(request);
        FamiliaNovedad instance = familiaNovedadTADDTITULARpthisFamiliaNovedad;

        for(NovedadCT step1Entity : repository.assocOperator042(familiaNovedadTADDTITULARpthisFamiliaNovedad)) {
            com.keralty.aenovedades.viewmodel.novedadct.siu.TDELETERequest step1Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.TDELETERequest();
            step1Request.setNovedadCTTDELETEpthisNovedadCTInstance(step1Entity);
            novedadCTSrv.tDELETEImplementation(step1Request);
        }

        com.keralty.aenovedades.viewmodel.novedadct.siu.TCREARRequest step2Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.TCREARRequest();
        step2Request.setNovedadCTTCREARptpagrFamiliaNovedadInstance(familiaNovedadTADDTITULARpthisFamiliaNovedad);
        step2Request.setNovedadCTTCREARptpagrTipoIdentificacionInstance(familiaNovedadTADDTITULARptpagrTipoIdentificacion);
        step2Request.setNovedadCTTCREARptpagrMunicipioNacInstance(familiaNovedadTADDTITULARptpagrMunicipioNacimiento);
        step2Request.setNovedadCTTCREARptpagrMunicipioResInstance(familiaNovedadTADDTITULARptpagrMunicipio);
        step2Request.setNovedadCTTCREARptpagrDepartamentoNacInstance(familiaNovedadTADDTITULARptpagrDepartamentoNacimiento);
        step2Request.setNovedadCTTCREARptpagrDepartamentoResInstance(familiaNovedadTADDTITULARptpagrDepartamento);
        step2Request.setNovedadCTTCREARptpagrPaisInstance(familiaNovedadTADDTITULARptpagrPais);
        step2Request.setNovedadCTTCREARptpatrTitNumidentificacion(familiaNovedadTADDTITULARptpatrNumIdentificacion);
        step2Request.setNovedadCTTCREARptpatrTitPrimerNombre(familiaNovedadTADDTITULARptpatrPrimerNombre);
        step2Request.setNovedadCTTCREARptpatrTitTieneBeneficios(repository.assocOperator046(familiaNovedadTADDTITULARpthisFamiliaNovedad, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion));
        step2Request.setNovedadCTTCREARptpatrTitSegundoNombre(familiaNovedadTADDTITULARptpatrSegundoNombre);
        step2Request.setNovedadCTTCREARptpatrTitPrimerApellido(familiaNovedadTADDTITULARptpatrPrimerApellido);
        step2Request.setNovedadCTTCREARptpatrTitSegundoApellido(familiaNovedadTADDTITULARptpatrSegundoApellido);
        step2Request.setNovedadCTTCREARptpatrTitRazonSocial(familiaNovedadTADDTITULARptRazonSocial);
        step2Request.setNovedadCTTCREARptpatrFechaNacimiento(familiaNovedadTADDTITULARptpatrFechaNacimiento);
        step2Request.setNovedadCTTCREARptpatrGenero(familiaNovedadTADDTITULARptpatrGenero);
        step2Request.setNovedadCTTCREARptpatrIndicadorExtranjero(familiaNovedadTADDTITULARptpatrIndicadorExtranjero);
        step2Request.setNovedadCTTCREARptpatrTelefonoFijo(familiaNovedadTADDTITULARptpatrTelefonoFijo);
        step2Request.setNovedadCTTCREARptpatrTelefonoCelular(familiaNovedadTADDTITULARptpatrTelefonoCelular);
        step2Request.setNovedadCTTCREARptpatrCorreoElectronico(familiaNovedadTADDTITULARptpatrCorreoElectronico);
        step2Request.setNovedadCTTCREARptpatrDireccionCompleta(familiaNovedadTADDTITULARptpatrDireccionCompleta);
        step2Request.setNovedadCTTCREARptpatrRural(familiaNovedadTADDTITULARptpatrRural);
        step2Request.setNovedadCTTCREARptpatrCodigoCORE(familiaNovedadTADDTITULARptpCodigo);
        novedadCTSrv.tCREARImplementation(step2Request);

        for(UsuarioNovedad step3Entity : repository.assocOperator044(familiaNovedadTADDTITULARpthisFamiliaNovedad, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion)) {
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest step3Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest();
            step3Request.setUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance(step3Entity);
            step3Request.setUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance(userFunctionsSrv.fugetParentescoTitularFun());
            usuarioNovedadSrv.tCAMBIARPARENTESCOImplementation(step3Request);
        }

        /* Action 4: IF (ptpCodigo <> NULL AND COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.TipoIdentificacion = ptpagrTipoIdentificacion AND UsuarioNovedad.NumIdentificacion = ptpatrNumIdentificacion) > 0) */
        boolean ifCondition4 = familiaNovedadTADDTITULARptpCodigo != null && repository.assocOperator047(familiaNovedadTADDTITULARpthisFamiliaNovedad, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion) > Long.valueOf(0);
        if (ifCondition4) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDOCNUMIDSIEXISTERequest step40Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDOCNUMIDSIEXISTERequest();
            step40Request.setFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance(familiaNovedadTADDTITULARpthisFamiliaNovedad);
            step40Request.setFamiliaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion(familiaNovedadTADDTITULARptpatrNumIdentificacion);
            familiaNovedadSrv.tCREARDOCNUMIDSIEXISTEImplementation(step40Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    /*
     * Checks service TADDTITULAR preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tADDTITULARCheckPreconditions(com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTADDTITULARpthisFamiliaNovedad()));
        request.setFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrTipoIdentificacion())));
        request.setFamiliaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance(departamentoSrv.getByOIDWithHV(new DepartamentoOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrDepartamentoNacimiento())));
        request.setFamiliaNovedadTADDTITULARptpagrMunicipioNacimientoInstance(municipioSrv.getByOIDWithHV(new MunicipioOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrMunicipioNacimiento())));
        request.setFamiliaNovedadTADDTITULARptpagrDepartamentoInstance(departamentoSrv.getByOIDWithHV(new DepartamentoOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrDepartamento())));
        request.setFamiliaNovedadTADDTITULARptpagrMunicipioInstance(municipioSrv.getByOIDWithHV(new MunicipioOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptpagrMunicipio())));
        request.setFamiliaNovedadTADDTITULARptpagrPaisInstance(paisSrv.getByOIDWithHV(request.getFamiliaNovedadTADDTITULARptpagrPais()));
        request.setFamiliaNovedadTADDTITULARptUsuExistenteInstance(usuarioNovedadSrv.getByOIDWithHV(new UsuarioNovedadOid().fromJsonString(request.getFamiliaNovedadTADDTITULARptUsuExistente())));
        try {
            if("Clas_1581424574464890Pre_38".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre38(request);
            if("Clas_1581424574464890Pre_37".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre37(request);
            if("Clas_1581424574464890Pre_30".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre30(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tADDTITULARPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) 
            throws ModelException {
        checkClas1581424574464890Pre38(request);
        checkClas1581424574464890Pre37(request);
        checkClas1581424574464890Pre30(request);
    }

    private void checkClas1581424574464890Pre38 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) 
            throws ModelException {
        // FamActiva = TRUE

        FamiliaNovedad familiaNovedadTADDTITULARpthisFamiliaNovedad = request.getFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance();
        boolean preconditionHolds = familiaNovedadTADDTITULARpthisFamiliaNovedad.getFamiliaNovedadFamActiva().equals(true);
        if (!preconditionHolds) throw new PreconditionException("La familia debe estar activa");
    }

    private void checkClas1581424574464890Pre37 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) 
            throws ModelException {
        // Solicitud.Novedad.AliasNovedad = "CT"

        FamiliaNovedad familiaNovedadTADDTITULARpthisFamiliaNovedad = request.getFamiliaNovedadTADDTITULARpthisFamiliaNovedadInstance();
        boolean preconditionHolds = (familiaNovedadTADDTITULARpthisFamiliaNovedad.getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CT");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de camboi de titular");
    }

    private void checkClas1581424574464890Pre30 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TADDTITULARRequest request) 
            throws ModelException {
        // ptpagrTipoIdentificacion.NIT = true OR ptpatrIndicadorExtranjero = true OR (ptpagrDepartamentoNacimiento <> NULL AND ptpagrMunicipioNacimiento <> NULL)

        TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion = request.getFamiliaNovedadTADDTITULARptpagrTipoIdentificacionInstance();
        Boolean familiaNovedadTADDTITULARptpatrIndicadorExtranjero = request.getFamiliaNovedadTADDTITULARptpatrIndicadorExtranjero();
        Departamento familiaNovedadTADDTITULARptpagrDepartamentoNacimiento = request.getFamiliaNovedadTADDTITULARptpagrDepartamentoNacimientoInstance();
        Municipio familiaNovedadTADDTITULARptpagrMunicipioNacimiento = request.getFamiliaNovedadTADDTITULARptpagrMunicipioNacimientoInstance();
        boolean preconditionHolds = familiaNovedadTADDTITULARptpagrTipoIdentificacion.getTipoIdentificacionNIT().equals(true) || familiaNovedadTADDTITULARptpatrIndicadorExtranjero.equals(true) || ((familiaNovedadTADDTITULARptpagrDepartamentoNacimiento != null && !familiaNovedadTADDTITULARptpagrDepartamentoNacimiento.isNull()) && (familiaNovedadTADDTITULARptpagrMunicipioNacimiento != null && !familiaNovedadTADDTITULARptpagrMunicipioNacimiento.isNull()));
        if (!preconditionHolds) throw new PreconditionException("Debe diligenciar el Departamento y Municipio de nacimiento");
    }

    // Service: TFIRMARNUEVOTITULAR

    /*
     * Entry point for service TFIRMARNUEVOTITULAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tFIRMARNUEVOTITULAR(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tFIRMARNUEVOTITULARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TFIRMARNUEVOTITULAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tFIRMARNUEVOTITULARTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad()));
        return familiaNovedadSrv.tFIRMARNUEVOTITULARImplementation(request);
    }

    /*
     * Implements service TFIRMARNUEVOTITULAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tFIRMARNUEVOTITULARImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        byte[] familiaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma = request.getFamiliaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma();
        String familiaNovedadTFIRMARNUEVOTITULARptpatrLatitud = request.getFamiliaNovedadTFIRMARNUEVOTITULARptpatrLatitud();
        String familiaNovedadTFIRMARNUEVOTITULARptpatrLongitud = request.getFamiliaNovedadTFIRMARNUEVOTITULARptpatrLongitud();
        FamiliaNovedad familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad = request.getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance();

        request.checkArguments();

        tFIRMARNUEVOTITULARPreconditions(request);
        FamiliaNovedad instance = familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad;

        com.keralty.aenovedades.viewmodel.novedadct.siu.TCREAROMODFIRMANUEVOTITRequest step1Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.TCREAROMODFIRMANUEVOTITRequest();
        step1Request.setNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance(familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad.getNovedadCT());
        step1Request.setNovedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma(familiaNovedadTFIRMARNUEVOTITULARptpatrImagenFirma);
        step1Request.setNovedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud(familiaNovedadTFIRMARNUEVOTITULARptpatrLatitud);
        step1Request.setNovedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud(familiaNovedadTFIRMARNUEVOTITULARptpatrLongitud);
        novedadCTSrv.tCREAROMODFIRMANUEVOTITImplementation(step1Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    /*
     * Checks service TFIRMARNUEVOTITULAR preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tFIRMARNUEVOTITULARCheckPreconditions(com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad()));
        try {
            if("Clas_1581424574464890Pre_40".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre40(request);
            if("Clas_1581424574464890Pre_41".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre41(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tFIRMARNUEVOTITULARPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest request) 
            throws ModelException {
        checkClas1581424574464890Pre40(request);
        checkClas1581424574464890Pre41(request);
    }

    private void checkClas1581424574464890Pre40 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest request) 
            throws ModelException {
        // FamActiva = TRUE

        FamiliaNovedad familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad = request.getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance();
        boolean preconditionHolds = familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad.getFamiliaNovedadFamActiva().equals(true);
        if (!preconditionHolds) throw new PreconditionException("La familia debe estgar activa");
    }

    private void checkClas1581424574464890Pre41 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TFIRMARNUEVOTITULARRequest request) 
            throws ModelException {
        // drvTieneNuevoTitular = TRUE

        FamiliaNovedad familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad = request.getFamiliaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedadInstance();
        boolean preconditionHolds = familiaNovedadTFIRMARNUEVOTITULARpthisFamiliaNovedad.getFamiliaNovedaddrvTieneNuevoTitular().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Antes de indicar la firma, debe diligenciar los datos del nuevo titular");
    }

    // Service: TDELETE

    /*
     * Entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tDELETE(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tDELETETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tDELETETxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TDELETERequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTDELETEpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTDELETEpthisFamiliaNovedad()));
        return familiaNovedadSrv.tDELETEImplementation(request);
    }

    /*
     * Implements service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tDELETEImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TDELETERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad familiaNovedadTDELETEpthisFamiliaNovedad = request.getFamiliaNovedadTDELETEpthisFamiliaNovedadInstance();

        request.checkArguments();

        tDELETEPreconditions(request);
        FamiliaNovedad instance = familiaNovedadTDELETEpthisFamiliaNovedad;

        for(UsuarioNovedad step1Entity : repository.assocOperator048(familiaNovedadTDELETEpthisFamiliaNovedad)) {
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.EliminarRequest step1Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.EliminarRequest();
            step1Request.setUsuarioNovedadeliminarpthisUsuarioNovedadInstance(step1Entity);
            usuarioNovedadSrv.eliminarImplementation(step1Request);
        }

        for(NovedadCT step2Entity : repository.assocOperator049(familiaNovedadTDELETEpthisFamiliaNovedad)) {
            com.keralty.aenovedades.viewmodel.novedadct.siu.TDELETERequest step2Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.TDELETERequest();
            step2Request.setNovedadCTTDELETEpthisNovedadCTInstance(step2Entity);
            novedadCTSrv.tDELETEImplementation(step2Request);
        }

        for(NovedadMD step3Entity : repository.assocOperator050(familiaNovedadTDELETEpthisFamiliaNovedad)) {
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TDELETERequest step3Request = new com.keralty.aenovedades.viewmodel.novedadmd.siu.TDELETERequest();
            step3Request.setNovedadMDTDELETEpthisNovedadMDInstance(step3Entity);
            novedadMDSrv.tDELETEImplementation(step3Request);
        }

        for(Firma step4Entity : repository.assocOperator051(familiaNovedadTDELETEpthisFamiliaNovedad)) {
            com.keralty.aenovedades.viewmodel.firma.siu.EliminarInternoRequest step4Request = new com.keralty.aenovedades.viewmodel.firma.siu.EliminarInternoRequest();
            step4Request.setFirmaeliminarInternopthisFirmaInstance(step4Entity);
            firmaSrv.eliminarInternoImplementation(step4Request);
        }

        com.keralty.aenovedades.viewmodel.familianovedad.siu.EliminarRequest step5Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.EliminarRequest();
        step5Request.setFamiliaNovedadeliminarpthisFamiliaNovedadInstance(familiaNovedadTDELETEpthisFamiliaNovedad);
        familiaNovedadSrv.eliminarImplementation(step5Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    /*
     * Checks service TDELETE preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tDELETECheckPreconditions(com.keralty.aenovedades.viewmodel.familianovedad.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setFamiliaNovedadTDELETEpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTDELETEpthisFamiliaNovedad()));
        try {
            if("Clas_1581424574464890Pre_44".equals(request.getPreconditionId()))
                checkClas1581424574464890Pre44(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tDELETEPreconditions(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TDELETERequest request) 
            throws ModelException {
        checkClas1581424574464890Pre44(request);
    }

    private void checkClas1581424574464890Pre44 (
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TDELETERequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = FALSE)
        // OR Solicitud.DrvPermiteDelFam = TRUE

        FamiliaNovedad familiaNovedadTDELETEpthisFamiliaNovedad = request.getFamiliaNovedadTDELETEpthisFamiliaNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || familiaNovedadTDELETEpthisFamiliaNovedad.getSolicitud().getSolicitudNovedadDrvPermiteDelFam().equals(true);
        if (!preconditionHolds) throw new PreconditionException("No es posible eliminar a la familia de la novedad");
    }

    // Service: TCREARDOCNUMIDSIEXISTE

    /*
     * Entry point for service TCREARDOCNUMIDSIEXISTE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARDOCNUMIDSIEXISTE(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDOCNUMIDSIEXISTERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tCREARDOCNUMIDSIEXISTETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARDOCNUMIDSIEXISTE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARDOCNUMIDSIEXISTETxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDOCNUMIDSIEXISTERequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad()));
        return familiaNovedadSrv.tCREARDOCNUMIDSIEXISTEImplementation(request);
    }

    /*
     * Implements service TCREARDOCNUMIDSIEXISTE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARDOCNUMIDSIEXISTEImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDOCNUMIDSIEXISTERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion = request.getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion();
        FamiliaNovedad familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad = request.getFamiliaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedadInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad;

        /* Action 1: IF (fuBuscarDocGestorNumId(pNumIdentificacion, Solicitud.DrvNumRadicadoStr) <> NULL) */
        boolean ifCondition1 = userFunctionsSrv.fuBuscarDocGestorNumIdFun(familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion, familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad.getSolicitud().getSolicitudNovedadDrvNumRadicadoStr()) != null;
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARDOCIDDESDECORERequest step10Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARDOCIDDESDECORERequest();
            step10Request.setDocumentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor(userFunctionsSrv.fuBuscarDocGestorNumIdFun(familiaNovedadTCREARDOCNUMIDSIEXISTEpNumIdentificacion, familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad.getSolicitud().getSolicitudNovedadDrvNumRadicadoStr()));
            step10Request.setDocumentoNovedadTCREARDOCIDDESDECOREptpNombre("CAMBIO MANUAL");
            step10Request.setDocumentoNovedadTCREARDOCIDDESDECOREptpExtension("CAMBIO MANUAL");
            step10Request.setDocumentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance(familiaNovedadTCREARDOCNUMIDSIEXISTEpthisFamiliaNovedad.getSolicitud());
            documentoNovedadSrv.tCREARDOCIDDESDECOREImplementation(step10Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: TCREARMANUAL

    /*
     * Entry point for service TCREARMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARMANUAL(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARMANUALRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tCREARMANUALTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARMANUALTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARMANUALRequest request) throws ModelException {
        request.setFamiliaNovedadTCREARMANUALptpagrSolicitudInstance(solicitudNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTCREARMANUALptpagrSolicitud()));
        request.setFamiliaNovedadTCREARMANUALptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getFamiliaNovedadTCREARMANUALptpagrTipoIdentificacion())));
        return familiaNovedadSrv.tCREARMANUALImplementation(request);
    }

    /*
     * Implements service TCREARMANUAL
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARMANUALImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARMANUALRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad familiaNovedadTCREARMANUALptpagrSolicitud = request.getFamiliaNovedadTCREARMANUALptpagrSolicitudInstance();
        TipoIdentificacion familiaNovedadTCREARMANUALptpagrTipoIdentificacion = request.getFamiliaNovedadTCREARMANUALptpagrTipoIdentificacionInstance();
        String familiaNovedadTCREARMANUALptpatrTitNumidentificacion = request.getFamiliaNovedadTCREARMANUALptpatrTitNumidentificacion();
        String familiaNovedadTCREARMANUALptpatrTitPrimerNombre = request.getFamiliaNovedadTCREARMANUALptpatrTitPrimerNombre();
        String familiaNovedadTCREARMANUALptpatrTitSegundoNombre = request.getFamiliaNovedadTCREARMANUALptpatrTitSegundoNombre();
        String familiaNovedadTCREARMANUALptpatrTitPrimerApellido = request.getFamiliaNovedadTCREARMANUALptpatrTitPrimerApellido();
        String familiaNovedadTCREARMANUALptpatrTitSegundoApellido = request.getFamiliaNovedadTCREARMANUALptpatrTitSegundoApellido();
        Long familiaNovedadTCREARMANUALptpatrNumFamilia = request.getFamiliaNovedadTCREARMANUALptpatrNumFamilia();
        String familiaNovedadTCREARMANUALptpatrTitRazonSocial = request.getFamiliaNovedadTCREARMANUALptpatrTitRazonSocial();

        request.checkArguments();
        FamiliaNovedad instance;

        com.keralty.aenovedades.viewmodel.familianovedad.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.CrearRequest();
        step1Request.setFamiliaNovedadcrearpagrSolicitudInstance(familiaNovedadTCREARMANUALptpagrSolicitud);
        step1Request.setFamiliaNovedadcrearpagrTipoIdentificacionInstance(familiaNovedadTCREARMANUALptpagrTipoIdentificacion);
        step1Request.setFamiliaNovedadcrearpagrFirmaInstance(null);
        step1Request.setFamiliaNovedadcrearpatrTitNumidentificacion(familiaNovedadTCREARMANUALptpatrTitNumidentificacion);
        step1Request.setFamiliaNovedadcrearpatrTitPrimerNombre(familiaNovedadTCREARMANUALptpatrTitPrimerNombre);
        step1Request.setFamiliaNovedadcrearpatrTitTieneBeneficios(Boolean.FALSE);
        step1Request.setFamiliaNovedadcrearpatrTitSegundoNombre(familiaNovedadTCREARMANUALptpatrTitSegundoNombre);
        step1Request.setFamiliaNovedadcrearpatrTitPrimerApellido(familiaNovedadTCREARMANUALptpatrTitPrimerApellido);
        step1Request.setFamiliaNovedadcrearpatrTitSegundoApellido(familiaNovedadTCREARMANUALptpatrTitSegundoApellido);
        step1Request.setFamiliaNovedadcrearpatrNumFamilia(familiaNovedadTCREARMANUALptpatrNumFamilia);
        step1Request.setFamiliaNovedadcrearpatrTitRazonSocial(familiaNovedadTCREARMANUALptpatrTitRazonSocial);
        step1Request.setFamiliaNovedadcrearpatrFamActiva(Boolean.TRUE);
        instance = (FamiliaNovedad) familiaNovedadSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: TMODIFICARMANUAL

    /*
     * Entry point for service TMODIFICARMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICARMANUAL(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMODIFICARMANUALRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tMODIFICARMANUALTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICARMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARMANUALTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMODIFICARMANUALRequest request) throws ModelException, SystemException {
        request.setFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedad()));
        request.setFamiliaNovedadTMODIFICARMANUALptTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getFamiliaNovedadTMODIFICARMANUALptTipoIdentificacion())));
        return familiaNovedadSrv.tMODIFICARMANUALImplementation(request);
    }

    /*
     * Implements service TMODIFICARMANUAL
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARMANUALImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TMODIFICARMANUALRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long familiaNovedadTMODIFICARMANUALptpNumFamilia = request.getFamiliaNovedadTMODIFICARMANUALptpNumFamilia();
        String familiaNovedadTMODIFICARMANUALptpTitNumidentificacion = request.getFamiliaNovedadTMODIFICARMANUALptpTitNumidentificacion();
        String familiaNovedadTMODIFICARMANUALptpTitPrimerNombre = request.getFamiliaNovedadTMODIFICARMANUALptpTitPrimerNombre();
        String familiaNovedadTMODIFICARMANUALptpTitSegundoNombre = request.getFamiliaNovedadTMODIFICARMANUALptpTitSegundoNombre();
        String familiaNovedadTMODIFICARMANUALptpTitPrimerApellido = request.getFamiliaNovedadTMODIFICARMANUALptpTitPrimerApellido();
        String familiaNovedadTMODIFICARMANUALptpTitSegundoApellido = request.getFamiliaNovedadTMODIFICARMANUALptpTitSegundoApellido();
        String familiaNovedadTMODIFICARMANUALptpTitRazonSocial = request.getFamiliaNovedadTMODIFICARMANUALptpTitRazonSocial();
        TipoIdentificacion familiaNovedadTMODIFICARMANUALptTipoIdentificacion = request.getFamiliaNovedadTMODIFICARMANUALptTipoIdentificacionInstance();
        FamiliaNovedad familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad = request.getFamiliaNovedadTMODIFICARMANUALpthisFamiliaNovedadInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad;

        com.keralty.aenovedades.viewmodel.familianovedad.siu.ModificarRequest step1Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.ModificarRequest();
        step1Request.setFamiliaNovedadmodificarpthisFamiliaNovedadInstance(familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad);
        step1Request.setFamiliaNovedadmodificarpNumFamilia(familiaNovedadTMODIFICARMANUALptpNumFamilia);
        step1Request.setFamiliaNovedadmodificarpTitNumidentificacion(familiaNovedadTMODIFICARMANUALptpTitNumidentificacion);
        step1Request.setFamiliaNovedadmodificarpTitPrimerNombre(familiaNovedadTMODIFICARMANUALptpTitPrimerNombre);
        step1Request.setFamiliaNovedadmodificarpTitSegundoNombre(familiaNovedadTMODIFICARMANUALptpTitSegundoNombre);
        step1Request.setFamiliaNovedadmodificarpTitPrimerApellido(familiaNovedadTMODIFICARMANUALptpTitPrimerApellido);
        step1Request.setFamiliaNovedadmodificarpTitSegundoApellido(familiaNovedadTMODIFICARMANUALptpTitSegundoApellido);
        step1Request.setFamiliaNovedadmodificarpTitRazonSocial(familiaNovedadTMODIFICARMANUALptpTitRazonSocial);
        familiaNovedadSrv.modificarImplementation(step1Request);

        /* Action 2: IF (TipoIdentificacion <> ptTipoIdentificacion) */
        boolean ifCondition2 = !Utilities.isEqual(familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad.getTipoIdentificacion(), familiaNovedadTMODIFICARMANUALptTipoIdentificacion);
        if (ifCondition2) {
            /* Action 20: IF (EXIST (TipoIdentificacion) = true) */
            boolean ifCondition20 = repository.assocOperator053(familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad).equals(true);
            if (ifCondition20) {
                com.keralty.aenovedades.viewmodel.familianovedad.siu.DelTipoIdentificacionRequest step200Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.DelTipoIdentificacionRequest();
                step200Request.setFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance(familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad);
                step200Request.setFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance(familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad.getTipoIdentificacion());
                familiaNovedadSrv.delTipoIdentificacionImplementation(step200Request, true);
            }
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsTipoIdentificacionRequest step21Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.InsTipoIdentificacionRequest();
            step21Request.setFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance(familiaNovedadTMODIFICARMANUALpthisFamiliaNovedad);
            step21Request.setFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance(familiaNovedadTMODIFICARMANUALptTipoIdentificacion);
            familiaNovedadSrv.insTipoIdentificacionImplementation(step21Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    // Service: TCREARUSUMANUAL

    /*
     * Entry point for service TCREARUSUMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARUSUMANUAL(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARUSUMANUALRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaNovedadSrv.tCREARUSUMANUALTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARUSUMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARUSUMANUALTxn(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARUSUMANUALRequest request) throws ModelException {
        request.setFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedad()));
        request.setFamiliaNovedadTCREARUSUMANUALptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getFamiliaNovedadTCREARUSUMANUALptpagrTipoIdentificacion())));
        request.setFamiliaNovedadTCREARUSUMANUALptpagrParentescoInstance(parentescoSrv.getByOIDWithHV(new ParentescoOid().fromJsonString(request.getFamiliaNovedadTCREARUSUMANUALptpagrParentesco())));
        return familiaNovedadSrv.tCREARUSUMANUALImplementation(request);
    }

    /*
     * Implements service TCREARUSUMANUAL
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARUSUMANUALImplementation(
            com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARUSUMANUALRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion = request.getFamiliaNovedadTCREARUSUMANUALptpagrTipoIdentificacionInstance();
        Parentesco familiaNovedadTCREARUSUMANUALptpagrParentesco = request.getFamiliaNovedadTCREARUSUMANUALptpagrParentescoInstance();
        String familiaNovedadTCREARUSUMANUALptpatrNumIdentificacion = request.getFamiliaNovedadTCREARUSUMANUALptpatrNumIdentificacion();
        String familiaNovedadTCREARUSUMANUALptpatrPrimerNombre = request.getFamiliaNovedadTCREARUSUMANUALptpatrPrimerNombre();
        String familiaNovedadTCREARUSUMANUALptpatrSegundoNombre = request.getFamiliaNovedadTCREARUSUMANUALptpatrSegundoNombre();
        String familiaNovedadTCREARUSUMANUALptpatrPrimerApellido = request.getFamiliaNovedadTCREARUSUMANUALptpatrPrimerApellido();
        String familiaNovedadTCREARUSUMANUALptpatrSegundoApellido = request.getFamiliaNovedadTCREARUSUMANUALptpatrSegundoApellido();
        Date familiaNovedadTCREARUSUMANUALptpatrFechaNacimiento = request.getFamiliaNovedadTCREARUSUMANUALptpatrFechaNacimiento();
        String familiaNovedadTCREARUSUMANUALptpatrGenero = request.getFamiliaNovedadTCREARUSUMANUALptpatrGenero();
        FamiliaNovedad familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad = request.getFamiliaNovedadTCREARUSUMANUALpthisFamiliaNovedadInstance();

        request.checkArguments();
        FamiliaNovedad instance = familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad;

        com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARMANUALRequest step1Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARMANUALRequest();
        step1Request.setUsuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance(familiaNovedadTCREARUSUMANUALpthisFamiliaNovedad);
        step1Request.setUsuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance(familiaNovedadTCREARUSUMANUALptpagrTipoIdentificacion);
        step1Request.setUsuarioNovedadTCREARMANUALptpagrParentescoInstance(familiaNovedadTCREARUSUMANUALptpagrParentesco);
        step1Request.setUsuarioNovedadTCREARMANUALptpatrNumIdentificacion(familiaNovedadTCREARUSUMANUALptpatrNumIdentificacion);
        step1Request.setUsuarioNovedadTCREARMANUALptpatrPrimerNombre(familiaNovedadTCREARUSUMANUALptpatrPrimerNombre);
        step1Request.setUsuarioNovedadTCREARMANUALptpatrSegundoNombre(familiaNovedadTCREARUSUMANUALptpatrSegundoNombre);
        step1Request.setUsuarioNovedadTCREARMANUALptpatrPrimerApellido(familiaNovedadTCREARUSUMANUALptpatrPrimerApellido);
        step1Request.setUsuarioNovedadTCREARMANUALptpatrSegundoApellido(familiaNovedadTCREARUSUMANUALptpatrSegundoApellido);
        step1Request.setUsuarioNovedadTCREARMANUALptpatrFechaNacimiento(familiaNovedadTCREARUSUMANUALptpatrFechaNacimiento);
        step1Request.setUsuarioNovedadTCREARMANUALptpatrGenero(familiaNovedadTCREARUSUMANUALptpatrGenero);
        usuarioNovedadSrv.tCREARMANUALImplementation(step1Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICFamiliaNovedad());

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ATTR_FIELD_FAMILIANOVEDADIDFAMILIANOVEDAD, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildFamiliaNovedadRelatedInstance(relatedInstanceJsonOid);
        }
        if (FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaNovedadRelatedInstance4UsuarioNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaNovedadRelatedInstance4NovedadCT(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaNovedadConstants.ROLE_NAME_NOVEDADMD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaNovedadRelatedInstance4NovedadMD(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaNovedadConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaNovedadRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaNovedadRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaNovedadConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaNovedadRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildFamiliaNovedadRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildFamiliaNovedadRelatedInstance4UsuarioNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new UsuarioNovedad(mapper.readValue(relatedInstanceJsonOid, UsuarioNovedadOid.class)): UsuarioNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildFamiliaNovedadRelatedInstance4NovedadCT(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new NovedadCT(mapper.readValue(relatedInstanceJsonOid, NovedadCTOid.class)): NovedadCT.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildFamiliaNovedadRelatedInstance4NovedadMD(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new NovedadMD(mapper.readValue(relatedInstanceJsonOid, NovedadMDOid.class)): NovedadMD.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildFamiliaNovedadRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildFamiliaNovedadRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildFamiliaNovedadRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FamiliaNovedadOid oid = new FamiliaNovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ATTR_FIELD_FAMILIANOVEDADIDFAMILIANOVEDAD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFamiliaNovedadidFamiliaNovedad(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(FamiliaNovedadService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
