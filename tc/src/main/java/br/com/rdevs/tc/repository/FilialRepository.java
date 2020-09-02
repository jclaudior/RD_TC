package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.FilialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FilialRepository extends JpaRepository<FilialEntity, BigInteger> {

}
