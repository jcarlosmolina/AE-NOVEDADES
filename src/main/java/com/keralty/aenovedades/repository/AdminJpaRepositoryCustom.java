package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Admin;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface AdminJpaRepositoryCustom {

    List<Admin> solveQuery(SQLSelect query);
    
    List<Admin> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Admin> executeQuery(String query);

    public List<Admin> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
