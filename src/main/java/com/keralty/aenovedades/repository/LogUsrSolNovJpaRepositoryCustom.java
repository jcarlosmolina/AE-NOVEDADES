package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.LogUsrSolNov;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface LogUsrSolNovJpaRepositoryCustom {

    List<LogUsrSolNov> solveQuery(SQLSelect query);
    
    List<LogUsrSolNov> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogUsrSolNov> executeQuery(String query);

    public List<LogUsrSolNov> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
