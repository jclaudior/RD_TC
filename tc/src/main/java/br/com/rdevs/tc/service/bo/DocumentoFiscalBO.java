package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.DocumentoItemDTO;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.model.entity.DocumentoItemEntity;
import br.com.rdevs.tc.model.entity.OperacaoEntity;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentoFiscalBO {

    @Autowired
    ClienteBO clienteBO;

    @Autowired
    ClienteRepository repositoryCliente;

    @Autowired
    FilialBO filialBO;

    @Autowired
    FilialRepository repositoryFilial;

    @Autowired
    MotivoBO motivoBO;

    @Autowired
    MotivoRepository repositoryMotivo;

    @Autowired
    DocumentoItemBO documentoItemBO;

    @Autowired
    DocumentoItemRepository repositoryDocumentoItem;

    @Autowired
    OperacaoBO operacaoBO;

    @Autowired
    OperacaoRepository repositoryOperacao;

    @Autowired
    ProdutoBo produtoBo;

    @Autowired
    TipoPagamentoRepository repositoryPagamento;

    public DocumentoFiscalDTO parseToDTO(DocumentoFiscalEntity entity){
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if(entity == null)
            return dto;

        dto.setIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        dto.setOperacao(operacaoBO.parseToDTO(entity.getOperacao()));
        dto.setFilial(filialBO.parseToDTO(entity.getFilial()));
        dto.setCliente(clienteBO.parseDTO(entity.getCliente()));
        dto.setMotivo(motivoBO.parseToDTO(entity.getMotivoDevolucao()));
        dto.setDataAbertura(entity.getDataAbertura());
        dto.setDataFechamento(entity.getDataFechamento());
        dto.setFlagNota(entity.getFlagNota());
        dto.setValorDocumento(entity.getValorDocumento());
        dto.setNumeroCaixa(entity.getNumeroCaixa());

        //Set Itens
        List<DocumentoItemEntity> listDocumentoEntity = repositoryDocumentoItem.findByIdDocumentoFiscalIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        List<DocumentoItemDTO> listDocumentoDTO = new ArrayList<>();

        for(DocumentoItemEntity itemEntity: listDocumentoEntity){
            DocumentoItemDTO itemDTO = new DocumentoItemDTO();

            itemDTO = documentoItemBO.parseToDTO(itemEntity);
            listDocumentoDTO.add(itemDTO);
        }
        dto.setItens(listDocumentoDTO);

        return dto;
    }


    public DocumentoFiscalEntity parseToEntity(DocumentoFiscalDTO dto){

        DocumentoFiscalEntity entity = new DocumentoFiscalEntity();

        entity.setIdDocumentoFiscal(dto.getIdDocumentoFiscal());
        entity.setOperacao(repositoryOperacao.getOne(dto.getOperacao().getCdOperacao()));
        entity.setFilial(repositoryFilial.getOne(dto.getFilial().getCdFilial()));
        entity.setCliente(repositoryCliente.getOne(dto.getCliente().getIdCliente()));
        entity.setMotivoDevolucao(repositoryMotivo.getOne(dto.getMotivo().getIdMotivo()));
        entity.setDataAbertura(dto.getDataAbertura());
        entity.setDataFechamento(dto.getDataFechamento());
        entity.setFlagNota(dto.getFlagNota());
        entity.setValorDocumento(dto.getValorDocumento());
        entity.setNumeroCaixa(dto.getNumeroCaixa());

        List<DocumentoItemEntity> listItemEntity = new ArrayList<>();
        for(DocumentoItemDTO itemDTO: dto.getItens()){

            DocumentoItemEntity entityItem = new DocumentoItemEntity();
            entityItem.setNumItemDocumento(itemDTO.getNumItemDocumento());
            ProdutoEntity produtoEntity = produtoBo.ParseEntity(itemDTO.getProduto());
            entityItem.setProduto(produtoEntity);
            entityItem.setQtdItem(itemDTO.getQtItem());
            entityItem.setValorItem(itemDTO.getValorItem());
            entityItem.setValorIcms(itemDTO.getValorIcms());
            entityItem.setPorcentoIcms(itemDTO.getPorcentoIcms());

            entityItem.setIdDocumentoFiscal(entity);

            listItemEntity.add(entityItem);
        }

        entity.setItens(listItemEntity);

        return entity;
    }
}
