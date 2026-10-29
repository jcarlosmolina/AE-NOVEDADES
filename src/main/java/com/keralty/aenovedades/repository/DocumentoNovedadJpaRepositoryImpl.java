package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.global.LogEstadoDocNovConstants;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.sqlutils.SQLParam;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.TypedQueryBuilder;
import com.keralty.aenovedades.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class DocumentoNovedadJpaRepositoryImpl extends AbstractRepository implements DocumentoNovedadJpaRepositoryCustom {

    @Inject
    public DocumentoNovedadJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<DocumentoNovedad> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<DocumentoNovedad> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<DocumentoNovedad> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<DocumentoNovedad> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, DocumentoNovedad.class);
    }

    @Override	
    public List<DocumentoNovedad> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<DocumentoNovedad> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Collection<LogEstadoDocNov> assocOperator000(DocumentoNovedad instance) throws SystemException {
        try {
            // FOR ALL LogEstadoDocNov DO LogEstadoDocNov.eliminar(LogEstadoDocNov)
        return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DocumentoNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Collection<LogEstadoDocNov> assocOperator000Range1 (DocumentoNovedad instance) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<LogEstadoDocNov>(em, LogEstadoDocNov.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLPopulation assocOperator000Range1Query (DocumentoNovedad instance) throws SystemException {
        try {
            return new SQLPopulation(DocumentoNovedadConstants.CLASS_NAME, LogEstadoDocNovConstants.CLASS_NAME, instance.getOid(), DocumentoNovedadConstants.ROLE_NAME_LOGESTADODOCNOV);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DocumentoNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
