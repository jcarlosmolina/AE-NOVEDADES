package com.keralty.aenovedades.service;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.MotivoExcepcionSolNovConstants;
import com.keralty.aenovedades.persistence.MotivoExcepcionSolNov;
import com.keralty.aenovedades.persistence.oid.MotivoExcepcionSolNovOid;
import com.keralty.aenovedades.repository.MotivoExcepcionSolNovJpaRepository;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.SQLWhereComparison;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aenovedades.sqlutils.SQLWhereOperandPathAttribute;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class MotivoExcepcionSolNovService extends AbstractService {

    MotivoExcepcionSolNovJpaRepository repository;

    MotivoExcepcionSolNovService motivoExcepcionSolNovSrv;

    @Inject
    public MotivoExcepcionSolNovService(
            MotivoExcepcionSolNovService motivoExcepcionSolNovSrv,
            MotivoExcepcionSolNovJpaRepository repository) {
        this.motivoExcepcionSolNovSrv = motivoExcepcionSolNovSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of MotivoExcepcionSolNov by ID
     *
     * @param motivoExcepcionSolNovId Identification field motivoExcepcionSolNovId
     *
     * @return Instance of MotivoExcepcionSolNov
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public MotivoExcepcionSolNov getById(Long motivoExcepcionSolNovId) {
        return getByOID(new MotivoExcepcionSolNovOid(motivoExcepcionSolNovId));
    }
    
    /*
     * Returns an instance of MotivoExcepcionSolNov by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of MotivoExcepcionSolNov
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public MotivoExcepcionSolNov getByOID(MotivoExcepcionSolNovOid oid) {
        Optional<MotivoExcepcionSolNov> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of MotivoExcepcionSolNov by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of MotivoExcepcionSolNov
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public MotivoExcepcionSolNov getByOIDWithHV(MotivoExcepcionSolNovOid oid) {
        Optional<MotivoExcepcionSolNov> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<MotivoExcepcionSolNov> getInstanceByOid(MotivoExcepcionSolNovOid oid) {
        return oid != null && oid.getMotivoExcepcionSolNovId() != null
               ? repository.findById(oid.getMotivoExcepcionSolNovId())
               : Optional.empty();
    }

    /*
     * Returns an instance of MotivoExcepcionSolNov by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of MotivoExcepcionSolNov
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public MotivoExcepcionSolNov getByJsonOid(String jsonOid) {
        MotivoExcepcionSolNovOid oid = new MotivoExcepcionSolNovOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            MotivoExcepcionSolNovOid oid = new MotivoExcepcionSolNovOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(MotivoExcepcionSolNovConstants.ATTR_FIELD_MOTIVOEXCEPCIONSOLNOVID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getMotivoExcepcionSolNovId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(MotivoExcepcionSolNovService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
