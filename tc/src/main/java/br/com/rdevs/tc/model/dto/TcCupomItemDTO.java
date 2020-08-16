package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TcCupomItemDTO {

    private BigInteger idCupomItem;
    private float pcDesconto;
    private TcCupomDTO cupom;
    private ProdutoDTO produto;
}
