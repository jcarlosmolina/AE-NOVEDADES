package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.AfiliacionesConstants;
import com.keralty.aenovedades.global.AsesorConstants;
import com.keralty.aenovedades.global.CausaExclusionConstants;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.global.DominioConstants;
import com.keralty.aenovedades.global.FamiliaNovedadConstants;
import com.keralty.aenovedades.global.FuncionarioConstants;
import com.keralty.aenovedades.global.NovedadConstants;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.global.PlanesConstants;
import com.keralty.aenovedades.global.PlantillaReporteConstants;
import com.keralty.aenovedades.global.ProductosConstants;
import com.keralty.aenovedades.global.ReportesDominioConstants;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.global.STDFunctions;
import com.keralty.aenovedades.global.TipoIdentificacionConstants;
import com.keralty.aenovedades.global.TipoNovedadConstants;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.global.UsuarioNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.ReportesDominio;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.sqlutils.SQLCount;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLGetOne;
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

public class SolicitudNovedadJpaRepositoryImpl extends AbstractRepository implements SolicitudNovedadJpaRepositoryCustom {

    @Inject
    public SolicitudNovedadJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<SolicitudNovedad> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<SolicitudNovedad> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<SolicitudNovedad> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<SolicitudNovedad> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, SolicitudNovedad.class);
    }

    @Override	
    public List<SolicitudNovedad> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<SolicitudNovedad> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000() throws SystemException {
        try {
            // EXIST (UsrAfiliacion) WHERE (UsrAfiliacion = agent)
            return assocOperator000Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 () throws SystemException {
        SQLExists sql = assocOperator000Range1Query(null);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsrAfiliacion = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, FuncionarioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Long assocOperator001() throws SystemException {
        try {
            // COUNT (PlanT.Afiliaciones) WHERE (PlanT.Afiliaciones = agent)
            return assocOperator001Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator001
	@Override
    public Long assocOperator001Range1 () throws SystemException {
        SQLCount sql = assocOperator001Range1Query(null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator001
	@Override
    public SQLCount assocOperator001Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Afiliaciones = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES, AfiliacionesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AfiliacionesConstants.CLASS_NAME, AfiliacionesConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Boolean assocOperator003(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Periodicidad)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Boolean assocOperator003Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLExists assocOperator003Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PERIODICIDAD, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Long assocOperator004(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Familias)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Long assocOperator004Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator004Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLCount assocOperator004Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Long assocOperator005(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Familias)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Long assocOperator005Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator005Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLCount assocOperator005Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Boolean assocOperator006(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Causal)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Boolean assocOperator006Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLExists assocOperator006Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_CAUSAL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Boolean assocOperator007(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Causal)
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Boolean assocOperator007Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator007Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLExists assocOperator007Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_CAUSAL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Boolean assocOperator008(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PlanT.Dominios) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorOscuro <> NULL)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Boolean assocOperator008Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator008Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLExists assocOperator008Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorOscuro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLOROSCURO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public String assocOperator009(SolicitudNovedad instance) throws SystemException {
        try {
            // GETONE (PlanT.Dominios.SolNovColorOscuro) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorOscuro <> NULL)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public String assocOperator009Range1 (SolicitudNovedad instance) throws SystemException {
        SQLGetOne sql = assocOperator009Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLGetOne assocOperator009Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLOROSCURO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorOscuro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLOROSCURO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
	@Override
    public Boolean assocOperator010(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PlanT.Dominios) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorClaro <> NULL)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
	@Override
    public Boolean assocOperator010Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
	@Override
    public SQLExists assocOperator010Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorClaro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLORCLARO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public String assocOperator011(SolicitudNovedad instance) throws SystemException {
        try {
            // GETONE (PlanT.Dominios.SolNovColorClaro) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorClaro <> NULL)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public String assocOperator011Range1 (SolicitudNovedad instance) throws SystemException {
        SQLGetOne sql = assocOperator011Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLGetOne assocOperator011Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLORCLARO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorClaro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLORCLARO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator012
	@Override
    public Boolean assocOperator012(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PlanT.Dominios) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovLogo <> NULL)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator012, Method: assocOperator012";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator012
	@Override
    public Boolean assocOperator012Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
	@Override
    public SQLExists assocOperator012Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovLogo <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVLOGO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator013
	@Override
    public String assocOperator013(SolicitudNovedad instance) throws SystemException {
        try {
            // GETONE (PlanT.Dominios.SolNovLogo) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovLogo <> NULL)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator013, Method: assocOperator013";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator013
	@Override
    public String assocOperator013Range1 (SolicitudNovedad instance) throws SystemException {
        SQLGetOne sql = assocOperator013Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator013
	@Override
    public SQLGetOne assocOperator013Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVLOGO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovLogo <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVLOGO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Boolean assocOperator014(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PeriodicidadNueva)
            return assocOperator014Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Boolean assocOperator014Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator014Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLExists assocOperator014Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PERIODICIDADNUEVA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Novedad.TipoNovedad.Novedades.CausasExclusion) WHERE (Novedad.TipoNovedad.Novedades.CausasExclusion.Novedad.AliasNovedad = fugetValorParametroConf("SOLNOVSUSVIAJE") AND Novedad.TipoNovedad.Novedades.CausasExclusion.Descripcion = CtrTagCausaExclusion)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ROLE_NAME_NOVEDADES + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Novedad.TipoNovedad.Novedades.CausasExclusion.Novedad.AliasNovedad = fugetValorParametroConf("SOLNOVSUSVIAJE")
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ROLE_NAME_NOVEDADES + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION + "." + CausaExclusionConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                            if (userFunctionsSrv.fugetValorParametroConfFun("SOLNOVSUSVIAJE") != null) {
                                comparison1.setSecondOperand(new SQLWhereOperandLiteral(userFunctionsSrv.fugetValorParametroConfFun("SOLNOVSUSVIAJE"), Constants.Type.STRING.getTypeName()));
                            } else {
                                comparison1.setSecondOperand(new SQLWhereOperandNull());
                                }
                    conjunction.addOperand(comparison1);


            // Novedad.TipoNovedad.Novedades.CausasExclusion.Descripcion = CtrTagCausaExclusion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ROLE_NAME_NOVEDADES + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION + "." + CausaExclusionConstants.ATTR_NAME_CAUSAEXCLUSIONDESCRIPCION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getSolicitudNovedadCtrTagCausaExclusion()!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitudNovedadCtrTagCausaExclusion(), Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Long assocOperator016(String vfTipoIdent, String vfNumIdent) throws SystemException {
        try {
            // COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent)
            return assocOperator016Range1(vfTipoIdent, vfNumIdent);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator016
	@Override
    public Long assocOperator016Range1 (String vfTipoIdent, String vfNumIdent) throws SystemException {
        SQLCount sql = assocOperator016Range1Query(vfTipoIdent, vfNumIdent, null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator016
	@Override
    public SQLCount assocOperator016Range1Query (String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfTipoIdent, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfNumIdent, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator017
	@Override
    public Long assocOperator017(String vfTipoIdent, String vfNumIdent) throws SystemException {
        try {
            // COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent AND Familias.UsuarioNovedad.Excluido = true)
            return assocOperator017Range1(vfTipoIdent, vfNumIdent);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator017, Method: assocOperator017";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator017
	@Override
    public Long assocOperator017Range1 (String vfTipoIdent, String vfNumIdent) throws SystemException {
        SQLCount sql = assocOperator017Range1Query(vfTipoIdent, vfNumIdent, null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator017
	@Override
    public SQLCount assocOperator017Range1Query (String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfTipoIdent, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfNumIdent, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Familias.UsuarioNovedad.Excluido = true
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADEXCLUIDO, Constants.Type.BOOL.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Boolean assocOperator018(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PeriodicidadNueva)
            return assocOperator018Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Boolean assocOperator018Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator018Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLExists assocOperator018Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PERIODICIDADNUEVA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator019
	@Override
    public Boolean assocOperator019(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Novedad.CausasExclusion) WHERE (Novedad.CausasExclusion.Descripcion = CtrTagCausaExclusion)
            return assocOperator019Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator019, Method: assocOperator019";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator019
	@Override
    public Boolean assocOperator019Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator019Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator019
	@Override
    public SQLExists assocOperator019Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Novedad.CausasExclusion.Descripcion = CtrTagCausaExclusion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION + "." + CausaExclusionConstants.ATTR_NAME_CAUSAEXCLUSIONDESCRIPCION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getSolicitudNovedadCtrTagCausaExclusion()!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitudNovedadCtrTagCausaExclusion(), Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator020
	@Override
    public Long assocOperator020(SolicitudNovedad instance, Long solicitudNovedadTADDFAMILIAptNumFamilia) throws SystemException {
        try {
            // COUNT (Familias) WHERE (Familias.NumFamilia = ptNumFamilia)
            return assocOperator020Range1(instance, solicitudNovedadTADDFAMILIAptNumFamilia);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator020, Method: assocOperator020";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator020
	@Override
    public Long assocOperator020Range1 (SolicitudNovedad instance, Long solicitudNovedadTADDFAMILIAptNumFamilia) throws SystemException {
        SQLCount sql = assocOperator020Range1Query(instance, solicitudNovedadTADDFAMILIAptNumFamilia);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator020
	@Override
    public SQLCount assocOperator020Range1Query (SolicitudNovedad instance, Long solicitudNovedadTADDFAMILIAptNumFamilia) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Familias.NumFamilia = ptNumFamilia
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ATTR_NAME_FAMILIANOVEDADNUMFAMILIA, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(solicitudNovedadTADDFAMILIAptNumFamilia, Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator020, Method: assocOperator020Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator021
	@Override
    public Long assocOperator021(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Familias)
            return assocOperator021Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator021, Method: assocOperator021";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator021
	@Override
    public Long assocOperator021Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator021Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator021
	@Override
    public SQLCount assocOperator021Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Long assocOperator022(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Documentos) WHERE (Documentos.Tipo = 2)
            return assocOperator022Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Long assocOperator022Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator022Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLCount assocOperator022Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Documentos.Tipo = 2
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS + "." + DocumentoNovedadConstants.ATTR_NAME_DOCUMENTONOVEDADTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator023
	@Override
    public Long assocOperator023(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Documentos) WHERE (Documentos.Tipo = 1)
            return assocOperator023Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator023, Method: assocOperator023";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator023
	@Override
    public Long assocOperator023Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator023Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator023
	@Override
    public SQLCount assocOperator023Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Documentos.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS + "." + DocumentoNovedadConstants.ATTR_NAME_DOCUMENTONOVEDADTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator023, Method: assocOperator023Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator024
	@Override
    public Long assocOperator024(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (PlanT.Dominios) WHERE (PlanT.Dominios.NovExcepcionReqDoc = true AND PlanT.Dominios.ProductoT = PlanT.ProductoT)
            return assocOperator024Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator024, Method: assocOperator024";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator024
	@Override
    public Long assocOperator024Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator024Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator024
	@Override
    public SQLCount assocOperator024Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.NovExcepcionReqDoc = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIONOVEXCEPCIONREQDOC, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Long assocOperator025(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Documentos) WHERE (Documentos.Tipo = 2)
            return assocOperator025Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Long assocOperator025Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator025Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLCount assocOperator025Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Documentos.Tipo = 2
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS + "." + DocumentoNovedadConstants.ATTR_NAME_DOCUMENTONOVEDADTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator026
	@Override
    public Long assocOperator026(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (PlanT.ProductoT.Dominios.ReportesDominio) WHERE (PlanT.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = PlanT AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 12 AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= FechaCreacion AND PlanT.ProductoT.Dominios.ReportesDominio.drvFechaHasta > FechaCreacion)
            long count = 0L;
            for(ReportesDominio item : assocOperator026Range1(instance)){
                // PlanT.ProductoT.Dominios.ReportesDominio.drvFechaHasta > FechaCreacion
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getSolicitudNovedadFechaCreacion()))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator026
	@Override
    public Collection<ReportesDominio> assocOperator026Range1 (SolicitudNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator026Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator026
	@Override
    public SQLPopulation assocOperator026Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudNovedadConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getPlanT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 12
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(12), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= FechaCreacion
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitudNovedadFechaCreacion(), Constants.Type.DATE.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator027
	@Override
    public String assocOperator027(SolicitudNovedad instance) throws SystemException {
        try {
            // GETONE (PlanT.ProductoT.Dominios.ReportesDominio.drvRuta) WHERE (PlanT.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = PlanT AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 12 AND PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= FechaCreacion AND PlanT.ProductoT.Dominios.ReportesDominio.drvFechaHasta > FechaCreacion)
            String result = null;
            for(ReportesDominio item : assocOperator027Range1(instance)){
                // PlanT.ProductoT.Dominios.ReportesDominio.drvFechaHasta > FechaCreacion
                if(result == null && STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getSolicitudNovedadFechaCreacion()))
                    result = item.getReportesDominiodrvRuta();
            }
            return result != null ? result : "";
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator027, Method: assocOperator027";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator027
	@Override
    public Collection<ReportesDominio> assocOperator027Range1 (SolicitudNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator027Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator027
	@Override
    public SQLPopulation assocOperator027Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudNovedadConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getPlanT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 12
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(12), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // PlanT.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= FechaCreacion
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitudNovedadFechaCreacion(), Constants.Type.DATE.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator027, Method: assocOperator027Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Collection<FamiliaNovedad> assocOperator028(SolicitudNovedad instance) throws SystemException {
        try {
            // FOR ALL Familias DO Familias.TMARCARCOMPLETADA(Familias)
        return assocOperator028Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator028
	@Override
    public Collection<FamiliaNovedad> assocOperator028Range1 (SolicitudNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator028Range1Query(instance);
        return new TypedQueryBuilder<FamiliaNovedad>(em, FamiliaNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator028
	@Override
    public SQLPopulation assocOperator028Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudNovedadConstants.CLASS_NAME, FamiliaNovedadConstants.CLASS_NAME, instance.getOid(), SolicitudNovedadConstants.ROLE_NAME_FAMILIAS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator030
	@Override
    public Collection<DocumentoNovedad> assocOperator030(SolicitudNovedad instance) throws SystemException {
        try {
            // FOR ALL Documentos DO Documentos.cambiarFechaSubida(Documentos, FechaCompletada)
        return assocOperator030Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator030, Method: assocOperator030";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator030
	@Override
    public Collection<DocumentoNovedad> assocOperator030Range1 (SolicitudNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator030Range1Query(instance);
        return new TypedQueryBuilder<DocumentoNovedad>(em, DocumentoNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator030
	@Override
    public SQLPopulation assocOperator030Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudNovedadConstants.CLASS_NAME, DocumentoNovedadConstants.CLASS_NAME, instance.getOid(), SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator030, Method: assocOperator030Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator031
	@Override
    public Collection<NovedadCT> assocOperator031(SolicitudNovedad instance) throws SystemException {
        try {
            // FOR ALL Familias.NovedadCT WHERE (Familias.NovedadCT.CodigoCORE = NULL) DO TCREARPERSONACORE(this, Familias.NovedadCT, oaNumErr; oaNumErr)
        return assocOperator031Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator031, Method: assocOperator031";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator031
	@Override
    public Collection<NovedadCT> assocOperator031Range1 (SolicitudNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator031Range1Query(instance);
        return new TypedQueryBuilder<NovedadCT>(em, NovedadCT.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator031
	@Override
    public SQLPopulation assocOperator031Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudNovedadConstants.CLASS_NAME, NovedadCTConstants.CLASS_NAME, instance.getOid(), SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Familias.NovedadCT.CodigoCORE = NULL
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_NOVEDADCT + "." + NovedadCTConstants.ATTR_NAME_NOVEDADCTCODIGOCORE, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator031, Method: assocOperator031Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator032
	@Override
    public Long assocOperator032(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Documentos)
            return assocOperator032Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator032, Method: assocOperator032";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator032
	@Override
    public Long assocOperator032Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator032Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator032
	@Override
    public SQLCount assocOperator032Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator032, Method: assocOperator032Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator034
	@Override
    public Boolean assocOperator034(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PeriodicidadNueva)
            return assocOperator034Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator034, Method: assocOperator034";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator034
	@Override
    public Boolean assocOperator034Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator034Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator034
	@Override
    public SQLExists assocOperator034Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PERIODICIDADNUEVA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator034, Method: assocOperator034Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator036
	@Override
    public Boolean assocOperator036(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator036Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator036, Method: assocOperator036";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator036
	@Override
    public Boolean assocOperator036Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator036Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator036
	@Override
    public SQLExists assocOperator036Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator036, Method: assocOperator036Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator037
	@Override
    public Collection<DocumentoNovedad> assocOperator037(SolicitudNovedad instance) throws SystemException {
        try {
            // FOR ALL Documentos WHERE (Documentos.Estado <> 2) DO Documentos.TCAMBIARESTADO(Documentos, NULL, 2, false)
        return assocOperator037Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator037, Method: assocOperator037";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator037
	@Override
    public Collection<DocumentoNovedad> assocOperator037Range1 (SolicitudNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator037Range1Query(instance);
        return new TypedQueryBuilder<DocumentoNovedad>(em, DocumentoNovedad.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator037
	@Override
    public SQLPopulation assocOperator037Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudNovedadConstants.CLASS_NAME, DocumentoNovedadConstants.CLASS_NAME, instance.getOid(), SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Documentos.Estado <> 2
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS + "." + DocumentoNovedadConstants.ATTR_NAME_DOCUMENTONOVEDADESTADO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator037, Method: assocOperator037Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator039
	@Override
    public Boolean assocOperator039(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator039Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator039, Method: assocOperator039";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator039
	@Override
    public Boolean assocOperator039Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator039Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator039
	@Override
    public SQLExists assocOperator039Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator039, Method: assocOperator039Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator041
	@Override
    public Boolean assocOperator041(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator041Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator041, Method: assocOperator041";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator041
	@Override
    public Boolean assocOperator041Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator041Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator041
	@Override
    public SQLExists assocOperator041Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator041, Method: assocOperator041Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator043
	@Override
    public Boolean assocOperator043(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator043Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator043, Method: assocOperator043";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator043
	@Override
    public Boolean assocOperator043Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator043Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator043
	@Override
    public SQLExists assocOperator043Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator043, Method: assocOperator043Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator047
	@Override
    public Long assocOperator047(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Documentos)
            return assocOperator047Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator047, Method: assocOperator047";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator047
	@Override
    public Long assocOperator047Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator047Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator047
	@Override
    public SQLCount assocOperator047Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator047, Method: assocOperator047Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator048
	@Override
    public Long assocOperator048(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Documentos) WHERE (Documentos.Estado = 1)
            return assocOperator048Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator048, Method: assocOperator048";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator048
	@Override
    public Long assocOperator048Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator048Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator048
	@Override
    public SQLCount assocOperator048Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Documentos.Estado = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS + "." + DocumentoNovedadConstants.ATTR_NAME_DOCUMENTONOVEDADESTADO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator048, Method: assocOperator048Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator049
	@Override
    public Long assocOperator049(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Documentos) WHERE (Documentos.Estado = 3)
            return assocOperator049Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator049, Method: assocOperator049";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator049
	@Override
    public Long assocOperator049Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator049Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator049
	@Override
    public SQLCount assocOperator049Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Documentos.Estado = 3
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_DOCUMENTOS + "." + DocumentoNovedadConstants.ATTR_NAME_DOCUMENTONOVEDADESTADO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(3), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator049, Method: assocOperator049Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator051
	@Override
    public Boolean assocOperator051(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator051Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator051, Method: assocOperator051";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator051
	@Override
    public Boolean assocOperator051Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator051Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator051
	@Override
    public SQLExists assocOperator051Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator051, Method: assocOperator051Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
