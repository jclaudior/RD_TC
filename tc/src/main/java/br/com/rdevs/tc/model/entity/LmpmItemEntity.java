package br.com.rdevs.tc.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_LMPM_ITEM")
@Data
public class LmpmItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LMPM_ITEM")
    private int idLmpmItem;

    @ManyToOne
    @JoinColumn(name = "ID_LMPM")
    private LmpmEntitty lmpmEntitty;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produtoEntity;

    @Column(name = "QT_PRODUTO")
    private int qtProduto;

    @Column(name = "PC_DESCONTO")
    private float pcDesconto;
}
