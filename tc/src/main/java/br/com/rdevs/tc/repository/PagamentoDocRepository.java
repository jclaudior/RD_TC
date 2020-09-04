package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.PagamentoDocEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface PagamentoDocRepository extends JpaRepository<PagamentoDocEntity, BigInteger> {

    List<PagamentoDocEntity> findBydocumentoFiscalIdDocumentoFiscal(BigInteger idDocumento);

}
