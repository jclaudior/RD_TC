package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.LmpmDTO;
import br.com.rdevs.tc.model.entity.LmpmEntitty;
import org.springframework.stereotype.Component;

@Component
public class LmpmBo {

    public LmpmDTO parseToDto(LmpmEntitty lmpmEntitty){
        LmpmDTO lmpmDTO = new LmpmDTO();
        lmpmDTO.setDtInicioLmpm(lmpmEntitty.getDtInicioLmpm());
        lmpmDTO.setDtFimLmpm(lmpmEntitty.getDtFimLmpm());


        return lmpmDTO;
    }


    public LmpmEntitty parseToEntity(LmpmDTO lmpmDTO){
        LmpmEntitty lmpmEntitty = new LmpmEntitty();
        lmpmEntitty.setDtInicioLmpm(lmpmDTO.getDtInicioLmpm());
        lmpmEntitty.setDtFimLmpm(lmpmDTO.getDtFimLmpm());


        return lmpmEntitty;
    }


}
