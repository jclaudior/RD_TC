package br.com.rdevs.tc.model.dto;

import br.com.rdevs.tc.model.entity.SubCategoriaProdutoEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
public class CategoriaProdutoDTO {
    private BigInteger idCategoria;
    private String dsCategoria;
    private SubCategoriaProdutoDTO subCategoria;
}
