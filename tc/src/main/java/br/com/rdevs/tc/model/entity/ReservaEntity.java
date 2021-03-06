package br.com.rdevs.tc.model.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_TC_RESERVA")
@Data
public class    ReservaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TC_RESERVA")
    private BigInteger idTcReserva;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity cliente;

    @Column(name = "DT_INICIAL_RESERVA")
    private Date dtInicialReserva;

    @Column(name = "DT_FINAL_RESERVA")
    private Date dtFinalReserva;

    @Column(name = "DT_BAIXA")
    private Date dtBaixa;

    @Column(name = "NR_PEDIDO")
    private BigInteger nrPedido;

    @Column(name = "CD_FILIAL")
    private BigInteger cdFilial;


    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<ReservaItemEntity> itens;

}
