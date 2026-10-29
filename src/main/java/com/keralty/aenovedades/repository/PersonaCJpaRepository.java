package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.PersonaC;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaCJpaRepository extends JpaRepository<PersonaC, Long>, PersonaCJpaRepositoryCustom {

    List<PersonaC> findByTipoIdentificacionC(TipoIdentificacion tipoIdentificacionC);
}
