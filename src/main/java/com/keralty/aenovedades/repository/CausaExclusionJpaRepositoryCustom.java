package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.CausaExclusion;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface CausaExclusionJpaRepositoryCustom {

    List<CausaExclusion> solveQuery(SQLSelect query);
    
    List<CausaExclusion> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<CausaExclusion> executeQuery(String query);

    public List<CausaExclusion> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
