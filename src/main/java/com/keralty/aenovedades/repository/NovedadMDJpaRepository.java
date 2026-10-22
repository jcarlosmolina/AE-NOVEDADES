package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.NovedadMD;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadMDJpaRepository extends JpaRepository<NovedadMD, Long>, NovedadMDJpaRepositoryCustom {

    List<NovedadMD> findByFamiliaNovedad(FamiliaNovedad familiaNovedad);
}
