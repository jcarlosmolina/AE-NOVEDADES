package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Afiliaciones;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.Planes;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanesJpaRepository extends JpaRepository<Planes, Long>, PlanesJpaRepositoryCustom {

    List<Planes> findByGruposAsociados(GrupoAsociado gruposAsociados);

    List<Planes> findByAfiliaciones(Afiliaciones afiliaciones);

    List<Planes> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);
}
