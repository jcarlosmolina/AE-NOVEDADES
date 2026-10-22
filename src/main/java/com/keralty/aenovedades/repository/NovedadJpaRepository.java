package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Novedad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadJpaRepository extends JpaRepository<Novedad, Long>, NovedadJpaRepositoryCustom {

    List<Novedad> findBySolicitudes(SolicitudNovedad solicitudes);
}
