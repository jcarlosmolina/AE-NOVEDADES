package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.EstadoBeneficiario;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoBeneficiarioJpaRepository extends JpaRepository<EstadoBeneficiario, Long>, EstadoBeneficiarioJpaRepositoryCustom {

    List<EstadoBeneficiario> findByUsuariosNovedad(UsuarioNovedad usuariosNovedad);
}
