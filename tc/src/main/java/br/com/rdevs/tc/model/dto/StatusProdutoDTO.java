package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StatusProdutoDTO {

    private BigInteger idStatusProduto;
    private String dsStatusProduto;

}
