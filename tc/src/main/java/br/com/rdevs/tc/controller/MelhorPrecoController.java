package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.model.dto.MelhorPrecoDTO;
import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.service.MelhorPrecoService;
import br.com.rdevs.tc.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MelhorPrecoController {

    @Autowired
    MelhorPrecoService service;

    @PostMapping("/melhorpreco")
    public ResponseEntity inserir(@RequestBody MelhorPrecoDTO dto){
        return  ResponseEntity.ok().body(service.inserir(dto));
    }

}
