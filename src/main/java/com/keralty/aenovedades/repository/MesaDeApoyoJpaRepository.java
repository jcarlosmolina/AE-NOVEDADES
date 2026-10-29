package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.MesaDeApoyo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaDeApoyoJpaRepository extends JpaRepository<MesaDeApoyo, Long>, MesaDeApoyoJpaRepositoryCustom {
}
