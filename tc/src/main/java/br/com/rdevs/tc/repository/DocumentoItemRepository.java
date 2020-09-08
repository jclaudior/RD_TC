package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.DocumentoItemEntity;
import br.com.rdevs.tc.model.entity.DocumentoItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface DocumentoItemRepository extends JpaRepository<DocumentoItemEntity, DocumentoItemPK> {

    List<DocumentoItemEntity> findByDocumentoFiscalIdDocumentoFiscal(BigInteger idDocumentoItem);

    List<DocumentoItemEntity> findByDocumentoFiscalIdDocumentoFiscalAndNumItemDocumento(BigInteger idDocumentoItem, BigInteger nrItemDocumento);


}
