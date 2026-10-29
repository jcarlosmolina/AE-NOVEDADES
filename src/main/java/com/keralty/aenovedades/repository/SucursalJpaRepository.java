package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalJpaRepository extends JpaRepository<Sucursal, Long>, SucursalJpaRepositoryCustom {

    List<Sucursal> findByAgentes(Funcionario agentes);
}
