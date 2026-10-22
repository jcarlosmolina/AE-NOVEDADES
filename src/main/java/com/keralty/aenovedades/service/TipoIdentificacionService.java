package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.AsesorOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.oid.UsuarioOid;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.Usuario;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.repository.TipoIdentificacionJpaRepository;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereConjunction;
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
public class TipoIdentificacionService extends AbstractService {

    TipoIdentificacionJpaRepository repository;

    TipoIdentificacionService tipoIdentificacionSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    FamiliaNovedadService familiaNovedadSrv;

    UsuarioNovedadService usuarioNovedadSrv;

    UsuarioService usuarioSrv;

    NovedadCTService novedadCTSrv;

    @Inject
    public TipoIdentificacionService(
            TipoIdentificacionService tipoIdentificacionSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            FamiliaNovedadService familiaNovedadSrv,
            UsuarioNovedadService usuarioNovedadSrv,
            UsuarioService usuarioSrv,
            NovedadCTService novedadCTSrv,
            TipoIdentificacionJpaRepository repository) {
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.usuarioNovedadSrv = usuarioNovedadSrv;
        this.usuarioSrv = usuarioSrv;
        this.novedadCTSrv = novedadCTSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, TipoIdentificacionConstants.CLASS_NAME);
    }

    private List<TipoIdentificacion> solveTipoIdentificacionTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, TipoIdentificacionConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveTipoIdentificacionTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, TipoIdentificacionConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class TipoIdentificacion
     *
     * @return Population of class TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> get() {
        List<TipoIdentificacion> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class TipoIdentificacion
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<TipoIdentificacion> instances = get(queryRequest);
        if(TipoIdentificacionConstants.DSICTIPOIDENTIFICACION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICTipoIdentificacion())).collect(Collectors.toList());
        }
        if(TipoIdentificacionConstants.DSDSTIPOIDENTIFICACIONNULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSTipoIdentificacionNull())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class TipoIdentificacion that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class TipoIdentificacion matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> get(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveTipoIdentificacionTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveTipoIdentificacionTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveTipoIdentificacionTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveTipoIdentificacionTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of TipoIdentificacion by ID
     *
     * @param tipoIdentificacionCodigo Identification field tipoIdentificacionCodigo
     *
     * @return Instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoIdentificacion getById(Long tipoIdentificacionCodigo) {
        return getByOID(new TipoIdentificacionOid(tipoIdentificacionCodigo));
    }
    
    /*
     * Returns an instance of TipoIdentificacion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoIdentificacion getByOID(TipoIdentificacionOid oid) {
        Optional<TipoIdentificacion> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of TipoIdentificacion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoIdentificacion getByOIDWithHV(TipoIdentificacionOid oid) {
        Optional<TipoIdentificacion> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<TipoIdentificacion> getInstanceByOid(TipoIdentificacionOid oid) {
        return oid != null && oid.getTipoIdentificacionCodigo() != null
               ? repository.findById(oid.getTipoIdentificacionCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of TipoIdentificacion by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of TipoIdentificacion
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoIdentificacion getByJsonOid(String jsonOid) {
        TipoIdentificacionOid oid = new TipoIdentificacionOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of TipoIdentificacion related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveTipoIdentificacionTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of TipoIdentificacion related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of TipoIdentificacion
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getTipoIdentificacionDynamic(TipoIdentificacionOid oid, String displaySetItems) {
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
    public String getSuppInfo(TipoIdentificacionOid oid, String dsName) {
        TipoIdentificacion instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(TipoIdentificacion instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (TipoIdentificacionConstants.DSICTIPOIDENTIFICACION.equals(dsName))
            return instance.buildICTipoIdentificacion();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(TipoIdentificacion instance, String dsName) {
        if (TipoIdentificacionConstants.DSICTIPOIDENTIFICACION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICTipoIdentificacion());
        if (TipoIdentificacionConstants.DSDSTIPOIDENTIFICACIONNULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSTipoIdentificacionNull());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (TipoIdentificacionConstants.FILTER_NAME_IFTIPOIDENTIFICACIONNOMBREC.equalsIgnoreCase(filterRequest.getName()))
            iFTipoIdentificacionNombreC(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Persona_TADDUSUARIOASOL_pt_p_agrTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431886233600805FiltNav10(sql);
        if ("Solicitud_TINDICARCONTRATANTE2_pt_p_evcTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav32(sql);
        if ("Solicitud_TINDICARTITULAR2_pt_p_agrTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav31(sql);
        if ("Usuario_TMODUSUARIO_pt_p_evcTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1432633737216826FiltNav3(sql);
        if ("UsuarioNovedad_TCAMBIARTIPOIDENT_pt_p_evcTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1581442138112529FiltNav4(sql);
        if ("TGValidadorUsuarios_ptTipoDoc_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            iGl1658391625728650FiltNav1(sql);
        if ("Persona_F_PersonaConsultarCORE_vo_TipoIdentificacion_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431886233600805FiltNav6(sql);
        if ("Persona_F_PersonaConsultarCORENat_vo_TipoIdentificacion_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431886233600805FiltNav8(sql);
    }


    private void iFTipoIdentificacionNombreC(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vNombreCorto = filterRequest.hasFilterVariable(TipoIdentificacionConstants.VAR_NAME_IFTIPOIDENTIFICACIONNOMBREC_VNOMBRECORTO) ? (String) filterRequest.getFilterVariable(TipoIdentificacionConstants.VAR_NAME_IFTIPOIDENTIFICACIONNOMBREC_VNOMBRECORTO, FilterVariableRequest.STRING) : null;

        // NombreCorto = vNombreCorto
        if (vNombreCorto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vNombreCorto, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void clas1431886233600805FiltNav10(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // NIT = false
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNIT, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431957012480960FiltNav32(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // ValidoContratante = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONVALIDOCONTRATANTE, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431957012480960FiltNav31(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // ValidoTitular = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONVALIDOTITULAR, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1432633737216826FiltNav3(SQLSelect sql) {
        clas1431886233600805FiltNav10(sql);
    }

    private void clas1581442138112529FiltNav4(SQLSelect sql) {
        clas1431886233600805FiltNav10(sql);
    }

    private void iGl1658391625728650FiltNav1(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // VisibleValidadorUsu = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONVISIBLEVALIDADORUSU, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431886233600805FiltNav6(SQLSelect sql) {
        clas1431957012480960FiltNav32(sql);
    }

    private void clas1431886233600805FiltNav8(SQLSelect sql) {
        clas1431957012480960FiltNav32(sql);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUTipoIdentificacion
     *
     * @param queryRequest Query request
     * @return List of viewmodels for TipoIdentificacion using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.tipoidentificacion.ds.AutoDS> piuPIUTipoIdentificacion(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.tipoidentificacion.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUTipoIdentificacion
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUTipoIdentificacion
     */
    public int getCount4PIUTipoIdentificacion(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUTipoIdentificacionNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for TipoIdentificacion using displayset DSTipoIdentificacionNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.tipoidentificacion.ds.DSTipoIdentificacionNull> piuPIUTipoIdentificacionNull(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.tipoidentificacion.ds.DSTipoIdentificacionNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUTipoIdentificacionNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUTipoIdentificacionNull
     */
    public int getCount4PIUTipoIdentificacionNull(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest).size();
    }

    // Service: InsTipoIdentContratante

    /*
     * Entry point for service InsTipoIdentContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoIdentContratante(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.insTipoIdentContratanteTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoIdentContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoIdentContratanteTxn(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentContratanteRequest request) throws ModelException {
        request.setTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion())));
        request.setTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad()));
        return tipoIdentificacionSrv.insTipoIdentContratanteImplementation(request, true);
    }

    /*
     * Implements service InsTipoIdentContratante
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoIdentContratanteImplementation(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion = request.getTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance();
        SolicitudNovedad tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad = request.getTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsTipoIdentContratanteRequest relatedRequest = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsTipoIdentContratanteRequest();
            relatedRequest.setSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance(tipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedad);
            relatedRequest.setSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance(tipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacion);
            solicitudNovedadSrv.insTipoIdentContratanteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: DelTipoIdentContratante

    /*
     * Entry point for service DelTipoIdentContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoIdentContratante(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.delTipoIdentContratanteTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoIdentContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoIdentContratanteTxn(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentContratanteRequest request) throws ModelException {
        request.setTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion())));
        request.setTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad()));
        return tipoIdentificacionSrv.delTipoIdentContratanteImplementation(request, true);
    }

    /*
     * Implements service DelTipoIdentContratante
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoIdentContratanteImplementation(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion = request.getTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance();
        SolicitudNovedad tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad = request.getTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelTipoIdentContratanteRequest relatedRequest = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelTipoIdentContratanteRequest();
            relatedRequest.setSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance(tipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedad);
            relatedRequest.setSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance(tipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacion);
            solicitudNovedadSrv.delTipoIdentContratanteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

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
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.insTipoIdentificacionTxn(request);
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
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionRequest request) throws ModelException {
        request.setTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion())));
        request.setTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad()));
        return tipoIdentificacionSrv.insTipoIdentificacionImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion = request.getTipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacionInstance();
        FamiliaNovedad tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad = request.getTipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.InsTipoIdentificacionRequest relatedRequest = new com.keralty.aenovedades.viewmodel.familianovedad.siu.InsTipoIdentificacionRequest();
            relatedRequest.setFamiliaNovedadInsTipoIdentificacionpthisFamiliaNovedadInstance(tipoIdentificacionInsTipoIdentificacionpevcFamiliaNovedad);
            relatedRequest.setFamiliaNovedadInsTipoIdentificacionpevcTipoIdentificacionInstance(tipoIdentificacionInsTipoIdentificacionpthisTipoIdentificacion);
            familiaNovedadSrv.insTipoIdentificacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

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
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.delTipoIdentificacionTxn(request);
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
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionRequest request) throws ModelException {
        request.setTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion())));
        request.setTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad()));
        return tipoIdentificacionSrv.delTipoIdentificacionImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion = request.getTipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacionInstance();
        FamiliaNovedad tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad = request.getTipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.familianovedad.siu.DelTipoIdentificacionRequest relatedRequest = new com.keralty.aenovedades.viewmodel.familianovedad.siu.DelTipoIdentificacionRequest();
            relatedRequest.setFamiliaNovedadDelTipoIdentificacionpthisFamiliaNovedadInstance(tipoIdentificacionDelTipoIdentificacionpevcFamiliaNovedad);
            relatedRequest.setFamiliaNovedadDelTipoIdentificacionpevcTipoIdentificacionInstance(tipoIdentificacionDelTipoIdentificacionpthisTipoIdentificacion);
            familiaNovedadSrv.delTipoIdentificacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: InsTipoIdentUsuNovedad

    /*
     * Entry point for service InsTipoIdentUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoIdentUsuNovedad(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.insTipoIdentUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoIdentUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoIdentUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentUsuNovedadRequest request) throws ModelException {
        request.setTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion())));
        request.setTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad()));
        return tipoIdentificacionSrv.insTipoIdentUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service InsTipoIdentUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoIdentUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion = request.getTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance();
        UsuarioNovedad tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad = request.getTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdentUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdentUsuNovedadRequest();
            relatedRequest.setUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance(tipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedad);
            relatedRequest.setUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacion);
            usuarioNovedadSrv.insTipoIdentUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: DelTipoIdentUsuNovedad

    /*
     * Entry point for service DelTipoIdentUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoIdentUsuNovedad(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.delTipoIdentUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoIdentUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoIdentUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentUsuNovedadRequest request) throws ModelException {
        request.setTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion())));
        request.setTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad()));
        return tipoIdentificacionSrv.delTipoIdentUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service DelTipoIdentUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoIdentUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion = request.getTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance();
        UsuarioNovedad tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad = request.getTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdentUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdentUsuNovedadRequest();
            relatedRequest.setUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance(tipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedad);
            relatedRequest.setUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacion);
            usuarioNovedadSrv.delTipoIdentUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: InsTipoIdCDUsuNovedad

    /*
     * Entry point for service InsTipoIdCDUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoIdCDUsuNovedad(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdCDUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.insTipoIdCDUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoIdCDUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoIdCDUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdCDUsuNovedadRequest request) throws ModelException {
        request.setTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion())));
        request.setTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad()));
        return tipoIdentificacionSrv.insTipoIdCDUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service InsTipoIdCDUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoIdCDUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdCDUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion = request.getTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance();
        UsuarioNovedad tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad = request.getTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdCDUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdCDUsuNovedadRequest();
            relatedRequest.setUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(tipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedad);
            relatedRequest.setUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacion);
            usuarioNovedadSrv.insTipoIdCDUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: DelTipoIdCDUsuNovedad

    /*
     * Entry point for service DelTipoIdCDUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoIdCDUsuNovedad(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdCDUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.delTipoIdCDUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoIdCDUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoIdCDUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdCDUsuNovedadRequest request) throws ModelException {
        request.setTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion())));
        request.setTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad()));
        return tipoIdentificacionSrv.delTipoIdCDUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service DelTipoIdCDUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoIdCDUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdCDUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion = request.getTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance();
        UsuarioNovedad tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad = request.getTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdCDUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdCDUsuNovedadRequest();
            relatedRequest.setUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(tipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedad);
            relatedRequest.setUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacion);
            usuarioNovedadSrv.delTipoIdCDUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCTipoIdentificacion(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.ATTR_FIELD_TIPOIDENTIFICACIONCODIGO, false), true);
    }


    private void applyOCOCTipoIdentificacion(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_TipoIdentificacion".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildTipoIdentificacionRelatedInstance(relatedInstanceJsonOid);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_ASESORES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4Asesor(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_USUARIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4Usuario(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_FAMILIASNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_USUARIOSNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || TipoIdentificacionConstants.ROLE_NAME_USUARIONOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4UsuarioNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_NOVEDADESCT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4NovedadCT(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildTipoIdentificacionRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4Asesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Asesor(mapper.readValue(relatedInstanceJsonOid, AsesorOid.class)): Asesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4Usuario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Usuario(mapper.readValue(relatedInstanceJsonOid, UsuarioOid.class)): Usuario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): FamiliaNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4UsuarioNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new UsuarioNovedad(mapper.readValue(relatedInstanceJsonOid, UsuarioNovedadOid.class)): UsuarioNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4NovedadCT(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new NovedadCT(mapper.readValue(relatedInstanceJsonOid, NovedadCTOid.class)): NovedadCT.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            TipoIdentificacionOid oid = new TipoIdentificacionOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_FIELD_TIPOIDENTIFICACIONCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getTipoIdentificacionCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(TipoIdentificacionService.class).error(e.getMessage());
        }
    }

}
