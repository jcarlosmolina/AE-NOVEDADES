package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoNovedadJpaRepository extends JpaRepository<DocumentoNovedad, Long>, DocumentoNovedadJpaRepositoryCustom {

    List<DocumentoNovedad> findByLogEstadoDocNov(LogEstadoDocNov logEstadoDocNov);

    List<DocumentoNovedad> findBySolicitud(SolicitudNovedad solicitud);

    List<DocumentoNovedad> findByUsuario(UsuarioNovedad usuario);
}
