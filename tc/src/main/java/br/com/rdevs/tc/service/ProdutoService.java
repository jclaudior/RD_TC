package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.repository.ProdutoRepository;
import br.com.rdevs.tc.service.bo.ProdutoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoBo produtoBo;

    @Autowired
    private ProdutoRepository produtoRep;

    public ResponseEntity listarProduto() {
        ResultData resultData = null;
        try {
        List<ProdutoEntity> listaEntity = produtoRep.findAll();
        List<ProdutoDTO> listaDto = new ArrayList<>();
        for (ProdutoEntity produtoEntity : listaEntity) {
            listaDto.add(produtoBo.ParseToDto(produtoEntity));

        }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Listagem de produtos realizada com sucesso!",listaDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch(Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao listar produtos! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }

    public ResponseEntity listarPorId(BigInteger cdProduto) {
        ResultData resultData = null;
        try {
            ProdutoEntity produtoEntity = produtoRep.getOne(cdProduto);
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO = (produtoBo.ParseToDto(produtoEntity));

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Consulta produto por id realizada com sucesso!",produtoDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch(Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao consultar produto por id! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }


    public ResponseEntity listarPorNome(String nomeProduto) {
        ResultData resultData = null;
        try {
            List<ProdutoEntity> listaEntity = produtoRep.findByNmFantasiaContaining(nomeProduto);
            List<ProdutoDTO> listaDto = new ArrayList<>();
            for (ProdutoEntity produtoEntity : listaEntity) {
                listaDto.add(produtoBo.ParseToDto(produtoEntity));
            }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Consulta produto por nome realizada com sucesso!",listaDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch(Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao consultar produto por id! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }
}
