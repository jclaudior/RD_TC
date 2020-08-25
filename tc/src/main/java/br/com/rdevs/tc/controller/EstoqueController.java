package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/filial")
public class EstoqueController {

    @Autowired
    EstoqueService service;

    @GetMapping("/{cdFilial}")
    public ResponseEntity listarTodas(@PathVariable("cdFilial")BigInteger cdFilial) {
        return ResponseEntity.ok().body(service.listarTodas(cdFilial));
    }

    @GetMapping("/{cdFilial}/codigo/{cdProduto}")
    public ResponseEntity listarPorId(@PathVariable("cdFilial")BigInteger cdFilial, @PathVariable("cdProduto")BigInteger cdProduto) {
        return ResponseEntity.ok().body(service.listarPorId(cdFilial, cdProduto));
    }

    @GetMapping("/{cdFilial}/nome/{nmFantasia}")
    public ResponseEntity listarPorNome(@PathVariable("cdFilial")BigInteger cdFilial, @PathVariable("nmFantasia")String nmFantasia) {
        return ResponseEntity.ok().body(service.listPorNome(cdFilial, nmFantasia));
    }
}
