package br.com.rdevs.tc.model.dto;

import lombok.Data;

@Data
public class DocumentoItemDTO {

    private DocumentoFiscalDTO idDocumentoFiscal;

    private Long numItemDocumento;

    private ProdutoDTO produto;

    private Integer qtItem;

    private Double valorItem;

    private Double porcentoIcms;

    private Double valorIcms;
}
