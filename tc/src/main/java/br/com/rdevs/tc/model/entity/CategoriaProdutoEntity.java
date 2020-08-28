package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name="TB_CATEGORIA_PRODUTO")
public class CategoriaProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CATEGORIA")
    private BigInteger idCategoria;

    @Column(name="DS_CATEGORIA")
    private String dsCategoria;

//    @OneToOne
//    @JoinColumn(name ="ID_SUB_CATEGORIA")
//    private SubCategoriaProdutoEntity subCategoria;

}
