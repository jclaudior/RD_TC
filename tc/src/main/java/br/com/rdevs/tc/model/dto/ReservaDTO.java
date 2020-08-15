package br.com.rdevs.tc.model.dto;

import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {


    private ClienteDTO clienteDTO;
    private Date dtInicialReserva;
    private Date dtFinalReserva;
    private List<ReservaItemDTO> itens;



}



