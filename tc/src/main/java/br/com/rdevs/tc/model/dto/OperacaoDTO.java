package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacaoDTO {

    private BigInteger cdOperacao;
    private BigInteger tipoOperacao;
    private String descricaoOperacao;

}
