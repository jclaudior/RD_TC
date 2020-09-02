package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private BigInteger idCliente;
    private String nmCliente;
    private String dsEmail;
    private Date dtCadastro;
    private String nrCPF;
    private String nrRg;
    private Date dtNascimento;
    private String dsGenero;
    private String nrTelefoneCliente;
    private CategoriaClienteDTO categoriaClienteDTO;

    private List<EnderecoDTO> enderecos;

}
