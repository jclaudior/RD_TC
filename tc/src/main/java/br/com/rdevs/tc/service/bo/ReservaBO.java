package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Component
public class ReservaBO {

    @Autowired
    private ClienteBO clienteBO;

    @Autowired
    private ProdutoBo produtoBo;

    @Autowired
    private  ReservaItemBO reservaItemBO;

    @Autowired
    private ProdutoRepository produtoRepository;


    public ReservaDTO parseToDTO(ReservaEntity entity){
        ReservaDTO dto = new ReservaDTO();

        if(entity == null)
            return dto;
        dto.setIdTcReserva(entity.getIdTcReserva());
        dto.setClienteDTO(clienteBO.parseDTO(entity.getCliente()));
        dto.setDtInicialReserva(entity.getDtInicialReserva());
        dto.setDtFinalReserva(entity.getDtFinalReserva());
        dto.setDtBaixa(entity.getDtBaixa());
        dto.setNrPedido(entity.getNrPedido());
        List<ReservaItemDTO> listaItemDTO = new ArrayList<>();
        for (ReservaItemEntity item : entity.getItens()) {
            ReservaItemDTO itemDTO = new ReservaItemDTO();
           // itemDTO.setIdReserva(item.getIdTcReservaItem());
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
        entity.setDtBaixa(dto.getDtBaixa());
        entity.setNrPedido(dto.getNrPedido());
        entity.setIdTcReserva(dto.getIdTcReserva());

        List<ReservaItemEntity> listaItemEntity = new ArrayList<>();
        if (dto.getItens() != null) {
            for (ReservaItemDTO item : dto.getItens()) {
                ReservaItemEntity itemEntity = reservaItemBO.parseToEntity(item, null, entity);
                //itemEntity.setReserva(entity);
                listaItemEntity.add(itemEntity);
            }
            entity.setItens(listaItemEntity);
        }
            return entity;
    }

}



