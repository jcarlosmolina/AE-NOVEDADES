package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.FuncionarioConstants;
import com.keralty.aenovedades.global.LogEstadoSNConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.LogEstadoSN;
import com.keralty.aenovedades.persistence.oid.LogEstadoSNOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.repository.LogEstadoSNJpaRepository;
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
public class LogEstadoSNService extends AbstractService {

    LogEstadoSNJpaRepository repository;

    LogEstadoSNService logEstadoSNSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    @Inject
    public LogEstadoSNService(
            LogEstadoSNService logEstadoSNSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            LogEstadoSNJpaRepository repository) {
        this.logEstadoSNSrv = logEstadoSNSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, LogEstadoSNConstants.CLASS_NAME);
    }

    private List<LogEstadoSN> solveLogEstadoSNTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, LogEstadoSNConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveLogEstadoSNTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, LogEstadoSNConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class LogEstadoSN
     *
     * @return Population of class LogEstadoSN
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoSN> get() {
        List<LogEstadoSN> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class LogEstadoSN that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class LogEstadoSN matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoSN> get(QueryRequest queryRequest) {
        return solveLogEstadoSNTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveLogEstadoSNTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveLogEstadoSNTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveLogEstadoSNTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of LogEstadoSN by ID
     *
     * @param logEstadoSNId Identification field logEstadoSNId
     *
     * @return Instance of LogEstadoSN
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogEstadoSN getById(Long logEstadoSNId) {
        return getByOID(new LogEstadoSNOid(logEstadoSNId));
    }
    
    /*
     * Returns an instance of LogEstadoSN by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogEstadoSN
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogEstadoSN getByOID(LogEstadoSNOid oid) {
        Optional<LogEstadoSN> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of LogEstadoSN by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogEstadoSN
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public LogEstadoSN getByOIDWithHV(LogEstadoSNOid oid) {
        Optional<LogEstadoSN> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<LogEstadoSN> getInstanceByOid(LogEstadoSNOid oid) {
        return oid != null && oid.getLogEstadoSNId() != null
               ? repository.findById(oid.getLogEstadoSNId())
               : Optional.empty();
    }

    /*
     * Returns an instance of LogEstadoSN by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of LogEstadoSN
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public LogEstadoSN getByJsonOid(String jsonOid) {
        LogEstadoSNOid oid = new LogEstadoSNOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of LogEstadoSN related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogEstadoSN
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoSN> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveLogEstadoSNTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of LogEstadoSN related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogEstadoSN
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogEstadoSN> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of LogEstadoSN
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of LogEstadoSN
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getLogEstadoSNDynamic(LogEstadoSNOid oid, String displaySetItems) {
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
    public String getSuppInfo(LogEstadoSNOid oid, String dsName) {
        LogEstadoSN instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(LogEstadoSN instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIULogEstadoSN
     *
     * @param queryRequest Query request
     * @return List of viewmodels for LogEstadoSN using displayset DSLogEstadoSNPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.logestadosn.ds.DSLogEstadoSNPIU> piuPIULogEstadoSN(QueryRequest queryRequest) {
        return solveLogEstadoSNTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.logestadosn.ds.DSLogEstadoSNPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIULogEstadoSN
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIULogEstadoSN
     */
    public int getCount4PIULogEstadoSN(QueryRequest queryRequest) {
        return solveLogEstadoSNTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.logestadosn.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logEstadoSNSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.logestadosn.siu.CrearRequest request) throws ModelException {
        request.setLogEstadoSNcrearpagrSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getLogEstadoSNcrearpagrSolicitudNovedad()));
        return logEstadoSNSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.logestadosn.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad logEstadoSNcrearpagrSolicitudNovedad = request.getLogEstadoSNcrearpagrSolicitudNovedadInstance();
        String logEstadoSNcrearpatrLoginFuncionario = request.getLogEstadoSNcrearpatrLoginFuncionario();
        Long logEstadoSNcrearpatrEstado = request.getLogEstadoSNcrearpatrEstado();
        Long logEstadoSNcrearpatrEstadoDoc = request.getLogEstadoSNcrearpatrEstadoDoc();

        request.checkArguments();
        LogEstadoSN instance = new LogEstadoSN();
        instance.add2SolicitudNovedad(logEstadoSNcrearpagrSolicitudNovedad);

        instance.setLogEstadoSNId(Long.valueOf(0));
        instance.setLogEstadoSNFecha(STDFunctions.systemDateTimeFun());
        instance.setLogEstadoSNLoginFuncionario(logEstadoSNcrearpatrLoginFuncionario);
        instance.setLogEstadoSNEstado(logEstadoSNcrearpatrEstado);
        instance.setLogEstadoSNEstadoDoc(logEstadoSNcrearpatrEstadoDoc);

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
            com.keralty.aenovedades.viewmodel.logestadosn.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logEstadoSNSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.logestadosn.siu.EliminarRequest request) throws ModelException {
        request.setLogEstadoSNeliminarpthisLogEstadoSNInstance(logEstadoSNSrv.getByOIDWithHV(request.getLogEstadoSNeliminarpthisLogEstadoSN()));
        return logEstadoSNSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.logestadosn.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        LogEstadoSN logEstadoSNeliminarpthisLogEstadoSN = request.getLogEstadoSNeliminarpthisLogEstadoSNInstance();

        request.checkArguments();
        LogEstadoSN instance = logEstadoSNeliminarpthisLogEstadoSN;


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: TCREAR

    /*
     * Entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAR(
            com.keralty.aenovedades.viewmodel.logestadosn.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logEstadoSNSrv.tCREARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARTxn(
            com.keralty.aenovedades.viewmodel.logestadosn.siu.TCREARRequest request) throws ModelException {
        request.setLogEstadoSNTCREARptpagrSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getLogEstadoSNTCREARptpagrSolicitudNovedad()));
        return logEstadoSNSrv.tCREARImplementation(request);
    }

    /*
     * Implements service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARImplementation(
            com.keralty.aenovedades.viewmodel.logestadosn.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad logEstadoSNTCREARptpagrSolicitudNovedad = request.getLogEstadoSNTCREARptpagrSolicitudNovedadInstance();
        Long logEstadoSNTCREARptpatrEstado = request.getLogEstadoSNTCREARptpatrEstado();
        Long logEstadoSNTCREARptpatrEstadoDoc = request.getLogEstadoSNTCREARptpatrEstadoDoc();

        request.checkArguments();
        LogEstadoSN instance;

        /* Action 1: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition1 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.logestadosn.siu.CrearRequest step10Request = new com.keralty.aenovedades.viewmodel.logestadosn.siu.CrearRequest();
            step10Request.setLogEstadoSNcrearpagrSolicitudNovedadInstance(logEstadoSNTCREARptpagrSolicitudNovedad);
            step10Request.setLogEstadoSNcrearpatrLoginFuncionario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
            step10Request.setLogEstadoSNcrearpatrEstado(logEstadoSNTCREARptpatrEstado);
            step10Request.setLogEstadoSNcrearpatrEstadoDoc(logEstadoSNTCREARptpatrEstadoDoc);
            instance = (LogEstadoSN) logEstadoSNSrv.crearImplementation(step10Request).getInstance();
        } else {
            com.keralty.aenovedades.viewmodel.logestadosn.siu.CrearRequest step11Request = new com.keralty.aenovedades.viewmodel.logestadosn.siu.CrearRequest();
            step11Request.setLogEstadoSNcrearpagrSolicitudNovedadInstance(logEstadoSNTCREARptpagrSolicitudNovedad);
            step11Request.setLogEstadoSNcrearpatrLoginFuncionario("usuicafile");
            step11Request.setLogEstadoSNcrearpatrEstado(logEstadoSNTCREARptpatrEstado);
            step11Request.setLogEstadoSNcrearpatrEstadoDoc(logEstadoSNTCREARptpatrEstadoDoc);
            instance = (LogEstadoSN) logEstadoSNSrv.crearImplementation(step11Request).getInstance();
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
        select.getOrderByPart().addItem(Constants.normalizePath(LogEstadoSNConstants.CLASS_NAME, LogEstadoSNConstants.ATTR_FIELD_LOGESTADOSNID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildLogEstadoSNRelatedInstance(relatedInstanceJsonOid);
        }
        if (LogEstadoSNConstants.ROLE_NAME_SOLICITUDNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildLogEstadoSNRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildLogEstadoSNRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new LogEstadoSN(mapper.readValue(relatedInstanceJsonOid, LogEstadoSNOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildLogEstadoSNRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            LogEstadoSNOid oid = new LogEstadoSNOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(LogEstadoSNConstants.ATTR_FIELD_LOGESTADOSNID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getLogEstadoSNId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(LogEstadoSNService.class).error(e.getMessage());
        }
    }

}
