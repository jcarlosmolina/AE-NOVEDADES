package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface LogEstadoDocNovJpaRepositoryCustom {

    List<LogEstadoDocNov> solveQuery(SQLSelect query);
    
    List<LogEstadoDocNov> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogEstadoDocNov> executeQuery(String query);

    public List<LogEstadoDocNov> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
