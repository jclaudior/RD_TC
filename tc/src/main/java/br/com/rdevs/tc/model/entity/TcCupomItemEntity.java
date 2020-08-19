package br.com.rdevs.tc.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_TC_CUPOM_ITEM")
@Data
public class TcCupomItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUPOM_ITEM")
    private BigInteger idCupomItem;

    @ManyToOne
    @JoinColumn(name = "ID_CUPOM")
    @JsonIgnore
    private TcCupomEntity tcCupom;

    @Column(name = "PC_DESCONTO")
    private float pcDesconto;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produtoEntity;
}
