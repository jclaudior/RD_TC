package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.FilialDTO;
import br.com.rdevs.tc.model.entity.FilialEntity;
import org.springframework.stereotype.Component;

@Component
public class FilialBO {

    public FilialDTO parseToDTO(FilialEntity entity){

        FilialDTO dto = new FilialDTO();

        dto.setCdFilial(entity.getCdFilial());
        dto.setNmFilial(entity.getNmFilial());
        dto.setNrCnpj(entity.getNrCnpj());
        dto.setNrTelefoneFilial(entity.getNrTelefoneFilial());

        return dto;
    }

    public  FilialEntity parseToEntity(FilialDTO dto){

        FilialEntity entity = new FilialEntity();

        entity.setCdFilial(dto.getCdFilial());
        entity.setNmFilial(dto.getNmFilial());
        entity.setNrCnpj(dto.getNrCnpj());
        entity.setNrTelefoneFilial(dto.getNrTelefoneFilial());

        return entity;
    }
}
