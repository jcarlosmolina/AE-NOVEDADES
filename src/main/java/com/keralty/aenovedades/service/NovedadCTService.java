package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.PreconditionException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.DepartamentoOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.MunicipioOid;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Pais;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.repository.NovedadCTJpaRepository;
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
import com.keralty.aenovedades.viewmodel.QueryRequest;
import com.keralty.aenovedades.viewmodel.QueryResponse;
import com.keralty.aenovedades.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class NovedadCTService extends AbstractService {

    NovedadCTJpaRepository repository;

    NovedadCTService novedadCTSrv;

    FamiliaNovedadService familiaNovedadSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    FirmaService firmaSrv;

    MunicipioService municipioSrv;

    DepartamentoService departamentoSrv;

    PaisService paisSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public NovedadCTService(
            NovedadCTService novedadCTSrv,
            FamiliaNovedadService familiaNovedadSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            FirmaService firmaSrv,
            MunicipioService municipioSrv,
            DepartamentoService departamentoSrv,
            PaisService paisSrv,
            UserFunctions userFunctionsSrv,
            NovedadCTJpaRepository repository) {
        this.novedadCTSrv = novedadCTSrv;
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.firmaSrv = firmaSrv;
        this.municipioSrv = municipioSrv;
        this.departamentoSrv = departamentoSrv;
        this.paisSrv = paisSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, NovedadCTConstants.CLASS_NAME);
    }

    private List<NovedadCT> solveNovedadCTTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, NovedadCTConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveNovedadCTTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, NovedadCTConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class NovedadCT
     *
     * @return Population of class NovedadCT
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadCT> get() {
        List<NovedadCT> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class NovedadCT that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class NovedadCT matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadCT> get(QueryRequest queryRequest) {
        return solveNovedadCTTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveNovedadCTTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveNovedadCTTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveNovedadCTTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of NovedadCT by ID
     *
     * @param novedadCTidNovedadCT Identification field novedadCTidNovedadCT
     *
     * @return Instance of NovedadCT
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadCT getById(Long novedadCTidNovedadCT) {
        return getByOID(new NovedadCTOid(novedadCTidNovedadCT));
    }
    
    /*
     * Returns an instance of NovedadCT by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadCT
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadCT getByOID(NovedadCTOid oid) {
        Optional<NovedadCT> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of NovedadCT by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadCT
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public NovedadCT getByOIDWithHV(NovedadCTOid oid) {
        Optional<NovedadCT> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<NovedadCT> getInstanceByOid(NovedadCTOid oid) {
        return oid != null && oid.getNovedadCTidNovedadCT() != null
               ? repository.findById(oid.getNovedadCTidNovedadCT())
               : Optional.empty();
    }

    /*
     * Returns an instance of NovedadCT by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of NovedadCT
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadCT getByJsonOid(String jsonOid) {
        NovedadCTOid oid = new NovedadCTOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of NovedadCT related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of NovedadCT
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadCT> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveNovedadCTTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of NovedadCT related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of NovedadCT
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NovedadCT> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of NovedadCT
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of NovedadCT
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getNovedadCTDynamic(NovedadCTOid oid, String displaySetItems) {
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
    public String getSuppInfo(NovedadCTOid oid, String dsName) {
        NovedadCT instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(NovedadCT instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUNovedadCTNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for NovedadCT using displayset DSNovedadCTNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.novedadct.ds.DSNovedadCTNull> piuPIUNovedadCTNull(QueryRequest queryRequest) {
        return solveNovedadCTTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.novedadct.ds.DSNovedadCTNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUNovedadCTNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUNovedadCTNull
     */
    public int getCount4PIUNovedadCTNull(QueryRequest queryRequest) {
        return solveNovedadCTTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.CrearRequest request) throws ModelException {
        request.setNovedadCTcrearpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getNovedadCTcrearpagrFamiliaNovedad()));
        request.setNovedadCTcrearpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getNovedadCTcrearpagrTipoIdentificacion()));
        request.setNovedadCTcrearpagrFirmaInstance(firmaSrv.getByOIDWithHV(request.getNovedadCTcrearpagrFirma()));
        request.setNovedadCTcrearpagrMunicipioNacInstance(municipioSrv.getByOIDWithHV(request.getNovedadCTcrearpagrMunicipioNac()));
        request.setNovedadCTcrearpagrMunicipioResInstance(municipioSrv.getByOIDWithHV(request.getNovedadCTcrearpagrMunicipioRes()));
        request.setNovedadCTcrearpagrDepartamentoNacInstance(departamentoSrv.getByOIDWithHV(request.getNovedadCTcrearpagrDepartamentoNac()));
        request.setNovedadCTcrearpagrDepartamentoResInstance(departamentoSrv.getByOIDWithHV(request.getNovedadCTcrearpagrDepartamentoRes()));
        request.setNovedadCTcrearpagrPaisInstance(paisSrv.getByOIDWithHV(request.getNovedadCTcrearpagrPais()));
        return novedadCTSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad novedadCTcrearpagrFamiliaNovedad = request.getNovedadCTcrearpagrFamiliaNovedadInstance();
        TipoIdentificacion novedadCTcrearpagrTipoIdentificacion = request.getNovedadCTcrearpagrTipoIdentificacionInstance();
        Firma novedadCTcrearpagrFirma = request.getNovedadCTcrearpagrFirmaInstance();
        Municipio novedadCTcrearpagrMunicipioNac = request.getNovedadCTcrearpagrMunicipioNacInstance();
        Municipio novedadCTcrearpagrMunicipioRes = request.getNovedadCTcrearpagrMunicipioResInstance();
        Departamento novedadCTcrearpagrDepartamentoNac = request.getNovedadCTcrearpagrDepartamentoNacInstance();
        Departamento novedadCTcrearpagrDepartamentoRes = request.getNovedadCTcrearpagrDepartamentoResInstance();
        Pais novedadCTcrearpagrPais = request.getNovedadCTcrearpagrPaisInstance();
        String novedadCTcrearpatrTitNumidentificacion = request.getNovedadCTcrearpatrTitNumidentificacion();
        String novedadCTcrearpatrTitPrimerNombre = request.getNovedadCTcrearpatrTitPrimerNombre();
        Boolean novedadCTcrearpatrTitTieneBeneficios = request.getNovedadCTcrearpatrTitTieneBeneficios();
        String novedadCTcrearpatrTitSegundoNombre = request.getNovedadCTcrearpatrTitSegundoNombre();
        String novedadCTcrearpatrTitPrimerApellido = request.getNovedadCTcrearpatrTitPrimerApellido();
        String novedadCTcrearpatrTitSegundoApellido = request.getNovedadCTcrearpatrTitSegundoApellido();
        String novedadCTcrearpatrTitRazonSocial = request.getNovedadCTcrearpatrTitRazonSocial();
        Date novedadCTcrearpatrFechaNacimiento = request.getNovedadCTcrearpatrFechaNacimiento();
        String novedadCTcrearpatrGenero = request.getNovedadCTcrearpatrGenero();
        Boolean novedadCTcrearpatrIndicadorExtranjero = request.getNovedadCTcrearpatrIndicadorExtranjero();
        String novedadCTcrearpatrTelefonoFijo = request.getNovedadCTcrearpatrTelefonoFijo();
        String novedadCTcrearpatrTelefonoCelular = request.getNovedadCTcrearpatrTelefonoCelular();
        String novedadCTcrearpatrCorreoElectronico = request.getNovedadCTcrearpatrCorreoElectronico();
        String novedadCTcrearpatrDireccionCompleta = request.getNovedadCTcrearpatrDireccionCompleta();
        Boolean novedadCTcrearpatrRural = request.getNovedadCTcrearpatrRural();
        Long novedadCTcrearpatrCodigoCORE = request.getNovedadCTcrearpatrCodigoCORE();

        request.checkArguments();
        NovedadCT instance = new NovedadCT();
        novedadCTcrearpagrFamiliaNovedad.add2NovedadCT(instance);
        instance.add2FamiliaNovedad(novedadCTcrearpagrFamiliaNovedad);

        instance.add2TipoIdentificacion(novedadCTcrearpagrTipoIdentificacion);

        if (novedadCTcrearpagrFirma != null && !novedadCTcrearpagrFirma.isNull()) {
            novedadCTcrearpagrFirma.add2NovedadesCT(instance);
            instance.add2Firma(novedadCTcrearpagrFirma);
        }

        if (novedadCTcrearpagrMunicipioNac != null && !novedadCTcrearpagrMunicipioNac.isNull()) {
            instance.add2MunicipioNac(novedadCTcrearpagrMunicipioNac);
        }

        if (novedadCTcrearpagrMunicipioRes != null && !novedadCTcrearpagrMunicipioRes.isNull()) {
            instance.add2MunicipioRes(novedadCTcrearpagrMunicipioRes);
        }

        if (novedadCTcrearpagrDepartamentoNac != null && !novedadCTcrearpagrDepartamentoNac.isNull()) {
            instance.add2DepartamentoNac(novedadCTcrearpagrDepartamentoNac);
        }

        if (novedadCTcrearpagrDepartamentoRes != null && !novedadCTcrearpagrDepartamentoRes.isNull()) {
            instance.add2DepartamentoRes(novedadCTcrearpagrDepartamentoRes);
        }

        if (novedadCTcrearpagrPais != null && !novedadCTcrearpagrPais.isNull()) {
            instance.add2Pais(novedadCTcrearpagrPais);
        }

        instance.setNovedadCTidNovedadCT(Long.valueOf(0));
        instance.setNovedadCTTitNumidentificacion(novedadCTcrearpatrTitNumidentificacion);
        instance.setNovedadCTTitPrimerNombre(novedadCTcrearpatrTitPrimerNombre);
        instance.setNovedadCTTitTieneBeneficios(novedadCTcrearpatrTitTieneBeneficios);
        instance.setNovedadCTTitSegundoNombre(novedadCTcrearpatrTitSegundoNombre);
        instance.setNovedadCTTitPrimerApellido(novedadCTcrearpatrTitPrimerApellido);
        instance.setNovedadCTTitSegundoApellido(novedadCTcrearpatrTitSegundoApellido);
        instance.setNovedadCTTitRazonSocial(novedadCTcrearpatrTitRazonSocial);
        instance.setNovedadCTFechaNacimiento(novedadCTcrearpatrFechaNacimiento);
        instance.setNovedadCTGenero(novedadCTcrearpatrGenero);
        instance.setNovedadCTIndicadorExtranjero(novedadCTcrearpatrIndicadorExtranjero);
        instance.setNovedadCTTelefonoFijo(novedadCTcrearpatrTelefonoFijo);
        instance.setNovedadCTTelefonoCelular(novedadCTcrearpatrTelefonoCelular);
        instance.setNovedadCTCorreoElectronico(novedadCTcrearpatrCorreoElectronico);
        instance.setNovedadCTDireccionCompleta(novedadCTcrearpatrDireccionCompleta);
        instance.setNovedadCTRural(novedadCTcrearpatrRural);
        instance.setNovedadCTCodigoCORE(novedadCTcrearpatrCodigoCORE);

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
            com.keralty.aenovedades.viewmodel.novedadct.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.EliminarRequest request) throws ModelException {
        request.setNovedadCTeliminarpthisFamiliaNovedadInstance(novedadCTSrv.getByOIDWithHV(request.getNovedadCTeliminarpthisFamiliaNovedad()));
        return novedadCTSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        NovedadCT novedadCTeliminarpthisFamiliaNovedad = request.getNovedadCTeliminarpthisFamiliaNovedadInstance();

        request.checkArguments();
        NovedadCT instance = novedadCTeliminarpthisFamiliaNovedad;

        instance.getFamiliaNovedad().add2NovedadCT(null);

        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: InsFirmaNovedadCT

    /*
     * Entry point for service InsFirmaNovedadCT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insFirmaNovedadCT(
            com.keralty.aenovedades.viewmodel.novedadct.siu.InsFirmaNovedadCTRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.insFirmaNovedadCTTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsFirmaNovedadCT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insFirmaNovedadCTTxn(
            com.keralty.aenovedades.viewmodel.novedadct.siu.InsFirmaNovedadCTRequest request) throws ModelException {
        request.setNovedadCTInsFirmaNovedadCTpthisNovedadCTInstance(novedadCTSrv.getByOIDWithHV(request.getNovedadCTInsFirmaNovedadCTpthisNovedadCT()));
        request.setNovedadCTInsFirmaNovedadCTpevcFirmaInstance(firmaSrv.getByOIDWithHV(request.getNovedadCTInsFirmaNovedadCTpevcFirma()));
        return novedadCTSrv.insFirmaNovedadCTImplementation(request, true);
    }

    /*
     * Implements service InsFirmaNovedadCT
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insFirmaNovedadCTImplementation(
            com.keralty.aenovedades.viewmodel.novedadct.siu.InsFirmaNovedadCTRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        NovedadCT novedadCTInsFirmaNovedadCTpthisNovedadCT = request.getNovedadCTInsFirmaNovedadCTpthisNovedadCTInstance();
        Firma novedadCTInsFirmaNovedadCTpevcFirma = request.getNovedadCTInsFirmaNovedadCTpevcFirmaInstance();

        request.checkArguments();
        NovedadCT instance = novedadCTInsFirmaNovedadCTpthisNovedadCT;

        instance.add2Firma(novedadCTInsFirmaNovedadCTpevcFirma);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.firma.siu.InsFirmaNovedadCTRequest relatedRequest = new com.keralty.aenovedades.viewmodel.firma.siu.InsFirmaNovedadCTRequest();
            relatedRequest.setFirmaInsFirmaNovedadCTpthisFirmaInstance(novedadCTInsFirmaNovedadCTpevcFirma);
            relatedRequest.setFirmaInsFirmaNovedadCTpevcNovedadCTInstance(novedadCTInsFirmaNovedadCTpthisNovedadCT);
            firmaSrv.insFirmaNovedadCTImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelFirmaNovedadCT

    /*
     * Entry point for service DelFirmaNovedadCT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delFirmaNovedadCT(
            com.keralty.aenovedades.viewmodel.novedadct.siu.DelFirmaNovedadCTRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.delFirmaNovedadCTTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelFirmaNovedadCT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delFirmaNovedadCTTxn(
            com.keralty.aenovedades.viewmodel.novedadct.siu.DelFirmaNovedadCTRequest request) throws ModelException {
        request.setNovedadCTDelFirmaNovedadCTpthisNovedadCTInstance(novedadCTSrv.getByOIDWithHV(request.getNovedadCTDelFirmaNovedadCTpthisNovedadCT()));
        request.setNovedadCTDelFirmaNovedadCTpevcFirmaInstance(firmaSrv.getByOIDWithHV(request.getNovedadCTDelFirmaNovedadCTpevcFirma()));
        return novedadCTSrv.delFirmaNovedadCTImplementation(request, true);
    }

    /*
     * Implements service DelFirmaNovedadCT
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delFirmaNovedadCTImplementation(
            com.keralty.aenovedades.viewmodel.novedadct.siu.DelFirmaNovedadCTRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        NovedadCT novedadCTDelFirmaNovedadCTpthisNovedadCT = request.getNovedadCTDelFirmaNovedadCTpthisNovedadCTInstance();
        Firma novedadCTDelFirmaNovedadCTpevcFirma = request.getNovedadCTDelFirmaNovedadCTpevcFirmaInstance();

        request.checkArguments();
        NovedadCT instance = novedadCTDelFirmaNovedadCTpthisNovedadCT;

        instance.add2Firma(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.firma.siu.DelFirmaNovedadCTRequest relatedRequest = new com.keralty.aenovedades.viewmodel.firma.siu.DelFirmaNovedadCTRequest();
            relatedRequest.setFirmaDelFirmaNovedadCTpthisFirmaInstance(novedadCTDelFirmaNovedadCTpevcFirma);
            relatedRequest.setFirmaDelFirmaNovedadCTpevcNovedadCTInstance(novedadCTDelFirmaNovedadCTpthisNovedadCT);
            firmaSrv.delFirmaNovedadCTImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: validarDatosRestrictiva

    /*
     * Entry point for service validarDatosRestrictiva
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarDatosRestrictiva(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.validarDatosRestrictivaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarDatosRestrictiva
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarDatosRestrictivaTxn(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) throws ModelException {
        request.setNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance(novedadCTSrv.getByOIDWithHV(request.getNovedadCTvalidarDatosRestrictivapthisNovedadCT()));
        return novedadCTSrv.validarDatosRestrictivaImplementation(request);
    }

    /*
     * Implements service validarDatosRestrictiva
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarDatosRestrictivaImplementation(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();

        request.checkArguments();

        validarDatosRestrictivaPreconditions(request);
        NovedadCT instance = novedadCTvalidarDatosRestrictivapthisNovedadCT;


        response.setInstance(repository.save(instance));

        return response;
    }

    private void validarDatosRestrictivaPreconditions(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        checkClas1582184136704954Pre1(request);
        checkClas1582184136704954Pre2(request);
        checkClas1582184136704954Pre3(request);
        checkClas1582184136704954Pre4(request);
        checkClas1582184136704954Pre5(request);
        checkClas1582184136704954Pre6(request);
        checkClas1582184136704954Pre7(request);
        checkClas1582184136704954Pre8(request);
        checkClas1582184136704954Pre9(request);
        checkClas1582184136704954Pre10(request);
        checkClas1582184136704954Pre11(request);
        checkClas1582184136704954Pre12(request);
        checkClas1582184136704954Pre13(request);
        checkClas1582184136704954Pre14(request);
    }

    private void checkClas1582184136704954Pre1 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // CorreoElectronico = NULL OR fuValidarEmail(CorreoElectronico) = true

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTCorreoElectronico() == null || userFunctionsSrv.fuValidarEmailFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTCorreoElectronico()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El formato proporcionado para el correo electrónico no es válido");
    }

    private void checkClas1582184136704954Pre2 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitRazonSocial = NULL OR (indexOf( TitRazonSocial, "y/o") = 0 AND indexOf( TitRazonSocial, "/") = 0)

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitRazonSocial() == null || ((STDFunctions.indexOfFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitRazonSocial(), "y/o")).equals(Long.valueOf(0)) && (STDFunctions.indexOfFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitRazonSocial(), "/")).equals(Long.valueOf(0)));
        if (!preconditionHolds) throw new PreconditionException("La razón social no puede contener los carácteres especiales 'y/o' ni '/'");
    }

    private void checkClas1582184136704954Pre3 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitPrimerNombre = NULL OR fuValidarNombre(TitPrimerNombre) = true

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerNombre() == null || userFunctionsSrv.fuValidarNombreFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerNombre()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El nombre debe estar formado por letras y no puede contener espacios");
    }

    private void checkClas1582184136704954Pre4 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitPrimerNombre = NULL OR length( TitPrimerNombre ) >= 2

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerNombre() == null || STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerNombre()) >= Long.valueOf(2);
        if (!preconditionHolds) throw new PreconditionException("El primer nombre debe tener como mínimo 2 caracteres");
    }

    private void checkClas1582184136704954Pre5 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitSegundoNombre = NULL OR length( TitSegundoNombre) >= 2

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoNombre() == null || STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoNombre()) >= Long.valueOf(2);
        if (!preconditionHolds) throw new PreconditionException("El segundo nombre, cuando es diligenciado, debe tener como mínimo 2 caracteres");
    }

    private void checkClas1582184136704954Pre6 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitSegundoNombre = NULL OR fuValidarNombre(TitSegundoNombre) = true

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoNombre() == null || userFunctionsSrv.fuValidarNombreFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoNombre()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El segundo nombre debe estar formado por letras y no puede contener espacios");
    }

    private void checkClas1582184136704954Pre7 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitPrimerApellido = NULL OR fuValidarNombre(TitPrimerApellido) = true

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerApellido() == null || userFunctionsSrv.fuValidarNombreFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerApellido()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El primer apellido debe estar formado por letras y no puede contener espacios");
    }

    private void checkClas1582184136704954Pre8 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitPrimerApellido = NULL OR length(TitPrimerApellido) >= 2

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerApellido() == null || STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitPrimerApellido()) >= Long.valueOf(2);
        if (!preconditionHolds) throw new PreconditionException("El primer apellido debe tener como mínimo 2 caracteres");
    }

    private void checkClas1582184136704954Pre9 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitSegundoApellido = NULL OR length(TitSegundoApellido) >= 2

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoApellido() == null || STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoApellido()) >= Long.valueOf(2);
        if (!preconditionHolds) throw new PreconditionException("El segundo apellido, cuando es diligenciado, debe tener como mínimo 2 caracteres");
    }

    private void checkClas1582184136704954Pre10 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TitSegundoApellido = NULL OR fuValidarNombre(TitSegundoApellido) = true

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoApellido() == null || userFunctionsSrv.fuValidarNombreFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTitSegundoApellido()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El segundo apellido debe estar formado por letras y no puede contener espacios");
    }

    private void checkClas1582184136704954Pre11 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // Genero = NULL OR (Genero = "F" OR Genero = "M" )

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTGenero() == null || ((novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTGenero()).equals("F") || (novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTGenero()).equals("M"));
        if (!preconditionHolds) throw new PreconditionException("El género debe ser F o M");
    }

    private void checkClas1582184136704954Pre12 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // FechaNacimiento = NULL OR FechaNacimiento <= systemDate()

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTFechaNacimiento() == null || (STDFunctions.dateBeforeFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTFechaNacimiento(),STDFunctions.systemDateFun()) || STDFunctions.dateEqualsFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTFechaNacimiento(), STDFunctions.systemDateFun()));
        if (!preconditionHolds) throw new PreconditionException("La fecha de nacimiento no puede ser futura");
    }

    private void checkClas1582184136704954Pre13 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TelefonoFijo = NULL OR fuValidarTelefonoFijo(TelefonoFijo) = true

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTelefonoFijo() == null || userFunctionsSrv.fuValidarTelefonoFijoFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTelefonoFijo()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El teléfono fijo debe contener 7 números y al menos uno de ellos debe ser distinto");
    }

    private void checkClas1582184136704954Pre14 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest request) 
            throws ModelException {
        // TelefonoCelular = NULL OR fuValidarTelefonoCelular(TelefonoCelular) = true

        NovedadCT novedadCTvalidarDatosRestrictivapthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTelefonoCelular() == null || userFunctionsSrv.fuValidarTelefonoCelularFun(novedadCTvalidarDatosRestrictivapthisNovedadCT.getNovedadCTTelefonoCelular()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El teléfono celular debe contener 10 números y al menos uno de ellos debe ser distinto");
    }

    // Service: validarDatosRestrictivaTipoId

    /*
     * Entry point for service validarDatosRestrictivaTipoId
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarDatosRestrictivaTipoId(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.validarDatosRestrictivaTipoIdTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarDatosRestrictivaTipoId
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarDatosRestrictivaTipoIdTxn(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) throws ModelException {
        request.setNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance(novedadCTSrv.getByOIDWithHV(request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT()));
        return novedadCTSrv.validarDatosRestrictivaTipoIdImplementation(request);
    }

    /*
     * Implements service validarDatosRestrictivaTipoId
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarDatosRestrictivaTipoIdImplementation(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();

        request.checkArguments();

        validarDatosRestrictivaTipoIdPreconditions(request);
        NovedadCT instance = novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT;


        response.setInstance(repository.save(instance));

        return response;
    }

    private void validarDatosRestrictivaTipoIdPreconditions(
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        checkClas1582184136704954Pre15(request);
        checkClas1582184136704954Pre16(request);
        checkClas1582184136704954Pre17(request);
        checkClas1582184136704954Pre18(request);
        checkClas1582184136704954Pre19(request);
        checkClas1582184136704954Pre20(request);
        checkClas1582184136704954Pre21(request);
        checkClas1582184136704954Pre22(request);
        checkClas1582184136704954Pre23(request);
        checkClas1582184136704954Pre24(request);
        checkClas1582184136704954Pre25(request);
        checkClas1582184136704954Pre26(request);
        checkClas1582184136704954Pre27(request);
        checkClas1582184136704954Pre28(request);
        checkClas1582184136704954Pre29(request);
        checkClas1582184136704954Pre30(request);
        checkClas1582184136704954Pre31(request);
        checkClas1582184136704954Pre32(request);
        checkClas1582184136704954Pre33(request);
        checkClas1582184136704954Pre34(request);
        checkClas1582184136704954Pre35(request);
        checkClas1582184136704954Pre36(request);
        checkClas1582184136704954Pre37(request);
        checkClas1582184136704954Pre38(request);
        checkClas1582184136704954Pre39(request);
        checkClas1582184136704954Pre40(request);
        checkClas1582184136704954Pre41(request);
    }

    private void checkClas1582184136704954Pre15 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "CC" OR (daysDifferenceFromDate(FechaNacimiento, systemDate()) >= 6570)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("CC") || (STDFunctions.daysDifferenceFromDateFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento(), STDFunctions.systemDateFun()) >= Long.valueOf(6570));
        if (!preconditionHolds) throw new PreconditionException("El documento de identificacion para afiliados menores de 18 es Tarjeta de identidad, Registro civil o Numero unico de identificacion personal (Nuip)");
    }

    private void checkClas1582184136704954Pre16 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // CodigoCORE = NULL OR TipoIdentificacion.NombreCorto <> "MS" OR (daysDifferenceFromDate(FechaNacimiento, systemDate()) <= 30)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTCodigoCORE() == null || !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("MS") || (STDFunctions.daysDifferenceFromDateFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento(), STDFunctions.systemDateFun()) <= Long.valueOf(30));
        if (!preconditionHolds) throw new PreconditionException("Pasado un mes desde la fecha de nacimiento del usuario solo se es permitido afiliarse a menores con tipo de identificacion Registro civil o Nuip.");
    }

    private void checkClas1582184136704954Pre17 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "TI" OR (daysDifferenceFromDate(FechaNacimiento, systemDate()) <= 6935)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI") || (STDFunctions.daysDifferenceFromDateFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento(), STDFunctions.systemDateFun()) <= Long.valueOf(6935));
        if (!preconditionHolds) throw new PreconditionException("El documento de identificacion para afiliados mayores de 18 años es Cedula de Ciudadania o en caso de ser extranjero Cedula de extranjeria");
    }

    private void checkClas1582184136704954Pre18 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "TI" OR (daysDifferenceFromDate(FechaNacimiento, systemDate()) >= 2555)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI") || (STDFunctions.daysDifferenceFromDateFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento(), STDFunctions.systemDateFun()) >= Long.valueOf(2555));
        if (!preconditionHolds) throw new PreconditionException("La Tarjeta de identidad solo se asigna a mayores de 7 años, los menores a esta edad solo deben identificarse con Registro Civil o Nuip.");
    }

    private void checkClas1582184136704954Pre19 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "RC" OR (daysDifferenceFromDate(FechaNacimiento, systemDate()) <= 6935)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("RC") || (STDFunctions.daysDifferenceFromDateFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento(), STDFunctions.systemDateFun()) <= Long.valueOf(6935));
        if (!preconditionHolds) throw new PreconditionException("El Registro civil solo es un documento valido hasta los 18 años, apartir de los 19 años todos los usuarios se deben identificar con Cedula de Ciudadania");
    }

    private void checkClas1582184136704954Pre20 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "RC" OR getYear(FechaNacimiento) <> 2000 OR length(TitNumIdentificacion) <> 11

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("RC") || !(STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())).equals(Long.valueOf(2000)) || !(STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(11));
        if (!preconditionHolds) throw new PreconditionException("RC de 11 dígitos y los 6 primeros dígitos de la identificación deben coincidir con la fecha de nacimiento del usuario.(Teniendo en cuenta que los 3 pueden ser ceros y no se reflejan en el sistema), por lo tanto los nacidos en 2000 tendrían identifiaciones solo de 8, 9 y 10 dígitos");
    }

    private void checkClas1582184136704954Pre21 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "TI" OR getYear(FechaNacimiento) <> 2000 OR length(TitNumIdentificacion) <> 11

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI") || !(STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())).equals(Long.valueOf(2000)) || !(STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(11));
        if (!preconditionHolds) throw new PreconditionException("TI de 11 dígitos y los 6 primeros dígitos de la identificación deben coincidir con la fecha de nacimiento del usuario.(Teniendo en cuenta que los 3 primeros pueden ser ceros y no se reflejan en el sistema) por lo tanto los nacidos en 2000 tendrían identifiaciones solo de 8, 9 y 10 dígitos");
    }

    private void checkClas1582184136704954Pre22 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "TI" OR getYear(FechaNacimiento) >= 2000 OR (length(TitNumIdentificacion) = 11 AND substring(TitNumIdentificacion, 1, 2) = substring(IntToStr(getYear(FechaNacimiento)), 3, 2) AND ((length(IntToStr(getMonth(FechaNacimiento))) = 2 AND substring(TitNumIdentificacion, 3, 2) = IntToStr(getMonth(FechaNacimiento))) OR (length(IntToStr(getMonth(FechaNacimiento))) = 1 AND substring(TitNumIdentificacion, 4, 1) = IntToStr(getMonth(FechaNacimiento)))) AND (length(IntToStr(getDay(FechaNacimiento))) = 2 AND substring(TitNumIdentificacion, 5, 2) = IntToStr(getDay(FechaNacimiento))) OR (length(IntToStr(getDay(FechaNacimiento))) = 1 AND substring(TitNumIdentificacion, 6, 1) = IntToStr(getDay(FechaNacimiento))))

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI") || STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()) >= Long.valueOf(2000) || ((STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(11)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(1), Long.valueOf(2)),STDFunctions.substringFun(STDFunctions.intToStrFun(STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())), Long.valueOf(3), Long.valueOf(2))) && (((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(2)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(3), Long.valueOf(2)),STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))) || ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(1)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(4), Long.valueOf(1)),STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()))))) && ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(2)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(5), Long.valueOf(2)),STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))) || ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(1)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(6), Long.valueOf(1)),STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))));
        if (!preconditionHolds) throw new PreconditionException("TI de 11 digitos y los 6 primeros digitos de la identificacion deben coincidir con la fecha de nacimiento del usuario");
    }

    private void checkClas1582184136704954Pre23 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "RC" OR getYear(FechaNacimiento) >= 2000 OR (length(TitNumIdentificacion) = 11 AND substring(TitNumIdentificacion, 1, 2) = substring(IntToStr(getYear(FechaNacimiento)), 3, 2) AND ((length(IntToStr(getMonth(FechaNacimiento))) = 2 AND substring(TitNumIdentificacion, 3, 2) = IntToStr(getMonth(FechaNacimiento))) OR (length(IntToStr(getMonth(FechaNacimiento))) = 1 AND substring(TitNumIdentificacion, 4, 1) = IntToStr(getMonth(FechaNacimiento)))) AND (length(IntToStr(getDay(FechaNacimiento))) = 2 AND substring(TitNumIdentificacion, 5, 2) = IntToStr(getDay(FechaNacimiento))) OR (length(IntToStr(getDay(FechaNacimiento))) = 1 AND substring(TitNumIdentificacion, 6, 1) = IntToStr(getDay(FechaNacimiento))))

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("RC") || STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()) >= Long.valueOf(2000) || ((STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(11)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(1), Long.valueOf(2)),STDFunctions.substringFun(STDFunctions.intToStrFun(STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())), Long.valueOf(3), Long.valueOf(2))) && (((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(2)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(3), Long.valueOf(2)),STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))) || ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(1)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(4), Long.valueOf(1)),STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()))))) && ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(2)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(5), Long.valueOf(2)),STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))) || ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(1)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(6), Long.valueOf(1)),STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))));
        if (!preconditionHolds) throw new PreconditionException("RC de 11 digitos y los 6 primeros digitos de la identificacion deben coincidir con la fecha de nacimiento del usuario");
    }

    private void checkClas1582184136704954Pre24 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "CE" OR length(TitNumIdentificacion) <= 7

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("CE") || STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) <= Long.valueOf(7);
        if (!preconditionHolds) throw new PreconditionException("Las CE de extranjeria correctas tienen como maximo 7 digitos en sus estructura");
    }

    private void checkClas1582184136704954Pre25 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "CE" OR fuSoloNumeros(TitNumIdentificacion) = true

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("CE") || userFunctionsSrv.fuSoloNumerosFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación sólo puede contener números");
    }

    private void checkClas1582184136704954Pre26 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "MS" OR length(TitNumIdentificacion) <= 12

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("MS") || STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) <= Long.valueOf(12);
        if (!preconditionHolds) throw new PreconditionException("Los MS correctos tienen como maximo 12 digitos en su estructura");
    }

    private void checkClas1582184136704954Pre27 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "CC" OR (length(TitNumIdentificacion) >= 3 AND length(TitNumIdentificacion) <= 10 AND length(TitNumIdentificacion) <> 9)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("CC") || (STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) >= Long.valueOf(3) && STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) <= Long.valueOf(10) && !(STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(9)));
        if (!preconditionHolds) throw new PreconditionException("CC entre 3 y 10 digitos a excepcion de 9");
    }

    private void checkClas1582184136704954Pre28 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "CC" OR fuSoloNumeros(TitNumIdentificacion) = true

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("CC") || userFunctionsSrv.fuSoloNumerosFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación sólo puede contener números");
    }

    private void checkClas1582184136704954Pre29 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // (TipoIdentificacion.NombreCorto <> "RC" AND TipoIdentificacion.NombreCorto <> "TI") OR length(TitNumIdentificacion) <> 8 OR getYear(FechaNacimiento) <> 2000 OR (substring(TitNumIdentificacion, 1, 1) = IntToStr(getMonth(FechaNacimiento)) AND (length(IntToStr(getDay(FechaNacimiento))) = 2 AND substring(TitNumIdentificacion, 2, 2) = IntToStr(getDay(FechaNacimiento)) OR length(IntToStr(getDay(FechaNacimiento))) = 1 AND substring(TitNumIdentificacion, 2, 2) = "0" + IntToStr(getDay(FechaNacimiento))))

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = (!(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("RC") && !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI")) || !(STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(8)) || !(STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())).equals(Long.valueOf(2000)) || (STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(1), Long.valueOf(1)),STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()))) && ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(2)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(2), Long.valueOf(2)),STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()))) || (STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(1)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(2), Long.valueOf(2)),"0" + STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))));
        if (!preconditionHolds) throw new PreconditionException("RC y TI solo pueden ser de 8 digitos cuando son usuarios nacidos en el año 2000 y sus 6 primeros digitos coinciden con los 6 primeros digitos de la fecha de nacimiento.");
    }

    private void checkClas1582184136704954Pre30 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // (TipoIdentificacion.NombreCorto <> "RC" AND TipoIdentificacion.NombreCorto <> "TI") OR length(TitNumIdentificacion) <> 9 OR getYear(FechaNacimiento) <> 2000 OR (substring(TitNumIdentificacion, 1, 2) = IntToStr(getMonth(FechaNacimiento)) AND (length(IntToStr(getDay(FechaNacimiento))) = 2 AND substring(TitNumIdentificacion, 3, 2) = IntToStr(getDay(FechaNacimiento)) OR length(IntToStr(getDay(FechaNacimiento))) = 1 AND substring(TitNumIdentificacion, 3, 2) = "0" + IntToStr(getDay(FechaNacimiento))))

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = (!(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("RC") && !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI")) || !(STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(9)) || !(STDFunctions.getYearFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())).equals(Long.valueOf(2000)) || (STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(1), Long.valueOf(2)),STDFunctions.intToStrFun(STDFunctions.getMonthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()))) && ((STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(2)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(3), Long.valueOf(2)),STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento()))) || (STDFunctions.lengthFun(STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))).equals(Long.valueOf(1)) && STDFunctions.areEqual(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(3), Long.valueOf(2)),"0" + STDFunctions.intToStrFun(STDFunctions.getDayFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTFechaNacimiento())))));
        if (!preconditionHolds) throw new PreconditionException("RC y TI solo pueden ser de 9 digitos cuando son usuarios nacidos en el año 2000 y sus 6 primeros digitos coinciden con los 6 primeros digitos de la fecha de nacimiento.");
    }

    private void checkClas1582184136704954Pre31 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // (TipoIdentificacion.NombreCorto <> "RC" AND TipoIdentificacion.NombreCorto <> "TI") OR length(TitNumIdentificacion) <> 10 OR TitNumIdentificacion <= "1299999999"

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = (!(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("RC") && !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI")) || !(STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(10)) || STDFunctions.strLesserThanOrEqualToFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(),"1299999999");
        if (!preconditionHolds) throw new PreconditionException("RC y TI de 10 digitos solo deben estar en un rango numerico entre 1000000000 y 1299999999");
    }

    private void checkClas1582184136704954Pre32 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "NU" OR length(TitNumIdentificacion) = 10

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("NU") || (STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion())).equals(Long.valueOf(10));
        if (!preconditionHolds) throw new PreconditionException("NU solo es valido de 10 digitos");
    }

    private void checkClas1582184136704954Pre33 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "CC" OR Genero <> "M" OR (StrToReal(TitNumIdentificacion) >= 0 AND StrToReal(TitNumIdentificacion) <= 20000000) OR (StrToReal(TitNumIdentificacion) > 70000000 AND StrToReal(TitNumIdentificacion) < 100000000) OR (StrToReal(TitNumIdentificacion) >= 1000000000)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("CC") || !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTGenero()).equals("M") || (STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) >= Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(0))) && STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) <= Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(20000000)))) || (STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) > Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(70000000))) && STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) < Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(100000000)))) || (STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) >= Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(1000000000))));
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación debe estar dentro de un rango de 0 a 20000000, de  70000000 a 10000000 (no inclusive) o de 1000000000 en adelante");
    }

    private void checkClas1582184136704954Pre34 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "CC" OR Genero <> "F" OR (StrToReal(TitNumIdentificacion) > 20000000 AND StrToReal(TitNumIdentificacion) <= 70000000) OR (StrToReal(TitNumIdentificacion) >= 1000000000)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("CC") || !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTGenero()).equals("F") || (STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) > Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(20000000))) && STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) <= Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(70000000)))) || (STDFunctions.strToRealFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) >= Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(1000000000))));
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación debe estar por fuera un rango de 20000000 y 70000000 o menor de 1000000000");
    }

    private void checkClas1582184136704954Pre35 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "TI" OR fuSoloNumeros(TitNumIdentificacion) = true

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("TI") || userFunctionsSrv.fuSoloNumerosFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación sólo puede contener números");
    }

    private void checkClas1582184136704954Pre36 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "NU" OR (length(TitNumIdentificacion) > 3 AND fuContieneCharEspecial(TitNumIdentificacion) = false AND fuSoloLetras(substring(TitNumIdentificacion, 1, 3)) = true AND fuSoloNumeros(substring(TitNumIdentificacion, 4, length(TitNumIdentificacion) - 3)) = true)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("NU") || (STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) > Long.valueOf(3) && userFunctionsSrv.fuContieneCharEspecialFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(false) && userFunctionsSrv.fuSoloLetrasFun(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(1), Long.valueOf(3))).equals(true) && userFunctionsSrv.fuSoloNumerosFun(STDFunctions.substringFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion(), Long.valueOf(4), STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) - Long.valueOf(3))).equals(true));
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación puede contener carácteres alfabeticos en las primeras 3 posiciones y números en las siguientes");
    }

    private void checkClas1582184136704954Pre37 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "RC" OR fuSoloNumeros(TitNumIdentificacion) = true

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("RC") || userFunctionsSrv.fuSoloNumerosFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación sólo puede contener números");
    }

    private void checkClas1582184136704954Pre38 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "MS" OR fuSoloNumeros(TitNumIdentificacion) = true

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("MS") || userFunctionsSrv.fuSoloNumerosFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(true);
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación sólo puede contener números");
    }

    private void checkClas1582184136704954Pre39 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.NombreCorto <> "PA" OR fuContieneCharEspecial(TitNumIdentificacion) = false

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = !(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionNombreCorto()).equals("PA") || userFunctionsSrv.fuContieneCharEspecialFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(false);
        if (!preconditionHolds) throw new PreconditionException("El Número de Identificación puede tener carácteres alfanúmericos sin carácteres especiales");
    }

    private void checkClas1582184136704954Pre40 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.Diplomatico = false OR fuContieneCharEspecial(TitNumIdentificacion) = false

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionDiplomatico().equals(false) || userFunctionsSrv.fuContieneCharEspecialFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()).equals(false);
        if (!preconditionHolds) throw new PreconditionException("El número de documento asociado a este tipo de documento es de tipo alfanumérico, puede admitir letras y números");
    }

    private void checkClas1582184136704954Pre41 (
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest request) 
            throws ModelException {
        // TipoIdentificacion.Diplomatico = false OR (length(TitNumIdentificacion) >= 3 AND length(TitNumIdentificacion) <= 11)

        NovedadCT novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT = request.getNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance();
        boolean preconditionHolds = novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getTipoIdentificacion().getTipoIdentificacionDiplomatico().equals(false) || (STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) >= Long.valueOf(3) && STDFunctions.lengthFun(novedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCT.getNovedadCTTitNumidentificacion()) <= Long.valueOf(11));
        if (!preconditionHolds) throw new PreconditionException("Para documentos de tipo diplomático, la longitud del número de identificación debe ser de entre 3 y 11 caracteres");
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.tCREARTxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.TCREARRequest request) throws ModelException {
        request.setNovedadCTTCREARptpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getNovedadCTTCREARptpagrFamiliaNovedad()));
        request.setNovedadCTTCREARptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getNovedadCTTCREARptpagrTipoIdentificacion()));
        request.setNovedadCTTCREARptpagrMunicipioNacInstance(municipioSrv.getByOIDWithHV(request.getNovedadCTTCREARptpagrMunicipioNac()));
        request.setNovedadCTTCREARptpagrMunicipioResInstance(municipioSrv.getByOIDWithHV(request.getNovedadCTTCREARptpagrMunicipioRes()));
        request.setNovedadCTTCREARptpagrDepartamentoNacInstance(departamentoSrv.getByOIDWithHV(request.getNovedadCTTCREARptpagrDepartamentoNac()));
        request.setNovedadCTTCREARptpagrDepartamentoResInstance(departamentoSrv.getByOIDWithHV(request.getNovedadCTTCREARptpagrDepartamentoRes()));
        request.setNovedadCTTCREARptpagrPaisInstance(paisSrv.getByOIDWithHV(request.getNovedadCTTCREARptpagrPais()));
        return novedadCTSrv.tCREARImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad novedadCTTCREARptpagrFamiliaNovedad = request.getNovedadCTTCREARptpagrFamiliaNovedadInstance();
        TipoIdentificacion novedadCTTCREARptpagrTipoIdentificacion = request.getNovedadCTTCREARptpagrTipoIdentificacionInstance();
        Municipio novedadCTTCREARptpagrMunicipioNac = request.getNovedadCTTCREARptpagrMunicipioNacInstance();
        Municipio novedadCTTCREARptpagrMunicipioRes = request.getNovedadCTTCREARptpagrMunicipioResInstance();
        Departamento novedadCTTCREARptpagrDepartamentoNac = request.getNovedadCTTCREARptpagrDepartamentoNacInstance();
        Departamento novedadCTTCREARptpagrDepartamentoRes = request.getNovedadCTTCREARptpagrDepartamentoResInstance();
        Pais novedadCTTCREARptpagrPais = request.getNovedadCTTCREARptpagrPaisInstance();
        String novedadCTTCREARptpatrTitNumidentificacion = request.getNovedadCTTCREARptpatrTitNumidentificacion();
        String novedadCTTCREARptpatrTitPrimerNombre = request.getNovedadCTTCREARptpatrTitPrimerNombre();
        Boolean novedadCTTCREARptpatrTitTieneBeneficios = request.getNovedadCTTCREARptpatrTitTieneBeneficios();
        String novedadCTTCREARptpatrTitSegundoNombre = request.getNovedadCTTCREARptpatrTitSegundoNombre();
        String novedadCTTCREARptpatrTitPrimerApellido = request.getNovedadCTTCREARptpatrTitPrimerApellido();
        String novedadCTTCREARptpatrTitSegundoApellido = request.getNovedadCTTCREARptpatrTitSegundoApellido();
        String novedadCTTCREARptpatrTitRazonSocial = request.getNovedadCTTCREARptpatrTitRazonSocial();
        Date novedadCTTCREARptpatrFechaNacimiento = request.getNovedadCTTCREARptpatrFechaNacimiento();
        String novedadCTTCREARptpatrGenero = request.getNovedadCTTCREARptpatrGenero();
        Boolean novedadCTTCREARptpatrIndicadorExtranjero = request.getNovedadCTTCREARptpatrIndicadorExtranjero();
        String novedadCTTCREARptpatrTelefonoFijo = request.getNovedadCTTCREARptpatrTelefonoFijo();
        String novedadCTTCREARptpatrTelefonoCelular = request.getNovedadCTTCREARptpatrTelefonoCelular();
        String novedadCTTCREARptpatrCorreoElectronico = request.getNovedadCTTCREARptpatrCorreoElectronico();
        String novedadCTTCREARptpatrDireccionCompleta = request.getNovedadCTTCREARptpatrDireccionCompleta();
        Boolean novedadCTTCREARptpatrRural = request.getNovedadCTTCREARptpatrRural();
        Long novedadCTTCREARptpatrCodigoCORE = request.getNovedadCTTCREARptpatrCodigoCORE();

        request.checkArguments();
        NovedadCT instance;

        com.keralty.aenovedades.viewmodel.novedadct.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.CrearRequest();
        step1Request.setNovedadCTcrearpagrFamiliaNovedadInstance(novedadCTTCREARptpagrFamiliaNovedad);
        step1Request.setNovedadCTcrearpagrTipoIdentificacionInstance(novedadCTTCREARptpagrTipoIdentificacion);
        step1Request.setNovedadCTcrearpagrFirmaInstance(null);
        step1Request.setNovedadCTcrearpagrMunicipioNacInstance(novedadCTTCREARptpagrMunicipioNac);
        step1Request.setNovedadCTcrearpagrMunicipioResInstance(novedadCTTCREARptpagrMunicipioRes);
        step1Request.setNovedadCTcrearpagrDepartamentoNacInstance(novedadCTTCREARptpagrDepartamentoNac);
        step1Request.setNovedadCTcrearpagrDepartamentoResInstance(novedadCTTCREARptpagrDepartamentoRes);
        step1Request.setNovedadCTcrearpagrPaisInstance(novedadCTTCREARptpagrPais);
        step1Request.setNovedadCTcrearpatrTitNumidentificacion(novedadCTTCREARptpatrTitNumidentificacion);
        step1Request.setNovedadCTcrearpatrTitPrimerNombre(novedadCTTCREARptpatrTitPrimerNombre);
        step1Request.setNovedadCTcrearpatrTitTieneBeneficios(novedadCTTCREARptpatrTitTieneBeneficios);
        step1Request.setNovedadCTcrearpatrTitSegundoNombre(novedadCTTCREARptpatrTitSegundoNombre);
        step1Request.setNovedadCTcrearpatrTitPrimerApellido(novedadCTTCREARptpatrTitPrimerApellido);
        step1Request.setNovedadCTcrearpatrTitSegundoApellido(novedadCTTCREARptpatrTitSegundoApellido);
        step1Request.setNovedadCTcrearpatrTitRazonSocial(novedadCTTCREARptpatrTitRazonSocial);
        step1Request.setNovedadCTcrearpatrFechaNacimiento(novedadCTTCREARptpatrFechaNacimiento);
        step1Request.setNovedadCTcrearpatrGenero(novedadCTTCREARptpatrGenero);
        step1Request.setNovedadCTcrearpatrIndicadorExtranjero(novedadCTTCREARptpatrIndicadorExtranjero);
        step1Request.setNovedadCTcrearpatrTelefonoFijo(novedadCTTCREARptpatrTelefonoFijo);
        step1Request.setNovedadCTcrearpatrTelefonoCelular(novedadCTTCREARptpatrTelefonoCelular);
        step1Request.setNovedadCTcrearpatrCorreoElectronico(novedadCTTCREARptpatrCorreoElectronico);
        step1Request.setNovedadCTcrearpatrDireccionCompleta(novedadCTTCREARptpatrDireccionCompleta);
        step1Request.setNovedadCTcrearpatrRural(novedadCTTCREARptpatrRural);
        step1Request.setNovedadCTcrearpatrCodigoCORE(novedadCTTCREARptpatrCodigoCORE);
        instance = (NovedadCT) novedadCTSrv.crearImplementation(step1Request).getInstance();

        com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest step2Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaRequest();
        step2Request.setNovedadCTvalidarDatosRestrictivapthisNovedadCTInstance(instance);
        novedadCTSrv.validarDatosRestrictivaImplementation(step2Request);

        /* Action 3: IF (CodigoCORE = NULL) */
        boolean ifCondition3 = instance.getNovedadCTCodigoCORE() == null;
        if (ifCondition3) {
            com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest step30Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.ValidarDatosRestrictivaTipoIdRequest();
            step30Request.setNovedadCTvalidarDatosRestrictivaTipoIdpthisNovedadCTInstance(instance);
            novedadCTSrv.validarDatosRestrictivaTipoIdImplementation(step30Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TCREAROMODFIRMANUEVOTIT

    /*
     * Entry point for service TCREAROMODFIRMANUEVOTIT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAROMODFIRMANUEVOTIT(
            com.keralty.aenovedades.viewmodel.novedadct.siu.TCREAROMODFIRMANUEVOTITRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.tCREAROMODFIRMANUEVOTITTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAROMODFIRMANUEVOTIT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREAROMODFIRMANUEVOTITTxn(
            com.keralty.aenovedades.viewmodel.novedadct.siu.TCREAROMODFIRMANUEVOTITRequest request) throws ModelException, SystemException {
        request.setNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance(novedadCTSrv.getByOIDWithHV(request.getNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT()));
        return novedadCTSrv.tCREAROMODFIRMANUEVOTITImplementation(request);
    }

    /*
     * Implements service TCREAROMODFIRMANUEVOTIT
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREAROMODFIRMANUEVOTITImplementation(
            com.keralty.aenovedades.viewmodel.novedadct.siu.TCREAROMODFIRMANUEVOTITRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        byte[] novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma = request.getNovedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma();
        String novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud = request.getNovedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud();
        String novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud = request.getNovedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud();
        NovedadCT novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT = request.getNovedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCTInstance();

        request.checkArguments();
        NovedadCT instance = novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT;

        /* Action 1: IF (EXIST (Firma) = false) */
        boolean ifCondition1 = repository.assocOperator001(novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT).equals(false);
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.firma.siu.TCREARNOVEDADCTRequest step10Request = new com.keralty.aenovedades.viewmodel.firma.siu.TCREARNOVEDADCTRequest();
            step10Request.setFirmaTCREARNOVEDADCTptpatrImagenFirma(novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma);
            step10Request.setFirmaTCREARNOVEDADCTptpatrLatitud(novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud);
            step10Request.setFirmaTCREARNOVEDADCTptpatrLongitud(novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud);
            step10Request.setFirmaTCREARNOVEDADCTptNovedadCTInstance(novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT);
            firmaSrv.tCREARNOVEDADCTImplementation(step10Request);
        } else {
            com.keralty.aenovedades.viewmodel.firma.siu.ModificarRequest step11Request = new com.keralty.aenovedades.viewmodel.firma.siu.ModificarRequest();
            step11Request.setFirmamodificarpthisFirmaInstance(novedadCTTCREAROMODFIRMANUEVOTITpthisNovedadCT.getFirma());
            step11Request.setFirmamodificarpImagenFirma(novedadCTTCREAROMODFIRMANUEVOTITptpatrImagenFirma);
            step11Request.setFirmamodificarpLatitud(novedadCTTCREAROMODFIRMANUEVOTITptpatrLatitud);
            step11Request.setFirmamodificarpLongitud(novedadCTTCREAROMODFIRMANUEVOTITptpatrLongitud);
            firmaSrv.modificarImplementation(step11Request);
        }

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
            com.keralty.aenovedades.viewmodel.novedadct.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = novedadCTSrv.tDELETETxn(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.TDELETERequest request) throws ModelException, SystemException {
        request.setNovedadCTTDELETEpthisNovedadCTInstance(novedadCTSrv.getByOIDWithHV(request.getNovedadCTTDELETEpthisNovedadCT()));
        return novedadCTSrv.tDELETEImplementation(request);
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
            com.keralty.aenovedades.viewmodel.novedadct.siu.TDELETERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        NovedadCT novedadCTTDELETEpthisNovedadCT = request.getNovedadCTTDELETEpthisNovedadCTInstance();

        request.checkArguments();
        NovedadCT instance = novedadCTTDELETEpthisNovedadCT;

        for(Firma step1Entity : repository.assocOperator002(novedadCTTDELETEpthisNovedadCT)) {
            com.keralty.aenovedades.viewmodel.firma.siu.EliminarInternoRequest step1Request = new com.keralty.aenovedades.viewmodel.firma.siu.EliminarInternoRequest();
            step1Request.setFirmaeliminarInternopthisFirmaInstance(step1Entity);
            firmaSrv.eliminarInternoImplementation(step1Request);
        }

        com.keralty.aenovedades.viewmodel.novedadct.siu.EliminarRequest step2Request = new com.keralty.aenovedades.viewmodel.novedadct.siu.EliminarRequest();
        step2Request.setNovedadCTeliminarpthisFamiliaNovedadInstance(novedadCTTDELETEpthisNovedadCT);
        novedadCTSrv.eliminarImplementation(step2Request);

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
        select.getOrderByPart().addItem(Constants.normalizePath(NovedadCTConstants.CLASS_NAME, NovedadCTConstants.ATTR_FIELD_NOVEDADCTIDNOVEDADCT, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildNovedadCTRelatedInstance(relatedInstanceJsonOid);
        }
        if (NovedadCTConstants.ROLE_NAME_FAMILIANOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadCTRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadCTConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadCTRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadCTConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadCTRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadCTConstants.ROLE_NAME_MUNICIPIONAC.equalsIgnoreCase(relatedInstancePathFirstItem) || NovedadCTConstants.ROLE_NAME_MUNICIPIORES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadCTRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadCTConstants.ROLE_NAME_DEPARTAMENTONAC.equalsIgnoreCase(relatedInstancePathFirstItem) || NovedadCTConstants.ROLE_NAME_DEPARTAMENTORES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadCTRelatedInstance4Departamento(relatedInstanceJsonOid, remainingPath);
        }
        if (NovedadCTConstants.ROLE_NAME_PAIS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildNovedadCTRelatedInstance4Pais(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildNovedadCTRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new NovedadCT(mapper.readValue(relatedInstanceJsonOid, NovedadCTOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadCTRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): FamiliaNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadCTRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadCTRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadCTRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadCTRelatedInstance4Departamento(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Departamento(mapper.readValue(relatedInstanceJsonOid, DepartamentoOid.class)): Departamento.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildNovedadCTRelatedInstance4Pais(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Pais(mapper.readValue(relatedInstanceJsonOid, PaisOid.class)): Pais.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            NovedadCTOid oid = new NovedadCTOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(NovedadCTConstants.ATTR_FIELD_NOVEDADCTIDNOVEDADCT, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getNovedadCTidNovedadCT(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(NovedadCTService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
