package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.CategoriaProdutoDTO;
import br.com.rdevs.tc.model.entity.CategoriaProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CategoriaProdutoBO {

    @Autowired
    SubCategoriaProdutoBO subCategoriaProdutoBO;

    public CategoriaProdutoDTO parseDTO(CategoriaProdutoEntity categoriaProdutoEntity) {
        CategoriaProdutoDTO categoriaProdutoDTO = new CategoriaProdutoDTO();
        categoriaProdutoDTO.setIdCategoria(categoriaProdutoEntity.getIdCategoria());
        categoriaProdutoDTO.setDsCategoria(categoriaProdutoEntity.getDsCategoria());
        categoriaProdutoDTO.setSubCategoria(subCategoriaProdutoBO.parseDTO(categoriaProdutoEntity.getSubCategoria()));
        return categoriaProdutoDTO;
    }

    public CategoriaProdutoEntity parseEntity(CategoriaProdutoDTO categoriaProdutoDTO) {
        CategoriaProdutoEntity categoriaProdutoEntity = new CategoriaProdutoEntity();
        categoriaProdutoEntity.setIdCategoria(categoriaProdutoDTO.getIdCategoria());
        categoriaProdutoEntity.setDsCategoria(categoriaProdutoDTO.getDsCategoria());
        categoriaProdutoEntity.setSubCategoria(subCategoriaProdutoBO.parseEntity(categoriaProdutoDTO.getSubCategoria()));
        return categoriaProdutoEntity;
    }

}

