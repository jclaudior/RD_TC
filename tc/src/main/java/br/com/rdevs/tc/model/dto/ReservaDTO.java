package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {


    private Integer idTcReserva;
    private BigInteger idCliente;
    private Date dtInicialReserva;
    private Date dtFinalReserva;

}



