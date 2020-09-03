package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.model.entity.ReservaItemPK;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ReservaItemRepository extends JpaRepositoryImplementation<ReservaItemEntity, ReservaItemPK> {


}
