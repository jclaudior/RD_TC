package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.OperacaoDTO;
import br.com.rdevs.tc.model.entity.OperacaoEntity;
import org.springframework.stereotype.Component;

@Component
public class OperacaoBO {


    public OperacaoDTO parseToDTO (OperacaoEntity entity){
        OperacaoDTO dto = new OperacaoDTO();

        dto.setCdOperacao(entity.getCdOperacao());
        dto.setDescricaoOperacao(entity.getDescricaoOperacao());

        return  dto;
    }

    public OperacaoEntity parseToEntity (OperacaoDTO dto){

        OperacaoEntity entity = new OperacaoEntity();

        entity.setCdOperacao(dto.getCdOperacao());
        entity.setDescricaoOperacao(dto.getDescricaoOperacao());

        return entity;
    }

}
