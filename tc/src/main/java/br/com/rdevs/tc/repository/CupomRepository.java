package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.TcCupomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface CupomRepository extends JpaRepository<TcCupomEntity, BigInteger> {

    List<TcCupomEntity> findByIdCliente(BigInteger idCliente);

}
