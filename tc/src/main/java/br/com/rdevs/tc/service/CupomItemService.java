package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.dto.TcCupomItemDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.model.entity.TcCupomItemEntity;
import br.com.rdevs.tc.repository.CupomItemRepository;
import br.com.rdevs.tc.service.bo.CupomItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CupomItemService {

    @Autowired
    CupomItemRepository repository;

    @Autowired
    CupomItemBO bo;

    public TcCupomItemDTO buscarItemCupom(BigInteger idItemCupom){
        TcCupomItemEntity entity = new TcCupomItemEntity();
        TcCupomItemDTO dto = new TcCupomItemDTO();

        entity = repository.getOne(idItemCupom);

        dto = bo.parseToDTO(entity);

        return dto;
    }
}
