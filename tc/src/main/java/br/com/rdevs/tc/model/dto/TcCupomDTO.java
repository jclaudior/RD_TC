package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TcCupomDTO {

    private BigInteger idCupom;
    private Date dtInicialCupom;
    private Date dtFinalCupom;
}
