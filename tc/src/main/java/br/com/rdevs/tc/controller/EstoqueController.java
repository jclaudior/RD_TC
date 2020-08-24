package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @GetMapping("/filial/{codigoFilial}")
    public ResponseEntity todosPorFilial(@PathVariable("codigoFilial") BigInteger cdFilial){
        return ResponseEntity.ok().body(estoqueService.listarProduto(cdFilial));
    }

    @GetMapping("/filial/{codigoFilial}/codigo/{codigoProduto}")
    public ResponseEntity produtoId(@PathVariable("codigoFilial") BigInteger cdFilial, @PathVariable("codigoProduto") BigInteger cdProduto){
        return ResponseEntity.ok().body(estoqueService.listarPorId(cdFilial, cdProduto));
    }

    @GetMapping("/filial/{codigoFilial}/nome/{nomeProduto}")
    public ResponseEntity produtoNome(@PathVariable("codigoFilial") BigInteger cdFilial, @PathVariable("nomeProduto") String nomeProduto){
        return ResponseEntity.ok().body(estoqueService.listarPorNome(cdFilial, nomeProduto));
        //return estoqueService.listarPorNome(nomeProduto);
    }
}
