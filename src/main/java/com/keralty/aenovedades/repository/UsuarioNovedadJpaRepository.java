package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioNovedadJpaRepository extends JpaRepository<UsuarioNovedad, Long>, UsuarioNovedadJpaRepositoryCustom {

    List<UsuarioNovedad> findByDocumentos(DocumentoNovedad documentos);

    List<UsuarioNovedad> findByFamiliaNovedad(FamiliaNovedad familiaNovedad);

    List<UsuarioNovedad> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<UsuarioNovedad> findByParentesco(Parentesco parentesco);

    List<UsuarioNovedad> findByEstadoBeneficiario(EstadoBeneficiario estadoBeneficiario);

    List<UsuarioNovedad> findByParentescoNuevo(Parentesco parentescoNuevo);

    List<UsuarioNovedad> findByTipoIdentificacionCD(TipoIdentificacion tipoIdentificacionCD);
}
