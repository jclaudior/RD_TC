package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;



@Entity
@Table(name = "TB_PRODUTO")
@Data
public class ProdutoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PRODUTO")
    private BigInteger cdProduto;

    @Column(name = "ID_STATUS_PRODUTO")
    private BigInteger idStatusProduto;

    @Column(name = "ID_CATEGORIA")
    private BigInteger idCategoria;

    @Column(name = "ID_TIPO_PRODUTO")
    private BigInteger idTipoProduto;

    @Column(name = "NM_FANTASIA")
    private String nmFantasia;

    @Column(name = "NM_FABRICANTE")
    private String nmFabricante;

    @Column(name = "VL_UNIDADE")
    private double vlUnidade;

    @OneToMany
    @JoinColumn(name = "CD_PRODUTO")
    private List<LmpmItemEntity> lmpmLista;

}
