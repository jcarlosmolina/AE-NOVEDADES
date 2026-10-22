package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Afiliaciones;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface AfiliacionesJpaRepositoryCustom {

    List<Afiliaciones> solveQuery(SQLSelect query);
    
    List<Afiliaciones> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Afiliaciones> executeQuery(String query);

    public List<Afiliaciones> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
