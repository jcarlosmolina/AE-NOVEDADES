package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.TypedQueryBuilder;
import com.keralty.aenovedades.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class LogEstadoDocNovJpaRepositoryImpl extends AbstractRepository implements LogEstadoDocNovJpaRepositoryCustom {

    @Inject
    public LogEstadoDocNovJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<LogEstadoDocNov> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<LogEstadoDocNov> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<LogEstadoDocNov> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<LogEstadoDocNov> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, LogEstadoDocNov.class);
    }

    @Override	
    public List<LogEstadoDocNov> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<LogEstadoDocNov> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
