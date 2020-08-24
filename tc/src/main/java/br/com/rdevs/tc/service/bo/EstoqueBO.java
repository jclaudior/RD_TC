package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.EstoqueDTO;
import br.com.rdevs.tc.model.entity.EstoqueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueBO {

    @Autowired
    ProdutoBo produto;

    @Autowired
    FilialBO filial;

    public EstoqueDTO parseToDto(EstoqueEntity estoqueEntity) {

        EstoqueDTO dto = new EstoqueDTO();

        dto.setCdEstoque(estoqueEntity.getCdEstoque());
        dto.setQtBase(estoqueEntity.getQtBase());
        dto.setQtEmpenho(estoqueEntity.getQtEmpenho());
        dto.setQtEstoque(estoqueEntity.getQtEstoque());
        dto.setProduto(produto.ParseToDto(estoqueEntity.getProduto()));
        dto.setFilial(filial.parseToDTO(estoqueEntity.getFilial()));

        return  dto;
    }
    public EstoqueEntity parseToEntity(EstoqueDTO estoqueDto){

        EstoqueEntity entity = new EstoqueEntity();

        entity.setCdEstoque(estoqueDto.getCdEstoque());
        entity.setQtBase(estoqueDto.getQtBase());
        entity.setQtEmpenho(estoqueDto.getQtEmpenho());
        entity.setQtEstoque(estoqueDto.getQtEstoque());
        entity.setProduto(produto.ParseEntity(estoqueDto.getProduto()));
        entity.setFilial(filial.parseToEntity(estoqueDto.getFilial()));

        return entity;
    }
}
