package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoAsociadoJpaRepository extends JpaRepository<GrupoAsociado, Long>, GrupoAsociadoJpaRepositoryCustom {

    List<GrupoAsociado> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);
}
