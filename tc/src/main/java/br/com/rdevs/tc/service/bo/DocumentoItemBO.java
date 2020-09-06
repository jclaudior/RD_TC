package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.DocumentoItemDTO;
import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.entity.DocumentoItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentoItemBO {

    @Autowired
    DocumentoFiscalBO documentoFiscalBO;

    @Autowired
    ProdutoBo produtoBo;


    public DocumentoItemDTO parseToDTO(DocumentoItemEntity entity){

        DocumentoItemDTO itemDTO = new DocumentoItemDTO();

        //itemDTO.setIdDocumentoFiscal(documentoFiscalBO.parseToDTO(entity.getIdDocumentoFiscal()));
        itemDTO.setNumItemDocumento(entity.getNumItemDocumento());
        itemDTO.setProduto(produtoBo.ParseToDto(entity.getProduto()));
        itemDTO.setQtItem(entity.getQtdItem());
        itemDTO.setValorItem(entity.getValorItem());
        itemDTO.setPorcentoIcms(entity.getPorcentoIcms());
        itemDTO.setValorIcms(entity.getValorIcms());
        itemDTO.setQtDevolvida(entity.getQtDevolvida());

        return itemDTO;

    }
    public  DocumentoItemEntity parseToEntity (DocumentoItemDTO dto, DocumentoItemEntity entity){

        DocumentoItemEntity itemEntity = new DocumentoItemEntity();

        itemEntity.setDocumentoFiscal(documentoFiscalBO.parseToEntity(dto.getIdDocumentoFiscal()));
        itemEntity.setNumItemDocumento(dto.getNumItemDocumento());
        itemEntity.setProduto(produtoBo.ParseEntity(dto.getProduto()));
        itemEntity.setQtdItem(dto.getQtItem());
        itemEntity.setValorItem(dto.getValorItem());
        itemEntity.setPorcentoIcms(dto.getPorcentoIcms());
        itemEntity.setValorIcms(dto.getValorIcms());

        return itemEntity;
    }
}
