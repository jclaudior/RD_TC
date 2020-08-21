package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class CupomController {

    @Autowired
    CupomService service;

    @GetMapping("/cupom/{codigoCliente}")
    public ResponseEntity buscarCupom(@PathVariable("codigoCliente")BigInteger codigoCliente){
        return service.buscarCupom(codigoCliente);
    }
}
