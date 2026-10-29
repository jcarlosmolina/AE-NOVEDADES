package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Afiliaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfiliacionesJpaRepository extends JpaRepository<Afiliaciones, Long>, AfiliacionesJpaRepositoryCustom {
}
