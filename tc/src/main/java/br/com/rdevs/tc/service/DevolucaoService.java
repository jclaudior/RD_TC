package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.DevolucaoDTO;
import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.entity.DevolucaoEntity;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.repository.DevolucaoRepository;
import br.com.rdevs.tc.service.bo.DevolucaoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DevolucaoService {

    @Autowired
    DevolucaoBO bo;

    @Autowired
    DevolucaoRepository repository;

    public void inserirDevolucao (DevolucaoDTO dto) {

        DevolucaoEntity entity = bo.parseToEntity(dto);
        repository.save(entity);
    }
}
