package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.LmpmDTO;
import br.com.rdevs.tc.model.dto.LmpmItemDTO;
import br.com.rdevs.tc.model.entity.LmpmItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LmpmItemBo {

    @Autowired
    LmpmBo lmpmBo;

    public LmpmItemDTO parseToDto(LmpmItemEntity lmpmItemEntity){
        LmpmItemDTO lmpmItemDTO = new LmpmItemDTO();
        lmpmItemDTO.setIdLmpmItem(lmpmItemEntity.getIdLmpmItem());
        lmpmItemDTO.setPcDesconto(lmpmItemEntity.getPcDesconto());
        lmpmItemDTO.setQtProduto(lmpmItemEntity.getQtProduto());
        lmpmItemDTO.setLmpm(lmpmBo.parseToDto(lmpmItemEntity.getLmpmEntitty()));
        return lmpmItemDTO;

    }
}
