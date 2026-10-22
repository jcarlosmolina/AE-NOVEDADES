package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.ProteccionDatos;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProteccionDatosJpaRepository extends JpaRepository<ProteccionDatos, Long>, ProteccionDatosJpaRepositoryCustom {

    List<ProteccionDatos> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);
}
