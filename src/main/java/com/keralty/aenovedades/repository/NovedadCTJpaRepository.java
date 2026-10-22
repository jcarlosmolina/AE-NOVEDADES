package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.FamiliaNovedad;
import com.keralty.aenovedades.persistence.Firma;
import com.keralty.aenovedades.persistence.NovedadCT;
import com.keralty.aenovedades.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadCTJpaRepository extends JpaRepository<NovedadCT, Long>, NovedadCTJpaRepositoryCustom {

    List<NovedadCT> findByFamiliaNovedad(FamiliaNovedad familiaNovedad);

    List<NovedadCT> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<NovedadCT> findByFirma(Firma firma);
}
