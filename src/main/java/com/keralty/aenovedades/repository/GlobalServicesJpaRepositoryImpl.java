package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.SolicitudNovedadConstants;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.sqlutils.SQLPopulation;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereConjunction;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aenovedades.sqlutils.TypedQueryBuilder;
import com.keralty.aenovedades.utils.Agent;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class GlobalServicesJpaRepositoryImpl extends AbstractRepository implements GlobalServicesJpaRepository {

    @Inject
    public GlobalServicesJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    // AssocOperator: AssocOperator131
	@Override
    public Collection<SolicitudNovedad> assocOperator131() throws SystemException {
        try {
            // FOR ALL SolicitudNovedad WHERE (1 > 2) DO TGSOLNOVSETTRA(1; oaNumProcesados, oaNumErrores, oaErrores)
            Collection<SolicitudNovedad> results = new ArrayList<>();
            for(SolicitudNovedad item : assocOperator131Range1()) {
                // 1 > 2
                if(Long.valueOf(1) > Long.valueOf(2))
                    results.add(item);
            }
            return results;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator131, Method: assocOperator131";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<SolicitudNovedad> assocOperator131Range1 () throws SystemException {

        SQLSelect sql = assocOperator131Range1Query();
        return new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute();
    }


    public SQLPopulation assocOperator131Range1Query () throws SystemException {
        try {
            return new SQLPopulation("", SolicitudNovedadConstants.CLASS_NAME);
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator131, Method: assocOperator131Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator132
	@Override
    public Collection<SolicitudNovedad> assocOperator132(Long tGSOLNOVSETTRAptNumRadicado) throws SystemException {
        try {
            // FOR ALL SolicitudNovedad WHERE (SolicitudNovedad.NumRadicado = ptNumRadicado) DO SolicitudNovedad.TMARCARTRAMITADA(SolicitudNovedad; ptoaNumProcesados, ptoaNumErrores, ptoaErrores)
            return assocOperator132Range1(tGSOLNOVSETTRAptNumRadicado);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator132, Method: assocOperator132";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<SolicitudNovedad> assocOperator132Range1 (Long tGSOLNOVSETTRAptNumRadicado) throws SystemException {

        SQLSelect sql = assocOperator132Range1Query(tGSOLNOVSETTRAptNumRadicado);
        return new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute();
    }


    public SQLPopulation assocOperator132Range1Query (Long tGSOLNOVSETTRAptNumRadicado) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SolicitudNovedadConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // SolicitudNovedad.NumRadicado = ptNumRadicado
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.CLASS_NAME + "." + SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSOLNOVSETTRAptNumRadicado, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator132, Method: assocOperator132Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
