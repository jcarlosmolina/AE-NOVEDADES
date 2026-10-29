package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.SuperAdmin;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface SuperAdminJpaRepositoryCustom {

    List<SuperAdmin> solveQuery(SQLSelect query);
    
    List<SuperAdmin> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<SuperAdmin> executeQuery(String query);

    public List<SuperAdmin> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
