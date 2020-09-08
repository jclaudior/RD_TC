package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.model.dto.ClienteDTO;
import br.com.rdevs.tc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/cliente")
    public ResponseEntity buscarCliente(@RequestParam("dadosCliente")String dadosCliente) {
        return service.buscarCliente(dadosCliente);
    }

    @PostMapping("/cliente")
    public ResponseEntity inserir(@RequestBody ClienteDTO dto){

    return  service.inserir(dto);
    }

}
