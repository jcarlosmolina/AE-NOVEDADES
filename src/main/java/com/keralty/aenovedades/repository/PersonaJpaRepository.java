package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Persona;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaJpaRepository extends JpaRepository<Persona, Long>, PersonaJpaRepositoryCustom {

    List<Persona> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);
}
