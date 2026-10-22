package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.EstadoContrato;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.Funcionario;
import com.keralty.aenovedades.persistence.GrupoAsociado;
import com.keralty.aenovedades.persistence.LogEstadoSN;
import com.keralty.aenovedades.persistence.LogUsrSolNov;
import com.keralty.aenovedades.persistence.Periodicidad;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudNovedadJpaRepository extends JpaRepository<SolicitudNovedad, Long>, SolicitudNovedadJpaRepositoryCustom {

    List<SolicitudNovedad> findByFamilias(FamiliaNovedad familias);

    List<SolicitudNovedad> findByDocumentos(DocumentoNovedad documentos);

    List<SolicitudNovedad> findByLogEstados(LogEstadoSN logEstados);

    List<SolicitudNovedad> findByLogUsrSolNov(LogUsrSolNov logUsrSolNov);

    List<SolicitudNovedad> findByTipoIdentContratante(TipoIdentificacion tipoIdentContratante);

    List<SolicitudNovedad> findByEstadoContrato(EstadoContrato estadoContrato);

    List<SolicitudNovedad> findByGrupoAsociado(GrupoAsociado grupoAsociado);

    List<SolicitudNovedad> findByPeriodicidad(Periodicidad periodicidad);

    List<SolicitudNovedad> findByAgente(Funcionario agente);

    List<SolicitudNovedad> findByPeriodicidadNueva(Periodicidad periodicidadNueva);

    List<SolicitudNovedad> findByUsrAfiliacion(Funcionario usrAfiliacion);

    List<SolicitudNovedad> findByFirma(Firma firma);
}
