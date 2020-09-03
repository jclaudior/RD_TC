package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.PagamentoDocDTO;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.model.entity.PagamentoDocEntity;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import br.com.rdevs.tc.repository.TipoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDocBO {

    @Autowired
    DocumentoFiscalRepository docRepository;

    @Autowired
    TipoPagamentoRepository pagamentoRepository;

    @Autowired
    DocumentoFiscalBO docBO;

    @Autowired
    TipoPagamentoBO pagamentoBO;

    public PagamentoDocDTO parseToDTO (PagamentoDocEntity entity){

        PagamentoDocDTO dto = new PagamentoDocDTO();

        dto.setIdPagamento(entity.getIdPagamento());
        dto.setDocumentoFiscal(docBO.parseToDTO(entity.getDocumentoFiscal()));
        dto.setTipoPagamento(pagamentoBO.parseToDTO(entity.getTipoPagamento()));
        dto.setVlPagamento(entity.getVlPagamento());

        return dto;
    }
    public PagamentoDocEntity parseToEntity (PagamentoDocDTO dto){

        PagamentoDocEntity entity = new PagamentoDocEntity();

        entity.setIdPagamento(dto.getIdPagamento());

        entity.setDocumentoFiscal(docRepository.getOne(dto.getDocumentoFiscal().getIdDocumentoFiscal()));
        entity.setTipoPagamento(pagamentoRepository.getOne(dto.getTipoPagamento().getIdTipoPagamento()));

        entity.setVlPagamento(dto.getVlPagamento());

        return  entity;
    }

}
