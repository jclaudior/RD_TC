package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.MelhorPrecoDTO;
import br.com.rdevs.tc.model.entity.MelhorPrecoEntity;
import br.com.rdevs.tc.repository.MelhorPrecoRepository;
import br.com.rdevs.tc.service.bo.MelhorPercoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MelhorPrecoService {

    @Autowired
    MelhorPercoBO bo;

    @Autowired
    MelhorPrecoRepository repository;

    public MelhorPrecoEntity inserir (MelhorPrecoDTO dto){
        MelhorPrecoEntity entity = bo.parseToEntity(dto, null);
        if(entity.getClienteEntity() != null && entity.getOperadorEntity() != null && entity.getProdutoEntity() != null){
            repository.save(entity);
        }
        return entity;
    }

}
