package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.dto.TcCupomItemDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.model.entity.TcCupomItemEntity;
import br.com.rdevs.tc.repository.CupomItemRepository;
import br.com.rdevs.tc.service.bo.CupomItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CupomItemService {

    @Autowired
    CupomItemRepository repository;

    @Autowired
    CupomItemBO bo;

    public List<TcCupomItemDTO> buscarItemCupom(BigInteger idItemCupom){
        List<TcCupomItemEntity> listEntity = new ArrayList<>();
        List<TcCupomItemDTO> listDto = new ArrayList<>();

        listEntity = repository.findByTcCupomIdCupom(idItemCupom);

        for(TcCupomItemEntity entity : listEntity){
            TcCupomItemDTO dto = new TcCupomItemDTO();
            dto = bo.parseToDTO(entity);
            listDto.add(dto);
        }
        //listEntity = repository.findByTcCupomIdCupom(idItemCupom);

        //dto = bo.parseToDTO(entity);

        return listDto;
    }
}
