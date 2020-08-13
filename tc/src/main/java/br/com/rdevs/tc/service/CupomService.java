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
    private CupomRepository repository;

    @Autowired
    private CupomBO cupomBO;

    public TcCupomDTO buscarCupomPorCliente(BigInteger idCliente){
        List<TcCupomEntity> listaDeCupons = repository.findByIdCliente(idCliente);
        TcCupomDTO dto = null;
        for(TcCupomEntity entity: listaDeCupons){
            dto = cupomBO.parseToDTO(entity);
        }
        return dto;
    }


}
