package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.AnexoNeo;
import com.keralty.aenovedades.persistence.Periodicidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoNeoJpaRepository extends JpaRepository<AnexoNeo, Long>, AnexoNeoJpaRepositoryCustom {

    List<AnexoNeo> findByPeriodicidad(Periodicidad periodicidad);
}
