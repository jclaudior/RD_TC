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

    private Long idDocumentoFiscal;
    private OperacaoDTO operacao;
    private FilialDTO filial;
    private ClienteDTO cliente;
    private MotivoDTO motivo;

    private Date dataAbertura;
    private Date dataFechamento;

    private Integer flagNota;

    private Double valorDocumento;

    private Integer numeroCaixa;

    private List<DocumentoItemDTO> itens;



}
