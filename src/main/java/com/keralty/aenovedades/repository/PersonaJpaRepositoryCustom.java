package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.Persona;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.List;

public interface PersonaJpaRepositoryCustom {

    List<Persona> solveQuery(SQLSelect query);
    
    List<Persona> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(Persona instance) throws SystemException;

    Boolean assocOperator000Range1(Persona instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(Persona instance) throws SystemException;

    Boolean assocOperator001(Persona instance) throws SystemException;

    Boolean assocOperator001Range1(Persona instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(Persona instance) throws SystemException;

    Boolean assocOperator002(Persona instance) throws SystemException;

    Boolean assocOperator002Range1(Persona instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(Persona instance) throws SystemException;

    Boolean assocOperator003(Persona instance) throws SystemException;

    Boolean assocOperator003Range1(Persona instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(Persona instance) throws SystemException;

    Boolean assocOperator004(Persona instance) throws SystemException;

    Boolean assocOperator004Range1(Persona instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(Persona instance) throws SystemException;

    public List<Persona> executeQuery(String query);

    public List<Persona> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
