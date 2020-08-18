package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.repository.ClienteRepository;
import br.com.rdevs.tc.repository.ReservaRepository;
import br.com.rdevs.tc.service.bo.ClienteBO;
import br.com.rdevs.tc.service.bo.ReservaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private ClienteBO clienteBO;

    @Autowired
    private ReservaBO reservaBo;

    public List<ReservaDTO> listarPorCliente(BigInteger idCliente) {

        List<ReservaEntity> listEntity = repository.findByClienteIdCliente(idCliente);
        List<ReservaDTO> listDTO = new ArrayList<>();
        for (ReservaEntity entity : listEntity) {
            ReservaDTO dto = reservaBo.parseToDTO(entity);

            listDTO.add(dto);
        }
        return listDTO;

    }
    public ReservaEntity inserir(ReservaDTO dto) {
        ReservaEntity entity = reservaBo.parseToEntity(dto, null);
        if(entity.getCliente() != null)
              repository.save(entity);

        return entity;
    }

}

