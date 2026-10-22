package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpaRepository extends JpaRepository<Admin, Long>, AdminJpaRepositoryCustom {
}
