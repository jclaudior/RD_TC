package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.model.dto.OperadorDTO;
import br.com.rdevs.tc.model.entity.OperadorEntity;
import br.com.rdevs.tc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity login(@RequestBody OperadorDTO dto) {
        return loginService.login(dto.getNrMatricula(), dto.getPwOperador());
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody OperadorDTO dto){


        return  loginService.atualizar(dto);
    }
}
