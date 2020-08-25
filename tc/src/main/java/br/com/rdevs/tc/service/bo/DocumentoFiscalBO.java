package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import org.springframework.stereotype.Component;

@Component
public class DocumentoFiscalBO {

    public DocumentoFiscalDTO parseToDTO(DocumentoFiscalEntity entity) {

        if (entity == null)
            return null;

// Data de Abertura, fechamento, nrCaixa não vai utilizar
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();
        dto.setIdDocumentoFiscal(entity.getIdDocumentoFiscal());

//        dto.setCdFilial(entity.getFilial().getCdFilial());
//        dto.setIdCliente(entity.getCliente().getIdCliente());
    return dto;
    }
}
