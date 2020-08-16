package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.dto.TcCupomItemDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.model.entity.TcCupomItemEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CupomBO {

    public TcCupomDTO parseToDTO(TcCupomEntity entity){
        if(entity == null){
            return null;
        }
        TcCupomDTO dto = new TcCupomDTO();
        dto.setIdCupom(entity.getIdCupom());
        dto.setDtInicialCupom(entity.getDtInicialCupom());
        dto.setDtFinalCupom(entity.getDtFinalCupom());

        ClienteBO cliente = new ClienteBO();
        dto.setCliente(cliente.parseDTO(entity.getClienteEntity()));

        return dto;
    }
}
