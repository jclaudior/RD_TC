package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/cliente")
    public ResponseEntity buscarCliente(@RequestParam("dadosCliente")String dadosCliente) {
        return service.buscarCliente(dadosCliente);
    }
}
