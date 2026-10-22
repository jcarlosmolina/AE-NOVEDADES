package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.TypedQueryBuilder;
import com.keralty.aenovedades.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class ProteccionDatosJpaRepositoryImpl extends AbstractRepository implements ProteccionDatosJpaRepositoryCustom {

    @Inject
    public ProteccionDatosJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<ProteccionDatos> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ProteccionDatos> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ProteccionDatos> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ProteccionDatos> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ProteccionDatos.class);
    }

    @Override	
    public List<ProteccionDatos> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<ProteccionDatos> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
