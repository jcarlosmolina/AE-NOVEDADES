package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.FuncionarioConstants;
import com.keralty.aenovedades.global.LogUsrSolNovConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.LogUsrSolNov;
import com.keralty.aenovedades.persistence.oid.LogUsrSolNovOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.repository.LogUsrSolNovJpaRepository;
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
public class LogUsrSolNovService extends AbstractService {

    LogUsrSolNovJpaRepository repository;

    LogUsrSolNovService logUsrSolNovSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    @Inject
    public LogUsrSolNovService(
            LogUsrSolNovService logUsrSolNovSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            LogUsrSolNovJpaRepository repository) {
        this.logUsrSolNovSrv = logUsrSolNovSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, LogUsrSolNovConstants.CLASS_NAME);
    }

    private List<LogUsrSolNov> solveLogUsrSolNovTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, LogUsrSolNovConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveLogUsrSolNovTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, LogUsrSolNovConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class LogUsrSolNov
     *
     * @return Population of class LogUsrSolNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogUsrSolNov> get() {
        List<LogUsrSolNov> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class LogUsrSolNov that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class LogUsrSolNov matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogUsrSolNov> get(QueryRequest queryRequest) {
        return solveLogUsrSolNovTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveLogUsrSolNovTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveLogUsrSolNovTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveLogUsrSolNovTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of LogUsrSolNov by ID
     *
     * @param logUsrSolNovId Identification field logUsrSolNovId
     *
     * @return Instance of LogUsrSolNov
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogUsrSolNov getById(Long logUsrSolNovId) {
        return getByOID(new LogUsrSolNovOid(logUsrSolNovId));
    }
    
    /*
     * Returns an instance of LogUsrSolNov by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogUsrSolNov
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogUsrSolNov getByOID(LogUsrSolNovOid oid) {
        Optional<LogUsrSolNov> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of LogUsrSolNov by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogUsrSolNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public LogUsrSolNov getByOIDWithHV(LogUsrSolNovOid oid) {
        Optional<LogUsrSolNov> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<LogUsrSolNov> getInstanceByOid(LogUsrSolNovOid oid) {
        return oid != null && oid.getLogUsrSolNovId() != null
               ? repository.findById(oid.getLogUsrSolNovId())
               : Optional.empty();
    }

    /*
     * Returns an instance of LogUsrSolNov by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of LogUsrSolNov
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public LogUsrSolNov getByJsonOid(String jsonOid) {
        LogUsrSolNovOid oid = new LogUsrSolNovOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of LogUsrSolNov related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogUsrSolNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogUsrSolNov> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveLogUsrSolNovTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of LogUsrSolNov related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogUsrSolNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogUsrSolNov> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of LogUsrSolNov
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of LogUsrSolNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getLogUsrSolNovDynamic(LogUsrSolNovOid oid, String displaySetItems) {
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
    public String getSuppInfo(LogUsrSolNovOid oid, String dsName) {
        LogUsrSolNov instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(LogUsrSolNov instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIULogUsrSolNov
     *
     * @param queryRequest Query request
     * @return List of viewmodels for LogUsrSolNov using displayset DSLogUsrSolNov that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.logusrsolnov.ds.DSLogUsrSolNov> piuPIULogUsrSolNov(QueryRequest queryRequest) {
        return solveLogUsrSolNovTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.logusrsolnov.ds.DSLogUsrSolNov::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIULogUsrSolNov
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIULogUsrSolNov
     */
    public int getCount4PIULogUsrSolNov(QueryRequest queryRequest) {
        return solveLogUsrSolNovTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logUsrSolNovSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.CrearRequest request) throws ModelException {
        request.setLogUsrSolNovcrearpagrSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getLogUsrSolNovcrearpagrSolicitudNovedad()));
        return logUsrSolNovSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad logUsrSolNovcrearpagrSolicitudNovedad = request.getLogUsrSolNovcrearpagrSolicitudNovedadInstance();
        String logUsrSolNovcrearpatrLoginFuncionario = request.getLogUsrSolNovcrearpatrLoginFuncionario();
        String logUsrSolNovcrearpatrUsuario = request.getLogUsrSolNovcrearpatrUsuario();

        request.checkArguments();
        LogUsrSolNov instance = new LogUsrSolNov();
        instance.add2SolicitudNovedad(logUsrSolNovcrearpagrSolicitudNovedad);

        instance.setLogUsrSolNovId(Long.valueOf(0));
        instance.setLogUsrSolNovFecha(STDFunctions.systemDateTimeFun());
        instance.setLogUsrSolNovLoginFuncionario(logUsrSolNovcrearpatrLoginFuncionario);
        instance.setLogUsrSolNovUsuario(logUsrSolNovcrearpatrUsuario);

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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logUsrSolNovSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.EliminarRequest request) throws ModelException {
        request.setLogUsrSolNoveliminarpthisLogUsrSolNovInstance(logUsrSolNovSrv.getByOIDWithHV(request.getLogUsrSolNoveliminarpthisLogUsrSolNov()));
        return logUsrSolNovSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        LogUsrSolNov logUsrSolNoveliminarpthisLogUsrSolNov = request.getLogUsrSolNoveliminarpthisLogUsrSolNovInstance();

        request.checkArguments();
        LogUsrSolNov instance = logUsrSolNoveliminarpthisLogUsrSolNov;


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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logUsrSolNovSrv.tCREARTxn(request);
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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.TCREARRequest request) throws ModelException {
        request.setLogUsrSolNovTCREARptpagrSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getLogUsrSolNovTCREARptpagrSolicitudNovedad()));
        return logUsrSolNovSrv.tCREARImplementation(request);
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
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad logUsrSolNovTCREARptpagrSolicitudNovedad = request.getLogUsrSolNovTCREARptpagrSolicitudNovedadInstance();
        String logUsrSolNovTCREARptpatrUsuario = request.getLogUsrSolNovTCREARptpatrUsuario();

        request.checkArguments();
        LogUsrSolNov instance;

        /* Action 1: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition1 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.CrearRequest step10Request = new com.keralty.aenovedades.viewmodel.logusrsolnov.siu.CrearRequest();
            step10Request.setLogUsrSolNovcrearpagrSolicitudNovedadInstance(logUsrSolNovTCREARptpagrSolicitudNovedad);
            step10Request.setLogUsrSolNovcrearpatrLoginFuncionario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
            step10Request.setLogUsrSolNovcrearpatrUsuario(logUsrSolNovTCREARptpatrUsuario);
            instance = (LogUsrSolNov) logUsrSolNovSrv.crearImplementation(step10Request).getInstance();
        } else {
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.CrearRequest step11Request = new com.keralty.aenovedades.viewmodel.logusrsolnov.siu.CrearRequest();
            step11Request.setLogUsrSolNovcrearpagrSolicitudNovedadInstance(logUsrSolNovTCREARptpagrSolicitudNovedad);
            step11Request.setLogUsrSolNovcrearpatrLoginFuncionario("usuicafile");
            step11Request.setLogUsrSolNovcrearpatrUsuario(logUsrSolNovTCREARptpatrUsuario);
            instance = (LogUsrSolNov) logUsrSolNovSrv.crearImplementation(step11Request).getInstance();
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
        select.getOrderByPart().addItem(Constants.normalizePath(LogUsrSolNovConstants.CLASS_NAME, LogUsrSolNovConstants.ATTR_FIELD_LOGUSRSOLNOVID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildLogUsrSolNovRelatedInstance(relatedInstanceJsonOid);
        }
        if (LogUsrSolNovConstants.ROLE_NAME_SOLICITUDNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildLogUsrSolNovRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildLogUsrSolNovRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new LogUsrSolNov(mapper.readValue(relatedInstanceJsonOid, LogUsrSolNovOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildLogUsrSolNovRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            LogUsrSolNovOid oid = new LogUsrSolNovOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(LogUsrSolNovConstants.ATTR_FIELD_LOGUSRSOLNOVID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getLogUsrSolNovId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(LogUsrSolNovService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
