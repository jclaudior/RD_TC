package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.DocumentoItemDTO;
import br.com.rdevs.tc.model.dto.EstoqueDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.model.entity.DocumentoItemEntity;
import br.com.rdevs.tc.model.entity.EstoqueEntitty;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import br.com.rdevs.tc.repository.EstoqueRepository;
import br.com.rdevs.tc.service.bo.DocumentoFiscalBO;
import br.com.rdevs.tc.service.bo.EstoqueBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoFiscalService {

    @Autowired
    DocumentoFiscalRepository repository;

    @Autowired
    DocumentoFiscalBO bo;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    EstoqueBO estoqueBO;

    public ResponseEntity buscarPorId(Long idDocumentoFiscal) {
        ResultData resultData = null;
        try {
            //Id da operação deve ser fixo, sempre pegar o ID da tabela de operação correspondente ao tipo "VENDA"
            DocumentoFiscalEntity documentoFiscal = repository.findByOperacaoCdOperacaoAndIdDocumentoFiscal((long) 1, idDocumentoFiscal);
            DocumentoFiscalDTO documentoDTO = new DocumentoFiscalDTO();
            documentoDTO = bo.parseToDTO(documentoFiscal);
            //return documentoDTO;

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Documentos fiscais listados com sucesso", documentoDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao listar os documentos fiscais" + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }

    public void inserir (DocumentoFiscalDTO dto) {

        DocumentoFiscalEntity entity = bo.parseToEntity(dto);

        //BigInteger idMotivoDevolucao = BigInteger.valueOf(3);
        if(entity.getMotivoDevolucao().getIdMotivo() != BigInteger.valueOf(3) || entity.getMotivoDevolucao().getIdMotivo() != BigInteger.valueOf(4)) {
            List<DocumentoItemEntity> listItens = entity.getItens();
            for (DocumentoItemEntity currentItem : listItens) {

                BigInteger cdProduto = currentItem.getProduto().getCdProduto();
                BigInteger cdFilial = entity.getFilial().getCdFilial();

                EstoqueEntitty entityEstoque = estoqueRepository.findByFilialCdFilialAndProdutoCdProduto(cdFilial, cdProduto);

                Integer ajustEstoque = entityEstoque.getQtEstoque() + currentItem.getQtdItem();
                entityEstoque.setQtEstoque(ajustEstoque);

                estoqueRepository.save(entityEstoque);
            }
        }

        repository.save(entity);
    }
}

