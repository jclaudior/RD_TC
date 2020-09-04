package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.dto.TcCupomItemDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.model.entity.TcCupomItemEntity;
import br.com.rdevs.tc.repository.CupomItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CupomBO {

    @Autowired
    ProdutoBo produtoBo;

    @Autowired
    ClienteBO clienteBO;

    @Autowired
    CupomItemRepository repository;

    public TcCupomDTO parseToDTO(TcCupomEntity entity){
        if(entity == null){
            return null;
        }
        TcCupomDTO dto = new TcCupomDTO();
        dto.setIdCupom(entity.getIdCupom());
        dto.setDtInicialCupom(entity.getDtInicialCupom());
        dto.setDtFinalCupom(entity.getDtFinalCupom());

        //SetCliente
        dto.setCliente(clienteBO.parseDTO(entity.getCliente()));

        //SetItens
        List<TcCupomItemEntity> listEntity = new ArrayList<>();
        listEntity = repository.findByTcCupomIdCupom(entity.getIdCupom());
        List<TcCupomItemDTO> listDTO = new ArrayList<>();


        for(TcCupomItemEntity itens: listEntity){

            TcCupomItemDTO itemDTO = new TcCupomItemDTO();

            itemDTO.setIdCupomItem(itens.getIdCupomItem());
            itemDTO.setPcDesconto(itens.getPcDesconto());
            itemDTO.setProduto(produtoBo.ParseToDto(itens.getProdutoEntity()));

            listDTO.add(itemDTO);
        }
        dto.setItensCupom(listDTO);

        return dto;
    }
}
