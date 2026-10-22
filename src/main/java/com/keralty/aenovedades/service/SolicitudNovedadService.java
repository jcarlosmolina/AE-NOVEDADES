package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.MinCardinalityException;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.PreconditionException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.AfiliacionesConstants;
import com.keralty.aenovedades.global.AsesorConstants;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.FuncionarioConstants;
import com.keralty.aenovedades.global.NovedadConstants;
import com.keralty.aenovedades.global.PlanesConstants;
import com.keralty.aenovedades.global.ProductosConstants;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.global.TipoNovedadConstants;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Afiliaciones;
import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.Causal;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.LogEstadoSN;
import com.keralty.aenovedades.persistence.LogUsrSolNov;
import com.keralty.aenovedades.persistence.MotivoExcepcionSolNov;
import com.keralty.aenovedades.persistence.Novedad;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.oid.CausalOid;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;
import com.keralty.aenovedades.persistence.oid.EstadoContratoOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.FuncionarioOid;
import com.keralty.aenovedades.persistence.oid.GrupoAsociadoOid;
import com.keralty.aenovedades.persistence.oid.LogEstadoSNOid;
import com.keralty.aenovedades.persistence.oid.LogUsrSolNovOid;
import com.keralty.aenovedades.persistence.oid.MotivoExcepcionSolNovOid;
import com.keralty.aenovedades.persistence.oid.NovedadCTOid;
import com.keralty.aenovedades.persistence.oid.NovedadOid;
import com.keralty.aenovedades.persistence.oid.PeriodicidadOid;
import com.keralty.aenovedades.persistence.oid.PlanesOid;
import com.keralty.aenovedades.persistence.oid.ProductosOid;
import com.keralty.aenovedades.persistence.oid.ProteccionDatosOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.TipoNovedadOid;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.Planes;
import com.keralty.aenovedades.persistence.Productos;
import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.TipoNovedad;
import com.keralty.aenovedades.repository.SolicitudNovedadJpaRepository;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereConjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereDisjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandNull;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandSubQuery;
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
public class SolicitudNovedadService extends AbstractService {

    SolicitudNovedadJpaRepository repository;

    SolicitudNovedadService solicitudNovedadSrv;

    PlanesService planesSrv;

    NovedadService novedadSrv;

    CausalService causalSrv;

    ProteccionDatosService proteccionDatosSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    EstadoContratoService estadoContratoSrv;

    GrupoAsociadoService grupoAsociadoSrv;

    PeriodicidadService periodicidadSrv;

    MotivoExcepcionSolNovService motivoExcepcionSolNovSrv;

    FirmaService firmaSrv;

    ProductosService productosSrv;

    TipoNovedadService tipoNovedadSrv;

    FamiliaNovedadService familiaNovedadSrv;

    DocumentoNovedadService documentoNovedadSrv;

    NovedadCTService novedadCTSrv;

    LogEstadoSNService logEstadoSNSrv;

