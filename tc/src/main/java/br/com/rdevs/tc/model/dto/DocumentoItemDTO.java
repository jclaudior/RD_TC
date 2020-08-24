package br.com.rdevs.tc.model.dto;

import lombok.Data;

@Data
public class DocumentoItemDTO {

    private Long documentoFiscal;

    private Long numItemDoc;

    private Long cdProduto;

    private Long qtdItem;

    private Double valorItem;

    private Double porcentoIcms;

    private Double valorIcms;
}
