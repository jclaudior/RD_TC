package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RequestMapping("/cupom")
@RestController
public class CupomController {

    @Autowired
    CupomService service;

    @GetMapping("/{idClietne}")
    public ResponseEntity<Object> buscarCupomPorIdeDoCliente(@PathVariable("idClietne")BigInteger idClietne){
        return ResponseEntity.ok(service.buscarCupomPorCliente(idClietne));
    }

}