    LogUsrSolNovService logUsrSolNovSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public SolicitudNovedadService(
            SolicitudNovedadService solicitudNovedadSrv,
            PlanesService planesSrv,
            NovedadService novedadSrv,
            CausalService causalSrv,
            ProteccionDatosService proteccionDatosSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            EstadoContratoService estadoContratoSrv,
            GrupoAsociadoService grupoAsociadoSrv,
            PeriodicidadService periodicidadSrv,
            MotivoExcepcionSolNovService motivoExcepcionSolNovSrv,
            FirmaService firmaSrv,
            ProductosService productosSrv,
            TipoNovedadService tipoNovedadSrv,
            FamiliaNovedadService familiaNovedadSrv,
            DocumentoNovedadService documentoNovedadSrv,
            NovedadCTService novedadCTSrv,
            LogEstadoSNService logEstadoSNSrv,
            LogUsrSolNovService logUsrSolNovSrv,
            UserFunctions userFunctionsSrv,
            SolicitudNovedadJpaRepository repository) {
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.planesSrv = planesSrv;
        this.novedadSrv = novedadSrv;
        this.causalSrv = causalSrv;
        this.proteccionDatosSrv = proteccionDatosSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.estadoContratoSrv = estadoContratoSrv;
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.periodicidadSrv = periodicidadSrv;
        this.motivoExcepcionSolNovSrv = motivoExcepcionSolNovSrv;
        this.firmaSrv = firmaSrv;
        this.productosSrv = productosSrv;
        this.tipoNovedadSrv = tipoNovedadSrv;
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.documentoNovedadSrv = documentoNovedadSrv;
        this.novedadCTSrv = novedadCTSrv;
        this.logEstadoSNSrv = logEstadoSNSrv;
        this.logUsrSolNovSrv = logUsrSolNovSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, SolicitudNovedadConstants.CLASS_NAME);
    }

    private List<SolicitudNovedad> solveSolicitudNovedadTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, SolicitudNovedadConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveSolicitudNovedadTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, SolicitudNovedadConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class SolicitudNovedad
     *
     * @return Population of class SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> get() {
        List<SolicitudNovedad> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class SolicitudNovedad
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<SolicitudNovedad> instances = get(queryRequest);
        if(SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADCON.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolicitudNovedadCon())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVTIPOCONTRATO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovTipoContrato())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVCONTRATANTE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovContratante())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVOBSERVACIONES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovObservaciones())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVTIPOTITULAR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovTipoTitular())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVESTATUS.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovEstatus())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVTIPOUSUARIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovTipoUsuario())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVCONTRATIPOTITULAR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovContraTipoTitular())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSICSOLICITUDNOVEDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICSolicitudNovedad())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVESTATUSAFILIACION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovEstatusAfiliacion())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVESTATUSASESOR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovEstatusAsesor())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADNULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolicitudNovedadNull())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class SolicitudNovedad that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class SolicitudNovedad matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> get(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveSolicitudNovedadTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveSolicitudNovedadTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveSolicitudNovedadTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of SolicitudNovedad by ID
     *
     * @param solicitudNovedadId Identification field solicitudNovedadId
     *
     * @return Instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SolicitudNovedad getById(Long solicitudNovedadId) {
        return getByOID(new SolicitudNovedadOid(solicitudNovedadId));
    }
    
    /*
     * Returns an instance of SolicitudNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SolicitudNovedad getByOID(SolicitudNovedadOid oid) {
        Optional<SolicitudNovedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of SolicitudNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public SolicitudNovedad getByOIDWithHV(SolicitudNovedadOid oid) {
        Optional<SolicitudNovedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<SolicitudNovedad> getInstanceByOid(SolicitudNovedadOid oid) {
        return oid != null && oid.getSolicitudNovedadId() != null
               ? repository.findById(oid.getSolicitudNovedadId())
               : Optional.empty();
    }

    /*
     * Returns an instance of SolicitudNovedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of SolicitudNovedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public SolicitudNovedad getByJsonOid(String jsonOid) {
        SolicitudNovedadOid oid = new SolicitudNovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of SolicitudNovedad related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveSolicitudNovedadTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of SolicitudNovedad related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of SolicitudNovedad
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getSolicitudNovedadDynamic(SolicitudNovedadOid oid, String displaySetItems) {
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
    public String getSuppInfo(SolicitudNovedadOid oid, String dsName) {
        SolicitudNovedad instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(SolicitudNovedad instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (SolicitudNovedadConstants.DSICSOLICITUDNOVEDAD.equals(dsName))
            return instance.buildICSolicitudNovedad();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(SolicitudNovedad instance, String dsName) {
        if (SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADCON.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolicitudNovedadCon());
        if (SolicitudNovedadConstants.DSDSSOLNOVTIPOCONTRATO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovTipoContrato());
        if (SolicitudNovedadConstants.DSDSSOLNOVCONTRATANTE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovContratante());
        if (SolicitudNovedadConstants.DSDSSOLNOVOBSERVACIONES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovObservaciones());
        if (SolicitudNovedadConstants.DSDSSOLNOVTIPOTITULAR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovTipoTitular());
        if (SolicitudNovedadConstants.DSDSSOLNOVESTATUS.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovEstatus());
        if (SolicitudNovedadConstants.DSDSSOLNOVTIPOUSUARIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovTipoUsuario());
        if (SolicitudNovedadConstants.DSDSSOLNOVCONTRATIPOTITULAR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovContraTipoTitular());
        if (SolicitudNovedadConstants.DSICSOLICITUDNOVEDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICSolicitudNovedad());
        if (SolicitudNovedadConstants.DSDSSOLNOVESTATUSAFILIACION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovEstatusAfiliacion());
        if (SolicitudNovedadConstants.DSDSSOLNOVESTATUSASESOR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovEstatusAsesor());
        if (SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADNULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolicitudNovedadNull());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADNUMFECHAS.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadNumFechas(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADNUMFECHESTA.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadNumFechEsta(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_IFILTROPORNUMRADICADO.equalsIgnoreCase(filterRequest.getName()))
            iFiltroPorNumRadicado(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADESTATUAFIL1.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadEstatuAfil1(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADESTATUAFIL2.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadEstatuAfil2(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADESTATUAFIL3.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadEstatuAfil3(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_IFSOLNOVVALIDADORUSUARIOS.equalsIgnoreCase(filterRequest.getName()))
            iFSolNovValidadorUsuarios(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_SolicitudNovedad".equals(filterRequest.getName()))
            suppInfo4ICSolicitudNovedad(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fSolicitudNovedadNumFechas(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFHASTA, FilterVariableRequest.DATE) : null;

        // Completada = false
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);


        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadNumFechEsta(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;
        Long vfEstadoDoc = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADODOC) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADODOC, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // EstadoDocumentacion = vfEstadoDoc
        if (vfEstadoDoc != null) {
            // '=' Comparison
            SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
            comparison6.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
            comparison6.setFirstOperand(operand117);
            
            // Operand 2
            comparison6.setSecondOperand(new SQLWhereOperandLiteral(vfEstadoDoc, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison6);

        }        

        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison7 = new SQLWhereComparison(sql);
        comparison7.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand118 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison7.setFirstOperand(operand118);
        
        // Operand 2
        comparison7.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison7);


        sql.addConjunction(conjunction);
    }

    private void iFiltroPorNumRadicado(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFILTROPORNUMRADICADO_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFILTROPORNUMRADICADO_VFNUMRADICADO, FilterVariableRequest.INT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadEstatuAfil1(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;
        Long vfEstadoDoc = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADODOC) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADODOC, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // EstadoDocumentacion = vfEstadoDoc
        if (vfEstadoDoc != null) {
            // '=' Comparison
            SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
            comparison6.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
            comparison6.setFirstOperand(operand117);
            
            // Operand 2
            comparison6.setSecondOperand(new SQLWhereOperandLiteral(vfEstadoDoc, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison6);

        }        

        // ((EstadoDocumentacion = 1 AND Estado <> 4 AND FechaTerminada = NULL) OR (EstadoDocumentacion = 2 AND Estado = 1))
    {
        // 'or' Logical operator
        SQLWhereDisjunction comparison7 = new SQLWhereDisjunction();
    
        // Operand 1
        {
            // 'and' Logical operator
            SQLWhereConjunction comparison8 = new SQLWhereConjunction();
        
            // Operand 1
            {
                // 'and' Logical operator
                SQLWhereConjunction comparison9 = new SQLWhereConjunction();
            
                // Operand 1
                    // '=' Comparison
                    SQLWhereComparison comparison10 = new SQLWhereComparison(sql);
                    comparison10.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand1111 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
                    comparison10.setFirstOperand(operand1111);
                    
                    // Operand 2
                    comparison10.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    comparison9.addOperand(comparison10);
            
                // Operand 2
                    // '<>' Comparison
                    SQLWhereComparison comparison12 = new SQLWhereComparison(sql);
                    comparison12.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand1113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
                    comparison12.setFirstOperand(operand1113);
                    
                    // Operand 2
                    comparison12.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(4), Constants.Type.NAT.getTypeName()));
                    comparison9.addOperand(comparison12);
                
                comparison8.addOperand(comparison9);
            }
        
            // Operand 2
                // '=' Comparison
                SQLWhereComparison comparison13 = new SQLWhereComparison(sql);
                comparison13.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand1114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHATERMINADA, Constants.Type.DATE.getTypeName());
                comparison13.setFirstOperand(operand1114);
                
                // Operand 2
                comparison13.setSecondOperand(new SQLWhereOperandNull());
                comparison8.addOperand(comparison13);
            
            comparison7.addOperand(comparison8);
        }
    
        // Operand 2
        {
            // 'and' Logical operator
            SQLWhereConjunction comparison130 = new SQLWhereConjunction();
        
            // Operand 1
                // '=' Comparison
                SQLWhereComparison comparison14 = new SQLWhereComparison(sql);
                comparison14.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand1115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
                comparison14.setFirstOperand(operand1115);
                
                // Operand 2
                comparison14.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                comparison130.addOperand(comparison14);
        
            // Operand 2
                // '=' Comparison
                SQLWhereComparison comparison16 = new SQLWhereComparison(sql);
                comparison16.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand1117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
                comparison16.setFirstOperand(operand1117);
                
                // Operand 2
                comparison16.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                comparison130.addOperand(comparison16);
            
            comparison7.addOperand(comparison130);
        }
        
        conjunction.addOperand(comparison7);
    }


        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
        comparison8.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison8.setFirstOperand(operand119);
        
        // Operand 2
        comparison8.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison8);


        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadEstatuAfil2(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // FechaTerminada = NULL
        // '=' Comparison
        SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
        comparison6.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHATERMINADA, Constants.Type.DATE.getTypeName());
        comparison6.setFirstOperand(operand117);
        
        // Operand 2
        comparison6.setSecondOperand(new SQLWhereOperandNull());
        conjunction.addOperand(comparison6);


        // EstadoDocumentacion = 3
        // '=' Comparison
        SQLWhereComparison comparison7 = new SQLWhereComparison(sql);
        comparison7.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand118 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
        comparison7.setFirstOperand(operand118);
        
        // Operand 2
        comparison7.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(3), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison7);


        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
        comparison8.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison8.setFirstOperand(operand119);
        
        // Operand 2
        comparison8.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison8);


        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadEstatuAfil3(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // FechaTerminada <> NULL
        // '<>' Comparison
        SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
        comparison6.setOperator("<>");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHATERMINADA, Constants.Type.DATE.getTypeName());
        comparison6.setFirstOperand(operand117);
        
        // Operand 2
        comparison6.setSecondOperand(new SQLWhereOperandNull());
        conjunction.addOperand(comparison6);


        // EstadoDocumentacion = 2
        // '=' Comparison
        SQLWhereComparison comparison7 = new SQLWhereComparison(sql);
        comparison7.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand118 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
        comparison7.setFirstOperand(operand118);
        
        // Operand 2
        comparison7.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison7);


        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
        comparison8.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison8.setFirstOperand(operand119);
        
        // Operand 2
        comparison8.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison8);


        sql.addConjunction(conjunction);
    }

    private void iFSolNovValidadorUsuarios(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfNumContrato = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMCONTRATO) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMCONTRATO, FilterVariableRequest.STRING) : null;
        String vfPlan = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPLAN) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPLAN, FilterVariableRequest.STRING) : null;
        String vfProducto = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPRODUCTO) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPRODUCTO, FilterVariableRequest.STRING) : null;
        String vfTipoIdent = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFTIPOIDENT) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFTIPOIDENT, FilterVariableRequest.STRING) : null;
        String vfNumIdent = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMIDENT) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMIDENT, FilterVariableRequest.STRING) : null;

        // Estado = 1
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison1);


        // EstadoDocumentacion = 1
        // '=' Comparison
        SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
        comparison2.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
        comparison2.setFirstOperand(operand113);
        
        // Operand 2
        comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison2);


        // NumContrato = vfNumContrato
        if (vfNumContrato != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMCONTRATO, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfNumContrato, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // PlanT.CodigoLegal = vfPlan
        if (vfPlan != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ATTR_NAME_PLANESCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfPlan, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // PlanT.ProductoT.CodigoLegal = vfProducto
        if (vfProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfProducto, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // (Novedad.AliasNovedad = "CC" OR (Novedad.AliasNovedad = "CF" AND COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent) > 0) OR (Novedad.AliasNovedad = "EU" AND COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent AND Familias.UsuarioNovedad.Excluido = true) > 0))
        if (vfTipoIdent != null && vfNumIdent != null) {
        {
            // 'or' Logical operator
            SQLWhereDisjunction comparison6 = new SQLWhereDisjunction();
        
            // Operand 1
                {
                    // 'or' Logical operator
                    SQLWhereDisjunction comparison7 = new SQLWhereDisjunction();
                
                    // Operand 1
                            // '=' Comparison
                            SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
                            comparison8.setOperator("=");
                            
                            // Operand 1
                            SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                            comparison8.setFirstOperand(operand119);
                            
                            // Operand 2
                            comparison8.setSecondOperand(new SQLWhereOperandLiteral("CC", Constants.Type.STRING.getTypeName()));
                            comparison7.addOperand(comparison8);
                
                    // Operand 2
                        {
                            // 'and' Logical operator
                            SQLWhereConjunction comparison10 = new SQLWhereConjunction();
                        
                            // Operand 1
                                    // '=' Comparison
                                    SQLWhereComparison comparison11 = new SQLWhereComparison(sql);
                                    comparison11.setOperator("=");
                                    
                                    // Operand 1
                                    SQLWhereOperandPathAttribute operand1112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                                    comparison11.setFirstOperand(operand1112);
                                    
                                    // Operand 2
                                    comparison11.setSecondOperand(new SQLWhereOperandLiteral("CF", Constants.Type.STRING.getTypeName()));
                                    comparison10.addOperand(comparison11);
                        
                            // Operand 2
                                    // '>' Comparison
                                    SQLWhereComparison comparison13 = new SQLWhereComparison(sql);
                                    comparison13.setOperator(">");
                                    
                                    // Operand 1
                                        // 'count' Association operator
                                        SQLWhereOperandSubQuery operandSubQueryAssocOperator016 = new SQLWhereOperandSubQuery(repository.assocOperator016Range1Query(vfTipoIdent, vfNumIdent, sql));
                                    comparison13.setFirstOperand(operandSubQueryAssocOperator016);
                                    
                                    // Operand 2
                                    comparison13.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                                    comparison10.addOperand(comparison13);
                            
                            comparison7.addOperand(comparison10);
                        }
                    
                    comparison6.addOperand(comparison7);
                }
        
            // Operand 2
                {
                    // 'and' Logical operator
                    SQLWhereConjunction comparison110 = new SQLWhereConjunction();
                
                    // Operand 1
                            // '=' Comparison
                            SQLWhereComparison comparison12 = new SQLWhereComparison(sql);
                            comparison12.setOperator("=");
                            
                            // Operand 1
                            SQLWhereOperandPathAttribute operand1113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                            comparison12.setFirstOperand(operand1113);
                            
                            // Operand 2
                            comparison12.setSecondOperand(new SQLWhereOperandLiteral("EU", Constants.Type.STRING.getTypeName()));
                            comparison110.addOperand(comparison12);
                
                    // Operand 2
                            // '>' Comparison
                            SQLWhereComparison comparison14 = new SQLWhereComparison(sql);
                            comparison14.setOperator(">");
                            
                            // Operand 1
                                // 'count' Association operator
                                SQLWhereOperandSubQuery operandSubQueryAssocOperator017 = new SQLWhereOperandSubQuery(repository.assocOperator017Range1Query(vfTipoIdent, vfNumIdent, sql));
                            comparison14.setFirstOperand(operandSubQueryAssocOperator017);
                            
                            // Operand 2
                            comparison14.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                            comparison110.addOperand(comparison14);
                    
                    comparison6.addOperand(comparison110);
                }
            
            conjunction.addOperand(comparison6);
        }

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoContrato for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato iIUSolNovTipoContrato(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContratante for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContratante
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContratante iIUSolNovContratante(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContratante(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovObservaciones for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovObservaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones iIUSolNovObservaciones(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoTitular for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoTitular
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular iIUSolNovTipoTitular(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoUsuario for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoUsuario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario iIUSolNovTipoUsuario(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContratante for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContratante
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContratante iIUSolNovContratanteSL(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContratante(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContraTipoTitular for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContraTipoTitular
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContraTipoTitular iIUSolNovContraTipoTitular(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContraTipoTitular(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoContrato for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato iIUSolNovTipoContratoOBS(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContratante for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContratante
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContratante iIUSolNovContratanteOBS(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovContratante(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovObservaciones for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovObservaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones iIUSolNovObservacionesOBS(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoTitular for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoTitular
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular iIUSolNovTipoTitularObs(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoUsuario for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoUsuario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario iIUSolNovTipoUsuarioObs(SolicitudNovedadOid oid) {
        return new com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUConsultaSolicitudNovedad
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolicitudNovedadCon that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadCon> piuPIUConsultaSolicitudNovedad(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadCon::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUConsultaSolicitudNovedad
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUConsultaSolicitudNovedad
     */
    public int getCount4PIUConsultaSolicitudNovedad(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUEstatusSolNov
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolNovEstatus that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovEstatus> piuPIUEstatusSolNov(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovEstatus::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEstatusSolNov
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEstatusSolNov
     */
    public int getCount4PIUEstatusSolNov(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUEstatusSolNovAfiliacion
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolNovEstatusAfiliacion that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAfiliacion> piuPIUEstatusSolNovAfiliacion(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAfiliacion::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEstatusSolNovAfiliacion
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEstatusSolNovAfiliacion
     */
    public int getCount4PIUEstatusSolNovAfiliacion(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUEstatusSolNovAsesor
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolNovEstatusAsesor that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAsesor> piuPIUEstatusSolNovAsesor(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAsesor::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEstatusSolNovAsesor
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEstatusSolNovAsesor
     */
    public int getCount4PIUEstatusSolNovAsesor(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUSolicitudNovedadNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolicitudNovedadNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadNull> piuPIUSolicitudNovedadNull(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUSolicitudNovedadNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUSolicitudNovedadNull
     */
    public int getCount4PIUSolicitudNovedadNull(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CrearRequest request) throws ModelException {
        request.setSolicitudNovedadcrearpagrPlanTInstance(planesSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrPlanT()));
        request.setSolicitudNovedadcrearpagrNovedadInstance(novedadSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrNovedad()));
        request.setSolicitudNovedadcrearpagrCausalInstance(causalSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrCausal()));
        request.setSolicitudNovedadcrearpagrProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrProteccionDatos()));
        request.setSolicitudNovedadcrearpagrTipoIdentContratanteInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrTipoIdentContratante()));
        request.setSolicitudNovedadcrearpagrEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrEstadoContrato()));
        request.setSolicitudNovedadcrearpagrGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrGrupoAsociado()));
        request.setSolicitudNovedadcrearpagrPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrPeriodicidad()));
        request.setSolicitudNovedadcrearpagrAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrAgente()));
        request.setSolicitudNovedadcrearpagrPeriodicidadNuevaInstance(periodicidadSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrPeriodicidadNueva()));
        request.setSolicitudNovedadcrearpagrMotivoExcepcionInstance(motivoExcepcionSolNovSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrMotivoExcepcion()));
        request.setSolicitudNovedadcrearpagrUsrAfiliacionInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrUsrAfiliacion()));
        request.setSolicitudNovedadcrearpagrFirmaInstance(firmaSrv.getByOIDWithHV(request.getSolicitudNovedadcrearpagrFirma()));
        return solicitudNovedadSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Planes solicitudNovedadcrearpagrPlanT = request.getSolicitudNovedadcrearpagrPlanTInstance();
        Novedad solicitudNovedadcrearpagrNovedad = request.getSolicitudNovedadcrearpagrNovedadInstance();
        Causal solicitudNovedadcrearpagrCausal = request.getSolicitudNovedadcrearpagrCausalInstance();
        ProteccionDatos solicitudNovedadcrearpagrProteccionDatos = request.getSolicitudNovedadcrearpagrProteccionDatosInstance();
        TipoIdentificacion solicitudNovedadcrearpagrTipoIdentContratante = request.getSolicitudNovedadcrearpagrTipoIdentContratanteInstance();
        EstadoContrato solicitudNovedadcrearpagrEstadoContrato = request.getSolicitudNovedadcrearpagrEstadoContratoInstance();
        GrupoAsociado solicitudNovedadcrearpagrGrupoAsociado = request.getSolicitudNovedadcrearpagrGrupoAsociadoInstance();
        Periodicidad solicitudNovedadcrearpagrPeriodicidad = request.getSolicitudNovedadcrearpagrPeriodicidadInstance();
        Funcionario solicitudNovedadcrearpagrAgente = request.getSolicitudNovedadcrearpagrAgenteInstance();
        Periodicidad solicitudNovedadcrearpagrPeriodicidadNueva = request.getSolicitudNovedadcrearpagrPeriodicidadNuevaInstance();
        MotivoExcepcionSolNov solicitudNovedadcrearpagrMotivoExcepcion = request.getSolicitudNovedadcrearpagrMotivoExcepcionInstance();
        Funcionario solicitudNovedadcrearpagrUsrAfiliacion = request.getSolicitudNovedadcrearpagrUsrAfiliacionInstance();
        Firma solicitudNovedadcrearpagrFirma = request.getSolicitudNovedadcrearpagrFirmaInstance();
        Date solicitudNovedadcrearpatrFechaVigencia = request.getSolicitudNovedadcrearpatrFechaVigencia();
        String solicitudNovedadcrearpatrNumContrato = request.getSolicitudNovedadcrearpatrNumContrato();
        Boolean solicitudNovedadcrearpatrExcepcion = request.getSolicitudNovedadcrearpatrExcepcion();
        Date solicitudNovedadcrearpatrFechaIniExcepcion = request.getSolicitudNovedadcrearpatrFechaIniExcepcion();
        Date solicitudNovedadcrearpatrFechaFinExcepcion = request.getSolicitudNovedadcrearpatrFechaFinExcepcion();

        request.checkArguments();
        SolicitudNovedad instance = new SolicitudNovedad();
        instance.add2PlanT(solicitudNovedadcrearpagrPlanT);

        instance.add2Novedad(solicitudNovedadcrearpagrNovedad);

        if (solicitudNovedadcrearpagrCausal != null && !solicitudNovedadcrearpagrCausal.isNull()) {
            instance.add2Causal(solicitudNovedadcrearpagrCausal);
        }

        if (solicitudNovedadcrearpagrProteccionDatos != null && !solicitudNovedadcrearpagrProteccionDatos.isNull()) {
            solicitudNovedadcrearpagrProteccionDatos.add2SolicitudNovedad(instance);
            instance.add2ProteccionDatos(solicitudNovedadcrearpagrProteccionDatos);
        }

        if (solicitudNovedadcrearpagrTipoIdentContratante != null && !solicitudNovedadcrearpagrTipoIdentContratante.isNull()) {
            instance.add2TipoIdentContratante(solicitudNovedadcrearpagrTipoIdentContratante);
        }

        if (solicitudNovedadcrearpagrEstadoContrato != null && !solicitudNovedadcrearpagrEstadoContrato.isNull()) {
            instance.add2EstadoContrato(solicitudNovedadcrearpagrEstadoContrato);
        }

        if (solicitudNovedadcrearpagrGrupoAsociado != null && !solicitudNovedadcrearpagrGrupoAsociado.isNull()) {
            instance.add2GrupoAsociado(solicitudNovedadcrearpagrGrupoAsociado);
        }

        if (solicitudNovedadcrearpagrPeriodicidad != null && !solicitudNovedadcrearpagrPeriodicidad.isNull()) {
            instance.add2Periodicidad(solicitudNovedadcrearpagrPeriodicidad);
        }

        instance.add2Agente(solicitudNovedadcrearpagrAgente);

        if (solicitudNovedadcrearpagrPeriodicidadNueva != null && !solicitudNovedadcrearpagrPeriodicidadNueva.isNull()) {
            instance.add2PeriodicidadNueva(solicitudNovedadcrearpagrPeriodicidadNueva);
        }

        if (solicitudNovedadcrearpagrMotivoExcepcion != null && !solicitudNovedadcrearpagrMotivoExcepcion.isNull()) {
            instance.add2MotivoExcepcion(solicitudNovedadcrearpagrMotivoExcepcion);
        }

        if (solicitudNovedadcrearpagrUsrAfiliacion != null && !solicitudNovedadcrearpagrUsrAfiliacion.isNull()) {
            instance.add2UsrAfiliacion(solicitudNovedadcrearpagrUsrAfiliacion);
        }

        if (solicitudNovedadcrearpagrFirma != null && !solicitudNovedadcrearpagrFirma.isNull()) {
            solicitudNovedadcrearpagrFirma.add2SolicitudNovedad(instance);
            instance.add2Firma(solicitudNovedadcrearpagrFirma);
        }

        instance.setSolicitudNovedadId(Long.valueOf(0));
        instance.setSolicitudNovedadNumRadicado(Long.valueOf(0));
        instance.setSolicitudNovedadFechaCreacion(STDFunctions.systemDateFun());
        instance.setSolicitudNovedadCtrEsColectivo(false);
        instance.setSolicitudNovedadEstado(Long.valueOf(1));
        instance.setSolicitudNovedadEstadoDocumentacion(Long.valueOf(1));
        instance.setSolicitudNovedadCompletada(Boolean.FALSE);
        instance.setSolicitudNovedadCtrActivo(Boolean.FALSE);
        instance.setSolicitudNovedadPrioridad(Long.valueOf(999));
        instance.setSolicitudNovedadFechaTerminada(null);
        instance.setSolicitudNovedadFechaFUG(null);
        instance.setSolicitudNovedadFechaFA(null);
        instance.setSolicitudNovedadFechaVigencia(solicitudNovedadcrearpatrFechaVigencia);
        instance.setSolicitudNovedadNumContrato(solicitudNovedadcrearpatrNumContrato);
        instance.setSolicitudNovedadExcepcion(solicitudNovedadcrearpatrExcepcion);
        instance.setSolicitudNovedadFechaIniExcepcion(solicitudNovedadcrearpatrFechaIniExcepcion);
        instance.setSolicitudNovedadFechaFinExcepcion(solicitudNovedadcrearpatrFechaFinExcepcion);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.EliminarRequest request) throws ModelException {
        request.setSolicitudNovedadeliminarpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadeliminarpthisSolicitudNovedad()));
        return solicitudNovedadSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadeliminarpthisSolicitudNovedad = request.getSolicitudNovedadeliminarpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadeliminarpthisSolicitudNovedad;
        if(solicitudNovedadeliminarpthisSolicitudNovedad.getFamilias().size() > 0) {
            throw new MinCardinalityException(SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ROLE_ALIAS_FAMILIAS);
        }
        if(solicitudNovedadeliminarpthisSolicitudNovedad.getDocumentos().size() > 0) {
            throw new MinCardinalityException(SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ROLE_ALIAS_DOCUMENTOS);
        }
        if(solicitudNovedadeliminarpthisSolicitudNovedad.getLogEstados().size() > 0) {
            throw new MinCardinalityException(SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ROLE_ALIAS_LOGESTADOS);
        }
        if(solicitudNovedadeliminarpthisSolicitudNovedad.getLogUsrSolNov().size() > 0) {
            throw new MinCardinalityException(SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ROLE_ALIAS_LOGUSRSOLNOV);
        }


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: setValoresDesdeContrato

    /*
     * Entry point for service setValoresDesdeContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse setValoresDesdeContrato(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.SetValoresDesdeContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.setValoresDesdeContratoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service setValoresDesdeContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse setValoresDesdeContratoTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.SetValoresDesdeContratoRequest request) throws ModelException {
        request.setSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad()));
        return solicitudNovedadSrv.setValoresDesdeContratoImplementation(request);
    }

    /*
     * Implements service setValoresDesdeContrato
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse setValoresDesdeContratoImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.SetValoresDesdeContratoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad = request.getSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance();
        String solicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa = request.getSolicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa();
        String solicitudNovedadsetValoresDesdeContratopCtrDescTarifa = request.getSolicitudNovedadsetValoresDesdeContratopCtrDescTarifa();
        String solicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio = request.getSolicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio();
        String solicitudNovedadsetValoresDesdeContratopCtrDescConvenio = request.getSolicitudNovedadsetValoresDesdeContratopCtrDescConvenio();
        String solicitudNovedadsetValoresDesdeContratopContraNumIden = request.getSolicitudNovedadsetValoresDesdeContratopContraNumIden();
        String solicitudNovedadsetValoresDesdeContratopContraPrimerNombre = request.getSolicitudNovedadsetValoresDesdeContratopContraPrimerNombre();
        Boolean solicitudNovedadsetValoresDesdeContratopCtrEsColectivo = request.getSolicitudNovedadsetValoresDesdeContratopCtrEsColectivo();
        String solicitudNovedadsetValoresDesdeContratopContraSegundoNombre = request.getSolicitudNovedadsetValoresDesdeContratopContraSegundoNombre();
        String solicitudNovedadsetValoresDesdeContratopContraPrimerApellido = request.getSolicitudNovedadsetValoresDesdeContratopContraPrimerApellido();
        String solicitudNovedadsetValoresDesdeContratopContraSegundoApellido = request.getSolicitudNovedadsetValoresDesdeContratopContraSegundoApellido();
        String solicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion = request.getSolicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion();
        Boolean solicitudNovedadsetValoresDesdeContratopCtrActivo = request.getSolicitudNovedadsetValoresDesdeContratopCtrActivo();
        String solicitudNovedadsetValoresDesdeContratopContraRazonSocial = request.getSolicitudNovedadsetValoresDesdeContratopContraRazonSocial();
        String solicitudNovedadsetValoresDesdeContratopContraTipoPersona = request.getSolicitudNovedadsetValoresDesdeContratopContraTipoPersona();
        Date solicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato = request.getSolicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato();
        Long solicitudNovedadsetValoresDesdeContratopCtrTipoContrato = request.getSolicitudNovedadsetValoresDesdeContratopCtrTipoContrato();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadsetValoresDesdeContratopthisSolicitudNovedad;
        instance.setSolicitudNovedadCtrCodigoTarifa(solicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa);
        instance.setSolicitudNovedadCtrDescTarifa(solicitudNovedadsetValoresDesdeContratopCtrDescTarifa);
        instance.setSolicitudNovedadCtrCodigoConvenio(solicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio);
        instance.setSolicitudNovedadCtrDescConvenio(solicitudNovedadsetValoresDesdeContratopCtrDescConvenio);
        instance.setSolicitudNovedadContraNumIden(solicitudNovedadsetValoresDesdeContratopContraNumIden);
        instance.setSolicitudNovedadContraPrimerNombre(solicitudNovedadsetValoresDesdeContratopContraPrimerNombre);
        instance.setSolicitudNovedadCtrEsColectivo(solicitudNovedadsetValoresDesdeContratopCtrEsColectivo);
        instance.setSolicitudNovedadContraSegundoNombre(solicitudNovedadsetValoresDesdeContratopContraSegundoNombre);
        instance.setSolicitudNovedadContraPrimerApellido(solicitudNovedadsetValoresDesdeContratopContraPrimerApellido);
        instance.setSolicitudNovedadContraSegundoApellido(solicitudNovedadsetValoresDesdeContratopContraSegundoApellido);
        instance.setSolicitudNovedadCtrTagCausaExclusion(solicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion);
        instance.setSolicitudNovedadCtrActivo(solicitudNovedadsetValoresDesdeContratopCtrActivo);
        instance.setSolicitudNovedadContraRazonSocial(solicitudNovedadsetValoresDesdeContratopContraRazonSocial);
        instance.setSolicitudNovedadContraTipoPersona(solicitudNovedadsetValoresDesdeContratopContraTipoPersona);
        instance.setSolicitudNovedadCtrFInicioContrato(solicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato);
        instance.setSolicitudNovedadCtrTipoContrato(solicitudNovedadsetValoresDesdeContratopCtrTipoContrato);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsTipoIdentContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insTipoIdentContratanteTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsTipoIdentContratanteRequest request) throws ModelException {
        request.setSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad()));
        request.setSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion()));
        return solicitudNovedadSrv.insTipoIdentContratanteImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsTipoIdentContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad = request.getSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance();
        TipoIdentificacion solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion = request.getSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad;

        instance.add2TipoIdentContratante(solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentContratanteRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentContratanteRequest();
            relatedRequest.setTipoIdentificacionInsTipoIdentContratantepthisTipoIdentificacionInstance(solicitudNovedadInsTipoIdentContratantepevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionInsTipoIdentContratantepevcSolicitudNovedadInstance(solicitudNovedadInsTipoIdentContratantepthisSolicitudNovedad);
            tipoIdentificacionSrv.insTipoIdentContratanteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelTipoIdentContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delTipoIdentContratanteTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelTipoIdentContratanteRequest request) throws ModelException {
        request.setSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad()));
        request.setSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion()));
        return solicitudNovedadSrv.delTipoIdentContratanteImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelTipoIdentContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad = request.getSolicitudNovedadDelTipoIdentContratantepthisSolicitudNovedadInstance();
        TipoIdentificacion solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion = request.getSolicitudNovedadDelTipoIdentContratantepevcTipoIdentificacionInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad;

        instance.add2TipoIdentContratante(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentContratanteRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentContratanteRequest();
            relatedRequest.setTipoIdentificacionDelTipoIdentContratantepthisTipoIdentificacionInstance(solicitudNovedadDelTipoIdentContratantepevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionDelTipoIdentContratantepevcSolicitudNovedadInstance(solicitudNovedadDelTipoIdentContratantepthisSolicitudNovedad);
            tipoIdentificacionSrv.delTipoIdentContratanteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsEstadoContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insEstadoContratoTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsEstadoContratoRequest request) throws ModelException {
        request.setSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsEstadoContratopthisSolicitudNovedad()));
        request.setSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getSolicitudNovedadInsEstadoContratopevcEstadoContrato()));
        return solicitudNovedadSrv.insEstadoContratoImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsEstadoContratoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsEstadoContratopthisSolicitudNovedad = request.getSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance();
        EstadoContrato solicitudNovedadInsEstadoContratopevcEstadoContrato = request.getSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsEstadoContratopthisSolicitudNovedad;

        instance.add2EstadoContrato(solicitudNovedadInsEstadoContratopevcEstadoContrato);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.InsEstadoContratoRequest relatedRequest = new com.keralty.aenovedades.viewmodel.estadocontrato.siu.InsEstadoContratoRequest();
            relatedRequest.setEstadoContratoInsEstadoContratopthisEstadoContratoInstance(solicitudNovedadInsEstadoContratopevcEstadoContrato);
            relatedRequest.setEstadoContratoInsEstadoContratopevcSolicitudNovedadInstance(solicitudNovedadInsEstadoContratopthisSolicitudNovedad);
            estadoContratoSrv.insEstadoContratoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelEstadoContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delEstadoContratoTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelEstadoContratoRequest request) throws ModelException {
        request.setSolicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelEstadoContratopthisSolicitudNovedad()));
        request.setSolicitudNovedadDelEstadoContratopevcEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getSolicitudNovedadDelEstadoContratopevcEstadoContrato()));
        return solicitudNovedadSrv.delEstadoContratoImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelEstadoContratoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelEstadoContratopthisSolicitudNovedad = request.getSolicitudNovedadDelEstadoContratopthisSolicitudNovedadInstance();
        EstadoContrato solicitudNovedadDelEstadoContratopevcEstadoContrato = request.getSolicitudNovedadDelEstadoContratopevcEstadoContratoInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelEstadoContratopthisSolicitudNovedad;

        instance.add2EstadoContrato(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.estadocontrato.siu.DelEstadoContratoRequest relatedRequest = new com.keralty.aenovedades.viewmodel.estadocontrato.siu.DelEstadoContratoRequest();
            relatedRequest.setEstadoContratoDelEstadoContratopthisEstadoContratoInstance(solicitudNovedadDelEstadoContratopevcEstadoContrato);
            relatedRequest.setEstadoContratoDelEstadoContratopevcSolicitudNovedadInstance(solicitudNovedadDelEstadoContratopthisSolicitudNovedad);
            estadoContratoSrv.delEstadoContratoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: InsGrupoAsociado

    /*
     * Entry point for service InsGrupoAsociado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insGrupoAsociado(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsGrupoAsociadoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insGrupoAsociadoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsGrupoAsociado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insGrupoAsociadoTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsGrupoAsociadoRequest request) throws ModelException {
        request.setSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedad()));
        request.setSolicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getSolicitudNovedadInsGrupoAsociadopevcGrupoAsociado()));
        return solicitudNovedadSrv.insGrupoAsociadoImplementation(request, true);
    }

    /*
     * Implements service InsGrupoAsociado
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insGrupoAsociadoImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsGrupoAsociadoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad = request.getSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance();
        GrupoAsociado solicitudNovedadInsGrupoAsociadopevcGrupoAsociado = request.getSolicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad;

        instance.add2GrupoAsociado(solicitudNovedadInsGrupoAsociadopevcGrupoAsociado);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.grupoasociado.siu.InsGrupoAsociadoRequest relatedRequest = new com.keralty.aenovedades.viewmodel.grupoasociado.siu.InsGrupoAsociadoRequest();
            relatedRequest.setGrupoAsociadoInsGrupoAsociadopthisGrupoAsociadoInstance(solicitudNovedadInsGrupoAsociadopevcGrupoAsociado);
            relatedRequest.setGrupoAsociadoInsGrupoAsociadopevcSolicitudNovedadInstance(solicitudNovedadInsGrupoAsociadopthisSolicitudNovedad);
            grupoAsociadoSrv.insGrupoAsociadoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: DelGrupoAsociado

    /*
     * Entry point for service DelGrupoAsociado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delGrupoAsociado(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelGrupoAsociadoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delGrupoAsociadoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelGrupoAsociado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delGrupoAsociadoTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelGrupoAsociadoRequest request) throws ModelException {
        request.setSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedad()));
        request.setSolicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getSolicitudNovedadDelGrupoAsociadopevcGrupoAsociado()));
        return solicitudNovedadSrv.delGrupoAsociadoImplementation(request, true);
    }

    /*
     * Implements service DelGrupoAsociado
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delGrupoAsociadoImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelGrupoAsociadoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad = request.getSolicitudNovedadDelGrupoAsociadopthisSolicitudNovedadInstance();
        GrupoAsociado solicitudNovedadDelGrupoAsociadopevcGrupoAsociado = request.getSolicitudNovedadDelGrupoAsociadopevcGrupoAsociadoInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad;

        instance.add2GrupoAsociado(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.grupoasociado.siu.DelGrupoAsociadoRequest relatedRequest = new com.keralty.aenovedades.viewmodel.grupoasociado.siu.DelGrupoAsociadoRequest();
            relatedRequest.setGrupoAsociadoDelGrupoAsociadopthisGrupoAsociadoInstance(solicitudNovedadDelGrupoAsociadopevcGrupoAsociado);
            relatedRequest.setGrupoAsociadoDelGrupoAsociadopevcSolicitudNovedadInstance(solicitudNovedadDelGrupoAsociadopthisSolicitudNovedad);
            grupoAsociadoSrv.delGrupoAsociadoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: validarContratoActivo

    /*
     * Entry point for service validarContratoActivo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarContratoActivo(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarContratoActivoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.validarContratoActivoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarContratoActivo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarContratoActivoTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarContratoActivoRequest request) throws ModelException {
        request.setSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadvalidarContratoActivopthisSolicitudNovedad()));
        return solicitudNovedadSrv.validarContratoActivoImplementation(request);
    }

    /*
     * Implements service validarContratoActivo
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarContratoActivoImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarContratoActivoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadvalidarContratoActivopthisSolicitudNovedad = request.getSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance();

        request.checkArguments();

        validarContratoActivoPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadvalidarContratoActivopthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    private void validarContratoActivoPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarContratoActivoRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre1(request);
    }

    private void checkClas1581421428736234Pre1 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarContratoActivoRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = FALSE)
        // OR CtrActivo = TRUE

        SolicitudNovedad solicitudNovedadvalidarContratoActivopthisSolicitudNovedad = request.getSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || solicitudNovedadvalidarContratoActivopthisSolicitudNovedad.getSolicitudNovedadCtrActivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Es necesario que el contrato se encuentre activo");
    }

    // Service: marcarCompletada

    /*
     * Entry point for service marcarCompletada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse marcarCompletada(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.MarcarCompletadaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.marcarCompletadaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service marcarCompletada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse marcarCompletadaTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.MarcarCompletadaRequest request) throws ModelException {
        request.setSolicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadmarcarCompletadapthisSolicitudNovedad()));
        return solicitudNovedadSrv.marcarCompletadaImplementation(request);
    }

    /*
     * Implements service marcarCompletada
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse marcarCompletadaImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.MarcarCompletadaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadmarcarCompletadapthisSolicitudNovedad = request.getSolicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadmarcarCompletadapthisSolicitudNovedad;
        if (solicitudNovedadmarcarCompletadapthisSolicitudNovedad.getSolicitudNovedadFechaCompletada() == null) {
            instance.setSolicitudNovedadFechaCompletada(STDFunctions.systemDateTimeFun());
        }
        instance.setSolicitudNovedadCompletada(Boolean.TRUE);
        if (solicitudNovedadmarcarCompletadapthisSolicitudNovedad.getSolicitudNovedadFechaCompletada() == null) {
            instance.setSolicitudNovedadFechaFA(STDFunctions.systemDateTimeFun());
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: validarSC

    /*
     * Entry point for service validarSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarSC(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.validarSCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarSCTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest request) throws ModelException {
        request.setSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadvalidarSCpthisSolicitudNovedad()));
        return solicitudNovedadSrv.validarSCImplementation(request);
    }

    /*
     * Implements service validarSC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarSCImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadvalidarSCpthisSolicitudNovedad = request.getSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance();

        request.checkArguments();

        validarSCPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadvalidarSCpthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    private void validarSCPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre37(request);
        checkClas1581421428736234Pre4(request);
    }

    private void checkClas1581421428736234Pre37 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest request) 
            throws ModelException {
        // Novedad.AliasNovedad <> "SC" OR SCNumMeses <> NULL

        SolicitudNovedad solicitudNovedadvalidarSCpthisSolicitudNovedad = request.getSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance();
        boolean preconditionHolds = !(solicitudNovedadvalidarSCpthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("SC") || solicitudNovedadvalidarSCpthisSolicitudNovedad.getSolicitudNovedadSCNumMeses() != null;
        if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo SC es necesario indicar el número de meses. Complete la información de la solicitud de novedad antes de marcarla como completada");
    }

    private void checkClas1581421428736234Pre4 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest request) 
            throws ModelException {
        // SCNumMeses >= Novedad.MinValorMeses AND SCNumMeses <= Novedad.MaxValorMeses

        SolicitudNovedad solicitudNovedadvalidarSCpthisSolicitudNovedad = request.getSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance();
        boolean preconditionHolds = solicitudNovedadvalidarSCpthisSolicitudNovedad.getSolicitudNovedadSCNumMeses() >= solicitudNovedadvalidarSCpthisSolicitudNovedad.getNovedad().getNovedadMinValorMeses() && solicitudNovedadvalidarSCpthisSolicitudNovedad.getSolicitudNovedadSCNumMeses() <= solicitudNovedadvalidarSCpthisSolicitudNovedad.getNovedad().getNovedadMaxValorMeses();
        if (!preconditionHolds) throw new PreconditionException("El número de meses ha de estar entre " + STDFunctions.intToStrFun(solicitudNovedadvalidarSCpthisSolicitudNovedad.getNovedad().getNovedadMinValorMeses()) + " y " + STDFunctions.intToStrFun(solicitudNovedadvalidarSCpthisSolicitudNovedad.getNovedad().getNovedadMaxValorMeses()));
    }

    // Service: modificarNumMeses

    /*
     * Entry point for service modificarNumMeses
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarNumMeses(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.modificarNumMesesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarNumMeses
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarNumMesesTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest request) throws ModelException {
        request.setSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadmodificarNumMesespthisSolicitudNovedad()));
        return solicitudNovedadSrv.modificarNumMesesImplementation(request);
    }

    /*
     * Implements service modificarNumMeses
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarNumMesesImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadmodificarNumMesespthisSolicitudNovedad = request.getSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance();
        Long solicitudNovedadmodificarNumMesespSCNumMeses = request.getSolicitudNovedadmodificarNumMesespSCNumMeses();

        request.checkArguments();

        modificarNumMesesPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadmodificarNumMesespthisSolicitudNovedad;
        instance.setSolicitudNovedadSCNumMeses(solicitudNovedadmodificarNumMesespSCNumMeses);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service modificarNumMeses preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse modificarNumMesesCheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadmodificarNumMesespthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_43".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre43(request);
            if("Clas_1581421428736234Pre_49".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre49(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void modificarNumMesesPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre43(request);
        checkClas1581421428736234Pre49(request);
    }

    private void checkClas1581421428736234Pre43 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest request) 
            throws ModelException {
        // Novedad.AliasNovedad = "SC" 

        SolicitudNovedad solicitudNovedadmodificarNumMesespthisSolicitudNovedad = request.getSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance();
        boolean preconditionHolds = (solicitudNovedadmodificarNumMesespthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("SC");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de tipo suspensión de contrato");
    }

    private void checkClas1581421428736234Pre49 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNumMesesRequest request) 
            throws ModelException {
        // pSCNumMeses >= Novedad.MinValorMeses AND pSCNumMeses <= Novedad.MaxValorMeses

        Long solicitudNovedadmodificarNumMesespSCNumMeses = request.getSolicitudNovedadmodificarNumMesespSCNumMeses();
        SolicitudNovedad solicitudNovedadmodificarNumMesespthisSolicitudNovedad = request.getSolicitudNovedadmodificarNumMesespthisSolicitudNovedadInstance();
        boolean preconditionHolds = solicitudNovedadmodificarNumMesespSCNumMeses >= solicitudNovedadmodificarNumMesespthisSolicitudNovedad.getNovedad().getNovedadMinValorMeses() && solicitudNovedadmodificarNumMesespSCNumMeses <= solicitudNovedadmodificarNumMesespthisSolicitudNovedad.getNovedad().getNovedadMaxValorMeses();
        if (!preconditionHolds) throw new PreconditionException("El número de meses ha de estar entre " + STDFunctions.intToStrFun(solicitudNovedadmodificarNumMesespthisSolicitudNovedad.getNovedad().getNovedadMinValorMeses()) + " y " + STDFunctions.intToStrFun(solicitudNovedadmodificarNumMesespthisSolicitudNovedad.getNovedad().getNovedadMaxValorMeses()));
    }

    // Service: validarPSContrato

    /*
     * Entry point for service validarPSContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarPSContrato(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.validarPSContratoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarPSContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarPSContratoTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest request) throws ModelException {
        request.setSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadvalidarPSContratopthisSolicitudNovedad()));
        return solicitudNovedadSrv.validarPSContratoImplementation(request);
    }

    /*
     * Implements service validarPSContrato
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarPSContratoImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadvalidarPSContratopthisSolicitudNovedad = request.getSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance();

        request.checkArguments();

        validarPSContratoPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadvalidarPSContratopthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    private void validarPSContratoPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre38(request);
        checkClas1581421428736234Pre55();
        checkClas1581421428736234Pre6(request);
    }

    private void checkClas1581421428736234Pre38 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = false) OR DrvValidarPS1 = true

        SolicitudNovedad solicitudNovedadvalidarPSContratopthisSolicitudNovedad = request.getSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || solicitudNovedadvalidarPSContratopthisSolicitudNovedad.getSolicitudNovedadDrvValidarPS1().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo PS es necesario que el contrato se encuentre cancelado.");
    }

    private void checkClas1581421428736234Pre55 () throws ModelException {
        // fugetValorParametroConf( "SOLNOVSUSVIAJE" ) <> NULL

        boolean preconditionHolds = userFunctionsSrv.fugetValorParametroConfFun("SOLNOVSUSVIAJE") != null;
        if (!preconditionHolds) throw new PreconditionException("No se ha encontrado en los parámetros de configuración el Alias de la Novedad 'Suspensión por viaje'. Parametro: SOLNOVSUSVIAJE ");
    }

    private void checkClas1581421428736234Pre6 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = false) OR DrvValidarPS2 = true

        SolicitudNovedad solicitudNovedadvalidarPSContratopthisSolicitudNovedad = request.getSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || solicitudNovedadvalidarPSContratopthisSolicitudNovedad.getSolicitudNovedadDrvValidarPS2().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El contrato debe estar cancelado. Verifique el tag 'CausaExclusion' de la carátula del contrato");
    }

    // Service: validarPP

    /*
     * Entry point for service validarPP
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarPP(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPPRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.validarPPTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarPP
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarPPTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPPRequest request) throws ModelException {
        request.setSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadvalidarPPpthisSolicitudNovedad()));
        return solicitudNovedadSrv.validarPPImplementation(request);
    }

    /*
     * Implements service validarPP
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarPPImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPPRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadvalidarPPpthisSolicitudNovedad = request.getSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance();

        request.checkArguments();

        validarPPPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadvalidarPPpthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    private void validarPPPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPPRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre8(request);
    }

    private void checkClas1581421428736234Pre8 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPPRequest request) 
            throws ModelException {
        // EXIST( PeriodicidadNueva ) = true

        SolicitudNovedad solicitudNovedadvalidarPPpthisSolicitudNovedad = request.getSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = repository.assocOperator018(solicitudNovedadvalidarPPpthisSolicitudNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("La solicitud de novedad de periodicidad de pago requiere sea indicada la nueva periodicidad");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: validarAS

    /*
     * Entry point for service validarAS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarAS(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarASRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.validarASTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarAS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarASTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarASRequest request) throws ModelException {
        request.setSolicitudNovedadvalidarASpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadvalidarASpthisSolicitudNovedad()));
        return solicitudNovedadSrv.validarASImplementation(request);
    }

    /*
     * Implements service validarAS
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarASImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarASRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadvalidarASpthisSolicitudNovedad = request.getSolicitudNovedadvalidarASpthisSolicitudNovedadInstance();

        request.checkArguments();

        validarASPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadvalidarASpthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    private void validarASPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarASRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre9(request);
    }

    private void checkClas1581421428736234Pre9 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarASRequest request) 
            throws ModelException {
        // 
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = FALSE)
        // OR  EXIST(Novedad.CausasExclusion) 
        // WHERE  ( 
        // Novedad.CausasExclusion.Descripcion = CtrTagCausaExclusion)  = TRUE

        SolicitudNovedad solicitudNovedadvalidarASpthisSolicitudNovedad = request.getSolicitudNovedadvalidarASpthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || repository.assocOperator019(solicitudNovedadvalidarASpthisSolicitudNovedad).equals(true);
            if (!preconditionHolds) throw new PreconditionException("El contrato debe estar suspendido. Verifique el tag 'CausaExclusion' de la carátula del contrato");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: modificarNuevoNombre

    /*
     * Entry point for service modificarNuevoNombre
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarNuevoNombre(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.modificarNuevoNombreTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarNuevoNombre
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarNuevoNombreTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest request) throws ModelException {
        request.setSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad()));
        return solicitudNovedadSrv.modificarNuevoNombreImplementation(request);
    }

    /*
     * Implements service modificarNuevoNombre
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarNuevoNombreImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad = request.getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance();
        String solicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial = request.getSolicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial();

        request.checkArguments();

        modificarNuevoNombrePreconditions(request);
        SolicitudNovedad instance = solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad;
        instance.setSolicitudNovedadContraNuevaRazonSocial(solicitudNovedadmodificarNuevoNombrepContraNuevaRazonSocial);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service modificarNuevoNombre preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse modificarNuevoNombreCheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_45".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre45(request);
            if("Clas_1581421428736234Pre_48".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre48(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void modificarNuevoNombrePreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre45(request);
        checkClas1581421428736234Pre48(request);
    }

    private void checkClas1581421428736234Pre45 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest request) 
            throws ModelException {
        // Novedad.AliasNovedad = "CR"

        SolicitudNovedad solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad = request.getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance();
        boolean preconditionHolds = (solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("CR");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de tipo cambio de razón social");
    }

    private void checkClas1581421428736234Pre48 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ModificarNuevoNombreRequest request) 
            throws ModelException {
        // TipoIdentContratante.NIT = true

        SolicitudNovedad solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad = request.getSolicitudNovedadmodificarNuevoNombrepthisSolicitudNovedadInstance();
        boolean preconditionHolds = solicitudNovedadmodificarNuevoNombrepthisSolicitudNovedad.getTipoIdentContratante().getTipoIdentificacionNIT().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Novedad CR tan solo aplica si el tipo de identificación del contratante es Nit");
    }

    // Service: validarCR

    /*
     * Entry point for service validarCR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse validarCR(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarCRRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.validarCRTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validarCR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse validarCRTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarCRRequest request) throws ModelException {
        request.setSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadvalidarCRpthisSolicitudNovedad()));
        return solicitudNovedadSrv.validarCRImplementation(request);
    }

    /*
     * Implements service validarCR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse validarCRImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarCRRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadvalidarCRpthisSolicitudNovedad = request.getSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance();

        request.checkArguments();

        validarCRPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadvalidarCRpthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    private void validarCRPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarCRRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre39(request);
    }

    private void checkClas1581421428736234Pre39 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarCRRequest request) 
            throws ModelException {
        // Novedad.AliasNovedad <> "CR" OR ContraNuevaRazonSocial <> NULL

        SolicitudNovedad solicitudNovedadvalidarCRpthisSolicitudNovedad = request.getSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance();
        boolean preconditionHolds = !(solicitudNovedadvalidarCRpthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("CR") || solicitudNovedadvalidarCRpthisSolicitudNovedad.getSolicitudNovedadContraNuevaRazonSocial() != null;
        if (!preconditionHolds) throw new PreconditionException("Para novedades de tipo CR es necesario indicar el nuevo nombre del contratante");
    }

    // Service: registrarObservaciones

    /*
     * Entry point for service registrarObservaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse registrarObservaciones(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.RegistrarObservacionesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.registrarObservacionesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service registrarObservaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse registrarObservacionesTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.RegistrarObservacionesRequest request) throws ModelException {
        request.setSolicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadregistrarObservacionespthisSolicitudNovedad()));
        return solicitudNovedadSrv.registrarObservacionesImplementation(request);
    }

    /*
     * Implements service registrarObservaciones
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse registrarObservacionesImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.RegistrarObservacionesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadregistrarObservacionespthisSolicitudNovedad = request.getSolicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance();
        String solicitudNovedadregistrarObservacionespObservaciones = request.getSolicitudNovedadregistrarObservacionespObservaciones();

        request.checkArguments();

        registrarObservacionesPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadregistrarObservacionespthisSolicitudNovedad;
        instance.setSolicitudNovedadObservacions(STDFunctions.textToStrFun(solicitudNovedadregistrarObservacionespObservaciones));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service registrarObservaciones preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse registrarObservacionesCheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.RegistrarObservacionesRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setSolicitudNovedadregistrarObservacionespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadregistrarObservacionespthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_52".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre52(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void registrarObservacionesPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.RegistrarObservacionesRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre52(request);
    }

    private void checkClas1581421428736234Pre52 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.RegistrarObservacionesRequest request) 
            throws ModelException {
        // pObservaciones = NULL OR length(TextToStr(pObservaciones)) < 900

        String solicitudNovedadregistrarObservacionespObservaciones = request.getSolicitudNovedadregistrarObservacionespObservaciones();
        boolean preconditionHolds = solicitudNovedadregistrarObservacionespObservaciones == null || STDFunctions.lengthFun(STDFunctions.textToStrFun(solicitudNovedadregistrarObservacionespObservaciones)) < Long.valueOf(900);
        if (!preconditionHolds) throw new PreconditionException("Las observaciones no pueden superar los 900 caracteres");
    }

    // Service: InsPeriodicidadNueva

    /*
     * Entry point for service InsPeriodicidadNueva
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPeriodicidadNueva(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadNuevaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insPeriodicidadNuevaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPeriodicidadNueva
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPeriodicidadNuevaTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadNuevaRequest request) throws ModelException {
        request.setSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad()));
        request.setSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidad()));
        return solicitudNovedadSrv.insPeriodicidadNuevaImplementation(request, true);
    }

    /*
     * Implements service InsPeriodicidadNueva
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPeriodicidadNuevaImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadNuevaRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad = request.getSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance();
        Periodicidad solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad = request.getSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad;

        instance.add2PeriodicidadNueva(solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.periodicidad.siu.InsPeriodicidadNuevaRequest relatedRequest = new com.keralty.aenovedades.viewmodel.periodicidad.siu.InsPeriodicidadNuevaRequest();
            relatedRequest.setPeriodicidadInsPeriodicidadNuevapthisPeriodicidadInstance(solicitudNovedadInsPeriodicidadNuevapevcPeriodicidad);
            relatedRequest.setPeriodicidadInsPeriodicidadNuevapevcSolicitudNovedadInstance(solicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedad);
            periodicidadSrv.insPeriodicidadNuevaImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: DelPeriodicidadNueva

    /*
     * Entry point for service DelPeriodicidadNueva
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPeriodicidadNueva(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadNuevaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delPeriodicidadNuevaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPeriodicidadNueva
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPeriodicidadNuevaTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadNuevaRequest request) throws ModelException {
        request.setSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad()));
        request.setSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidad()));
        return solicitudNovedadSrv.delPeriodicidadNuevaImplementation(request, true);
    }

    /*
     * Implements service DelPeriodicidadNueva
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPeriodicidadNuevaImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadNuevaRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad = request.getSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance();
        Periodicidad solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad = request.getSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad;

        instance.add2PeriodicidadNueva(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.periodicidad.siu.DelPeriodicidadNuevaRequest relatedRequest = new com.keralty.aenovedades.viewmodel.periodicidad.siu.DelPeriodicidadNuevaRequest();
            relatedRequest.setPeriodicidadDelPeriodicidadNuevapthisPeriodicidadInstance(solicitudNovedadDelPeriodicidadNuevapevcPeriodicidad);
            relatedRequest.setPeriodicidadDelPeriodicidadNuevapevcSolicitudNovedadInstance(solicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedad);
            periodicidadSrv.delPeriodicidadNuevaImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.cambiarEstadoTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoRequest request) throws ModelException {
        request.setSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadcambiarEstadopthisSolicitudNovedad()));
        return solicitudNovedadSrv.cambiarEstadoImplementation(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadcambiarEstadopthisSolicitudNovedad = request.getSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance();
        Long solicitudNovedadcambiarEstadopeEstado = request.getSolicitudNovedadcambiarEstadopeEstado();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadcambiarEstadopthisSolicitudNovedad;
        instance.setSolicitudNovedadEstado(solicitudNovedadcambiarEstadopeEstado);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: cambiarEstadoDoc

    /*
     * Entry point for service cambiarEstadoDoc
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarEstadoDoc(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.cambiarEstadoDocTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarEstadoDoc
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarEstadoDocTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest request) throws ModelException {
        request.setSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedad()));
        return solicitudNovedadSrv.cambiarEstadoDocImplementation(request);
    }

    /*
     * Implements service cambiarEstadoDoc
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarEstadoDocImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad = request.getSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance();
        Long solicitudNovedadcambiarEstadoDocpeEstadoDoc = request.getSolicitudNovedadcambiarEstadoDocpeEstadoDoc();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadcambiarEstadoDocpthisSolicitudNovedad;
        instance.setSolicitudNovedadEstadoDocumentacion(solicitudNovedadcambiarEstadoDocpeEstadoDoc);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: cambiarFechaUltDoc

    /*
     * Entry point for service cambiarFechaUltDoc
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarFechaUltDoc(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarFechaUltDocRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.cambiarFechaUltDocTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarFechaUltDoc
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarFechaUltDocTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarFechaUltDocRequest request) throws ModelException {
        request.setSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad()));
        return solicitudNovedadSrv.cambiarFechaUltDocImplementation(request);
    }

    /*
     * Implements service cambiarFechaUltDoc
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarFechaUltDocImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarFechaUltDocRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad = request.getSolicitudNovedadcambiarFechaUltDocpthisSolicitudNovedadInstance();
        Timestamp solicitudNovedadcambiarFechaUltDocpeFechaHora = request.getSolicitudNovedadcambiarFechaUltDocpeFechaHora();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadcambiarFechaUltDocpthisSolicitudNovedad;
        instance.setSolicitudNovedadFechaUltimoDoc(solicitudNovedadcambiarFechaUltDocpeFechaHora);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: InsPeriodicidadSolNov

    /*
     * Entry point for service InsPeriodicidadSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPeriodicidadSolNov(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadSolNovRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insPeriodicidadSolNovTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPeriodicidadSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPeriodicidadSolNovTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadSolNovRequest request) throws ModelException {
        request.setSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad()));
        request.setSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad()));
        return solicitudNovedadSrv.insPeriodicidadSolNovImplementation(request, true);
    }

    /*
     * Implements service InsPeriodicidadSolNov
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPeriodicidadSolNovImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadSolNovRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad = request.getSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance();
        Periodicidad solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad = request.getSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad;

        instance.add2Periodicidad(solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.periodicidad.siu.InsPeriodicidadSolNovRequest relatedRequest = new com.keralty.aenovedades.viewmodel.periodicidad.siu.InsPeriodicidadSolNovRequest();
            relatedRequest.setPeriodicidadInsPeriodicidadSolNovpthisPeriodicidadInstance(solicitudNovedadInsPeriodicidadSolNovpevcPeriodicidad);
            relatedRequest.setPeriodicidadInsPeriodicidadSolNovpevcSolicitudNovedadInstance(solicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedad);
            periodicidadSrv.insPeriodicidadSolNovImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: DelPeriodicidadSolNov

    /*
     * Entry point for service DelPeriodicidadSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPeriodicidadSolNov(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadSolNovRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delPeriodicidadSolNovTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPeriodicidadSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPeriodicidadSolNovTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadSolNovRequest request) throws ModelException {
        request.setSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad()));
        request.setSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad()));
        return solicitudNovedadSrv.delPeriodicidadSolNovImplementation(request, true);
    }

    /*
     * Implements service DelPeriodicidadSolNov
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPeriodicidadSolNovImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadSolNovRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad = request.getSolicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedadInstance();
        Periodicidad solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad = request.getSolicitudNovedadDelPeriodicidadSolNovpevcPeriodicidadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad;

        instance.add2Periodicidad(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.periodicidad.siu.DelPeriodicidadSolNovRequest relatedRequest = new com.keralty.aenovedades.viewmodel.periodicidad.siu.DelPeriodicidadSolNovRequest();
            relatedRequest.setPeriodicidadDelPeriodicidadSolNovpthisPeriodicidadInstance(solicitudNovedadDelPeriodicidadSolNovpevcPeriodicidad);
            relatedRequest.setPeriodicidadDelPeriodicidadSolNovpevcSolicitudNovedadInstance(solicitudNovedadDelPeriodicidadSolNovpthisSolicitudNovedad);
            periodicidadSrv.delPeriodicidadSolNovImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: dummyNavegarAModificar

    /*
     * Entry point for service dummyNavegarAModificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse dummyNavegarAModificar(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.dummyNavegarAModificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service dummyNavegarAModificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse dummyNavegarAModificarTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAModificarRequest request) throws ModelException {
        request.setSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad()));
        return solicitudNovedadSrv.dummyNavegarAModificarImplementation(request);
    }

    /*
     * Implements service dummyNavegarAModificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse dummyNavegarAModificarImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad = request.getSolicitudNovedaddummyNavegarAModificarpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedaddummyNavegarAModificarpthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: dummyVerPDF

    /*
     * Entry point for service dummyVerPDF
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse dummyVerPDF(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyVerPDFRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.dummyVerPDFTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service dummyVerPDF
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse dummyVerPDFTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyVerPDFRequest request) throws ModelException {
        request.setSolicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedaddummyVerPDFpthisSolicitudNovedad()));
        return solicitudNovedadSrv.dummyVerPDFImplementation(request);
    }

    /*
     * Implements service dummyVerPDF
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse dummyVerPDFImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyVerPDFRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedaddummyVerPDFpthisSolicitudNovedad = request.getSolicitudNovedaddummyVerPDFpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedaddummyVerPDFpthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: addTextoObservaciones

    /*
     * Entry point for service addTextoObservaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse addTextoObservaciones(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AddTextoObservacionesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.addTextoObservacionesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service addTextoObservaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse addTextoObservacionesTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AddTextoObservacionesRequest request) throws ModelException {
        request.setSolicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadaddTextoObservacionespthisSolicitudNovedad()));
        return solicitudNovedadSrv.addTextoObservacionesImplementation(request);
    }

    /*
     * Implements service addTextoObservaciones
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse addTextoObservacionesImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AddTextoObservacionesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadaddTextoObservacionespthisSolicitudNovedad = request.getSolicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance();
        String solicitudNovedadaddTextoObservacionesptTexto = request.getSolicitudNovedadaddTextoObservacionesptTexto();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadaddTextoObservacionespthisSolicitudNovedad;
        if (solicitudNovedadaddTextoObservacionesptTexto != null && solicitudNovedadaddTextoObservacionespthisSolicitudNovedad.getSolicitudNovedadObservacions() != null) {
            instance.setSolicitudNovedadObservacions(STDFunctions.leftSubstringFun(solicitudNovedadaddTextoObservacionespthisSolicitudNovedad.getSolicitudNovedadObservacions() + solicitudNovedadaddTextoObservacionesptTexto, Long.valueOf(900)));
        } else if (solicitudNovedadaddTextoObservacionesptTexto != null) {
            instance.setSolicitudNovedadObservacions(STDFunctions.leftSubstringFun(solicitudNovedadaddTextoObservacionesptTexto, Long.valueOf(900)));
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: InsSolNovUsrAfiliacion

    /*
     * Entry point for service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insSolNovUsrAfiliacion(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insSolNovUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insSolNovUsrAfiliacionTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest request) throws ModelException {
        request.setSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad()));
        request.setSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario()));
        return solicitudNovedadSrv.insSolNovUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insSolNovUsrAfiliacionImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad = request.getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance();
        Funcionario solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario = request.getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad;

        instance.add2UsrAfiliacion(solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.funcionario.siu.InsSolNovUsrAfiliacionRequest relatedRequest = new com.keralty.aenovedades.viewmodel.funcionario.siu.InsSolNovUsrAfiliacionRequest();
            relatedRequest.setFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance(solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario);
            relatedRequest.setFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance(solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad);
            funcionarioSrv.insSolNovUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: DelSolNovUsrAfiliacion

    /*
     * Entry point for service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delSolNovUsrAfiliacion(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delSolNovUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delSolNovUsrAfiliacionTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest request) throws ModelException {
        request.setSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad()));
        request.setSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario()));
        return solicitudNovedadSrv.delSolNovUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delSolNovUsrAfiliacionImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad = request.getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance();
        Funcionario solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario = request.getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad;

        instance.add2UsrAfiliacion(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.funcionario.siu.DelSolNovUsrAfiliacionRequest relatedRequest = new com.keralty.aenovedades.viewmodel.funcionario.siu.DelSolNovUsrAfiliacionRequest();
            relatedRequest.setFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance(solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario);
            relatedRequest.setFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance(solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad);
            funcionarioSrv.delSolNovUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: asignarFechaTerminada

    /*
     * Entry point for service asignarFechaTerminada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse asignarFechaTerminada(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFechaTerminadaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.asignarFechaTerminadaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service asignarFechaTerminada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse asignarFechaTerminadaTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFechaTerminadaRequest request) throws ModelException {
        request.setSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedad()));
        return solicitudNovedadSrv.asignarFechaTerminadaImplementation(request);
    }

    /*
     * Implements service asignarFechaTerminada
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse asignarFechaTerminadaImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFechaTerminadaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad = request.getSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad;
        instance.setSolicitudNovedadFechaTerminada(STDFunctions.systemDateFun());
        instance.setSolicitudNovedadSemaforoGrabAse(userFunctionsSrv.fuCallSPgetsemaforograbadornovFun(solicitudNovedadasignarFechaTerminadapthisSolicitudNovedad.getSolicitudNovedadId()));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: asignarPrioridad

    /*
     * Entry point for service asignarPrioridad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse asignarPrioridad(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarPrioridadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.asignarPrioridadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service asignarPrioridad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse asignarPrioridadTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarPrioridadRequest request) throws ModelException {
        request.setSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadasignarPrioridadpthisSolicitudNovedad()));
        return solicitudNovedadSrv.asignarPrioridadImplementation(request);
    }

    /*
     * Implements service asignarPrioridad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse asignarPrioridadImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarPrioridadRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadasignarPrioridadpthisSolicitudNovedad = request.getSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance();
        Long solicitudNovedadasignarPrioridadpePrioridad = request.getSolicitudNovedadasignarPrioridadpePrioridad();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadasignarPrioridadpthisSolicitudNovedad;
        if (solicitudNovedadasignarPrioridadpePrioridad > Long.valueOf(0)) {
            instance.setSolicitudNovedadPrioridad(solicitudNovedadasignarPrioridadpePrioridad);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: anotarObservaciones

    /*
     * Entry point for service anotarObservaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse anotarObservaciones(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AnotarObservacionesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.anotarObservacionesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service anotarObservaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse anotarObservacionesTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AnotarObservacionesRequest request) throws ModelException {
        request.setSolicitudNovedadanotarObservacionespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadanotarObservacionespthisSolicitudNovedad()));
        return solicitudNovedadSrv.anotarObservacionesImplementation(request);
    }

    /*
     * Implements service anotarObservaciones
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse anotarObservacionesImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AnotarObservacionesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadanotarObservacionespthisSolicitudNovedad = request.getSolicitudNovedadanotarObservacionespthisSolicitudNovedadInstance();

        request.checkArguments();

        anotarObservacionesPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadanotarObservacionespthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service anotarObservaciones preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse anotarObservacionesCheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AnotarObservacionesRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setSolicitudNovedadanotarObservacionespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadanotarObservacionespthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_57".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre57(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void anotarObservacionesPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AnotarObservacionesRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre57(request);
    }

    private void checkClas1581421428736234Pre57 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AnotarObservacionesRequest request) 
            throws ModelException {
        // pObservaciones = NULL OR length(TextToStr(pObservaciones)) <= 700

        String solicitudNovedadanotarObservacionespObservaciones = request.getSolicitudNovedadanotarObservacionespObservaciones();
        boolean preconditionHolds = solicitudNovedadanotarObservacionespObservaciones == null || STDFunctions.lengthFun(STDFunctions.textToStrFun(solicitudNovedadanotarObservacionespObservaciones)) <= Long.valueOf(700);
        if (!preconditionHolds) throw new PreconditionException("Las observaciones no pueden superar los 700 caracteres");
    }

    // Service: asignarFUG

    /*
     * Entry point for service asignarFUG
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse asignarFUG(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFUGRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.asignarFUGTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service asignarFUG
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse asignarFUGTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFUGRequest request) throws ModelException {
        request.setSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadasignarFUGpthisSolicitudNovedad()));
        return solicitudNovedadSrv.asignarFUGImplementation(request);
    }

    /*
     * Implements service asignarFUG
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse asignarFUGImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFUGRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadasignarFUGpthisSolicitudNovedad = request.getSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadasignarFUGpthisSolicitudNovedad;
        instance.setSolicitudNovedadFechaFUG(STDFunctions.systemDateTimeFun());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: asignarFA

    /*
     * Entry point for service asignarFA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse asignarFA(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.asignarFATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service asignarFA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse asignarFATxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFARequest request) throws ModelException {
        request.setSolicitudNovedadasignarFApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadasignarFApthisSolicitudNovedad()));
        return solicitudNovedadSrv.asignarFAImplementation(request);
    }

    /*
     * Implements service asignarFA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse asignarFAImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFARequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadasignarFApthisSolicitudNovedad = request.getSolicitudNovedadasignarFApthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadasignarFApthisSolicitudNovedad;
        instance.setSolicitudNovedadFechaFA(STDFunctions.systemDateTimeFun());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: dummyEstatusSolicitudes

    /*
     * Entry point for service dummyEstatusSolicitudes
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse dummyEstatusSolicitudes(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyEstatusSolicitudesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.dummyEstatusSolicitudesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service dummyEstatusSolicitudes
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse dummyEstatusSolicitudesTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyEstatusSolicitudesRequest request) throws ModelException {
        request.setSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad()));
        return solicitudNovedadSrv.dummyEstatusSolicitudesImplementation(request);
    }

    /*
     * Implements service dummyEstatusSolicitudes
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse dummyEstatusSolicitudesImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyEstatusSolicitudesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad = request.getSolicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad;
        instance.setSolicitudNovedadCompletada(solicitudNovedaddummyEstatusSolicitudespthisSolicitudNovedad.getSolicitudNovedadCompletada());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: InsFirmaSolNov

    /*
     * Entry point for service InsFirmaSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insFirmaSolNov(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsFirmaSolNovRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insFirmaSolNovTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsFirmaSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insFirmaSolNovTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsFirmaSolNovRequest request) throws ModelException {
        request.setSolicitudNovedadInsFirmaSolNovpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsFirmaSolNovpthisSolicitudNovedad()));
        request.setSolicitudNovedadInsFirmaSolNovpevcFirmaInstance(firmaSrv.getByOIDWithHV(request.getSolicitudNovedadInsFirmaSolNovpevcFirma()));
        return solicitudNovedadSrv.insFirmaSolNovImplementation(request, true);
    }

    /*
     * Implements service InsFirmaSolNov
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insFirmaSolNovImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsFirmaSolNovRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsFirmaSolNovpthisSolicitudNovedad = request.getSolicitudNovedadInsFirmaSolNovpthisSolicitudNovedadInstance();
        Firma solicitudNovedadInsFirmaSolNovpevcFirma = request.getSolicitudNovedadInsFirmaSolNovpevcFirmaInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsFirmaSolNovpthisSolicitudNovedad;

        instance.add2Firma(solicitudNovedadInsFirmaSolNovpevcFirma);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.firma.siu.InsFirmaSolNovRequest relatedRequest = new com.keralty.aenovedades.viewmodel.firma.siu.InsFirmaSolNovRequest();
            relatedRequest.setFirmaInsFirmaSolNovpthisFirmaInstance(solicitudNovedadInsFirmaSolNovpevcFirma);
            relatedRequest.setFirmaInsFirmaSolNovpevcSolicitudNovedadInstance(solicitudNovedadInsFirmaSolNovpthisSolicitudNovedad);
            firmaSrv.insFirmaSolNovImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: DelFirmaSolNov

    /*
     * Entry point for service DelFirmaSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delFirmaSolNov(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelFirmaSolNovRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delFirmaSolNovTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelFirmaSolNov
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delFirmaSolNovTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelFirmaSolNovRequest request) throws ModelException {
        request.setSolicitudNovedadDelFirmaSolNovpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelFirmaSolNovpthisSolicitudNovedad()));
        request.setSolicitudNovedadDelFirmaSolNovpevcFirmaInstance(firmaSrv.getByOIDWithHV(request.getSolicitudNovedadDelFirmaSolNovpevcFirma()));
        return solicitudNovedadSrv.delFirmaSolNovImplementation(request, true);
    }

    /*
     * Implements service DelFirmaSolNov
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delFirmaSolNovImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelFirmaSolNovRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelFirmaSolNovpthisSolicitudNovedad = request.getSolicitudNovedadDelFirmaSolNovpthisSolicitudNovedadInstance();
        Firma solicitudNovedadDelFirmaSolNovpevcFirma = request.getSolicitudNovedadDelFirmaSolNovpevcFirmaInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelFirmaSolNovpthisSolicitudNovedad;

        instance.add2Firma(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.firma.siu.DelFirmaSolNovRequest relatedRequest = new com.keralty.aenovedades.viewmodel.firma.siu.DelFirmaSolNovRequest();
            relatedRequest.setFirmaDelFirmaSolNovpthisFirmaInstance(solicitudNovedadDelFirmaSolNovpevcFirma);
            relatedRequest.setFirmaDelFirmaSolNovpevcSolicitudNovedadInstance(solicitudNovedadDelFirmaSolNovpthisSolicitudNovedad);
            firmaSrv.delFirmaSolNovImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: dummyNavegarAConsultar

    /*
     * Entry point for service dummyNavegarAConsultar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse dummyNavegarAConsultar(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAConsultarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.dummyNavegarAConsultarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service dummyNavegarAConsultar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse dummyNavegarAConsultarTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAConsultarRequest request) throws ModelException {
        request.setSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad()));
        return solicitudNovedadSrv.dummyNavegarAConsultarImplementation(request);
    }

    /*
     * Implements service dummyNavegarAConsultar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse dummyNavegarAConsultarImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DummyNavegarAConsultarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad = request.getSolicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedaddummyNavegarAConsultarpthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: getRutaPlantilla

    /*
     * Entry point for service getRutaPlantilla
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse getRutaPlantilla(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaRequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse();
        try {
            response = solicitudNovedadSrv.getRutaPlantillaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service getRutaPlantilla
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse getRutaPlantillaTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedad()));
        return solicitudNovedadSrv.getRutaPlantillaImplementation(request);
    }

    /*
     * Implements service getRutaPlantilla
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse getRutaPlantillaImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaRequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse();
        SolicitudNovedad solicitudNovedadgetRutaPlantillapthisSolicitudNovedad = request.getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance();

        request.checkArguments();

        getRutaPlantillaPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadgetRutaPlantillapthisSolicitudNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        // Value expressions for outgoing argument 'solicitudNovedadgetRutaPlantillaoaRuta'
        // DEFAULT  : GETONE(PlanT.ProductoT.Dominios.ReportesDominio.drvRuta)  WHERE         //            (PlanT.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = PlanT AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 12 AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= FechaCreacion AND PlanT.ProductoT.Dominios.ReportesDominio.drvFechaHasta > FechaCreacion)
        response.setSolicitudNovedadgetRutaPlantillaoaRuta(repository.assocOperator027(solicitudNovedadgetRutaPlantillapthisSolicitudNovedad));


        // Value expressions for outgoing argument 'solicitudNovedadgetRutaPlantillaoaNombreArchivo'
        // DEFAULT  : IntToStr(NumRadicado) + ".pdf"
        response.setSolicitudNovedadgetRutaPlantillaoaNombreArchivo(STDFunctions.intToStrFun(solicitudNovedadgetRutaPlantillapthisSolicitudNovedad.getSolicitudNovedadNumRadicado()) + ".pdf");


        // Value expressions for outgoing argument 'solicitudNovedadgetRutaPlantillaoaReporte'
        // DEFAULT  : NULL
        response.setSolicitudNovedadgetRutaPlantillaoaReporte(null);


        return response;
    }

    /*
     * Checks service getRutaPlantilla preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse getRutaPlantillaCheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaRequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaResponse();
        request.setSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_60".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre60(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void getRutaPlantillaPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre60(request);
    }

    private void checkClas1581421428736234Pre60 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.GetRutaPlantillaRequest request) 
            throws ModelException {
        // COUNT( PlanT.ProductoT.Dominios.ReportesDominio)  WHERE 
        // (PlanT.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = PlanT AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 12 AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= FechaCreacion AND PlanT.ProductoT.Dominios.ReportesDominio.drvFechaHasta > FechaCreacion) = 1

        SolicitudNovedad solicitudNovedadgetRutaPlantillapthisSolicitudNovedad = request.getSolicitudNovedadgetRutaPlantillapthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = (repository.assocOperator026(solicitudNovedadgetRutaPlantillapthisSolicitudNovedad)).equals(Long.valueOf(1));
            if (!preconditionHolds) throw new PreconditionException("Plantilla del tipo solicitado inexistente para la solicitud");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
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
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse tCREAR(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARRequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse();
        try {
            response = solicitudNovedadSrv.tCREARTxn(request);
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
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse tCREARTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTCREARptpagrPlanInstance(planesSrv.getByOIDWithHV(new PlanesOid().fromJsonString(request.getSolicitudNovedadTCREARptpagrPlan())));
        request.setSolicitudNovedadTCREARptpagrNovedadInstance(novedadSrv.getByOIDWithHV(new NovedadOid().fromJsonString(request.getSolicitudNovedadTCREARptpagrNovedad())));
        request.setSolicitudNovedadTCREARptpagrCausalInstance(causalSrv.getByOIDWithHV(new CausalOid().fromJsonString(request.getSolicitudNovedadTCREARptpagrCausal())));
        request.setSolicitudNovedadTCREARptProductoInstance(productosSrv.getByOIDWithHV(new ProductosOid().fromJsonString(request.getSolicitudNovedadTCREARptProducto())));
        request.setSolicitudNovedadTCREARptTipoNovedadInstance(tipoNovedadSrv.getByOIDWithHV(new TipoNovedadOid().fromJsonString(request.getSolicitudNovedadTCREARptTipoNovedad())));
        request.setSolicitudNovedadTCREARptpagrProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARptpagrProteccionDatos()));
        return solicitudNovedadSrv.tCREARImplementation(request);
    }

    /*
     * Implements service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse tCREARImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARRequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARResponse();
        Planes solicitudNovedadTCREARptpagrPlan = request.getSolicitudNovedadTCREARptpagrPlanInstance();
        Novedad solicitudNovedadTCREARptpagrNovedad = request.getSolicitudNovedadTCREARptpagrNovedadInstance();
        Causal solicitudNovedadTCREARptpagrCausal = request.getSolicitudNovedadTCREARptpagrCausalInstance();
        Date solicitudNovedadTCREARptpatrFechaVigencia = request.getSolicitudNovedadTCREARptpatrFechaVigencia();
        String solicitudNovedadTCREARptpatrNumContrato = request.getSolicitudNovedadTCREARptpatrNumContrato();
        Productos solicitudNovedadTCREARptProducto = request.getSolicitudNovedadTCREARptProductoInstance();
        TipoNovedad solicitudNovedadTCREARptTipoNovedad = request.getSolicitudNovedadTCREARptTipoNovedadInstance();
        ProteccionDatos solicitudNovedadTCREARptpagrProteccionDatos = request.getSolicitudNovedadTCREARptpagrProteccionDatosInstance();

        request.checkArguments();
        SolicitudNovedad instance;

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTRequest step1Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTRequest();
        step1Request.setSolicitudNovedadTCREARINTptpagrPlanInstance(solicitudNovedadTCREARptpagrPlan);
        step1Request.setSolicitudNovedadTCREARINTptpagrNovedadInstance(solicitudNovedadTCREARptpagrNovedad);
        step1Request.setSolicitudNovedadTCREARINTptpagrCausalInstance(solicitudNovedadTCREARptpagrCausal);
        step1Request.setSolicitudNovedadTCREARINTptpatrFechaVigencia(solicitudNovedadTCREARptpatrFechaVigencia);
        step1Request.setSolicitudNovedadTCREARINTptpatrNumContrato(solicitudNovedadTCREARptpatrNumContrato);
        step1Request.setSolicitudNovedadTCREARINTptProductoInstance(solicitudNovedadTCREARptProducto);
        step1Request.setSolicitudNovedadTCREARINTptTipoNovedadInstance(solicitudNovedadTCREARptTipoNovedad);
        step1Request.setSolicitudNovedadTCREARINTptpagrProteccionDatosInstance(solicitudNovedadTCREARptpagrProteccionDatos);
        step1Request.setSolicitudNovedadTCREARINTptpatrExcepcion(Boolean.FALSE);
        step1Request.setSolicitudNovedadTCREARINTpagrMotivoExcepcionInstance(null);
        step1Request.setSolicitudNovedadTCREARINTpatrFechaIniExcepcion(null);
        step1Request.setSolicitudNovedadTCREARINTpatrFechaFinExcepcion(null);
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse step1Response = solicitudNovedadSrv.tCREARINTImplementation(step1Request);
        instance = (SolicitudNovedad) step1Response.getInstance();
        response.setSolicitudNovedadTCREARoaSolicitudInstance(step1Response.getSolicitudNovedadTCREARINToaSolicitudInstance());

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        // Value expressions for outgoing argument 'solicitudNovedadTCREARoaSolicitud'
        // DEFAULT  : THIS
        response.setSolicitudNovedadTCREARoaSolicitudInstance(instance);


        return response;
    }

    // Service: TSETVALORESDESDECONTRATO

    /*
     * Entry point for service TSETVALORESDESDECONTRATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tSETVALORESDESDECONTRATO(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TSETVALORESDESDECONTRATORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tSETVALORESDESDECONTRATOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TSETVALORESDESDECONTRATO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tSETVALORESDESDECONTRATOTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TSETVALORESDESDECONTRATORequest request) throws ModelException {
        request.setSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad()));
        request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato()));
        request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado()));
        request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad()));
        request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion()));
        return solicitudNovedadSrv.tSETVALORESDESDECONTRATOImplementation(request);
    }

    /*
     * Implements service TSETVALORESDESDECONTRATO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tSETVALORESDESDECONTRATOImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TSETVALORESDESDECONTRATORequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio();
        Boolean solicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido();
        String solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion();
        String solicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial = request.getSolicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial();
        Boolean solicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo = request.getSolicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo();
        String solicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona = request.getSolicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona();
        Date solicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato();
        Long solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato();
        EstadoContrato solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance();
        GrupoAsociado solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance();
        Periodicidad solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance();
        TipoIdentificacion solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion = request.getSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance();
        SolicitudNovedad solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad = request.getSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad;

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.SetValoresDesdeContratoRequest step1Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.SetValoresDesdeContratoRequest();
        step1Request.setSolicitudNovedadsetValoresDesdeContratopthisSolicitudNovedadInstance(solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrCodigoTarifa(solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrDescTarifa(solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrCodigoConvenio(solicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrDescConvenio(solicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrEsColectivo(solicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopContraNumIden(solicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopContraPrimerNombre(solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopContraSegundoNombre(solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopContraPrimerApellido(solicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopContraSegundoApellido(solicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrTagCausaExclusion(solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopContraRazonSocial(solicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrActivo(solicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopContraTipoPersona(solicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopatrCtrFInicioContrato(solicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato);
        step1Request.setSolicitudNovedadsetValoresDesdeContratopCtrTipoContrato(solicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato);
        solicitudNovedadSrv.setValoresDesdeContratoImplementation(step1Request);

        boolean guard2 = (solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato != null && !solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato.isNull());

        if (guard2) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsEstadoContratoRequest step2Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsEstadoContratoRequest();
            step2Request.setSolicitudNovedadInsEstadoContratopthisSolicitudNovedadInstance(solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad);
            step2Request.setSolicitudNovedadInsEstadoContratopevcEstadoContratoInstance(solicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContrato);
            solicitudNovedadSrv.insEstadoContratoImplementation(step2Request, true);
        }

        boolean guard3 = (solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado != null && !solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado.isNull());

        if (guard3) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsGrupoAsociadoRequest step3Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsGrupoAsociadoRequest();
            step3Request.setSolicitudNovedadInsGrupoAsociadopthisSolicitudNovedadInstance(solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad);
            step3Request.setSolicitudNovedadInsGrupoAsociadopevcGrupoAsociadoInstance(solicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociado);
            solicitudNovedadSrv.insGrupoAsociadoImplementation(step3Request, true);
        }

        boolean guard4 = (solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad != null && !solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad.isNull());

        if (guard4) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadSolNovRequest step4Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadSolNovRequest();
            step4Request.setSolicitudNovedadInsPeriodicidadSolNovpthisSolicitudNovedadInstance(solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad);
            step4Request.setSolicitudNovedadInsPeriodicidadSolNovpevcPeriodicidadInstance(solicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidad);
            solicitudNovedadSrv.insPeriodicidadSolNovImplementation(step4Request, true);
        }

        boolean guard5 = (solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion != null && !solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion.isNull());

        if (guard5) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsTipoIdentContratanteRequest step5Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsTipoIdentContratanteRequest();
            step5Request.setSolicitudNovedadInsTipoIdentContratantepthisSolicitudNovedadInstance(solicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedad);
            step5Request.setSolicitudNovedadInsTipoIdentContratantepevcTipoIdentificacionInstance(solicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacion);
            solicitudNovedadSrv.insTipoIdentContratanteImplementation(step5Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TADDFAMILIA

    /*
     * Entry point for service TADDFAMILIA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tADDFAMILIA(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tADDFAMILIATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TADDFAMILIA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tADDFAMILIATxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest request) throws ModelException {
        request.setSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTADDFAMILIApthisSolicitudNovedad()));
        return solicitudNovedadSrv.tADDFAMILIAImplementation(request);
    }

    /*
     * Implements service TADDFAMILIA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tADDFAMILIAImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Long solicitudNovedadTADDFAMILIAptNumFamilia = request.getSolicitudNovedadTADDFAMILIAptNumFamilia();
        SolicitudNovedad solicitudNovedadTADDFAMILIApthisSolicitudNovedad = request.getSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance();

        request.checkArguments();

        tADDFAMILIAPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadTADDFAMILIApthisSolicitudNovedad;

        com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECORERequest step1Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.TCREARDESDECORERequest();
        step1Request.setFamiliaNovedadTCREARDESDECOREptpagrSolicitudInstance(solicitudNovedadTADDFAMILIApthisSolicitudNovedad);
        step1Request.setFamiliaNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance(null);
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrTitNumidentificacion("");
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrTitPrimerNombre("");
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrTitTieneBeneficios(Boolean.FALSE);
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrTitSegundoNombre("");
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrTitPrimerApellido("");
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrTitSegundoApellido("");
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrNumFamilia(solicitudNovedadTADDFAMILIAptNumFamilia);
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrTitRazonSocial("");
        step1Request.setFamiliaNovedadTCREARDESDECOREptpatrFamActiva(Boolean.FALSE);
        familiaNovedadSrv.tCREARDESDECOREImplementation(step1Request);
        

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service TADDFAMILIA preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tADDFAMILIACheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTADDFAMILIApthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_50".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre50(request);
            if("Clas_1581421428736234Pre_51".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre51(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tADDFAMILIAPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest request) 
            throws ModelException {
        checkClas1581421428736234Pre50(request);
        checkClas1581421428736234Pre51(request);
    }

    private void checkClas1581421428736234Pre50 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest request) 
            throws ModelException {
        // DrvPermiteAddFam = TRUE

        SolicitudNovedad solicitudNovedadTADDFAMILIApthisSolicitudNovedad = request.getSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance();
        boolean preconditionHolds = solicitudNovedadTADDFAMILIApthisSolicitudNovedad.getSolicitudNovedadDrvPermiteAddFam().equals(true);
        if (!preconditionHolds) throw new PreconditionException("No es posible añadir familia a la novedad");
    }

    private void checkClas1581421428736234Pre51 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest request) 
            throws ModelException {
        // COUNT(Familias) WHERE (Familias.NumFamilia = ptNumFamilia) = 0

        Long solicitudNovedadTADDFAMILIAptNumFamilia = request.getSolicitudNovedadTADDFAMILIAptNumFamilia();
        SolicitudNovedad solicitudNovedadTADDFAMILIApthisSolicitudNovedad = request.getSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = (repository.assocOperator020(solicitudNovedadTADDFAMILIApthisSolicitudNovedad, solicitudNovedadTADDFAMILIAptNumFamilia)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("La familia número " + STDFunctions.intToStrFun(solicitudNovedadTADDFAMILIAptNumFamilia) + " ya está incluida en la solicitud");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
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
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse tMARCARCOMPLETADA(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse();
        try {
            response = solicitudNovedadSrv.tMARCARCOMPLETADATxn(request);
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
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse tMARCARCOMPLETADATxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad()));
        return solicitudNovedadSrv.tMARCARCOMPLETADAImplementation(request);
    }

    /*
     * Implements service TMARCARCOMPLETADA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse tMARCARCOMPLETADAImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse();
        response.setSolicitudNovedadTMARCARCOMPLETADAoaNumErr(Long.valueOf(0));
        SolicitudNovedad solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedadInstance();

        request.checkArguments();

        tMARCARCOMPLETADAPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad;

        /* Action 1: IF (Excepcion = false OR systemDate() < FechaIniExcepcion OR systemDate() > FechaFinExcepcion) */
        boolean ifCondition1 = solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadExcepcion().equals(false) || STDFunctions.dateBeforeFun(STDFunctions.systemDateFun(),solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadFechaIniExcepcion()) || STDFunctions.dateAfterFun(STDFunctions.systemDateFun(),solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadFechaFinExcepcion());
        if (ifCondition1) {
            /* Action 10: IF (DrvExigeContratoActivo = true) */
            boolean ifCondition10 = solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadDrvExigeContratoActivo().equals(true);
            if (ifCondition10) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarContratoActivoRequest step100Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarContratoActivoRequest();
                step100Request.setSolicitudNovedadvalidarContratoActivopthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
                solicitudNovedadSrv.validarContratoActivoImplementation(step100Request);
            }
            for(FamiliaNovedad step1011Entity : repository.assocOperator028(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad)) {
                com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest step11Request = new com.keralty.aenovedades.viewmodel.familianovedad.siu.TMARCARCOMPLETADARequest();
                step11Request.setFamiliaNovedadTMARCARCOMPLETADApthisFamiliaNovedadInstance(step1011Entity);
                familiaNovedadSrv.tMARCARCOMPLETADAImplementation(step11Request);
            }
            /* Action 12: IF (Novedad.AliasNovedad = "SC") */
            boolean ifCondition12 = (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("SC");
            if (ifCondition12) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest step120Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarSCRequest();
                step120Request.setSolicitudNovedadvalidarSCpthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
                solicitudNovedadSrv.validarSCImplementation(step120Request);
            }
            /* Action 13: IF (Novedad.AliasNovedad = "PS" AND Novedad.TipoNovedad.Tipo = 0) */
            boolean ifCondition13 = (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("PS") && (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getTipoNovedad().getTipoNovedadTipo()).equals(Long.valueOf(0));
            if (ifCondition13) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest step130Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPSContratoRequest();
                step130Request.setSolicitudNovedadvalidarPSContratopthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
                solicitudNovedadSrv.validarPSContratoImplementation(step130Request);
            }
            /* Action 14: IF (Novedad.AliasNovedad = "PP") */
            boolean ifCondition14 = (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("PP");
            if (ifCondition14) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPPRequest step140Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarPPRequest();
                step140Request.setSolicitudNovedadvalidarPPpthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
                solicitudNovedadSrv.validarPPImplementation(step140Request);
            }
            /* Action 15: IF (Novedad.AliasNovedad = "AS" AND Novedad.TipoNovedad.Tipo = 0) */
            boolean ifCondition15 = (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("AS") && (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getTipoNovedad().getTipoNovedadTipo()).equals(Long.valueOf(0));
            if (ifCondition15) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarASRequest step150Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarASRequest();
                step150Request.setSolicitudNovedadvalidarASpthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
                solicitudNovedadSrv.validarASImplementation(step150Request);
            }
            /* Action 16: IF (Novedad.AliasNovedad = "CR") */
            boolean ifCondition16 = (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("CR");
            if (ifCondition16) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarCRRequest step160Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.ValidarCRRequest();
                step160Request.setSolicitudNovedadvalidarCRpthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
                solicitudNovedadSrv.validarCRImplementation(step160Request);
            }
        }

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.MarcarCompletadaRequest step2Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.MarcarCompletadaRequest();
        step2Request.setSolicitudNovedadmarcarCompletadapthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
        solicitudNovedadSrv.marcarCompletadaImplementation(step2Request);

        /* Action 3: IF (COUNT (Documentos) = 0) */
        boolean ifCondition3 = (repository.assocOperator032(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad)).equals(Long.valueOf(0));
        if (ifCondition3) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest step30Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest();
            step30Request.setSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
            step30Request.setSolicitudNovedadcambiarEstadoDocpeEstadoDoc(Long.valueOf(2));
            solicitudNovedadSrv.cambiarEstadoDocImplementation(step30Request);
        }

        for(DocumentoNovedad step4Entity : repository.assocOperator030(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad)) {
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarFechaSubidaRequest step4Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.CambiarFechaSubidaRequest();
            step4Request.setDocumentoNovedadcambiarFechaSubidapthisDocumentoNovedadInstance(step4Entity);
            step4Request.setDocumentoNovedadcambiarFechaSubidapFechaSubida(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadFechaCompletada());
            documentoNovedadSrv.cambiarFechaSubidaImplementation(step4Request);
        }

        for(NovedadCT step5Entity : repository.assocOperator031(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad)) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACORERequest step5Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACORERequest();
            step5Request.setSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
            step5Request.setSolicitudNovedadTCREARPERSONACOREptNovedadCTInstance(step5Entity);
            step5Request.setSolicitudNovedadTCREARPERSONACOREptNumErrores(response.getSolicitudNovedadTMARCARCOMPLETADAoaNumErr());
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse step5Response = solicitudNovedadSrv.tCREARPERSONACOREImplementation(step5Request);
        response.setSolicitudNovedadTMARCARCOMPLETADAoaNumErr(step5Response.getSolicitudNovedadTCREARPERSONACOREoaNumErrores());
        }

        /* Action 6: IF (oaNumErr = 0) */
        boolean ifCondition6 = (response.getSolicitudNovedadTMARCARCOMPLETADAoaNumErr()).equals(Long.valueOf(0));
        if (ifCondition6) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoRequest step60Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoRequest();
            step60Request.setSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
            step60Request.setSolicitudNovedadcambiarEstadopeEstado(Long.valueOf(0));
            solicitudNovedadSrv.cambiarEstadoImplementation(step60Request);
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest step61Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest();
            step61Request.setSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad);
            step61Request.setSolicitudNovedadTCAMBIARESTADOptEstado(Long.valueOf(1));
            solicitudNovedadSrv.tCAMBIARESTADOImplementation(step61Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service TMARCARCOMPLETADA preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse tMARCARCOMPLETADACheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADAResponse();
        request.setSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_40".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre40(request);
            if("Clas_1581421428736234Pre_53".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre53(request);
            if("Clas_1581421428736234Pre_54".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre54(request);
            if("Clas_1581421428736234Pre_56".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre56(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tMARCARCOMPLETADAPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        checkClas1581421428736234Pre40(request);
        checkClas1581421428736234Pre53(request);
        checkClas1581421428736234Pre54(request);
        checkClas1581421428736234Pre56(request);
    }

    private void checkClas1581421428736234Pre40 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Novedad.TipoNovedad.Tipo = 0 OR COUNT(Familias) > 0

        SolicitudNovedad solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = (solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getNovedad().getTipoNovedad().getTipoNovedadTipo()).equals(Long.valueOf(0)) || repository.assocOperator021(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("La novedad requiere que indique al menos una familia");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1581421428736234Pre53 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // DrvExigeDocSolicitud = false OR COUNT( Documentos ) WHERE (Documentos.Tipo = 2) > 0

        SolicitudNovedad solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadDrvExigeDocSolicitud().equals(false) || repository.assocOperator022(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Debe adjuntar documentación de la solicitud");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1581421428736234Pre54 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // DrvExigeDocPersona = FALSE OR COUNT(Documentos)  WHERE (Documentos.Tipo = 1) > 0

        SolicitudNovedad solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadDrvExigeDocPersona().equals(false) || repository.assocOperator023(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Debe adjuntar documentación de identificación de persona");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1581421428736234Pre56 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARCOMPLETADARequest request) 
            throws ModelException {
        // Excepcion = false OR COUNT( PlanT.Dominios ) WHERE (PlanT.Dominios.NovExcepcionReqDoc = true AND PlanT.Dominios.ProductoT = PlanT.ProductoT) = 0 OR COUNT( Documentos ) WHERE (Documentos.Tipo = 2) > 0

        SolicitudNovedad solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedadInstance();
        try {
            boolean preconditionHolds = solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad.getSolicitudNovedadExcepcion().equals(false) || (repository.assocOperator024(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad)).equals(Long.valueOf(0)) || repository.assocOperator025(solicitudNovedadTMARCARCOMPLETADApthisSolicitudNovedad) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("Debe adjuntar documentación de la solicitud de excepción");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: TCHGNUEVAPERIODICIDAD

    /*
     * Entry point for service TCHGNUEVAPERIODICIDAD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCHGNUEVAPERIODICIDAD(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tCHGNUEVAPERIODICIDADTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCHGNUEVAPERIODICIDAD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCHGNUEVAPERIODICIDADTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad()));
        request.setSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(new PeriodicidadOid().fromJsonString(request.getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad())));
        return solicitudNovedadSrv.tCHGNUEVAPERIODICIDADImplementation(request);
    }

    /*
     * Implements service TCHGNUEVAPERIODICIDAD
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCHGNUEVAPERIODICIDADImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Periodicidad solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad = request.getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance();
        SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad = request.getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance();

        request.checkArguments();

        tCHGNUEVAPERIODICIDADPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad;

        /* Action 1: IF (ptPeriodicidad <> PeriodicidadNueva) */
        boolean ifCondition1 = !(solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad.equalsObject(solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad.getPeriodicidadNueva()));
        if (ifCondition1) {
            /* Action 10: IF (EXIST (PeriodicidadNueva) = true) */
            boolean ifCondition10 = repository.assocOperator034(solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad).equals(true);
            if (ifCondition10) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadNuevaRequest step100Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelPeriodicidadNuevaRequest();
                step100Request.setSolicitudNovedadDelPeriodicidadNuevapthisSolicitudNovedadInstance(solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad);
                step100Request.setSolicitudNovedadDelPeriodicidadNuevapevcPeriodicidadInstance(solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad.getPeriodicidadNueva());
                solicitudNovedadSrv.delPeriodicidadNuevaImplementation(step100Request, true);
            }
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadNuevaRequest step11Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsPeriodicidadNuevaRequest();
            step11Request.setSolicitudNovedadInsPeriodicidadNuevapthisSolicitudNovedadInstance(solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad);
            step11Request.setSolicitudNovedadInsPeriodicidadNuevapevcPeriodicidadInstance(solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad);
            solicitudNovedadSrv.insPeriodicidadNuevaImplementation(step11Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service TCHGNUEVAPERIODICIDAD preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tCHGNUEVAPERIODICIDADCheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad()));
        request.setSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(new PeriodicidadOid().fromJsonString(request.getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad())));
        try {
            if("Clas_1581421428736234Pre_41".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre41(request);
            if("Clas_1581421428736234Pre_42".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre42(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tCHGNUEVAPERIODICIDADPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest request) 
            throws ModelException {
        checkClas1581421428736234Pre41(request);
        checkClas1581421428736234Pre42(request);
    }

    private void checkClas1581421428736234Pre41 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest request) 
            throws ModelException {
        // Novedad.AliasNovedad = "PP"

        SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad = request.getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance();
        boolean preconditionHolds = (solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad.getNovedad().getNovedadAliasNovedad()).equals("PP");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de cambio de periodicidad");
    }

    private void checkClas1581421428736234Pre42 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCHGNUEVAPERIODICIDADRequest request) 
            throws ModelException {
        // ptPeriodicidad <> PeriodicidadNueva

        Periodicidad solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad = request.getSolicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidadInstance();
        SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad = request.getSolicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedadInstance();
        boolean preconditionHolds = !(solicitudNovedadTCHGNUEVAPERIODICIDADptPeriodicidad.equalsObject(solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad.getPeriodicidadNueva()));
        if (!preconditionHolds) throw new PreconditionException("La periodicidad introducida es la misma que ya tiene el contrato. Debe indicar otra periodicidad");
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tCAMBIARESTADOTxn(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad()));
        return solicitudNovedadSrv.tCAMBIARESTADOImplementation(request);
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
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long solicitudNovedadTCAMBIARESTADOptEstado = request.getSolicitudNovedadTCAMBIARESTADOptEstado();
        SolicitudNovedad solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad = request.getSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad;

        /* Action 1: IF (Estado <> ptEstado) */
        boolean ifCondition1 = !(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(solicitudNovedadTCAMBIARESTADOptEstado);
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFUGRequest step10Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFUGRequest();
            step10Request.setSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad);
            solicitudNovedadSrv.asignarFUGImplementation(step10Request);
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoRequest step11Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoRequest();
            step11Request.setSolicitudNovedadcambiarEstadopthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad);
            step11Request.setSolicitudNovedadcambiarEstadopeEstado(solicitudNovedadTCAMBIARESTADOptEstado);
            solicitudNovedadSrv.cambiarEstadoImplementation(step11Request);
            com.keralty.aenovedades.viewmodel.logestadosn.siu.TCREARRequest step12Request = new com.keralty.aenovedades.viewmodel.logestadosn.siu.TCREARRequest();
            step12Request.setLogEstadoSNTCREARptpagrSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad);
            step12Request.setLogEstadoSNTCREARptpatrEstado(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadEstado());
            step12Request.setLogEstadoSNTCREARptpatrEstadoDoc(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadEstadoDocumentacion());
            logEstadoSNSrv.tCREARImplementation(step12Request);
            /* Action 13: IF (EXIST (UsrAfiliacion) = false AND (Estado = 1 OR Estado = 2)) */
            boolean ifCondition13 = repository.assocOperator036(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad).equals(false) && ((solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(1)) || (solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(2)));
            if (ifCondition13) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGAUTOUSRAFILIRequest step130Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGAUTOUSRAFILIRequest();
                step130Request.setSolicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad);
                step130Request.setSolicitudNovedadTASGAUTOUSRAFILIptFuncionarioInstance(userFunctionsSrv.fugetFuncionarioPorIdFun(userFunctionsSrv.fuCallSPgetusugrabadornovFun(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadId())));
                solicitudNovedadSrv.tASGAUTOUSRAFILIImplementation(step130Request);
            }
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTERMINADARequest step14Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTERMINADARequest();
            step14Request.setSolicitudNovedadTMARCARTERMINADApthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad);
            solicitudNovedadSrv.tMARCARTERMINADAImplementation(step14Request);
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarPrioridadRequest step15Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarPrioridadRequest();
            step15Request.setSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad);
            step15Request.setSolicitudNovedadasignarPrioridadpePrioridad(userFunctionsSrv.fugetPrioridadFun(solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadEstado(), solicitudNovedadTCAMBIARESTADOpthisSolicitudNovedad.getSolicitudNovedadEstadoDocumentacion()));
            solicitudNovedadSrv.asignarPrioridadImplementation(step15Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TMARCARTRAMITADA

    /*
     * Entry point for service TMARCARTRAMITADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse tMARCARTRAMITADA(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse();
        try {
            response = solicitudNovedadSrv.tMARCARTRAMITADATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMARCARTRAMITADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse tMARCARTRAMITADATxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad()));
        return solicitudNovedadSrv.tMARCARTRAMITADAImplementation(request);
    }

    /*
     * Implements service TMARCARTRAMITADA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse tMARCARTRAMITADAImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse();
        SolicitudNovedad solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance();

        request.checkArguments();

        tMARCARTRAMITADAPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad;

        for(DocumentoNovedad step1Entity : repository.assocOperator037(solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad)) {
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest step1Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.TCAMBIARESTADORequest();
            step1Request.setDocumentoNovedadTCAMBIARESTADOpthisDocumentoNovedadInstance(step1Entity);
            step1Request.setDocumentoNovedadTCAMBIARESTADOptpatrObservacions(null);
            step1Request.setDocumentoNovedadTCAMBIARESTADOptNuevoEstado(Long.valueOf(2));
            step1Request.setDocumentoNovedadTCAMBIARESTADOptAjustarEstadoSolicitud(Boolean.FALSE);
            documentoNovedadSrv.tCAMBIARESTADOImplementation(step1Request);
        }

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest step2Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest();
        step2Request.setSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance(solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad);
        step2Request.setSolicitudNovedadcambiarEstadoDocpeEstadoDoc(Long.valueOf(2));
        solicitudNovedadSrv.cambiarEstadoDocImplementation(step2Request);

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest step3Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest();
        step3Request.setSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance(solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad);
        step3Request.setSolicitudNovedadTCAMBIARESTADOptEstado(Long.valueOf(2));
        solicitudNovedadSrv.tCAMBIARESTADOImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        // Value expressions for outgoing argument 'solicitudNovedadTMARCARTRAMITADAoaNumProcesados'
        // DEFAULT  : 1
        response.setSolicitudNovedadTMARCARTRAMITADAoaNumProcesados(Long.valueOf(1));


        // Value expressions for outgoing argument 'solicitudNovedadTMARCARTRAMITADAoaNumErrores'
        // DEFAULT  : 0
        response.setSolicitudNovedadTMARCARTRAMITADAoaNumErrores(Long.valueOf(0));


        // Value expressions for outgoing argument 'solicitudNovedadTMARCARTRAMITADAoaErrores'
        // DEFAULT  : ""
        response.setSolicitudNovedadTMARCARTRAMITADAoaErrores("");


        return response;
    }

    /*
     * Checks service TMARCARTRAMITADA preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse tMARCARTRAMITADACheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse();
        request.setSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_46".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre46(request);
            if("Clas_1581421428736234Pre_58".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre58();
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tMARCARTRAMITADAPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest request) 
            throws ModelException {
        checkClas1581421428736234Pre46(request);
        checkClas1581421428736234Pre58();
    }

    private void checkClas1581421428736234Pre46 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest request) 
            throws ModelException {
        // Estado <> 2

        SolicitudNovedad solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance();
        boolean preconditionHolds = !(solicitudNovedadTMARCARTRAMITADApthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(2));
        if (!preconditionHolds) throw new PreconditionException("La solicitud ya se encuentra en estado Tramitada");
    }

    private void checkClas1581421428736234Pre58 () throws ModelException {
        // AGENTAsesor = NULL OR AGENTAsesor.EsIntegral = TRUE

        boolean preconditionHolds = (((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) == null || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorEsIntegral().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Proceso no permitido para un Asesor");
    }

    // Service: TMARCARANULADA

    /*
     * Entry point for service TMARCARANULADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMARCARANULADA(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARANULADARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tMARCARANULADATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMARCARANULADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMARCARANULADATxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARANULADARequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTMARCARANULADApthisSolicitudNovedad()));
        return solicitudNovedadSrv.tMARCARANULADAImplementation(request);
    }

    /*
     * Implements service TMARCARANULADA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMARCARANULADAImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARANULADARequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadTMARCARANULADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance();

        request.checkArguments();

        tMARCARANULADAPreconditions(request);
        SolicitudNovedad instance = solicitudNovedadTMARCARANULADApthisSolicitudNovedad;

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest step1Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADORequest();
        step1Request.setSolicitudNovedadTCAMBIARESTADOpthisSolicitudNovedadInstance(solicitudNovedadTMARCARANULADApthisSolicitudNovedad);
        step1Request.setSolicitudNovedadTCAMBIARESTADOptEstado(Long.valueOf(4));
        solicitudNovedadSrv.tCAMBIARESTADOImplementation(step1Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    /*
     * Checks service TMARCARANULADA preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tMARCARANULADACheckPreconditions(com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARANULADARequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTMARCARANULADApthisSolicitudNovedad()));
        try {
            if("Clas_1581421428736234Pre_47".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre47(request);
            if("Clas_1581421428736234Pre_59".equals(request.getPreconditionId()))
                checkClas1581421428736234Pre59();
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tMARCARANULADAPreconditions(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARANULADARequest request) 
            throws ModelException {
        checkClas1581421428736234Pre47(request);
        checkClas1581421428736234Pre59();
    }

    private void checkClas1581421428736234Pre47 (
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARANULADARequest request) 
            throws ModelException {
        // Estado <> 4

        SolicitudNovedad solicitudNovedadTMARCARANULADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARANULADApthisSolicitudNovedadInstance();
        boolean preconditionHolds = !(solicitudNovedadTMARCARANULADApthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(4));
        if (!preconditionHolds) throw new PreconditionException("La solicitud ya se encuentra en estado Anulada");
    }

    private void checkClas1581421428736234Pre59 () throws ModelException {
        // AGENTAsesor = NULL OR AGENTAsesor.EsIntegral = TRUE

        boolean preconditionHolds = (((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) == null || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorEsIntegral().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Proceso no permitido para un Asesor");
    }

    // Service: TCREARINT

    /*
     * Entry point for service TCREARINT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse tCREARINT(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTRequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse();
        try {
            response = solicitudNovedadSrv.tCREARINTTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARINT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse tCREARINTTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTCREARINTptpagrPlanInstance(planesSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARINTptpagrPlan()));
        request.setSolicitudNovedadTCREARINTptpagrNovedadInstance(novedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARINTptpagrNovedad()));
        request.setSolicitudNovedadTCREARINTptpagrCausalInstance(causalSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARINTptpagrCausal()));
        request.setSolicitudNovedadTCREARINTptProductoInstance(productosSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARINTptProducto()));
        request.setSolicitudNovedadTCREARINTptTipoNovedadInstance(tipoNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARINTptTipoNovedad()));
        request.setSolicitudNovedadTCREARINTptpagrProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARINTptpagrProteccionDatos()));
        request.setSolicitudNovedadTCREARINTpagrMotivoExcepcionInstance(motivoExcepcionSolNovSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARINTpagrMotivoExcepcion()));
        return solicitudNovedadSrv.tCREARINTImplementation(request);
    }

    /*
     * Implements service TCREARINT
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse tCREARINTImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTRequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse();
        Planes solicitudNovedadTCREARINTptpagrPlan = request.getSolicitudNovedadTCREARINTptpagrPlanInstance();
        Novedad solicitudNovedadTCREARINTptpagrNovedad = request.getSolicitudNovedadTCREARINTptpagrNovedadInstance();
        Causal solicitudNovedadTCREARINTptpagrCausal = request.getSolicitudNovedadTCREARINTptpagrCausalInstance();
        ProteccionDatos solicitudNovedadTCREARINTptpagrProteccionDatos = request.getSolicitudNovedadTCREARINTptpagrProteccionDatosInstance();
        MotivoExcepcionSolNov solicitudNovedadTCREARINTpagrMotivoExcepcion = request.getSolicitudNovedadTCREARINTpagrMotivoExcepcionInstance();
        Date solicitudNovedadTCREARINTptpatrFechaVigencia = request.getSolicitudNovedadTCREARINTptpatrFechaVigencia();
        String solicitudNovedadTCREARINTptpatrNumContrato = request.getSolicitudNovedadTCREARINTptpatrNumContrato();
        Boolean solicitudNovedadTCREARINTptpatrExcepcion = request.getSolicitudNovedadTCREARINTptpatrExcepcion();
        Date solicitudNovedadTCREARINTpatrFechaIniExcepcion = request.getSolicitudNovedadTCREARINTpatrFechaIniExcepcion();
        Date solicitudNovedadTCREARINTpatrFechaFinExcepcion = request.getSolicitudNovedadTCREARINTpatrFechaFinExcepcion();

        request.checkArguments();
        SolicitudNovedad instance;

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CrearRequest();
        step1Request.setSolicitudNovedadcrearpagrPlanTInstance(solicitudNovedadTCREARINTptpagrPlan);
        step1Request.setSolicitudNovedadcrearpagrNovedadInstance(solicitudNovedadTCREARINTptpagrNovedad);
        step1Request.setSolicitudNovedadcrearpagrCausalInstance(solicitudNovedadTCREARINTptpagrCausal);
        step1Request.setSolicitudNovedadcrearpagrProteccionDatosInstance(solicitudNovedadTCREARINTptpagrProteccionDatos);
        step1Request.setSolicitudNovedadcrearpagrTipoIdentContratanteInstance(null);
        step1Request.setSolicitudNovedadcrearpagrEstadoContratoInstance(null);
        step1Request.setSolicitudNovedadcrearpagrGrupoAsociadoInstance(null);
        step1Request.setSolicitudNovedadcrearpagrPeriodicidadInstance(null);
        step1Request.setSolicitudNovedadcrearpagrAgenteInstance(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)));
        step1Request.setSolicitudNovedadcrearpagrPeriodicidadNuevaInstance(null);
        step1Request.setSolicitudNovedadcrearpagrMotivoExcepcionInstance(solicitudNovedadTCREARINTpagrMotivoExcepcion);
        step1Request.setSolicitudNovedadcrearpagrUsrAfiliacionInstance(null);
        step1Request.setSolicitudNovedadcrearpagrFirmaInstance(null);
        step1Request.setSolicitudNovedadcrearpatrFechaVigencia(solicitudNovedadTCREARINTptpatrFechaVigencia);
        step1Request.setSolicitudNovedadcrearpatrNumContrato(solicitudNovedadTCREARINTptpatrNumContrato);
        step1Request.setSolicitudNovedadcrearpatrExcepcion(solicitudNovedadTCREARINTptpatrExcepcion);
        step1Request.setSolicitudNovedadcrearpatrFechaIniExcepcion(solicitudNovedadTCREARINTpatrFechaIniExcepcion);
        step1Request.setSolicitudNovedadcrearpatrFechaFinExcepcion(solicitudNovedadTCREARINTpatrFechaFinExcepcion);
        instance = (SolicitudNovedad) solicitudNovedadSrv.crearImplementation(step1Request).getInstance();

        /* Action 2: IF (DrvExigeDocPersona = false AND DrvExigeDocSolicitud = false) */
        boolean ifCondition2 = instance.getSolicitudNovedadDrvExigeDocPersona().equals(false) && instance.getSolicitudNovedadDrvExigeDocSolicitud().equals(false);
        if (ifCondition2) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest step20Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest();
            step20Request.setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance(instance);
            step20Request.setSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc(Long.valueOf(2));
            solicitudNovedadSrv.tCAMBIARESTADODOCImplementation(step20Request);
        }

        /* Action 3: IF (AGENTAsesor = NULL OR AGENTAsesor.VerContratoNovedad = true) */
        boolean ifCondition3 = (((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) == null || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(true);
        if (ifCondition3) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TSETVALORESDESDECONTRATORequest step30Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TSETVALORESDESDECONTRATORequest();
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOpthisSolicitudNovedadInstance(instance);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoTarifa("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescTarifa("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrCodigoConvenio("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrDescConvenio("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrEsColectivo(Boolean.FALSE);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraNumIden("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerNombre("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoNombre("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraPrimerApellido("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpContraSegundoApellido("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcEstadoContratoInstance(null);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcGrupoAsociadoInstance(null);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcPeriodicidadInstance(null);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpevcTipoIdentificacionInstance(null);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTagCausaExclusion("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOpContraRazonSocial("");
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOpCtrActivo(Boolean.FALSE);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOpContraTipoPersona(null);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpatrCtrFInicioContrato(null);
            step30Request.setSolicitudNovedadTSETVALORESDESDECONTRATOptpCtrTipoContrato(null);
            solicitudNovedadSrv.tSETVALORESDESDECONTRATOImplementation(step30Request);
        }

        /* Action 4: IF (Novedad.TipoNovedad.Tipo <> 0 AND (AGENTAsesor = NULL OR AGENTAsesor.VerContratoNovedad = true) AND CtrEsColectivo = false) */
        boolean ifCondition4 = !(instance.getNovedad().getTipoNovedad().getTipoNovedadTipo()).equals(Long.valueOf(0)) && ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) == null || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) || ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(true)) && instance.getSolicitudNovedadCtrEsColectivo().equals(false);
        if (ifCondition4) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest step40Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TADDFAMILIARequest();
            step40Request.setSolicitudNovedadTADDFAMILIApthisSolicitudNovedadInstance(instance);
            step40Request.setSolicitudNovedadTADDFAMILIAptNumFamilia(Long.valueOf(1));
            solicitudNovedadSrv.tADDFAMILIAImplementation(step40Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        // Value expressions for outgoing argument 'solicitudNovedadTCREARINToaSolicitud'
        // DEFAULT  : THIS
        response.setSolicitudNovedadTCREARINToaSolicitudInstance(instance);


        return response;
    }

    // Service: TCREAREXCEPCION

    /*
     * Entry point for service TCREAREXCEPCION
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse tCREAREXCEPCION(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONRequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse();
        try {
            response = solicitudNovedadSrv.tCREAREXCEPCIONTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAREXCEPCION
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse tCREAREXCEPCIONTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTCREAREXCEPCIONptpagrPlanInstance(planesSrv.getByOIDWithHV(new PlanesOid().fromJsonString(request.getSolicitudNovedadTCREAREXCEPCIONptpagrPlan())));
        request.setSolicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance(novedadSrv.getByOIDWithHV(new NovedadOid().fromJsonString(request.getSolicitudNovedadTCREAREXCEPCIONptpagrNovedad())));
        request.setSolicitudNovedadTCREAREXCEPCIONptpagrCausalInstance(causalSrv.getByOIDWithHV(new CausalOid().fromJsonString(request.getSolicitudNovedadTCREAREXCEPCIONptpagrCausal())));
        request.setSolicitudNovedadTCREAREXCEPCIONptProductoInstance(productosSrv.getByOIDWithHV(new ProductosOid().fromJsonString(request.getSolicitudNovedadTCREAREXCEPCIONptProducto())));
        request.setSolicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance(tipoNovedadSrv.getByOIDWithHV(new TipoNovedadOid().fromJsonString(request.getSolicitudNovedadTCREAREXCEPCIONptTipoNovedad())));
        request.setSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos()));
        request.setSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcionInstance(motivoExcepcionSolNovSrv.getByOIDWithHV(new MotivoExcepcionSolNovOid().fromJsonString(request.getSolicitudNovedadTCREAREXCEPCIONpagrMotivoExcepcion())));
        return solicitudNovedadSrv.tCREAREXCEPCIONImplementation(request);
    }

    /*
     * Implements service TCREAREXCEPCION
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse tCREAREXCEPCIONImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONRequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREAREXCEPCIONResponse();
        Planes solicitudNovedadTCREAREXCEPCIONptpagrPlan = request.getSolicitudNovedadTCREAREXCEPCIONptpagrPlanInstance();
        Novedad solicitudNovedadTCREAREXCEPCIONptpagrNovedad = request.getSolicitudNovedadTCREAREXCEPCIONptpagrNovedadInstance();
        Causal solicitudNovedadTCREAREXCEPCIONptpagrCausal = request.getSolicitudNovedadTCREAREXCEPCIONptpagrCausalInstance();
        Date solicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia = request.getSolicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia();
        String solicitudNovedadTCREAREXCEPCIONptpatrNumContrato = request.getSolicitudNovedadTCREAREXCEPCIONptpatrNumContrato();
        Productos solicitudNovedadTCREAREXCEPCIONptProducto = request.getSolicitudNovedadTCREAREXCEPCIONptProductoInstance();
        TipoNovedad solicitudNovedadTCREAREXCEPCIONptTipoNovedad = request.getSolicitudNovedadTCREAREXCEPCIONptTipoNovedadInstance();
        ProteccionDatos solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos = request.getSolicitudNovedadTCREAREXCEPCIONptpagrProteccionDatosInstance();

        request.checkArguments();
        SolicitudNovedad instance;

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTRequest step1Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTRequest();
        step1Request.setSolicitudNovedadTCREARINTptpagrPlanInstance(solicitudNovedadTCREAREXCEPCIONptpagrPlan);
        step1Request.setSolicitudNovedadTCREARINTptpagrNovedadInstance(solicitudNovedadTCREAREXCEPCIONptpagrNovedad);
        step1Request.setSolicitudNovedadTCREARINTptpagrCausalInstance(solicitudNovedadTCREAREXCEPCIONptpagrCausal);
        step1Request.setSolicitudNovedadTCREARINTptpatrFechaVigencia(solicitudNovedadTCREAREXCEPCIONptpatrFechaVigencia);
        step1Request.setSolicitudNovedadTCREARINTptpatrNumContrato(solicitudNovedadTCREAREXCEPCIONptpatrNumContrato);
        step1Request.setSolicitudNovedadTCREARINTptProductoInstance(solicitudNovedadTCREAREXCEPCIONptProducto);
        step1Request.setSolicitudNovedadTCREARINTptTipoNovedadInstance(solicitudNovedadTCREAREXCEPCIONptTipoNovedad);
        step1Request.setSolicitudNovedadTCREARINTptpagrProteccionDatosInstance(solicitudNovedadTCREAREXCEPCIONptpagrProteccionDatos);
        step1Request.setSolicitudNovedadTCREARINTptpatrExcepcion(Boolean.FALSE);
        step1Request.setSolicitudNovedadTCREARINTpagrMotivoExcepcionInstance(null);
        step1Request.setSolicitudNovedadTCREARINTpatrFechaIniExcepcion(null);
        step1Request.setSolicitudNovedadTCREARINTpatrFechaFinExcepcion(null);
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARINTResponse step1Response = solicitudNovedadSrv.tCREARINTImplementation(step1Request);
        instance = (SolicitudNovedad) step1Response.getInstance();
        response.setSolicitudNovedadTCREAREXCEPCIONoaSolicitudInstance(step1Response.getSolicitudNovedadTCREARINToaSolicitudInstance());

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        // Value expressions for outgoing argument 'solicitudNovedadTCREAREXCEPCIONoaSolicitud'
        // DEFAULT  : THIS
        response.setSolicitudNovedadTCREAREXCEPCIONoaSolicitudInstance(instance);


        return response;
    }

    // Service: TCREARPERSONACORE

    /*
     * Entry point for service TCREARPERSONACORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse tCREARPERSONACORE(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACORERequest request) {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse();
        try {
            response = solicitudNovedadSrv.tCREARPERSONACORETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARPERSONACORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse tCREARPERSONACORETxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACORERequest request) throws ModelException {
        request.setSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad()));
        request.setSolicitudNovedadTCREARPERSONACOREptNovedadCTInstance(novedadCTSrv.getByOIDWithHV(request.getSolicitudNovedadTCREARPERSONACOREptNovedadCT()));
        return solicitudNovedadSrv.tCREARPERSONACOREImplementation(request);
    }

    /*
     * Implements service TCREARPERSONACORE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse tCREARPERSONACOREImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACORERequest request) throws ModelException {
        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse response = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCREARPERSONACOREResponse();
        Long solicitudNovedadTCREARPERSONACOREptNumErrores = request.getSolicitudNovedadTCREARPERSONACOREptNumErrores();
        SolicitudNovedad solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad = request.getSolicitudNovedadTCREARPERSONACOREpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad;

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AddTextoObservacionesRequest step1Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AddTextoObservacionesRequest();
        step1Request.setSolicitudNovedadaddTextoObservacionespthisSolicitudNovedadInstance(solicitudNovedadTCREARPERSONACOREpthisSolicitudNovedad);
        step1Request.setSolicitudNovedadaddTextoObservacionesptTexto("CAMBIO MANUAL");
        solicitudNovedadSrv.addTextoObservacionesImplementation(step1Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        // Value expressions for outgoing argument 'solicitudNovedadTCREARPERSONACOREoaNumErrores'
        // DEFAULT  : ptNumErrores
        response.setSolicitudNovedadTCREARPERSONACOREoaNumErrores(solicitudNovedadTCREARPERSONACOREptNumErrores);


        return response;
    }

    // Service: TCAMBIARESTADODOC

    /*
     * Entry point for service TCAMBIARESTADODOC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCAMBIARESTADODOC(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tCAMBIARESTADODOCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCAMBIARESTADODOC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCAMBIARESTADODOCTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad()));
        return solicitudNovedadSrv.tCAMBIARESTADODOCImplementation(request);
    }

    /*
     * Implements service TCAMBIARESTADODOC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCAMBIARESTADODOCImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long solicitudNovedadTCAMBIARESTADODOCptEstadoDoc = request.getSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc();
        SolicitudNovedad solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad = request.getSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad;

        /* Action 1: IF (ptEstadoDoc = 1) */
        boolean ifCondition1 = (solicitudNovedadTCAMBIARESTADODOCptEstadoDoc).equals(Long.valueOf(1));
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFARequest step10Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFARequest();
            step10Request.setSolicitudNovedadasignarFApthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad);
            solicitudNovedadSrv.asignarFAImplementation(step10Request);
        }

        /* Action 2: IF (EstadoDocumentacion <> ptEstadoDoc) */
        boolean ifCondition2 = !(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstadoDocumentacion()).equals(solicitudNovedadTCAMBIARESTADODOCptEstadoDoc);
        if (ifCondition2) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFUGRequest step20Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFUGRequest();
            step20Request.setSolicitudNovedadasignarFUGpthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad);
            solicitudNovedadSrv.asignarFUGImplementation(step20Request);
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest step21Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.CambiarEstadoDocRequest();
            step21Request.setSolicitudNovedadcambiarEstadoDocpthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad);
            step21Request.setSolicitudNovedadcambiarEstadoDocpeEstadoDoc(solicitudNovedadTCAMBIARESTADODOCptEstadoDoc);
            solicitudNovedadSrv.cambiarEstadoDocImplementation(step21Request);
            com.keralty.aenovedades.viewmodel.logestadosn.siu.TCREARRequest step22Request = new com.keralty.aenovedades.viewmodel.logestadosn.siu.TCREARRequest();
            step22Request.setLogEstadoSNTCREARptpagrSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad);
            step22Request.setLogEstadoSNTCREARptpatrEstado(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstado());
            step22Request.setLogEstadoSNTCREARptpatrEstadoDoc(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstadoDocumentacion());
            logEstadoSNSrv.tCREARImplementation(step22Request);
            /* Action 23: IF (EXIST (UsrAfiliacion) = false AND (Estado = 0 OR Estado = 1 OR Estado = 2 OR Estado = 3 OR Estado = 5)) */
            boolean ifCondition23 = repository.assocOperator039(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad).equals(false) && ((solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(0)) || (solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(1)) || (solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(2)) || (solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(3)) || (solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(5)));
            if (ifCondition23) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGAUTOUSRAFILIRequest step230Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGAUTOUSRAFILIRequest();
                step230Request.setSolicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad);
                step230Request.setSolicitudNovedadTASGAUTOUSRAFILIptFuncionarioInstance(userFunctionsSrv.fugetFuncionarioPorIdFun(userFunctionsSrv.fuCallSPgetusugrabadornovFun(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadId())));
                solicitudNovedadSrv.tASGAUTOUSRAFILIImplementation(step230Request);
            }
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTERMINADARequest step24Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTERMINADARequest();
            step24Request.setSolicitudNovedadTMARCARTERMINADApthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad);
            solicitudNovedadSrv.tMARCARTERMINADAImplementation(step24Request);
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarPrioridadRequest step25Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarPrioridadRequest();
            step25Request.setSolicitudNovedadasignarPrioridadpthisSolicitudNovedadInstance(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad);
            step25Request.setSolicitudNovedadasignarPrioridadpePrioridad(userFunctionsSrv.fugetPrioridadFun(solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstado(), solicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedad.getSolicitudNovedadEstadoDocumentacion()));
            solicitudNovedadSrv.asignarPrioridadImplementation(step25Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TASGAUTOUSRAFILI

    /*
     * Entry point for service TASGAUTOUSRAFILI
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tASGAUTOUSRAFILI(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGAUTOUSRAFILIRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tASGAUTOUSRAFILITxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TASGAUTOUSRAFILI
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tASGAUTOUSRAFILITxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGAUTOUSRAFILIRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedad()));
        request.setSolicitudNovedadTASGAUTOUSRAFILIptFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadTASGAUTOUSRAFILIptFuncionario()));
        return solicitudNovedadSrv.tASGAUTOUSRAFILIImplementation(request);
    }

    /*
     * Implements service TASGAUTOUSRAFILI
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tASGAUTOUSRAFILIImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGAUTOUSRAFILIRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Funcionario solicitudNovedadTASGAUTOUSRAFILIptFuncionario = request.getSolicitudNovedadTASGAUTOUSRAFILIptFuncionarioInstance();
        SolicitudNovedad solicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedad = request.getSolicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedad;

        /* Action 1: IF (ptFuncionario <> NULL) */
        boolean ifCondition1 = (solicitudNovedadTASGAUTOUSRAFILIptFuncionario != null && !solicitudNovedadTASGAUTOUSRAFILIptFuncionario.isNull());
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGUSRAFILIRequest step10Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGUSRAFILIRequest();
            step10Request.setSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance(solicitudNovedadTASGAUTOUSRAFILIpthisSolicitudNovedad);
            step10Request.setSolicitudNovedadTASGUSRAFILIptFuncionarioInstance(solicitudNovedadTASGAUTOUSRAFILIptFuncionario);
            solicitudNovedadSrv.tASGUSRAFILIImplementation(step10Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TASGUSRAFILI

    /*
     * Entry point for service TASGUSRAFILI
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tASGUSRAFILI(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGUSRAFILIRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tASGUSRAFILITxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TASGUSRAFILI
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tASGUSRAFILITxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGUSRAFILIRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedad()));
        request.setSolicitudNovedadTASGUSRAFILIptFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadTASGUSRAFILIptFuncionario()));
        return solicitudNovedadSrv.tASGUSRAFILIImplementation(request);
    }

    /*
     * Implements service TASGUSRAFILI
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tASGUSRAFILIImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGUSRAFILIRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Funcionario solicitudNovedadTASGUSRAFILIptFuncionario = request.getSolicitudNovedadTASGUSRAFILIptFuncionarioInstance();
        SolicitudNovedad solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad = request.getSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad;

        /* Action 1: IF (UsrAfiliacion <> ptFuncionario) */
        boolean ifCondition1 = !(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getUsrAfiliacion().equalsObject(solicitudNovedadTASGUSRAFILIptFuncionario));
        if (ifCondition1) {
            /* Action 10: IF (EXIST (UsrAfiliacion) = true) */
            boolean ifCondition10 = repository.assocOperator041(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad).equals(true);
            if (ifCondition10) {
                /* Action 100: IF (FechaTerminada = NULL) */
                boolean ifCondition100 = solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getSolicitudNovedadFechaTerminada() == null;
                if (ifCondition100) {
                    com.keralty.aenovedades.viewmodel.funcionario.siu.SolicitudTerminadaRequest step1000Request = new com.keralty.aenovedades.viewmodel.funcionario.siu.SolicitudTerminadaRequest();
                    step1000Request.setFuncionariosolicitudTerminadapthisFuncionarioInstance(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getUsrAfiliacion());
                    funcionarioSrv.solicitudTerminadaImplementation(step1000Request);
                }
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest step101Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest();
                step101Request.setSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad);
                step101Request.setSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getUsrAfiliacion());
                solicitudNovedadSrv.delSolNovUsrAfiliacionImplementation(step101Request, true);
            }
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest step11Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest();
            step11Request.setSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad);
            step11Request.setSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance(solicitudNovedadTASGUSRAFILIptFuncionario);
            solicitudNovedadSrv.insSolNovUsrAfiliacionImplementation(step11Request, true);
            /* Action 12: IF (FechaTerminada = NULL) */
            boolean ifCondition12 = solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getSolicitudNovedadFechaTerminada() == null;
            if (ifCondition12) {
                com.keralty.aenovedades.viewmodel.funcionario.siu.SolicitudAsignadaRequest step120Request = new com.keralty.aenovedades.viewmodel.funcionario.siu.SolicitudAsignadaRequest();
                step120Request.setFuncionariosolicitudAsignadapthisFuncionarioInstance(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getUsrAfiliacion());
                funcionarioSrv.solicitudAsignadaImplementation(step120Request);
            }
            com.keralty.aenovedades.viewmodel.logusrsolnov.siu.TCREARRequest step13Request = new com.keralty.aenovedades.viewmodel.logusrsolnov.siu.TCREARRequest();
            step13Request.setLogUsrSolNovTCREARptpagrSolicitudNovedadInstance(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad);
            step13Request.setLogUsrSolNovTCREARptpatrUsuario(solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getUsrAfiliacion().getFuncionarioUsuarioLDAP());
            logUsrSolNovSrv.tCREARImplementation(step13Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TMARCARTERMINADA

    /*
     * Entry point for service TMARCARTERMINADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMARCARTERMINADA(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTERMINADARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tMARCARTERMINADATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMARCARTERMINADA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMARCARTERMINADATxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTERMINADARequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTMARCARTERMINADApthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTMARCARTERMINADApthisSolicitudNovedad()));
        return solicitudNovedadSrv.tMARCARTERMINADAImplementation(request);
    }

    /*
     * Implements service TMARCARTERMINADA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMARCARTERMINADAImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTERMINADARequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad = request.getSolicitudNovedadTMARCARTERMINADApthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad;

        /* Action 1: IF (FechaTerminada = NULL AND Estado = 4 OR (EstadoDocumentacion = 2 AND (Estado = 2 OR Estado = 3))) */
        boolean ifCondition1 = solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad.getSolicitudNovedadFechaTerminada() == null && (solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(4)) || ((solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad.getSolicitudNovedadEstadoDocumentacion()).equals(Long.valueOf(2)) && ((solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(2)) || (solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad.getSolicitudNovedadEstado()).equals(Long.valueOf(3))));
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFechaTerminadaRequest step10Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.AsignarFechaTerminadaRequest();
            step10Request.setSolicitudNovedadasignarFechaTerminadapthisSolicitudNovedadInstance(solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad);
            solicitudNovedadSrv.asignarFechaTerminadaImplementation(step10Request);
            /* Action 11: IF (EXIST (UsrAfiliacion) = true) */
            boolean ifCondition11 = repository.assocOperator043(solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad).equals(true);
            if (ifCondition11) {
                com.keralty.aenovedades.viewmodel.funcionario.siu.SolicitudTerminadaRequest step110Request = new com.keralty.aenovedades.viewmodel.funcionario.siu.SolicitudTerminadaRequest();
                step110Request.setFuncionariosolicitudTerminadapthisFuncionarioInstance(solicitudNovedadTMARCARTERMINADApthisSolicitudNovedad.getUsrAfiliacion());
                funcionarioSrv.solicitudTerminadaImplementation(step110Request);
            }
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TREASIGNARUSUARIOS

    /*
     * Entry point for service TREASIGNARUSUARIOS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tREASIGNARUSUARIOS(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tREASIGNARUSUARIOSTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TREASIGNARUSUARIOS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tREASIGNARUSUARIOSTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad()));
        request.setSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion()));
        return solicitudNovedadSrv.tREASIGNARUSUARIOSImplementation(request);
    }

    /*
     * Implements service TREASIGNARUSUARIOS
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tREASIGNARUSUARIOSImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Funcionario solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion = request.getSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance();
        SolicitudNovedad solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad = request.getSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad;

        /* Action 1: IF (ptUsrAfiliacion <> NULL AND UsrAfiliacion <> ptUsrAfiliacion) */
        boolean ifCondition1 = (solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion != null && !solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion.isNull()) && !(solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad.getUsrAfiliacion().equalsObject(solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion));
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGUSRAFILIRequest step10Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TASGUSRAFILIRequest();
            step10Request.setSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance(solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad);
            step10Request.setSolicitudNovedadTASGUSRAFILIptFuncionarioInstance(solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion);
            solicitudNovedadSrv.tASGUSRAFILIImplementation(step10Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TCALCESTADODOCU

    /*
     * Entry point for service TCALCESTADODOCU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCALCESTADODOCU(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tCALCESTADODOCUTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCALCESTADODOCU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCALCESTADODOCUTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad()));
        return solicitudNovedadSrv.tCALCESTADODOCUImplementation(request);
    }

    /*
     * Implements service TCALCESTADODOCU
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCALCESTADODOCUImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad = request.getSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad;

        /* Action 1: IF (COUNT (Documentos) = 0) */
        boolean ifCondition1 = (repository.assocOperator047(solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad)).equals(Long.valueOf(0));
        if (ifCondition1) {
            /* Action 10: IF (DrvExigeDocPersona = false AND DrvExigeDocSolicitud = false) */
            boolean ifCondition10 = solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad.getSolicitudNovedadDrvExigeDocPersona().equals(false) && solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad.getSolicitudNovedadDrvExigeDocSolicitud().equals(false);
            if (ifCondition10) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest step100Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest();
                step100Request.setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance(solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad);
                step100Request.setSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc(Long.valueOf(2));
                solicitudNovedadSrv.tCAMBIARESTADODOCImplementation(step100Request);
            }
        } else {
            /* Action 11: IF (COUNT (Documentos) WHERE (Documentos.Estado = 1) > 0) */
            boolean ifCondition11 = repository.assocOperator048(solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad) > Long.valueOf(0);
            if (ifCondition11) {
                com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest step110Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest();
                step110Request.setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance(solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad);
                step110Request.setSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc(Long.valueOf(1));
                solicitudNovedadSrv.tCAMBIARESTADODOCImplementation(step110Request);
            } else {
                /* Action 111: IF (COUNT (Documentos) WHERE (Documentos.Estado = 3) > 0) */
                boolean ifCondition111 = repository.assocOperator049(solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad) > Long.valueOf(0);
                if (ifCondition111) {
                    com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest step1110Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest();
                    step1110Request.setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance(solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad);
                    step1110Request.setSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc(Long.valueOf(3));
                    solicitudNovedadSrv.tCAMBIARESTADODOCImplementation(step1110Request);
                } else {
                    com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest step1111Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCAMBIARESTADODOCRequest();
                    step1111Request.setSolicitudNovedadTCAMBIARESTADODOCpthisSolicitudNovedadInstance(solicitudNovedadTCALCESTADODOCUpthisSolicitudNovedad);
                    step1111Request.setSolicitudNovedadTCAMBIARESTADODOCptEstadoDoc(Long.valueOf(2));
                    solicitudNovedadSrv.tCAMBIARESTADODOCImplementation(step1111Request);
                }
            }
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: TFIRMAR

    /*
     * Entry point for service TFIRMAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tFIRMAR(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TFIRMARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.tFIRMARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TFIRMAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tFIRMARTxn(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TFIRMARRequest request) throws ModelException, SystemException {
        request.setSolicitudNovedadTFIRMARpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadTFIRMARpthisSolicitudNovedad()));
        return solicitudNovedadSrv.tFIRMARImplementation(request);
    }

    /*
     * Implements service TFIRMAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tFIRMARImplementation(
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TFIRMARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        byte[] solicitudNovedadTFIRMARptpatrImagenFirma = request.getSolicitudNovedadTFIRMARptpatrImagenFirma();
        String solicitudNovedadTFIRMARptpatrLatitud = request.getSolicitudNovedadTFIRMARptpatrLatitud();
        String solicitudNovedadTFIRMARptpatrLongitud = request.getSolicitudNovedadTFIRMARptpatrLongitud();
        SolicitudNovedad solicitudNovedadTFIRMARpthisSolicitudNovedad = request.getSolicitudNovedadTFIRMARpthisSolicitudNovedadInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadTFIRMARpthisSolicitudNovedad;

        /* Action 1: IF (EXIST (Firma) = false) */
        boolean ifCondition1 = repository.assocOperator051(solicitudNovedadTFIRMARpthisSolicitudNovedad).equals(false);
        if (ifCondition1) {
            com.keralty.aenovedades.viewmodel.firma.siu.TCREARSOLNOVRequest step10Request = new com.keralty.aenovedades.viewmodel.firma.siu.TCREARSOLNOVRequest();
            step10Request.setFirmaTCREARSOLNOVptpagrSolicitudNovedadInstance(solicitudNovedadTFIRMARpthisSolicitudNovedad);
            step10Request.setFirmaTCREARSOLNOVptpatrImagenFirma(solicitudNovedadTFIRMARptpatrImagenFirma);
            step10Request.setFirmaTCREARSOLNOVptpatrLatitud(solicitudNovedadTFIRMARptpatrLatitud);
            step10Request.setFirmaTCREARSOLNOVptpatrLongitud(solicitudNovedadTFIRMARptpatrLongitud);
            firmaSrv.tCREARSOLNOVImplementation(step10Request);
        } else {
            com.keralty.aenovedades.viewmodel.firma.siu.ModificarRequest step11Request = new com.keralty.aenovedades.viewmodel.firma.siu.ModificarRequest();
            step11Request.setFirmamodificarpthisFirmaInstance(solicitudNovedadTFIRMARpthisSolicitudNovedad.getFirma());
            step11Request.setFirmamodificarpImagenFirma(solicitudNovedadTFIRMARptpatrImagenFirma);
            step11Request.setFirmamodificarpLatitud(solicitudNovedadTFIRMARptpatrLatitud);
            step11Request.setFirmamodificarpLongitud(solicitudNovedadTFIRMARptpatrLongitud);
            firmaSrv.modificarImplementation(step11Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(AsesorConstants.CLASS_NAME)) applyHVFilter4Asesor(sql, disjunction);
        if (getAgentRoles().contains(AfiliacionesConstants.CLASS_NAME)) applyHVFilter4Afiliaciones(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4Asesor(SQLSelect sql, SQLWhereDisjunction disjunction) throws SystemException{
        // (Agente = agent OR Agente.CodJefe = Agent.Usuario OR EXIST (UsrAfiliacion) WHERE (UsrAfiliacion = agent) = true)
        Asesor agentInstance = getAgentAsesor();
    {
        // 'or' Logical operator
        SQLWhereDisjunction comparison1 = new SQLWhereDisjunction();
    
        // Operand 1
        {
            // 'or' Logical operator
            SQLWhereDisjunction comparison2 = new SQLWhereDisjunction();
        
            // Operand 1
                // '=' Comparison
                SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                comparison3.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathInstance operand114 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_AGENTE, FuncionarioConstants.CLASS_NAME);
                comparison3.setFirstOperand(operand114);
                
                // Operand 2
                SQLWhereOperandOVParameter operand225 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
                comparison3.setSecondOperand(operand225);
                comparison2.addOperand(comparison3);
        
            // Operand 2
                // '=' Comparison
                SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
                comparison5.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_AGENTE + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
                comparison5.setFirstOperand(operand116);
                
                // Operand 2
                comparison5.setSecondOperand(new SQLWhereOperandLiteral(agentInstance.getFuncionarioUsuario(), Constants.Type.STRING.getTypeName()));
                comparison2.addOperand(comparison5);
            
            comparison1.addOperand(comparison2);
        }
    
        // Operand 2
        // 'exist' Association operator
        SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(sql));
        comparison1.addOperand(operandSubQueryAssocOperator000);
        
        disjunction.addOperand(comparison1);
    }

    }

    private void applyHVFilter4Afiliaciones(SQLSelect sql, SQLWhereDisjunction disjunction) throws SystemException{
        // UsrAfiliacion = agent AND COUNT (PlanT.Afiliaciones) WHERE (PlanT.Afiliaciones = agent) > 0
        Afiliaciones agentInstance = getAgentAfiliaciones();
    {
        // 'and' Logical operator
        SQLWhereConjunction comparison1 = new SQLWhereConjunction();
    
        // Operand 1
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, FuncionarioConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AfiliacionesConstants.CLASS_NAME, AfiliacionesConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
            comparison2.setSecondOperand(operand224);
            comparison1.addOperand(comparison2);
    
        // Operand 2
            // '>' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator(">");
            
            // Operand 1
                // 'count' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator001 = new SQLWhereOperandSubQuery(repository.assocOperator001Range1Query(sql));
            comparison4.setFirstOperand(operandSubQueryAssocOperator001);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
            comparison1.addOperand(comparison4);
        
        disjunction.addOperand(comparison1);
    }

    }


    private void suppInfo4ICSolicitudNovedad(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADDRVNUMRADICADOSTR, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            conjunction.addDisjunction(disjunction);
            select.addConjunction(conjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCSolicitudPrioridadFechas(queryRequest, select);
        applyOCOCSolNovFechaFAPrioridad(queryRequest, select);
        applyOCOCSolNovFechaCreacion(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_FIELD_SOLICITUDNOVEDADID, false), true);
    }


    private void applyOCOCSolicitudPrioridadFechas(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Solicitud_PrioridadFechas".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADPRIORIDAD, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACOMPLETADA, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHAULTIMODOC, false), true);
        }
    }


    private void applyOCOCSolNovFechaFAPrioridad(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_SolNov_FechaFA_Prioridad".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHAFA, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADPRIORIDAD, false), true);
        }
    }


    private void applyOCOCSolNovFechaCreacion(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_SolNov_FechaCreacion".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, false), false);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildSolicitudNovedadRelatedInstance(relatedInstanceJsonOid);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_FAMILIAS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4DocumentoNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_LOGESTADOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4LogEstadoSN(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_LOGUSRSOLNOV.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4LogUsrSolNov(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_PLANT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_NOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Novedad(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_CAUSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Causal(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_PROTECCIONDATOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4ProteccionDatos(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_TIPOIDENTCONTRATANTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_ESTADOCONTRATO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4EstadoContrato(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_GRUPOASOCIADO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4GrupoAsociado(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_PERIODICIDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || SolicitudNovedadConstants.ROLE_NAME_PERIODICIDADNUEVA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Periodicidad(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_AGENTE.equalsIgnoreCase(relatedInstancePathFirstItem) || SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_MOTIVOEXCEPCION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4MotivoExcepcionSolNov(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildSolicitudNovedadRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): FamiliaNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4DocumentoNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DocumentoNovedad(mapper.readValue(relatedInstanceJsonOid, DocumentoNovedadOid.class)): DocumentoNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4LogEstadoSN(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogEstadoSN(mapper.readValue(relatedInstanceJsonOid, LogEstadoSNOid.class)): LogEstadoSN.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4LogUsrSolNov(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogUsrSolNov(mapper.readValue(relatedInstanceJsonOid, LogUsrSolNovOid.class)): LogUsrSolNov.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Novedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Novedad(mapper.readValue(relatedInstanceJsonOid, NovedadOid.class)): Novedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Causal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Causal(mapper.readValue(relatedInstanceJsonOid, CausalOid.class)): Causal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4ProteccionDatos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ProteccionDatos(mapper.readValue(relatedInstanceJsonOid, ProteccionDatosOid.class)): ProteccionDatos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4EstadoContrato(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoContrato(mapper.readValue(relatedInstanceJsonOid, EstadoContratoOid.class)): EstadoContrato.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4GrupoAsociado(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsociado(mapper.readValue(relatedInstanceJsonOid, GrupoAsociadoOid.class)): GrupoAsociado.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Periodicidad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Periodicidad(mapper.readValue(relatedInstanceJsonOid, PeriodicidadOid.class)): Periodicidad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): Funcionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4MotivoExcepcionSolNov(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new MotivoExcepcionSolNov(mapper.readValue(relatedInstanceJsonOid, MotivoExcepcionSolNovOid.class)): MotivoExcepcionSolNov.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            SolicitudNovedadOid oid = new SolicitudNovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_FIELD_SOLICITUDNOVEDADID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getSolicitudNovedadId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(SolicitudNovedadService.class).error(e.getMessage());
        }
    }

}
