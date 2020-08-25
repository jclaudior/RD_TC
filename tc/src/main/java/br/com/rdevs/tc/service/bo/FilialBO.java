package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.FilialDTO;
import br.com.rdevs.tc.model.entity.FilialEntity;
import org.springframework.stereotype.Component;

@Component
public class FilialBO {

    public FilialDTO parseToDTO(FilialEntity filialEntity) {

        if  (filialEntity == null)
            return null;

        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setCdFilial(filialEntity.getCdFilial());
        filialDTO.setNmFilial(filialEntity.getNmFilial());
        filialDTO.setNrCnpj(filialEntity.getNrCnpj());
        filialDTO.setNrTelefoneFilial(filialEntity.getNrTelefoneFilial());

        return filialDTO;
    }

    public FilialEntity parseToEntity(FilialDTO filialDTO) {

        if (filialDTO == null)
            return null;

        FilialEntity filialEntity = new FilialEntity();
        filialEntity.setCdFilial(filialDTO.getCdFilial());
        filialEntity.setNmFilial(filialDTO.getNmFilial());
        filialEntity.setNrCnpj(filialDTO.getNrCnpj());
        filialEntity.setNrTelefoneFilial(filialDTO.getNrTelefoneFilial());

        return filialEntity;
    }
}
