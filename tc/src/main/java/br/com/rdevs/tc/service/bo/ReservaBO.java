package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ReservaBO {

    @Autowired
    private ClienteBO clienteBO;

    @Autowired
    private ProdutoBo produtoBo;



    public ReservaDTO parseToDTO(ReservaEntity entity){
        ReservaDTO dto = new ReservaDTO();

        if(entity == null)
            return dto;

        dto.setClienteDTO(clienteBO.parseDTO(entity.getCliente()));
        dto.setDtInicialReserva(entity.getDtFinalReserva());
        dto.setDtFinalReserva(entity.getDtFinalReserva());

        List<ReservaItemDTO> listaItemDTO = new ArrayList<>();
        for (ReservaItemEntity item : entity.getItens()) {
            ReservaItemDTO itemDTO = new ReservaItemDTO();
            ProdutoDTO produtoDTO = produtoBo.ParseToDto(item.getProduto());

            itemDTO.setProduto(produtoDTO);
            itemDTO.setQtProduto(item.getQtProduto());
            listaItemDTO.add(itemDTO);

        }
        dto.setItens(listaItemDTO);


        return dto;
    }


    public ReservaEntity parseToEntity(ReservaDTO dto, ReservaEntity entity){
        if(entity == null)
            entity = new ReservaEntity();

        if(dto == null)
            return entity;

        entity.setCliente(clienteBO.parseEntity(dto.getClienteDTO()));
        entity.setDtInicialReserva(dto.getDtInicialReserva());
        entity.setDtFinalReserva(dto.getDtFinalReserva());
        entity.setIdTcReserva(dto.getIdTcReserva());

        List<ReservaItemEntity> listaItemEntity = new ArrayList<>();
        for (ReservaItemDTO item : dto.getItens()) {
            ReservaItemEntity itemEntity = new ReservaItemEntity();
            ProdutoEntity produtoEntity = produtoBo.ParseEntity(item.getProduto());


            itemEntity.setProduto(produtoEntity);
            itemEntity.setQtProduto(item.getQtProduto());
            listaItemEntity.add(itemEntity);
        }
        entity.setItens(listaItemEntity);


            return entity;
    }

}



