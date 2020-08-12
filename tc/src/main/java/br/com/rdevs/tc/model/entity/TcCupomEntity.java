package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "TB_TC_CUPOM")
@Data
public class TcCupomEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUPOM")
    private BigInteger idCupom;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity clienteEntity;

    @Column(name = "DT_INICIAL_CUPOM")
    private Date dtInicialCupom;

    @Column(name = "DT_FINAL_CUPOM")
    private Date dtFinalCupom;
}
