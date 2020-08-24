package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.EstoqueDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.EstoqueEntity;
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
    private EstoqueBO boEstoaque;

    @Autowired
    private EstoqueRepository repositoryEstoque;

    public ResponseEntity listarProduto(BigInteger cdFilial) {
        ResultData resultData = null;
        try{
            List<EstoqueEntity> listEntity = repositoryEstoque.findByFilialCdFilial(cdFilial);
            List<EstoqueDTO> listDTO = new ArrayList<>();
            for(EstoqueEntity estoque : listEntity){
                listDTO.add(boEstoaque.parseToDto(estoque));
            }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Listagem de produtos realizada com sucesso!",listDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao listar produtos! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }

    public ResponseEntity listarPorId(BigInteger cdFilial, BigInteger cdProduto) {
        ResultData resultData = null;
        try{

            List<EstoqueEntity> estoqueEntity  = repositoryEstoque.findByFilialCdFilialAndProdutoCdProduto(cdFilial, cdProduto);
            List<EstoqueDTO> estoqueDTO = new ArrayList<>();
            for (EstoqueEntity estoque : estoqueEntity) {
                estoqueDTO.add(boEstoaque.parseToDto(estoque));
                //estoqueDTO = boEstoaque.parseToDto(estoqueEntity);
            }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Consulta produto por id realizada com sucesso!",estoqueDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao consultar produto por id! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }

    public ResponseEntity listarPorNome(BigInteger cdFilial, String nomeProduto) {
        ResultData resultData = null;
        try{

            List<EstoqueEntity> listEntity = repositoryEstoque.findByFilialCdFilialAndProdutoNmFantasiaContaining(cdFilial, nomeProduto);
            List<EstoqueDTO> listDTO = new ArrayList<>();

            for (EstoqueEntity estoque : listEntity) {

                listDTO.add(boEstoaque.parseToDto(estoque));
            }

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Consulta produto por nome realizada com sucesso!",listDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao consultar produto por nome! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
    }
}
