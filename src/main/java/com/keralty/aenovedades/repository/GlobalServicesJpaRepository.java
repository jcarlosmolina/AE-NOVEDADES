package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalServicesJpaRepository {

    Collection<SolicitudNovedad> assocOperator131() throws SystemException;

    Collection<SolicitudNovedad> assocOperator132(Long tGSOLNOVSETTRAptNumRadicado) throws SystemException;

    void refreshEntity(Object object);
}
