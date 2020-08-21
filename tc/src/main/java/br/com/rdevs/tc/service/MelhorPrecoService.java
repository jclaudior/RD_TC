package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.MelhorPrecoDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.MelhorPrecoEntity;
import br.com.rdevs.tc.repository.MelhorPrecoRepository;
import br.com.rdevs.tc.service.bo.MelhorPercoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MelhorPrecoService {

    @Autowired
    MelhorPercoBO bo;

    @Autowired
    MelhorPrecoRepository repository;

    public ResponseEntity<ResultData> inserir (MelhorPrecoDTO dto){
        ResultData resultData = null;

        if(dto.getCliente() == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro CLiente invalido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(dto.getOperador()== null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro Operador invalido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(dto.getProduto() == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro Produto invalido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        try {
            MelhorPrecoEntity entity = bo.parseToEntity(dto, null);
            if(entity.getClienteEntity() != null && entity.getOperadorEntity() != null && entity.getProdutoEntity() != null){
            repository.save(entity);
            }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Melhor preço inserido com sucesso!",repository);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch(Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao inserir melhor preço! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }

}
