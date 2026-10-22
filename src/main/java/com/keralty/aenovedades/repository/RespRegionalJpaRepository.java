package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.RespRegional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespRegionalJpaRepository extends JpaRepository<RespRegional, Long>, RespRegionalJpaRepositoryCustom {

    List<RespRegional> findByFirma(Firma firma);
}
