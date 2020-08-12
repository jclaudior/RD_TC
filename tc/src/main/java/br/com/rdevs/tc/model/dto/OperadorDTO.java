package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadorDTO {

    private BigInteger idOperador;
    private String nmOperador;
    private String nrCpf;
    private BigInteger nrMatricula;
    private String dsCargo;
    private BigInteger cdFilial;
    private String pwOperador;
}
