package br.com.rdevs.tc.model.dto;

import lombok.Data;

@Data
public class DocumentoItemDTO {

    private DocumentoFiscalDTO idDocumentoFiscal;

    private Long numItemDocumento;

    private ProdutoDTO produto;

    private Long qtItem;

    private Double valorItem;

    private Double porcentoIcms;

    private Double valorIcms;
}
