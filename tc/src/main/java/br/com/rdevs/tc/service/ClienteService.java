package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ClienteDTO;
import br.com.rdevs.tc.model.entity.ClienteEntity;
import br.com.rdevs.tc.repository.ClienteRepository;
import br.com.rdevs.tc.service.bo.ClienteBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    ClienteBO bo;

    public List<ClienteDTO> buscarCliente(String dadosCliente){

        List<ClienteEntity> listEntity = null;
        List<ClienteDTO> listDTO = new ArrayList<>();
        if(bo.isName(dadosCliente)) {
            listEntity  = repository.findByNmCliente(dadosCliente);
        }
        else if (bo.isCPF(dadosCliente)){
            listEntity  = repository.findByNrCpf(dadosCliente);

        }
        else if (bo.isRg(dadosCliente)){
            listEntity  = repository.findByNrRg(dadosCliente);

        }
        for (ClienteEntity entity: listEntity) {
            ClienteDTO dto = bo.parseDTO(entity);
            listDTO.add(dto);

        }
        return  listDTO;
    }




}
