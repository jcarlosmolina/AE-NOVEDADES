package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.MinCardinalityException;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.PreconditionException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.AsesorConstants;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.global.EstadoBeneficiarioConstants;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.global.ParentescoConstants;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;
import com.keralty.aenovedades.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aenovedades.persistence.oid.FamiliaNovedadOid;
import com.keralty.aenovedades.persistence.oid.ParentescoOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.oid.UsuarioNovedadOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.repository.UsuarioNovedadJpaRepository;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereConjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereDisjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathInstance;
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
public class UsuarioNovedadService extends AbstractService {

    UsuarioNovedadJpaRepository repository;

    UsuarioNovedadService usuarioNovedadSrv;

    FamiliaNovedadService familiaNovedadSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    ParentescoService parentescoSrv;

    EstadoBeneficiarioService estadoBeneficiarioSrv;

    DocumentoNovedadService documentoNovedadSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    @Inject
    public UsuarioNovedadService(
            UsuarioNovedadService usuarioNovedadSrv,
            FamiliaNovedadService familiaNovedadSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            ParentescoService parentescoSrv,
            EstadoBeneficiarioService estadoBeneficiarioSrv,
            DocumentoNovedadService documentoNovedadSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            UsuarioNovedadJpaRepository repository) {
        this.usuarioNovedadSrv = usuarioNovedadSrv;
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.parentescoSrv = parentescoSrv;
        this.estadoBeneficiarioSrv = estadoBeneficiarioSrv;
        this.documentoNovedadSrv = documentoNovedadSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, UsuarioNovedadConstants.CLASS_NAME);
    }

    private List<UsuarioNovedad> solveUsuarioNovedadTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, UsuarioNovedadConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveUsuarioNovedadTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, UsuarioNovedadConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class UsuarioNovedad
     *
     * @return Population of class UsuarioNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<UsuarioNovedad> get() {
        List<UsuarioNovedad> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class UsuarioNovedad
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class UsuarioNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<UsuarioNovedad> instances = get(queryRequest);
        if(UsuarioNovedadConstants.DSICUSUARIONOVEDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICUsuarioNovedad())).collect(Collectors.toList());
        }
        if(UsuarioNovedadConstants.DSDSUSUNOVTIPOTITULAR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSUsuNovTipoTitular())).collect(Collectors.toList());
        }
        if(UsuarioNovedadConstants.DSDSUSUNOVTIPOUSUARIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSUsuNovTipoUsuario())).collect(Collectors.toList());
        }
        if(UsuarioNovedadConstants.DSDSUSUARIONOVEDADNULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSUsuarioNovedadNull())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class UsuarioNovedad that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class UsuarioNovedad matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<UsuarioNovedad> get(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveUsuarioNovedadTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveUsuarioNovedadTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveUsuarioNovedadTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveUsuarioNovedadTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of UsuarioNovedad by ID
     *
     * @param usuarioNovedadidUsuarioNovedad Identification field usuarioNovedadidUsuarioNovedad
     *
     * @return Instance of UsuarioNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioNovedad getById(Long usuarioNovedadidUsuarioNovedad) {
        return getByOID(new UsuarioNovedadOid(usuarioNovedadidUsuarioNovedad));
    }
    
    /*
     * Returns an instance of UsuarioNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioNovedad getByOID(UsuarioNovedadOid oid) {
        Optional<UsuarioNovedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of UsuarioNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public UsuarioNovedad getByOIDWithHV(UsuarioNovedadOid oid) {
        Optional<UsuarioNovedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<UsuarioNovedad> getInstanceByOid(UsuarioNovedadOid oid) {
        return oid != null && oid.getUsuarioNovedadidUsuarioNovedad() != null
               ? repository.findById(oid.getUsuarioNovedadidUsuarioNovedad())
               : Optional.empty();
    }

    /*
     * Returns an instance of UsuarioNovedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of UsuarioNovedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioNovedad getByJsonOid(String jsonOid) {
        UsuarioNovedadOid oid = new UsuarioNovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of UsuarioNovedad related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of UsuarioNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<UsuarioNovedad> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveUsuarioNovedadTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of UsuarioNovedad related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of UsuarioNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<UsuarioNovedad> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of UsuarioNovedad
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of UsuarioNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getUsuarioNovedadDynamic(UsuarioNovedadOid oid, String displaySetItems) {
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
    public String getSuppInfo(UsuarioNovedadOid oid, String dsName) {
        UsuarioNovedad instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(UsuarioNovedad instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (UsuarioNovedadConstants.DSICUSUARIONOVEDAD.equals(dsName))
            return instance.buildICUsuarioNovedad();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(UsuarioNovedad instance, String dsName) {
        if (UsuarioNovedadConstants.DSICUSUARIONOVEDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICUsuarioNovedad());
        if (UsuarioNovedadConstants.DSDSUSUNOVTIPOTITULAR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSUsuNovTipoTitular());
        if (UsuarioNovedadConstants.DSDSUSUNOVTIPOUSUARIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSUsuNovTipoUsuario());
        if (UsuarioNovedadConstants.DSDSUSUARIONOVEDADNULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSUsuarioNovedadNull());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("FamiliaNovedad_TADDTITULAR_ptUsuExistente_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1581424574464890FiltNav5(filterRequest, sql);
        if ("DocumentoNovedad_TCREARATO_ptUsuario_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1582535933952300FiltNav2(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_UsuarioNovedad".equals(filterRequest.getName()))
            suppInfo4ICUsuarioNovedad(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void clas1581424574464890FiltNav5(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        FamiliaNovedad familiaNovedadTADDTITULARpthisFamiliaNovedad = filterRequest.hasFilterVariable(FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTHISFAMILIANOVEDAD) ? familiaNovedadSrv.getByOID(new FamiliaNovedadOid().fromJsonString(toJson(filterRequest.getFilterVariable(FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTHISFAMILIANOVEDAD)))) : null;

        // FamiliaNovedad = pthisFamiliaNovedad
        if (familiaNovedadTADDTITULARpthisFamiliaNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioNovedadConstants.ROLE_NAME_FAMILIANOVEDAD, FamiliaNovedadConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTHISFAMILIANOVEDAD, FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.CLASS_NAME, familiaNovedadTADDTITULARpthisFamiliaNovedad.getOid(), FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTHISFAMILIANOVEDAD);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // Parentesco.EsTitular = false
        // '=' Comparison
        SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
        comparison2.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioNovedadConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
        comparison2.setFirstOperand(operand113);
        
        // Operand 2
        comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison2);


        // EstadoBeneficiario.EsActivo = true
        // '=' Comparison
        SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
        comparison3.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(UsuarioNovedadConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
        comparison3.setFirstOperand(operand114);
        
        // Operand 2
        comparison3.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison3);

        sql.addConjunction(conjunction);
    }

    private void clas1582535933952300FiltNav2(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SolicitudNovedad documentoNovedadTCREARATOptSolicitud = filterRequest.hasFilterVariable(DocumentoNovedadConstants.ARG_NAME_TCREARATO_DOCUMENTONOVEDADTCREARATOPTSOLICITUD) ? solicitudNovedadSrv.getByOID(new SolicitudNovedadOid().fromJsonString(toJson(filterRequest.getFilterVariable(DocumentoNovedadConstants.ARG_NAME_TCREARATO_DOCUMENTONOVEDADTCREARATOPTSOLICITUD)))) : null;

        // FamiliaNovedad.Solicitud = ptSolicitud
        if (documentoNovedadTCREARATOptSolicitud != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioNovedadConstants.ROLE_NAME_FAMILIANOVEDAD + "." + FamiliaNovedadConstants.ROLE_NAME_SOLICITUD, SolicitudNovedadConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DocumentoNovedadConstants.ARG_NAME_TCREARATO_DOCUMENTONOVEDADTCREARATOPTSOLICITUD, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.CLASS_NAME, documentoNovedadTCREARATOptSolicitud.getOid(), DocumentoNovedadConstants.ARG_NAME_TCREARATO_DOCUMENTONOVEDADTCREARATOPTSOLICITUD);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        
        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUUsuNovTipoTitular
     *
     * @param queryRequest Query request
     * @return List of viewmodels for UsuarioNovedad using displayset DSUsuNovTipoTitular that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoTitular> piuPIUUsuNovTipoTitular(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoTitular::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUUsuNovTipoTitular
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUUsuNovTipoTitular
     */
    public int getCount4PIUUsuNovTipoTitular(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUUsuNovTipoUsuario
     *
     * @param queryRequest Query request
     * @return List of viewmodels for UsuarioNovedad using displayset DSUsuNovTipoUsuario that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoUsuario> piuPIUUsuNovTipoUsuario(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoUsuario::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUUsuNovTipoUsuario
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUUsuNovTipoUsuario
     */
    public int getCount4PIUUsuNovTipoUsuario(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUUsuarioNovedadNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for UsuarioNovedad using displayset DSUsuarioNovedadNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuarioNovedadNull> piuPIUUsuarioNovedadNull(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuarioNovedadNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUUsuarioNovedadNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUUsuarioNovedadNull
     */
    public int getCount4PIUUsuarioNovedadNull(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUUsuNovTipoTitularObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for UsuarioNovedad using displayset DSUsuNovTipoTitular that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoTitular> piuPIUUsuNovTipoTitularObs(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoTitular::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUUsuNovTipoTitularObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUUsuNovTipoTitularObs
     */
    public int getCount4PIUUsuNovTipoTitularObs(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUUsuNovTipoUsuarioObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for UsuarioNovedad using displayset DSUsuNovTipoUsuario that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoUsuario> piuPIUUsuNovTipoUsuarioObs(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.usuarionovedad.ds.DSUsuNovTipoUsuario::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUUsuNovTipoUsuarioObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUUsuNovTipoUsuarioObs
     */
    public int getCount4PIUUsuNovTipoUsuarioObs(QueryRequest queryRequest) {
        return solveUsuarioNovedadTypedQuery(queryRequest).size();
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.crearTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CrearRequest request) throws ModelException {
        request.setUsuarioNovedadcrearpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcrearpagrFamiliaNovedad()));
        request.setUsuarioNovedadcrearpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadcrearpagrTipoIdentificacion()));
        request.setUsuarioNovedadcrearpagrParentescoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadcrearpagrParentesco()));
        request.setUsuarioNovedadcrearpagrEstadoBeneficiarioInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getUsuarioNovedadcrearpagrEstadoBeneficiario()));
        request.setUsuarioNovedadcrearpagrParentescoNuevoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadcrearpagrParentescoNuevo()));
        request.setUsuarioNovedadcrearpagrTipoIdentificacionCDInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadcrearpagrTipoIdentificacionCD()));
        return usuarioNovedadSrv.crearImplementation(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad usuarioNovedadcrearpagrFamiliaNovedad = request.getUsuarioNovedadcrearpagrFamiliaNovedadInstance();
        TipoIdentificacion usuarioNovedadcrearpagrTipoIdentificacion = request.getUsuarioNovedadcrearpagrTipoIdentificacionInstance();
        Parentesco usuarioNovedadcrearpagrParentesco = request.getUsuarioNovedadcrearpagrParentescoInstance();
        EstadoBeneficiario usuarioNovedadcrearpagrEstadoBeneficiario = request.getUsuarioNovedadcrearpagrEstadoBeneficiarioInstance();
        Parentesco usuarioNovedadcrearpagrParentescoNuevo = request.getUsuarioNovedadcrearpagrParentescoNuevoInstance();
        TipoIdentificacion usuarioNovedadcrearpagrTipoIdentificacionCD = request.getUsuarioNovedadcrearpagrTipoIdentificacionCDInstance();
        String usuarioNovedadcrearpatrNumIdentificacion = request.getUsuarioNovedadcrearpatrNumIdentificacion();
        String usuarioNovedadcrearpatrPrimerNombre = request.getUsuarioNovedadcrearpatrPrimerNombre();
        String usuarioNovedadcrearpatrMotivoEstado = request.getUsuarioNovedadcrearpatrMotivoEstado();
        Date usuarioNovedadcrearpatrFechaIniVigencia = request.getUsuarioNovedadcrearpatrFechaIniVigencia();
        Date usuarioNovedadcrearpatrFechaAntiguedad = request.getUsuarioNovedadcrearpatrFechaAntiguedad();
        String usuarioNovedadcrearpatrSegundoNombre = request.getUsuarioNovedadcrearpatrSegundoNombre();
        String usuarioNovedadcrearpatrPrimerApellido = request.getUsuarioNovedadcrearpatrPrimerApellido();
        String usuarioNovedadcrearpatrSegundoApellido = request.getUsuarioNovedadcrearpatrSegundoApellido();
        Long usuarioNovedadcrearpatrNumUsuario = request.getUsuarioNovedadcrearpatrNumUsuario();
        Date usuarioNovedadcrearpatrFechaNacimiento = request.getUsuarioNovedadcrearpatrFechaNacimiento();
        String usuarioNovedadcrearpatrGenero = request.getUsuarioNovedadcrearpatrGenero();

        request.checkArguments();
        UsuarioNovedad instance = new UsuarioNovedad();
        instance.add2FamiliaNovedad(usuarioNovedadcrearpagrFamiliaNovedad);

        if (usuarioNovedadcrearpagrTipoIdentificacion != null && !usuarioNovedadcrearpagrTipoIdentificacion.isNull()) {
            instance.add2TipoIdentificacion(usuarioNovedadcrearpagrTipoIdentificacion);
        }

        if (usuarioNovedadcrearpagrParentesco != null && !usuarioNovedadcrearpagrParentesco.isNull()) {
            instance.add2Parentesco(usuarioNovedadcrearpagrParentesco);
        }

        if (usuarioNovedadcrearpagrEstadoBeneficiario != null && !usuarioNovedadcrearpagrEstadoBeneficiario.isNull()) {
            instance.add2EstadoBeneficiario(usuarioNovedadcrearpagrEstadoBeneficiario);
        }

        if (usuarioNovedadcrearpagrParentescoNuevo != null && !usuarioNovedadcrearpagrParentescoNuevo.isNull()) {
            instance.add2ParentescoNuevo(usuarioNovedadcrearpagrParentescoNuevo);
        }

        if (usuarioNovedadcrearpagrTipoIdentificacionCD != null && !usuarioNovedadcrearpagrTipoIdentificacionCD.isNull()) {
            instance.add2TipoIdentificacionCD(usuarioNovedadcrearpagrTipoIdentificacionCD);
        }

        instance.setUsuarioNovedadidUsuarioNovedad(Long.valueOf(0));
        instance.setUsuarioNovedadExcluido(Boolean.FALSE);
        instance.setUsuarioNovedadContratacionRO(Boolean.FALSE);
        instance.setUsuarioNovedadProrrogaSuspension(Boolean.FALSE);
        instance.setUsuarioNovedadActivacionSuspension(Boolean.FALSE);
        instance.setUsuarioNovedadNumIdentificacion(usuarioNovedadcrearpatrNumIdentificacion);
        instance.setUsuarioNovedadPrimerNombre(usuarioNovedadcrearpatrPrimerNombre);
        instance.setUsuarioNovedadMotivoEstado(usuarioNovedadcrearpatrMotivoEstado);
        instance.setUsuarioNovedadFechaIniVigencia(usuarioNovedadcrearpatrFechaIniVigencia);
        instance.setUsuarioNovedadFechaAntiguedad(usuarioNovedadcrearpatrFechaAntiguedad);
        instance.setUsuarioNovedadSegundoNombre(usuarioNovedadcrearpatrSegundoNombre);
        instance.setUsuarioNovedadPrimerApellido(usuarioNovedadcrearpatrPrimerApellido);
        instance.setUsuarioNovedadSegundoApellido(usuarioNovedadcrearpatrSegundoApellido);
        instance.setUsuarioNovedadNumUsuario(usuarioNovedadcrearpatrNumUsuario);
        instance.setUsuarioNovedadFechaNacimiento(usuarioNovedadcrearpatrFechaNacimiento);
        instance.setUsuarioNovedadGenero(usuarioNovedadcrearpatrGenero);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.eliminarTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.EliminarRequest request) throws ModelException {
        request.setUsuarioNovedadeliminarpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadeliminarpthisUsuarioNovedad()));
        return usuarioNovedadSrv.eliminarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadeliminarpthisUsuarioNovedad = request.getUsuarioNovedadeliminarpthisUsuarioNovedadInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadeliminarpthisUsuarioNovedad;
        if(usuarioNovedadeliminarpthisUsuarioNovedad.getDocumentos().size() > 0) {
            throw new MinCardinalityException(UsuarioNovedadConstants.CLASS_ALIAS, UsuarioNovedadConstants.ROLE_ALIAS_DOCUMENTOS);
        }


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdentUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.insTipoIdentUsuNovedadTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdentUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion()));
        return usuarioNovedadSrv.insTipoIdentUsuNovedadImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdentUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance();
        TipoIdentificacion usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion = request.getUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad;

        instance.add2TipoIdentificacion(usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdentUsuNovedadRequest();
            relatedRequest.setTipoIdentificacionInsTipoIdentUsuNovedadpthisTipoIdentificacionInstance(usuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionInsTipoIdentUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedad);
            tipoIdentificacionSrv.insTipoIdentUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdentUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.delTipoIdentUsuNovedadTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdentUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion()));
        return usuarioNovedadSrv.delTipoIdentUsuNovedadImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdentUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance();
        TipoIdentificacion usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion = request.getUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad;

        instance.add2TipoIdentificacion(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdentUsuNovedadRequest();
            relatedRequest.setTipoIdentificacionDelTipoIdentUsuNovedadpthisTipoIdentificacionInstance(usuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionDelTipoIdentUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedad);
            tipoIdentificacionSrv.delTipoIdentUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: InsParentescoUsuNovedad

    /*
     * Entry point for service InsParentescoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insParentescoUsuNovedad(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.insParentescoUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsParentescoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insParentescoUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadInsParentescoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadInsParentescoUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadInsParentescoUsuNovedadpevcParentescoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadInsParentescoUsuNovedadpevcParentesco()));
        return usuarioNovedadSrv.insParentescoUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service InsParentescoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insParentescoUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadInsParentescoUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadInsParentescoUsuNovedadpthisUsuarioNovedadInstance();
        Parentesco usuarioNovedadInsParentescoUsuNovedadpevcParentesco = request.getUsuarioNovedadInsParentescoUsuNovedadpevcParentescoInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadInsParentescoUsuNovedadpthisUsuarioNovedad;

        instance.add2Parentesco(usuarioNovedadInsParentescoUsuNovedadpevcParentesco);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.parentesco.siu.InsParentescoUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.parentesco.siu.InsParentescoUsuNovedadRequest();
            relatedRequest.setParentescoInsParentescoUsuNovedadpthisParentescoInstance(usuarioNovedadInsParentescoUsuNovedadpevcParentesco);
            relatedRequest.setParentescoInsParentescoUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadInsParentescoUsuNovedadpthisUsuarioNovedad);
            parentescoSrv.insParentescoUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: DelParentescoUsuNovedad

    /*
     * Entry point for service DelParentescoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delParentescoUsuNovedad(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.delParentescoUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelParentescoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delParentescoUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadDelParentescoUsuNovedadpevcParentesco()));
        return usuarioNovedadSrv.delParentescoUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service DelParentescoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delParentescoUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance();
        Parentesco usuarioNovedadDelParentescoUsuNovedadpevcParentesco = request.getUsuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad;

        instance.add2Parentesco(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.parentesco.siu.DelParentescoUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.parentesco.siu.DelParentescoUsuNovedadRequest();
            relatedRequest.setParentescoDelParentescoUsuNovedadpthisParentescoInstance(usuarioNovedadDelParentescoUsuNovedadpevcParentesco);
            relatedRequest.setParentescoDelParentescoUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedad);
            parentescoSrv.delParentescoUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: InsEstadoBeneficiario

    /*
     * Entry point for service InsEstadoBeneficiario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insEstadoBeneficiario(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsEstadoBeneficiarioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.insEstadoBeneficiarioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsEstadoBeneficiario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insEstadoBeneficiarioTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsEstadoBeneficiarioRequest request) throws ModelException {
        request.setUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad()));
        request.setUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario()));
        return usuarioNovedadSrv.insEstadoBeneficiarioImplementation(request, true);
    }

    /*
     * Implements service InsEstadoBeneficiario
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insEstadoBeneficiarioImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsEstadoBeneficiarioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad = request.getUsuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedadInstance();
        EstadoBeneficiario usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario = request.getUsuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiarioInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad;

        instance.add2EstadoBeneficiario(usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.estadobeneficiario.siu.InsEstadoBeneficiarioRequest relatedRequest = new com.keralty.aenovedades.viewmodel.estadobeneficiario.siu.InsEstadoBeneficiarioRequest();
            relatedRequest.setEstadoBeneficiarioInsEstadoBeneficiariopthisEstadoBeneficiarioInstance(usuarioNovedadInsEstadoBeneficiariopevcEstadoBeneficiario);
            relatedRequest.setEstadoBeneficiarioInsEstadoBeneficiariopevcUsuarioNovedadInstance(usuarioNovedadInsEstadoBeneficiariopthisUsuarioNovedad);
            estadoBeneficiarioSrv.insEstadoBeneficiarioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: DelEstadoBeneficiario

    /*
     * Entry point for service DelEstadoBeneficiario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delEstadoBeneficiario(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelEstadoBeneficiarioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.delEstadoBeneficiarioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelEstadoBeneficiario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delEstadoBeneficiarioTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelEstadoBeneficiarioRequest request) throws ModelException {
        request.setUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad()));
        request.setUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario()));
        return usuarioNovedadSrv.delEstadoBeneficiarioImplementation(request, true);
    }

    /*
     * Implements service DelEstadoBeneficiario
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delEstadoBeneficiarioImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelEstadoBeneficiarioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad = request.getUsuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedadInstance();
        EstadoBeneficiario usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario = request.getUsuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiarioInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad;

        instance.add2EstadoBeneficiario(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.estadobeneficiario.siu.DelEstadoBeneficiarioRequest relatedRequest = new com.keralty.aenovedades.viewmodel.estadobeneficiario.siu.DelEstadoBeneficiarioRequest();
            relatedRequest.setEstadoBeneficiarioDelEstadoBeneficiariopthisEstadoBeneficiarioInstance(usuarioNovedadDelEstadoBeneficiariopevcEstadoBeneficiario);
            relatedRequest.setEstadoBeneficiarioDelEstadoBeneficiariopevcUsuarioNovedadInstance(usuarioNovedadDelEstadoBeneficiariopthisUsuarioNovedad);
            estadoBeneficiarioSrv.delEstadoBeneficiarioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: InsParentescoNuevoUsuNovedad

    /*
     * Entry point for service InsParentescoNuevoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insParentescoNuevoUsuNovedad(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoNuevoUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.insParentescoNuevoUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsParentescoNuevoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insParentescoNuevoUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoNuevoUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco()));
        return usuarioNovedadSrv.insParentescoNuevoUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service InsParentescoNuevoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insParentescoNuevoUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoNuevoUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance();
        Parentesco usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco = request.getUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad;

        instance.add2ParentescoNuevo(usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.parentesco.siu.InsParentescoNuevoUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.parentesco.siu.InsParentescoNuevoUsuNovedadRequest();
            relatedRequest.setParentescoInsParentescoNuevoUsuNovedadpthisParentescoInstance(usuarioNovedadInsParentescoNuevoUsuNovedadpevcParentesco);
            relatedRequest.setParentescoInsParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedad);
            parentescoSrv.insParentescoNuevoUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: DelParentescoNuevoUsuNovedad

    /*
     * Entry point for service DelParentescoNuevoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delParentescoNuevoUsuNovedad(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoNuevoUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.delParentescoNuevoUsuNovedadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelParentescoNuevoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delParentescoNuevoUsuNovedadTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoNuevoUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco()));
        return usuarioNovedadSrv.delParentescoNuevoUsuNovedadImplementation(request, true);
    }

    /*
     * Implements service DelParentescoNuevoUsuNovedad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delParentescoNuevoUsuNovedadImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoNuevoUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance();
        Parentesco usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco = request.getUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad;

        instance.add2ParentescoNuevo(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.parentesco.siu.DelParentescoNuevoUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.parentesco.siu.DelParentescoNuevoUsuNovedadRequest();
            relatedRequest.setParentescoDelParentescoNuevoUsuNovedadpthisParentescoInstance(usuarioNovedadDelParentescoNuevoUsuNovedadpevcParentesco);
            relatedRequest.setParentescoDelParentescoNuevoUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedad);
            parentescoSrv.delParentescoNuevoUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: modificarSUNumMeses

    /*
     * Entry point for service modificarSUNumMeses
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarSUNumMeses(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.modificarSUNumMesesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarSUNumMeses
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarSUNumMesesTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) throws ModelException {
        request.setUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedad()));
        return usuarioNovedadSrv.modificarSUNumMesesImplementation(request);
    }

    /*
     * Implements service modificarSUNumMeses
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarSUNumMesesImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad = request.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance();
        Long usuarioNovedadmodificarSUNumMesespSUNumMeses = request.getUsuarioNovedadmodificarSUNumMesespSUNumMeses();

        request.checkArguments();

        modificarSUNumMesesPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad;
        instance.setUsuarioNovedadSUNumMeses(usuarioNovedadmodificarSUNumMesespSUNumMeses);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    /*
     * Checks service modificarSUNumMeses preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse modificarSUNumMesesCheckPreconditions(com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedad()));
        try {
            if("Clas_1581442138112529Pre_18".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre18(request);
            if("Clas_1581442138112529Pre_19".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre19(request);
            if("Clas_1581442138112529Pre_17".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre17(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void modificarSUNumMesesPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) 
            throws ModelException {
        checkClas1581442138112529Pre18(request);
        checkClas1581442138112529Pre19(request);
        checkClas1581442138112529Pre17(request);
    }

    private void checkClas1581442138112529Pre18 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) 
            throws ModelException {
        // drvEstaActivo = TRUE

        UsuarioNovedad usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad = request.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad.getUsuarioNovedaddrvEstaActivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El usuario debe estar activo");
    }

    private void checkClas1581442138112529Pre19 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) 
            throws ModelException {
        // FamiliaNovedad.Solicitud.Novedad.AliasNovedad = "SU"

        UsuarioNovedad usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad = request.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance();
        boolean preconditionHolds = (usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("SU");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de suspensión de usuario");
    }

    private void checkClas1581442138112529Pre17 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarSUNumMesesRequest request) 
            throws ModelException {
        // pSUNumMeses >= FamiliaNovedad.Solicitud.Novedad.MinValorMeses AND pSUNumMeses <= FamiliaNovedad.Solicitud.Novedad.MaxValorMeses

        Long usuarioNovedadmodificarSUNumMesespSUNumMeses = request.getUsuarioNovedadmodificarSUNumMesespSUNumMeses();
        UsuarioNovedad usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad = request.getUsuarioNovedadmodificarSUNumMesespthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadmodificarSUNumMesespSUNumMeses >= usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadMinValorMeses() && usuarioNovedadmodificarSUNumMesespSUNumMeses <= usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadMaxValorMeses();
        if (!preconditionHolds) throw new PreconditionException("El número de meses ha de estar entre " + STDFunctions.intToStrFun(usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadMinValorMeses()) + " y " + STDFunctions.intToStrFun(usuarioNovedadmodificarSUNumMesespthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadMaxValorMeses()));
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdCDUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.insTipoIdCDUsuNovedadTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdCDUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion()));
        return usuarioNovedadSrv.insTipoIdCDUsuNovedadImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdCDUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance();
        TipoIdentificacion usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion = request.getUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad;

        instance.add2TipoIdentificacionCD(usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdCDUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.InsTipoIdCDUsuNovedadRequest();
            relatedRequest.setTipoIdentificacionInsTipoIdCDUsuNovedadpthisTipoIdentificacionInstance(usuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionInsTipoIdCDUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedad);
            tipoIdentificacionSrv.insTipoIdCDUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdCDUsuNovedadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.delTipoIdCDUsuNovedadTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdCDUsuNovedadRequest request) throws ModelException {
        request.setUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad()));
        request.setUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion()));
        return usuarioNovedadSrv.delTipoIdCDUsuNovedadImplementation(request, true);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdCDUsuNovedadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad = request.getUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance();
        TipoIdentificacion usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion = request.getUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad;

        instance.add2TipoIdentificacionCD(null);
        if (isEntryPoint) {
            com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdCDUsuNovedadRequest relatedRequest = new com.keralty.aenovedades.viewmodel.tipoidentificacion.siu.DelTipoIdCDUsuNovedadRequest();
            relatedRequest.setTipoIdentificacionDelTipoIdCDUsuNovedadpthisTipoIdentificacionInstance(usuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionDelTipoIdCDUsuNovedadpevcUsuarioNovedadInstance(usuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedad);
            tipoIdentificacionSrv.delTipoIdCDUsuNovedadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: modificarNumIdentificacion

    /*
     * Entry point for service modificarNumIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarNumIdentificacion(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarNumIdentificacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.modificarNumIdentificacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarNumIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarNumIdentificacionTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarNumIdentificacionRequest request) throws ModelException {
        request.setUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad()));
        return usuarioNovedadSrv.modificarNumIdentificacionImplementation(request);
    }

    /*
     * Implements service modificarNumIdentificacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarNumIdentificacionImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarNumIdentificacionRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad = request.getUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance();
        String usuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD = request.getUsuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedad;
        instance.setUsuarioNovedadNumIdentificacionCD(usuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: cambiarExcluido

    /*
     * Entry point for service cambiarExcluido
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarExcluido(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.cambiarExcluidoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarExcluido
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarExcluidoTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) throws ModelException {
        request.setUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedad()));
        return usuarioNovedadSrv.cambiarExcluidoImplementation(request);
    }

    /*
     * Implements service cambiarExcluido
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarExcluidoImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadcambiarExcluidopthisUsuarioNovedad = request.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance();
        Boolean usuarioNovedadcambiarExcluidoprExcluido = request.getUsuarioNovedadcambiarExcluidoprExcluido();

        request.checkArguments();

        cambiarExcluidoPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadcambiarExcluidopthisUsuarioNovedad;
        instance.setUsuarioNovedadExcluido(usuarioNovedadcambiarExcluidoprExcluido);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    /*
     * Checks service cambiarExcluido preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse cambiarExcluidoCheckPreconditions(com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedad()));
        try {
            if("Clas_1581442138112529Pre_1".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre1(request);
            if("Clas_1581442138112529Pre_2".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre2(request);
            if("Clas_1581442138112529Pre_23".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre23(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void cambiarExcluidoPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) 
            throws ModelException {
        checkClas1581442138112529Pre1(request);
        checkClas1581442138112529Pre2(request);
        checkClas1581442138112529Pre23(request);
    }

    private void checkClas1581442138112529Pre1 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) 
            throws ModelException {
        // Parentesco.EsTitular = FALSE

        UsuarioNovedad usuarioNovedadcambiarExcluidopthisUsuarioNovedad = request.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadcambiarExcluidopthisUsuarioNovedad.getParentesco().getParentescoEsTitular().equals(false);
        if (!preconditionHolds) throw new PreconditionException("No se permite excluir al titular de la familia");
    }

    private void checkClas1581442138112529Pre2 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) 
            throws ModelException {
        // drvEstaActivo = TRUE

        UsuarioNovedad usuarioNovedadcambiarExcluidopthisUsuarioNovedad = request.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadcambiarExcluidopthisUsuarioNovedad.getUsuarioNovedaddrvEstaActivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Solo se pueden excluir usuarios que estén activos");
    }

    private void checkClas1581442138112529Pre23 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarExcluidoRequest request) 
            throws ModelException {
        // FamiliaNovedad.Solicitud.Novedad.AliasNovedad = "EU"

        UsuarioNovedad usuarioNovedadcambiarExcluidopthisUsuarioNovedad = request.getUsuarioNovedadcambiarExcluidopthisUsuarioNovedadInstance();
        boolean preconditionHolds = (usuarioNovedadcambiarExcluidopthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("EU");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de tipo Exclusión de usuarios");
    }

    // Service: cambiarRO

    /*
     * Entry point for service cambiarRO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarRO(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.cambiarROTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarRO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarROTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest request) throws ModelException {
        request.setUsuarioNovedadcambiarROpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarROpthisUsuarioNovedad()));
        return usuarioNovedadSrv.cambiarROImplementation(request);
    }

    /*
     * Implements service cambiarRO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarROImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadcambiarROpthisUsuarioNovedad = request.getUsuarioNovedadcambiarROpthisUsuarioNovedadInstance();
        Boolean usuarioNovedadcambiarROprContratar = request.getUsuarioNovedadcambiarROprContratar();

        request.checkArguments();

        cambiarROPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadcambiarROpthisUsuarioNovedad;
        instance.setUsuarioNovedadContratacionRO(usuarioNovedadcambiarROprContratar);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    /*
     * Checks service cambiarRO preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse cambiarROCheckPreconditions(com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setUsuarioNovedadcambiarROpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarROpthisUsuarioNovedad()));
        try {
            if("Clas_1581442138112529Pre_3".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre3(request);
            if("Clas_1581442138112529Pre_22".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre22(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void cambiarROPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest request) 
            throws ModelException {
        checkClas1581442138112529Pre3(request);
        checkClas1581442138112529Pre22(request);
    }

    private void checkClas1581442138112529Pre3 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest request) 
            throws ModelException {
        //  drvEstaActivo = TRUE

        UsuarioNovedad usuarioNovedadcambiarROpthisUsuarioNovedad = request.getUsuarioNovedadcambiarROpthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadcambiarROpthisUsuarioNovedad.getUsuarioNovedaddrvEstaActivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El usuario debe estar activo");
    }

    private void checkClas1581442138112529Pre22 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarRORequest request) 
            throws ModelException {
        // FamiliaNovedad.Solicitud.Novedad.AliasNovedad = "RO"

        UsuarioNovedad usuarioNovedadcambiarROpthisUsuarioNovedad = request.getUsuarioNovedadcambiarROpthisUsuarioNovedadInstance();
        boolean preconditionHolds = (usuarioNovedadcambiarROpthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("RO");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de tipo Rehabilitación Oral");
    }

    // Service: cambiarPS

    /*
     * Entry point for service cambiarPS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarPS(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.cambiarPSTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarPS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarPSTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest request) throws ModelException {
        request.setUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarPSpthisUsuarioNovedad()));
        return usuarioNovedadSrv.cambiarPSImplementation(request);
    }

    /*
     * Implements service cambiarPS
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarPSImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadcambiarPSpthisUsuarioNovedad = request.getUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance();
        Boolean usuarioNovedadcambiarPSpProrroga = request.getUsuarioNovedadcambiarPSpProrroga();

        request.checkArguments();

        cambiarPSPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadcambiarPSpthisUsuarioNovedad;
        instance.setUsuarioNovedadProrrogaSuspension(usuarioNovedadcambiarPSpProrroga);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    /*
     * Checks service cambiarPS preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse cambiarPSCheckPreconditions(com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarPSpthisUsuarioNovedad()));
        try {
            if("Clas_1581442138112529Pre_6".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre6(request);
            if("Clas_1581442138112529Pre_21".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre21(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void cambiarPSPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest request) 
            throws ModelException {
        checkClas1581442138112529Pre6(request);
        checkClas1581442138112529Pre21(request);
    }

    private void checkClas1581442138112529Pre6 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = false) OR drvEstaSuspendido = true

        UsuarioNovedad usuarioNovedadcambiarPSpthisUsuarioNovedad = request.getUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || usuarioNovedadcambiarPSpthisUsuarioNovedad.getUsuarioNovedaddrvEstaSuspendido().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El usuario debe estar suspendido");
    }

    private void checkClas1581442138112529Pre21 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarPSRequest request) 
            throws ModelException {
        // FamiliaNovedad.Solicitud.Novedad.AliasNovedad = "PS"

        UsuarioNovedad usuarioNovedadcambiarPSpthisUsuarioNovedad = request.getUsuarioNovedadcambiarPSpthisUsuarioNovedadInstance();
        boolean preconditionHolds = (usuarioNovedadcambiarPSpthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("PS");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de tipo Prorroga de suspensión");
    }

    // Service: cambiarAS

    /*
     * Entry point for service cambiarAS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarAS(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.cambiarASTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarAS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarASTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest request) throws ModelException {
        request.setUsuarioNovedadcambiarASpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarASpthisUsuarioNovedad()));
        return usuarioNovedadSrv.cambiarASImplementation(request);
    }

    /*
     * Implements service cambiarAS
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarASImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadcambiarASpthisUsuarioNovedad = request.getUsuarioNovedadcambiarASpthisUsuarioNovedadInstance();
        Boolean usuarioNovedadcambiarASpActivacion = request.getUsuarioNovedadcambiarASpActivacion();

        request.checkArguments();

        cambiarASPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadcambiarASpthisUsuarioNovedad;
        instance.setUsuarioNovedadActivacionSuspension(usuarioNovedadcambiarASpActivacion);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    /*
     * Checks service cambiarAS preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse cambiarASCheckPreconditions(com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setUsuarioNovedadcambiarASpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadcambiarASpthisUsuarioNovedad()));
        try {
            if("Clas_1581442138112529Pre_7".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre7(request);
            if("Clas_1581442138112529Pre_20".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre20(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void cambiarASPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest request) 
            throws ModelException {
        checkClas1581442138112529Pre7(request);
        checkClas1581442138112529Pre20(request);
    }

    private void checkClas1581442138112529Pre7 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest request) 
            throws ModelException {
        // (AGENTAsesor <> NULL AND AGENTAsesor.VerContratoNovedad = false) OR drvEstaSuspendido = true

        UsuarioNovedad usuarioNovedadcambiarASpthisUsuarioNovedad = request.getUsuarioNovedadcambiarASpthisUsuarioNovedadInstance();
        boolean preconditionHolds = ((((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)) != null && !((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).isNull()) && ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getAsesorVerContratoNovedad().equals(false)) || usuarioNovedadcambiarASpthisUsuarioNovedad.getUsuarioNovedaddrvEstaSuspendido().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El usuario debe estar suspendido");
    }

    private void checkClas1581442138112529Pre20 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CambiarASRequest request) 
            throws ModelException {
        // FamiliaNovedad.Solicitud.Novedad.AliasNovedad = "AS"

        UsuarioNovedad usuarioNovedadcambiarASpthisUsuarioNovedad = request.getUsuarioNovedadcambiarASpthisUsuarioNovedadInstance();
        boolean preconditionHolds = (usuarioNovedadcambiarASpthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("AS");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de tipo Activacion Suspensión");
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.validarCPTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) throws ModelException {
        request.setUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadvalidarCPpthisUsuarioNovedad()));
        return usuarioNovedadSrv.validarCPImplementation(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadvalidarCPpthisUsuarioNovedad = request.getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance();

        request.checkArguments();

        validarCPPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadvalidarCPpthisUsuarioNovedad;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    private void validarCPPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        checkClas1581442138112529Pre8(request);
        checkClas1581442138112529Pre9(request);
        checkClas1581442138112529Pre10(request);
        checkClas1581442138112529Pre11(request);
    }

    private void checkClas1581442138112529Pre8 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        // drvEsElTitular = false OR COUNT( FamiliaNovedad.UsuarioNovedad ) WHERE (FamiliaNovedad.UsuarioNovedad.drvEsPadre = true AND FamiliaNovedad.UsuarioNovedad.drvEdad - drvEdad < 10) = 0

        UsuarioNovedad usuarioNovedadvalidarCPpthisUsuarioNovedad = request.getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance();
        try {
            boolean preconditionHolds = usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedaddrvEsElTitular().equals(false) || (repository.assocOperator024(usuarioNovedadvalidarCPpthisUsuarioNovedad)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("Usuario " + STDFunctions.intToStrFun(usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedadNumUsuario()) + ": " + "El titular debe tener por lo menos un diferencia de 10 años con la edad del beneficiario de parentesco PADRE");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581442138112529Pre9 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        // drvEsElTitular = false OR COUNT( FamiliaNovedad.UsuarioNovedad ) WHERE (FamiliaNovedad.UsuarioNovedad.drvEsHijo = true AND drvEdad - FamiliaNovedad.UsuarioNovedad.drvEdad < 10) = 0

        UsuarioNovedad usuarioNovedadvalidarCPpthisUsuarioNovedad = request.getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance();
        try {
            boolean preconditionHolds = usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedaddrvEsElTitular().equals(false) || (repository.assocOperator025(usuarioNovedadvalidarCPpthisUsuarioNovedad)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("Usuario " + STDFunctions.intToStrFun(usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedadNumUsuario()) + ": " + "El titular debe tener por lo menos un diferencia de 10 años con la edad del beneficiario de parentesco HIJO");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581442138112529Pre10 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        // drvEsElTitular = false OR COUNT( FamiliaNovedad.UsuarioNovedad ) WHERE (FamiliaNovedad.UsuarioNovedad.drvEsConyuge = true AND Genero = FamiliaNovedad.UsuarioNovedad.Genero) = 0

        UsuarioNovedad usuarioNovedadvalidarCPpthisUsuarioNovedad = request.getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance();
        try {
            boolean preconditionHolds = usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedaddrvEsElTitular().equals(false) || (repository.assocOperator026(usuarioNovedadvalidarCPpthisUsuarioNovedad)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("Usuario " + STDFunctions.intToStrFun(usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedadNumUsuario()) + ": " + "Los beneficiarios con parentesco CONYUGE deben tener sexo distinto al del TITULAR");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    private void checkClas1581442138112529Pre11 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ValidarCPRequest request) 
            throws ModelException {
        // drvEsConyuge = FALSE OR drvEdad >= 13

        UsuarioNovedad usuarioNovedadvalidarCPpthisUsuarioNovedad = request.getUsuarioNovedadvalidarCPpthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedaddrvEsConyuge().equals(false) || usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedaddrvEdad() >= Long.valueOf(13);
        if (!preconditionHolds) throw new PreconditionException("Usuario " + STDFunctions.intToStrFun(usuarioNovedadvalidarCPpthisUsuarioNovedad.getUsuarioNovedadNumUsuario()) + ": " + "La edad de los beneficiarios con parentesco CONYUGE debe ser mayor o igual a 13 años");
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.modificarTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarRequest request) throws ModelException {
        request.setUsuarioNovedadmodificarpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadmodificarpthisUsuarioNovedad()));
        return usuarioNovedadSrv.modificarImplementation(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadmodificarpthisUsuarioNovedad = request.getUsuarioNovedadmodificarpthisUsuarioNovedadInstance();
        String usuarioNovedadmodificarpNumIdentificacion = request.getUsuarioNovedadmodificarpNumIdentificacion();
        String usuarioNovedadmodificarpPrimerNombre = request.getUsuarioNovedadmodificarpPrimerNombre();
        String usuarioNovedadmodificarpSegundoNombre = request.getUsuarioNovedadmodificarpSegundoNombre();
        String usuarioNovedadmodificarpPrimerApellido = request.getUsuarioNovedadmodificarpPrimerApellido();
        String usuarioNovedadmodificarpSegundoApellido = request.getUsuarioNovedadmodificarpSegundoApellido();
        Date usuarioNovedadmodificarpFechaNacimiento = request.getUsuarioNovedadmodificarpFechaNacimiento();
        String usuarioNovedadmodificarpGenero = request.getUsuarioNovedadmodificarpGenero();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadmodificarpthisUsuarioNovedad;
        instance.setUsuarioNovedadNumIdentificacion(usuarioNovedadmodificarpNumIdentificacion);
        instance.setUsuarioNovedadPrimerNombre(usuarioNovedadmodificarpPrimerNombre);
        instance.setUsuarioNovedadSegundoNombre(usuarioNovedadmodificarpSegundoNombre);
        instance.setUsuarioNovedadPrimerApellido(usuarioNovedadmodificarpPrimerApellido);
        instance.setUsuarioNovedadSegundoApellido(usuarioNovedadmodificarpSegundoApellido);
        instance.setUsuarioNovedadFechaNacimiento(usuarioNovedadmodificarpFechaNacimiento);
        instance.setUsuarioNovedadGenero(usuarioNovedadmodificarpGenero);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

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
    public ServiceResponse tCREARDESDECORE(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARDESDECORERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.tCREARDESDECORETxn(request);
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
    public ServiceResponse tCREARDESDECORETxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARDESDECORERequest request) throws ModelException {
        request.setUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad()));
        request.setUsuarioNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion()));
        request.setUsuarioNovedadTCREARDESDECOREptpagrParentescoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadTCREARDESDECOREptpagrParentesco()));
        request.setUsuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiarioInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getUsuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario()));
        return usuarioNovedadSrv.tCREARDESDECOREImplementation(request);
    }

    /*
     * Implements service TCREARDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARDESDECOREImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARDESDECORERequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad = request.getUsuarioNovedadTCREARDESDECOREptpagrFamiliaNovedadInstance();
        TipoIdentificacion usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion = request.getUsuarioNovedadTCREARDESDECOREptpagrTipoIdentificacionInstance();
        Parentesco usuarioNovedadTCREARDESDECOREptpagrParentesco = request.getUsuarioNovedadTCREARDESDECOREptpagrParentescoInstance();
        EstadoBeneficiario usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario = request.getUsuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiarioInstance();
        String usuarioNovedadTCREARDESDECOREptpatrNumIdentificacion = request.getUsuarioNovedadTCREARDESDECOREptpatrNumIdentificacion();
        String usuarioNovedadTCREARDESDECOREptpatrPrimerNombre = request.getUsuarioNovedadTCREARDESDECOREptpatrPrimerNombre();
        String usuarioNovedadTCREARDESDECOREptpatrMotivoEstado = request.getUsuarioNovedadTCREARDESDECOREptpatrMotivoEstado();
        Date usuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia = request.getUsuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia();
        Date usuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad = request.getUsuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad();
        String usuarioNovedadTCREARDESDECOREptpatrSegundoNombre = request.getUsuarioNovedadTCREARDESDECOREptpatrSegundoNombre();
        String usuarioNovedadTCREARDESDECOREptpatrPrimerApellido = request.getUsuarioNovedadTCREARDESDECOREptpatrPrimerApellido();
        String usuarioNovedadTCREARDESDECOREptpatrSegundoApellido = request.getUsuarioNovedadTCREARDESDECOREptpatrSegundoApellido();
        Long usuarioNovedadTCREARDESDECOREptpatrNumUsuario = request.getUsuarioNovedadTCREARDESDECOREptpatrNumUsuario();
        Date usuarioNovedadTCREARDESDECOREptpatrFechaNacimiento = request.getUsuarioNovedadTCREARDESDECOREptpatrFechaNacimiento();
        String usuarioNovedadTCREARDESDECOREptpatrGenero = request.getUsuarioNovedadTCREARDESDECOREptpatrGenero();

        request.checkArguments();
        UsuarioNovedad instance;

        com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CrearRequest();
        step1Request.setUsuarioNovedadcrearpagrFamiliaNovedadInstance(usuarioNovedadTCREARDESDECOREptpagrFamiliaNovedad);
        step1Request.setUsuarioNovedadcrearpagrTipoIdentificacionInstance(usuarioNovedadTCREARDESDECOREptpagrTipoIdentificacion);
        step1Request.setUsuarioNovedadcrearpagrParentescoInstance(usuarioNovedadTCREARDESDECOREptpagrParentesco);
        step1Request.setUsuarioNovedadcrearpagrEstadoBeneficiarioInstance(usuarioNovedadTCREARDESDECOREptpagrEstadoBeneficiario);
        step1Request.setUsuarioNovedadcrearpagrParentescoNuevoInstance(null);
        step1Request.setUsuarioNovedadcrearpagrTipoIdentificacionCDInstance(null);
        step1Request.setUsuarioNovedadcrearpatrNumIdentificacion(usuarioNovedadTCREARDESDECOREptpatrNumIdentificacion);
        step1Request.setUsuarioNovedadcrearpatrPrimerNombre(usuarioNovedadTCREARDESDECOREptpatrPrimerNombre);
        step1Request.setUsuarioNovedadcrearpatrMotivoEstado(usuarioNovedadTCREARDESDECOREptpatrMotivoEstado);
        step1Request.setUsuarioNovedadcrearpatrFechaIniVigencia(usuarioNovedadTCREARDESDECOREptpatrFechaIniVigencia);
        step1Request.setUsuarioNovedadcrearpatrFechaAntiguedad(usuarioNovedadTCREARDESDECOREptpatrFechaAntiguedad);
        step1Request.setUsuarioNovedadcrearpatrSegundoNombre(usuarioNovedadTCREARDESDECOREptpatrSegundoNombre);
        step1Request.setUsuarioNovedadcrearpatrPrimerApellido(usuarioNovedadTCREARDESDECOREptpatrPrimerApellido);
        step1Request.setUsuarioNovedadcrearpatrSegundoApellido(usuarioNovedadTCREARDESDECOREptpatrSegundoApellido);
        step1Request.setUsuarioNovedadcrearpatrNumUsuario(usuarioNovedadTCREARDESDECOREptpatrNumUsuario);
        step1Request.setUsuarioNovedadcrearpatrFechaNacimiento(usuarioNovedadTCREARDESDECOREptpatrFechaNacimiento);
        step1Request.setUsuarioNovedadcrearpatrGenero(usuarioNovedadTCREARDESDECOREptpatrGenero);
        instance = (UsuarioNovedad) usuarioNovedadSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.tDELETETxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TDELETERequest request) throws ModelException, SystemException {
        request.setUsuarioNovedadTDELETEpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTDELETEpthisUsuarioNovedad()));
        return usuarioNovedadSrv.tDELETEImplementation(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TDELETERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        UsuarioNovedad usuarioNovedadTDELETEpthisUsuarioNovedad = request.getUsuarioNovedadTDELETEpthisUsuarioNovedadInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadTDELETEpthisUsuarioNovedad;

        for(DocumentoNovedad step1Entity : repository.assocOperator027(usuarioNovedadTDELETEpthisUsuarioNovedad)) {
            com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDELETERequest step1Request = new com.keralty.aenovedades.viewmodel.documentonovedad.siu.TDELETERequest();
            step1Request.setDocumentoNovedadTDELETEpthisDocumentoNovedadInstance(step1Entity);
            documentoNovedadSrv.tDELETEImplementation(step1Request);
        }

        com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest step2Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TCALCESTADODOCURequest();
        step2Request.setSolicitudNovedadTCALCESTADODOCUpthisSolicitudNovedadInstance(usuarioNovedadTDELETEpthisUsuarioNovedad.getFamiliaNovedad().getSolicitud());
        solicitudNovedadSrv.tCALCESTADODOCUImplementation(step2Request);

        com.keralty.aenovedades.viewmodel.usuarionovedad.siu.EliminarRequest step3Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.EliminarRequest();
        step3Request.setUsuarioNovedadeliminarpthisUsuarioNovedadInstance(usuarioNovedadTDELETEpthisUsuarioNovedad);
        usuarioNovedadSrv.eliminarImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    // Service: TCAMBIARPARENTESCO

    /*
     * Entry point for service TCAMBIARPARENTESCO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCAMBIARPARENTESCO(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.tCAMBIARPARENTESCOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCAMBIARPARENTESCO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCAMBIARPARENTESCOTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest request) throws ModelException, SystemException {
        request.setUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad()));
        request.setUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance(parentescoSrv.getByOIDWithHV(new ParentescoOid().fromJsonString(request.getUsuarioNovedadTCAMBIARPARENTESCOptpevcParentesco())));
        return usuarioNovedadSrv.tCAMBIARPARENTESCOImplementation(request);
    }

    /*
     * Implements service TCAMBIARPARENTESCO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCAMBIARPARENTESCOImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Parentesco usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco = request.getUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance();
        UsuarioNovedad usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad = request.getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance();

        request.checkArguments();

        tCAMBIARPARENTESCOPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad;

        /* Action 1: IF (ParentescoNuevo <> ptpevcParentesco) */
        boolean ifCondition1 = !Utilities.isEqual(usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad.getParentescoNuevo(), usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco);
        if (ifCondition1) {
            /* Action 10: IF (EXIST (ParentescoNuevo) = true) */
            boolean ifCondition10 = repository.assocOperator029(usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad).equals(true);
            if (ifCondition10) {
                com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoNuevoUsuNovedadRequest step100Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoNuevoUsuNovedadRequest();
                step100Request.setUsuarioNovedadDelParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad);
                step100Request.setUsuarioNovedadDelParentescoNuevoUsuNovedadpevcParentescoInstance(usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad.getParentescoNuevo());
                usuarioNovedadSrv.delParentescoNuevoUsuNovedadImplementation(step100Request, true);
            }
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoNuevoUsuNovedadRequest step11Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoNuevoUsuNovedadRequest();
            step11Request.setUsuarioNovedadInsParentescoNuevoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad);
            step11Request.setUsuarioNovedadInsParentescoNuevoUsuNovedadpevcParentescoInstance(usuarioNovedadTCAMBIARPARENTESCOptpevcParentesco);
            usuarioNovedadSrv.insParentescoNuevoUsuNovedadImplementation(step11Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    /*
     * Checks service TCAMBIARPARENTESCO preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tCAMBIARPARENTESCOCheckPreconditions(com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad()));
        request.setUsuarioNovedadTCAMBIARPARENTESCOptpevcParentescoInstance(parentescoSrv.getByOIDWithHV(new ParentescoOid().fromJsonString(request.getUsuarioNovedadTCAMBIARPARENTESCOptpevcParentesco())));
        try {
            if("Clas_1581442138112529Pre_13".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre13(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tCAMBIARPARENTESCOPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest request) 
            throws ModelException {
        checkClas1581442138112529Pre13(request);
    }

    private void checkClas1581442138112529Pre13 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARPARENTESCORequest request) 
            throws ModelException {
        // 
        // drvEstaActivo = TRUE

        UsuarioNovedad usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad = request.getUsuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad.getUsuarioNovedaddrvEstaActivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El usuario debe estar activo");
    }

    // Service: TCAMBIARTIPOIDENT

    /*
     * Entry point for service TCAMBIARTIPOIDENT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCAMBIARTIPOIDENT(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.tCAMBIARTIPOIDENTTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCAMBIARTIPOIDENT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCAMBIARTIPOIDENTTxn(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest request) throws ModelException, SystemException {
        request.setUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad()));
        request.setUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion())));
        return usuarioNovedadSrv.tCAMBIARTIPOIDENTImplementation(request);
    }

    /*
     * Implements service TCAMBIARTIPOIDENT
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCAMBIARTIPOIDENTImplementation(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion = request.getUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance();
        String usuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD = request.getUsuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD();
        UsuarioNovedad usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad = request.getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance();

        request.checkArguments();

        tCAMBIARTIPOIDENTPreconditions(request);
        UsuarioNovedad instance = usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad;

        /* Action 1: IF (TipoIdentificacionCD <> ptpevcTipoIdentificacion) */
        boolean ifCondition1 = !Utilities.isEqual(usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad.getTipoIdentificacionCD(), usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion);
        if (ifCondition1) {
            /* Action 10: IF (EXIST (TipoIdentificacionCD) = true) */
            boolean ifCondition10 = repository.assocOperator031(usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad).equals(true);
            if (ifCondition10) {
                com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdCDUsuNovedadRequest step100Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdCDUsuNovedadRequest();
                step100Request.setUsuarioNovedadDelTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad);
                step100Request.setUsuarioNovedadDelTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad.getTipoIdentificacionCD());
                usuarioNovedadSrv.delTipoIdCDUsuNovedadImplementation(step100Request, true);
            }
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdCDUsuNovedadRequest step11Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdCDUsuNovedadRequest();
            step11Request.setUsuarioNovedadInsTipoIdCDUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad);
            step11Request.setUsuarioNovedadInsTipoIdCDUsuNovedadpevcTipoIdentificacionInstance(usuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion);
            usuarioNovedadSrv.insTipoIdCDUsuNovedadImplementation(step11Request, true);
        }

        com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarNumIdentificacionRequest step2Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarNumIdentificacionRequest();
        step2Request.setUsuarioNovedadmodificarNumIdentificacionpthisUsuarioNovedadInstance(usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad);
        step2Request.setUsuarioNovedadmodificarNumIdentificacionpNumIdentificacionCD(usuarioNovedadTCAMBIARTIPOIDENTptpNumIdentificacionCD);
        usuarioNovedadSrv.modificarNumIdentificacionImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }

    /*
     * Checks service TCAMBIARTIPOIDENT preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tCAMBIARTIPOIDENTCheckPreconditions(com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad()));
        request.setUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getUsuarioNovedadTCAMBIARTIPOIDENTptpevcTipoIdentificacion())));
        try {
            if("Clas_1581442138112529Pre_15".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre15(request);
            if("Clas_1581442138112529Pre_16".equals(request.getPreconditionId()))
                checkClas1581442138112529Pre16(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tCAMBIARTIPOIDENTPreconditions(
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest request) 
            throws ModelException {
        checkClas1581442138112529Pre15(request);
        checkClas1581442138112529Pre16(request);
    }

    private void checkClas1581442138112529Pre15 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest request) 
            throws ModelException {
        // drvEstaActivo = TRUE

        UsuarioNovedad usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad = request.getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance();
        boolean preconditionHolds = usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad.getUsuarioNovedaddrvEstaActivo().equals(true);
        if (!preconditionHolds) throw new PreconditionException("El usuario debe estar activo");
    }

    private void checkClas1581442138112529Pre16 (
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCAMBIARTIPOIDENTRequest request) 
            throws ModelException {
        // FamiliaNovedad.Solicitud.Novedad.AliasNovedad = "CD"

        UsuarioNovedad usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad = request.getUsuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedadInstance();
        boolean preconditionHolds = (usuarioNovedadTCAMBIARTIPOIDENTpthisUsuarioNovedad.getFamiliaNovedad().getSolicitud().getNovedad().getNovedadAliasNovedad()).equals("CD");
        if (!preconditionHolds) throw new PreconditionException("La novedad no es de cambio de identificación de usuario");
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARMANUALRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.tCREARMANUALTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARMANUALRequest request) throws ModelException {
        request.setUsuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTCREARMANUALptpagrFamiliaNovedad()));
        request.setUsuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getUsuarioNovedadTCREARMANUALptpagrTipoIdentificacion()));
        request.setUsuarioNovedadTCREARMANUALptpagrParentescoInstance(parentescoSrv.getByOIDWithHV(request.getUsuarioNovedadTCREARMANUALptpagrParentesco()));
        return usuarioNovedadSrv.tCREARMANUALImplementation(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TCREARMANUALRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaNovedad usuarioNovedadTCREARMANUALptpagrFamiliaNovedad = request.getUsuarioNovedadTCREARMANUALptpagrFamiliaNovedadInstance();
        TipoIdentificacion usuarioNovedadTCREARMANUALptpagrTipoIdentificacion = request.getUsuarioNovedadTCREARMANUALptpagrTipoIdentificacionInstance();
        Parentesco usuarioNovedadTCREARMANUALptpagrParentesco = request.getUsuarioNovedadTCREARMANUALptpagrParentescoInstance();
        String usuarioNovedadTCREARMANUALptpatrNumIdentificacion = request.getUsuarioNovedadTCREARMANUALptpatrNumIdentificacion();
        String usuarioNovedadTCREARMANUALptpatrPrimerNombre = request.getUsuarioNovedadTCREARMANUALptpatrPrimerNombre();
        String usuarioNovedadTCREARMANUALptpatrSegundoNombre = request.getUsuarioNovedadTCREARMANUALptpatrSegundoNombre();
        String usuarioNovedadTCREARMANUALptpatrPrimerApellido = request.getUsuarioNovedadTCREARMANUALptpatrPrimerApellido();
        String usuarioNovedadTCREARMANUALptpatrSegundoApellido = request.getUsuarioNovedadTCREARMANUALptpatrSegundoApellido();
        Date usuarioNovedadTCREARMANUALptpatrFechaNacimiento = request.getUsuarioNovedadTCREARMANUALptpatrFechaNacimiento();
        String usuarioNovedadTCREARMANUALptpatrGenero = request.getUsuarioNovedadTCREARMANUALptpatrGenero();

        request.checkArguments();
        UsuarioNovedad instance;

        com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CrearRequest step1Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.CrearRequest();
        step1Request.setUsuarioNovedadcrearpagrFamiliaNovedadInstance(usuarioNovedadTCREARMANUALptpagrFamiliaNovedad);
        step1Request.setUsuarioNovedadcrearpagrTipoIdentificacionInstance(usuarioNovedadTCREARMANUALptpagrTipoIdentificacion);
        step1Request.setUsuarioNovedadcrearpagrParentescoInstance(usuarioNovedadTCREARMANUALptpagrParentesco);
        step1Request.setUsuarioNovedadcrearpagrEstadoBeneficiarioInstance(null);
        step1Request.setUsuarioNovedadcrearpagrParentescoNuevoInstance(null);
        step1Request.setUsuarioNovedadcrearpagrTipoIdentificacionCDInstance(null);
        step1Request.setUsuarioNovedadcrearpatrNumIdentificacion(usuarioNovedadTCREARMANUALptpatrNumIdentificacion);
        step1Request.setUsuarioNovedadcrearpatrPrimerNombre(usuarioNovedadTCREARMANUALptpatrPrimerNombre);
        step1Request.setUsuarioNovedadcrearpatrMotivoEstado(null);
        step1Request.setUsuarioNovedadcrearpatrFechaIniVigencia(null);
        step1Request.setUsuarioNovedadcrearpatrFechaAntiguedad(null);
        step1Request.setUsuarioNovedadcrearpatrSegundoNombre(usuarioNovedadTCREARMANUALptpatrSegundoNombre);
        step1Request.setUsuarioNovedadcrearpatrPrimerApellido(usuarioNovedadTCREARMANUALptpatrPrimerApellido);
        step1Request.setUsuarioNovedadcrearpatrSegundoApellido(usuarioNovedadTCREARMANUALptpatrSegundoApellido);
        step1Request.setUsuarioNovedadcrearpatrNumUsuario(Long.valueOf(1));
        step1Request.setUsuarioNovedadcrearpatrFechaNacimiento(usuarioNovedadTCREARMANUALptpatrFechaNacimiento);
        step1Request.setUsuarioNovedadcrearpatrGenero(usuarioNovedadTCREARMANUALptpatrGenero);
        instance = (UsuarioNovedad) usuarioNovedadSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TMODIFICARMANUALRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioNovedadSrv.tMODIFICARMANUALTxn(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TMODIFICARMANUALRequest request) throws ModelException, SystemException {
        request.setUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance(usuarioNovedadSrv.getByOIDWithHV(request.getUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad()));
        request.setUsuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getUsuarioNovedadTMODIFICARMANUALptTipoIdentificacion())));
        request.setUsuarioNovedadTMODIFICARMANUALptParentescoInstance(parentescoSrv.getByOIDWithHV(new ParentescoOid().fromJsonString(request.getUsuarioNovedadTMODIFICARMANUALptParentesco())));
        return usuarioNovedadSrv.tMODIFICARMANUALImplementation(request);
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
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.TMODIFICARMANUALRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String usuarioNovedadTMODIFICARMANUALptpNumIdentificacion = request.getUsuarioNovedadTMODIFICARMANUALptpNumIdentificacion();
        String usuarioNovedadTMODIFICARMANUALptpPrimerNombre = request.getUsuarioNovedadTMODIFICARMANUALptpPrimerNombre();
        String usuarioNovedadTMODIFICARMANUALptpSegundoNombre = request.getUsuarioNovedadTMODIFICARMANUALptpSegundoNombre();
        String usuarioNovedadTMODIFICARMANUALptpPrimerApellido = request.getUsuarioNovedadTMODIFICARMANUALptpPrimerApellido();
        String usuarioNovedadTMODIFICARMANUALptpSegundoApellido = request.getUsuarioNovedadTMODIFICARMANUALptpSegundoApellido();
        String usuarioNovedadTMODIFICARMANUALptpGenero = request.getUsuarioNovedadTMODIFICARMANUALptpGenero();
        Date usuarioNovedadTMODIFICARMANUALptpFechaNacimiento = request.getUsuarioNovedadTMODIFICARMANUALptpFechaNacimiento();
        TipoIdentificacion usuarioNovedadTMODIFICARMANUALptTipoIdentificacion = request.getUsuarioNovedadTMODIFICARMANUALptTipoIdentificacionInstance();
        Parentesco usuarioNovedadTMODIFICARMANUALptParentesco = request.getUsuarioNovedadTMODIFICARMANUALptParentescoInstance();
        UsuarioNovedad usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad = request.getUsuarioNovedadTMODIFICARMANUALpthisUsuarioNovedadInstance();

        request.checkArguments();
        UsuarioNovedad instance = usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad;

        com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarRequest step1Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.ModificarRequest();
        step1Request.setUsuarioNovedadmodificarpthisUsuarioNovedadInstance(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad);
        step1Request.setUsuarioNovedadmodificarpNumIdentificacion(usuarioNovedadTMODIFICARMANUALptpNumIdentificacion);
        step1Request.setUsuarioNovedadmodificarpPrimerNombre(usuarioNovedadTMODIFICARMANUALptpPrimerNombre);
        step1Request.setUsuarioNovedadmodificarpSegundoNombre(usuarioNovedadTMODIFICARMANUALptpSegundoNombre);
        step1Request.setUsuarioNovedadmodificarpPrimerApellido(usuarioNovedadTMODIFICARMANUALptpPrimerApellido);
        step1Request.setUsuarioNovedadmodificarpSegundoApellido(usuarioNovedadTMODIFICARMANUALptpSegundoApellido);
        step1Request.setUsuarioNovedadmodificarpGenero(usuarioNovedadTMODIFICARMANUALptpGenero);
        step1Request.setUsuarioNovedadmodificarpFechaNacimiento(usuarioNovedadTMODIFICARMANUALptpFechaNacimiento);
        usuarioNovedadSrv.modificarImplementation(step1Request);

        /* Action 2: IF (TipoIdentificacion <> ptTipoIdentificacion) */
        boolean ifCondition2 = !Utilities.isEqual(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad.getTipoIdentificacion(), usuarioNovedadTMODIFICARMANUALptTipoIdentificacion);
        if (ifCondition2) {
            /* Action 20: IF (EXIST (TipoIdentificacion) = true) */
            boolean ifCondition20 = repository.assocOperator034(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad).equals(true);
            if (ifCondition20) {
                com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdentUsuNovedadRequest step200Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelTipoIdentUsuNovedadRequest();
                step200Request.setUsuarioNovedadDelTipoIdentUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad);
                step200Request.setUsuarioNovedadDelTipoIdentUsuNovedadpevcTipoIdentificacionInstance(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad.getTipoIdentificacion());
                usuarioNovedadSrv.delTipoIdentUsuNovedadImplementation(step200Request, true);
            }
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdentUsuNovedadRequest step21Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsTipoIdentUsuNovedadRequest();
            step21Request.setUsuarioNovedadInsTipoIdentUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad);
            step21Request.setUsuarioNovedadInsTipoIdentUsuNovedadpevcTipoIdentificacionInstance(usuarioNovedadTMODIFICARMANUALptTipoIdentificacion);
            usuarioNovedadSrv.insTipoIdentUsuNovedadImplementation(step21Request, true);
        }

        /* Action 3: IF (Parentesco <> ptParentesco) */
        boolean ifCondition3 = !Utilities.isEqual(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad.getParentesco(), usuarioNovedadTMODIFICARMANUALptParentesco);
        if (ifCondition3) {
            /* Action 30: IF (EXIST (Parentesco) = true) */
            boolean ifCondition30 = repository.assocOperator035(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad).equals(true);
            if (ifCondition30) {
                com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoUsuNovedadRequest step300Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.DelParentescoUsuNovedadRequest();
                step300Request.setUsuarioNovedadDelParentescoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad);
                step300Request.setUsuarioNovedadDelParentescoUsuNovedadpevcParentescoInstance(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad.getParentesco());
                usuarioNovedadSrv.delParentescoUsuNovedadImplementation(step300Request, true);
            }
            com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoUsuNovedadRequest step31Request = new com.keralty.aenovedades.viewmodel.usuarionovedad.siu.InsParentescoUsuNovedadRequest();
            step31Request.setUsuarioNovedadInsParentescoUsuNovedadpthisUsuarioNovedadInstance(usuarioNovedadTMODIFICARMANUALpthisUsuarioNovedad);
            step31Request.setUsuarioNovedadInsParentescoUsuNovedadpevcParentescoInstance(usuarioNovedadTMODIFICARMANUALptParentesco);
            usuarioNovedadSrv.insParentescoUsuNovedadImplementation(step31Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICUsuarioNovedad());

        return response;
    }


    private void suppInfo4ICUsuarioNovedad(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADDRVNOMBRECOMPLETO, Constants.Type.STRING.getTypeName()));
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
        select.getOrderByPart().addItem(Constants.normalizePath(UsuarioNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.ATTR_FIELD_USUARIONOVEDADIDUSUARIONOVEDAD, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildUsuarioNovedadRelatedInstance(relatedInstanceJsonOid);
        }
        if (UsuarioNovedadConstants.ROLE_NAME_DOCUMENTOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildUsuarioNovedadRelatedInstance4DocumentoNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (UsuarioNovedadConstants.ROLE_NAME_FAMILIANOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildUsuarioNovedadRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem) || UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildUsuarioNovedadRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (UsuarioNovedadConstants.ROLE_NAME_PARENTESCO.equalsIgnoreCase(relatedInstancePathFirstItem) || UsuarioNovedadConstants.ROLE_NAME_PARENTESCONUEVO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildUsuarioNovedadRelatedInstance4Parentesco(relatedInstanceJsonOid, remainingPath);
        }
        if (UsuarioNovedadConstants.ROLE_NAME_ESTADOBENEFICIARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildUsuarioNovedadRelatedInstance4EstadoBeneficiario(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildUsuarioNovedadRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new UsuarioNovedad(mapper.readValue(relatedInstanceJsonOid, UsuarioNovedadOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildUsuarioNovedadRelatedInstance4DocumentoNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DocumentoNovedad(mapper.readValue(relatedInstanceJsonOid, DocumentoNovedadOid.class)): DocumentoNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildUsuarioNovedadRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): FamiliaNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildUsuarioNovedadRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildUsuarioNovedadRelatedInstance4Parentesco(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Parentesco(mapper.readValue(relatedInstanceJsonOid, ParentescoOid.class)): Parentesco.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildUsuarioNovedadRelatedInstance4EstadoBeneficiario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoBeneficiario(mapper.readValue(relatedInstanceJsonOid, EstadoBeneficiarioOid.class)): EstadoBeneficiario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            UsuarioNovedadOid oid = new UsuarioNovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(UsuarioNovedadConstants.ATTR_FIELD_USUARIONOVEDADIDUSUARIONOVEDAD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getUsuarioNovedadidUsuarioNovedad(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(UsuarioNovedadService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
