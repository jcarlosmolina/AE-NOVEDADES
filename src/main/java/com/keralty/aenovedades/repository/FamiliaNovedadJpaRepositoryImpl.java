package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.EstadoBeneficiarioConstants;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.global.FirmaConstants;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.global.NovedadMDConstants;
import com.keralty.aenovedades.global.ParentescoConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.sqlutils.SQLCount;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereConjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandNull;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aenovedades.sqlutils.TypedQueryBuilder;
import com.keralty.aenovedades.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class FamiliaNovedadJpaRepositoryImpl extends AbstractRepository implements FamiliaNovedadJpaRepositoryCustom {

    @Inject
    public FamiliaNovedadJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<FamiliaNovedad> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<FamiliaNovedad> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<FamiliaNovedad> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<FamiliaNovedad> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, FamiliaNovedad.class);
    }

    @Override	
    public List<FamiliaNovedad> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<FamiliaNovedad> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (UsuarioNovedad) WHERE (UsuarioNovedad.EstadoBeneficiario.EsActivo = true)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Boolean assocOperator001(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Boolean assocOperator001Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLExists assocOperator001Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Long assocOperator002(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.drvEsTitular = true AND UsuarioNovedad.EstadoBeneficiario.EsActivo = true AND (EXIST (UsuarioNovedad.TipoIdentificacionCD) = false AND UsuarioNovedad.TipoIdentificacion.Codigo <> NovedadCT.TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacion <> NovedadCT.TitNumidentificacion) OR (EXIST (UsuarioNovedad.TipoIdentificacionCD) = true AND UsuarioNovedad.TipoIdentificacionCD.Codigo <> NovedadCT.TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacionCD <> NovedadCT.TitNumidentificacion))
            long count = 0L;
            for(UsuarioNovedad item : assocOperator002Range1(instance)){
                // UsuarioNovedad.drvEsTitular = true AND UsuarioNovedad.EstadoBeneficiario.EsActivo = true AND (EXIST (UsuarioNovedad.TipoIdentificacionCD) = false AND UsuarioNovedad.TipoIdentificacion.Codigo <> NovedadCT.TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacion <> NovedadCT.TitNumidentificacion) OR (EXIST (UsuarioNovedad.TipoIdentificacionCD) = true AND UsuarioNovedad.TipoIdentificacionCD.Codigo <> NovedadCT.TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacionCD <> NovedadCT.TitNumidentificacion)
                if(item.getUsuarioNovedaddrvEsTitular().equals(true) && item.getEstadoBeneficiario().getEstadoBeneficiarioEsActivo().equals(true) && (assocOperator003(instance).equals(false) && !STDFunctions.areEqual(item.getTipoIdentificacion().getTipoIdentificacionCodigo(),instance.getNovedadCT().getTipoIdentificacion().getTipoIdentificacionCodigo()) && !STDFunctions.areEqual(item.getUsuarioNovedadNumIdentificacion(),instance.getNovedadCT().getNovedadCTTitNumidentificacion())) || (assocOperator004(instance).equals(true) && !STDFunctions.areEqual(item.getTipoIdentificacionCD().getTipoIdentificacionCodigo(),instance.getNovedadCT().getTipoIdentificacion().getTipoIdentificacionCodigo()) && !STDFunctions.areEqual(item.getUsuarioNovedadNumIdentificacionCD(),instance.getNovedadCT().getNovedadCTTitNumidentificacion())))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Collection<UsuarioNovedad> assocOperator002Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator002Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLPopulation assocOperator002Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Boolean assocOperator003(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (UsuarioNovedad.TipoIdentificacionCD)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Boolean assocOperator003Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance, null);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLExists assocOperator003Range1Query (FamiliaNovedad instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
        	if (superQuery == null)
        	{
        		return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD, instance.getOid());
        	} else {
                return new SQLExists(superQuery, FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD);
        	}
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Boolean assocOperator004(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (UsuarioNovedad.TipoIdentificacionCD)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Boolean assocOperator004Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance, null);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLExists assocOperator004Range1Query (FamiliaNovedad instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            if (superQuery == null) {
            	return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD, instance.getOid());
            } else {
                return new SQLExists(superQuery, FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD);
            }
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Long assocOperator005(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.drvEsTitular = true AND UsuarioNovedad.EstadoBeneficiario.EsActivo = true AND (EXIST (UsuarioNovedad.TipoIdentificacionCD) = false AND UsuarioNovedad.TipoIdentificacion.Codigo <> TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacion <> TitNumidentificacion) OR (EXIST (UsuarioNovedad.TipoIdentificacionCD) = true AND UsuarioNovedad.TipoIdentificacionCD.Codigo <> TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacionCD <> TitNumidentificacion))
            long count = 0L;
            for(UsuarioNovedad item : assocOperator005Range1(instance)){
                // UsuarioNovedad.drvEsTitular = true AND UsuarioNovedad.EstadoBeneficiario.EsActivo = true AND (EXIST (UsuarioNovedad.TipoIdentificacionCD) = false AND UsuarioNovedad.TipoIdentificacion.Codigo <> TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacion <> TitNumidentificacion) OR (EXIST (UsuarioNovedad.TipoIdentificacionCD) = true AND UsuarioNovedad.TipoIdentificacionCD.Codigo <> TipoIdentificacion.Codigo AND UsuarioNovedad.NumIdentificacionCD <> TitNumidentificacion)
                if(item.getUsuarioNovedaddrvEsTitular().equals(true) && item.getEstadoBeneficiario().getEstadoBeneficiarioEsActivo().equals(true) && (assocOperator006(instance).equals(false) && !STDFunctions.areEqual(item.getTipoIdentificacion().getTipoIdentificacionCodigo(),instance.getTipoIdentificacion().getTipoIdentificacionCodigo()) && !(item.getUsuarioNovedadNumIdentificacion()).equals(instance.getFamiliaNovedadTitNumidentificacion())) || (assocOperator007(instance).equals(true) && !STDFunctions.areEqual(item.getTipoIdentificacionCD().getTipoIdentificacionCodigo(),instance.getTipoIdentificacion().getTipoIdentificacionCodigo()) && !(item.getUsuarioNovedadNumIdentificacionCD()).equals(instance.getFamiliaNovedadTitNumidentificacion())))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Collection<UsuarioNovedad> assocOperator005Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator005Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLPopulation assocOperator005Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Boolean assocOperator006(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (UsuarioNovedad.TipoIdentificacionCD)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Boolean assocOperator006Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance, null);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLExists assocOperator006Range1Query (FamiliaNovedad instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            if (superQuery == null) {
            	return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD, instance.getOid());
            } else {
                return new SQLExists(superQuery, FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD);
            }
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Boolean assocOperator007(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (UsuarioNovedad.TipoIdentificacionCD)
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Boolean assocOperator007Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator007Range1Query(instance, null);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLExists assocOperator007Range1Query (FamiliaNovedad instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            if (superQuery == null) {
            	return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD, instance.getOid());
            } else {
                return new SQLExists(superQuery, FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD);
            }
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Boolean assocOperator008(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Boolean assocOperator008Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator008Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLExists assocOperator008Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public Boolean assocOperator009(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public Boolean assocOperator009Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator009Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLExists assocOperator009Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
	@Override
    public Boolean assocOperator010(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
	@Override
    public Boolean assocOperator010Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
	@Override
    public SQLExists assocOperator010Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public Boolean assocOperator011(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public Boolean assocOperator011Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLExists assocOperator011Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator012
	@Override
    public Boolean assocOperator012(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator012, Method: assocOperator012";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator012
	@Override
    public Boolean assocOperator012Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
	@Override
    public SQLExists assocOperator012Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator013
	@Override
    public Boolean assocOperator013(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadMD)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator013, Method: assocOperator013";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator013
	@Override
    public Boolean assocOperator013Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator013Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator013
	@Override
    public SQLExists assocOperator013Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADMD, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Boolean assocOperator014(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator014Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Boolean assocOperator014Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator014Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLExists assocOperator014Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT.Firma)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT + "." + NovedadCTConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Long assocOperator016(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.Parentesco.EsTitular = true AND UsuarioNovedad.drvEstaActivo = true)
            long count = 0L;
            for(UsuarioNovedad item : assocOperator016Range1(instance)){
                // UsuarioNovedad.drvEstaActivo = true
                if(item.getUsuarioNovedaddrvEstaActivo().equals(true))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator016
	@Override
    public Collection<UsuarioNovedad> assocOperator016Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator016Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator016
	@Override
    public SQLPopulation assocOperator016Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator017
	@Override
    public Boolean assocOperator017(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT) WHERE (NovedadCT.TipoIdentificacion.NIT = true)
            return assocOperator017Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator017, Method: assocOperator017";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator017
	@Override
    public Boolean assocOperator017Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator017Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator017
	@Override
    public SQLExists assocOperator017Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // NovedadCT.TipoIdentificacion.NIT = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    if (instance.getNovedadCT().getTipoIdentificacion().getTipoIdentificacionNIT()!= null){
                    comparison1.setFirstOperand(new SQLWhereOperandLiteral(instance.getNovedadCT().getTipoIdentificacion().getTipoIdentificacionNIT(), Constants.Type.BOOL.getTypeName()));
                    } else {
                    comparison1.setFirstOperand(new SQLWhereOperandNull());
                    }
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Long assocOperator018(FamiliaNovedad instance) throws SystemException {
        try {
            // SUM (UsuarioNovedad.drvEdad) WHERE (UsuarioNovedad.drvEsTitular = true)
            long result = 0L;
            for(UsuarioNovedad item : assocOperator018Range1(instance)){
                // UsuarioNovedad.drvEsTitular = true
                if(item.getUsuarioNovedaddrvEsTitular().equals(true))
                    result += item.getUsuarioNovedaddrvEdad();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Collection<UsuarioNovedad> assocOperator018Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator018Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLPopulation assocOperator018Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator019
	@Override
    public Long assocOperator019(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad.TipoIdentificacionCD)
            return assocOperator019Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator019, Method: assocOperator019";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator019
	@Override
    public Long assocOperator019Range1 (FamiliaNovedad instance) throws SystemException {
        SQLCount sql = assocOperator019Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator019
	@Override
    public SQLCount assocOperator019Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACIONCD, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator020
	@Override
    public Long assocOperator020(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.NumIdentificacionCD <> NULL)
            return assocOperator020Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator020, Method: assocOperator020";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator020
	@Override
    public Long assocOperator020Range1 (FamiliaNovedad instance) throws SystemException {
        SQLCount sql = assocOperator020Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator020
	@Override
    public SQLCount assocOperator020Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.NumIdentificacionCD <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACIONCD, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator020, Method: assocOperator020Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator021
	@Override
    public Boolean assocOperator021(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator021Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator021, Method: assocOperator021";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator021
	@Override
    public Boolean assocOperator021Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator021Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator021
	@Override
    public SQLExists assocOperator021Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Boolean assocOperator022(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator022Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Boolean assocOperator022Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator022Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLExists assocOperator022Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator023
	@Override
    public Boolean assocOperator023(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT.Firma)
            return assocOperator023Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator023, Method: assocOperator023";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator023
	@Override
    public Boolean assocOperator023Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator023Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator023
	@Override
    public SQLExists assocOperator023Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT + "." + NovedadCTConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator023, Method: assocOperator023Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator024
	@Override
    public Boolean assocOperator024(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadMD)
            return assocOperator024Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator024, Method: assocOperator024";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator024
	@Override
    public Boolean assocOperator024Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator024Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator024
	@Override
    public SQLExists assocOperator024Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADMD, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Boolean assocOperator025(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (UsuarioNovedad.ParentescoNuevo)
            return assocOperator025Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Boolean assocOperator025Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator025Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLExists assocOperator025Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_PARENTESCONUEVO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator026
	@Override
    public Long assocOperator026(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.ContratacionRO = true)
            return assocOperator026Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator026
	@Override
    public Long assocOperator026Range1 (FamiliaNovedad instance) throws SystemException {
        SQLCount sql = assocOperator026Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator026
	@Override
    public SQLCount assocOperator026Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.ContratacionRO = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADCONTRATACIONRO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator027
	@Override
    public Long assocOperator027(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.Parentesco.EsPadre = true AND UsuarioNovedad.drvEdad - drvEdadUsuTitular < 10)
            long count = 0L;
            for(UsuarioNovedad item : assocOperator027Range1(instance)){
                // UsuarioNovedad.drvEdad - drvEdadUsuTitular < 10
                if(item.getUsuarioNovedaddrvEdad() - instance.getFamiliaNovedaddrvEdadUsuTitular() < Long.valueOf(10))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator027, Method: assocOperator027";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator027
	@Override
    public Collection<UsuarioNovedad> assocOperator027Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator027Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator027
	@Override
    public SQLPopulation assocOperator027Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.Parentesco.EsPadre = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESPADRE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator027, Method: assocOperator027Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Long assocOperator028(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.ContratacionRO = true AND UsuarioNovedad.drvEstaActivo = false)
            long count = 0L;
            for(UsuarioNovedad item : assocOperator028Range1(instance)){
                // UsuarioNovedad.drvEstaActivo = false
                if(item.getUsuarioNovedaddrvEstaActivo().equals(false))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator028
	@Override
    public Collection<UsuarioNovedad> assocOperator028Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator028Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator028
	@Override
    public SQLPopulation assocOperator028Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.ContratacionRO = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADCONTRATACIONRO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator029
	@Override
    public Long assocOperator029(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.ProrrogaSuspension = true)
            return assocOperator029Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator029, Method: assocOperator029";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator029
	@Override
    public Long assocOperator029Range1 (FamiliaNovedad instance) throws SystemException {
        SQLCount sql = assocOperator029Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator029
	@Override
    public SQLCount assocOperator029Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.ProrrogaSuspension = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADPRORROGASUSPENSION, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator030
	@Override
    public Long assocOperator030(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.ActivacionSuspension = true)
            return assocOperator030Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator030, Method: assocOperator030";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator030
	@Override
    public Long assocOperator030Range1 (FamiliaNovedad instance) throws SystemException {
        SQLCount sql = assocOperator030Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator030
	@Override
    public SQLCount assocOperator030Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.ActivacionSuspension = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADACTIVACIONSUSPENSION, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator030, Method: assocOperator030Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator031
	@Override
    public Long assocOperator031(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.drvEsConyuge = true AND UsuarioNovedad.drvEstaActivo = true)
            long count = 0L;
            for(UsuarioNovedad item : assocOperator031Range1(instance)){
                // UsuarioNovedad.drvEsConyuge = true
                boolean conditionsMet = (item.getUsuarioNovedaddrvEsConyuge().equals(true));
                // UsuarioNovedad.drvEstaActivo = true
                conditionsMet &= (item.getUsuarioNovedaddrvEstaActivo().equals(true));
                if(conditionsMet) count++;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator031, Method: assocOperator031";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator031
	@Override
    public Collection<UsuarioNovedad> assocOperator031Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator031Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator031
	@Override
    public SQLPopulation assocOperator031Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator031, Method: assocOperator031Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator032
	@Override
    public Boolean assocOperator032(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT)
            return assocOperator032Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator032, Method: assocOperator032";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator032
	@Override
    public Boolean assocOperator032Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator032Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator032
	@Override
    public SQLExists assocOperator032Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator032, Method: assocOperator032Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator033
	@Override
    public Boolean assocOperator033(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (NovedadCT.Firma)
            return assocOperator033Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator033, Method: assocOperator033";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator033
	@Override
    public Boolean assocOperator033Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator033Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator033
	@Override
    public SQLExists assocOperator033Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT + "." + NovedadCTConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator033, Method: assocOperator033Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator034
	@Override
    public Boolean assocOperator034(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator034Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator034, Method: assocOperator034";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator034
	@Override
    public Boolean assocOperator034Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator034Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator034
	@Override
    public SQLExists assocOperator034Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator034, Method: assocOperator034Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator035
	@Override
    public Long assocOperator035(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.Excluido = true)
            return assocOperator035Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator035, Method: assocOperator035";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator035
	@Override
    public Long assocOperator035Range1 (FamiliaNovedad instance) throws SystemException {
        SQLCount sql = assocOperator035Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator035
	@Override
    public SQLCount assocOperator035Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.Excluido = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADEXCLUIDO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator035, Method: assocOperator035Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator036
	@Override
    public Long assocOperator036(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.drvEstaActivo = true AND UsuarioNovedad.Excluido = false)
            long count = 0L;
            for(UsuarioNovedad item : assocOperator036Range1(instance)){
                // UsuarioNovedad.drvEstaActivo = true
                if(item.getUsuarioNovedaddrvEstaActivo().equals(true))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator036, Method: assocOperator036";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator036
	@Override
    public Collection<UsuarioNovedad> assocOperator036Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator036Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator036
	@Override
    public SQLPopulation assocOperator036Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.Excluido = false
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADEXCLUIDO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator036, Method: assocOperator036Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator037
	@Override
    public Long assocOperator037(FamiliaNovedad instance) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.SUNumMeses <> NULL)
            return assocOperator037Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator037, Method: assocOperator037";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator037
	@Override
    public Long assocOperator037Range1 (FamiliaNovedad instance) throws SystemException {
        SQLCount sql = assocOperator037Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator037
	@Override
    public SQLCount assocOperator037Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.SUNumMeses <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADSUNUMMESES, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator037, Method: assocOperator037Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator039
	@Override
    public Boolean assocOperator039(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator039Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator039, Method: assocOperator039";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator039
	@Override
    public Boolean assocOperator039Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator039Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator039
	@Override
    public SQLExists assocOperator039Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator039, Method: assocOperator039Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator040
	@Override
    public Collection<UsuarioNovedad> assocOperator040(FamiliaNovedad instance) throws SystemException {
        try {
            // FOR ALL UsuarioNovedad DO UsuarioNovedad.validarCP(UsuarioNovedad)
        return assocOperator040Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator040, Method: assocOperator040";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator040
	@Override
    public Collection<UsuarioNovedad> assocOperator040Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator040Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator040
	@Override
    public SQLPopulation assocOperator040Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator040, Method: assocOperator040Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator041
	@Override
    public Collection<NovedadMD> assocOperator041(FamiliaNovedad instance) throws SystemException {
        try {
            // FOR ALL NovedadMD DO NovedadMD.TDELETE(NovedadMD)
        return assocOperator041Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator041, Method: assocOperator041";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator041
	@Override
    public Collection<NovedadMD> assocOperator041Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator041Range1Query(instance);
        return new TypedQueryBuilder<NovedadMD>(em, NovedadMD.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator041
	@Override
    public SQLPopulation assocOperator041Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, NovedadMDConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_NOVEDADMD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator041, Method: assocOperator041Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator042
	@Override
    public Collection<NovedadCT> assocOperator042(FamiliaNovedad instance) throws SystemException {
        try {
            // FOR ALL NovedadCT DO NovedadCT.TDELETE(NovedadCT)
        return assocOperator042Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator042, Method: assocOperator042";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator042
	@Override
    public Collection<NovedadCT> assocOperator042Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator042Range1Query(instance);
        return new TypedQueryBuilder<NovedadCT>(em, NovedadCT.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator042
	@Override
    public SQLPopulation assocOperator042Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, NovedadCTConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator042, Method: assocOperator042Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator044
	@Override
    public Collection<UsuarioNovedad> assocOperator044(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        try {
            // FOR ALL UsuarioNovedad WHERE (UsuarioNovedad.TipoIdentificacion = ptpagrTipoIdentificacion AND UsuarioNovedad.NumIdentificacion = ptpatrNumIdentificacion) DO UsuarioNovedad.TCAMBIARPARENTESCO(UsuarioNovedad, fugetParentescoTitular())
        return assocOperator044Range1(instance, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator044, Method: assocOperator044";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator044
	@Override
    public Collection<UsuarioNovedad> assocOperator044Range1 (FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {

        SQLSelect sql = assocOperator044Range1Query(instance, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator044
	@Override
    public SQLPopulation assocOperator044Range1Query (FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.TipoIdentificacion = ptpagrTipoIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, familiaNovedadTADDTITULARptpagrTipoIdentificacion.getOid(), FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // UsuarioNovedad.NumIdentificacion = ptpatrNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(familiaNovedadTADDTITULARptpatrNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator044, Method: assocOperator044Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator046
	@Override
    public Boolean assocOperator046(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        try {
            // EXIST (UsuarioNovedad) WHERE (UsuarioNovedad.TipoIdentificacion = ptpagrTipoIdentificacion AND UsuarioNovedad.NumIdentificacion = ptpatrNumIdentificacion)
            return assocOperator046Range1(instance, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator046, Method: assocOperator046";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator046
	@Override
    public Boolean assocOperator046Range1 (FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        SQLExists sql = assocOperator046Range1Query(instance, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator046
	@Override
    public SQLExists assocOperator046Range1Query (FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.TipoIdentificacion = ptpagrTipoIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, familiaNovedadTADDTITULARptpagrTipoIdentificacion.getOid(), FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // UsuarioNovedad.NumIdentificacion = ptpatrNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(familiaNovedadTADDTITULARptpatrNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator046, Method: assocOperator046Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator047
	@Override
    public Long assocOperator047(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        try {
            // COUNT (UsuarioNovedad) WHERE (UsuarioNovedad.TipoIdentificacion = ptpagrTipoIdentificacion AND UsuarioNovedad.NumIdentificacion = ptpatrNumIdentificacion)
            return assocOperator047Range1(instance, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator047, Method: assocOperator047";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator047
	@Override
    public Long assocOperator047Range1 (FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        SQLCount sql = assocOperator047Range1Query(instance, familiaNovedadTADDTITULARptpagrTipoIdentificacion, familiaNovedadTADDTITULARptpatrNumIdentificacion);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator047
	@Override
    public SQLCount assocOperator047Range1Query (FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioNovedad.TipoIdentificacion = ptpagrTipoIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, familiaNovedadTADDTITULARptpagrTipoIdentificacion.getOid(), FamiliaNovedadConstants.ARG_NAME_TADDTITULAR_FAMILIANOVEDADTADDTITULARPTPAGRTIPOIDENTIFICACION);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // UsuarioNovedad.NumIdentificacion = ptpatrNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(familiaNovedadTADDTITULARptpatrNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator047, Method: assocOperator047Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator048
	@Override
    public Collection<UsuarioNovedad> assocOperator048(FamiliaNovedad instance) throws SystemException {
        try {
            // FOR ALL UsuarioNovedad DO UsuarioNovedad.eliminar(UsuarioNovedad)
        return assocOperator048Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator048, Method: assocOperator048";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator048
	@Override
    public Collection<UsuarioNovedad> assocOperator048Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator048Range1Query(instance);
        return new TypedQueryBuilder<UsuarioNovedad>(em, UsuarioNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator048
	@Override
    public SQLPopulation assocOperator048Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, UsuarioNovedadConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator048, Method: assocOperator048Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator049
	@Override
    public Collection<NovedadCT> assocOperator049(FamiliaNovedad instance) throws SystemException {
        try {
            // FOR ALL NovedadCT DO NovedadCT.TDELETE(NovedadCT)
        return assocOperator049Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator049, Method: assocOperator049";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator049
	@Override
    public Collection<NovedadCT> assocOperator049Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator049Range1Query(instance);
        return new TypedQueryBuilder<NovedadCT>(em, NovedadCT.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator049
	@Override
    public SQLPopulation assocOperator049Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, NovedadCTConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator049, Method: assocOperator049Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator050
	@Override
    public Collection<NovedadMD> assocOperator050(FamiliaNovedad instance) throws SystemException {
        try {
            // FOR ALL NovedadMD DO NovedadMD.TDELETE(NovedadMD)
        return assocOperator050Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator050, Method: assocOperator050";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator050
	@Override
    public Collection<NovedadMD> assocOperator050Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator050Range1Query(instance);
        return new TypedQueryBuilder<NovedadMD>(em, NovedadMD.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator050
	@Override
    public SQLPopulation assocOperator050Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, NovedadMDConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_NOVEDADMD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator050, Method: assocOperator050Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator051
	@Override
    public Collection<Firma> assocOperator051(FamiliaNovedad instance) throws SystemException {
        try {
            // FOR ALL Firma DO Firma.eliminarInterno(Firma)
        return assocOperator051Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator051, Method: assocOperator051";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator051
	@Override
    public Collection<Firma> assocOperator051Range1 (FamiliaNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator051Range1Query(instance);
        return new TypedQueryBuilder<Firma>(em, Firma.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator051
	@Override
    public SQLPopulation assocOperator051Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaNovedadConstants.CLASS_NAME, FirmaConstants.CLASS_NAME, instance.getOid(), FamiliaNovedadConstants.ROLE_NAME_FIRMA);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator051, Method: assocOperator051Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator053
	@Override
    public Boolean assocOperator053(FamiliaNovedad instance) throws SystemException {
        try {
            // EXIST (TipoIdentificacion)
            return assocOperator053Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator053, Method: assocOperator053";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator053
	@Override
    public Boolean assocOperator053Range1 (FamiliaNovedad instance) throws SystemException {
        SQLExists sql = assocOperator053Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator053
	@Override
    public SQLExists assocOperator053Range1Query (FamiliaNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaNovedad, Assoc.Operator: AssocOperator053, Method: assocOperator053Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
