package br.com.rdevs.tc.model.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigInteger;

@Data
public class SubCategoriaProdutoDTO {

    private BigInteger idSubCategoria;
    private String dsSubCategoria;
}
