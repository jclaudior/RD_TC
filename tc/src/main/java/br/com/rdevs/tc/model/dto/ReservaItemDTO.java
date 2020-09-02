package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaItemDTO {

    private ReservaDTO reserva;
    private ProdutoDTO produto;
    private Integer qtProduto;

}
