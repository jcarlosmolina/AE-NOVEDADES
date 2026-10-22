package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorJpaRepository extends JpaRepository<Gestor, Long>, GestorJpaRepositoryCustom {
}
