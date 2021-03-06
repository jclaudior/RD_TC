package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.OperadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface LoginRepository extends JpaRepository<OperadorEntity, BigInteger> {
    List<OperadorEntity> findByNrMatriculaAndPwOperador (BigInteger nrMatricula, String pwOperador);
    List<OperadorEntity> findByNrMatriculaAndNrCpf (BigInteger nrMatricula, String NrCpf);

}
