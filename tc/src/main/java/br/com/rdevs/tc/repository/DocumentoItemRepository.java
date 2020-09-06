package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.DocumentoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface DocumentoItemRepository extends JpaRepository<DocumentoItemEntity, BigInteger> {

    List<DocumentoItemEntity> findByIdDocumentoFiscalIdDocumentoFiscal(BigInteger idDocumentoItem);

    List<DocumentoItemEntity> findByDocumentoFiscalIdDocumentoFiscalAndNumItemDocumento(BigInteger idDocumentoItem, BigInteger nrItemDocumento);


}
