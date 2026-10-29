package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface AsesorJpaRepositoryCustom {

    List<Asesor> solveQuery(SQLSelect query);
    
    List<Asesor> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Asesor> executeQuery(String query);

    public List<Asesor> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
