package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.NovedadMDConstants;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.oid.DepartamentoOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.MunicipioOid;
import com.keralty.aenovedades.persistence.oid.NovedadMDOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.Pais;
import com.keralty.aenovedades.repository.NovedadMDJpaRepository;
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
public class NovedadMDService extends AbstractService {

    NovedadMDJpaRepository repository;

    NovedadMDService novedadMDSrv;

    FamiliaNovedadService familiaNovedadSrv;

    PaisService paisSrv;

    MunicipioService municipioSrv;

    DepartamentoService departamentoSrv;

    @Inject
    public NovedadMDService(
            NovedadMDService novedadMDSrv,
            FamiliaNovedadService familiaNovedadSrv,
            PaisService paisSrv,
            MunicipioService municipioSrv,
            DepartamentoService departamentoSrv,
            NovedadMDJpaRepository repository) {
        this.novedadMDSrv = novedadMDSrv;
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.paisSrv = paisSrv;
        this.municipioSrv = municipioSrv;
        this.departamentoSrv = departamentoSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, NovedadMDConstants.CLASS_NAME);
    }

    private List<NovedadMD> solveNovedadMDTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, NovedadMDConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveNovedadMDTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, NovedadMDConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class NovedadMD
     *
     * @return Population of class NovedadMD
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadMD> get() {
        List<NovedadMD> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class NovedadMD that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class NovedadMD matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadMD> get(QueryRequest queryRequest) {
        return solveNovedadMDTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveNovedadMDTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveNovedadMDTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveNovedadMDTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of NovedadMD by ID
     *
     * @param novedadMDidNovedadMD Identification field novedadMDidNovedadMD
     *
     * @return Instance of NovedadMD
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadMD getById(Long novedadMDidNovedadMD) {
        return getByOID(new NovedadMDOid(novedadMDidNovedadMD));
    }
    
    /*
     * Returns an instance of NovedadMD by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadMD
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadMD getByOID(NovedadMDOid oid) {
        Optional<NovedadMD> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of NovedadMD by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadMD
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public NovedadMD getByOIDWithHV(NovedadMDOid oid) {
        Optional<NovedadMD> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<NovedadMD> getInstanceByOid(NovedadMDOid oid) {
        return oid != null && oid.getNovedadMDidNovedadMD() != null
               ? repository.findById(oid.getNovedadMDidNovedadMD())
               : Optional.empty();
    }

    /*
     * Returns an instance of NovedadMD by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of NovedadMD
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadMD getByJsonOid(String jsonOid) {
        NovedadMDOid oid = new NovedadMDOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of NovedadMD related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of NovedadMD
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadMD> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveNovedadMDTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of NovedadMD related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of NovedadMD
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadMD> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of NovedadMD
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of NovedadMD
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getNovedadMDDynamic(NovedadMDOid oid, String displaySetItems) {
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
    public String getSuppInfo(NovedadMDOid oid, String dsName) {
        NovedadMD instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(NovedadMD instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUNovedadMDNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for NovedadMD using displayset DSNovedadMDNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.novedadmd.ds.DSNovedadMDNull> piuPIUNovedadMDNull(QueryRequest queryRequest) {
        return solveNovedadMDTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.novedadmd.ds.DSNovedadMDNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUNovedadMDNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUNovedadMDNull
     */
    public int getCount4PIUNovedadMDNull(QueryRequest queryRequest) {
        return solveNovedadMDTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadMDSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.CrearRequest request) throws ModelException {
        request.setNovedadMDcrearpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getNovedadMDcrearpagrFamiliaNovedad()));
        request.setNovedadMDcrearpagrPaisInstance(paisSrv.getByOIDWithHV(request.getNovedadMDcrearpagrPais()));
        request.setNovedadMDcrearpagrMunicipioInstance(municipioSrv.getByOIDWithHV(request.getNovedadMDcrearpagrMunicipio()));
        request.setNovedadMDcrearpagrDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getNovedadMDcrearpagrDepartamento()));
        return novedadMDSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad novedadMDcrearpagrFamiliaNovedad = request.getNovedadMDcrearpagrFamiliaNovedadInstance();
        Pais novedadMDcrearpagrPais = request.getNovedadMDcrearpagrPaisInstance();
        Municipio novedadMDcrearpagrMunicipio = request.getNovedadMDcrearpagrMunicipioInstance();
        Departamento novedadMDcrearpagrDepartamento = request.getNovedadMDcrearpagrDepartamentoInstance();
        String novedadMDcrearpatrDireccionCompleta = request.getNovedadMDcrearpatrDireccionCompleta();
        Boolean novedadMDcrearpatrRural = request.getNovedadMDcrearpatrRural();
        String novedadMDcrearpatrTelefonoFijo = request.getNovedadMDcrearpatrTelefonoFijo();
        String novedadMDcrearpatrTelefonoCelular = request.getNovedadMDcrearpatrTelefonoCelular();
        String novedadMDcrearpatrCorreoElectronico = request.getNovedadMDcrearpatrCorreoElectronico();

        request.checkArguments();
        NovedadMD instance = new NovedadMD();
        novedadMDcrearpagrFamiliaNovedad.add2NovedadMD(instance);
        instance.add2FamiliaNovedad(novedadMDcrearpagrFamiliaNovedad);

        if (novedadMDcrearpagrPais != null && !novedadMDcrearpagrPais.isNull()) {
            instance.add2Pais(novedadMDcrearpagrPais);
        }

        if (novedadMDcrearpagrMunicipio != null && !novedadMDcrearpagrMunicipio.isNull()) {
            instance.add2Municipio(novedadMDcrearpagrMunicipio);
        }

        if (novedadMDcrearpagrDepartamento != null && !novedadMDcrearpagrDepartamento.isNull()) {
            instance.add2Departamento(novedadMDcrearpagrDepartamento);
        }

        instance.setNovedadMDidNovedadMD(Long.valueOf(0));
        instance.setNovedadMDDireccionCompleta(novedadMDcrearpatrDireccionCompleta);
        instance.setNovedadMDRural(novedadMDcrearpatrRural);
        instance.setNovedadMDTelefonoFijo(novedadMDcrearpatrTelefonoFijo);
        instance.setNovedadMDTelefonoCelular(novedadMDcrearpatrTelefonoCelular);
        instance.setNovedadMDCorreoElectronico(novedadMDcrearpatrCorreoElectronico);

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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadMDSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.EliminarRequest request) throws ModelException {
        request.setNovedadMDeliminarpthisNovedadMDInstance(novedadMDSrv.getByOIDWithHV(request.getNovedadMDeliminarpthisNovedadMD()));
        return novedadMDSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        NovedadMD novedadMDeliminarpthisNovedadMD = request.getNovedadMDeliminarpthisNovedadMDInstance();

        request.checkArguments();
        NovedadMD instance = novedadMDeliminarpthisNovedadMD;

        instance.getFamiliaNovedad().add2NovedadMD(null);

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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadMDSrv.tCREARTxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TCREARRequest request) throws ModelException {
        request.setNovedadMDTCREARptpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getNovedadMDTCREARptpagrFamiliaNovedad()));
        request.setNovedadMDTCREARptpagrPaisInstance(paisSrv.getByOIDWithHV(request.getNovedadMDTCREARptpagrPais()));
        request.setNovedadMDTCREARptpagrDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getNovedadMDTCREARptpagrDepartamento()));
        request.setNovedadMDTCREARptpagrMunicipioInstance(municipioSrv.getByOIDWithHV(request.getNovedadMDTCREARptpagrMunicipio()));
        return novedadMDSrv.tCREARImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad novedadMDTCREARptpagrFamiliaNovedad = request.getNovedadMDTCREARptpagrFamiliaNovedadInstance();
        Pais novedadMDTCREARptpagrPais = request.getNovedadMDTCREARptpagrPaisInstance();
        Municipio novedadMDTCREARptpagrMunicipio = request.getNovedadMDTCREARptpagrMunicipioInstance();
        Departamento novedadMDTCREARptpagrDepartamento = request.getNovedadMDTCREARptpagrDepartamentoInstance();
        String novedadMDTCREARptpatrDireccionCompleta = request.getNovedadMDTCREARptpatrDireccionCompleta();
        Boolean novedadMDTCREARptpatrRural = request.getNovedadMDTCREARptpatrRural();
        String novedadMDTCREARptpatrTelefonoFijo = request.getNovedadMDTCREARptpatrTelefonoFijo();
        String novedadMDTCREARptpatrTelefonoCelular = request.getNovedadMDTCREARptpatrTelefonoCelular();
        String novedadMDTCREARptpatrCorreoElectronico = request.getNovedadMDTCREARptpatrCorreoElectronico();

        request.checkArguments();
        NovedadMD instance;

        com.keralty.aenovedades.viewmodel.novedadmd.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.novedadmd.siu.CrearRequest();
        step1Request.setNovedadMDcrearpagrFamiliaNovedadInstance(novedadMDTCREARptpagrFamiliaNovedad);
        step1Request.setNovedadMDcrearpagrPaisInstance(novedadMDTCREARptpagrPais);
        step1Request.setNovedadMDcrearpagrMunicipioInstance(novedadMDTCREARptpagrMunicipio);
        step1Request.setNovedadMDcrearpagrDepartamentoInstance(novedadMDTCREARptpagrDepartamento);
        step1Request.setNovedadMDcrearpatrDireccionCompleta(novedadMDTCREARptpatrDireccionCompleta);
        step1Request.setNovedadMDcrearpatrRural(novedadMDTCREARptpatrRural);
        step1Request.setNovedadMDcrearpatrTelefonoFijo(novedadMDTCREARptpatrTelefonoFijo);
        step1Request.setNovedadMDcrearpatrTelefonoCelular(novedadMDTCREARptpatrTelefonoCelular);
        step1Request.setNovedadMDcrearpatrCorreoElectronico(novedadMDTCREARptpatrCorreoElectronico);
        instance = (NovedadMD) novedadMDSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));

        return response;
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadMDSrv.tDELETETxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TDELETERequest request) throws ModelException {
        request.setNovedadMDTDELETEpthisNovedadMDInstance(novedadMDSrv.getByOIDWithHV(request.getNovedadMDTDELETEpthisNovedadMD()));
        return novedadMDSrv.tDELETEImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadmd.siu.TDELETERequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        NovedadMD novedadMDTDELETEpthisNovedadMD = request.getNovedadMDTDELETEpthisNovedadMDInstance();

        request.checkArguments();
        NovedadMD instance = novedadMDTDELETEpthisNovedadMD;

        com.keralty.aenovedades.viewmodel.novedadmd.siu.EliminarRequest step1Request = new com.keralty.aenovedades.viewmodel.novedadmd.siu.EliminarRequest();
        step1Request.setNovedadMDeliminarpthisNovedadMDInstance(novedadMDTDELETEpthisNovedadMD);
        novedadMDSrv.eliminarImplementation(step1Request);

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
        select.getOrderByPart().addItem(Constants.normalizePath(NovedadMDConstants.CLASS_NAME, NovedadMDConstants.ATTR_FIELD_NOVEDADMDIDNOVEDADMD, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildNovedadMDRelatedInstance(relatedInstanceJsonOid);
        }
        if (NovedadMDConstants.ROLE_NAME_FAMILIANOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadMDRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadMDConstants.ROLE_NAME_PAIS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadMDRelatedInstance4Pais(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadMDConstants.ROLE_NAME_DEPARTAMENTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadMDRelatedInstance4Departamento(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadMDConstants.ROLE_NAME_MUNICIPIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadMDRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildNovedadMDRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new NovedadMD(mapper.readValue(relatedInstanceJsonOid, NovedadMDOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadMDRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): FamiliaNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadMDRelatedInstance4Pais(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Pais(mapper.readValue(relatedInstanceJsonOid, PaisOid.class)): Pais.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadMDRelatedInstance4Departamento(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Departamento(mapper.readValue(relatedInstanceJsonOid, DepartamentoOid.class)): Departamento.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadMDRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            NovedadMDOid oid = new NovedadMDOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(NovedadMDConstants.ATTR_FIELD_NOVEDADMDIDNOVEDADMD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getNovedadMDidNovedadMD(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(NovedadMDService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
