package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Departamento;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.NovedadMD;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoJpaRepository extends JpaRepository<Departamento, Long>, DepartamentoJpaRepositoryCustom {

    List<Departamento> findByNovedadCTNac(NovedadCT novedadCTNac);

    List<Departamento> findByNovedadCTRes(NovedadCT novedadCTRes);

    List<Departamento> findByNovedadesMD(NovedadMD novedadesMD);
}
