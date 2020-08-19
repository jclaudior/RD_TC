package br.com.rdevs.tc.controller;

<<<<<<< HEAD
=======
import br.com.rdevs.tc.model.dto.ReservaDTO;
>>>>>>> APIRESERVA3
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
        return ResponseEntity.ok().body(reservaService.listarPorCliente(idCliente));

    }

    @PostMapping("/reserva")
    public ResponseEntity inserir(@RequestBody ReservaDTO dto){
        return ResponseEntity.ok().body(reservaService.inserir(dto));
    }

}