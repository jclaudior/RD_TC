package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.StatusProdutoDTO;
import br.com.rdevs.tc.model.entity.StatusProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class StatusProdutoBO {

    public StatusProdutoDTO parseToDTO(StatusProdutoEntity entity){

        if(entity == null){
            return null;
        }

        StatusProdutoDTO dto = new StatusProdutoDTO();

        dto.setIdStatusProduto(entity.getIdStatusProduto());
        dto.setDsStatusProduto(entity.getDsStatusProduto());

        return dto;
    }

    public StatusProdutoEntity parseToEntity(StatusProdutoDTO dto){
        if(dto == null){
            return null;
        }

        StatusProdutoEntity entity = new StatusProdutoEntity();

        entity.setIdStatusProduto(dto.getIdStatusProduto());
        entity.setDsStatusProduto(dto.getDsStatusProduto());

        return entity;
    }

}
