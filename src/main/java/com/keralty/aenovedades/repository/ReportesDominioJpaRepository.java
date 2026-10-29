package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.oid.ReportesDominioOid;
import com.keralty.aenovedades.persistence.ReportesDominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportesDominioJpaRepository extends JpaRepository<ReportesDominio, ReportesDominioOid>, ReportesDominioJpaRepositoryCustom {
}
