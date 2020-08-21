package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, BigInteger> {

    List<ClienteEntity> findByNmCliente (String nome);

    List<ClienteEntity> findByNrRg (String Rg);

    List<ClienteEntity> findByNrCpf (String CPF);
}
