package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminJpaRepository extends JpaRepository<SuperAdmin, Long>, SuperAdminJpaRepositoryCustom {
}
