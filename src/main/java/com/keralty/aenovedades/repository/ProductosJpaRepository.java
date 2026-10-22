package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosJpaRepository extends JpaRepository<Productos, Long>, ProductosJpaRepositoryCustom {

    List<Productos> findByGruposAsociados(GrupoAsociado gruposAsociados);
}
