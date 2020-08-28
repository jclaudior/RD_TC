package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.StatusProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.function.BiConsumer;

public interface StatusProdutoRepository extends JpaRepository<StatusProdutoEntity, BigInteger> {

}
