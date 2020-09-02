package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.CategoriaClienteDTO;
import br.com.rdevs.tc.model.dto.ClienteDTO;
import br.com.rdevs.tc.model.dto.EnderecoDTO;
import br.com.rdevs.tc.model.entity.ClienteEntity;
import br.com.rdevs.tc.model.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClienteBO {

    @Autowired
    EnderecoBO enderecoBO;

    public boolean isName(String dadosCliente) {
        if (dadosCliente == null)
            return false;
        try {
            Integer.parseInt(String.valueOf(dadosCliente.charAt(0)));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isCPF(String dadosCliente) {
        if (dadosCliente == null)
            return false;
        if (dadosCliente.length() == 11)
            return true;
        else
            return false;

    }

    public boolean isRg(String dadosCliente) {
        if (dadosCliente == null)
            return false;
        if (dadosCliente.length() == 9)
            return true;
        else
            return false;

    }

    public ClienteDTO parseDTO(ClienteEntity entity) {
            if (entity == null) {
                return null;
            }
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(entity.getIdCliente());
        dto.setNmCliente(entity.getNmCliente());
        dto.setDsEmail(entity.getDsEmail());
        dto.setDtCadastro(entity.getDtCadastro());
        dto.setNrCPF(entity.getNrCpf());
        dto.setNrRg(entity.getNrRg());
        dto.setDtNascimento(entity.getDtNascimento());
        dto.setDsGenero(entity.getDsGenero());
        dto.setNrTelefoneCliente(entity.getNrTelefoneCliente());
        CategoriaClienteDTO categoriaDTO = new CategoriaClienteDTO();
        categoriaDTO.setIdCategoriaCliente(entity.getCategoriaClienteEntity().getIdCategoriaCliente());
        categoriaDTO.setDsCategoriaCliente(entity.getCategoriaClienteEntity().getDsCategoriaCliente());
        categoriaDTO.setPcDescontoCliente(entity.getCategoriaClienteEntity().getPcDescontoCliente());
        dto.setCategoriaClienteDTO(categoriaDTO);

        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();
        for (EnderecoEntity enderecoEntity: entity.getEnderecos()) {
            EnderecoDTO enderecoDTO = enderecoBO.parseDTO(enderecoEntity);
            enderecoDTOList.add(enderecoDTO);
        }
        dto.setEnderecos(enderecoDTOList);
        return dto;
    }

    public ClienteEntity parseEntity(ClienteDTO dto) {
        if (dto == null)
            return null;

            ClienteEntity entity = new ClienteEntity();
            entity.setIdCliente(dto.getIdCliente());
            entity.setNmCliente(dto.getNmCliente());
            entity.setDsEmail(dto.getDsEmail());
            entity.setDtCadastro(dto.getDtCadastro());
            entity.setNrCpf(dto.getNrCPF());
            entity.setNrRg(dto.getNrRg());
            entity.setDtNascimento(dto.getDtNascimento());
            entity.setDsGenero(dto.getDsGenero());
            entity.setNrTelefoneCliente(dto.getNrTelefoneCliente());

        List<EnderecoEntity> enderecoEntityList = new ArrayList<>();
        for (EnderecoDTO enderecoDTO: dto.getEnderecos()) {
            EnderecoEntity enderecoEntity = enderecoBO.parseEntity(enderecoDTO);
            enderecoEntityList.add(enderecoEntity);
        }
        entity.setEnderecos(enderecoEntityList);
            return entity;


        }

    }


