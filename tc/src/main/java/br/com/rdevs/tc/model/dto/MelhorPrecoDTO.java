package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MelhorPrecoDTO {

    private BigInteger idMelhorPreco;
    private int qtItem;
    private float pcDesconto;
    private ProdutoDTO produto;
    private OperadorDTO operador;
    private ClienteDTO cliente;
    private float vlDesconto;

}
