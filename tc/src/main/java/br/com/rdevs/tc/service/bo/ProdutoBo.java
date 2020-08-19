package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.LmpmItemDTO;
import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.entity.LmpmItemEntity;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoBo {

    @Autowired
    LmpmItemBo lmpmItemBo;
    public ProdutoDTO ParseToDto(ProdutoEntity produtoEntity) {

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setCdProduto(produtoEntity.getCdProduto());
        produtoDTO.setIdCategoria(produtoEntity.getIdCategoria());
        produtoDTO.setIdStatusProduto(produtoEntity.getIdStatusProduto());
        produtoDTO.setIdTipoProduto(produtoEntity.getIdTipoProduto());
        produtoDTO.setNmFabricante(produtoEntity.getNmFabricante());
        produtoDTO.setNmFantasia(produtoEntity.getNmFantasia());
        produtoDTO.setVlUnidade(produtoEntity.getVlUnidade());
        List<LmpmItemDTO>  lmpmItemDTO = new ArrayList<>();
        if(produtoDTO.getLmpmLista() != null) {
            for (LmpmItemEntity lmpmItemEntity : produtoEntity.getLmpmLista()) {
                lmpmItemDTO.add(lmpmItemBo.parseToDto(lmpmItemEntity));
            }
        }
        produtoDTO.setLmpmLista(lmpmItemDTO);
        return produtoDTO;
    }

}
