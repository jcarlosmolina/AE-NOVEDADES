package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioJpaRepository extends JpaRepository<Funcionario, Long>, FuncionarioJpaRepositoryCustom {

    List<Funcionario> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Funcionario> findBySolNovAifliaciones(SolicitudNovedad solNovAifliaciones);
}
