package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.NovedadMD;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import com.keralty.aenovedades.persistence.UsuarioNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaNovedadJpaRepository extends JpaRepository<FamiliaNovedad, Long>, FamiliaNovedadJpaRepositoryCustom {

    List<FamiliaNovedad> findByUsuarioNovedad(UsuarioNovedad usuarioNovedad);

    List<FamiliaNovedad> findByNovedadCT(NovedadCT novedadCT);

    List<FamiliaNovedad> findByNovedadMD(NovedadMD novedadMD);

    List<FamiliaNovedad> findBySolicitud(SolicitudNovedad solicitud);

    List<FamiliaNovedad> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<FamiliaNovedad> findByFirma(Firma firma);
}
