package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.FirmaConstants;
import com.keralty.aenovedades.global.NovedadCTConstants;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.TypedQueryBuilder;
import com.keralty.aenovedades.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class NovedadCTJpaRepositoryImpl extends AbstractRepository implements NovedadCTJpaRepositoryCustom {

    @Inject
    public NovedadCTJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<NovedadCT> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<NovedadCT> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<NovedadCT> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<NovedadCT> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, NovedadCT.class);
    }

    @Override	
    public List<NovedadCT> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<NovedadCT> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator001
	@Override
    public Boolean assocOperator001(NovedadCT instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: NovedadCT, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Boolean assocOperator001Range1 (NovedadCT instance) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(instance);
        return !new TypedQueryBuilder<NovedadCT>(em, NovedadCT.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLExists assocOperator001Range1Query (NovedadCT instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(NovedadCTConstants.CLASS_NAME, NovedadCTConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: NovedadCT, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Collection<Firma> assocOperator002(NovedadCT instance) throws SystemException {
        try {
            // FOR ALL Firma DO Firma.eliminarInterno(Firma)
        return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: NovedadCT, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Collection<Firma> assocOperator002Range1 (NovedadCT instance) throws SystemException {

        SQLSelect sql = assocOperator002Range1Query(instance);
        return new TypedQueryBuilder<Firma>(em, Firma.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLPopulation assocOperator002Range1Query (NovedadCT instance) throws SystemException {
        try {
            return new SQLPopulation(NovedadCTConstants.CLASS_NAME, FirmaConstants.CLASS_NAME, instance.getOid(), NovedadCTConstants.ROLE_NAME_FIRMA);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: NovedadCT, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
