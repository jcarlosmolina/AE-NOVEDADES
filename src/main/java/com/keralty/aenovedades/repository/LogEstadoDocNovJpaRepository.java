package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.LogEstadoDocNov;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEstadoDocNovJpaRepository extends JpaRepository<LogEstadoDocNov, Long>, LogEstadoDocNovJpaRepositoryCustom {

    List<LogEstadoDocNov> findByDocumentoNovedad(DocumentoNovedad documentoNovedad);
}
