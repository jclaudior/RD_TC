package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.MotivoDTO;
import br.com.rdevs.tc.model.entity.MotivoEntity;
import org.springframework.stereotype.Component;

@Component
public class MotivoBO {

    public MotivoDTO parseToDTO(MotivoEntity entity){

        if  (entity == null) {
            return null;
        }

        MotivoDTO dto = new MotivoDTO();

        dto.setIdMotivo(entity.getIdMotivo());
        dto.setDsMotivo(entity.getDsMotivo());

        return dto;
    }
    public MotivoEntity parseToEntity(MotivoEntity entity, MotivoDTO dto){
        if(entity == null) {
            entity = new MotivoEntity();
        }
        if(dto == null){
            return entity;
        }

        entity.setIdMotivo(dto.getIdMotivo());
        entity.setDsMotivo(dto.getDsMotivo());

        return entity;
    }

}
