package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.sqlutils.SQLCount;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface UsuarioNovedadJpaRepositoryCustom {

    List<UsuarioNovedad> solveQuery(SQLSelect query);
    
    List<UsuarioNovedad> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator000Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator001(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator001Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(UsuarioNovedad instance) throws SystemException;

    Long assocOperator002(UsuarioNovedad instance) throws SystemException;

    Long assocOperator002Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLCount assocOperator002Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator003(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator003Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator004(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator004Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator005(UsuarioNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator005Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator005Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator006(UsuarioNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator006Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator006Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator007(UsuarioNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator007Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator007Range1Query(UsuarioNovedad instance) throws SystemException;

    Long assocOperator008(UsuarioNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator008Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator008Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator009(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator009Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator009Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator010(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator010Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator011(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator011Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator012(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator012Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator013(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator013Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator013Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator014(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator014Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator015(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator015Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator016(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator016Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator016Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator017(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator017Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator017Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator018(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator018Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator018Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator019(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator019Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator019Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator020(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator020Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator020Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator021(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator021Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator021Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator022(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator022Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator022Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator023(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator023Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator023Range1Query(UsuarioNovedad instance) throws SystemException;

    Long assocOperator024(UsuarioNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator024Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator024Range1Query(UsuarioNovedad instance) throws SystemException;

    Long assocOperator025(UsuarioNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator025Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator025Range1Query(UsuarioNovedad instance) throws SystemException;

    Long assocOperator026(UsuarioNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator026Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator026Range1Query(UsuarioNovedad instance) throws SystemException;

    Collection<DocumentoNovedad> assocOperator027(UsuarioNovedad instance) throws SystemException;

    Collection<DocumentoNovedad> assocOperator027Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator027Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator029(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator029Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator029Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator031(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator031Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator031Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator034(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator034Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator034Range1Query(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator035(UsuarioNovedad instance) throws SystemException;

    Boolean assocOperator035Range1(UsuarioNovedad instance) throws SystemException;
    
    SQLExists assocOperator035Range1Query(UsuarioNovedad instance) throws SystemException;

    public List<UsuarioNovedad> executeQuery(String query);

    public List<UsuarioNovedad> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
