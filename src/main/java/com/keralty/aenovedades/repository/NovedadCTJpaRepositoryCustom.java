package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface NovedadCTJpaRepositoryCustom {

    List<NovedadCT> solveQuery(SQLSelect query);
    
    List<NovedadCT> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator001(NovedadCT instance) throws SystemException;

    Boolean assocOperator001Range1(NovedadCT instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(NovedadCT instance) throws SystemException;

    Collection<Firma> assocOperator002(NovedadCT instance) throws SystemException;

    Collection<Firma> assocOperator002Range1(NovedadCT instance) throws SystemException;
    
    SQLPopulation assocOperator002Range1Query(NovedadCT instance) throws SystemException;

    public List<NovedadCT> executeQuery(String query);

    public List<NovedadCT> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
