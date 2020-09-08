package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.DevolucaoDTO;
import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.DevolucaoEntity;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.repository.DevolucaoRepository;
import br.com.rdevs.tc.service.bo.DevolucaoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DevolucaoService {

    @Autowired
    DevolucaoBO bo;

    @Autowired
    DevolucaoRepository repository;

    public ResponseEntity inserirDevolucao (DevolucaoDTO dto) {
        ResultData resultData = null;
        if(dto.getTipoPagamento() == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Tipo de pagameno invalido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        try {
            DevolucaoEntity entity = bo.parseToEntity(dto);
            repository.save(entity);
            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Devolucao salvo com sucesso! ", entity);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao salvar devolucao! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }
}
