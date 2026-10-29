package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.LogEstadoSN;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface LogEstadoSNJpaRepositoryCustom {

    List<LogEstadoSN> solveQuery(SQLSelect query);
    
    List<LogEstadoSN> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogEstadoSN> executeQuery(String query);

    public List<LogEstadoSN> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
