package br.com.rdevs.tc.model.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class DocumentoItemDTO {

    private DocumentoFiscalDTO documentoFiscal;

    private BigInteger numItemDocumento;

    private ProdutoDTO produto;

    private Integer qtItem;

    private Double valorItem;

    private Double porcentoIcms;

    private Double valorIcms;

    private Integer qtDevolvida;

    private TipoPagamentoDTO formaDevolucao;
}
