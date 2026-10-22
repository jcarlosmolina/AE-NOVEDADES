package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Aesolicitudes;
import com.keralty.aenovedades.persistence.EstadoContrato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AesolicitudesJpaRepository extends JpaRepository<Aesolicitudes, Long>, AesolicitudesJpaRepositoryCustom {

    List<Aesolicitudes> findByESTADOSOLICITUD(EstadoContrato eSTADOSOLICITUD);
}
