package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.PlantillaReporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantillaReporteJpaRepository extends JpaRepository<PlantillaReporte, Long>, PlantillaReporteJpaRepositoryCustom {
}
