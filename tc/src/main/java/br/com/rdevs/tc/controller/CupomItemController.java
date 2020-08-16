package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.service.CupomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class CupomItemController {

    @Autowired
    CupomItemService service;

    @GetMapping("/item/{codigo}")
    public ResponseEntity buscaPorItemCupom(@PathVariable("codigo") BigInteger codigo){
        return ResponseEntity.ok().body(service.buscarItemCupom(codigo));
    }
}
