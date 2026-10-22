package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.oid.UsuarioOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, UsuarioOid>, UsuarioJpaRepositoryCustom {

    List<Usuario> findByParentesco(Parentesco parentesco);

    List<Usuario> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<Usuario> findByEstadoBeneficiario(EstadoBeneficiario estadoBeneficiario);
}
