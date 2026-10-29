package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.PlantillaReporte;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface PlantillaReporteJpaRepositoryCustom {

    List<PlantillaReporte> solveQuery(SQLSelect query);
    
    List<PlantillaReporte> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<PlantillaReporte> executeQuery(String query);

    public List<PlantillaReporte> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
