package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;


@NamedNativeQuery(name = "listarProduto", query = "SELECT\n" +
        "P.CD_PRODUTO,\n" +
        "P.ID_STATUS_PRODUTO,\n" +
        "P.ID_CATEGORIA,\n" +
        "P.ID_TIPO_PRODUTO,\n" +
        "P.NM_FABRICANTE,\n" +
        "P.NM_FANTASIA,\n" +
        "P.VL_UNIDADE,\n" +
        "LMPM.QT_PRODUTO,\n" +
        "LMPM.PC_DESCONTO,\n" +
        "LMPM.DT_INICIO_LMPM,\n" +
        "LMPM.DT_FIM_LMPM\n" +
        "FROM TB_PRODUTO as P\n" +
        "LEFT JOIN (SELECT L.ID_LMPM,\n" +
        "                  L.DT_INICIO_LMPM,\n" +
        "                  L.DT_FIM_LMPM,\n" +
        "                  LI.CD_PRODUTO,\n" +
        "                  LI.QT_PRODUTO,\n" +
        "                  LI.PC_DESCONTO\n" +
        "           FROM TB_LMPM L\n" +
        "           INNER JOIN TB_LMPM_ITEM LI ON (LI.ID_LMPM = L.ID_LMPM)\n" +
        "           WHERE SYSDATE() BETWEEN L.DT_INICIO_LMPM AND L.DT_FIM_LMPM) LMPM ON (LMPM.CD_PRODUTO = P.CD_PRODUTO)")
@NamedNativeQuery( name = "listarPorProduto", query = "SELECT\n" +
        "P.CD_PRODUTO,\n" +
        "P.ID_STATUS_PRODUTO,\n" +
        "P.ID_CATEGORIA,\n" +
        "P.ID_TIPO_PRODUTO,\n" +
        "P.NM_FABRICANTE,\n" +
        "P.NM_FANTASIA,\n" +
        "P.VL_UNIDADE,\n" +
        "LMPM.QT_PRODUTO,\n" +
        "LMPM.PC_DESCONTO,\n" +
        "LMPM.DT_INICIO_LMPM,\n" +
        "LMPM.DT_FIM_LMPM\n" +
        "FROM TB_PRODUTO as P\n" +
        "LEFT JOIN (SELECT L.ID_LMPM,\n" +
        "                  L.DT_INICIO_LMPM,\n" +
        "                  L.DT_FIM_LMPM,\n" +
        "                  LI.CD_PRODUTO,\n" +
        "                  LI.QT_PRODUTO,\n" +
        "                  LI.PC_DESCONTO\n" +
        "           FROM TB_LMPM L\n" +
        "           INNER JOIN TB_LMPM_ITEM LI ON (LI.ID_LMPM = L.ID_LMPM)\n" +
        "           WHERE SYSDATE() BETWEEN L.DT_INICIO_LMPM AND L.DT_FIM_LMPM) LMPM ON (LMPM.CD_PRODUTO = P.CD_PRODUTO)\n" +
        "WHERE P.CD_PRODUTO = ?\n" )
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
