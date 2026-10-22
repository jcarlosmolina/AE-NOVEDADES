package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.Regional;
import com.keralty.aenovedades.persistence.RespRegional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionalJpaRepository extends JpaRepository<Regional, Long>, RegionalJpaRepositoryCustom {

    List<Regional> findByRespRegional(RespRegional respRegional);
}
