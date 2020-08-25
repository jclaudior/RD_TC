package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {

    private BigInteger cdEstoque;
    private FilialDTO filial;
    private ProdutoDTO produto;
    private Integer qtEstoque;
    private Integer qtEmpenho;
    private Integer qtBase;
}
