package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.EstadoContratoConstants;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Aesolicitudes;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.oid.AesolicitudesOid;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.repository.EstadoContratoJpaRepository;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class EstadoContratoService extends AbstractService {

    EstadoContratoJpaRepository repository;

    EstadoContratoService estadoContratoSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    AesolicitudesService aesolicitudesSrv;

    @Inject
    public EstadoContratoService(
            EstadoContratoService estadoContratoSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            AesolicitudesService aesolicitudesSrv,
            EstadoContratoJpaRepository repository) {
        this.estadoContratoSrv = estadoContratoSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.aesolicitudesSrv = aesolicitudesSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, EstadoContratoConstants.CLASS_NAME);
    }

    private List<EstadoContrato> solveEstadoContratoTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, EstadoContratoConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveEstadoContratoTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, EstadoContratoConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class EstadoContrato
     *
     * @return Population of class EstadoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<EstadoContrato> get() {
        List<EstadoContrato> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class EstadoContrato
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class EstadoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<EstadoContrato> instances = get(queryRequest);
        if(EstadoContratoConstants.DSICESTADOCONTRATO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICEstadoContrato())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class EstadoContrato that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class EstadoContrato matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<EstadoContrato> get(QueryRequest queryRequest) {
        return solveEstadoContratoTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveEstadoContratoTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveEstadoContratoTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveEstadoContratoTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveEstadoContratoTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of EstadoContrato by ID
     *
     * @param estadoContratoCodigo Identification field estadoContratoCodigo
     *
     * @return Instance of EstadoContrato
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public EstadoContrato getById(Long estadoContratoCodigo) {
        return getByOID(new EstadoContratoOid(estadoContratoCodigo));
    }
    
    /*
     * Returns an instance of EstadoContrato by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoContrato
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public EstadoContrato getByOID(EstadoContratoOid oid) {
        Optional<EstadoContrato> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of EstadoContrato by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoContrato getByOIDWithHV(EstadoContratoOid oid) {
        Optional<EstadoContrato> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<EstadoContrato> getInstanceByOid(EstadoContratoOid oid) {
        return oid != null && oid.getEstadoContratoCodigo() != null
               ? repository.findById(oid.getEstadoContratoCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of EstadoContrato by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of EstadoContrato
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public EstadoContrato getByJsonOid(String jsonOid) {
        EstadoContratoOid oid = new EstadoContratoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of EstadoContrato related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of EstadoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<EstadoContrato> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveEstadoContratoTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of EstadoContrato related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of EstadoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<EstadoContrato> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of EstadoContrato
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of EstadoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getEstadoContratoDynamic(EstadoContratoOid oid, String displaySetItems) {
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
    public String getSuppInfo(EstadoContratoOid oid, String dsName) {
        EstadoContrato instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(EstadoContrato instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (EstadoContratoConstants.DSICESTADOCONTRATO.equals(dsName))
            return instance.buildICEstadoContrato();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(EstadoContrato instance, String dsName) {
        if (EstadoContratoConstants.DSICESTADOCONTRATO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICEstadoContrato());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (EstadoContratoConstants.FILTER_NAME_IFESTADOCONTRATOCONTRATO.equalsIgnoreCase(filterRequest.getName()))
            iFEstadoContratoContrato(filterRequest, sql);
        if (EstadoContratoConstants.FILTER_NAME_IFESTADOCONTRATOCONTRATOPORNO.equalsIgnoreCase(filterRequest.getName()))
            iFEstadoContratoContratoPorNo(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_EstadoContrato".equals(filterRequest.getName()))
            suppInfo4ICEstadoContrato(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void iFEstadoContratoContrato(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vCodigo = filterRequest.hasFilterVariable(EstadoContratoConstants.VAR_NAME_IFESTADOCONTRATOCONTRATO_VCODIGO) ? (Long) filterRequest.getFilterVariable(EstadoContratoConstants.VAR_NAME_IFESTADOCONTRATOCONTRATO_VCODIGO, FilterVariableRequest.INT) : null;

        // Codigo = vCodigo
        if (vCodigo != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(EstadoContratoConstants.ATTR_NAME_ESTADOCONTRATOCODIGO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vCodigo, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFEstadoContratoContratoPorNo(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vNombre = filterRequest.hasFilterVariable(EstadoContratoConstants.VAR_NAME_IFESTADOCONTRATOCONTRATOPORNO_VNOMBRE) ? (String) filterRequest.getFilterVariable(EstadoContratoConstants.VAR_NAME_IFESTADOCONTRATOCONTRATOPORNO_VNOMBRE, FilterVariableRequest.STRING) : null;

        // Descripcion = vNombre
        if (vNombre != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(EstadoContratoConstants.ATTR_NAME_ESTADOCONTRATODESCRIPCION, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUEstadoContrato
     *
     * @param queryRequest Query request
     * @return List of viewmodels for EstadoContrato using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.estadocontrato.ds.AutoDS> piuPIUEstadoContrato(QueryRequest queryRequest) {
        return solveEstadoContratoTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.estadocontrato.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEstadoContrato
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEstadoContrato
     */
    public int getCount4PIUEstadoContrato(QueryRequest queryRequest) {
        return solveEstadoContratoTypedQuery(queryRequest).size();
    }

    // Service: InsEstadoContrato

    /*
     * Entry point for service InsEstadoContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insEstadoContrato(
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.InsEstadoContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = estadoContratoSrv.insEstadoContratoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsEstadoContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insEstadoContratoTxn(
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.InsEstadoContratoRequest request) throws ModelException {
        request.setEstadoContratoInsEstadoContratopthisEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getEstadoContratoInsEstadoContratopthisEstadoContrato()));
        request.setEstadoContratoInsEstadoContratopevcSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getEstadoContratoInsEstadoContratopevcSolicitudNovedad()));
        return estadoContratoSrv.insEstadoContratoImplementation(request, true);
    }

    /*
     * Implements service InsEstadoContrato
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insEstadoContratoImplementation(
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.InsEstadoContratoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        EstadoContrato estadoContratoInsEstadoContratopthisEstadoContrato = request.getEstadoContratoInsEstadoContratopthisEstadoContratoInstance();
        SolicitudNovedad estadoContratoInsEstadoContratopevcSolicitudNovedad = request.getEstadoContratoInsEstadoContratopevcSolicitudNovedadInstance();

        request.checkArguments();
        EstadoContrato instance = estadoContratoInsEstadoContratopthisEstadoContrato;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsEstadoContratoRequest relatedRequest = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsEstadoContratoRequest();
            relatedRequest.setSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance(estadoContratoInsEstadoContratopevcSolicitudNovedad);
            relatedRequest.setSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance(estadoContratoInsEstadoContratopthisEstadoContrato);
            solicitudNovedadSrv.insEstadoContratoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICEstadoContrato());

        return response;
    }

    // Service: DelEstadoContrato

    /*
     * Entry point for service DelEstadoContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delEstadoContrato(
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.DelEstadoContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = estadoContratoSrv.delEstadoContratoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelEstadoContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delEstadoContratoTxn(
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.DelEstadoContratoRequest request) throws ModelException {
        request.setEstadoContratoDelEstadoContratopthisEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getEstadoContratoDelEstadoContratopthisEstadoContrato()));
        request.setEstadoContratoDelEstadoContratopevcSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getEstadoContratoDelEstadoContratopevcSolicitudNovedad()));
        return estadoContratoSrv.delEstadoContratoImplementation(request, true);
    }

    /*
     * Implements service DelEstadoContrato
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delEstadoContratoImplementation(
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.DelEstadoContratoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        EstadoContrato estadoContratoDelEstadoContratopthisEstadoContrato = request.getEstadoContratoDelEstadoContratopthisEstadoContratoInstance();
        SolicitudNovedad estadoContratoDelEstadoContratopevcSolicitudNovedad = request.getEstadoContratoDelEstadoContratopevcSolicitudNovedadInstance();

        request.checkArguments();
        EstadoContrato instance = estadoContratoDelEstadoContratopthisEstadoContrato;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelEstadoContratoRequest relatedRequest = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelEstadoContratoRequest();
            relatedRequest.setSolicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance(estadoContratoDelEstadoContratopevcSolicitudNovedad);
            relatedRequest.setSolicitudNovedadDelEstadoContratopevcEstadoContratoInstance(estadoContratoDelEstadoContratopthisEstadoContrato);
            solicitudNovedadSrv.delEstadoContratoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICEstadoContrato());

        return response;
    }


    private void suppInfo4ICEstadoContrato(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(EstadoContratoConstants.ATTR_NAME_ESTADOCONTRATODESCRIPCION, Constants.Type.STRING.getTypeName()));
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
        applyOCOCEstadoContrato(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(EstadoContratoConstants.CLASS_NAME, EstadoContratoConstants.ATTR_FIELD_ESTADOCONTRATOCODIGO, false), true);
    }


    private void applyOCOCEstadoContrato(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_EstadoContrato".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(EstadoContratoConstants.CLASS_NAME, EstadoContratoConstants.ATTR_NAME_ESTADOCONTRATODESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildEstadoContratoRelatedInstance(relatedInstanceJsonOid);
        }
        if (EstadoContratoConstants.ROLE_NAME_AESOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildEstadoContratoRelatedInstance4Aesolicitudes(relatedInstanceJsonOid, remainingPath);
        }
        if (EstadoContratoConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildEstadoContratoRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildEstadoContratoRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new EstadoContrato(mapper.readValue(relatedInstanceJsonOid, EstadoContratoOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildEstadoContratoRelatedInstance4Aesolicitudes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Aesolicitudes(mapper.readValue(relatedInstanceJsonOid, AesolicitudesOid.class)): Aesolicitudes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildEstadoContratoRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
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
            EstadoContratoOid oid = new EstadoContratoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(EstadoContratoConstants.ATTR_FIELD_ESTADOCONTRATOCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getEstadoContratoCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(EstadoContratoService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
