package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.TcCupomItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CupomItemRepository extends JpaRepository<TcCupomItemEntity, BigInteger> {

}
