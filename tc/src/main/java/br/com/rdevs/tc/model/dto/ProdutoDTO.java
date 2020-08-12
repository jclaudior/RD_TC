package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private BigInteger cdProduto;
    private BigInteger idStatusProduto;
    private BigInteger idCategoria;
    private BigInteger idTipoProduto;
    private String nmFantasia;
    private String nmFabricante;
    private double vlUnidade;
}
