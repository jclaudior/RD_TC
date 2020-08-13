package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import org.springframework.stereotype.Component;


@Component
public class CupomBO {

    public TcCupomDTO parseToDTO(TcCupomEntity entity){
        if(entity == null){
            return null;
        }
        TcCupomDTO dto = new TcCupomDTO();
        dto.setIdCupom(entity.getIdCupom());
        dto.setDtInicialCupom(entity.getDtInicialCupom());
        dto.setDtFinalCupom(entity.getDtFinalCupom());
        return dto;
    }

    public  TcCupomEntity parseToEntity(TcCupomDTO dto, TcCupomEntity entity){
        if(entity == null){
            entity = new TcCupomEntity();
        }
        if(dto == null) {
            return  null;
        }
        entity.setIdCupom(dto.getIdCupom());
        entity.setDtInicialCupom(dto.getDtInicialCupom());
        entity.setDtFinalCupom(dto.getDtFinalCupom());
        return entity;
    }
}
