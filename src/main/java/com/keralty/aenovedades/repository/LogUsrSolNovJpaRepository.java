package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.LogUsrSolNov;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogUsrSolNovJpaRepository extends JpaRepository<LogUsrSolNov, Long>, LogUsrSolNovJpaRepositoryCustom {

    List<LogUsrSolNov> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);
}
