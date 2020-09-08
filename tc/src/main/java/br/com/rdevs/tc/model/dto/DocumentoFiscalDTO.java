package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentoFiscalDTO {

    private BigInteger idDocumentoFiscal;
    private OperacaoDTO operacao;
    private FilialDTO filial;
    private ClienteDTO cliente;
    private MotivoDTO motivo;

    private BigInteger idDocumnetoFiscalVenda;
    private BigInteger nrNumeroItem;

    private Date dataAbertura;
    private Date dataFechamento;

    private Integer flagNota;

    private Double valorDocumento;

    private Integer numeroCaixa;

    private List<DocumentoItemDTO> itens;

    private  List<PagamentoDocDTO> tipoPagamento;

    private Integer notaDevolvida;




}
