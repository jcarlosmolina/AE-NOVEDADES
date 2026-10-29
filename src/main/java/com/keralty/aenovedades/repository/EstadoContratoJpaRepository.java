package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoContratoJpaRepository extends JpaRepository<EstadoContrato, Long>, EstadoContratoJpaRepositoryCustom {

    List<EstadoContrato> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);
}
