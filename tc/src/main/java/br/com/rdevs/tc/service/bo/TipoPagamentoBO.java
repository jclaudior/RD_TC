package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.TipoPagamentoDTO;
import br.com.rdevs.tc.model.entity.TipoPagamentoEntity;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoPagamentoBO {





    public TipoPagamentoDTO parseToDTO (TipoPagamentoEntity entity){

        TipoPagamentoDTO dto = new TipoPagamentoDTO();

        dto.setIdTipoPagamento(entity.getIdTipoPagamento());
        dto.setDsTipoPagamento(entity.getDsTipoPagamento());

        return dto;
    }
    public  TipoPagamentoEntity parseToEntity (TipoPagamentoDTO dto){

        TipoPagamentoEntity entity = new TipoPagamentoEntity();

        entity.setIdTipoPagamento(dto.getIdTipoPagamento());
        entity.setDsTipoPagamento(dto.getDsTipoPagamento());

        return entity;
    }
}
