package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, BigInteger> {

    List<EstoqueEntity> findByFilialCdFilialAndProdutoCdProduto(BigInteger cdFilial, BigInteger cdProduto);

    List<EstoqueEntity> findByFilialCdFilial(BigInteger cdFilial);

    List<EstoqueEntity> findByFilialCdFilialAndProdutoNmFantasiaContaining(BigInteger cdFilial, String nomeProduto);
}
