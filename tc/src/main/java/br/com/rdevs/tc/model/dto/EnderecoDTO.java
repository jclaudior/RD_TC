package br.com.rdevs.tc.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private BigInteger idEndereco;
    private String dsEndereco;
    private String nrEndereco;
    private String nrCep;
    private String cidade;
    private String sgEstado;
}
