package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.LogEstadoSN;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEstadoSNJpaRepository extends JpaRepository<LogEstadoSN, Long>, LogEstadoSNJpaRepositoryCustom {

    List<LogEstadoSN> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);
}
