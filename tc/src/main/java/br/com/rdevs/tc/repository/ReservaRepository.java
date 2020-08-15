package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

    List<ReservaEntity> findByClienteIdCliente(BigInteger idCliente);
}
