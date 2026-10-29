package com.keralty.aenovedades.service;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.Constants;
import com.keralty.aenovedades.global.ProteccionDatosConstants;
import com.keralty.aenovedades.persistence.oid.ProteccionDatosOid;
import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.repository.ProteccionDatosJpaRepository;
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
public class ProteccionDatosService extends AbstractService {

    ProteccionDatosJpaRepository repository;

    ProteccionDatosService proteccionDatosSrv;

    @Inject
    public ProteccionDatosService(
            ProteccionDatosService proteccionDatosSrv,
            ProteccionDatosJpaRepository repository) {
        this.proteccionDatosSrv = proteccionDatosSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of ProteccionDatos by ID
     *
     * @param proteccionDatosIdentificador Identification field proteccionDatosIdentificador
     *
     * @return Instance of ProteccionDatos
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatos getById(Long proteccionDatosIdentificador) {
        return getByOID(new ProteccionDatosOid(proteccionDatosIdentificador));
    }
    
    /*
     * Returns an instance of ProteccionDatos by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatos
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatos getByOID(ProteccionDatosOid oid) {
        Optional<ProteccionDatos> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ProteccionDatos by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ProteccionDatos getByOIDWithHV(ProteccionDatosOid oid) {
        Optional<ProteccionDatos> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ProteccionDatos> getInstanceByOid(ProteccionDatosOid oid) {
        return oid != null && oid.getProteccionDatosIdentificador() != null
               ? repository.findById(oid.getProteccionDatosIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of ProteccionDatos by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ProteccionDatos
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatos getByJsonOid(String jsonOid) {
        ProteccionDatosOid oid = new ProteccionDatosOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ProteccionDatosOid oid = new ProteccionDatosOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProteccionDatosConstants.ATTR_FIELD_PROTECCIONDATOSIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getProteccionDatosIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ProteccionDatosService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
