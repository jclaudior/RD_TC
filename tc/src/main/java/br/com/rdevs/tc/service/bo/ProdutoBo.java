package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.LmpmItemDTO;
import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.entity.LmpmItemEntity;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.Date;

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
            for (LmpmItemEntity lmpmItemEntity : produtoEntity.getLmpmLista()) {
                Date dataAtual = new Date();
                Date dataDaPromocao = lmpmItemBo.parseToDto(lmpmItemEntity).getLmpm().getDtFimLmpm();
                if (dataDaPromocao.after(dataAtual)||dataDaPromocao.equals(dataAtual)) {
                    lmpmItemDTO.add(lmpmItemBo.parseToDto(lmpmItemEntity));
                }
            }

        produtoDTO.setLmpmLista(lmpmItemDTO);
        return produtoDTO;


    }

    public ProdutoEntity ParseEntity(ProdutoDTO produtoDTO) {

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setCdProduto(produtoDTO.getCdProduto());
        produtoEntity.setIdCategoria(produtoDTO.getIdCategoria());
        produtoEntity.setIdStatusProduto(produtoDTO.getIdStatusProduto());
        produtoEntity.setIdTipoProduto(produtoDTO.getIdTipoProduto());
        produtoEntity.setNmFabricante(produtoDTO.getNmFabricante());
        produtoEntity.setNmFantasia(produtoDTO.getNmFantasia());
        produtoEntity.setVlUnidade(produtoDTO.getVlUnidade());
        List<LmpmItemEntity> lmpmItemEntity = new ArrayList<>();
        if (produtoDTO.getLmpmLista() != null) {
            for (LmpmItemDTO lmpmItemDTO : produtoDTO.getLmpmLista()) {
                lmpmItemEntity.add(lmpmItemBo.parseEntity(lmpmItemDTO));
            }
            }
            produtoEntity.setLmpmLista(lmpmItemEntity);

            return produtoEntity;
        }
    }

