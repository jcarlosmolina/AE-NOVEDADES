package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsesorJpaRepository extends JpaRepository<Asesor, Long>, AsesorJpaRepositoryCustom {

    List<Asesor> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);
}
