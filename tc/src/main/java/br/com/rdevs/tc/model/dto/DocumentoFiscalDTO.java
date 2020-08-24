package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentoFiscalDTO {

    private Long idDocumentoFiscal;

    private Long cdOperacao;

    private BigInteger cdFilial;

    private BigInteger idCliente;

    private Long idFornecedor;

    private Long idRecarga;

    private Date dataAbertura;

    private Date dataFechamento;

    private Integer flagNota;

    private Double valorDocumento;

    private Integer numeroCaixa;

//    private Long idMotivo;
//
//    private Long numeroNota;
//
//    private Long numeroChaveAcesso;
//
//    private Long numeroSerie;
//
//    private Date dataEmissao;
//
//    private Date dataEntrada;

}
