package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.repository.ProdutoRepository;
import br.com.rdevs.tc.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaItemBO {

    @Autowired
    private ReservaBO reservaBO;

    @Autowired
    private ProdutoBo produtoBo;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ReservaItemDTO parseToDTO(ReservaItemEntity entity) {
        ReservaItemDTO dto = new ReservaItemDTO();

        if(entity == null)
            return dto;

//        dto.setReserva(reservaBO.parseToDTO(entity.getReserva()));
        dto.setProduto(produtoBo.ParseToDto(entity.getProduto()));
        dto.setQtProduto(entity.getQtProduto());

        return dto;
    }

    public ReservaItemEntity parseToEntity(ReservaItemDTO dto, ReservaItemEntity entity, ReservaEntity reserva) {

        if (entity == null)
            return new ReservaItemEntity();

        if (dto == null)
            return entity;

        entity.setReserva(reserva);
        entity.setProduto(produtoRepository.getOne(dto.getProduto().getCdProduto()));
        entity.setQtProduto(dto.getQtProduto());

        return entity;
    }
}
