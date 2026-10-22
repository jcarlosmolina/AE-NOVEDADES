package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.Gestor;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface GestorJpaRepositoryCustom {

    List<Gestor> solveQuery(SQLSelect query);
    
    List<Gestor> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Gestor> executeQuery(String query);

    public List<Gestor> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
