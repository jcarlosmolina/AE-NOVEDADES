package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.RespRegional;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmaJpaRepository extends JpaRepository<Firma, Long>, FirmaJpaRepositoryCustom {

    List<Firma> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);

    List<Firma> findByFamiliaNovedad(FamiliaNovedad familiaNovedad);

    List<Firma> findByNovedadesCT(NovedadCT novedadesCT);

    List<Firma> findByRespRegional(RespRegional respRegional);
}
