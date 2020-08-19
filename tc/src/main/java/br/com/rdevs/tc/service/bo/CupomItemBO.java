package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.dto.TcCupomItemDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.model.entity.TcCupomItemEntity;
import org.springframework.stereotype.Component;

@Component
public class CupomItemBO {

    public TcCupomItemDTO parseToDTO(TcCupomItemEntity entity){
        if(entity == null){
            return null;
        }

        TcCupomItemDTO dto = new TcCupomItemDTO();

        dto.setIdCupomItem(entity.getIdCupomItem());
        dto.setPcDesconto(entity.getPcDesconto());

        //CupomBO cupom = new CupomBO();
        //dto.setCupom(cupom.parseToDTO(entity.getTcCupom()));

        ProdutoBo produto = new ProdutoBo();
        dto.setProduto(produto.ParseToDto(entity.getProdutoEntity()));

        return dto;
    }
}
