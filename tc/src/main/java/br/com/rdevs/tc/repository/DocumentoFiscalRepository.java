package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoFiscalRepository extends JpaRepository<DocumentoFiscalEntity, Long> {

    DocumentoFiscalEntity findByOperacaoCdOperacaoAndIdDocumentoFiscal(Long idOperacao, Long idDocumentoFiscal);

}
