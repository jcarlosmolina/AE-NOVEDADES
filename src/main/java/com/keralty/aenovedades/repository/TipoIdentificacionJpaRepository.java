package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Asesor;
import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoIdentificacionJpaRepository extends JpaRepository<TipoIdentificacion, Long>, TipoIdentificacionJpaRepositoryCustom {

    List<TipoIdentificacion> findByAsesores(Asesor asesores);

    List<TipoIdentificacion> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<TipoIdentificacion> findByFamiliasNovedad(FamiliaNovedad familiasNovedad);

    List<TipoIdentificacion> findByUsuariosNovedad(UsuarioNovedad usuariosNovedad);

    List<TipoIdentificacion> findByUsuarioNovedad(UsuarioNovedad usuarioNovedad);

    List<TipoIdentificacion> findByNovedadesCT(NovedadCT novedadesCT);
}
