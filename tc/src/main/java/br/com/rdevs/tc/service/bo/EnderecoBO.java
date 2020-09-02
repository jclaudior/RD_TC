package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.ClienteDTO;
import br.com.rdevs.tc.model.dto.EnderecoDTO;
import br.com.rdevs.tc.model.entity.ClienteEntity;
import br.com.rdevs.tc.model.entity.EnderecoEntity;
import org.springframework.stereotype.Component;

@Component
public class EnderecoBO {

    public EnderecoDTO parseDTO(EnderecoEntity entity) {
        if (entity == null) {
            return null;
        }

        EnderecoDTO dto = new EnderecoDTO();
        dto.setDsEndereco(entity.getDsEndereco());
        dto.setNrEndereco(entity.getNrEndereco());
        dto.setNrCep(entity.getNrCep());
        dto.setSgEstado(entity.getSgEstado());
        dto.setCidade(entity.getCidade());

        return dto;

    }
    public EnderecoEntity parseEntity(EnderecoDTO dto) {
        if (dto == null)
            return null;

        EnderecoEntity entity = new EnderecoEntity();
        entity.setDsEndereco(dto.getDsEndereco());
        entity.setNrEndereco(dto.getNrEndereco());
        entity.setNrCep(dto.getNrCep());
        entity.setSgEstado(dto.getSgEstado());
        entity.setCidade(dto.getCidade());

        return entity;
    }
}