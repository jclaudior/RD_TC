package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialDTO {

    private BigInteger cdFilial;
    private String nmFilial;
    private String nrCnpj;
    private String nrTelefoneFilial;
}
