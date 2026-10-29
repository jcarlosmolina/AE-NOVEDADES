package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.AreaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaMedicaJpaRepository extends JpaRepository<AreaMedica, Long>, AreaMedicaJpaRepositoryCustom {
}
