package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.OperadorDTO;
import br.com.rdevs.tc.model.entity.OperadorEntity;
import br.com.rdevs.tc.repository.LoginRepository;
import br.com.rdevs.tc.service.bo.LoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class LoginService {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private LoginBO loginBO;

    public OperadorDTO login(BigInteger nrMatricula, String pwOperador) {
        List<OperadorEntity> listEntity = repository.findByNrMatriculaAndPwOperador(nrMatricula, pwOperador);
        OperadorDTO dto = null;

        for (OperadorEntity entity : listEntity) {
            dto = loginBO.parseToDTO(entity);
        }

/*        if (lista.getNrMatricula() == null || lista.getPwOperador() == null)
            return lista = null;

        if (pwOperador == lista.getPwOperador())
            return lista;*/

        return dto;
    }
}
