package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface ProteccionDatosJpaRepositoryCustom {

    List<ProteccionDatos> solveQuery(SQLSelect query);
    
    List<ProteccionDatos> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<ProteccionDatos> executeQuery(String query);

    public List<ProteccionDatos> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
