package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodicidadJpaRepository extends JpaRepository<Periodicidad, Long>, PeriodicidadJpaRepositoryCustom {

    List<Periodicidad> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Periodicidad> findBySolicitudesNovedadNueva(SolicitudNovedad solicitudesNovedadNueva);
}
