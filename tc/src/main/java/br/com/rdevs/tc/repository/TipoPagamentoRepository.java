package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.TipoPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamentoEntity, BigInteger> {

}
