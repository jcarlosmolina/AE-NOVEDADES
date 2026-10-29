package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.DireccionC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionCJpaRepository extends JpaRepository<DireccionC, Long>, DireccionCJpaRepositoryCustom {
}
