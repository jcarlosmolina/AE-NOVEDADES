package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Dominio;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface DominioJpaRepositoryCustom {

    List<Dominio> solveQuery(SQLSelect query);
    
    List<Dominio> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Dominio> executeQuery(String query);

    public List<Dominio> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
