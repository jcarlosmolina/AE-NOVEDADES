package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.AreaMedica;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudJpaRepository extends JpaRepository<Solicitud, Long>, SolicitudJpaRepositoryCustom {

    List<Solicitud> findByFirma(Firma firma);

    List<Solicitud> findBySegundaFirma(Firma segundaFirma);

    List<Solicitud> findByFirmaContratanteIncl(Firma firmaContratanteIncl);

    List<Solicitud> findByGrupoAsociado(GrupoAsociado grupoAsociado);

    List<Solicitud> findByAgente(Funcionario agente);

    List<Solicitud> findByPeriodicidad(Periodicidad periodicidad);

    List<Solicitud> findByUsrAreaMedica(AreaMedica usrAreaMedica);

    List<Solicitud> findByUsrAfiliacion(Funcionario usrAfiliacion);
}
