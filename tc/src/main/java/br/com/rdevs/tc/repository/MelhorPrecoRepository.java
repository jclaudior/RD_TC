package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.MelhorPrecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MelhorPrecoRepository extends JpaRepository<MelhorPrecoEntity, BigInteger>{



}
