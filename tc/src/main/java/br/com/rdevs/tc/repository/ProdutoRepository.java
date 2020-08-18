package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigInteger> {
//    @Query(value = "SELECT P.CD_PRODUTO, P.ID_STATUS_PRODUTO, P.ID_CATEGORIA, P.ID_TIPO_PRODUTO, P.NM_FABRICANTE, P.NM_FANTASIA, P.VL_UNIDADE, LMPM.QT_PRODUTO, LMPM.PC_DESCONTO, LMPM.DT_INICIO_LMPM, LMPM.DT_FIM_LMPM FROM TB_PRODUTO as P LEFT JOIN (SELECT L.ID_LMPM, L.DT_INICIO_LMPM, L.DT_FIM_LMPM, LI.CD_PRODUTO, LI.QT_PRODUTO, LI.PC_DESCONTO FROM TB_LMPM L INNER JOIN TB_LMPM_ITEM LI ON (LI.ID_LMPM = L.ID_LMPM WHERE SYSDATE() BETWEEN L.DT_INICIO_LMPM AND L.DT_FIM_LMPM) LMPM ON (LI.CD_PRODUTO = P.CD_PRODUTO)", nativeQuery = true)
//    List<ProdutoEntity> findByAllProdutos();
    List<ProdutoEntity> findByNmFantasiaContaining(String nomeProduto);
}
