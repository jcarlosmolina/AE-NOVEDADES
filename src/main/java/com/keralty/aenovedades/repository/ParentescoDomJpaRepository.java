package com.keralty.aenovedades.repository;

import com.keralty.aenovedades.persistence.oid.ParentescoDomOid;
import com.keralty.aenovedades.persistence.Parentesco;
import com.keralty.aenovedades.persistence.ParentescoDom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentescoDomJpaRepository extends JpaRepository<ParentescoDom, ParentescoDomOid>, ParentescoDomJpaRepositoryCustom {

    List<ParentescoDom> findByParentesco(Parentesco parentesco);
}
