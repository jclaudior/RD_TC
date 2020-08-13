package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.model.dto.OperadorDTO;
import br.com.rdevs.tc.model.entity.OperadorEntity;
import br.com.rdevs.tc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity login(@RequestBody OperadorDTO dto) {
        OperadorDTO usuario = loginService.login(dto.getNrMatricula(), dto.getPwOperador());
        return ResponseEntity.ok().body(usuario);
    }
}
