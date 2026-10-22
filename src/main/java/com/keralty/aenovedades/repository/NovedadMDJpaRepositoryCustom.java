package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface NovedadMDJpaRepositoryCustom {

    List<NovedadMD> solveQuery(SQLSelect query);
    
    List<NovedadMD> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<NovedadMD> executeQuery(String query);

    public List<NovedadMD> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
