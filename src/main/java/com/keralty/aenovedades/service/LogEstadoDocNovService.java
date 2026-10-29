package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.FuncionarioConstants;
import com.keralty.aenovedades.global.LogEstadoDocNovConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;
import com.keralty.aenovedades.persistence.oid.LogEstadoDocNovOid;
import com.keralty.aenovedades.repository.LogEstadoDocNovJpaRepository;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aenovedades.viewmodel.FilterRequest;
import com.keralty.aenovedades.viewmodel.FilterVariableRequest;
import com.keralty.aenovedades.viewmodel.InstanceResponseViewModel;
import com.keralty.aenovedades.viewmodel.PopulationResponseViewModel;
import com.keralty.aenovedades.viewmodel.PreloadResponseViewModel;
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class LogEstadoDocNovService extends AbstractService {

    LogEstadoDocNovJpaRepository repository;

    LogEstadoDocNovService logEstadoDocNovSrv;

    DocumentoNovedadService documentoNovedadSrv;

    @Inject
    public LogEstadoDocNovService(
            LogEstadoDocNovService logEstadoDocNovSrv,
            DocumentoNovedadService documentoNovedadSrv,
            LogEstadoDocNovJpaRepository repository) {
        this.logEstadoDocNovSrv = logEstadoDocNovSrv;
        this.documentoNovedadSrv = documentoNovedadSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, LogEstadoDocNovConstants.CLASS_NAME);
    }

    private List<LogEstadoDocNov> solveLogEstadoDocNovTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, LogEstadoDocNovConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveLogEstadoDocNovTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, LogEstadoDocNovConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class LogEstadoDocNov
     *
     * @return Population of class LogEstadoDocNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoDocNov> get() {
        List<LogEstadoDocNov> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class LogEstadoDocNov that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class LogEstadoDocNov matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoDocNov> get(QueryRequest queryRequest) {
        return solveLogEstadoDocNovTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveLogEstadoDocNovTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveLogEstadoDocNovTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
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
        return new PopulationResponseViewModel(solveLogEstadoDocNovTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of LogEstadoDocNov by ID
     *
     * @param logEstadoDocNovId Identification field logEstadoDocNovId
     *
     * @return Instance of LogEstadoDocNov
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogEstadoDocNov getById(Long logEstadoDocNovId) {
        return getByOID(new LogEstadoDocNovOid(logEstadoDocNovId));
    }
    
    /*
     * Returns an instance of LogEstadoDocNov by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogEstadoDocNov
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogEstadoDocNov getByOID(LogEstadoDocNovOid oid) {
        Optional<LogEstadoDocNov> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of LogEstadoDocNov by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogEstadoDocNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public LogEstadoDocNov getByOIDWithHV(LogEstadoDocNovOid oid) {
        Optional<LogEstadoDocNov> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<LogEstadoDocNov> getInstanceByOid(LogEstadoDocNovOid oid) {
        return oid != null && oid.getLogEstadoDocNovId() != null
               ? repository.findById(oid.getLogEstadoDocNovId())
               : Optional.empty();
    }

    /*
     * Returns an instance of LogEstadoDocNov by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of LogEstadoDocNov
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public LogEstadoDocNov getByJsonOid(String jsonOid) {
        LogEstadoDocNovOid oid = new LogEstadoDocNovOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of LogEstadoDocNov related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogEstadoDocNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoDocNov> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveLogEstadoDocNovTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of LogEstadoDocNov related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogEstadoDocNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoDocNov> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of LogEstadoDocNov
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of LogEstadoDocNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getLogEstadoDocNovDynamic(LogEstadoDocNovOid oid, String displaySetItems) {
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
    public String getSuppInfo(LogEstadoDocNovOid oid, String dsName) {
        LogEstadoDocNov instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(LogEstadoDocNov instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIULogEstadoDocNov
     *
     * @param queryRequest Query request
     * @return List of viewmodels for LogEstadoDocNov using displayset DSLogEstadoDocNov that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.logestadodocnov.ds.DSLogEstadoDocNov> piuPIULogEstadoDocNov(QueryRequest queryRequest) {
        return solveLogEstadoDocNovTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.logestadodocnov.ds.DSLogEstadoDocNov::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIULogEstadoDocNov
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIULogEstadoDocNov
     */
    public int getCount4PIULogEstadoDocNov(QueryRequest queryRequest) {
        return solveLogEstadoDocNovTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logEstadoDocNovSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.CrearRequest request) throws ModelException {
        request.setLogEstadoDocNovcrearpagrDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getLogEstadoDocNovcrearpagrDocumentoNovedad()));
        return logEstadoDocNovSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad logEstadoDocNovcrearpagrDocumentoNovedad = request.getLogEstadoDocNovcrearpagrDocumentoNovedadInstance();
        String logEstadoDocNovcrearpatrNombreFuncionario = request.getLogEstadoDocNovcrearpatrNombreFuncionario();
        Long logEstadoDocNovcrearpatrEstadoAnterior = request.getLogEstadoDocNovcrearpatrEstadoAnterior();
        Long logEstadoDocNovcrearpatrEstadoNuevo = request.getLogEstadoDocNovcrearpatrEstadoNuevo();
        String logEstadoDocNovcrearpatrObservacions = request.getLogEstadoDocNovcrearpatrObservacions();

        request.checkArguments();
        LogEstadoDocNov instance = new LogEstadoDocNov();
        instance.add2DocumentoNovedad(logEstadoDocNovcrearpagrDocumentoNovedad);

        instance.setLogEstadoDocNovId(Long.valueOf(0));
        instance.setLogEstadoDocNovFecha(STDFunctions.systemDateTimeFun());
        instance.setLogEstadoDocNovNombreFuncionario(logEstadoDocNovcrearpatrNombreFuncionario);
        instance.setLogEstadoDocNovEstadoAnterior(logEstadoDocNovcrearpatrEstadoAnterior);
        instance.setLogEstadoDocNovEstadoNuevo(logEstadoDocNovcrearpatrEstadoNuevo);
        instance.setLogEstadoDocNovObservacions(logEstadoDocNovcrearpatrObservacions);

        response.setInstance(repository.save(instance));

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
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logEstadoDocNovSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.EliminarRequest request) throws ModelException {
        request.setLogEstadoDocNoveliminarpthisObsEstadoNovInstance(logEstadoDocNovSrv.getByOIDWithHV(request.getLogEstadoDocNoveliminarpthisObsEstadoNov()));
        return logEstadoDocNovSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        LogEstadoDocNov logEstadoDocNoveliminarpthisObsEstadoNov = request.getLogEstadoDocNoveliminarpthisObsEstadoNovInstance();

        request.checkArguments();
        LogEstadoDocNov instance = logEstadoDocNoveliminarpthisObsEstadoNov;


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: TNEW

    /*
     * Entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEW(
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.TNEWRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logEstadoDocNovSrv.tNEWTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWTxn(
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.TNEWRequest request) throws ModelException {
        request.setLogEstadoDocNovTNEWptpagrDocumentoNovedadInstance(documentoNovedadSrv.getByOIDWithHV(request.getLogEstadoDocNovTNEWptpagrDocumentoNovedad()));
        return logEstadoDocNovSrv.tNEWImplementation(request);
    }

    /*
     * Implements service TNEW
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWImplementation(
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.TNEWRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DocumentoNovedad logEstadoDocNovTNEWptpagrDocumentoNovedad = request.getLogEstadoDocNovTNEWptpagrDocumentoNovedadInstance();
        Long logEstadoDocNovTNEWptpatrEstadoAnterior = request.getLogEstadoDocNovTNEWptpatrEstadoAnterior();
        Long logEstadoDocNovTNEWptpatrEstadoNuevo = request.getLogEstadoDocNovTNEWptpatrEstadoNuevo();
        String logEstadoDocNovTNEWptpatrObservacions = request.getLogEstadoDocNovTNEWptpatrObservacions();

        request.checkArguments();
        LogEstadoDocNov instance;

        /* Action 1: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition1 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.CrearRequest step10Request = new com.keralty.aenovedades.viewmodel.logestadodocnov.siu.CrearRequest();
            step10Request.setLogEstadoDocNovcrearpagrDocumentoNovedadInstance(logEstadoDocNovTNEWptpagrDocumentoNovedad);
            step10Request.setLogEstadoDocNovcrearpatrNombreFuncionario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionariodrvNombreCompleto());
            step10Request.setLogEstadoDocNovcrearpatrEstadoAnterior(logEstadoDocNovTNEWptpatrEstadoAnterior);
            step10Request.setLogEstadoDocNovcrearpatrEstadoNuevo(logEstadoDocNovTNEWptpatrEstadoNuevo);
            step10Request.setLogEstadoDocNovcrearpatrObservacions(logEstadoDocNovTNEWptpatrObservacions);
            instance = (LogEstadoDocNov) logEstadoDocNovSrv.crearImplementation(step10Request).getInstance();
        } else {
            com.keralty.aenovedades.viewmodel.logestadodocnov.siu.CrearRequest step11Request = new com.keralty.aenovedades.viewmodel.logestadodocnov.siu.CrearRequest();
            step11Request.setLogEstadoDocNovcrearpagrDocumentoNovedadInstance(logEstadoDocNovTNEWptpagrDocumentoNovedad);
            step11Request.setLogEstadoDocNovcrearpatrNombreFuncionario("usuicafile");
            step11Request.setLogEstadoDocNovcrearpatrEstadoAnterior(logEstadoDocNovTNEWptpatrEstadoAnterior);
            step11Request.setLogEstadoDocNovcrearpatrEstadoNuevo(logEstadoDocNovTNEWptpatrEstadoNuevo);
            step11Request.setLogEstadoDocNovcrearpatrObservacions(logEstadoDocNovTNEWptpatrObservacions);
            instance = (LogEstadoDocNov) logEstadoDocNovSrv.crearImplementation(step11Request).getInstance();
        }

        response.setInstance(getByOID(instance.getOid()));

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
        select.getOrderByPart().addItem(Constants.normalizePath(LogEstadoDocNovConstants.CLASS_NAME, LogEstadoDocNovConstants.ATTR_FIELD_LOGESTADODOCNOVID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildLogEstadoDocNovRelatedInstance(relatedInstanceJsonOid);
        }
        if (LogEstadoDocNovConstants.ROLE_NAME_DOCUMENTONOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildLogEstadoDocNovRelatedInstance4DocumentoNovedad(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildLogEstadoDocNovRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new LogEstadoDocNov(mapper.readValue(relatedInstanceJsonOid, LogEstadoDocNovOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildLogEstadoDocNovRelatedInstance4DocumentoNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DocumentoNovedad(mapper.readValue(relatedInstanceJsonOid, DocumentoNovedadOid.class)): DocumentoNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            LogEstadoDocNovOid oid = new LogEstadoDocNovOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(LogEstadoDocNovConstants.ATTR_FIELD_LOGESTADODOCNOVID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getLogEstadoDocNovId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(LogEstadoDocNovService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
