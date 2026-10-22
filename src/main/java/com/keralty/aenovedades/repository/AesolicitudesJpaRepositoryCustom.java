package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Aesolicitudes;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface AesolicitudesJpaRepositoryCustom {

    List<Aesolicitudes> solveQuery(SQLSelect query);
    
    List<Aesolicitudes> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Aesolicitudes> executeQuery(String query);

    public List<Aesolicitudes> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
