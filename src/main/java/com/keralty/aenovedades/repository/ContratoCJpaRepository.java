package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.ContratoC;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.Periodicidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoCJpaRepository extends JpaRepository<ContratoC, Long>, ContratoCJpaRepositoryCustom {

    List<ContratoC> findByPeriodicidadC(Periodicidad periodicidadC);

    List<ContratoC> findByEstadoContratoC(EstadoContrato estadoContratoC);

    List<ContratoC> findByGrupoAsociadoC(GrupoAsociado grupoAsociadoC);

    List<ContratoC> findByAsesorC(Asesor asesorC);
}
