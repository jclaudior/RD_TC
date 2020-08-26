package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.DocumentoItemDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import br.com.rdevs.tc.service.bo.DocumentoFiscalBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentoFiscalService {

    @Autowired
    DocumentoFiscalRepository repository;

    @Autowired
    DocumentoFiscalBO bo;



    public DocumentoFiscalDTO buscarPorId(Long idDocumentoFiscal){

        DocumentoFiscalEntity documentoFiscal = repository.findByOperacaoCdOperacaoAndIdDocumentoFiscal((long) 4, idDocumentoFiscal);

        DocumentoFiscalDTO documentoDTO = new DocumentoFiscalDTO();

        documentoDTO = bo.parseToDTO(documentoFiscal);

        return documentoDTO;
    }

    public void inserir (DocumentoFiscalDTO dto) {
        DocumentoFiscalEntity entity = bo.parseToEntity(dto);

        repository.save(entity);
    }
}

