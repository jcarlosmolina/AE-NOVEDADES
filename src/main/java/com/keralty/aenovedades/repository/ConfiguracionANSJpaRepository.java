package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.ConfiguracionANS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracionANSJpaRepository extends JpaRepository<ConfiguracionANS, Long>, ConfiguracionANSJpaRepositoryCustom {
}
