package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.ParentescoDom;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface ParentescoDomJpaRepositoryCustom {

    List<ParentescoDom> solveQuery(SQLSelect query);
    
    List<ParentescoDom> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextParentescoDomIdentificador(Long dominioNumero);

    public List<ParentescoDom> executeQuery(String query);

    public List<ParentescoDom> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
