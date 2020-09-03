package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.EstoqueDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.EstoqueEntitty;
import br.com.rdevs.tc.repository.EstoqueRepository;
import br.com.rdevs.tc.service.bo.EstoqueBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    EstoqueBO estoqueBO;

    @Autowired
    EstoqueRepository estoqueRepository;

    public ResponseEntity listarTodas(BigInteger cdFilial) {
        ResultData resultData = null;

        try {
            List<EstoqueEntitty> listEntity = estoqueRepository.findByFilialCdFilial(cdFilial);
            List<EstoqueDTO> listDTO = new ArrayList<>();
            for (EstoqueEntitty entity : listEntity) {
                listDTO.add(estoqueBO.parseToDto(entity));
            }

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Listagem de produtos realizada com sucesso!", listDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao listar produtos! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }

    public ResponseEntity listarPorId(BigInteger cdFilial, BigInteger cdProduto) {
        ResultData resultData = null;

        try {
            EstoqueEntitty entity = estoqueRepository.findByFilialCdFilialAndProdutoCdProduto(cdFilial, cdProduto);
            EstoqueDTO dto = estoqueBO.parseToDto(entity);
            //for (EstoqueEntitty entity : listEntity) {
                //listDTO.add(estoqueBO.parseToDto(entity));
            //}

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Consulta produto por id realizada com sucesso!", dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao consultar produto por id! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }

    public ResponseEntity listPorNome(BigInteger cdFilial, String nmFantasia) {
        ResultData resultData = null;

        try {
            List<EstoqueEntitty> listEntity = estoqueRepository.findByFilialCdFilialAndProdutoNmFantasiaContaining(cdFilial, nmFantasia);
            List<EstoqueDTO> listDTO = new ArrayList<>();
            for (EstoqueEntitty entity : listEntity) {
                listDTO.add(estoqueBO.parseToDto(entity));
            }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Consulta produto por nome realizada com sucesso!", listDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao consultar produto por id! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }
}
