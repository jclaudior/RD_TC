package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.CategoriaClienteDTO;
import br.com.rdevs.tc.model.dto.ClienteDTO;
import br.com.rdevs.tc.model.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteBO {

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
        if(dadosCliente.length()== 11)
            return true;
        else
            return false;

    }
    public boolean isRg(String dadosCliente) {
        if (dadosCliente == null)
            return false;
        if(dadosCliente.length()== 9)
            return true;
        else
            return false;

    }
    public ClienteDTO parseDTO(ClienteEntity entity) {
        if(entity == null){
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
        return dto;
    }


}

