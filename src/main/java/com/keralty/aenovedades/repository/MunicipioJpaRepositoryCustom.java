package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface MunicipioJpaRepositoryCustom {

    List<Municipio> solveQuery(SQLSelect query);
    
    List<Municipio> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Municipio> executeQuery(String query);

    public List<Municipio> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
