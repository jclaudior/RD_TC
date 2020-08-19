package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigInteger> {

    List<ProdutoEntity> findByNmFantasiaContaining(String nomeProduto);

}
