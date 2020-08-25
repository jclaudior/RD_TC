package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.EstoqueDTO;
import br.com.rdevs.tc.model.entity.EstoqueEntitty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueBO {

    @Autowired
    ProdutoBo produtoBo;

    @Autowired
    FilialBO filialBO;

    public EstoqueDTO parseToDto(EstoqueEntitty estoqueEntitty) {
        if  (estoqueEntitty == null)
            return null;

        EstoqueDTO estoqueDTO = new EstoqueDTO();
        estoqueDTO.setCdEstoque(estoqueEntitty.getCdEstoque());
        estoqueDTO.setQtEstoque(estoqueEntitty.getQtEstoque());
        estoqueDTO.setQtEmpenho(estoqueEntitty.getQtEmpenho());
        estoqueDTO.setQtBase(estoqueEntitty.getQtBase());
        estoqueDTO.setProduto(produtoBo.ParseToDto(estoqueEntitty.getProduto()));
        estoqueDTO.setFilial(filialBO.parseToDTO(estoqueEntitty.getFilial()));

        return estoqueDTO;
    }

    public EstoqueEntitty parseToEntity(EstoqueDTO estoqueDTO) {

        if (estoqueDTO == null)
            return null;

        EstoqueEntitty estoqueEntitty = new EstoqueEntitty();
        estoqueEntitty.setCdEstoque(estoqueDTO.getCdEstoque());
        estoqueEntitty.setQtEstoque(estoqueDTO.getQtEstoque());
        estoqueEntitty.setQtEmpenho(estoqueDTO.getQtEmpenho());
        estoqueEntitty.setQtBase(estoqueDTO.getQtEmpenho());
        estoqueEntitty.setProduto(produtoBo.ParseEntity(estoqueDTO.getProduto()));
        estoqueEntitty.setFilial(filialBO.parseToEntity(estoqueDTO.getFilial()));

        return estoqueEntitty;
    }
}
