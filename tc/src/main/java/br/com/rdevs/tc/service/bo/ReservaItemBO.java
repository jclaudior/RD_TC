package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaItemBO {

    @Autowired
    private ReservaBO reservaBO;

    @Autowired
    private ProdutoBo produtoBo;

    public ReservaItemDTO parseToDTO(ReservaItemEntity entity) {
        ReservaItemDTO dto = new ReservaItemDTO();

        if(entity == null)
            return dto;

//        dto.setReserva(reservaBO.parseToDTO(entity.getReserva()));
        dto.setProduto(produtoBo.ParseToDto(entity.getProduto()));
        dto.setQtProduto(entity.getQtProduto());

        return dto;
    }

    public ReservaItemEntity parseToEntity(ReservaItemDTO dto, ReservaItemEntity entity) {

        if (entity == null)
            return new ReservaItemEntity();

        if (dto == null)
            return entity;

        entity.setReserva(reservaBO.parseToEntity(dto.getReserva(), null));
        entity.setProduto(produtoBo.ParseEntity(dto.getProduto()));
        entity.setQtProduto(dto.getQtProduto());

        return entity;
    }
}
