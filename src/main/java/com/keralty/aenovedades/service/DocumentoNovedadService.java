package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.MinCardinalityException;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.PreconditionException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.AsesorConstants;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.global.FuncionarioConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;
import com.keralty.aenovedades.persistence.oid.LogEstadoDocNovOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.repository.DocumentoNovedadJpaRepository;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereConjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereDisjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class DocumentoNovedadService extends AbstractService {

    DocumentoNovedadJpaRepository repository;

    DocumentoNovedadService documentoNovedadSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    UsuarioNovedadService usuarioNovedadSrv;

    LogEstadoDocNovService logEstadoDocNovSrv;

    SolicitudService solicitudSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public DocumentoNovedadService(
            DocumentoNovedadService documentoNovedadSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            UsuarioNovedadService usuarioNovedadSrv,
            LogEstadoDocNovService logEstadoDocNovSrv,
            SolicitudService solicitudSrv,
            UserFunctions userFunctionsSrv,
            DocumentoNovedadJpaRepository repository) {
        this.documentoNovedadSrv = documentoNovedadSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.usuarioNovedadSrv = usuarioNovedadSrv;
        this.logEstadoDocNovSrv = logEstadoDocNovSrv;
        this.solicitudSrv = solicitudSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, DocumentoNovedadConstants.CLASS_NAME);
    }

    private List<DocumentoNovedad> solveDocumentoNovedadTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, DocumentoNovedadConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveDocumentoNovedadTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, DocumentoNovedadConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class DocumentoNovedad
     *
     * @return Population of class DocumentoNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DocumentoNovedad> get() {
        List<DocumentoNovedad> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class DocumentoNovedad
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class DocumentoNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<DocumentoNovedad> instances = get(queryRequest);
        if(DocumentoNovedadConstants.DSDSDOCUMENTONOVEDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDocumentoNovedad())).collect(Collectors.toList());
        }
        if(DocumentoNovedadConstants.DSICDOCUMENTONOVEDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICDocumentoNovedad())).collect(Collectors.toList());
        }
        if(DocumentoNovedadConstants.DSDSDOCUMENTONOVEDADNULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDocumentoNovedadNull())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class DocumentoNovedad that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class DocumentoNovedad matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DocumentoNovedad> get(QueryRequest queryRequest) {
        return solveDocumentoNovedadTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveDocumentoNovedadTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveDocumentoNovedadTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveDocumentoNovedadTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveDocumentoNovedadTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of DocumentoNovedad by ID
     *
     * @param documentoNovedadIdDocumento Identification field documentoNovedadIdDocumento
     *
     * @return Instance of DocumentoNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public DocumentoNovedad getById(Long documentoNovedadIdDocumento) {
        return getByOID(new DocumentoNovedadOid(documentoNovedadIdDocumento));
    }
    
    /*
     * Returns an instance of DocumentoNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DocumentoNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public DocumentoNovedad getByOID(DocumentoNovedadOid oid) {
        Optional<DocumentoNovedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of DocumentoNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DocumentoNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public DocumentoNovedad getByOIDWithHV(DocumentoNovedadOid oid) {
        Optional<DocumentoNovedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<DocumentoNovedad> getInstanceByOid(DocumentoNovedadOid oid) {
        return oid != null && oid.getDocumentoNovedadIdDocumento() != null
               ? repository.findById(oid.getDocumentoNovedadIdDocumento())
               : Optional.empty();
    }

    /*
     * Returns an instance of DocumentoNovedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of DocumentoNovedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public DocumentoNovedad getByJsonOid(String jsonOid) {
        DocumentoNovedadOid oid = new DocumentoNovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of DocumentoNovedad related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of DocumentoNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DocumentoNovedad> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveDocumentoNovedadTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of DocumentoNovedad related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of DocumentoNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DocumentoNovedad> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of DocumentoNovedad
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of DocumentoNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getDocumentoNovedadDynamic(DocumentoNovedadOid oid, String displaySetItems) {
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
    public String getSuppInfo(DocumentoNovedadOid oid, String dsName) {
        DocumentoNovedad instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(DocumentoNovedad instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (DocumentoNovedadConstants.DSICDOCUMENTONOVEDAD.equals(dsName))
            return instance.buildICDocumentoNovedad();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(DocumentoNovedad instance, String dsName) {
        if (DocumentoNovedadConstants.DSDSDOCUMENTONOVEDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDocumentoNovedad());
        if (DocumentoNovedadConstants.DSICDOCUMENTONOVEDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICDocumentoNovedad());
        if (DocumentoNovedadConstants.DSDSDOCUMENTONOVEDADNULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDocumentoNovedadNull());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_DocumentoNovedad".equals(filterRequest.getName()))
            suppInfo4ICDocumentoNovedad(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods


    /*
     * Solves the query needed for PIUDocumentoNovedad
     *
     * @param queryRequest Query request
     * @return List of viewmodels for DocumentoNovedad using displayset DSDocumentoNovedad that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.documentonovedad.ds.DSDocumentoNovedad> piuPIUDocumentoNovedad(QueryRequest queryRequest) {
        return solveDocumentoNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.documentonovedad.ds.DSDocumentoNovedad::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDocumentoNovedad
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDocumentoNovedad
     */
    public int getCount4PIUDocumentoNovedad(QueryRequest queryRequest) {
        return solveDocumentoNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUDocumentoNovedadNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for DocumentoNovedad using displayset DSDocumentoNovedadNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.documentonovedad.ds.DSDocumentoNovedadNull> piuPIUDocumentoNovedadNull(QueryRequest queryRequest) {
        return solveDocumentoNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.documentonovedad.ds.DSDocumentoNovedadNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDocumentoNovedadNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDocumentoNovedadNull
     */
    public int getCount4PIUDocumentoNovedadNull(QueryRequest queryRequest) {
        return solveDocumentoNovedadTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest request) throws ModelException {
        request.setDocumentoNovedadcrearpagrSolicitudInstance(solicitudNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadcrearpagrSolicitud()));
        request.setDocumentoNovedadcrearpagrUsuarioInstance(usuarioNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadcrearpagrUsuario()));
        return documentoNovedadSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad documentoNovedadcrearpagrSolicitud = request.getDocumentoNovedadcrearpagrSolicitudInstance();
        UsuarioNovedad documentoNovedadcrearpagrUsuario = request.getDocumentoNovedadcrearpagrUsuarioInstance();
        String documentoNovedadcrearpatrDescripcion = request.getDocumentoNovedadcrearpatrDescripcion();
        Long documentoNovedadcrearpatrEstado = request.getDocumentoNovedadcrearpatrEstado();
        String documentoNovedadcrearpatrIdDocEnGestor = request.getDocumentoNovedadcrearpatrIdDocEnGestor();
        Long documentoNovedadcrearpatrTipo = request.getDocumentoNovedadcrearpatrTipo();
        String documentoNovedadcrearpatrNombre = request.getDocumentoNovedadcrearpatrNombre();
        String documentoNovedadcrearpatrExtension = request.getDocumentoNovedadcrearpatrExtension();
        String documentoNovedadcrearpatrUsuarioCreador = request.getDocumentoNovedadcrearpatrUsuarioCreador();

        request.checkArguments();
        DocumentoNovedad instance = new DocumentoNovedad();
        instance.add2Solicitud(documentoNovedadcrearpagrSolicitud);

        if (documentoNovedadcrearpagrUsuario != null && !documentoNovedadcrearpagrUsuario.isNull()) {
            instance.add2Usuario(documentoNovedadcrearpagrUsuario);
        }

        instance.setDocumentoNovedadIdDocumento(Long.valueOf(0));
        instance.setDocumentoNovedadFechaSubida(STDFunctions.systemDateTimeFun());
        instance.setDocumentoNovedadDescripcion(documentoNovedadcrearpatrDescripcion);
        instance.setDocumentoNovedadEstado(documentoNovedadcrearpatrEstado);
        instance.setDocumentoNovedadIdDocEnGestor(documentoNovedadcrearpatrIdDocEnGestor);
        instance.setDocumentoNovedadTipo(documentoNovedadcrearpatrTipo);
        instance.setDocumentoNovedadNombre(documentoNovedadcrearpatrNombre);
        instance.setDocumentoNovedadExtension(documentoNovedadcrearpatrExtension);
        instance.setDocumentoNovedadUsuarioCreador(documentoNovedadcrearpatrUsuarioCreador);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.EliminarRequest request) throws ModelException {
        request.setDocumentoNovedadeliminarpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadeliminarpthisDocumentoNovedad()));
        return documentoNovedadSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad documentoNovedadeliminarpthisDocumentoNovedad = request.getDocumentoNovedadeliminarpthisDocumentoNovedadInstance();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadeliminarpthisDocumentoNovedad;
        if(documentoNovedadeliminarpthisDocumentoNovedad.getLogEstadoDocNov().size() > 0) {
            throw new MinCardinalityException(DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ROLE_ALIAS_LOGESTADODOCNOV);
        }


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: cambiarFechaSubida

    /*
     * Entry point for service cambiarFechaSubida
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarFechaSubida(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarFechaSubidaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.cambiarFechaSubidaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarFechaSubida
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarFechaSubidaTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarFechaSubidaRequest request) throws ModelException {
        request.setDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedad()));
        return documentoNovedadSrv.cambiarFechaSubidaImplementation(request);
    }

    /*
     * Implements service cambiarFechaSubida
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarFechaSubidaImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarFechaSubidaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad documentoNovedadcambiarFechaSubidapthisDocumentoNovedad = request.getDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance();
        Timestamp documentoNovedadcambiarFechaSubidapFechaSubida = request.getDocumentoNovedadcambiarFechaSubidapFechaSubida();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadcambiarFechaSubidapthisDocumentoNovedad;
        instance.setDocumentoNovedadFechaSubida(documentoNovedadcambiarFechaSubidapFechaSubida);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: cambiarEstado

    /*
     * Entry point for service cambiarEstado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarEstado(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarEstadoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.cambiarEstadoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarEstado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarEstadoTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarEstadoRequest request) throws ModelException {
        request.setDocumentoNovedadcambiarEstadopthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadcambiarEstadopthisDocumentoNovedad()));
        return documentoNovedadSrv.cambiarEstadoImplementation(request);
    }

    /*
     * Implements service cambiarEstado
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarEstadoImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarEstadoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad documentoNovedadcambiarEstadopthisDocumentoNovedad = request.getDocumentoNovedadcambiarEstadopthisDocumentoNovedadInstance();
        Long documentoNovedadcambiarEstadopeEstado = request.getDocumentoNovedadcambiarEstadopeEstado();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadcambiarEstadopthisDocumentoNovedad;
        instance.setDocumentoNovedadEstado(documentoNovedadcambiarEstadopeEstado);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: dummyEnviarEmail

    /*
     * Entry point for service dummyEnviarEmail
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse dummyEnviarEmail(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DummyEnviarEmailRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.dummyEnviarEmailTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service dummyEnviarEmail
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse dummyEnviarEmailTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DummyEnviarEmailRequest request) throws ModelException {
        request.setDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedad()));
        return documentoNovedadSrv.dummyEnviarEmailImplementation(request);
    }

    /*
     * Implements service dummyEnviarEmail
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse dummyEnviarEmailImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DummyEnviarEmailRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad documentoNovedaddummyEnviarEmailpthisDocumentoNovedad = request.getDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance();

        request.checkArguments();

        dummyEnviarEmailPreconditions(request);
        DocumentoNovedad instance = documentoNovedaddummyEnviarEmailpthisDocumentoNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    private void dummyEnviarEmailPreconditions(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DummyEnviarEmailRequest request) 
            throws ModelException {
        checkClas1582535933952300Pre1(request);
    }

    private void checkClas1582535933952300Pre1 (
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DummyEnviarEmailRequest request) 
            throws ModelException {
        // fuEnviarEmail( pAsunto, pTo, "", pBoby , NULL, NULL, Solicitud.DrvNumRadicadoStr) <> "A NADA"

        String documentoNovedaddummyEnviarEmailpAsunto = request.getDocumentoNovedaddummyEnviarEmailpAsunto();
        String documentoNovedaddummyEnviarEmailpTo = request.getDocumentoNovedaddummyEnviarEmailpTo();
        String documentoNovedaddummyEnviarEmailpBoby = request.getDocumentoNovedaddummyEnviarEmailpBoby();
        DocumentoNovedad documentoNovedaddummyEnviarEmailpthisDocumentoNovedad = request.getDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance();
        boolean preconditionHolds = !(userFunctionsSrv.fuEnviarEmailFun(documentoNovedaddummyEnviarEmailpAsunto, documentoNovedaddummyEnviarEmailpTo, "", documentoNovedaddummyEnviarEmailpBoby, null, null, documentoNovedaddummyEnviarEmailpthisDocumentoNovedad.getSolicitud().getSolicitudNovedadDrvNumRadicadoStr())).equals("A NADA");
        if (!preconditionHolds) throw new PreconditionException("Error 1001");
    }

    // Service: subirDocumentoGestorATO

    /*
     * Entry point for service subirDocumentoGestorATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse subirDocumentoGestorATO(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.SubirDocumentoGestorATORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.subirDocumentoGestorATOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service subirDocumentoGestorATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse subirDocumentoGestorATOTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.SubirDocumentoGestorATORequest request) throws ModelException {
        request.setDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad()));
        return documentoNovedadSrv.subirDocumentoGestorATOImplementation(request);
    }

    /*
     * Implements service subirDocumentoGestorATO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse subirDocumentoGestorATOImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.SubirDocumentoGestorATORequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad = request.getDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance();
        String documentoNovedadsubirDocumentoGestorATOpeIdDocGestor = request.getDocumentoNovedadsubirDocumentoGestorATOpeIdDocGestor();
        String documentoNovedadsubirDocumentoGestorATOptNombre = request.getDocumentoNovedadsubirDocumentoGestorATOptNombre();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad;
        instance.setDocumentoNovedadIdDocEnGestor(documentoNovedadsubirDocumentoGestorATOpeIdDocGestor);
        instance.setDocumentoNovedadNombre(documentoNovedadsubirDocumentoGestorATOptNombre);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: descargarDocumentoATO

    /*
     * Entry point for service descargarDocumentoATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse descargarDocumentoATO(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATORequest request) {
        com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse response = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse();
        try {
            response = documentoNovedadSrv.descargarDocumentoATOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service descargarDocumentoATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse descargarDocumentoATOTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATORequest request) throws ModelException {
        request.setDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedad()));
        return documentoNovedadSrv.descargarDocumentoATOImplementation(request);
    }

    /*
     * Implements service descargarDocumentoATO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse descargarDocumentoATOImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATORequest request) throws ModelException {
        com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse response = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse();
        DocumentoNovedad documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad = request.getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance();

        request.checkArguments();

        descargarDocumentoATOPreconditions(request);
        DocumentoNovedad instance = documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        // Value expressions for outgoing argument 'documentoNovedaddescargarDocumentoATOoaUrlDescarga'
        // DEFAULT  : fuGetIURLDescargaATOMIC(  ) + "/" + IdDocEnGestor
        response.setDocumentoNovedaddescargarDocumentoATOoaUrlDescarga(userFunctionsSrv.fuGetIURLDescargaATOMICFun() + "/" + documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad.getDocumentoNovedadIdDocEnGestor());


        // Value expressions for outgoing argument 'documentoNovedaddescargarDocumentoATOoaToken'
        // DEFAULT  : fuGetTkn(  )
        response.setDocumentoNovedaddescargarDocumentoATOoaToken(userFunctionsSrv.fuGetTknFun());


        // Value expressions for outgoing argument 'documentoNovedaddescargarDocumentoATOoaNumSolicitud'
        // DEFAULT  : IntToStr( Solicitud.NumRadicado )
        response.setDocumentoNovedaddescargarDocumentoATOoaNumSolicitud(STDFunctions.intToStrFun(documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad.getSolicitud().getSolicitudNovedadNumRadicado()));


        return response;
    }

    /*
     * Checks service descargarDocumentoATO preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse descargarDocumentoATOCheckPreconditions(com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATORequest request) {
        com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse response = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATOResponse();
        request.setDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedad()));
        try {
            if("Clas_1582535933952300Pre_3".equals(request.getPreconditionId()))
                checkClas1582535933952300Pre3(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void descargarDocumentoATOPreconditions(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATORequest request) 
            throws ModelException {
        checkClas1582535933952300Pre3(request);
    }

    private void checkClas1582535933952300Pre3 (
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DescargarDocumentoATORequest request) 
            throws ModelException {
        // Tipo = 2 OR AGENTAsesor = NULL OR AGENTAsesor.VerDocIdentificacionPersona = true OR UsuarioCreador = AGENTAsesor.UsuarioLDAP

        DocumentoNovedad documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad = request.getDocumentoNovedaddescargarDocumentoATOpthisDocumentoNovedadInstance();
        boolean preconditionHolds = (documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad.getDocumentoNovedadTipo()).equals(Long.valueOf(2)) || (((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) == null || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerDocIdentificacionPersona().equals(true) || (documentoNovedaddescargarDocumentoATOpthisDocumentoNovedad.getDocumentoNovedadUsuarioCreador()).equals(((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
        if (!preconditionHolds) throw new PreconditionException("No se permite la descarga de documento de identificación");
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.tDELETETxn(request);
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDELETERequest request) throws ModelException, SystemException {
        request.setDocumentoNovedadTDELETEpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadTDELETEpthisDocumentoNovedad()));
        return documentoNovedadSrv.tDELETEImplementation(request);
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
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDELETERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad documentoNovedadTDELETEpthisDocumentoNovedad = request.getDocumentoNovedadTDELETEpthisDocumentoNovedadInstance();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadTDELETEpthisDocumentoNovedad;

        for(LogEstadoDocNov step1Entity : repository.assocOperator000(documentoNovedadTDELETEpthisDocumentoNovedad)) {
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.EliminarRequest step1Request = new com.keralty.aenovedades.viewmodel.logestadodocnov.siu.EliminarRequest();
            step1Request.setLogEstadoDocNoveliminarpthisObsEstadoNovInstance(step1Entity);
            logEstadoDocNovSrv.eliminarImplementation(step1Request);
        }

        com.keralty.aenovedades.viewmodel.documentonovedad.siu.EliminarRequest step2Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.EliminarRequest();
        step2Request.setDocumentoNovedadeliminarpthisDocumentoNovedadInstance(documentoNovedadTDELETEpthisDocumentoNovedad);
        documentoNovedadSrv.eliminarImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: TAPROBAR

    /*
     * Entry point for service TAPROBAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tAPROBAR(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TAPROBARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.tAPROBARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TAPROBAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tAPROBARTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TAPROBARRequest request) throws ModelException, SystemException {
        request.setDocumentoNovedadTAPROBARpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadTAPROBARpthisDocumentoNovedad()));
        return documentoNovedadSrv.tAPROBARImplementation(request);
    }

    /*
     * Implements service TAPROBAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tAPROBARImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TAPROBARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String documentoNovedadTAPROBARptpatrObservacions = request.getDocumentoNovedadTAPROBARptpatrObservacions();
        DocumentoNovedad documentoNovedadTAPROBARpthisDocumentoNovedad = request.getDocumentoNovedadTAPROBARpthisDocumentoNovedadInstance();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadTAPROBARpthisDocumentoNovedad;

        com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest step1Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest();
        step1Request.setDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance(documentoNovedadTAPROBARpthisDocumentoNovedad);
        step1Request.setDocumentoNovedadTCAMBIARESTADOptpatrObservacions(documentoNovedadTAPROBARptpatrObservacions);
        step1Request.setDocumentoNovedadTCAMBIARESTADOptNuevoEstado(Long.valueOf(2));
        step1Request.setDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud(Boolean.TRUE);
        documentoNovedadSrv.tCAMBIARESTADOImplementation(step1Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: TDEVOLVER

    /*
     * Entry point for service TDEVOLVER
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tDEVOLVER(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDEVOLVERRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.tDEVOLVERTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TDEVOLVER
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tDEVOLVERTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDEVOLVERRequest request) throws ModelException, SystemException {
        request.setDocumentoNovedadTDEVOLVERpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadTDEVOLVERpthisDocumentoNovedad()));
        return documentoNovedadSrv.tDEVOLVERImplementation(request);
    }

    /*
     * Implements service TDEVOLVER
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tDEVOLVERImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDEVOLVERRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String documentoNovedadTDEVOLVERptpatrObservacions = request.getDocumentoNovedadTDEVOLVERptpatrObservacions();
        DocumentoNovedad documentoNovedadTDEVOLVERpthisDocumentoNovedad = request.getDocumentoNovedadTDEVOLVERpthisDocumentoNovedadInstance();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadTDEVOLVERpthisDocumentoNovedad;

        com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest step1Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest();
        step1Request.setDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance(documentoNovedadTDEVOLVERpthisDocumentoNovedad);
        step1Request.setDocumentoNovedadTCAMBIARESTADOptpatrObservacions(documentoNovedadTDEVOLVERptpatrObservacions);
        step1Request.setDocumentoNovedadTCAMBIARESTADOptNuevoEstado(Long.valueOf(3));
        step1Request.setDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud(Boolean.TRUE);
        documentoNovedadSrv.tCAMBIARESTADOImplementation(step1Request);

        /* Action 2: IF (Solicitud.Agente.Email <> NULL AND Solicitud.Agente.Email <> "") */
        boolean ifCondition2 = documentoNovedadTDEVOLVERpthisDocumentoNovedad.getSolicitud().getAgente().getFuncionarioEmail() != null && (documentoNovedadTDEVOLVERpthisDocumentoNovedad.getSolicitud().getAgente().getFuncionarioEmail()).length() != 0;
        if (ifCondition2) {
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.DummyEnviarEmailRequest step20Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.DummyEnviarEmailRequest();
            step20Request.setDocumentoNovedaddummyEnviarEmailpthisDocumentoNovedadInstance(documentoNovedadTDEVOLVERpthisDocumentoNovedad);
            step20Request.setDocumentoNovedaddummyEnviarEmailpTo(documentoNovedadTDEVOLVERpthisDocumentoNovedad.getSolicitud().getAgente().getFuncionarioEmail());
            step20Request.setDocumentoNovedaddummyEnviarEmailpAsunto("Documento devuelto en Solicitud Novedad: " + STDFunctions.intToStrFun(documentoNovedadTDEVOLVERpthisDocumentoNovedad.getSolicitud().getSolicitudNovedadNumRadicado()));
            step20Request.setDocumentoNovedaddummyEnviarEmailpBoby("El día " + STDFunctions.intToStrFun(STDFunctions.getDayFun(STDFunctions.systemDateFun())) + "/" + STDFunctions.intToStrFun(STDFunctions.getMonthFun(STDFunctions.systemDateFun())) + "/" + STDFunctions.intToStrFun(STDFunctions.getYearFun(STDFunctions.systemDateFun())) + " se ha devuelteo un documento en la solicitud de novedad número: " + STDFunctions.intToStrFun(documentoNovedadTDEVOLVERpthisDocumentoNovedad.getSolicitud().getSolicitudNovedadNumRadicado()));
            documentoNovedadSrv.dummyEnviarEmailImplementation(step20Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: TCREARDOCIDDESDECORE

    /*
     * Entry point for service TCREARDOCIDDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARDOCIDDESDECORE(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARDOCIDDESDECORERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.tCREARDOCIDDESDECORETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARDOCIDDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARDOCIDDESDECORETxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARDOCIDDESDECORERequest request) throws ModelException, SystemException {
        request.setDocumentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance(solicitudNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadTCREARDOCIDDESDECOREptSolicitud()));
        return documentoNovedadSrv.tCREARDOCIDDESDECOREImplementation(request);
    }

    /*
     * Implements service TCREARDOCIDDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARDOCIDDESDECOREImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARDOCIDDESDECORERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad documentoNovedadTCREARDOCIDDESDECOREptSolicitud = request.getDocumentoNovedadTCREARDOCIDDESDECOREptSolicitudInstance();
        String documentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor = request.getDocumentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor();
        String documentoNovedadTCREARDOCIDDESDECOREptpNombre = request.getDocumentoNovedadTCREARDOCIDDESDECOREptpNombre();
        String documentoNovedadTCREARDOCIDDESDECOREptpExtension = request.getDocumentoNovedadTCREARDOCIDDESDECOREptpExtension();

        request.checkArguments();
        DocumentoNovedad instance;

        com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest();
        step1Request.setDocumentoNovedadcrearpagrSolicitudInstance(documentoNovedadTCREARDOCIDDESDECOREptSolicitud);
        step1Request.setDocumentoNovedadcrearpagrUsuarioInstance(null);
        step1Request.setDocumentoNovedadcrearpatrDescripcion("DOC. IDENTIFICACION");
        step1Request.setDocumentoNovedadcrearpatrEstado(Long.valueOf(1));
        step1Request.setDocumentoNovedadcrearpatrIdDocEnGestor(documentoNovedadTCREARDOCIDDESDECOREptpatrIdDocEnGestor);
        step1Request.setDocumentoNovedadcrearpatrTipo(Long.valueOf(1));
        step1Request.setDocumentoNovedadcrearpatrNombre(documentoNovedadTCREARDOCIDDESDECOREptpNombre);
        step1Request.setDocumentoNovedadcrearpatrExtension(documentoNovedadTCREARDOCIDDESDECOREptpExtension);
        step1Request.setDocumentoNovedadcrearpatrUsuarioCreador("usuicafile");
        instance = (DocumentoNovedad) documentoNovedadSrv.crearImplementation(step1Request).getInstance();

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest step2Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest();
        step2Request.setSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance(instance.getSolicitud());
        solicitudNovedadSrv.tCALCESTADODOCUImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: TCAMBIARESTADO

    /*
     * Entry point for service TCAMBIARESTADO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCAMBIARESTADO(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.tCAMBIARESTADOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCAMBIARESTADO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCAMBIARESTADOTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest request) throws ModelException, SystemException {
        request.setDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedad()));
        return documentoNovedadSrv.tCAMBIARESTADOImplementation(request);
    }

    /*
     * Implements service TCAMBIARESTADO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCAMBIARESTADOImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long documentoNovedadTCAMBIARESTADOptNuevoEstado = request.getDocumentoNovedadTCAMBIARESTADOptNuevoEstado();
        String documentoNovedadTCAMBIARESTADOptpatrObservacions = request.getDocumentoNovedadTCAMBIARESTADOptpatrObservacions();
        Boolean documentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud = request.getDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud();
        DocumentoNovedad documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad = request.getDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance();

        request.checkArguments();
        DocumentoNovedad instance = documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad;

        /* Action 1: IF (Estado <> ptNuevoEstado) */
        boolean ifCondition1 = !(documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad.getDocumentoNovedadEstado()).equals(documentoNovedadTCAMBIARESTADOptNuevoEstado);
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.TNEWRequest step10Request = new com.keralty.aenovedades.viewmodel.logestadodocnov.siu.TNEWRequest();
            step10Request.setLogEstadoDocNovTNEWptpagrDocumentoNovedadInstance(documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad);
            step10Request.setLogEstadoDocNovTNEWptpatrEstadoAnterior(documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad.getDocumentoNovedadEstado());
            step10Request.setLogEstadoDocNovTNEWptpatrEstadoNuevo(documentoNovedadTCAMBIARESTADOptNuevoEstado);
            step10Request.setLogEstadoDocNovTNEWptpatrObservacions(documentoNovedadTCAMBIARESTADOptpatrObservacions);
            logEstadoDocNovSrv.tNEWImplementation(step10Request);
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarEstadoRequest step11Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarEstadoRequest();
            step11Request.setDocumentoNovedadcambiarEstadopthisDocumentoNovedadInstance(documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad);
            step11Request.setDocumentoNovedadcambiarEstadopeEstado(documentoNovedadTCAMBIARESTADOptNuevoEstado);
            documentoNovedadSrv.cambiarEstadoImplementation(step11Request);
            /* Action 12: IF (ptAjustarEstadoSolicitud = true) */
            boolean ifCondition12 = documentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud.equals(true);
            if (ifCondition12) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest step120Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest();
                step120Request.setSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance(documentoNovedadTCAMBIARESTADOpthisDocumentoNovedad.getSolicitud());
                solicitudNovedadSrv.tCALCESTADODOCUImplementation(step120Request);
            }
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }

    // Service: TCREARATO

    /*
     * Entry point for service TCREARATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARATO(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARATORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = documentoNovedadSrv.tCREARATOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARATOTxn(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARATORequest request) throws ModelException, SystemException {
        request.setDocumentoNovedadTCREARATOptUsuarioInstance(usuarioNovedadSrv.getByOIDWithHV(new UsuarioNovedadOid().fromJsonString(request.getDocumentoNovedadTCREARATOptUsuario())));
        request.setDocumentoNovedadTCREARATOptSolicitudInstance(solicitudNovedadSrv.getByOIDWithHV(request.getDocumentoNovedadTCREARATOptSolicitud()));
        return documentoNovedadSrv.tCREARATOImplementation(request);
    }

    /*
     * Implements service TCREARATO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARATOImplementation(
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCREARATORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long documentoNovedadTCREARATOptpatrTipo = request.getDocumentoNovedadTCREARATOptpatrTipo();
        SolicitudNovedad documentoNovedadTCREARATOptSolicitud = request.getDocumentoNovedadTCREARATOptSolicitudInstance();
        UsuarioNovedad documentoNovedadTCREARATOptUsuario = request.getDocumentoNovedadTCREARATOptUsuarioInstance();
        String documentoNovedadTCREARATOptpatrDescripcion = request.getDocumentoNovedadTCREARATOptpatrDescripcion();
        String documentoNovedadTCREARATOptIdDocGestor = request.getDocumentoNovedadTCREARATOptIdDocGestor();
        String documentoNovedadTCREARATOptNombre = request.getDocumentoNovedadTCREARATOptNombre();
        String documentoNovedadTCREARATOptpExtension = request.getDocumentoNovedadTCREARATOptpExtension();

        request.checkArguments();
        DocumentoNovedad instance;

        /* Action 1: IF (ptpatrTipo = NULL) */
        boolean ifCondition1 = documentoNovedadTCREARATOptpatrTipo == null;
        if (ifCondition1) {
            /* Action 10: IF (AGENTFuncionario <> NULL) */
            boolean ifCondition10 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
            if (ifCondition10) {
                com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest step100Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest();
                step100Request.setDocumentoNovedadcrearpagrSolicitudInstance(documentoNovedadTCREARATOptSolicitud);
                step100Request.setDocumentoNovedadcrearpagrUsuarioInstance(documentoNovedadTCREARATOptUsuario);
                step100Request.setDocumentoNovedadcrearpatrDescripcion(documentoNovedadTCREARATOptpatrDescripcion);
                step100Request.setDocumentoNovedadcrearpatrEstado(Long.valueOf(1));
                step100Request.setDocumentoNovedadcrearpatrIdDocEnGestor(documentoNovedadTCREARATOptIdDocGestor);
                step100Request.setDocumentoNovedadcrearpatrTipo(Long.valueOf(2));
                step100Request.setDocumentoNovedadcrearpatrNombre(documentoNovedadTCREARATOptNombre);
                step100Request.setDocumentoNovedadcrearpatrExtension(documentoNovedadTCREARATOptpExtension);
                step100Request.setDocumentoNovedadcrearpatrUsuarioCreador(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
                instance = (DocumentoNovedad) documentoNovedadSrv.crearImplementation(step100Request).getInstance();
            } else {
                com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest step101Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest();
                step101Request.setDocumentoNovedadcrearpagrSolicitudInstance(documentoNovedadTCREARATOptSolicitud);
                step101Request.setDocumentoNovedadcrearpagrUsuarioInstance(documentoNovedadTCREARATOptUsuario);
                step101Request.setDocumentoNovedadcrearpatrDescripcion(documentoNovedadTCREARATOptpatrDescripcion);
                step101Request.setDocumentoNovedadcrearpatrEstado(Long.valueOf(1));
                step101Request.setDocumentoNovedadcrearpatrIdDocEnGestor(documentoNovedadTCREARATOptIdDocGestor);
                step101Request.setDocumentoNovedadcrearpatrTipo(Long.valueOf(2));
                step101Request.setDocumentoNovedadcrearpatrNombre(documentoNovedadTCREARATOptNombre);
                step101Request.setDocumentoNovedadcrearpatrExtension(documentoNovedadTCREARATOptpExtension);
                step101Request.setDocumentoNovedadcrearpatrUsuarioCreador("usuicafile");
                instance = (DocumentoNovedad) documentoNovedadSrv.crearImplementation(step101Request).getInstance();
            }
        } else {
            /* Action 11: IF (AGENTFuncionario <> NULL) */
            boolean ifCondition11 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
            if (ifCondition11) {
                com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest step110Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest();
                step110Request.setDocumentoNovedadcrearpagrSolicitudInstance(documentoNovedadTCREARATOptSolicitud);
                step110Request.setDocumentoNovedadcrearpagrUsuarioInstance(documentoNovedadTCREARATOptUsuario);
                step110Request.setDocumentoNovedadcrearpatrDescripcion(documentoNovedadTCREARATOptpatrDescripcion);
                step110Request.setDocumentoNovedadcrearpatrEstado(Long.valueOf(1));
                step110Request.setDocumentoNovedadcrearpatrIdDocEnGestor(documentoNovedadTCREARATOptIdDocGestor);
                step110Request.setDocumentoNovedadcrearpatrTipo(documentoNovedadTCREARATOptpatrTipo);
                step110Request.setDocumentoNovedadcrearpatrNombre(documentoNovedadTCREARATOptNombre);
                step110Request.setDocumentoNovedadcrearpatrExtension(documentoNovedadTCREARATOptpExtension);
                step110Request.setDocumentoNovedadcrearpatrUsuarioCreador(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
                instance = (DocumentoNovedad) documentoNovedadSrv.crearImplementation(step110Request).getInstance();
            } else {
                com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest step111Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.CrearRequest();
                step111Request.setDocumentoNovedadcrearpagrSolicitudInstance(documentoNovedadTCREARATOptSolicitud);
                step111Request.setDocumentoNovedadcrearpagrUsuarioInstance(documentoNovedadTCREARATOptUsuario);
                step111Request.setDocumentoNovedadcrearpatrDescripcion(documentoNovedadTCREARATOptpatrDescripcion);
                step111Request.setDocumentoNovedadcrearpatrEstado(Long.valueOf(1));
                step111Request.setDocumentoNovedadcrearpatrIdDocEnGestor(documentoNovedadTCREARATOptIdDocGestor);
                step111Request.setDocumentoNovedadcrearpatrTipo(documentoNovedadTCREARATOptpatrTipo);
                step111Request.setDocumentoNovedadcrearpatrNombre(documentoNovedadTCREARATOptNombre);
                step111Request.setDocumentoNovedadcrearpatrExtension(documentoNovedadTCREARATOptpExtension);
                step111Request.setDocumentoNovedadcrearpatrUsuarioCreador("usuicafile");
                instance = (DocumentoNovedad) documentoNovedadSrv.crearImplementation(step111Request).getInstance();
            }
        }

        com.keralty.aenovedades.viewmodel.documentonovedad.siu.SubirDocumentoGestorATORequest step2Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.SubirDocumentoGestorATORequest();
        step2Request.setDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance(instance);
        step2Request.setDocumentoNovedadsubirDocumentoGestorATOpeIdDocGestor(documentoNovedadTCREARATOptIdDocGestor);
        step2Request.setDocumentoNovedadsubirDocumentoGestorATOptNombre(documentoNovedadTCREARATOptNombre);
        documentoNovedadSrv.subirDocumentoGestorATOImplementation(step2Request);

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarFechaUltDocRequest step3Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarFechaUltDocRequest();
        step3Request.setSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance(instance.getSolicitud());
        step3Request.setSolicitudNovedadcambiarFechaUltDocpeFechaHora(instance.getDocumentoNovedadFechaSubida());
        solicitudNovedadSrv.cambiarFechaUltDocImplementation(step3Request);

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest step4Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest();
        step4Request.setSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance(instance.getSolicitud());
        solicitudNovedadSrv.tCALCESTADODOCUImplementation(step4Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICDocumentoNovedad());

        return response;
    }


    private void suppInfo4ICDocumentoNovedad(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DocumentoNovedadConstants.ATTR_NAME_DOCUMENTONOVEDADNOMBRE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            conjunction.addDisjunction(disjunction);
            select.addConjunction(conjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
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
        select.getOrderByPart().addItem(Constants.normalizePath(DocumentoNovedadConstants.CLASS_NAME, DocumentoNovedadConstants.ATTR_FIELD_DOCUMENTONOVEDADIDDOCUMENTO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildDocumentoNovedadRelatedInstance(relatedInstanceJsonOid);
        }
        if (DocumentoNovedadConstants.ROLE_NAME_LOGESTADODOCNOV.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDocumentoNovedadRelatedInstance4LogEstadoDocNov(relatedInstanceJsonOid, remainingPath);
        }
        if (DocumentoNovedadConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDocumentoNovedadRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (DocumentoNovedadConstants.ROLE_NAME_USUARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDocumentoNovedadRelatedInstance4UsuarioNovedad(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildDocumentoNovedadRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new DocumentoNovedad(mapper.readValue(relatedInstanceJsonOid, DocumentoNovedadOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDocumentoNovedadRelatedInstance4LogEstadoDocNov(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogEstadoDocNov(mapper.readValue(relatedInstanceJsonOid, LogEstadoDocNovOid.class)): LogEstadoDocNov.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDocumentoNovedadRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDocumentoNovedadRelatedInstance4UsuarioNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new UsuarioNovedad(mapper.readValue(relatedInstanceJsonOid, UsuarioNovedadOid.class)): UsuarioNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            DocumentoNovedadOid oid = new DocumentoNovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DocumentoNovedadConstants.ATTR_FIELD_DOCUMENTONOVEDADIDDOCUMENTO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDocumentoNovedadIdDocumento(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(DocumentoNovedadService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
