package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.DevolucaoDTO;
import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.DocumentoItemDTO;
import br.com.rdevs.tc.model.dto.PagamentoDocDTO;
import br.com.rdevs.tc.model.entity.*;
import br.com.rdevs.tc.repository.*;
import br.com.rdevs.tc.service.DevolucaoService;
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
    PagamentoDocRepository repositoryPagamento;

    @Autowired
    PagamentoDocBO pagamentoBO;

    @Autowired
    DevolucaoService devolucaoService;

    @Autowired
    DocumentoFiscalRepository docRepository;

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
        List<DocumentoItemEntity> listDocumentoEntity = repositoryDocumentoItem.findByDocumentoFiscalIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        List<DocumentoItemDTO> listDocumentoDTO = new ArrayList<>();

        int totalItensDevolvido = 0;

        for(DocumentoItemEntity itemEntity: listDocumentoEntity){
            DocumentoItemDTO itemDTO = new DocumentoItemDTO();

            itemDTO = documentoItemBO.parseToDTO(itemEntity);

            if(itemDTO.getQtDevolvida() >= itemDTO.getQtItem()){
                totalItensDevolvido++;
            }

            listDocumentoDTO.add(itemDTO);
        }

        dto.setItens(listDocumentoDTO);

        //Set Tipos Pagamento
        List<PagamentoDocEntity> listTipoPagamento  = repositoryPagamento.findBydocumentoFiscalIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        List<PagamentoDocDTO> listPagamentoDTO = new ArrayList<>();

        for(PagamentoDocEntity pagDocEntity: listTipoPagamento){
            PagamentoDocDTO pagDto = new PagamentoDocDTO();

            pagDto = pagamentoBO.parseToDTO(pagDocEntity);
            listPagamentoDTO.add(pagDto);
        }
        dto.setTipoPagamento(listPagamentoDTO);

        if(totalItensDevolvido >= dto.getItens().size()){

            entity.setFlagNotaDevolvida(1);
            docRepository.save(entity);

        }else {

        }

        dto.setNotaDevolvida(entity.getFlagNotaDevolvida());

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
        int i = 0;

        for(DocumentoItemDTO itemDTO: dto.getItens()){

            DocumentoItemEntity entityItem = new DocumentoItemEntity();

            entityItem.setNumItemDocumento(dto.getNrNumeroItem().get(i));
            ProdutoEntity produtoEntity = produtoBo.ParseEntity(itemDTO.getProduto());
            entityItem.setProduto(produtoEntity);
            entityItem.setQtdItem(itemDTO.getQtItem());
            entityItem.setValorItem(itemDTO.getValorItem());
            entityItem.setValorIcms(itemDTO.getValorIcms());
            entityItem.setPorcentoIcms(itemDTO.getPorcentoIcms());
            entityItem.setQtDevolvida(itemDTO.getQtItem());

            DevolucaoDTO devoDto = new DevolucaoDTO();

            devoDto.setDocumentoFiscal(dto.getIdDocumentoFiscalVenda());
            devoDto.setNrItemDocumento(dto.getNrNumeroItem().get(i));
            devoDto.setCliente(clienteBO.parseDTO(entity.getCliente()));
            devoDto.setVlDevolucao(entity.getValorDocumento());
            devoDto.setTipoPagamento(itemDTO.getFormaDevolucao());

            devolucaoService.inserirDevolucao(devoDto);

            DocumentoItemPK  pk = new DocumentoItemPK();
            pk.setDocumentoFiscal(docRepository.getOne(dto.getIdDocumentoFiscalVenda()));
            pk.setNumItemDocumento(dto.getNrNumeroItem().get(i));

            DocumentoItemEntity entityItemNota = repositoryDocumentoItem.getOne(pk);

            entityItemNota.setQtDevolvida(itemDTO.getQtItem().intValue());
            repositoryDocumentoItem.save(entityItemNota);

            entityItem.setDocumentoFiscal(entity);
            listItemEntity.add(entityItem);
            i++;
        }

        entity.setItens(listItemEntity);

        return entity;
    }
}
