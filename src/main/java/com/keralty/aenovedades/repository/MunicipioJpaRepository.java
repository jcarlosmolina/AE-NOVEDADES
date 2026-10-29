package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Municipio;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.NovedadMD;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioJpaRepository extends JpaRepository<Municipio, Long>, MunicipioJpaRepositoryCustom {

    List<Municipio> findByNovedadCTNac(NovedadCT novedadCTNac);

    List<Municipio> findByNovedadCTRes(NovedadCT novedadCTRes);

    List<Municipio> findByNovedadesMD(NovedadMD novedadesMD);
}
