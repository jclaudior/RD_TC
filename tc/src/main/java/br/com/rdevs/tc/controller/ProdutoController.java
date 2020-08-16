package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @GetMapping("/resposta")
    public ResponseEntity resposta(){

        return ResponseEntity.ok().body(produtoService.listarProduto());
    }
}
