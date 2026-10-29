package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import com.keralty.aenovedades.sqlutils.SQLCount;
import com.keralty.aenovedades.sqlutils.SQLExists;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface FamiliaNovedadJpaRepositoryCustom {

    List<FamiliaNovedad> solveQuery(SQLSelect query);
    
    List<FamiliaNovedad> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator000Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator001(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator001Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator002(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator002Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator002Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator003(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator003Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(FamiliaNovedad instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator004(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator004Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(FamiliaNovedad instance, SQLSelect superQuery) throws SystemException;

    Long assocOperator005(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator005Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator005Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator006(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator006Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(FamiliaNovedad instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator007(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator007Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator007Range1Query(FamiliaNovedad instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator008(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator008Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator008Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator009(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator009Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator009Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator010(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator010Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator011(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator011Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator012(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator012Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator013(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator013Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator013Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator014(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator014Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator015(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator015Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator016(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator016Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator016Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator017(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator017Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator017Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator018(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator018Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator018Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator019(FamiliaNovedad instance) throws SystemException;

    Long assocOperator019Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLCount assocOperator019Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator020(FamiliaNovedad instance) throws SystemException;

    Long assocOperator020Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLCount assocOperator020Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator021(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator021Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator021Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator022(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator022Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator022Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator023(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator023Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator023Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator024(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator024Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator024Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator025(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator025Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator025Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator026(FamiliaNovedad instance) throws SystemException;

    Long assocOperator026Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLCount assocOperator026Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator027(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator027Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator027Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator028(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator028Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator028Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator029(FamiliaNovedad instance) throws SystemException;

    Long assocOperator029Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLCount assocOperator029Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator030(FamiliaNovedad instance) throws SystemException;

    Long assocOperator030Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLCount assocOperator030Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator031(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator031Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator031Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator032(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator032Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator032Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator033(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator033Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator033Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator034(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator034Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator034Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator035(FamiliaNovedad instance) throws SystemException;

    Long assocOperator035Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLCount assocOperator035Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator036(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator036Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator036Range1Query(FamiliaNovedad instance) throws SystemException;

    Long assocOperator037(FamiliaNovedad instance) throws SystemException;

    Long assocOperator037Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLCount assocOperator037Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator039(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator039Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator039Range1Query(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator040(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator040Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator040Range1Query(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadMD> assocOperator041(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadMD> assocOperator041Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator041Range1Query(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadCT> assocOperator042(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadCT> assocOperator042Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator042Range1Query(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator044(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;

    Collection<UsuarioNovedad> assocOperator044Range1(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;
    
    SQLPopulation assocOperator044Range1Query(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;

    Boolean assocOperator046(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;

    Boolean assocOperator046Range1(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;
    
    SQLExists assocOperator046Range1Query(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;

    Long assocOperator047(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;

    Long assocOperator047Range1(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;
    
    SQLCount assocOperator047Range1Query(FamiliaNovedad instance, TipoIdentificacion familiaNovedadTADDTITULARptpagrTipoIdentificacion, String familiaNovedadTADDTITULARptpatrNumIdentificacion) throws SystemException;

    Collection<UsuarioNovedad> assocOperator048(FamiliaNovedad instance) throws SystemException;

    Collection<UsuarioNovedad> assocOperator048Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator048Range1Query(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadCT> assocOperator049(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadCT> assocOperator049Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator049Range1Query(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadMD> assocOperator050(FamiliaNovedad instance) throws SystemException;

    Collection<NovedadMD> assocOperator050Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator050Range1Query(FamiliaNovedad instance) throws SystemException;

    Collection<Firma> assocOperator051(FamiliaNovedad instance) throws SystemException;

    Collection<Firma> assocOperator051Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLPopulation assocOperator051Range1Query(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator053(FamiliaNovedad instance) throws SystemException;

    Boolean assocOperator053Range1(FamiliaNovedad instance) throws SystemException;
    
    SQLExists assocOperator053Range1Query(FamiliaNovedad instance) throws SystemException;

    public List<FamiliaNovedad> executeQuery(String query);

    public List<FamiliaNovedad> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
