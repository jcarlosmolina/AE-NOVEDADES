package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisJpaRepository extends JpaRepository<Pais, String>, PaisJpaRepositoryCustom {

    List<Pais> findByNovedadCT(NovedadCT novedadCT);

    List<Pais> findByNovedadesMD(NovedadMD novedadesMD);
}
