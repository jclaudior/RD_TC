package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaItemEntity, BigInteger> {
}
