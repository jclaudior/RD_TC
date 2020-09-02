package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.DocumentoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoItemRepository extends JpaRepository<DocumentoItemEntity, Long> {

    List<DocumentoItemEntity> findByIdDocumentoFiscalIdDocumentoFiscal(Long idDocumentoItem);

}
