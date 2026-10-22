package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.MotivoExcepcionSolNov;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoExcepcionSolNovJpaRepository extends JpaRepository<MotivoExcepcionSolNov, Long>, MotivoExcepcionSolNovJpaRepositoryCustom {

    List<MotivoExcepcionSolNov> findBySolicitudes(SolicitudNovedad solicitudes);
}
