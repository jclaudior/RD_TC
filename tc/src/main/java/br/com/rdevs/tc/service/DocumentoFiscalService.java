package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.DocumentoItemDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import br.com.rdevs.tc.repository.EstoqueRepository;
import br.com.rdevs.tc.service.bo.DocumentoFiscalBO;
import br.com.rdevs.tc.service.bo.EstoqueBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

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

    @Autowired
    AlterarEstoqueService altEstoqueService;

    BigInteger idOperacaoVenda = BigInteger.valueOf(1);

    public ResponseEntity buscarPorId(BigInteger idDocumentoFiscal) {
        ResultData resultData = null;
        try {

            //Id da operação deve ser fixo, sempre pegar o ID da tabela de operação correspondente ao tipo "VENDA"
            DocumentoFiscalEntity documentoFiscal = repository.findByOperacaoCdOperacaoAndIdDocumentoFiscal(idOperacaoVenda, idDocumentoFiscal);
            DocumentoFiscalDTO documentoDTO = new DocumentoFiscalDTO();
            documentoDTO = bo.parseToDTOFind(documentoFiscal);

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Documentos fiscais listados com sucesso", documentoDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);

        }catch (Exception e){

            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao listar os documentos fiscais" + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);

        }
    }

    public ResponseEntity inserir (DocumentoFiscalDTO dto) {
        ResultData resultData = null;
        if(dto.getMotivo() == null || dto.getMotivo().equals(0)) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Motivo de Devolucao invalido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(dto.getCliente() == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Cliente invalido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(dto.getIdDocumentoFiscalVenda() == null || dto.getIdDocumentoFiscalVenda().equals(0)){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Nota de venda invalida! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(dto.getNrNumeroItem() == null || dto.getNrNumeroItem().equals(0)){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Numero do item invalido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(dto.getItens() == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Itens da devolucao invalidos! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

        for(DocumentoItemDTO itemDTO : dto.getItens()){
            if(itemDTO.getProduto() == null){
                resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Produto da Devoluao invalido! ");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
            }
            if(Integer.parseInt(itemDTO.getQtItem().toString()) <= 0){
                resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Quantidade de intens invalida! ");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
            }
            if(itemDTO.getFormaDevolucao() == null){
                resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Forma de Devolucao invalida! ");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
            }
        }
        try {
            DocumentoFiscalEntity entity = bo.parseToEntity(dto);
            altEstoqueService.devolucaoParaEstoque(entity);
            repository.save(entity);

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Documento fiscal de Devolucao salvo com sucesso! ", entity);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);

        }catch(Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao salvar o documento fiscal de Devolucao! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }
}

