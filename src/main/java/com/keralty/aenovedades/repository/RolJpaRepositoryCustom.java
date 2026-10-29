package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Rol;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface RolJpaRepositoryCustom {

    List<Rol> solveQuery(SQLSelect query);
    
    List<Rol> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Rol> executeQuery(String query);

    public List<Rol> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
