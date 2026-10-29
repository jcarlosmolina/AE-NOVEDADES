package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentescoJpaRepository extends JpaRepository<Parentesco, Long>, ParentescoJpaRepositoryCustom {

    List<Parentesco> findByUsuariosNovedad(UsuarioNovedad usuariosNovedad);

    List<Parentesco> findByUsuarioNovedad(UsuarioNovedad usuarioNovedad);
}
