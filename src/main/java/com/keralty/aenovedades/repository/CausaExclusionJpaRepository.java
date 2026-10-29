package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.CausaExclusion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CausaExclusionJpaRepository extends JpaRepository<CausaExclusion, Long>, CausaExclusionJpaRepositoryCustom {
}
