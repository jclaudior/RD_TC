package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DocumentoFiscalRepository extends JpaRepository<DocumentoFiscalEntity, BigInteger> {

    DocumentoFiscalEntity findByOperacaoCdOperacaoAndIdDocumentoFiscal(BigInteger idOperacao, BigInteger idDocumentoFiscal);

}
