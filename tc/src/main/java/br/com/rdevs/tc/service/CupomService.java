package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.repository.CupomRepository;
import br.com.rdevs.tc.service.bo.CupomBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CupomService {

    @Autowired
    CupomRepository repository;

    @Autowired
    CupomBO bo;

    public TcCupomDTO buscarCupom(BigInteger idCupom){
        TcCupomEntity entity = new TcCupomEntity();
        TcCupomDTO dto = new TcCupomDTO();

        entity = repository.getOne(idCupom);

        dto = bo.parseToDTO(entity);

        return dto;
    }

}
