package com.keralty.aenovedades.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.global.AfiliacionesConstants;
import com.keralty.aenovedades.global.AreaMedicaConstants;
import com.keralty.aenovedades.global.AsesorConstants;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.FuncionarioConstants;
import com.keralty.aenovedades.global.RespRegionalConstants;
import com.keralty.aenovedades.global.SuperAdminConstants;
import com.keralty.aenovedades.persistence.AbstractAppEntity;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.GrupoAsignacion;
import com.keralty.aenovedades.persistence.oid.FirmaOid;
import com.keralty.aenovedades.persistence.oid.GrupoAsignacionOid;
import com.keralty.aenovedades.persistence.oid.PlanesOid;
import com.keralty.aenovedades.persistence.oid.RegionalOid;
import com.keralty.aenovedades.persistence.oid.RolOid;
import com.keralty.aenovedades.persistence.oid.SolicitudNovedadOid;
import com.keralty.aenovedades.persistence.oid.SolicitudOid;
import com.keralty.aenovedades.persistence.oid.SucursalOid;
import com.keralty.aenovedades.persistence.oid.SuperAdminOid;
import com.keralty.aenovedades.persistence.oid.TipoIdentificacionOid;
import com.keralty.aenovedades.persistence.Planes;
import com.keralty.aenovedades.persistence.Regional;
import com.keralty.aenovedades.persistence.Rol;
import com.keralty.aenovedades.persistence.Solicitud;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.Sucursal;
import com.keralty.aenovedades.persistence.SuperAdmin;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.repository.SuperAdminJpaRepository;
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
public class SuperAdminService extends AbstractService {

    SuperAdminJpaRepository repository;

    SolicitudService solicitudSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    GrupoAsignacionService grupoAsignacionSrv;

    FirmaService firmaSrv;

    RolService rolSrv;

    SucursalService sucursalSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    PlanesService planesSrv;

    RegionalService regionalSrv;

    @Inject
    public SuperAdminService(
            SolicitudService solicitudSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            GrupoAsignacionService grupoAsignacionSrv,
            FirmaService firmaSrv,
            RolService rolSrv,
            SucursalService sucursalSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            PlanesService planesSrv,
            RegionalService regionalSrv,
            SuperAdminJpaRepository repository) {
        this.solicitudSrv = solicitudSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.grupoAsignacionSrv = grupoAsignacionSrv;
        this.firmaSrv = firmaSrv;
        this.rolSrv = rolSrv;
        this.sucursalSrv = sucursalSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.planesSrv = planesSrv;
        this.regionalSrv = regionalSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, SuperAdminConstants.CLASS_NAME);
    }

    private List<SuperAdmin> solveSuperAdminTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, SuperAdminConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveSuperAdminTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, SuperAdminConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class SuperAdmin
     *
     * @return Population of class SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> get() {
        List<SuperAdmin> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class SuperAdmin that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class SuperAdmin matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> get(QueryRequest queryRequest) {
        return solveSuperAdminTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveSuperAdminTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveSuperAdminTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveSuperAdminTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of SuperAdmin by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SuperAdmin getById(Long funcionarioId) {
        return getByOID(new SuperAdminOid(funcionarioId));
    }
    
    /*
     * Returns an instance of SuperAdmin by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SuperAdmin getByOID(SuperAdminOid oid) {
        Optional<SuperAdmin> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of SuperAdmin by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public SuperAdmin getByOIDWithHV(SuperAdminOid oid) {
        Optional<SuperAdmin> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<SuperAdmin> getInstanceByOid(SuperAdminOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }

    /*
     * Returns an instance of SuperAdmin by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of SuperAdmin
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public SuperAdmin getByJsonOid(String jsonOid) {
        SuperAdminOid oid = new SuperAdminOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of SuperAdmin related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveSuperAdminTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of SuperAdmin related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of SuperAdmin
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getSuperAdminDynamic(SuperAdminOid oid, String displaySetItems) {
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
    public String getSuppInfo(SuperAdminOid oid, String dsName) {
        SuperAdmin instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(SuperAdmin instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (SuperAdminConstants.DSICSUPERADMIN.equals(dsName))
            return instance.buildICSuperAdmin();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUSuperAdmin
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SuperAdmin using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aenovedades.viewmodel.superadmin.ds.AutoDS> piuPIUSuperAdmin(QueryRequest queryRequest) {
        return solveSuperAdminTypedQuery(queryRequest).stream()
                .map(com.keralty.aenovedades.viewmodel.superadmin.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUSuperAdmin
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUSuperAdmin
     */
    public int getCount4PIUSuperAdmin(QueryRequest queryRequest) {
        return solveSuperAdminTypedQuery(queryRequest).size();
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
        select.getOrderByPart().addItem(Constants.normalizePath(SuperAdminConstants.CLASS_NAME, FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildSuperAdminRelatedInstance(relatedInstanceJsonOid);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem) || AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildSuperAdminRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new SuperAdmin(mapper.readValue(relatedInstanceJsonOid, SuperAdminOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): GrupoAsignacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): Rol.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Regional(mapper.readValue(relatedInstanceJsonOid, RegionalOid.class)): Regional.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            SuperAdminOid oid = new SuperAdminOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(SuperAdminService.class).error(e.getMessage());
        }
    }

}
