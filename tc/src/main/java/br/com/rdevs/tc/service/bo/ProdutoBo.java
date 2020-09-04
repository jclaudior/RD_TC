package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.LmpmItemDTO;
import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.dto.SubCategoriaProdutoDTO;
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

    @Autowired
    CategoriaProdutoBO categoriaProdutoBO;

    @Autowired
    SubCategoriaProdutoBO subCategoriaProdutoBO;

    @Autowired
    StatusProdutoBO statusProdutoBO;

    public ProdutoDTO ParseToDto(ProdutoEntity produtoEntity) {

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setCdProduto(produtoEntity.getCdProduto());
        produtoDTO.setCategoria(categoriaProdutoBO.parseDTO(produtoEntity.getCategoria()));
        produtoDTO.setStatusProduto(statusProdutoBO.parseToDTO(produtoEntity.getStatusProduto()));
        //produtoDTO.setIdStatusProduto(produtoEntity.getIdStatusProduto());
        produtoDTO.setIdTipoProduto(produtoEntity.getIdTipoProduto());
        produtoDTO.setNmFabricante(produtoEntity.getNmFabricante());
        produtoDTO.setNmFantasia(produtoEntity.getNmFantasia());
        produtoDTO.setVlUnidade(produtoEntity.getVlUnidade());
        produtoDTO.setDsProduto(produtoEntity.getDsProduto());

        List<LmpmItemDTO>  lmpmItemDTO = new ArrayList<>();
            for (LmpmItemEntity lmpmItemEntity : produtoEntity.getLmpmLista()) {
                Date dataAtual = new Date();
                Date dataDaPromocao = lmpmItemBo.parseToDto(lmpmItemEntity).getLmpm().getDtFimLmpm();
                if (dataDaPromocao.after(dataAtual)||dataDaPromocao.equals(dataAtual)) {
                    produtoDTO.setLmpmItem(lmpmItemBo.parseToDto(lmpmItemEntity));
                }
            }
        produtoDTO.setSubCategoria(subCategoriaProdutoBO.parseDTO((produtoEntity.getSubCategoria())));


        return produtoDTO;

    }

    public ProdutoEntity ParseEntity(ProdutoDTO produtoDTO) {

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setCdProduto(produtoDTO.getCdProduto());
        if(produtoDTO.getCategoria() != null){
            produtoEntity.setCategoria(categoriaProdutoBO.parseEntity(produtoDTO.getCategoria()));
        }
        produtoEntity.setStatusProduto(statusProdutoBO.parseToEntity(produtoDTO.getStatusProduto()));
        //produtoEntity.setIdStatusProduto(produtoDTO.getIdStatusProduto());
        produtoEntity.setIdTipoProduto(produtoDTO.getIdTipoProduto());
        produtoEntity.setNmFabricante(produtoDTO.getNmFabricante());
        produtoEntity.setNmFantasia(produtoDTO.getNmFantasia());
        produtoEntity.setVlUnidade(produtoDTO.getVlUnidade());
        produtoEntity.setDsProduto(produtoDTO.getDsProduto());
        List<LmpmItemEntity> lmpmItemEntity = new ArrayList<>();
//        if (produtoDTO.getLmpmLista() != null) {
//            for (LmpmItemDTO lmpmItemDTO : produtoDTO.getLmpmLista()) {
//                lmpmItemEntity.add(lmpmItemBo.parseEntity(lmpmItemDTO));
//            }
//            }
//            produtoEntity.setLmpmLista(lmpmItemEntity);

        produtoEntity.setSubCategoria(subCategoriaProdutoBO.parseEntity(produtoDTO.getSubCategoria()));

            return produtoEntity;

    }
}


