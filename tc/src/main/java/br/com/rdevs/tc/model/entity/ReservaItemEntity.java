package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_TC_RESERVA_ITEM")
@Data
public class ReservaItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TC_RESERVA_ITEM")
    private BigInteger idTcReservaItem;

    @ManyToOne
    @JoinColumn(name = "ID_RESERVA")
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private BigInteger cdProduto;

    @Column(name = "QT_PRODUTO")
    private Integer qtProduto;


}
