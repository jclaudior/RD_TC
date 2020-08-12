package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private BigInteger idCliente;
    private String nmCliente;
    private String dsEmail;
    private Date dtCadastro;
    private String nrRg;
    private Date dtNascimento;
    private String dsGenero;
    private String nrTelefoneCliente;
    private CategoriaClienteDTO categoriaClienteDTO;
}
