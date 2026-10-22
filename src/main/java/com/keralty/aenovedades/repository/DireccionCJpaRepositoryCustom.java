package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.DireccionC;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface DireccionCJpaRepositoryCustom {

    List<DireccionC> solveQuery(SQLSelect query);
    
    List<DireccionC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(DireccionC instance) throws SystemException;

    Boolean assocOperator000Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator001(DireccionC instance) throws SystemException;

    Boolean assocOperator001Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(DireccionC instance) throws SystemException;

    public List<DireccionC> executeQuery(String query);

    public List<DireccionC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
