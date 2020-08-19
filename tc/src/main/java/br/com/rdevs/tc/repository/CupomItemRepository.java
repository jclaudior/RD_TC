package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.model.entity.TcCupomItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface CupomItemRepository extends JpaRepository<TcCupomItemEntity, BigInteger> {

    List<TcCupomItemEntity> findByTcCupomIdCupom(BigInteger idCliente);

}
