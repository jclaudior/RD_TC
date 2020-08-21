package br.com.rdevs.tc.controller;


import br.com.rdevs.tc.model.dto.ReservaDTO;

import br.com.rdevs.tc.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/reserva")
    public ResponseEntity listarPorCliente(@RequestParam("idCliente") BigInteger idCliente) {
        return reservaService.listarPorCliente(idCliente);

    }

    @PostMapping("/reserva")
    public ResponseEntity inserir(@RequestBody ReservaDTO dto){
        return reservaService.inserir(dto);
    }

}