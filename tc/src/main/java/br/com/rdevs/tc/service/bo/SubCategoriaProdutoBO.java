package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.SubCategoriaProdutoDTO;
import br.com.rdevs.tc.model.entity.SubCategoriaProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class SubCategoriaProdutoBO {

    public SubCategoriaProdutoDTO parseDTO(SubCategoriaProdutoEntity subCategoriaProdutoEntity){
        SubCategoriaProdutoDTO subCategoriaProdutoDTO = new SubCategoriaProdutoDTO();
        subCategoriaProdutoDTO.setIdSubCategoria(subCategoriaProdutoEntity.getIdSubCategoria());
        subCategoriaProdutoDTO.setDsSubCategoria(subCategoriaProdutoEntity.getDsSubCategoria());
        return subCategoriaProdutoDTO;
    }

    public SubCategoriaProdutoEntity parseEntity(SubCategoriaProdutoDTO subCategoriaProdutoDTO){
        SubCategoriaProdutoEntity subCategoriaProdutoEntity  = new SubCategoriaProdutoEntity();
        subCategoriaProdutoEntity.setIdSubCategoria(subCategoriaProdutoDTO.getIdSubCategoria());
        subCategoriaProdutoEntity.setDsSubCategoria(subCategoriaProdutoDTO.getDsSubCategoria());
        return subCategoriaProdutoEntity;
    }
}
