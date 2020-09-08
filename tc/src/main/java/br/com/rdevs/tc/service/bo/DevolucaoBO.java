package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.DevolucaoDTO;
import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.entity.DevolucaoEntity;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import br.com.rdevs.tc.repository.TipoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DevolucaoBO {

    @Autowired
    DocumentoFiscalBO docBO;

    @Autowired
    ClienteBO clienteBO;

    @Autowired
    TipoPagamentoBO pagBO;

    public DevolucaoEntity parseToEntity (DevolucaoDTO dto){
        DevolucaoEntity entity = new DevolucaoEntity();

        entity.setDocumentoFiscal(dto.getDocumentoFiscal());
        entity.setCliente(clienteBO.parseEntity(dto.getCliente()));
        entity.setVlDevolucao(dto.getVlDevolucao());
        entity.setTipoPagamento(pagBO.parseToEntity(dto.getTipoPagamento()));
        entity.setNrItemDocumento(dto.getNrItemDocumento());

        return  entity;
    }

}
