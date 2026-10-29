package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.AreaMedica;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface AreaMedicaJpaRepositoryCustom {

    List<AreaMedica> solveQuery(SQLSelect query);
    
    List<AreaMedica> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<AreaMedica> executeQuery(String query);

    public List<AreaMedica> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
