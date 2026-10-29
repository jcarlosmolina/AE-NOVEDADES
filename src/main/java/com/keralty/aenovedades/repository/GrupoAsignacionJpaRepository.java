package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.GrupoAsignacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoAsignacionJpaRepository extends JpaRepository<GrupoAsignacion, Long>, GrupoAsignacionJpaRepositoryCustom {

    List<GrupoAsignacion> findByFuncionario(Funcionario funcionario);
}
