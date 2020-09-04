package br.com.rdevs.tc.repository;

import br.com.rdevs.tc.model.entity.DevolucaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DevolucaoRepository extends JpaRepository<DevolucaoEntity, BigInteger> {

}
