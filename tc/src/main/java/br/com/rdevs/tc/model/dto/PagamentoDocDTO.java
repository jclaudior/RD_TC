package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDocDTO {

    private BigInteger idPagamento;
    //private DocumentoFiscalDTO documentoFiscal;
    private Double vlPagamento;
    private TipoPagamentoDTO tipoPagamento;

}
