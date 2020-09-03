package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.EstoqueEntitty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface EstoqueRepository extends JpaRepository<EstoqueEntitty, BigInteger> {

    EstoqueEntitty findByFilialCdFilialAndProdutoCdProduto(BigInteger cdFilial, BigInteger cdProduto);

    List<EstoqueEntitty> findByFilialCdFilial(BigInteger cdFilial);

    List<EstoqueEntitty> findByFilialCdFilialAndProdutoNmFantasiaContaining(BigInteger cdFilial, String nmFantasia);
}
