package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.AnexoMat;
import com.keralty.aenovedades.persistence.Periodicidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoMatJpaRepository extends JpaRepository<AnexoMat, Long>, AnexoMatJpaRepositoryCustom {

    List<AnexoMat> findByPeriodicidad(Periodicidad periodicidad);
}
