package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Dominio;
import com.keralty.aenovedades.persistence.Periodicidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DominioJpaRepository extends JpaRepository<Dominio, Long>, DominioJpaRepositoryCustom {

    List<Dominio> findByPeriodicidades(Periodicidad periodicidades);
}
