package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.OperadorDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.OperadorEntity;
import br.com.rdevs.tc.repository.LoginRepository;
import br.com.rdevs.tc.service.bo.LoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class LoginService {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private LoginBO loginBO;

    public ResponseEntity login(BigInteger nrMatricula, String pwOperador) {
        ResultData resultData = null;
        if(nrMatricula == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Matricula invalida!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(pwOperador == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Password invalido!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        try {
            List<OperadorEntity> listEntity = repository.findByNrMatriculaAndPwOperador(nrMatricula, pwOperador);
            if(listEntity.size() == 0){
                resultData = new ResultData(HttpStatus.UNAUTHORIZED.value(), "Matricula ou Senha Incorreta!");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultData);
            }
            OperadorDTO dto = null;

            for (OperadorEntity entity : listEntity) {
                dto = loginBO.parseToDTO(entity);
            }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(), "Usuario autenticado com sucesso!", dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro ao autenticar usuario " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }
}
