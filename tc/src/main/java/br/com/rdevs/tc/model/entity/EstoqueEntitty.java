package br.com.rdevs.tc.model.entity;

import br.com.rdevs.tc.model.dto.ProdutoDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_PRODUTO_FILIAL_ESTOQUE")
@Data
public class EstoqueEntitty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ESTOQUE")
    private BigInteger cdEstoque;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")
    private FilialEntity filial;

    @OneToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;

    @Column(name = "QT_ESTOQUE")
    private Integer qtEstoque;

    @Column(name = "QT_EMPENHO")
    private Integer qtEmpenho;

    @Column(name = "QT_BASE")
    private Integer qtBase;
}
