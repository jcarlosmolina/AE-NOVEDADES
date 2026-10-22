package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.MotivoExcepcionSolNov;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface MotivoExcepcionSolNovJpaRepositoryCustom {

    List<MotivoExcepcionSolNov> solveQuery(SQLSelect query);
    
    List<MotivoExcepcionSolNov> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<MotivoExcepcionSolNov> executeQuery(String query);

    public List<MotivoExcepcionSolNov> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
