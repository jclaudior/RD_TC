package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_MELHOR_PRECO")
@Data
public class MelhorPrecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MP")
    private BigInteger idMelhorPreco;

    @Column(name = "QT_ITEM")
    private int qtItem;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produtoEntity;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity clienteEntity;

    @ManyToOne
    @JoinColumn(name = "ID_OPERADOR")
    private OperadorEntity operadorEntity;

    @Column(name = "PC_DESCONTO")
    private float pcDesconto;
}
