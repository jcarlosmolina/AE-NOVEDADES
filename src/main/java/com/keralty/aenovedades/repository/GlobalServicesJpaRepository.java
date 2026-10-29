package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalServicesJpaRepository {

    Collection<SolicitudNovedad> assocOperator137() throws SystemException;

    Collection<SolicitudNovedad> assocOperator138(Long tGSOLNOVSETTRAptNumRadicado) throws SystemException;

    void refreshEntity(Object object);
}
