package com.keralty.aenovedades.service;

import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.PaisConstants;
import com.keralty.aenovedades.persistence.oid.PaisOid;
import com.keralty.aenovedades.persistence.Pais;
import com.keralty.aenovedades.repository.PaisJpaRepository;
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
public class PaisService extends AbstractService {

    PaisJpaRepository repository;

    PaisService paisSrv;

    @Inject
    public PaisService(
            PaisService paisSrv,
            PaisJpaRepository repository) {
        this.paisSrv = paisSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Pais by ID
     *
     * @param paisCodigo Identification field paisCodigo
     *
     * @return Instance of Pais
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Pais getById(String paisCodigo) {
        return getByOID(new PaisOid(paisCodigo));
    }
    
    /*
     * Returns an instance of Pais by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pais
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Pais getByOID(PaisOid oid) {
        Optional<Pais> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Pais by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pais
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Pais getByOIDWithHV(PaisOid oid) {
        Optional<Pais> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Pais> getInstanceByOid(PaisOid oid) {
        return oid != null && oid.getPaisCodigo() != null
               ? repository.findById(oid.getPaisCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Pais by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Pais
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Pais getByJsonOid(String jsonOid) {
        PaisOid oid = new PaisOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PaisOid oid = new PaisOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PaisConstants.ATTR_FIELD_PAISCODIGO, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPaisCodigo(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PaisService.class).error(e.getMessage());
        }
    }

}
