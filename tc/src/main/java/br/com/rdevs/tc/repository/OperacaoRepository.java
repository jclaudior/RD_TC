package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.OperacaoEntity;
import br.com.rdevs.tc.model.entity.OperadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OperacaoRepository extends JpaRepository<OperacaoEntity, Long> {
}
