package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ClienteDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.ClienteEntity;
import br.com.rdevs.tc.repository.ClienteRepository;
import br.com.rdevs.tc.service.bo.ClienteBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    ClienteBO bo;

    public ResponseEntity buscarCliente(String dadosCliente){
        ResultData resultData = null;
        if(dadosCliente.isEmpty()){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Dados do cliente Invalidos!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        try {
            List<ClienteEntity> listEntity = null;
            List<ClienteDTO> listDTO = new ArrayList<>();
            if (bo.isName(dadosCliente)) {
                listEntity = repository.findByNmClienteContaining(dadosCliente);
            } else if (bo.isCPF(dadosCliente)) {
                listEntity = repository.findByNrCpf(dadosCliente);

            } else if (bo.isRg(dadosCliente)) {
                listEntity = repository.findByNrRg(dadosCliente);

            }
            for (ClienteEntity entity : listEntity) {
                ClienteDTO dto = bo.parseDTO(entity);
                listDTO.add(dto);
                if(listDTO.size() == 0){
                    resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro ao consultar cliente!");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
                }
            }

            resultData = new ResultData(HttpStatus.ACCEPTED.value(), "Consulta de cliente realizada com sucesso!", listDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        }catch(Exception e){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro ao consultar cliente " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }




}
