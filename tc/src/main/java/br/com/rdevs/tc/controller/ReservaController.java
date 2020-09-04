package br.com.rdevs.tc.controller;


import br.com.rdevs.tc.model.dto.ReservaDTO;

import br.com.rdevs.tc.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping
    public ResponseEntity listarReservasValidasPorCliente(@RequestParam("idCliente") BigInteger idCliente) {
        return reservaService.listarPorClienteReservasValidas(idCliente);

    }

    @GetMapping("/vencidas")
    public ResponseEntity listarReservasVencidasPorCliente() {
        return reservaService.listarPorClienteReservasVencidas();
    }

    @PostMapping
    public ResponseEntity inserir(@RequestBody ReservaDTO dto) {
        return reservaService.inserir(dto);
    }

}