package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.TipoNovedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoNovedadJpaRepository extends JpaRepository<TipoNovedad, Long>, TipoNovedadJpaRepositoryCustom {
}
