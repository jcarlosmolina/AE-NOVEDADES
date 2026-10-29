package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface DocumentoNovedadJpaRepositoryCustom {

    List<DocumentoNovedad> solveQuery(SQLSelect query);
    
    List<DocumentoNovedad> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Collection<LogEstadoDocNov> assocOperator000(DocumentoNovedad instance) throws SystemException;

    Collection<LogEstadoDocNov> assocOperator000Range1(DocumentoNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator000Range1Query(DocumentoNovedad instance) throws SystemException;

    public List<DocumentoNovedad> executeQuery(String query);

    public List<DocumentoNovedad> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
