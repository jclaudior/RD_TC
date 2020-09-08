package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.DocumentoItemDTO;
import br.com.rdevs.tc.model.entity.DocumentoItemEntity;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import br.com.rdevs.tc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentoItemBO {

    @Autowired
    DocumentoFiscalBO documentoFiscalBO;

    @Autowired
    DocumentoFiscalRepository documentoFiscalRepository;

    @Autowired
    ProdutoBo produtoBo;

    @Autowired
    ProdutoRepository produtoRepository;


    public DocumentoItemDTO parseToDTO(DocumentoItemEntity entity){

        DocumentoItemDTO itemDTO = new DocumentoItemDTO();

        itemDTO.setDocumentoFiscal(documentoFiscalBO.parseToDTO(entity.getDocumentoFiscal()));
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

        //itemEntity.setDocumentoFiscal(documentoFiscalBO.parseToEntity(dto.getIdDocumentoFiscal()));
        itemEntity.setDocumentoFiscal(documentoFiscalRepository.getOne(dto.getDocumentoFiscal().getIdDocumentoFiscal()));
        itemEntity.setNumItemDocumento(dto.getNumItemDocumento());
        //itemEntity.setProduto(produtoBo.ParseEntity(dto.getProduto()));
        itemEntity.setProduto(produtoRepository.getOne(dto.getProduto().getCdProduto()));
        itemEntity.setQtdItem(dto.getQtItem());
        itemEntity.setValorItem(dto.getValorItem());
        itemEntity.setPorcentoIcms(dto.getPorcentoIcms());
        itemEntity.setValorIcms(dto.getValorIcms());

        return itemEntity;
    }
}
