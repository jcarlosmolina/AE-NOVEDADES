package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.ReportesDominio;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.sqlutils.SQLCount;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLGetOne;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface SolicitudNovedadJpaRepositoryCustom {

    Long getSiguienteNumRadicado(boolean esVoluntario);

    List<SolicitudNovedad> solveQuery(SQLSelect query);
    
    List<SolicitudNovedad> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000() throws SystemException;

    Boolean assocOperator000Range1() throws SystemException;
    
    SQLExists assocOperator000Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator001() throws SystemException;

    Long assocOperator001Range1() throws SystemException;
    
    SQLCount assocOperator001Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator002(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator002Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator003(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator003Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator004(SolicitudNovedad instance) throws SystemException;

    Long assocOperator004Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator004Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator005(SolicitudNovedad instance) throws SystemException;

    Long assocOperator005Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator005Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator006(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator006Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator007(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator007Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator007Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator008(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator008Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator008Range1Query(SolicitudNovedad instance) throws SystemException;

    String assocOperator009(SolicitudNovedad instance) throws SystemException;

    String assocOperator009Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLGetOne assocOperator009Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator010(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator010Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(SolicitudNovedad instance) throws SystemException;

    String assocOperator011(SolicitudNovedad instance) throws SystemException;

    String assocOperator011Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLGetOne assocOperator011Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator012(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator012Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(SolicitudNovedad instance) throws SystemException;

    String assocOperator013(SolicitudNovedad instance) throws SystemException;

    String assocOperator013Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLGetOne assocOperator013Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator014(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator014Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator015(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator015Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator016(String vfTipoIdent, String vfNumIdent) throws SystemException;

    Long assocOperator016Range1(String vfTipoIdent, String vfNumIdent) throws SystemException;
    
    SQLCount assocOperator016Range1Query(String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException;

    Long assocOperator017(String vfTipoIdent, String vfNumIdent) throws SystemException;

    Long assocOperator017Range1(String vfTipoIdent, String vfNumIdent) throws SystemException;
    
    SQLCount assocOperator017Range1Query(String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator018(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator018Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator018Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator019(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator019Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator019Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator020(SolicitudNovedad instance, Long solicitudNovedadTADDFAMILIAptNumFamilia) throws SystemException;

    Long assocOperator020Range1(SolicitudNovedad instance, Long solicitudNovedadTADDFAMILIAptNumFamilia) throws SystemException;
    
    SQLCount assocOperator020Range1Query(SolicitudNovedad instance, Long solicitudNovedadTADDFAMILIAptNumFamilia) throws SystemException;

    Long assocOperator021(SolicitudNovedad instance) throws SystemException;

    Long assocOperator021Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator021Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator022(SolicitudNovedad instance) throws SystemException;

    Long assocOperator022Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator022Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator023(SolicitudNovedad instance) throws SystemException;

    Long assocOperator023Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator023Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator024(SolicitudNovedad instance) throws SystemException;

    Long assocOperator024Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator024Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator025(SolicitudNovedad instance) throws SystemException;

    Long assocOperator025Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator025Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator026(SolicitudNovedad instance) throws SystemException;

    Collection<ReportesDominio> assocOperator026Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator026Range1Query(SolicitudNovedad instance) throws SystemException;

    String assocOperator027(SolicitudNovedad instance) throws SystemException;

    Collection<ReportesDominio> assocOperator027Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator027Range1Query(SolicitudNovedad instance) throws SystemException;

    Collection<FamiliaNovedad> assocOperator028(SolicitudNovedad instance) throws SystemException;

    Collection<FamiliaNovedad> assocOperator028Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator028Range1Query(SolicitudNovedad instance) throws SystemException;

    Collection<DocumentoNovedad> assocOperator030(SolicitudNovedad instance) throws SystemException;

    Collection<DocumentoNovedad> assocOperator030Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator030Range1Query(SolicitudNovedad instance) throws SystemException;

    Collection<NovedadCT> assocOperator031(SolicitudNovedad instance) throws SystemException;

    Collection<NovedadCT> assocOperator031Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator031Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator032(SolicitudNovedad instance) throws SystemException;

    Long assocOperator032Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator032Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator034(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator034Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator034Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator036(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator036Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator036Range1Query(SolicitudNovedad instance) throws SystemException;

    Collection<DocumentoNovedad> assocOperator037(SolicitudNovedad instance) throws SystemException;

    Collection<DocumentoNovedad> assocOperator037Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator037Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator039(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator039Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator039Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator041(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator041Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator041Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator043(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator043Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator043Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator047(SolicitudNovedad instance) throws SystemException;

    Long assocOperator047Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator047Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator048(SolicitudNovedad instance) throws SystemException;

    Long assocOperator048Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator048Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator049(SolicitudNovedad instance) throws SystemException;

    Long assocOperator049Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator049Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator051(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator051Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator051Range1Query(SolicitudNovedad instance) throws SystemException;

    public List<SolicitudNovedad> executeQuery(String query);

    public List<SolicitudNovedad> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
